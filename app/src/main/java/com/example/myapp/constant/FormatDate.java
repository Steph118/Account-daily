package com.example.myapp.constant;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class FormatDate {
    private static final String format1 = "dd/MM/yyyy";
    private static final String format2 = "dd-MM-yyyy";
    private static final String format3 = "hh:mm a";

    public static String datepicker(Locale locale, Calendar calendar) {
        SimpleDateFormat format = new SimpleDateFormat(format1, locale);
        return format.format(calendar.getTime());
    }

    public static String timePicker(Calendar calendar) {
        SimpleDateFormat format = new SimpleDateFormat(format3, Locale.getDefault());
        return format.format(calendar.getTime());
    }
}
