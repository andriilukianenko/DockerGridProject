package login;

import org.openqa.selenium.By;

public final class Locators {

    public static final By LOGIN_FIELD = By.xpath("//input[@id='j_username']");
    public static final By PASSWORD_FIELD = By.xpath("//input[@id='j_password']");
    public static final By LOGIN_BUTTON = By.xpath("//button[contains(text(),'Log In')]");
    public static final By FORGOT_PASSWORD_LINK = By.xpath("//a[contains(text(),'Forgot your password?')]");
    public static final By FORGOT_PSWD_EMAIL_FIELD = By.xpath("//input[@id='forgottenPwd.email']");
    public static final By RESET_PASSWORD_BUTTON = By.xpath("//button[normalize-space()='Reset Password']");

    public static final By ERROR_MESSAGE_PSWD_OR_USRNAME_INCORRECT = By.xpath("//div[@class='alert alert-danger alert-dismissable getAccAlert']");
    public static final By ERROR_FINAL_MESSAGE_RESETED_PASWORD = By.xpath("//div[@id='cboxLoadedContent']//div[@id='validEmail']");
    public static final By ERROR_MESSAGE_ENTER_VALID_EMAIL = By.xpath("//span[@id='email.errors']");

    public static final String URL_LOGIN = "https://electronic-1905.aimprosoft.com/electronics/en/login";
}


