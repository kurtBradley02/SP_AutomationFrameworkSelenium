package com.myprojectnew.cucumber.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginSignUpPageObject {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/h2")
    WebElement newUserSignUpIsVisible;

    //Enter for register name and email address
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")
    WebElement nameField;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")
    WebElement emailAddressField;
    //End enter for register name and email address

    //Enter for login name and email address
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/input[0]")
    WebElement loginNameField;

    @FindBy(xpath = "//*[@data-qa=\"login-email\"]")
    WebElement loginEmailAddressField;
    //End enter for login name and email address

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/button")
    WebElement signUpBtn;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div/h2/b")
    WebElement enterAccountInformationIsVisible;

    //9. Fill details: Title, Name, Email, Password, Date of birth
    @FindBy(xpath = "//*[@id=\"id_gender1\"]")
    WebElement titleMrFieldChkBox;

    @FindBy(xpath = "//*[@id=\"name\"]")
    WebElement name2Field;

    @FindBy(xpath = "//*[@data-qa=\"login-password\" or @data-qa=\"password\"]")
    WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"days\"]")
    WebElement dayOfBirthField;

    @FindBy(xpath = "//*[@id=\"months\"]")
    WebElement monthOfBirthField;

    @FindBy(xpath = "//*[@id=\"years\"]")
    WebElement yearOfBirthField;

    //End 9. Fill details: Title, Name, Email, Password, Date of birth

    @FindBy(xpath = "//*[@id=\"newsletter\"]")
    WebElement signUpForOurNewsLetterChkBox;

    @FindBy(xpath = "//*[@id=\"optin\"]")
    WebElement receiveSpecialOffersFromOurPartnersChkBox;

    //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number

    @FindBy(xpath = "//*[@id=\"first_name\"]")
    WebElement firstNameField;

    @FindBy(xpath = "//*[@id=\"last_name\"]")
    WebElement lastNameField;

    @FindBy(xpath = "//*[@id=\"company\"]")
    WebElement companyField;

    @FindBy(xpath = "//*[@id=\"address1\"]")
    WebElement addressField;

    @FindBy(xpath = "//*[@id=\"address2\"]")
    WebElement address2Field;

    @FindBy(xpath = "//*[@id=\"country\"]")
    WebElement countryField;

    @FindBy(xpath = "//*[@id=\"state\"]")
    WebElement stateField;

    @FindBy(xpath = "//*[@id=\"city\"]")
    WebElement cityField;

    @FindBy(xpath = "//*[@id=\"zipcode\"]")
    WebElement zipCode;

    @FindBy(xpath = "//*[@id=\"mobile_number\"]")
    WebElement mobileNumber;

    //End 12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div[1]/form/button")
    WebElement createAccountBtn;

    @FindBy(xpath = "a")
    WebElement logInAsUsernameIsVisible;

    @FindBy(xpath = "//*[contains(text(),'Delete Account')]")
    WebElement deleteBtn;

    @FindBy(xpath = "//*[@data-qa=\"account-deleted\"]")
    WebElement accountDeletedIsVisible;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div/a")
    WebElement continueBtn;

    @FindBy(xpath = "//*[contains(text(),'Login to your account')]")
    WebElement loginToYourAccountIsVisible;

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement loginBtn;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a")
    WebElement loggedInAsUsernameIsVisible;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/p")
    WebElement yourEmailAndPasswordIsIncorrectIsVisible;

    @FindBy(xpath = "//*[@id='form']/div/div/div/h2/b")
    WebElement accountCreatedIsVisible;

    public WebElement getAccountCreatedIsVisible() {
        return accountCreatedIsVisible;
    }

    public WebElement getNewUserSignUpIsVisible() {
        return newUserSignUpIsVisible;
    }

    public WebElement getNameField() {
        return nameField;
    }

    public WebElement getEmailAddressField() {
        return emailAddressField;
    }

    public WebElement getLoginEmailAddressField() {
        return loginEmailAddressField;
    }

    public WebElement getLoginNameField() {
        return loginNameField;
    }

    public WebElement getSignUpBtn() {
        return signUpBtn;
    }



    public WebElement getEnterAccountInformationIsVisible() {
        return enterAccountInformationIsVisible;
    }

    public WebElement getTitleMrFieldChkBox() {
        return titleMrFieldChkBox;
    }

    public WebElement getName2Field() {
        return name2Field;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getDayOfBirthField() {
        return dayOfBirthField;
    }

    public WebElement getMonthOfBirthField() {
        return monthOfBirthField;
    }

    public WebElement getYearOfBirthField() {
        return yearOfBirthField;
    }

    public WebElement getSignUpForOurNewsLetterChkBox() {
        return signUpForOurNewsLetterChkBox;
    }

    public WebElement getReceiveSpecialOffersFromOurPartnersChkBox() {
        return receiveSpecialOffersFromOurPartnersChkBox;
    }

    public WebElement getFirstNameField() {
        return firstNameField;
    }

    public WebElement getLastNameField() {
        return lastNameField;
    }

    public WebElement getCompanyField() {
        return companyField;
    }

    public WebElement getAddressField() {
        return addressField;
    }

    public WebElement getAddress2Field() {
        return address2Field;
    }

    public WebElement getCountryField() {
        return countryField;
    }

    public WebElement getStateField() {
        return stateField;
    }

    public WebElement getCityField() {
        return cityField;
    }

    public WebElement getZipCode() {
        return zipCode;
    }

    public WebElement getMobileNumber() {
        return mobileNumber;
    }

    public WebElement getCreateAccountBtn() {
        return createAccountBtn;
    }

    public WebElement getLogInAsUsernameIsVisible() {
        return logInAsUsernameIsVisible;
    }

    public WebElement getDeleteBtn() {
        return deleteBtn;
    }

    public WebElement getAccountDeletedIsVisible() {
        return accountDeletedIsVisible;
    }

    public WebElement getContinueBtn() {
        return continueBtn;
    }

    public WebElement getLoginToYourAccountIsVisible() {
        return loginToYourAccountIsVisible;
    }

    public WebElement getLoginBtn() {
        return loginBtn;
    }

    public WebElement getLoggedInAsUsernameIsVisible() {
        return loggedInAsUsernameIsVisible;
    }

    public WebElement getYourEmailAndPasswordIsIncorrectIsVisible() {
        return yourEmailAndPasswordIsIncorrectIsVisible;
    }

    public WebElement getLogoutBtn() {
        return logoutBtn;
    }

    public WebElement getLoginPageIsVisible() {
        return loginPageIsVisible;
    }

    public WebElement getEmailAddressAlreadyExistIsVisible() {
        return emailAddressAlreadyExistIsVisible;
    }

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")
    WebElement logoutBtn;

    @FindBy(xpath = "a")
    WebElement loginPageIsVisible;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/p")
    WebElement emailAddressAlreadyExistIsVisible;

    public LoginSignUpPageObject(WebDriver driver) {


        this.driver = driver;
        PageFactory.initElements(driver, this);

    }



}