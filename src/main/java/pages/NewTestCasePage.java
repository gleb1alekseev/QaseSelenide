package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Input;

import static com.codeborne.selenide.Selenide.$x;

public class NewTestCasePage extends BasePage{

    private static final SelenideElement NEW_TEST_BUTTON = $x("//*[contains(text(), 'New test')]");
    private static final SelenideElement CREATE_NEW_CASE_BUTTON = $x("//*[contains(text(), 'Create new case')]");
    private static final SelenideElement SAVE_BUTTON = $x("//span[text()='Save']");
    private static final SelenideElement ADD_STEP_BUTTON = $x("//*[@type='button']//*[text()=' Add step']");
    private static final SelenideElement INPUT_STEP_VALUE = $x("(//*[@class = 'OwrMko']//*[contains(@class, 'ProseMirror toastui-editor-contents')])[1]");
    public static final SelenideElement TITLE_XPATH = $x("//*[contains(text(), 'TestTitle')]");

    public static final String TEST_TITLE_TEXT_XPATH = "//*[contains(text(), 'TestTitle')]";
    public static final String TEST_CASE_DESCRIPTION_XPATH = "//p[contains(text(), 'TestCaseDescription')]";
    public static final String TEST_CASE_PRE_CONDITION_XPATH = "//p[contains(text(), 'TestCasePreCondition')]";
    public static final String TEST_CASE_POST_CONDITION_XPATH = "//p[contains(text(), 'TestCasePostCondition')]";

    public NewTestCasePage(){
    }

    public NewTestCasePage createNewTest(String title) {
        new Button().click(NEW_TEST_BUTTON);
        new Input("title").writeTestAndSuite(title);
        new Button().click(SAVE_BUTTON);
        return this;
    }

    public NewTestCasePage createNewTestCase(String title) {
        new Button().click(CREATE_NEW_CASE_BUTTON);
        new Input("title").writeTestAndSuite(title);
        new Button().click(SAVE_BUTTON);
        return this;
    }

    public NewTestCasePage createNewTestWithFillingFieldsAndSteps(String title, String description, String precondition, String postcondition) {
        new Button().click(NEW_TEST_BUTTON);
        new Input("title").writeTestAndSuite(title);
        new Input("Description").writeForTextareaForTestCase(description);
        new Input("Pre-conditions").writeForTextareaForTestCase(precondition);
        new Input("Post-conditions").writeForTextareaForTestCase(postcondition);
        new Button().click(ADD_STEP_BUTTON);
        INPUT_STEP_VALUE.setValue("FirstStep");
        new Button().click(SAVE_BUTTON);
        return this;
    }

    public static String titleTestText() {
        return $x(String.format(TEST_TITLE_TEXT_XPATH)).getText();
    }

    public static String descriptionTestText() {
        return $x(String.format(TEST_CASE_DESCRIPTION_XPATH)).getText();
    }

    public static String preConditionTestText() {
        return $x(String.format(TEST_CASE_PRE_CONDITION_XPATH)).getText();
    }

    public static String postConditionTestText() {
        return $x(String.format(TEST_CASE_POST_CONDITION_XPATH)).getText();
    }
}
