package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.FirstPage;
import pages.FourthPage;
import pages.SecondPage;
import pages.ThirdPage;

@DisplayName("Wikipedia tests")
public class WikiTests extends TestBase {
    @DisplayName("Успешный просмотр экранов онбординга")
    @Test
    void onboardingTest() {

        FirstPage firstPage = new FirstPage();
        SecondPage secondPage = new SecondPage();
        ThirdPage thirdPage = new ThirdPage();
        FourthPage fourthPage = new FourthPage();

        firstPage.checkTextOnAddLanguageButton()
                .clickOnForwardButtonOnFirstPage();

        secondPage.checkPrimaryTextOnSecondPage()
                .clickOnForwardButtonOnSecondPage();

        thirdPage.checkPrimaryTextOnThirdPage()
                .clickOnContinueButtonOnThirdPage();

        fourthPage.visibilityCheckOfDoneButtonOnFourthPage();
    }
}