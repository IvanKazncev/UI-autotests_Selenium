package pageObject;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public class ForgotPasswordPage {

    //enter link
    @FindBy(how = How.CSS, using = "[href=\"/login\"]")
    private SelenideElement enterLink;

    // click on the enter link
    public void enterLinkClick () {
        enterLink.shouldBe(visible, Duration.ofSeconds(7));
        enterLink.isDisplayed();
        enterLink.click();
    }
}
