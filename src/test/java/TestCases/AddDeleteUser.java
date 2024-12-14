package TestCases;

import Pages.AdminPage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddDeleteUser {
    public WebDriver driver;
private AdminPage admnpage;
private LoginPage lgnpage;
private int Record;
private int recordAdded;
private int recorddeleted;
@BeforeTest
public void initiate ()
{
    driver = new ChromeDriver();
    driver.get("https://opensource-demo.orangehrmlive.com");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    driver.manage().window().maximize();
    lgnpage = new LoginPage(driver);
}
@Test
    public void AddDeleteUser() throws InterruptedException {
    lgnpage.enterUserName("Admin");
    lgnpage.enterpassword("admin123");
    admnpage = lgnpage.clickonLogin();
    Record = admnpage.getNumberOfRecords();
    admnpage.clickonAddbutton();
    admnpage.addUser();
    admnpage.clickonSavebutton();
    recordAdded = admnpage.getNumberOfRecords();
    Assert.assertTrue(recordAdded==Record+1);
    admnpage.searchForUser();
    admnpage.deleteUser();
    recorddeleted = admnpage.getNumberOfRecords();
    Assert.assertTrue(recorddeleted==recordAdded-1);

}
@AfterTest
    public void Teardown(){
    driver.quit();
}
}
