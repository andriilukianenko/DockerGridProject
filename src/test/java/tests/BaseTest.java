package tests;

import login.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;

    @Parameters("browser")
    @BeforeClass

    public void setup(String driverName) throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        URL url = new URL("http://localhost:4444/wd/hub");
        driver = new RemoteWebDriver(url, cap);
        driver = Util.setEnvironmentAndGetDriver(driverName);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }


        @AfterClass
        public void close () {
            driver.quit();
        }


        protected WebDriver getDriver () {
            return driver;
        }
    }
