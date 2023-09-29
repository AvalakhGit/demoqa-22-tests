package utils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static void main(String[] args){
        System.out.println(getRandomString(10));
        System.out.println(getRandomPhone());
        System.out.println(getRandomAddress());
        System.out.println(getRandomGender());
    }

    public static String getRandomString (int len){
        String AB="QAZWSXEDCRFVTGBYHNUJMIKOLPqazwsxedcrfvtgbyhnujmikolp";
        SecureRandom rnd= new SecureRandom();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<len;i++){
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }

    public static String getRandomMail (int len){

        return getRandomString(10)+"@mailing.ru";
    }

    public static String getRandomAddress (){

        return getRandomString(10)+" " + getRandomString(3) +" " +getRandomString(7);
    }

    public static int getRandomInt (int min,int max){

        return ThreadLocalRandom.current().nextInt(min,max+1);
    }
    public static String getRandomPhone (){

        return String.format("+%s (%s) %s - %s - %s",
                getRandomInt(1,9),
                getRandomInt(111,999),
                getRandomInt(111,999),
                getRandomInt(11,99),
                getRandomInt(11,99));
    }
    public static String getRandomGender(){
        String[] genders ={"Male","Female","Other"};
        return getRandomItemFromArray(genders);
    }
    public static String getRandomItemFromArray(String[] array){
        int index = getRandomInt(0, array.length - 1);
        return array[index];
    }
}