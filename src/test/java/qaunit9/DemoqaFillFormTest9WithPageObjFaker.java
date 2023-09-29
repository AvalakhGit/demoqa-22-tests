package qaunit9;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Locale;


public class DemoqaFillFormTest9WithPageObjFaker extends TestBase9 {
    @Test
    void fillFields() {
//        Faker faker = new Faker(new Locale("ru"));
//        Faker fekerMail = new Faker();
//
//        String userFirstName = faker.name().fullName(); // Miss Samanta Schmidt
//        String userLastName = faker.name().firstName(); // Emory
//        String userEmail = fekerMail.internet().emailAddress();
//        String userAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449
//        String userMobile= faker.phoneNumber().subscriberNumber(10);
//        String userGender=faker.demographic().sex();
//        String userDayBirth= String.valueOf(faker.number().numberBetween(1,27));
//        Date userDateOfBirth = faker.date().birthday();

        String
                userFirstName = "UserFirstName",
                userLastName = "UserLastName",
                userEmail = "user_mail@mail.com",
                userGender = "Female",
                userAddress = "User Address. City One.",
                userMobile = "9991234560",
                userMobileBad = "99912560",
                userState = "NCR",
                userCity = "Delhi";
        String[]
//                userDateBirth = {String.valueOf(userDateOfBirth.getDate()),"November","1979"},
                userDateBirth = {"11","November","1979"},
                userSubjects={"Maths","Physics"},
                userHobbies= {"Sports","Reading"};

        registrationPage
                .openPage()
                .setFirstName(userFirstName)
                .setLastName(userLastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(userMobile)
                .setDateOfBirth(userDateBirth[0],userDateBirth[1],userDateBirth[2])
                .setSubject(userSubjects[0],userSubjects[1])
                .setHobbies(userHobbies[0],userHobbies[1])
                .uploadPicture("img/AtomicHeart_sample.jpg")
                .setAddress(userAddress)
                .setState(userState)
                .setCity(userCity)
                .submitButtonClick();

        registrationPage
                .checkResultModalVisible()
                .checkResultModalTitleHaveMessage("Thanks for submitting the form")
                .checkResult ("Student Name",userFirstName+" "+userLastName)
                .checkResult ("Student Email",userEmail)
                .checkResult ("Gender",userGender)
                .checkResult ("Mobile",userMobile)
                .checkResult ("Date of Birth",userDateBirth[0]+" "+userDateBirth[1]+","+userDateBirth[2])
                .checkResult ("Subjects",userSubjects[0]+", "+userSubjects[1])
                .checkResult ("Hobbies",userHobbies[0]+", "+userHobbies[1])
                .checkResult ("Picture","AtomicHeart_sample.jpg")
                .checkResult ("Address",userAddress)
                .checkResult ("State and City",userState+" "+userCity)
                .closeResultModal();

    }


}
