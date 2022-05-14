package com.Calendar;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Airlines {

    /*
    Go to aa.com/homePage.do
    select depart date
    select return date
    select destination
    click on search
    quit the browser
     */

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.aa.com/homePage.do");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//label[@for= 'aa-leavingOn']/following-sibling::button")).click();

        boolean flag = true;
        while (flag){
            WebElement month = driver.findElement(By.xpath("(//span[@class = 'ui-datepicker-month'])[1]"));
            if(!month.getText().equals("August")){
                driver.findElement(By.xpath("//a[@aria-label = 'Next Month']")).click();
            }
            else
            {
                List<WebElement> rows = driver.findElements(By.xpath("(//table)[1]/tbody/tr/td"));
                for(WebElement row:rows){
                    if(row.getText().equals("12")){
                        flag=false;
                        row.click();
                        break;
                    }
                }
            }
        }
        driver.findElement(By.xpath("(//button[@class = 'ui-datepicker-trigger'])[2]")).click();


        boolean flag1 = true;
        while (flag1){
            WebElement month = driver.findElement(By.xpath("(//span[@class = 'ui-datepicker-month'])[1]"));
            if(!month.getText().equals("September")){
                driver.findElement(By.xpath("//a[@aria-label = 'Next Month']")).click();
            }
            else
            {
                List<WebElement> rows = driver.findElements(By.xpath("(//table)[1]/tbody/tr/td"));
                for(WebElement row:rows){
                    if(row.getText().equals("25")){
                        flag1=false;
                        row.click();
                        break;
                    }
                }
            }
        }

        driver.findElement(By.id("reservationFlightSearchForm.destinationAirport")).sendKeys("tpa", Keys.ENTER);

        driver.quit();
    }
}


