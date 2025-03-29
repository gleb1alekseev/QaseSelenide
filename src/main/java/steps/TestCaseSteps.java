package steps;

import io.qameta.allure.Step;
import pages.NewTestCasePage;

public class TestCaseSteps extends BaseSteps{

    NewTestCasePage newTestCasePage;

    public TestCaseSteps() {
        this.newTestCasePage = new NewTestCasePage();
    }

    @Step("Create test")
    public void newTest(String title){
        newTestCasePage
                .createNewTest(title);
    }

    @Step("Create new case")
    public void newCase(String title){
        newTestCasePage
                .createNewTestCase(title);
    }

    @Step("Create new test with filling fields and add steps")
    public void newTestWithFieldsAndSteps(String title, String description, String precondition, String postcondition){
        newTestCasePage
                .createNewTestWithFillingFieldsAndSteps(title, description, precondition, postcondition);
    }
}
