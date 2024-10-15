package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class base {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions action;

    public base(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click(By by) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }

    public void click(WebElement element) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void sendkeys(By by, String text) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.findElement(by).sendKeys(text);
    }

    public void sendkeys(WebElement element, String text) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    public void selectByVisibleText(By by, String visibleText) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByVisibleText(visibleText);
    }

    public void selectByVisibleText(WebElement element, String visibleText) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(visibleText);
    }

    public void selectByValue(By by, String value) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByValue(value);
    }

    public void selectByValue(WebElement element, String value) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
        Select dropdown = new Select(element);
        dropdown.selectByValue(value);
    }

    public void selectByIndex(By by, int index) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByIndex(index);
    }

    public void selectByIndex(WebElement element, int index) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
        Select dropdown = new Select(element);
        dropdown.selectByIndex(index);
    }

    public String getCss(By by, String proberty) {
        return driver.findElement(by).getCssValue(proberty);
    }

    public String getCss(WebElement element, String property) {
        return element.getCssValue(property);
    }
    public String getText(By by){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElement(by).getText();
    }
    public String getText(WebElement element){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }
    public void hover(By by){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        action = new Actions(driver);
        action.moveToElement(driver.findElement(by)).perform();
    }
    public void hover(WebElement element){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
        action = new Actions(driver);
        action.moveToElement(element).perform();
    }
}
