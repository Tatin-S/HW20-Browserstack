package tests;

import data.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.*;

@DisplayName("Тесты для Wikipedia")
public class WikiTests extends TestBase {
    FirstPage firstPage = new FirstPage();
    SecondPage secondPage = new SecondPage();
    ThirdPage thirdPage = new ThirdPage();
    FourthPage fourthPage = new FourthPage();
    SearchPage searchPage = new SearchPage();
    ArticlePage articlePage = new ArticlePage();
    TestData testData = new TestData();

/*    @DisplayName("Успешный просмотр экранов онбординга")
    @Test
    void onboardingTest() {
        firstPage
                .checkTextOnAddLanguageButton()
                .checkSkipButtonOnFirstPage()
                .clickOnForwardButtonOnFirstPage();

        secondPage
                .checkPrimaryTextOnSecondPage()
                .checkSkipButtonOnSecondPage()
                .clickOnForwardButtonOnSecondPage();

        thirdPage
                .checkPrimaryTextOnThirdPage()
                .checkSkipButtonOnThirdPage()
                .clickOnContinueButtonOnThirdPage();

        fourthPage
                .checkPrimaryTextOnFourthPage()
                .visibilityCheckOfDoneButtonOnFourthPage()
                .clickToGetStarted();
    }*/

    @Test
    @DisplayName("Поиск статьи по заданному значению")
    void successfulOpenArticleTest() {
        firstPage
                .clickSkipButtonOnFirstPage();
        searchPage
                .checkAccessibilityOfSearchBar()
                .enterValueIntoSearch(testData.valueSearch)
                .checkListTitles()
                .clickFirstArticleInResultList();
        articlePage
                .findText(testData.valueSearch);

    }

/*    @Test
    @DisplayName("Проверка краткого описания статьи")
    void checkDescriptionTest() {
        back();
        step("Отправляем запрос в википедии", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });

        step("Проверяем, что найденный заголовок имеет корректное описание", () ->
                $(id("org.wikipedia.alpha:id/page_list_item_description"))
                        .shouldHave(text("Automation for Apps")));
    }*/

/*    @Test
    @DisplayName("Отображение ошибки при некорректном вводе значения в поиск")
    void errorOpenArticleTest() {
        firstPage
                .clickSkipButtonOnFirstPage();
        searchPage
                .checkAccessibilityOfSearchBar()
                .enterValueIntoSearch(testData.valueSearchError);
        articlePage
                .findText(testData.errorMessage);
    }*/
}