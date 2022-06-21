package guru.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.annotations_steps.AnnotationStepTestSteps;
import guru.qa.attachments.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnnotationStepTest {
    /**
     * Тест, использующий steps с Annotations от Allure. Сами степы с аннотациями будут лежать в отдельном классе.
     *
     * Также содержит аттачменты. Аттачментом может быть скриншот, код страницы, видео прохождения теста и даже
     * интерактивная версия страницы.
     * При необходимости можно вставить нужные аттачменты в @AfterEach в TestBase классе, чтобы не коллить их в каждом
     * тесте.
     */

    @Test
    @DisplayName("Проверка наличия названия конкретной Issue в разделе Issue, используя Allure annotations steps")
    public void githubIssueSelenideAllureTest() {
        SelenideLogger.addListener("Allure Listener", new AllureSelenide());
        AnnotationStepTestSteps steps = new AnnotationStepTestSteps();

        steps.githubOpening();
        steps.allureSearch();
        steps.clickOn1stResult();
        steps.issuesOpening();
        steps.specificIssueFinding();
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}

