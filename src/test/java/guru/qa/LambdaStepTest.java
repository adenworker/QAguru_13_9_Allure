package guru.qa;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class LambdaStepTest {
    /**
     * Тест, использующий lambda steps от Allure.
     *
     * Также в нем используются разнообразные лейблы теста от Allure.
     * Лейблы можно активировать, используя классы и методы:
     * Allure.label("owner", "eroshenkoam");
     * Allure.label("severity", SeverityLevel.CRITICAL.value());
     * Allure.feature("Работа с лейбочками");
     * Allure.story("Внутри теста можно выставлять динамические лейбочки");
     * Allure.getLifecycle().updateTestCase(testResult -> testResult.setName("Не самый прекрасный тест"));
     * Allure.getLifecycle().updateTestCase(testResult -> testResult.setDescription("Этот тест проверяет очень важную функцоинальность..."));
     * Allure.link("GitHub", "https://guthub.com");
     */

    @Test
    @DisplayName("Проверка наличия названия конкретной Issue в разделе Issue, используя Allure lambda steps")
    @Owner("alisichkin")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Allure lambda tests")
    @Story("В Issues гитхаба можно найти конкретную issue")
    @Description("Этот тест проверяет работоспособность Allure lambda tests")
    @Link(name = "GitHub", url = "https://github.com")
    public void githubIssueSelenideAllureLambdaTest() {
        SelenideLogger.addListener("Allure Listener", new AllureSelenide());

        step("Открываем главную github", () -> {
            Selenide.open("https://github.com");
        });
        step("В окошке поиска вводим Allure2 и жмем Enter", () -> {
            $("[data-test-selector='nav-search-input']").setValue("Allure2").pressEnter();
        });
        step("Выбираем в списке результатов первый", () -> {
            //Тут я кликаю на 1 результат, это само по себе проверка, что поиск прошел правильно и дальше все будет окей
            $$("ul.repo-list li").first().$("[class='f4 text-normal']").click();
        });
        step("Кликаем по пункту меню Issues", () -> {
            $("ul.UnderlineNav-body [data-content='Issues']").parent().click();
        });
        step("Проверяем список Issues на наличие нужной нам", () -> {
            $("div.js-navigation-container")
                    .shouldHave(text("allure-behave how to add a new information into file.json generate by allure-behave "))
                    .shouldBe(visible);
        });
    }
}

