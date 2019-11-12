package ohtu;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Stepdefs {
    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567";

    // stepdefs for logging in
    @Given("login is selected")
    public void loginIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();   
    }   
    
    @When("correct username {string} and password {string} are given")
    public void correctUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is logged in")
    public void userIsLoggedIn() {
        pageHasContent("Ohtu Application main page");
    }
 
    @When("correct username {string} and incorrect password {string} are given")
    public void correctUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    } 
    
    @When("nonexistent username {string} and password {string} are given")
    public void nonexistentUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }

    @When("recently not successfully created username {string} and password {string} are given")
    public void recentlyNotSuccessfullyCreatedCredentialsAreGiven(String username, String password) throws Throwable {
        logInWith(username, password);
    }  
    
    @Then("user is not logged in and error message is given")
    public void userIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }

    //stepdefs for creating new user
    
    @Given("command new user is selected")
    public void commandNewUserIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click();           
    }

    @Given("user with username {string} and password {string} is tried to be created")
    public void userIsTriedToBeCreated(String username, String password) {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click();  
        createUserWith(username, password, password);
        element = driver.findElement(By.linkText("back to home"));       
        element.click();
    }

    @Given("user with username {string} with password {string} is successfully created")
    public void userWithNewUsernameAndPasswordIsSuccessfullyCreated(String username, String password) {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click();  
        createUserWith(username, password, password);
        element = driver.findElement(By.linkText("continue to application mainpage"));       
        element.click();
        element = driver.findElement(By.linkText("logout"));
        element.click();
    }

    @When("a valid username {string} and password {string} and matching password confirmation are entered")
    public void usernameAndPasswordAreGiven(String username, String password) throws Throwable {
        createUserWith(username, password, password);
    } 

    @Then("a new user is created")
    public void newUserIsCreated() {
        pageHasContent("Welcome to Ohtu Application!");
    }

    @When("recently created username {string} and password {string} are given")
    public void recentlyCreatedCredentialsAreGiven(String username, String password) throws Throwable {
        logInWith(username, password);
    }

    @When("too short username {string} and password {string} and matching password confirmation are entered")
    public void tooShortUsernameAndPasswordAreGiven(String username, String password) throws Throwable {
        createUserWith(username, password, password);
    }

    @When("a valid username {string} and too short password {string} and matching password confirmation are entered")
    public void validUsernameAndTooShortPasswordAreGiven(String username, String password) throws Throwable {
        createUserWith(username, password, password);
    }  

    @When("a valid username {string} and valid password {string} and different password confimation {string} are entered")
    public void validUsernameAndDifferentPasswordsAreGiven(String username, String password, String passwordConfirmation) throws Throwable {
        createUserWith(username, password, passwordConfirmation);
    }

    @Then("user is not created and error {string} is reported")
    public void errorInTheNewUserCredentials(String error) throws Throwable {
        pageHasContent(error);
    }


    @After
    public void tearDown(){
        driver.quit();
    }
        
    /* helper methods */
 
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
        
    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    } 

    private void createUserWith(String username, String password, String passwordConfirmation) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(passwordConfirmation);
        element = driver.findElement(By.name("signup"));
        element.submit();  
    } 

}
