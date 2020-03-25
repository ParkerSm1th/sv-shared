package io.parkersmith.sunverse.shared.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Chase on 1/7/2018.
 */
public class StringUtil {

    public static String repeat(String string, int count) {
        if (count <= 1) {
            return count == 0 ? "" : string;
        } else {
            int len = string.length();
            long longSize = (long) len * (long) count;
            int size = (int) longSize;
            if ((long) size != longSize) {
                throw new ArrayIndexOutOfBoundsException("Required array size too large: " + longSize);
            } else {
                char[] array = new char[size];
                string.getChars(0, len, array, 0);
                int n;
                for (n = len; n < size - n; n <<= 1) {
                    System.arraycopy(array, 0, array, n, n);
                }
                System.arraycopy(array, 0, array, n, size - n);
                return new String(array);
            }
        }
    }

    /**
     * Get the nice version of a string (Correct English Title capitalisation).
     */
    public static String niceString(String old){
        if(old.contains(" ")){
            String[] words = old.split(" ");

            StringBuilder sb = new StringBuilder();
            for(String s : words) {
                sb.append(s.substring(0, 1).toUpperCase());
                sb.append(s.substring(1).toLowerCase());
                sb.append(" ");
            }

            String output = sb.toString();

            return output.substring(0, output.length() - 1); // Remove the extra space. ^
        }else{
            return old.substring(0, 1).toUpperCase() + old.substring(1).toLowerCase();
        }
    }

    /**
     * Formats time to display it as a string from seconds
     */
    public static String toFriendlyTimeFormat(int seconds) {

        int h = seconds/ 3600, m = (seconds % 3600) / 60, s = seconds % 60;

        String sh = (h > 0 ? String.valueOf(h) + "h" : "");
        String sm = (m < 10 && m > 0 && h > 0 ? "0" : "") + (m > 0 ? (h > 0 && s == 0 ? String.valueOf(m) : String.valueOf(m) + "m") : "");
        String ss = (s == 0 && (h > 0 || m > 0) ? "" : (s < 10 && (h > 0 || m > 0) ? "0" : "") + String.valueOf(s) + "s");

        return sh + (h > 0 ? " " : "") + sm + (m > 0 ? " " : "") + ss;
    }

    /**
     * Gets a friendly time by comparing a past {@link Date} to a current {@link Date}
     * @param dateTime Past {@link Date}
     * @return Friendly data as a string
     */
    public static String compareDateToNow(Date dateTime) {

        StringBuffer sb = new StringBuffer();
        Date current = Calendar.getInstance().getTime();
        long diffInSeconds = (current.getTime() - dateTime.getTime()) / 1000, sec = (diffInSeconds >= 60 ? diffInSeconds % 60 : diffInSeconds),
                min = (diffInSeconds = (diffInSeconds / 60)) >= 60 ? diffInSeconds % 60 : diffInSeconds, hrs = (diffInSeconds = (diffInSeconds / 60)) >= 24 ? diffInSeconds % 24 : diffInSeconds,
                days = (diffInSeconds = (diffInSeconds / 24)) >= 30 ? diffInSeconds % 30 : diffInSeconds, months = (diffInSeconds = (diffInSeconds / 30)) >= 12 ? diffInSeconds % 12 : diffInSeconds,
                years = (diffInSeconds = (diffInSeconds / 12));

        if (years > 0) {
            if (years == 1)
                sb.append("a year");
            else
                sb.append(years + " years");

            if (years <= 6 && months > 0) {
                if (months == 1)
                    sb.append(" and a month");
                else
                    sb.append(" and " + months + " months");
            }
        }

        else if (months > 0) {
            if (months == 1)
                sb.append("a month");
            else
                sb.append(months + " months");

            if (months <= 6 && days > 0) {
                if (days == 1)
                    sb.append(" and a day");
                else
                    sb.append(" and " + days + " days");
            }
        }

        else if (days > 0) {
            if (days == 1)
                sb.append("a day");
            else
                sb.append(days + " days");

            if (days <= 3 && hrs > 0) {
                if (hrs == 1)
                    sb.append(" and an hour");
                else
                    sb.append(" and " + hrs + " hours");
            }
        }

        else if (hrs > 0) {
            if (hrs == 1)
                sb.append("an hour");
            else
                sb.append(hrs + " hours");

            if (min > 1)
                sb.append(" and " + min + " minutes");
        }

        else if (min > 0) {
            if (min == 1)
                sb.append("a minute");
            else
                sb.append(min + " minutes");

            if (sec > 1)
                sb.append(" and " + sec + " seconds");
        }

        else {
            if (sec <= 1)
                sb.append("about a second");
            else
                sb.append("about " + sec + " seconds");
        }

        sb.append(" ago");

        return sb.toString();
    }

}
