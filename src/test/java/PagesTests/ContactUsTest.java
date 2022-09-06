package PagesTests;

import Enums.SubjectHeading;
import MainData.PageUtils;
import Model.Message;
import PagesObjects.ContactUsFormPage;
import PagesObjects.TopMenuPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class ContactUsTest extends PagesTests.BaseTest {

    private TopMenuPage topMenuPage;
    private ContactUsFormPage contactUsFormPage;
    private Message message;

    @BeforeEach
    public void setUpTest() {
        driver = new ChromeDriver();
        driver.get(PageUtils.BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageUtils.HOME_PAGE_TITLE);

        topMenuPage = new TopMenuPage(driver);
        contactUsFormPage = new ContactUsFormPage(driver);
        message = new Message();
    }

    @Test
    @Order(1)
    public void shouldNotAllowToSendEmptyContactUsForm() {
        topMenuPage.clinkOnContactUsLink();
        contactUsFormPage.clickOnSendButton();

        assertThat(contactUsFormPage.isRedAlertBoxDisplayed()).isTrue();
        assertThat(contactUsFormPage.redBoxText()).contains(PageUtils.ERROR_TEXT_FOR_EMPTY_CONTACT_US_FORM);
    }

    @Test
    @Order(2)
    public void shouldSendContactUsFormWithValidData() {
        topMenuPage.clinkOnContactUsLink();
        Message.setNewMessage(new Message());

        contactUsFormPage.sendContactUsForm(new Message());
        assertThat(contactUsFormPage.isGreenAlertBoxDisplayed()).isTrue();
    }
}