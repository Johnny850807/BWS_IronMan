package com.ood.waterball.teampathy.Controllers.MyUtils.DateConvertStrategy;


import java.util.Calendar;
import java.util.Date;

public class StandardDateConvert implements DateConvertStrategy {

    @Override
    public String dateToTime(Date datetime,boolean showTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datetime);
        String date = String.valueOf(calendar.get(Calendar.DATE));
        String month = String.valueOf(calendar.get(Calendar.MONTH));
        String year = String.valueOf(calendar.get(Calendar.YEAR));
        String hour = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
        if (hour.length() == 1)
            hour = "0" + hour ;
        String minute = String.valueOf(calendar.get(Calendar.MINUTE));
        if (minute.length() == 1)
            minute = "0" + minute ;

        StringBuilder str = new StringBuilder();
        str.append(String.format("%s-%s-%s",year,month,date));
        if (showTime)
            str.append(String.format("T%s:%s",hour,minute));

        return str.toString();
    }

}
