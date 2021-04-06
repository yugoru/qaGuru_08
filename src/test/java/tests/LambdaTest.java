package tests;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaTest {

    void searchIssue(String repo, String pagename, String searchfor) {
        step("Открываем главную страницу", () -> open("https://github.com"));
        step("Вводим в поиск " + repo, () -> $(".header-search-input").setValue(repo).pressEnter());
        step("Переходим на странцу " + repo, () -> $(By.linkText(repo)).click());
        step("Переходим на страницу " + pagename, () -> $(withText(pagename)).click());
        step("Проверяем, что на странице есть " + repo,
                () -> $(withText(searchfor)).shouldBe(Condition.visible));
    }

}
