package steps;

import io.qameta.allure.Step;
import pages.NewSuiteModalPage;

public class SuiteSteps extends BaseSteps{

    NewSuiteModalPage newSuiteModalPage;

    public SuiteSteps() {
        this.newSuiteModalPage = new NewSuiteModalPage();
    }

    @Step("Add suite case")
    public void addSuite(String suiteName){
        newSuiteModalPage
                .addNewSuite(suiteName);
    }

    @Step("Create new suite")
    public void newSuite(String suiteName){
        newSuiteModalPage
                .createNewSuite(suiteName);
    }
}
