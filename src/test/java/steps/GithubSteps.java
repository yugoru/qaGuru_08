package steps;


import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GithubSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Ищем нужный репозиторий в поле для ввода")
    public void searchRepo(String repo) {
        $(".header-search-input").setValue(repo).pressEnter();
    }

    @Step("Переходим в репозиторий")
    public void clickRepo(String repo) {
        $(By.linkText(repo)).click();
    }

    @Step("Переходим на указанную страницу")
    public void goToPage(String pageName) {
        $(withText(pageName)).click();
    }

    @Step("Проверяем, что на странице есть указанный текст")
    public void searchFor(String searchFor) {
        $(withText(searchFor)).shouldBe(Condition.visible);
    }

}



