package org.example.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {

    public static String dateFormat(){
        Date date= new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM_dd_YYYY_hh_mm_ss");
        return sdf.format(date);
    }

}
