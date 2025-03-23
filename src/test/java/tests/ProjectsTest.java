package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;

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
        Assert.assertEquals($x("//*[contains(text(), 'PROJECTCOD')]").getText(), PROJECT_CODE);
    }

    @Test(description = "Create project and test")
    public void createNewTest() {
        createNewProject();
        projectsSteps.newTest(TITLE);
        Assert.assertEquals($x("//*[contains(text(), 'TestTitle')]").getText(), TITLE);
    }
}
