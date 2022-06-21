package guru.qa.annotations_steps;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AnnotationStepTestSteps {
    /**
     * Специальный класс, содержащий степы теста с аннотациями.
     * Многие данные тут можно вынести в переменные или даже в датакласс, но надо помнить, что статические объекты
     * могут мешать многопоточности.
     */

    @Step("Открываем главную github")
    public void githubOpening() {
        Selenide.open("https://github.com");
    }

    @Step("В окошке поиска вводим Allure2 и жмем Enter")
    public void allureSearch() {
        $("[data-test-selector='nav-search-input']").setValue("Allure2").pressEnter();
    }

    @Step("Выбираем в списке результатов первый")
    public void clickOn1stResult() {
        $$("ul.repo-list li").first().$("[class='f4 text-normal']").click();
    }

    @Step("Кликаем по пункту меню Issues")
    public void issuesOpening() {
        $("ul.UnderlineNav-body [data-content='Issues']").parent().click();
    }

    @Step("Проверяем список Issues на наличие нужной нам")
    public void specificIssueFinding() {
        $("div.js-navigation-container")
                .shouldHave(text("allure-behave how to add a new information into file.json generate by allure-behave "))
                .shouldBe(visible);
    }
}
