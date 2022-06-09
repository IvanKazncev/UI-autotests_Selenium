package tests;
import com.codeborne.selenide.Selenide;
import data.TestData;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import po.*;
import steps.StepToDeleteUser;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.*;

public class AuthorizationTests {

    TestData testData = new TestData();
    String name = testData.getUserName();
    String email = testData.getUserEmail();
    String password = testData.getUserPassword();
    LoginPage loginPage;
    MainPage mainPage;
    RegistrationPage registrationPage;
    ForgotPasswordPage forgotPasswordPage;
    StepToDeleteUser stepToDeleteUser = new StepToDeleteUser();

    @Before
    public void initializationTestData() {
        System.setProperty("selenide.browser", "edge");
        open(testData.getRegistrationPageURL());
        loginPage = Selenide.page(LoginPage.class);
        mainPage = Selenide.page(MainPage.class);
        registrationPage = Selenide.page(RegistrationPage.class);
        forgotPasswordPage = Selenide.page(ForgotPasswordPage.class);
        registrationPage.registration(name, email, password);
    }

    @After
    public void afterClass() {
        stepToDeleteUser.deleteUser(email, password);
        Selenide.closeWebDriver();
    }

    @Test
    @DisplayName("Authorization using SignIn button")
    public void authorizationFromEnterToAccountButtonTest() {
        open(testData.getMainPageURL());
        mainPage.doEnterToAccountButtonWait();
        mainPage.enterToAccountButtonClick();
        loginPage.login(email, password);
        assertTrue(mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Authorization using 'Private account' button")
    public void authorizationFromPrivateAccountTest() {
        open(testData.getMainPageURL());
        mainPage.privateAccountElementClick();
        loginPage.login(email, password);
        mainPage.doOrderButtonWait();
        assertTrue(mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Authorization from registration form")
    public void authorizationFromSmallEnterButtonOnRegisterPageTest() {
        open(testData.getRegistrationPageURL());
        registrationPage.smallRegistrationButtonClick();
        loginPage.login(email, password);
        assertTrue(mainPage.doOrderButtonWait().isOrderButtonVisible());
    }

    @Test
    @DisplayName("Authorization using from restore password form")
    public void authorizationFromRestorePasswordLinkTest() {
        loginPage.restoreButtonClick();
        forgotPasswordPage.enterLinkClick();
        loginPage.login(email, password);
        assertTrue(mainPage.doOrderButtonWait().isOrderButtonVisible());
    }
}

