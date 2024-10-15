package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class generalInfoPage extends base {
    public generalInfoPage(WebDriver driver) {
        super(driver);
    }

    final protected By generalInfoText = By.xpath("//*[@class=\"css-a3j4hb\"]");
    final public By dayField = By.xpath("//*[@class=\"col-2-lg col-12\"]");
    final protected By dayFieldSize = By.xpath("//*[@class=\" css-1tci6j0\"]//div");
    final protected By monthField = By.xpath("//*[@class=\"col-3-lg col-12\"][1]");
    final protected By monthFieldSize = By.xpath("//*[@class=\" css-1tci6j0\"]//div");
    final protected By yearField = By.xpath("//*[@class=\"col-3-lg col-12\"][2]");
    final protected By yearFieldSize = By.xpath("//*[@class=\" css-1tci6j0\"]//div");
    final protected By genderRadio = By.xpath("//*[@class=\"css-1t6kodx e1kea1u62\"][1]//*[@class=\"css-bhwo3q e1kea1u61\"]");
    final protected By nationalityField = By.xpath("//*[@class=\"section-validation-error css-6hend0 e1v1l3u10\"][1]/div[5]/div/div[2]");
    final protected By nationalityoptions = By.xpath("//*[@class=\" css-1tci6j0\"]/div");
    //final protected By egyptOption = By.xpath("//*[@class=\" css-1tci6j0\"]//div[42]");
    final protected By countryField = By.xpath("//*[@class=\"section-validation-error css-6hend0 e1v1l3u10\"][2]/div[1]/div/div[2]/div");
    final protected By countryField2 = By.xpath("//*[@id=\"react-select-9-input\"]");
    final protected By countryOptions = By.xpath("//*[@class=\" css-1tci6j0\"]/div");
    final protected By cityField = By.xpath("//*[@id=\"basic-info-form\"]/div[2]/div[2]/div/div[2]/div/div[2]");
    final protected By cityOptions = By.xpath("//*[@class=\" css-1tci6j0\"]/div");
    //final protected By cairoOption = By.xpath("//*[@class=\" css-1tci6j0\"]//div[6]");
    //final protected By areaField = By.xpath("//*[@id=\"react-select-11-input\"]");
    //final protected By sayedaZainabArea = By.xpath("//*[@class=\" css-1tci6j0\"]//div[12]");
    final protected By phoneField = By.xpath("//*[@name=\"primaryPhone\"]");
    final protected By saveAndContinueButton = By.xpath("//*[@class=\"css-1wj05oe ezfki8j0\"]");
    final protected By test = By.xpath("");


    public String getGeneralInfoText() {
        return driver.findElement(generalInfoText).getText();
    }

    public int getNationalitysize() {
        click(nationalityField);
        return driver.findElements(nationalityoptions).size();
    }


    public void fillGeneralInfoData(int day, int month, int year) {
        click(dayField);
        WebElement selectRandomDay = driver.findElement(By.xpath("//*[@class=\"col-2-lg col-12\"]//*[@class=\" css-1tci6j0\"]//div[" + day + "]"));
        click(selectRandomDay);
        click(monthField);
        WebElement selectRandomMonth = driver.findElement(By.xpath("//*[@class=\"col-3-lg col-12\"][1]//*[@class=\" css-1tci6j0\"]//div[" + month + "]"));
        click(selectRandomMonth);
        click(yearField);
        WebElement selectRandomyear = driver.findElement(By.xpath("//*[@class=\"col-3-lg col-12\"][2]//*[@class=\" css-1tci6j0\"]//div[" + year + "]"));
        click(selectRandomyear);
        click(genderRadio);
    }

    public int getCountriesSize() throws InterruptedException {
        click(countryField2);
        return driver.findElements(countryOptions).size();
    }

    public void continueGeneralData(int nationality) {
        By randomNationality = By.xpath("//*[@class=\" css-1tci6j0\"]/div[" + nationality + "]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(randomNationality));
        click(randomNationality);
    }

    public void continueGeneralData2(int country) throws InterruptedException {
        By randomCountry = By.xpath("//*[@class=\" css-1tci6j0\"]/div[" + country + "]");
        click(randomCountry);
    }

    public int getCitySize() throws InterruptedException {
        Thread.sleep(1000);
        click(cityField);
        return driver.findElements(cityOptions).size();
    }

    public void continueGeneralData3(String number, int city) throws InterruptedException {
        By randomCity = By.xpath("//*[@class=\" css-1tci6j0\"]/div[" + city + "]");
        click(randomCity);
        sendkeys(phoneField, number);
        Thread.sleep(1000);
        click(saveAndContinueButton);
        //if (randomCountry == "Egypt")
        //click(areaField);
        //click(sayedaZainabArea);


    }

    public int getDayNumber() {
        click(dayField);
        return driver.findElements(dayFieldSize).size();
    }

    public int getMonthNumber() {
        click(monthField);
        return driver.findElements(monthFieldSize).size();
    }

    public int getYearNumber() {
        click(yearField);
        return driver.findElements(yearFieldSize).size();
    }
}
