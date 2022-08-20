package PagesObjects;

import Model.Message;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ContactUsFormPage extends PagesObjects.BasePage {

    public ContactUsFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "submitMessage")
    WebElement sendButton;

    @FindBy(id = "id_contact")
    WebElement subjectHeading;

    @FindBy(id = "email")
    WebElement emailElement;

    @FindBy(id = "id_order")
    WebElement orderReference;

    @FindBy(id = "message")
    WebElement messageBox;

    @FindBy(className = "alert-success")
    WebElement greenAlertBox;

    @FindBy(className = "alert-danger")
    WebElement redAlertBox;

    public void clickOnSendButton() {
        sendButton.click();
    }

    public boolean isRedAlertBoxDisplayed() {
        return isAlertBoxDisplayed(redAlertBox);
    }

    public boolean isGreenAlertBoxDisplayed() {
        return isAlertBoxDisplayed(greenAlertBox);
    }

    public void enterEmail(String email) {
        emailElement.sendKeys(email);
    }

    public void sendContactUsForm() {
        Select subject = new Select(subjectHeading);
        subject.selectByVisibleText(message.getSubjectHeading().getValue());

        emailElement.sendKeys(message.getEmailAddress());
        orderReference.sendKeys(message.getOrderReference());
        messageBox.sendKeys(message.getEmailAddress());
        sendButton.click();
        wait.until(ExpectedConditions.visibilityOf(greenAlertBox));
    }

    public String redBoxText() {
        return isTextInRedAlertBox(redAlertBox);
    }
}