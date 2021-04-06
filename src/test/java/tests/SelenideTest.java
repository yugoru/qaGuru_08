package tests;


import com.codeborne.selenide.Condition;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {

    void searchIssue(String repo, String pagename, String searchfor) {
        open("https://github.com");
        $(".header-search-input").setValue(repo).pressEnter();
        $(By.linkText(repo)).click();
        $(withText(pagename)).click();
        $(withText(searchfor)).shouldBe(Condition.visible);
    }
}
