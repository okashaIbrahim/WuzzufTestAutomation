package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class registerPage extends base {
    public registerPage(WebDriver driver) {
        super(driver);
    }

    final protected By getStartedButton = By.xpath("//*[@class=\"css-11gef4w\"]/div[3]/a[3]");
    final protected By firstNameField = By.xpath("//*[@id=\"firstname\"]");
    final protected By lastNameField = By.xpath("//*[@id=\"lastname\"]");
    final protected By emailField = By.xpath("//*[@id=\"email\"]");
    final protected By passwordField = By.xpath("//*[@name=\"password\"]");
    final protected By jobTitleField = By.xpath("//*[@placeholder=\"e.g. Accountant\"]");
    final protected By createAccountButton = By.xpath("//*[@class=\"css-1q79c5q\"]/form[2]/button");
    final protected By careerInterestText = By.xpath("//*[@class=\"css-a3j4hb\"]");

    final protected By test = By.xpath("");


    public void goToRegisterPage() {
        click(getStartedButton);
    }

    public void createAccount(String firstName, String lastName, String email, String password, String jobTitle) {
        sendkeys(firstNameField, firstName);
        sendkeys(lastNameField, lastName);
        sendkeys(emailField, email);
        sendkeys(passwordField, password);
        sendkeys(jobTitleField, jobTitle);
        click(passwordField);
        click(createAccountButton);
    }
    public String getCareerInterestText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(careerInterestText));
        return driver.findElement(careerInterestText).getText();
    }


}
