package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class searchPage extends base {
    public searchPage(WebDriver driver) {
        super(driver);
    }

    final protected By searchField = By.xpath("//*[@id=\"app\"]/div/div/div//input");
    final protected By searchButton = By.xpath("//*[@id=\"app\"]/div/div/div//button");
    final protected By searchResult = By.xpath("//*[@class=\"css-xkh9ud\"]");
    final protected By relatedJobs = By.xpath("//*[@class=\"css-1gatmva e1v1l3u10\"]/div/div[1]/h2/a");
    final protected By datePostedFilter = By.xpath("//*[@class=\"css-16dyq3s e1v1l3u10\"]/div[10]/h3");
    final protected By pastWeekRadio = By.xpath("//*[@class=\"css-ala0zs\"]/div[3]//div");
    final protected By numberOfJobs = By.xpath("//*[@class=\"css-xkh9ud\"]//strong");
    final protected By firstJob = By.xpath("//*[@class=\"css-9i2afk\"]/div[2]/div[1]//*[@class=\"css-m604qf\"]/a");
    final protected By applyButton = By.xpath("//*[@class=\"css-1m0yk35 ezfki8j0\"]");
    final protected By jobQuestionField = By.xpath("//*[@name=\"88190aac-8c14-4d0d-94ba-470a9e3ecbe2\"]/div[3]/textarea");
    final protected By submitButton = By.xpath("//*[@data-gtm-form-interact-id=\"0\"]/div[2]/div/button[2]");
    final protected By gotItButton = By.xpath("//*[@class=\"css-w6lahm\"]");
    final protected By test = By.xpath("");


    public void enterDataInSearchField(String jobTitle) {
        sendkeys(searchField, jobTitle);
        click(searchButton);
    }

    public int relatedjobs() {
        return driver.findElements(relatedJobs).size();
    }

    public void filter() {
        click(datePostedFilter);
        click(pastWeekRadio);
    }

    public String numberOfJobs() {
        return driver.findElement(numberOfJobs).getText();
    }

    public void applyToFirstJob(){
        click(firstJob);

    }


}



