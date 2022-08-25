package com.downloadwink.contacts.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressHome {
    public static AddressHome instance;

    public static AddressHome getInstance() {
        if (instance == null) {
            return new AddressHome();
        } else {
            return instance;
        }
    }

    private Connection connect;

    private Connection getConnection() throws SQLException {
        if (connect == null) {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mycontacts", "root", "password");
        }
        return connect;
    }

    //All addresses
    public List<Address> allAddresses() throws SQLException {
        Connection connect = getConnection();
        Statement statement = connect.createStatement();
        // Result set get the result of the SQL query
        ResultSet resultSet = statement
                .executeQuery("select * from mycontacts.address");
        List<Address> allAddresses = new ArrayList<>();
        while (resultSet.next()) {
            Address address = new Address();
            extractAddressFromResultSet(resultSet, address);

            allAddresses.add(address);

        }
        statement.close();
        return allAddresses;
    }


    //Add new address
    public Address addAddress(String streetNumber, String streetName, String city, String province, String postalCode) throws SQLException {
        Connection connect = getConnection();

        PreparedStatement preparedStatement = connect.prepareStatement("INSERT INTO  mycontacts.address (id,streetNumber,streetName,city,province,postalCode) VALUES (Default,?,?,?,?,?)");
        preparedStatement.setString(1, streetNumber);
        preparedStatement.setString(2, streetName);
        preparedStatement.setString(3, city);
        preparedStatement.setString(4, province);
        preparedStatement.setString(5, postalCode);
        preparedStatement.executeUpdate();


        ResultSet resultSet = connect.createStatement()
                .executeQuery("SELECT * FROM address where streetNumber = '" + streetNumber + "'");
        Address addAddress = new Address();
        while (resultSet.next()) {
            int sId = resultSet.getInt(1);
            String sNumber = resultSet.getString(2);
            String sName = resultSet.getString(3);
            String sCity = resultSet.getString(4);
            String sProvince = resultSet.getString(5);
            String sPostalCode = resultSet.getString(6);

            addAddress.setId(sId);
            addAddress.setStreetNumber(sNumber);
            addAddress.setStreetName(sName);
            addAddress.setCity(sCity);
            addAddress.setProvince(sProvince);
            addAddress.setPostalCode(sPostalCode);

        }
        return addAddress;
    }

    private void extractAddressFromResultSet(ResultSet resultSet, Address addAddress) {

    }

    //Find address by id
    public Address findById(int id) throws SQLException {
        Connection connect = getConnection();
        ResultSet resultSet = connect.createStatement().executeQuery("Select * from address where id = '" + id + "'");
        Address address = new Address();
        while (resultSet.next()) {
            int addId = resultSet.getInt(1);
            String sNumber = resultSet.getString(2);
            String sName = resultSet.getString(3);
            String sCity = resultSet.getString(4);
            String sProvince = resultSet.getString(5);
            String sPostalCode = resultSet.getString(6);

            address.setId(addId);
            address.setStreetNumber(sNumber);
            address.setStreetName(sName);
            address.setCity(sCity);
            address.setProvince(sProvince);
            address.setPostalCode(sPostalCode);

        }

        return address;
    }

    //Update address
    public Address saveAddress(Address address) throws SQLException {
        Connection connect = AddressHome.getInstance().getConnection();
        PreparedStatement preparedStatement = connect.prepareStatement("update mycontacts.address set streetNumber = ?, streetName= ?, city= ?, province = ? , postalCode= ? where id = ?");
        preparedStatement.setString(1, address.getStreetNumber());
        preparedStatement.setString(2, address.getStreetName());
        preparedStatement.setString(3, address.getCity());
        preparedStatement.setString(4, address.getProvince());
        preparedStatement.setString(5, address.getPostalCode());
        preparedStatement.setInt(6, address.getId());
        preparedStatement.executeUpdate();
        return address;
    }


    public Address updateAddress(Address address, String streetNumber, String streetName, String city, String province, String postalCode) throws SQLException {
        Connection connect = AddressHome.getInstance().getConnection();
        address.setStreetNumber(streetNumber);
        address.setStreetName(streetName);
        address.setCity(city);
        address.setProvince(province);
        address.setPostalCode(postalCode);

        return saveAddress(address);
    }

    //Delete address
    public void deleteAddress(int id) throws SQLException {
        Connection connect = getConnection();
        PreparedStatement preparedStatement = connect.prepareStatement("delete from mycontacts.address where id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

}
