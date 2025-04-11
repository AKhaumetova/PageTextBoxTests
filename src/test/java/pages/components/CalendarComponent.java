package pages.components;

import pages.RegistrationPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String month, String year){
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("June")).click();
        $(".react-datepicker__year-select").$(byText("1991")).click();
        $(".react-datepicker__month").$(byText("15")).click();


}
}
