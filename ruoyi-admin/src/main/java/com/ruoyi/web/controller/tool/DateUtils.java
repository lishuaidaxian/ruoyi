package com.ruoyi.web.controller.tool;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    //获取某月天数
    public static int getDaysOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    //根据月天数获取标识
    public static String getDateSign(Date date){
        String sign = "";
        int daysOfMonth = getDaysOfMonth(date);
        if(daysOfMonth==28){
            sign = "1";
        }else if(daysOfMonth==29){
            sign = "2";
        }else if(daysOfMonth==30){
            sign = "3";
        }else if(daysOfMonth==31){
            sign = "4";
        }
        return sign;
    }

}
