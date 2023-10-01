package qaunit9;

import com.github.javafaker.Faker;
import utils.RandomUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class TestData {

   Faker iFaker = new Faker(new Locale("in-ID"));
  public String[] genders ={"Male","Female","Other"},
            states = {"NCR",
                    "Uttar Pradesh",
                    "Haryana",
                    "Rajasthan"},
            subjects={"Hindi", "English", "Maths", "Physics",
                    "Chemistry", "Computer Science", "Commerce", "Accounting",
                    "Economics", "Arts", "Social Studies", "History",
                    "Civics"},
            hobbies= {"Sports","Reading","Music"};
  Date userBirthday=iFaker.date().birthday();
  String[][] stateCities={
           {"Delhi", "Gurgaon", "Noida"},
           {"Agra", "Lucknow", "Merrut"},
           {"Karnal", "Panipat"},
           {"Jaipur", "Jaiselmer"}};
  Map<String,String> chosenCity = new HashMap<>(){{
      put(states[0], RandomUtils.getRandomItemFromArray(stateCities[0]));
      put(states[1], RandomUtils.getRandomItemFromArray(stateCities[1]));
      put(states[2], RandomUtils.getRandomItemFromArray(stateCities[2]));
      put(states[3], RandomUtils.getRandomItemFromArray(stateCities[3]));
  }};

  public final String userFirstName = iFaker.name().firstName();
  public final String userLastName = iFaker.name().lastName();
  public final String userEmail = iFaker.internet().emailAddress(userFirstName+"."+userLastName);
  public final String userGender =RandomUtils.getRandomItemFromArray(genders);
  public final String userAddress = iFaker.address().streetAddress();
  public final String userMobile = iFaker.phoneNumber().subscriberNumber(10);
  public final String userMobileBad = iFaker.phoneNumber().subscriberNumber(9);
  public final String userState = RandomUtils.getRandomItemFromArray(states);
  public final String userCity = chosenCity.get(userState);
  public final String userSubject=RandomUtils.getRandomItemFromArray(subjects);
  public final String userHobbie=RandomUtils.getRandomItemFromArray(hobbies);
  public final String picturePath="AtomicHeart"+ RandomUtils.getRandomInt(1,5)+".jpg";

  public final String[] userDateBirth={
          RandomUtils.getItemFromDate("dd",userBirthday),
          RandomUtils.getItemFromDate("MMMM",userBirthday),
          RandomUtils.getItemFromDate("y",userBirthday)};

}
