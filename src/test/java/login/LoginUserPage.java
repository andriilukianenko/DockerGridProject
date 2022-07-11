package login;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static login.Locators.*;

public class LoginUserPage extends BasePage{


    public LoginUserPage(WebDriver driver) {
        super(driver);

    }
    public void goToLoginPage() {
        driver.get(URL_LOGIN);}

    public void enterUserEmail(String emailUser) {
        driver.findElement(LOGIN_FIELD).sendKeys(emailUser);
    }

    public void enterPassword(String pass) {
        driver.findElement(PASSWORD_FIELD).sendKeys(pass);
    }

    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }
    public void clickForgotPasswordLink() {
        driver.findElement(FORGOT_PASSWORD_LINK).click();
    }

    public void enterForgotPwdEmail(String forgotPswdEmail) {
        driver.findElement(FORGOT_PSWD_EMAIL_FIELD).sendKeys(forgotPswdEmail);
    }

    public void clickResetPasswordButton() {
        driver.findElement(RESET_PASSWORD_BUTTON).click();
    }

    public boolean isValidationMessageDisplayed() {
        return driver.findElement(ERROR_MESSAGE_PSWD_OR_USRNAME_INCORRECT).isDisplayed();
    }

    public String userIsResetPassword() {
        return driver.findElement(ERROR_FINAL_MESSAGE_RESETED_PASWORD).getText();
    }

    public boolean userIsUnableResetPswdWithEmptyFields() {
        return driver.findElement(ERROR_MESSAGE_ENTER_VALID_EMAIL).getText().equalsIgnoreCase("Please enter a valid email");
    }

}