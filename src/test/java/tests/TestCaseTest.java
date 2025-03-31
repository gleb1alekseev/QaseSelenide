package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static pages.NewTestCasePage.*;

public class TestCaseTest extends BaseTest{

    @Test(description = "Create project and new test")
    public void createNewTest() {
        loginSteps.login(USER, PASSWORD, LOGIN_URL);
        projectsSteps.openProjects(PROJECTS_URL);
        projectsSteps.newProject(PROJECT_NAME, PROJECT_CODE);
        testCaseSteps.newTest(TITLE);
        Assert.assertEquals(TITLE_XPATH.getText(), TITLE);
    }

    @Test(description = "Create project and create new case")
    public void createNewCase() {
        loginSteps.login(USER, PASSWORD, LOGIN_URL);
        projectsSteps.openProjects(PROJECTS_URL);
        projectsSteps.newProject(PROJECT_NAME, PROJECT_CODE);
        testCaseSteps.newCase(TITLE);
        Assert.assertEquals(TITLE_XPATH.getText(), TITLE);
    }

    @Test(description = "Create project and new test")
    public void createNewTestWithFillingFieldsAndSteps() {
        loginSteps.login(USER, PASSWORD, LOGIN_URL);
        projectsSteps.openProjects(PROJECTS_URL);
        projectsSteps.newProject(PROJECT_NAME, PROJECT_CODE);
        testCaseSteps.newTestWithFieldsAndSteps(TITLE, TEST_CASE_DESCRIPTION, TEST_CASE_PRE_CONDITION, TEST_CASE_POST_CONDITION);
        Assert.assertEquals(titleTestText(), TITLE);
        Assert.assertEquals(descriptionTestText(), TEST_CASE_DESCRIPTION);
        Assert.assertEquals(preConditionTestText(), TEST_CASE_PRE_CONDITION);
        Assert.assertEquals(postConditionTestText(), TEST_CASE_POST_CONDITION);
    }
}
