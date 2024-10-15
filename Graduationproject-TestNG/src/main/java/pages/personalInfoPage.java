package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class personalInfoPage extends base {
    public personalInfoPage(WebDriver driver) {
        super(driver);
    }

    final protected By experienceYearsField = By.xpath("//*[@class=\"section-validation-error css-1h480x3 e1v1l3u10\"]//*[@class=\" css-1hwfws3\"]");
    final protected By experienceOption = By.xpath("//*[@class=\" css-1tci6j0\"]//div[1]");
    final protected By educationalOptions = By.xpath("//*[@id=\"work-experience-form\"]/div[2]/div[1]/div");
    final protected By studyField = By.xpath("//*[@class=\"css-1a96k50 ek82ord0\"]");
    final protected By universityField1 = By.xpath("//*[@class=\"section-validation-error css-6hend0 e1v1l3u10\"]/div[2]/div[2]/div[1]/div/div[2]");
    final protected By universityField2 = By.xpath("//div[@class='css-rzjfos']/div[2]/div//input");
    final protected By cairoUnivOption = By.xpath("//*[@class=\" css-1tci6j0\"]//div[1]");
    final protected By degreeDateField = By.xpath("//*[@class=\"css-1fttcpj e6pv2vl2\"]/div[3]/div/div/div");
    final protected By degreeDateOption = By.xpath("//*[@class=\" css-1tci6j0\"]/div[10]");
    final protected By gradeField = By.xpath("//*[@class=\"css-1fttcpj e6pv2vl2\"]/div[5]/div/div");
    final protected By gradeOptions = By.xpath("//*[@class=\" css-1tci6j0\"]");
    final protected By languageField = By.xpath("//*[@class=\"css-1xrefku e6pv2vl1\"]/div[1]/div/div[2]");
    final protected By languageOptions = By.xpath("//*[@class=\" css-1tci6j0\"]/div");
    final protected By proficiencyField = By.xpath("//*[@class=\"css-1xrefku e6pv2vl1\"]/div[2]/div/div[2]");
    final protected By proficiencyoptions = By.xpath("//*[@class=\" css-1tci6j0\"]/div");
    final protected By addButton = By.xpath("//*[@class=\"css-ksyb00 ezfki8j0\"]");
    final protected By skillField = By.xpath("//*[@class=\"section-validation-error css-6hend0 e1v1l3u10\"][2]//*[@class=\" css-1hwfws3\"]");
    final protected By skillField1 = By.xpath("//*[@class=\"section-validation-error css-6hend0 e1v1l3u10\"]//*[@class=\" css-1hwfws3\"]");
    final protected By skillField2 = By.xpath("//*[@class=\"section-validation-error css-6hend0 e1v1l3u10\"]/div/div/div/div[1]//input");
    final protected By swTestingOption = By.xpath("//*[@class=\" css-1tci6j0\"]/div[1]");
    final protected By automationOption = By.xpath("//*[@class=\" css-1tci6j0\"]/div[6]");
    final protected By getStartedButton = By.xpath("//*[@class=\"css-1wj05oe ezfki8j0\"]");
    final protected By professionalInfoText = By.xpath("//*[@class=\"css-a3j4hb\"]");
    final protected By test = By.xpath("");

    public String getProfInfoText() {
        return driver.findElement(professionalInfoText).getText();
    }

    public void fillProfInfo() {
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        //wait.until(ExpectedConditions.elementToBeClickable(experienceYearsField));
        click(experienceYearsField);
    }

    public int getEduLevelSize() {
        return driver.findElements(educationalOptions).size();
    }

    public void eduLevel(int eduLevel, String study, String university) {
        click(experienceOption);
        By randomEduLevel = By.xpath("//*[@id=\"work-experience-form\"]/div[2]/div[1]/div[" + eduLevel + "]");
        click(randomEduLevel);
        sendkeys(studyField, study);
        sendkeys(universityField2, university);
    }

    public void degreeTime(int time) {
        click(degreeDateField);
        By randomDegreeTime = By.xpath("//*[@class=\" css-1tci6j0\"]/div[" + time + "]");
        click(randomDegreeTime);
    }

    public int getGradeSize() {
        return driver.findElements(gradeOptions).size();
    }

    public void grade(int grade) {
        click(gradeField);
        By randomGrade = By.xpath("//*[@class=\" css-1tci6j0\"]/div[" + grade + "]");
        click(randomGrade);
    }

    public int getLanguageSize() {
        click(languageField);
        return driver.findElements(languageOptions).size();
    }

    public void language(int language) {
        By randomLanguage = By.xpath("//*[@class=\" css-1tci6j0\"]/div[" + language + "]");
        click(randomLanguage);
    }

    public int getProficiencySize() {
        click(proficiencyField);
        return driver.findElements(proficiencyoptions).size();
    }

    public void continueProfInfo2(int proficiency, String skill1, String skill2) throws InterruptedException {
        By randomProficiency = By.xpath("//*[@class=\" css-1tci6j0\"]/div[" + proficiency + "]");
        click(randomProficiency);
        click(addButton);
        //click(skillField);
        Thread.sleep(2000);
        sendkeys(skillField2, skill1);
        click(swTestingOption);
        //click(skillField2);
        Thread.sleep(2000);
        sendkeys(skillField2, skill2);
        click(automationOption);
        click(getStartedButton);
        //click(cairoUnivOption);
        //click(universityField1);


        //click(degreeDateField);
        //click(degreeDateOption);
        //click(gradeField);
        //click(gradeOption);
        //click(languageField);
        //click(languageOption);
        //click(proficiencyField);
        //click(proficiencyoption);


    }

}


