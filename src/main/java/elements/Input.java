package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Input {
    String label;
    public String inputLocatorLogin = "//*[@name='%s']";
    public String inputLocatorProject = "//*[@id=\"project-name\"]";
    public String inputLocatorTest = "//*[@id=\"title\"]";

    public Input(String label) {
        this.label = label;
    }

    public Input writeLogin(String text) {
        $x(String.format(inputLocatorLogin, label)).shouldBe(Condition.visible).setValue(text);
        return this;
    }

    public Input writeProject(String text) {
        $x(String.format(inputLocatorProject, label)).shouldBe(Condition.visible).setValue(text);
        return this;
    }

    public Input writeTest(String text) {
        $x(String.format(inputLocatorTest, label)).shouldBe(Condition.visible).setValue(text);
        return this;
    }

    public Input clear() {
        SelenideElement element = $x(String.format(inputLocatorLogin, label));
        element.click();
        element.clear();
        return this;
    }
}