import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class NaukriProfileUpdate {
    public WebDriver driver;
    
    @BeforeMethod
    public void naukriLoginTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.naukri.com/");
    }

    @Test
    public void naukriProfileUpdateTest() throws InterruptedException {
        WebElement loginLink = driver.findElement(By.xpath(" //a[text()='Login']"));
        loginLink.click();
        WebElement userNameField = driver.findElement(By.xpath(" //input[contains(@placeholder,'Username')]"));
        userNameField.sendKeys("ganeshmekala977@gmail.com");
        WebElement passwordField = driver.findElement(By.xpath(" //input[contains(@placeholder,'password')]"));
        passwordField.sendKeys("Gana@0618");
        WebElement loginBtn = driver.findElement(By.xpath(" //button[text()='Login']"));
        loginBtn.click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        String actualNaukriProfileTitle = driver.findElement(By.xpath("//div[@title='Ganesh Yadav Mekala']")).getText();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@title='Ganesh Yadav Mekala']"))));
        String expectedNaukriProfileTitle = "Ganesh Yadav Mekala";
        Assert.assertEquals(actualNaukriProfileTitle,expectedNaukriProfileTitle);
        WebElement viewProfile = driver.findElement(By.xpath("//div[@class='other-info-wrapper']//a[contains(text(),'View')]"));
        viewProfile.click();
        WebElement editIcon = driver.findElement(By.xpath("//em[contains(@class,'icon edit')]"));
        editIcon.click();
        WebElement noticePeriod15Days = driver.findElement(By.xpath("//span[contains(text(),'15 Days or less')]"));
        noticePeriod15Days.click();
        WebElement noticePeriod30Days = driver.findElement(By.xpath("//span[contains(@data-value,'1 Month')]"));
        noticePeriod30Days.click();
        WebElement saveBasicDetailsBtn = driver.findElement(By.id("saveBasicDetailsBtn"));
        saveBasicDetailsBtn.click();
    }

    @AfterMethod
    public void broswerTearDown(){
        driver.quit();
    }
}
