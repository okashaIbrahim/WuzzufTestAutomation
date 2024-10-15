package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class careerPage extends base {
    public careerPage(WebDriver driver) {
        super(driver);
    }


    final protected By careerLevelOptions = By.xpath("//*[@id=\"career-interests-form\"]/div[1]/div/div");
    final protected By typesOfJobOptions = By.xpath("//*[@id=\"career-interests-form\"]/div[2]/div/button");
    final protected By workPlaceOptions = By.xpath("//*[@id=\"career-interests-form\"]/div[3]/div/button");
    final protected By jobCategories = By.xpath("//*[@class=\"section-validation-error css-6hend0 e1v1l3u10\"]/div");
    final protected By jobCategoriesOptions = By.xpath("//*[@class=\" css-1tci6j0\"]/div");
    final protected By salaryField = By.xpath("//*[@id=\"career-interests-form\"]/div[5]/div/div/div/input");
    final protected By hideSalaryCheckBox = By.xpath("//*[@class=\"css-hx5gx4\"]");
    final protected By saveAndContinueButton = By.xpath("//*[@class=\"css-1wj05oe ezfki8j0\"]");


    public int getCareerLevelSize() {
        return driver.findElements(careerLevelOptions).size();
    }

    public int getJobTypesSize() {
        return driver.findElements(typesOfJobOptions).size();
    }

    public int getWorkPlaceSize() {
        return driver.findElements(workPlaceOptions).size();
    }

    public int getJobCategoriesSize() {
        click(jobCategories);
        return driver.findElements(jobCategoriesOptions).size();
    }

    public void fillCareerInterestsData(int career, int type, int workPlace) {
        WebElement randomCareerLevel = driver.findElement(By.xpath("//*[@id=\"career-interests-form\"]/div[1]/div/div[" + career + "]"));
        click(randomCareerLevel);
        WebElement randomJobType = driver.findElement(By.xpath("//*[@id=\"career-interests-form\"]/div[2]/div/button[" + type + "]"));
        click(randomJobType);
        WebElement randomWorkPlace = driver.findElement(By.xpath("//*[@id=\"career-interests-form\"]/div[3]/div/button[" + workPlace + "]"));
        click(randomWorkPlace);
    }
    public void continueCareerData(String salary, int jobCateg){
        WebElement randomJobCateg = driver.findElement(By.xpath("//*[@class=\" css-1tci6j0\"]/div[" + jobCateg + "]"));
        click(randomJobCateg);
        sendkeys(salaryField, salary);
        click(hideSalaryCheckBox);
        click(saveAndContinueButton);
    }

}
