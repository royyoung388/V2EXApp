package com.roy.v2exapp.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Administrator on 2017/7/20.
 */

public class TimeUtil {

    /**
     * 时间戳转日期
     *
     * @param timestampString 时间戳
     * @return 日期
     */
    public static String TimeStamp2Date(Long timestampString) {
        //formats = "yyyy-MM-dd HH:mm:ss";
        String formats = "yyyy-MM-dd";
        timestampString *= 1000;
        String date = new SimpleDateFormat(formats, Locale.CHINA).format(new Date(timestampString));
        return date;
    }

    /**
     * 日期转时间戳
     *
     * @param dateStr 日期
     * @return 时间戳
     */
    public static Long Date2TimeStamp(String dateStr) {
        try {
//            String format = "yyyy-MM-dd HH:mm:ss";
            String format = "yyyy-MM-dd";
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.parse(dateStr).getTime() / 1000;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取时间
     *
     * @return 时间
     */
    public static String getNowDate() {
        String formats = "yyyy-MM-dd";
        String date = new SimpleDateFormat(formats, Locale.CHINA).format(new Date());
        return date;
    }

    /**
     * 日期转毫秒
     * @param date 日期
     * @return 毫秒
     */
    public static Long Date2Mills(String date) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date d = format.parse(date);
            return d.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getTimeDifference(Long timeStamp) {
        long now = System.currentTimeMillis() / 1000;
        // Calculate difference in milliseconds
        long diff = now - timeStamp;

        diff *= 1000;

        // Difference in seconds
        long diffSec = diff / 1000;
        // Difference in minutes
        long diffMin = diff / (60 * 1000);
        // Difference in hours
        long diffHours = diff / (60 * 60 * 1000);
        // Difference in days
        long diffDays = diff / (24 * 60 * 60 * 1000);
//        // Difference in months
//        long diffMonths = diff / (24 * 60 * 60 * 1000 * 30);
//        // Difference in years
//        long diffYears = diff / (24 * 60 * 60 * 1000 * 30 * 12);

        if (diffDays != 0) {
            return diffDays + "天前";
        }
        if (diffHours != 0) {
            return diffHours + "小时前";

        }
        if (diffMin != 0) {
            return diffMin + "分钟前";
        }
        if (diffSec != 0) {
            return diffSec + "秒前";
        }
        return "0秒前";
    }
}
