package tests;

import login.LoginUserPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    private LoginUserPage loginUserPage;

    //@Parameters("browser")
    @BeforeClass


    public void setUp() {
        loginUserPage = new LoginUserPage(getDriver());
      //  loginUserPage.goToLoginPage();
    }

    @Parameters("browser")
    @Test
    public void loginUserWithValidEmailPassword() {
        loginUserPage.goToLoginPage();
        loginUserPage.enterUserEmail("rock@19.ua");
        loginUserPage.enterPassword("qwerty");
        loginUserPage.clickLoginButton();

        String actualName = "Electronics Site | Homepage";
        String title = driver.getTitle();
        Assert.assertTrue(title.contains(actualName));
    }
    @Parameters("browser")
    @Test
    public void loginUsersWithEmptyEmailPasswordFields() {
        loginUserPage.goToLoginPage();
        loginUserPage.clickLoginButton();
        Assert.assertTrue(loginUserPage.isValidationMessageDisplayed(), "Your username or password was incorrect.");

    }
    @Parameters("browser")
    @Test
    public void loginUsersWithInvalidEmailValidPassword() {
        loginUserPage.goToLoginPage();
        loginUserPage.enterUserEmail("rock.ua");
        loginUserPage.enterPassword("qwerty");
        loginUserPage.clickLoginButton();
        Assert.assertTrue(loginUserPage.isValidationMessageDisplayed(), "Your username or password was incorrect.");
    }
    @Parameters("browser")
    @Test
    public void loginUsersWithInvalidPasswordValidEmail() {
        loginUserPage.goToLoginPage();
        loginUserPage.enterUserEmail("rock@19.ua");
        loginUserPage.enterPassword("4679^");
        loginUserPage.clickLoginButton();
        Assert.assertTrue(loginUserPage.isValidationMessageDisplayed(), "Your username or password was incorrect.");
    }
    @Parameters("browser")
    @Test
    public void loginUsersWithInvalidPasswordEmail() {
        loginUserPage.goToLoginPage();
        loginUserPage.enterUserEmail("@19.ua");
        loginUserPage.enterPassword("^^^");
        loginUserPage.clickLoginButton();
        Assert.assertTrue(loginUserPage.isValidationMessageDisplayed(), "Your username or password was incorrect.");
    }
    @Parameters("browser")
    @Test
    public void loginUsersWithValidPasswordEmptyEmail() {
        loginUserPage.goToLoginPage();
        loginUserPage.enterUserEmail("");
        loginUserPage.enterPassword("qwerty");
        loginUserPage.clickLoginButton();
        Assert.assertTrue(loginUserPage.isValidationMessageDisplayed(), "Your username or password was incorrect.");
    }
    @Parameters("browser")
    @Test
    public void userIsAbleResetPassword() {

        final String EXPECTED_TEXT = "Password reset instructions have been sent to your e-mail address. Please contact customer support if you require additional assistance.";
        loginUserPage.goToLoginPage();
        loginUserPage.clickForgotPasswordLink();
        loginUserPage.enterForgotPwdEmail("fisher@mail.ru");
        loginUserPage.clickResetPasswordButton();
        Assert.assertEquals(loginUserPage.userIsResetPassword(), EXPECTED_TEXT);
    }
    @Parameters("browser")
    @Test
    public void userIsUnAbleResetPasswordWithEmptyFields() {
        loginUserPage.goToLoginPage();
        loginUserPage.clickForgotPasswordLink();
        loginUserPage.clickResetPasswordButton();
        Assert.assertTrue(loginUserPage.userIsUnableResetPswdWithEmptyFields(), "Please enter a valid email");

    }

}
