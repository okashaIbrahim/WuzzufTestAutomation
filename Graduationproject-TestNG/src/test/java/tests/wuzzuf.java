package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

public class wuzzuf extends testBase {
    registerPage reg;
    careerPage career;
    generalInfoPage general;
    personalInfoPage personal;
    searchPage search;
    SoftAssert soft;


    @Test(priority = 1)
    public void searchForAJob() throws InterruptedException {
        reg = new registerPage(driver);
        career = new careerPage(driver);
        general = new generalInfoPage(driver);
        personal = new personalInfoPage(driver);
        search = new searchPage(driver);
        faker = new Faker();
        soft = new SoftAssert();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        String jobTitle = faker.job().title();

        reg.goToRegisterPage();
        reg.createAccount(firstName, lastName, email, password, jobTitle);
        soft.assertEquals(reg.getCareerInterestText().toLowerCase(), "career interests", "wrong");
        int careerLevel = faker.number().numberBetween(1, career.getCareerLevelSize() + 1);
        System.out.println(careerLevel);
        int jobType = faker.number().numberBetween(1, career.getJobTypesSize() + 1);
        System.out.println(jobType);
        int workPlace = faker.number().numberBetween(1, career.getWorkPlaceSize() + 1);
        System.out.println(workPlace);
        career.fillCareerInterestsData(careerLevel, jobType, workPlace);

        int jobCateg = faker.number().numberBetween(1, career.getJobCategoriesSize() + 1);
        System.out.println(jobCateg);
        career.continueCareerData("10000", jobCateg);
        Thread.sleep(1000);
        soft.assertEquals(general.getGeneralInfoText().toLowerCase(), "general info", "wrong");

        int day = faker.number().numberBetween(1, general.getDayNumber());
        int month = faker.number().numberBetween(1, general.getMonthNumber());
        int year = faker.number().numberBetween(1, general.getYearNumber());
        System.out.println("random day " + day);
        System.out.println("random month " + month);
        System.out.println("random year " + year);

        System.out.println("days size " + general.getDayNumber());
        System.out.println("months size " + general.getMonthNumber());
        System.out.println("years size " + general.getYearNumber());

        general.fillGeneralInfoData(day, month, year);
        general.continueGeneralData(faker.number().numberBetween(1, general.getNationalitysize() + 1));
        general.continueGeneralData2(faker.number().numberBetween(1, general.getCountriesSize() + 1));
        general.continueGeneralData3("01123465789", faker.number().numberBetween(1, general.getCitySize() + 1));
        Thread.sleep(1000);
        soft.assertEquals(personal.getProfInfoText().toLowerCase(), "professional info", "wrong");

        personal.fillProfInfo();
        int eduLevel;
        do {
            eduLevel = faker.number().numberBetween(1, personal.getEduLevelSize() + 1);
        } while (eduLevel == 4);
        personal.eduLevel(eduLevel, "Engineering", "Cairo University");
        personal.degreeTime(faker.number().numberBetween(9, 19));
        personal.grade(faker.number().numberBetween(1, personal.getGradeSize() + 1));
        personal.language(faker.number().numberBetween(1, personal.getLanguageSize() + 1));
        personal.continueProfInfo2(faker.number().numberBetween(1, personal.getProficiencySize() + 1), "Testing", "Automation");
        search.enterDataInSearchField("Software Engineer");
        Thread.sleep(3000);
        for (int i = 1; i < search.relatedjobs() + 1; i++) {
            String jobtitle = driver.findElement(By.xpath("//*[@class=\"css-1gatmva e1v1l3u10\"][" + i + "]/div/div[1]/h2/a")).getText();
            System.out.println(jobtitle);
            soft.assertTrue(jobtitle.toLowerCase().contains("software"), "wrong job");
        }
        soft.assertTrue(driver.findElement(By.xpath("//*[@class=\"css-xkh9ud\"]")).isDisplayed(), "Search result text is not displayed.");
        Thread.sleep(1000);
        search.filter();
        Thread.sleep(2000);
        System.out.println("number of all jobs" + search.numberOfJobs());
        search.applyToFirstJob();
        soft.assertAll();
    }

}
