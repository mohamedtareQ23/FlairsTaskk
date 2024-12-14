package Pages;

import CustomControls.CustomMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage {
    private WebDriver driver;
    public AdminPage(WebDriver driver){
        this.driver=driver;
    }
    private By adminTab =By.cssSelector(".oxd-text");
    private By numberOfRecords = By.xpath("//div[@class='orangehrm-header-container']//following::span");
    private By addBtn = By.xpath("//div[@class='orangehrm-header-container']//child::button");
    private By userRoleDropDown = By.xpath("//label[text()='Employee Name']//preceding::div[@tabindex='0']");
    private By employeeletter = By.xpath("//input[@placeholder='Type for hints...']");
    private By employeeoption = By.xpath("//div[@role='option']//child::span[1]");
    private By statusDropDown = By.xpath("//label[text()='Status']//following::div[@tabindex='0']");
    private By userName = By.xpath("//label[text()='Username']//following::input[1]");
    private By password = By.xpath("//label[text()='Password']//following::input[1]");
    private By confirmPassword = By.xpath("//label[text()='Confirm Password']//following::input[1]");
    private By saveBtn = By.xpath("//p//following::button[text()=' Save ']");
    private By adminChoice = By.xpath("//span[contains(text(),'Admin')]");
    private By enabledChoice = By.xpath("//span[contains(text(),'Enabled')]");
    private By userNameErrMsg = By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']");
    private By userNameSearchField = By.xpath("//label[contains(text(),'Username')]//following::input[1]");
    private By searchBtn = By.xpath("//div[@class='oxd-form-actions']//following-sibling::button[2]");
    private By deleteEmp = By.xpath("//div[@role='cell']//following::button[1]");
    private By confirmDelete = By.xpath("//p[@class='oxd-text oxd-text--p oxd-text--card-body']//following::button[2]");

    public int getNumberOfRecords (){
        driver.findElement(adminTab).click();
        String recordsNotxt = driver.findElement(numberOfRecords).getText();
        String recordNo = recordsNotxt.replaceAll("[^0-9]", "");
        int recordNum = Integer.parseInt(recordNo);
        return recordNum;
    }
    public void clickonAdminTab(){
        driver.findElement(adminTab).click();
    }
    public void clickonAddbutton(){
        driver.findElement(addBtn).click();
    }
    public void clickonSavebutton() throws InterruptedException {
        driver.findElement(saveBtn).click();
        CustomMethods.waitforseconds(3);
    }
    public void addUser() throws InterruptedException {
        CustomMethods.clickOnElement(driver,userRoleDropDown);
        CustomMethods.clickOnElement(driver,adminChoice);
        CustomMethods.EnterText(driver,employeeletter,"N");
        CustomMethods.clickOnElement(driver,employeeoption);
        CustomMethods.clickOnElement(driver,statusDropDown);
        CustomMethods.clickOnElement(driver,enabledChoice);
        CustomMethods.EnterText(driver,userName,"kennnmmmm7006");
        CustomMethods.WaitUntilElementIsNotVisible(driver,userNameErrMsg);
        CustomMethods.EnterText(driver,password,"Kenan1234");
        CustomMethods.EnterText(driver,confirmPassword,"Kenan1234");
        CustomMethods.waitforseconds(3);
    }
    public void searchForUser(){
        CustomMethods.EnterText(driver,userNameSearchField,"kennnmmmm7006");
        CustomMethods.clickOnElement(driver,searchBtn);

    }
    public void deleteUser(){
        CustomMethods.clickOnElement(driver,deleteEmp);
        CustomMethods.clickOnElement(driver,confirmDelete);
    }



}
