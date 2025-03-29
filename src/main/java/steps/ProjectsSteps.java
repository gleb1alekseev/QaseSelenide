package steps;

import io.qameta.allure.Step;
import pages.ProjectsPage;

public class ProjectsSteps extends BaseSteps{

    ProjectsPage projectsPage;

    public ProjectsSteps() {
        this.projectsPage = new ProjectsPage();
    }

    @Step("Open projects page")
    public void openProjects(String url){
        projectsPage
                .openProjectsPage(url);
    }

    @Step("Create new project and open project page")
    public void newProject(String projectName, String projectCode){
        projectsPage
                .createNewProject(projectName, projectCode);
    }

    @Step("Create new project and delete new project")
    public void deleteProject(){
        projectsPage
                .deleteProject();
    }
}
