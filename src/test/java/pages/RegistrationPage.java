package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement genderWrapper = $("#genterWrapper");
    private final SelenideElement userNumberInput= $("#userNumber");
    private final SelenideElement calendarInput =  $("#dateOfBirthInput");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement hobbiesWrapper = $("#hobbiesWrapper");

    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement selectStateWrapper = $("#stateCity-wrapper");
    private final SelenideElement stateWrapper = $("#stateCity-wrapper");
    private final SelenideElement selectCityWrapper = $("#stateCity-wrapper");
    private final SelenideElement CityWrapper = $("#stateCity-wrapper");
    private final SelenideElement submitClick = $("#submit");


 CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value){
        userEmailInput.setValue(value);

        return this;
    }
    public RegistrationPage setGender(String value){
        genderWrapper.$(byText(value)).click();

        return this;
    }
    public RegistrationPage setUserNumber(String value){
        userNumberInput.setValue(value);

        return this;

    }

    public RegistrationPage setDateOfBirth(String day, String month, String year){
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;

    }
    public RegistrationPage setSubjects(String value){
        subjectsInput.setValue(value);
        subjectsInput.pressEnter();


        return this;
    }
    public RegistrationPage setHobbies(String value){
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }




    public RegistrationPage setCurrentAddress(String value){
        currentAddressInput.setValue(value);

        return this;
    }
    public RegistrationPage setSelectState(String value){
        selectStateWrapper.$(byText(value)).click();

        return this;
    }
    public RegistrationPage setState(String value){
        stateWrapper.$(byText(value)).click();

        return this;
    }
    public RegistrationPage setSelectCity(String value){
        selectCityWrapper.$(byText(value)).click();

        return this;
    }
    public RegistrationPage setCity(String value){
        CityWrapper.$(byText(value)).click();

        return this;
    }
    public RegistrationPage setSubmitClick(String value){
        submitClick.click();

        return this;
    }



    public RegistrationPage checkResult(String key, String value){
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }


}
