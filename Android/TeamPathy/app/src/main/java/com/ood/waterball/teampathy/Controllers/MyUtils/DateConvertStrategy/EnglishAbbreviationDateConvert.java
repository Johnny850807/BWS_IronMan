package com.ood.waterball.teampathy.Controllers.MyUtils.DateConvertStrategy;


import java.util.Calendar;
import java.util.Date;

public class EnglishAbbreviationDateConvert implements DateConvertStrategy {
    public final static String[] DATE_NAME_ENG_ABR = {"Jan.","Feb.","Mar.","Apr.","May.","June.",
            "July.","Aug.","Sept.","Oct.","Nov.","Dec."};

    @Override
    public String dateToTime(Date datetime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datetime);
        String date = String.valueOf(calendar.get(Calendar.DATE));
        String month = DATE_NAME_ENG_ABR[(calendar.get(Calendar.MONTH))];
        String year = String.valueOf(calendar.get(Calendar.YEAR));
        return year + " " + date + " " + month;
    }

}
