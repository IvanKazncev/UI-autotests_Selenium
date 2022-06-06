package pageObject;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.time.Duration;
import java.util.List;
import static com.codeborne.selenide.Condition.visible;

public class MainPage {

        //burger ingredients names in display area list
        @FindBy(how = How.XPATH, using = "//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']/h2")
        private List<SelenideElement> burgerIngredients;

        //burger ingredients tabs
        @FindBy(how = How.XPATH, using = "//span[@class='text text_type_main-default']")
        private List<SelenideElement> burgerIngredientsTabs;

        //constructor button locator
        @FindBy (how = How.XPATH, using = "//*[contains(text(),'Конструктор')]")
        private SelenideElement constructorButton;

        //Order button locator
        @FindBy(how = How.XPATH, using = "//button[text()='Оформить заказ']")
        private SelenideElement orderButton;

        //  enter to an account button
        @FindBy(how = How.XPATH, using = "//button[text()='Войти в аккаунт']")
        private SelenideElement enterToAccountButton;

        //private account element locator
        @FindBy(how = How.LINK_TEXT, using = "Личный Кабинет")
        private SelenideElement privateAccountElement;

        //stellar burgers wording locator
        @FindBy(how = How.CSS, using = "[class=\"AppHeader_header__logo__2D0X2\"]")
        private SelenideElement stellarBurgersWording;

        //stellar burgers wording locator
        @FindBy(how = How.CSS, using = "[class=\"tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect\"]")
        private SelenideElement selectedStateOfFillingIngredient;


        // switch to bun ingredient tab
        public void bunTabClick() {
            burgerIngredientsTabs.get(0).isDisplayed();
            burgerIngredientsTabs.get(0).click();
        }

        // switch to sauce ingredient tab
        public void sauceTabClick() {
            burgerIngredientsTabs.get(1).isDisplayed();
            burgerIngredientsTabs.get(1).click();

        }

        // switch to filling ingredient tab
        public void fillingTabClick() {
            burgerIngredientsTabs.get(2).isDisplayed();
            burgerIngredientsTabs.get(2).click();
        }

        //check if a bun ingredient is displayed
        public Boolean isBunBurgerIngredientVisible() {
            return burgerIngredients.get(0) .shouldBe(visible, Duration.ofSeconds(10)).is(visible);
        }

        //check if a sauce ingredient is displayed
        public Boolean isSauceBurgerIngredientVisible() {
            return burgerIngredients.get(1).isDisplayed();
        }

        //check if a filling ingredient is displayed
        public Boolean isFillingBurgerIngredientVisible() {

            return burgerIngredients.get(2).shouldBe(visible, Duration.ofSeconds(5)).isDisplayed();
        }

        //click on private account element locator
        public void privateAccountElementClick () {
            privateAccountElement.shouldBe(visible, Duration.ofSeconds(7));
            privateAccountElement.click();
        }

        public MainPage doEnterToAccountButtonWait() {
            enterToAccountButton.shouldBe(visible, Duration.ofSeconds(7));
            enterToAccountButton.isDisplayed();
            return this;
        }

        public void enterToAccountButtonClick() {
            enterToAccountButton.shouldBe(visible, Duration.ofSeconds(7));
            enterToAccountButton.isDisplayed();
            enterToAccountButton.click();
        }

        //click on constructor Button
        public void constructorButtonClick() {
            constructorButton.click();
        }

        //wait for an order button
        public MainPage doOrderButtonWait() {
            orderButton.shouldBe(visible, Duration.ofSeconds(7));
            return this;
        }

        public Boolean isOrderButtonVisible () {
        orderButton.shouldBe(visible,Duration.ofSeconds(5));
        orderButton.isDisplayed();
            return orderButton.is(visible);
        }


}
