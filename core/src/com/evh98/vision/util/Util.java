package com.evh98.vision.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Util {

    public static float WIDTH = 2560;
    public static float HEIGHT = 1440;

    public static String date;
    public static String time;

    public static void updateTimeAndDate() {
        Calendar cal = Calendar.getInstance();

        SimpleDateFormat sdf = new SimpleDateFormat("hh:mma");
        time = sdf.format(cal.getTime()).toLowerCase();
        if (time.toCharArray()[0] == '0') {
            time = time.substring(1, time.length());
        }

        sdf = new SimpleDateFormat("dd/MM");
        date = sdf.format(cal.getTime());
    }
}
