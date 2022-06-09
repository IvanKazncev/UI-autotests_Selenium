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
import static org.junit.Assert.assertTrue;

public class ConstructorTests {

    TestData testData = new TestData();
    String name = testData.getUserName();
    String email = testData.getUserEmail();
    String password = testData.getUserPassword();
    LoginPage loginPage;
    MainPage mainPage;
    RegistrationPage registrationPage;
    ForgotPasswordPage forgotPasswordPage;
    AccountProfilePage accountProfilePage;
    StepToDeleteUser stepToDeleteUser = new StepToDeleteUser();

    @Before
    public void initializationTestData() {
        System.setProperty("selenide.browser", "edge");
        open(testData.getRegistrationPageURL());
        loginPage = Selenide.page(LoginPage.class);
        mainPage = Selenide.page(MainPage.class);
        registrationPage = Selenide.page(RegistrationPage.class);
        forgotPasswordPage = Selenide.page(ForgotPasswordPage.class);
        accountProfilePage = Selenide.page(AccountProfilePage.class);
        registrationPage.registration(name, email, password);
    }

    @After
    public void afterClass() {
        stepToDeleteUser.deleteUser(email, password);
        Selenide.closeWebDriver();
    }

    @DisplayName("Switching to the sauce ingredient tab")
    @Test
    public void switchToSauceIngredientTabTest() {
        loginPage.login(email, password);
        mainPage.sauceTabClick();
        assertTrue(mainPage.isSauceBurgerIngredientVisible());
    }

    @DisplayName("Switching to the filling ingredient tab")
    @Test
    public void switchToFillingIngredientTabTest() {
        loginPage.login(email, password);
        mainPage.fillingTabClick();
        assertTrue(mainPage.isFillingBurgerIngredientVisible());
    }

    @DisplayName("Switching to the bun ingredient tab")
    @Test
    public void switchToBunIngredientTabTest() {
        loginPage.login(email, password);
        mainPage.fillingTabClick();
        mainPage.bunTabClick();
        assertTrue(mainPage.isBunBurgerIngredientVisible());
    }
}
