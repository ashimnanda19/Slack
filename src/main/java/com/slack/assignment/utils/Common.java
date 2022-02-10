package com.slack.assignment.utils;
import org.apache.commons.lang3.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/****
 * This class contains common methods declared as static.
 */
public class Common {

    public static String getRandomString(int size) {
        String randomString = RandomStringUtils.randomAlphabetic(size);
        return randomString;
    }

    public static String getTimeStamp(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = dateFormat.format(new Date());
        return timestamp;
    }


}
