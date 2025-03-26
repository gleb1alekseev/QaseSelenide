package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Input;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class ProjectsPage extends BasePage{

    private static final SelenideElement CREATE_NEW_PROJECT_BUTTON = $x("//*[contains(text(), 'Create new project')]");
    private static final SelenideElement CREATE_PROJECT_BUTTON = $x("//*[contains(text(), 'Create project')]");
    private static final SelenideElement CREATED_PROJECT_BUTTON = $x("//*[contains(text(), 'PROJECTCOD')]");
    private static final SelenideElement NEW_TEST_BUTTON = $x("//*[contains(text(), 'New test')]");
    private static final SelenideElement CREATE_NEW_CASE_BUTTON = $x("//*[contains(text(), 'Create new case')]");
    private static final SelenideElement ADD_SUITE_BUTTON = $x("//*[contains(text(), 'Add suite')]");
    private static final SelenideElement CREATE_NEW_SUITE_BUTTON = $x("//*[contains(text(), 'Create new suite')]");
    private static final SelenideElement SAVE_BUTTON = $x("//span[text()='Save']");
    private static final SelenideElement CREATE_BUTTON = $x("//span[text()='Create']");
    private static final SelenideElement SETTINGS_BUTTON = $x("//span[contains(text(), 'Settings')]");
    private static final SelenideElement DELETE_PROJECT_BUTTON = $x("//span[contains(text(), 'Delete project')]");
    private static final SelenideElement DELETE_PROJECT_MODAL_BUTTON = $x("//button[@type='button']//span[contains(text(), 'Delete project')]");

    public static final SelenideElement PROJECT_CODE_XPATH = $x("//*[contains(text(), 'PROJECTCOD')]");
    public static final SelenideElement TITLE_XPATH = $x("//*[contains(text(), 'TestTitle')]");
    public static final SelenideElement SUITE_NAME_XPATH = $x("//a[contains(text(), 'suiteName')]");
    public static final SelenideElement NO_PROJECTS_XPATH = $x("//*[@class = 'wf6Aof']");

    public ProjectsPage() {
    }

    public ProjectsPage openProjectsPage(String url) {
        open(url);
        return this;
    }

    public ProjectsPage createNewProject(String projectName, String projectCode) {
        new Button().click(CREATE_NEW_PROJECT_BUTTON);
        new Input("projectName").writeProject(projectName);
        new Input("projectCode").writeProject(projectCode);
        new Button().click(CREATE_PROJECT_BUTTON);
        new Button().click(CREATED_PROJECT_BUTTON);
        return this;
    }

    public ProjectsPage deleteProject() {
        new Button().click(SETTINGS_BUTTON);
        new Button().click(DELETE_PROJECT_BUTTON);
        new Button().click(DELETE_PROJECT_MODAL_BUTTON);
        return this;
    }

    public ProjectsPage createNewTest(String title) {
        new Button().click(NEW_TEST_BUTTON);
        new Input("title").writeTestAndSuite(title);
        new Button().click(SAVE_BUTTON);
        return this;
    }

    public ProjectsPage createNewCase(String title) {
        new Button().click(CREATE_NEW_CASE_BUTTON);
        new Input("title").writeTestAndSuite(title);
        new Button().click(SAVE_BUTTON);
        return this;
    }

    public ProjectsPage addNewSuite(String suiteName) {
        new Button().click(ADD_SUITE_BUTTON);
        new Input("suiteName").writeTestAndSuite(suiteName);
        new Button().click(CREATE_BUTTON);
        return this;
    }

    public ProjectsPage createNewSuite(String suiteName) {
        new Button().click(CREATE_NEW_SUITE_BUTTON);
        new Input("suiteName").writeTestAndSuite(suiteName);
        new Button().click(CREATE_BUTTON);
        return this;
    }

}
