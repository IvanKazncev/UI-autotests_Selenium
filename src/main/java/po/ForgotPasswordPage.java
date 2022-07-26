package po;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.time.Duration;

public class ForgotPasswordPage {

    //enter link
    @FindBy(how = How.CSS, using = "[href=\"/login\"]")
    private SelenideElement enterLink;

    // click on the enter link
    public void enterLinkClick () {
        enterLink.shouldBe(Condition.visible, Duration.ofSeconds(7));
        enterLink.isDisplayed();
        enterLink.click();
    }
}
