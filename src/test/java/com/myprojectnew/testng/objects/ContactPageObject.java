package com.myprojectnew.testng.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPageObject {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"contact-page\"]/div[2]/div[1]/div/h2")
    WebElement getInTouchIsVisible;

    //6. Enter name, email, subject and message

    @FindBy(xpath = "//*[@id=\"contact-us-form\"]/div[1]/input")
    WebElement nameField;

    @FindBy(xpath = "//*[@id=\"contact-us-form\"]/div[2]/input")
    WebElement emailField;

    @FindBy(xpath = "//*[@id=\"contact-us-form\"]/div[3]/input")
    WebElement subjectField;

    @FindBy(xpath = "//*[@id=\"message\"]")
    WebElement messageField;

    //End 6. Enter name, email, subject and message

    @FindBy(xpath = "//*[@id=\"contact-us-form\"]/div[5]/input")
    WebElement uploadFileBtn;

    public WebElement getGetInTouchIsVisible() {
        return getInTouchIsVisible;
    }

    public WebElement getNameField() {
        return nameField;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getSubjectField() {
        return subjectField;
    }

    public WebElement getMessageField() {
        return messageField;
    }

    public WebElement getUploadFileBtn() {
        return uploadFileBtn;
    }

    public WebElement getSubmitBtn() {
        return submitBtn;
    }

    public WebElement getSuccessYourDetailsHaveBeenSubmittedSuccessfullyIsVisible() {
        return successYourDetailsHaveBeenSubmittedSuccessfullyIsVisible;
    }

    public WebElement getHomeBtn() {
        return homeBtn;
    }

    @FindBy(xpath = "//*[@id=\"contact-us-form\"]/div[6]/input")
    WebElement submitBtn;

    @FindBy(xpath = "//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]")
    WebElement successYourDetailsHaveBeenSubmittedSuccessfullyIsVisible;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a")
    WebElement homeBtn;

    public ContactPageObject(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

}