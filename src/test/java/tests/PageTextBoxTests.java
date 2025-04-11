package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PageTextBoxTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("Ivanov")
                .setEmail("alex@ivanov.com")
                .setGender("Male")
                .setUserNumber("9998887878")
                .setDateOfBirth("15", "June", "1991")
                .setSubjects("Physics")
                .setHobbies("Sports")

                .setCurrentAddress("Some Street 1")
                .setSelectState("Select State")
                .setState("Haryana")

                .setSelectCity("Select City")
                .setCity("Karnal")
                .setSubmitClick("Submit");

        $("#uploadPicture").uploadFromClasspath("5.jpg");


        
        registrationPage.checkResult("Student Name", "Alex Ivanov")
         .checkResult("Student Email", "alex@ivanov.com")
         .checkResult("Gender", "Male")
         .checkResult("Mobile", "9998887878")
         .checkResult("Date of Birth", "15 June,1991")
         .checkResult("Subjects", "Physics")
         .checkResult("Hobbies", "Sports")
         .checkResult("Picture", "5.jpg")
         .checkResult("Address", "Some Street 1")
         .checkResult("State and City", "Haryana Karnal");
    }

}