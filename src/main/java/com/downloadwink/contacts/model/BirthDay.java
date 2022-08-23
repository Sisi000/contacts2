package com.downloadwink.contacts.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BirthDay {
    private static BirthDay instance;
    public static BirthDay getInstance() {
        return BirthDay.instance;
    }

    public static void main(String[] args) throws Exception {

        Date date1 = new SimpleDateFormat("dd/MM/yyyy").get2DigitYearStart();
        System.out.println(date1);
    }


}
