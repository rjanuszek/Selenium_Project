package PagesTests;

import MainData.PageUtils;
import Model.DataForLogin;
import PagesObjects.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class SignInTest extends PagesTests.BaseTest {

    private PagesObjects.TopMenuPage topMenuPage;
    private PagesObjects.SignInPage signInPage;
    private PagesObjects.LoginPage loginPage;
    private PagesObjects.AccountPage accountPage;


    @BeforeEach
    public void setUpTest() {
        driver = new ChromeDriver();
        driver.get(PageUtils.BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageUtils.HOME_PAGE_TITLE);

        topMenuPage = new PagesObjects.TopMenuPage(driver);
        signInPage = new PagesObjects.SignInPage(driver);
        loginPage = new PagesObjects.LoginPage(driver);
        accountPage = new PagesObjects.AccountPage(driver);
    }

    @Test
    @Order(1)
    public void shouldNotCreateAnAccountWithUsedEmailAddress() {
        setTimeouts();
        topMenuPage.clickOnSignInLink();
        signInPage.inputSpecificEmailAddress("test@wp.pl");
        signInPage.createAnAccount();
        assertThat(signInPage.isRedAlertBoxDisplayed()).isTrue();
        assertThat(signInPage.redBoxText()).contains(PageUtils.ERROR_TEXT_CREATE_AN_ACCOUNT);
    }

    @Test
    @Order(2)
    public void shouldSendSignInFormWithAllValidData() {
        setTimeouts();
        topMenuPage.clickOnSignInLink();
        signInPage.inputRandomEmailAddress();
        signInPage.createAnAccount();
        loginPage.chooseMrsTitle();

        DataForLogin message = new DataForLogin();
        message.setFirstName("Test");
        message.setLastName("Testowa");
        message.setPassword("01234");

        loginPage.clickNewsletterCheckbox();
        loginPage.clickSpecialOffersCheckBox();

        message.setCompany("Google");
        message.setAddressLineOne("Street Test");
        message.setAddressLineTwo("01");
        message.setCity("Cracov");
        message.setPostalCode("42520");
        message.setAdditionalInformation("Nauka JAVA i Selenium");
        message.setHomePhone("48322609279");
        message.setMobilePhone("692000001");
        loginPage.inputDataInLoginForm(message);
        loginPage.clickRegisterButton();

        assertThat(accountPage.isTextAvailableWhenAccountRegister()).contains(PageUtils.TEXT_OF_REGISTER_ACCOUNT);
    }
}