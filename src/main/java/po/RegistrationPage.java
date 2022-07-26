package po;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.time.Duration;
import java.util.List;

public class RegistrationPage {

    //small enter button locator
    @FindBy (how = How.CSS, using = "[class=\"Auth_link__1fOlj\"]")
    private SelenideElement smallEnterButton;

    // password field locator
    @FindBy (how = How.CSS, using = "[name=\"Пароль\"]")
    private SelenideElement passwordField;

    //name field locator
    @FindBy (how = How.CSS, using = "[class=\"text input__textfield text_type_main-default\"]")
    private List<WebElement> authorizationFieldsList;

    //registration button locator
    @FindBy (how = How.CSS, using = "[class=\"button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa\"]")
    private SelenideElement registrationButton;

    //Step to set a name
    public void setName (String name) {
        getAuthorizationFieldsListField().get(0).click();
        getAuthorizationFieldsListField().get(0).sendKeys(name);
    }

    //click on the Small enter button
    public void smallRegistrationButtonClick() {
        smallEnterButton.shouldBe(Condition.visible, Duration.ofSeconds(7));
        smallEnterButton.click();
    }

    //Step to set a password
    public void setPassword (String password) {
        passwordField.click();
        passwordField.sendKeys(password);
    }

    //returns a list of 3 authorization fields
    public List<WebElement> getAuthorizationFieldsListField () {
        return  authorizationFieldsList;
    }

    //execute a registration procedure
    public void registration (String name, String emailName, String passwordName) {
        registrationButton.shouldBe(Condition.visible, Duration.ofSeconds(7));
        setName(name);
        getAuthorizationFieldsListField().get(1).click();
        getAuthorizationFieldsListField().get(1).sendKeys(emailName);
        setPassword(passwordName);
        registrationButton.click();
    }

}
