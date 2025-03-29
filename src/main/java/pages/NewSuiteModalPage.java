package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Input;

import static com.codeborne.selenide.Selenide.$x;

public class NewSuiteModalPage extends BasePage{

    private static final SelenideElement ADD_SUITE_BUTTON = $x("//*[contains(text(), 'Add suite')]");
    private static final SelenideElement CREATE_NEW_SUITE_BUTTON = $x("//*[contains(text(), 'Create new suite')]");
    private static final SelenideElement CREATE_BUTTON = $x("//span[text()='Create']");

    public NewSuiteModalPage(){

    }
    public NewSuiteModalPage addNewSuite(String suiteName) {
        new Button().click(ADD_SUITE_BUTTON);
        new Input("suiteName").writeTestAndSuite(suiteName);
        new Button().click(CREATE_BUTTON);
        return this;
    }

    public NewSuiteModalPage createNewSuite(String suiteName) {
        new Button().click(CREATE_NEW_SUITE_BUTTON);
        new Input("suiteName").writeTestAndSuite(suiteName);
        new Button().click(CREATE_BUTTON);
        return this;
    }
}
