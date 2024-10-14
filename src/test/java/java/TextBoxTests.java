
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
    }
    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("alex@ivanov.com");

        $("#genterWrapper").$(byText("Male")).click();

        $("#userNumber").setValue("9998887878");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("June")).click();
        $(".react-datepicker__year-select").$(byText("1991")).click();
        $(".react-datepicker__month").$(byText("15")).click();

        $("#subjectsInput").setValue("Physics").pressEnter();

        $("#hobbiesWrapper").shouldHave(text("Sports")).click();

        $("#uploadPicture").uploadFromClasspath("5.jpg");

        $("#currentAddress").setValue("Some Street 1");

        $("#stateCity-wrapper").$(byText("Select State")).click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();

        $("#stateCity-wrapper").$(byText("Select City")).click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();

        $("#submit").click();

        $(".table-responsive").shouldHave(text("Student Name Alex Ivanov"));
        $(".table-responsive").shouldHave(text("Student Email alex@ivanov.com"));
        $(".table-responsive").shouldHave(text("Gender Male"));
        $(".table-responsive").shouldHave(text("Mobile 9998887878"));
        $(".table-responsive").shouldHave(text("Date of Birth 15 June,1991"));
        $(".table-responsive").shouldHave(text("Subjects Physics"));
        $(".table-responsive").shouldHave(text("Hobbies Sports"));
        $(".table-responsive").shouldHave(text("Picture 5.jpg"));
        $(".table-responsive").shouldHave(text("Address Some Street 1"));
        $(".table-responsive").shouldHave(text("State and City Haryana Karnal"));
    }
}