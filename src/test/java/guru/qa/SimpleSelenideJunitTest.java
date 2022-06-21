package guru.qa;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SimpleSelenideJunitTest {
    /**Обычный тест на Selenide, но с подключенным Allure Selenide Listener.
     * Чтобы увидеть отчет в браузере, нужно запустить allureServe в меню Gradle.*/

    @Test
    @DisplayName("Проверка наличия названия конкретной Issue в разделе Issue")
    public void githubIssueSelenideAllureTest() {
        SelenideLogger.addListener("Allure Listener", new AllureSelenide());

        Selenide.open("https://github.com");
        $("[data-test-selector='nav-search-input']").setValue("Allure2").pressEnter();
        //Тут я кликаю на 1 результат, это само по себе проверка, что поиск прошел правильно и дальше все будет окей
        $$("ul.repo-list li").first().$("[class='f4 text-normal']").click();
        $("ul.UnderlineNav-body [data-content='Issues']").parent().click();
        $("div.js-navigation-container")
                .shouldHave(text("allure-behave how to add a new information into file.json generate by allure-behave "))
                .shouldBe(visible);
    }
}
