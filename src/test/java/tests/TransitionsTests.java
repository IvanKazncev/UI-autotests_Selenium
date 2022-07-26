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

public class TransitionsTests {

    TestData testData = new TestData();
    String name = testData.getUserName();
    String email = testData.getUserEmail();
    String password = testData.getUserPassword();
    LoginPage loginPage;
    MainPage mainPage;
    RegistrationPage registrationPage;
    AccountProfilePage accountProfilePage;
    StepToDeleteUser stepToDeleteUser = new StepToDeleteUser();

    @Before
    public void initializationTestData() {

        System.setProperty("selenide.browser", "edge");
        open(testData.getRegistrationPageURL());
        loginPage = Selenide.page(LoginPage.class);
        mainPage = Selenide.page(MainPage.class);
        registrationPage = Selenide.page(RegistrationPage.class);
        accountProfilePage = Selenide.page(AccountProfilePage.class);
        registrationPage.registration(name, email, password);
    }

    @After
    public void afterClass() {
        stepToDeleteUser.deleteUser(email, password);
        Selenide.closeWebDriver();
    }

    @DisplayName("Transition to the constructor from a private profile by clicking on the logo")
    @Test
    public void transitionFromPrivateProfileToConstructorUsingLogoTest() {
        loginPage.login(email, password);
        mainPage.privateAccountElementClick();
        accountProfilePage.stellarBurgersWordingClick();
        assertTrue(mainPage.isOrderButtonVisible());
    }

    @DisplayName("Transition to the private profile")
    @Test
    public void transitionToPrivateProfileTest() {
        loginPage.login(email, password);
        mainPage.privateAccountElementClick();
        //check if the shown in a private profile credentials match with the created user's credentials
        assertEquals(accountProfilePage.compareCredentials().get(0), name.toLowerCase());
        assertEquals(accountProfilePage.compareCredentials().get(1), email.toLowerCase());
    }

    @DisplayName("Transition to the constructor from a private profile by clicking on the constructor")
    @Test
    public void transitionFromPrivateProfileToConstructorTest() {

        loginPage.login(email, password);
        mainPage.privateAccountElementClick();
        mainPage.constructorButtonClick();
        mainPage.doOrderButtonWait();
        assertTrue(mainPage.isOrderButtonVisible());
    }

    @DisplayName("Exit from the private profile using the exit button")
    @Test
    public void exitFromPrivateProfileTest() {
        loginPage.login(email, password);
        mainPage.privateAccountElementClick();
        accountProfilePage.exitLinkClick();
        assertTrue(loginPage.isExitWordVisible());
    }
}
