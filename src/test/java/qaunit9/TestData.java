package qaunit9;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

import static utils.RandomUtils.getRandomItemFromArray;

public class TestData {

   public static Faker indiaFaker = new Faker(new Locale("in-ID"));

   public static String getUserFirstName(){
      return indiaFaker.name().firstName();
   }
   public static String getUserLastName(){
      return indiaFaker.name().lastName();
   }

   public static String getUserEmail(String localPath){
      return indiaFaker.internet().emailAddress(localPath);
   }
   public static String getRandomGender(){
      String[] genders ={"Male","Female","Other"};
      return getRandomItemFromArray(genders);
   }

   public static String getUserMobile(int length){
      return indiaFaker.phoneNumber().subscriberNumber(length);
   }

   public static String
            userFirstName = "UserFirstName",
            userLastName = "UserLastName",
            userEmail = "user_mail@mail.com",
            userGender = "Female",
            userAddress = "User Address. City One.",
            userMobile = "9991234560",
            userMobileBad = "99912560",
            userState = "NCR",
            userCity = "Delhi";
   public static String[]
            userDateBirth = {"11","November","1979"},
            userSubjects={"Maths","Physics"},
            userHobbies= {"Sports","Reading"};
}
