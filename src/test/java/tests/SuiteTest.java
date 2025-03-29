package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static pages.ProjectsPage.SUITE_NAME_XPATH;

public class SuiteTest extends BaseTest{

    @Test(description = "Create project and add suite")
    public void addNewSuite() {
        loginSteps.login(USER, PASSWORD, LOGIN_URL);
        projectsSteps.openProjects(PROJECTS_URL);
        projectsSteps.newProject(PROJECT_NAME, PROJECT_CODE);
        suiteSteps.addSuite(SUITE_NAME);
        Assert.assertEquals(SUITE_NAME_XPATH.getText(), SUITE_NAME);
    }

    @Test(description = "Create project and create new suite")
    public void createNewSuite() {
        loginSteps.login(USER, PASSWORD, LOGIN_URL);
        projectsSteps.openProjects(PROJECTS_URL);
        projectsSteps.newProject(PROJECT_NAME, PROJECT_CODE);
        suiteSteps.newSuite(SUITE_NAME);
        Assert.assertEquals(SUITE_NAME_XPATH.getText(), SUITE_NAME);
    }
}
