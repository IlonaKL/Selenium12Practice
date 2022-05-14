package com.PracticeHomework;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HelpStudent {
    public static String url = "https://aa.com/homePage.do";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement departureBox = driver.findElement(By.id("reservationFlightSearchForm.originAirport"));
        departureBox.clear();
        departureBox.sendKeys("SFO", Keys.ARROW_DOWN);  //add Keys.ARROW_DOWN
        WebElement arrivalBox = driver.findElement(By.id("reservationFlightSearchForm.destinationAirport"));
        arrivalBox.sendKeys("YYZ", Keys.ARROW_DOWN);  //add Keys.ARROW_DOWN

        WebElement passengerSelectBox = driver.findElement(By.id("flightSearchForm.adultOrSeniorPassengerCount"));
        Select select = new Select(passengerSelectBox);
        select.selectByValue("3");

        WebElement departureCalender = driver.findElement(By.className("ui-datepicker-trigger"));
        departureCalender.click();
        WebElement nextbutton = driver.findElement(By.xpath("//a[@aria-label='Next Month']"));

        WebElement depMonth = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'][1])"));
        String depMonthText = depMonth.getText();
        while (!depMonthText.equals("September")) {
            nextbutton.click();
            nextbutton = driver.findElement(By.xpath("//a[@aria-label='Next Month']"));    // remind the program what elements it needs to find, this case it the next button
            depMonth = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'][1])")); // remind the program what elements it needs to find, this case it the month
            depMonthText = depMonth.getText();
        }

        List<WebElement> departureDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr/td"));
        for (WebElement departureDate : departureDates) {
            if (departureDate.getText().equals("20")) {
                departureDate.click();
                break;
            }
        }

        driver.findElement(By.xpath("(//button[@class = 'ui-datepicker-trigger'])[2]")).click(); // click on the calendar button again

        WebElement returnMonth = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'][1])"));
        String retMonthText = returnMonth.getText();
        nextbutton = driver.findElement(By.xpath("//a[@aria-label='Next Month']")); //again have to remind the next button element

        while (!retMonthText.equals("November")) {
            nextbutton.click();
            nextbutton = driver.findElement(By.xpath("//a[@aria-label='Next Month']"));   //// again remind the program what elements it needs to find, this case it the next button
            returnMonth = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]"));  // again remind the program what elements it needs to find, this case it the month
                                                                              //also i've corrected your xpass, bracket needed to be before [1] not after
                                                                                //also [1] corrected from [2] because then it will pick the date in the right table and it will be a wrong month
            retMonthText = returnMonth.getText();
        }

        List<WebElement> arrivalDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr/td"));
        for (WebElement arrivalDate : arrivalDates) {
            if (arrivalDate.getText().equals("15")) {
                arrivalDate.click();
                break;
            }
        }
        //Thread.sleep(2000);  just for me so that i could see if the program picked correct dates
        WebElement searchButton = driver.findElement(By.id("flightSearchForm.button.reSubmit"));
        searchButton.click();
        driver.quit();
    }
}
