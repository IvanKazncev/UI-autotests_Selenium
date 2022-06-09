package po;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AccountProfilePage {


    //list with 3 locators "name", "email", "password"
    @FindBy(how = How.CSS, using = "  [class=\"text input__textfield text_type_main-default input__textfield-disabled\"]")
    private List<WebElement> disabledCredentialsFields;

    //Exit link locator
    @FindBy (how = How.XPATH, using = "//*[contains(text(),'Выход')]")
    private SelenideElement exitLink;

    //stellar burgers wording locator
    @FindBy(how = How.CSS, using = "[class=\"AppHeader_header__logo__2D0X2\"]")
    private SelenideElement stellarBurgersWording;

    //click on the stellar burgers wording
    public void  stellarBurgersWordingClick() {
        stellarBurgersWording.should(Condition.visible, Duration.ofSeconds(7));
        stellarBurgersWording.isDisplayed();
        stellarBurgersWording.click();
    }

    //click on the exit link
    public void exitLinkClick() {
        exitLink.should(Condition.visible, Duration.ofSeconds(7));
        exitLink.isDisplayed();
        exitLink.click();
    }

    // check if a specific credential is listed
    public List<String> compareCredentials () {
        List<String> credentials = new ArrayList<>();
        credentials.add(0, disabledCredentialsFields.get(0).getAttribute("value").toLowerCase());
        credentials.add(1, disabledCredentialsFields.get(1).getAttribute("value").toLowerCase());
        return credentials;
    }

}
