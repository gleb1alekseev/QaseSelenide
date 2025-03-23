package steps;

import io.qameta.allure.Step;
import pages.ProjectsPage;

public class ProjectsSteps extends BaseSteps{

    ProjectsPage projectsPage;

    public ProjectsSteps() {
        this.projectsPage = new ProjectsPage();
    }

    @Step("Open projects page")
    public void projects (String url){
        projectsPage
                .openProjectsPage(url);
    }

    @Step("Create new project and open project page")
    public void newProject (String projectName, String projectCode){
        projectsPage
                .createNewProject(projectName, projectCode);
    }

    @Step("Open projects page")
    public void newTest (String title){
        projectsPage
                .createNewTest(title);
    }
}
