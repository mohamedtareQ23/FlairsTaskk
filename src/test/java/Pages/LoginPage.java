package Pages;

import CustomControls.CustomMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    public LoginPage (WebDriver driver){
        this.driver=driver;
    }
    private By usernameTxtfield = By.name("username");
    private By passwordTxtfield = By.name("password");
    private By loginBtn = By.cssSelector(".oxd-button");
    public void enterUserName(String usrname){
        driver.findElement(usernameTxtfield).sendKeys(usrname);
    }
    public void enterpassword(String password){
        driver.findElement(passwordTxtfield).sendKeys(password);
    }
    public AdminPage clickonLogin(){
        CustomMethods.clickOnElement(driver,loginBtn);
        return new AdminPage(driver);
    }
}
