package pageObject;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.time.Duration;
import java.util.List;
import static com.codeborne.selenide.Condition.visible;

public class LoginPage {

    //Email field locator
    @FindBy(how = How.NAME, using = "name")
    private SelenideElement email;

    //Password field locator
    @FindBy(how = How.CSS, using = "[type='password']")
    private SelenideElement password;

    //enter button locator
    @FindBy(how = How.XPATH, using = "//button[text()='Войти']")
    private SelenideElement enterButton;

    // registration link locator
    @FindBy(how = How.CSS, using = "[href=\"/register\"]")
    private SelenideElement registrationLink;

    // forgot password link locator
    @FindBy(how = How.CSS, using = "[href=\"/forgot-password\"]")
    private SelenideElement forgotPassword;

    //name field locator
    @FindBy (how = How.CSS, using = "[class=\"text input__textfield text_type_main-default\"]")
    private List<WebElement> authorizationFieldsList;

    //ribbon orders feed button locator
    @FindBy (how = How.XPATH, using = "//*[contains(text(),'Лента Заказов')]")
    private SelenideElement ordersFeedButton;

    //"Exit" word locator
    @FindBy (how = How.XPATH, using = "//*[contains(text(),'Вход')]")
    private SelenideElement exitWord;

    //registration button locator
    @FindBy (how = How.CSS, using = "[class=\"button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa\"]")
    private SelenideElement registrationButton;

    // password field locator
    @FindBy (how = How.CSS, using = "[name=\"Пароль\"]")
    private SelenideElement passwordField;

    //restore button locator
    @FindBy (how = How.XPATH, using = "//*[contains(text(),'Восстановить')]")
    private SelenideElement restoreButton;

    //eye icon locator
    @FindBy (how = How.XPATH, using = "[fill=\"#F2F2F3\"]")
    private SelenideElement eyeIcon;

    // incorrect password message locator
    @FindBy (how = How.XPATH, using = "//*[contains(text(),'Некорректный пароль')]")
    private SelenideElement incorrectPasswordMessage;

    //stellar burgers wording locator
    @FindBy(how = How.CSS, using = "[class=\"AppHeader_header__logo__2D0X2\"]")
    private SelenideElement stellarBurgersWording;

    //click on the stellar burgers wording
    public void stellarBurgersWordingClick() {
        stellarBurgersWording.should(visible, Duration.ofSeconds(7));
        stellarBurgersWording.isDisplayed();
        stellarBurgersWording.click();
    }

    public void waitStellarBurgersWording () {
        stellarBurgersWording.isDisplayed();
        stellarBurgersWording.should(visible, Duration.ofSeconds(7));
    }

    // click on the eye icon
    public void eyeIconClick(){
        eyeIcon.click();
    }

    // click on the restore password button
    public void restoreButtonClick(){
        restoreButton.shouldBe(visible, Duration.ofSeconds(5));
        restoreButton.isDisplayed();
        restoreButton.click();
    }

    //check if the incorrect pw message is shown up
    public SelenideElement incorrectPasswordAlert() {
        incorrectPasswordMessage.shouldBe(visible, Duration.ofSeconds(7));
        return incorrectPasswordMessage;
    }

    // click on registration link
    public void registrationLinkClick(){
        registrationLink.shouldBe(visible, Duration.ofSeconds(7));
        registrationLink.click();
    }

    //check if the exit word visible
    public Boolean isExitWordVisible() {
        exitWord.shouldBe(visible, Duration.ofSeconds(7));
        return exitWord.isDisplayed();
    }

    //returns a list of 3 authorization fields
    public List<WebElement> getAuthorizationFieldsListField () {
        return  authorizationFieldsList;
    }

    //Step to set an email
    public void setEmail (String email) {
        getAuthorizationFieldsListField().get(0).click();
        getAuthorizationFieldsListField().get(0).sendKeys(email);
    }

    //Step to set a password
    public void setPassword (String password) {
        passwordField.click();
        passwordField.sendKeys(password);
    }

    //execute a login procedure
    public void login (String emailName, String passwordName) {
        enterButton.shouldBe(visible, Duration.ofSeconds(7));
        enterButton.isDisplayed();
        setEmail(emailName);
        setPassword(passwordName);
        enterButton.click();
    }
}
