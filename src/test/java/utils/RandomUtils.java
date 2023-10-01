package utils;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static int getRandomInt (int min,int max){
        return ThreadLocalRandom.current().nextInt(min,max+1);
    }

    public static String getRandomItemFromArray(String[] array){
        int index = getRandomInt(0, array.length - 1);
        return array[index];
    }

    public static String getItemFromDate(String pattern, Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern, Locale.ENGLISH);
        return formatter.format(date);
    }

}
