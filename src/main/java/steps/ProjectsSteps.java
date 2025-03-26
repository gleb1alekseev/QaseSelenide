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

    @Step("Create new project and delete new project")
    public void deleteProject (){
        projectsPage
                .deleteProject();
    }

    @Step("Create test")
    public void newTest (String title){
        projectsPage
                .createNewTest(title);
    }

    @Step("Create new case")
    public void newCase (String title){
        projectsPage
                .createNewCase(title);
    }

    @Step("Add suite case")
    public void addSuite(String suiteName){
        projectsPage
                .addNewSuite(suiteName);
    }

    @Step("Create new suite")
    public void newSuite (String suiteName){
        projectsPage
                .createNewSuite(suiteName);
    }
}
