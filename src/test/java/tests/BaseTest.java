package tests;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import pages.ProjectsPage;
import steps.LoginSteps;
import steps.ProjectsSteps;
import steps.SuiteSteps;
import steps.TestCaseSteps;
import utils.PropertyReader;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BaseTest extends BasePage {
    protected LoginSteps loginSteps;
    protected ProjectsSteps projectsSteps;
    protected SuiteSteps suiteSteps;
    protected TestCaseSteps testCaseSteps;

    public static String USER = PropertyReader.getProperty("user");
    public static String PASSWORD = PropertyReader.getProperty("password");
    public static String LOGIN_URL = PropertyReader.getProperty("loginUrl");
    public static String PROJECTS_URL = PropertyReader.getProperty("projectsUrl");
    public static String PROJECT_NAME = PropertyReader.getProperty("projectName");
    public static String PROJECT_CODE = PropertyReader.getProperty("projectCode");
    public static String TITLE = PropertyReader.getProperty("title");
    public static String SUITE_NAME = PropertyReader.getProperty("suiteName");
    public static String TEST_CASE_DESCRIPTION = PropertyReader.getProperty("caseDescription");
    public static String TEST_CASE_PRE_CONDITION = PropertyReader.getProperty("casePreCondition");
    public static String TEST_CASE_POST_CONDITION = PropertyReader.getProperty("casePostCondition");

    public void initPages() {
        loginSteps = new LoginSteps();
        projectsSteps = new ProjectsSteps();
        suiteSteps = new SuiteSteps();
        testCaseSteps = new TestCaseSteps();
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
        ProjectsPage.SETTINGS_BUTTON.click();
        ProjectsPage.DELETE_PROJECT_BUTTON.click();
        ProjectsPage.DELETE_PROJECT_MODAL_BUTTON.click();
        getWebDriver().quit();
    }
}
