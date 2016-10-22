package com.renegades.labs.hobbit;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Виталик on 03.10.2016.
 */

public class CommonMethods {
    private static DateFormat dateFormat = new SimpleDateFormat("d MMM yyyy", Locale.US);
    private static DateFormat timeFormat = new SimpleDateFormat("K:mma", Locale.US);

    public static String getCurrentTime() {

        Date today = Calendar.getInstance().getTime();
        return timeFormat.format(today);
    }

    public static String getCurrentDate() {

        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }

}
