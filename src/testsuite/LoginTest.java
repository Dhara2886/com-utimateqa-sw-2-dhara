package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
/*
Create the package ‘testsuite’ and create the
following class inside the ‘testsuite’ package.
1. LoginTest
 */
public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/ ";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
//1. User should navigate to login page successfully
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click();
        String actualText = driver.findElement(By.tagName("h2")).getText();
        Assert.assertEquals("Welcome Back!",actualText);
    }
//2. Verify the error message
    @Test
    public void verifyTheErrorMessage(){
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click();
        driver.findElement(By.id("user[email]")).sendKeys("invalid@gmail.com");
        driver.findElement(By.name("user[password]")).sendKeys("invalid!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String actualText = driver.findElement(By.id("notice")).getText();
        Assert.assertEquals("Invalid email or password.", actualText);
    }

    @After
    public void closeBrowser() {
    }

}
