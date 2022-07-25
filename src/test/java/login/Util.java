package login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public final class Util  {

    private Util() {
    }

    private static final String OS = System.getProperty("os.name");

    public static WebDriver setEnvironmentAndGetDriver(String driverName) {


        if (isUnix() && ("chrome").equalsIgnoreCase(driverName)) {
            System.setProperty("chmod +x webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        } else if (isUnix() && ("firefox").equalsIgnoreCase(driverName)) {
            System.setProperty("chmod +x webdriver.gecko.driver", "src/test/resources/driver/geckodriver");
        } else if (isWindows() && ("chrome").equalsIgnoreCase(driverName)) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        } else if (isWindows() && ("firefox").equalsIgnoreCase(driverName))  {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/geckodriver.exe");
        }

        if (driverName.equalsIgnoreCase("chrome")) {
            return new ChromeDriver();
        } else if (driverName.equalsIgnoreCase("firefox")) {
            return new FirefoxDriver();
        }
        return null;
    }


        private static boolean isUnix() {
            return (OS.contains("nix")
                    || OS.contains("nux")
                    || OS.indexOf("aix") > 0);
        }

        private static boolean isWindows() {
            return (OS.contains("Win"));
        }


}
