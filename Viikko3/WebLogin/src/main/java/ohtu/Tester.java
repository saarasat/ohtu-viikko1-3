package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/home/saarasat/Desktop/chromedriver"); 
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();

        sleep(3);

        element = driver.findElement(By.linkText("logout"));
        element.click();
        failedLogin(driver);
        creatingNewUser(driver);
        logOutAfterCreating(driver);
        
        driver.quit();
        
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }

    private static void failedLogin(WebDriver driver) {
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkepaaa");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();
        
        element = driver.findElement(By.linkText("back to home"));
        sleep(2);
        element.click();

        sleep(2);        
    }

    private static void creatingNewUser(WebDriver driver) {
        
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekkaKakkonen");
        element = driver.findElement(By.name("password"));
        element.sendKeys("pekanSalasana1");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("pekanSalasana1");

        element = driver.findElement(By.name("signup"));
        
        sleep(2);
        element.submit();        
    }

    private static void logOutAfterCreating(WebDriver driver) {
        
        WebElement element = driver.findElement(By.linkText("continue to application mainpage"));
        sleep(2);
        element.click();
        element = driver.findElement(By.linkText("logout"));
        element.click();
        sleep(2);
    }
}
