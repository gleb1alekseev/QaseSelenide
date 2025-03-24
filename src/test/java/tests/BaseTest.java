package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.LoginSteps;
import steps.ProjectsSteps;
import utils.PropertyReader;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BaseTest {
    protected LoginSteps loginSteps;
    protected ProjectsSteps projectsSteps;

    public static String USER = PropertyReader.getProperty("user");
    public static String PASSWORD = PropertyReader.getProperty("password");
    public static String LOGIN_URL = PropertyReader.getProperty("loginUrl");
    public static String PROJECTS_URL = PropertyReader.getProperty("projectsUrl");
    public static String PROJECT_NAME = PropertyReader.getProperty("projectName");
    public static String PROJECT_CODE = PropertyReader.getProperty("projectCode");
    public static String TITLE = PropertyReader.getProperty("title");
    public static String SUITE_NAME = PropertyReader.getProperty("suiteName");
    private static final SelenideElement SETTINGS = $x("//span[contains(text(), 'Settings')]");
    private static final SelenideElement DELETE_PROJECT = $x("//span[contains(text(), 'Delete project')]");
    private static final SelenideElement DELETE_PROJECT_MODAL = $x("//button[@type='button']//span[contains(text(), 'Delete project')]");

    public void initPages() {
        loginSteps = new LoginSteps();
        projectsSteps = new ProjectsSteps();
    }

    @BeforeMethod
    public void initTest(){
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        options.addArguments("--disable-popup-blocking");
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);
        setWebDriver(driver);

        Configuration.browser = "chrome";
        Configuration.timeout = 15000;
        Configuration.headless = false;
        Configuration.browserSize = "1024x768";
        initPages();
    }

    @AfterMethod
    public void endTest() {
        SETTINGS.click();
        DELETE_PROJECT.click();
        DELETE_PROJECT_MODAL.click();
        getWebDriver().quit();
    }
}
