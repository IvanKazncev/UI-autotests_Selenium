package data;
import org.apache.commons.lang3.RandomStringUtils;

public class TestData {

        private String mainPageURL = "https://stellarburgers.nomoreparties.site";
        private String loginPageURL = "https://stellarburgers.nomoreparties.site/login";
        private String privateAccountPageURL = "https://stellarburgers.nomoreparties.site/account/profile";
        private String registrationPageURL = "https://stellarburgers.nomoreparties.site/register";
        private String forgotPasswordURL = "https://stellarburgers.nomoreparties.site/forgot-password";

        public String getForgotPasswordURL() {
                return forgotPasswordURL;
        }
        public String getMainPageURL() {
                return mainPageURL;
        }

        public String getLoginPageURL() {
                return loginPageURL;
        }

        public String getPrivateAccountPageURL() {
                return privateAccountPageURL;
        }

        public String getRegistrationPageURL() {
                return registrationPageURL;
        }

        //"Getter for generating a random username")
        public String getUserName() {
                return RandomStringUtils.randomAlphabetic(10);
        }

        //"Getter for generating a random email")
        public String getUserEmail() {
                return RandomStringUtils.randomAlphabetic(10) + "@" + RandomStringUtils.randomAlphabetic(5)
                        + "." + RandomStringUtils.randomAlphabetic(3);
        }

        //"Getter for generating a random password with customizable length")
        public String getUserPassword(int passwordLength) {
                return RandomStringUtils.randomAlphabetic(passwordLength);
        }

        //"Getter for generating a random password")
        public String getUserPassword() {
                return RandomStringUtils.randomAlphabetic(10);
        }

}
