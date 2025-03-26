package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static pages.ProjectsPage.*;

public class ProjectsTest extends BaseTest{

    @Test(description = "Login to Qase and open projects page")
    public void successProjectsPage() {
        loginSteps.login(USER, PASSWORD, LOGIN_URL);
        projectsSteps.projects(PROJECTS_URL);
    }

    @Test(description = "Open modal and fill data to create new project")
    public void createNewProject() {
        successProjectsPage();
        projectsSteps.newProject(PROJECT_NAME, PROJECT_CODE);
        Assert.assertEquals(PROJECT_CODE_XPATH.getText(), PROJECT_CODE);
    }

    @Test(description = "Create project and delete it")
    public void deleteProjectTest() {
        createNewProject();
        projectsSteps.deleteProject();
        Assert.assertEquals(NO_PROJECTS_XPATH.getText(), "Looks like you don’t have any projects yet.");
    }

    @Test(description = "Create project and new test")
    public void createNewTest() {
        createNewProject();
        projectsSteps.newTest(TITLE);
        Assert.assertEquals(TITLE_XPATH.getText(), TITLE);
    }

    @Test(description = "Create project and create new case")
    public void createNewCase() {
        createNewProject();
        projectsSteps.newCase(TITLE);
        Assert.assertEquals(TITLE_XPATH.getText(), TITLE);
    }

    @Test(description = "Create project and add suite")
    public void addNewSuite() {
        createNewProject();
        projectsSteps.addSuite(SUITE_NAME);
        Assert.assertEquals(SUITE_NAME_XPATH.getText(), SUITE_NAME);
    }

    @Test(description = "Create project and create new suite")
    public void createNewSuite() {
        createNewProject();
        projectsSteps.newSuite(SUITE_NAME);
        Assert.assertEquals(SUITE_NAME_XPATH.getText(), SUITE_NAME);
    }
}
