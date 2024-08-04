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
                .enterValueIntoSearch("BrowserStack")
                .checkListTitles()
                .clickFirstArticleInResultList();
        articlePage
                .findText("BrowserStack");

    }

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