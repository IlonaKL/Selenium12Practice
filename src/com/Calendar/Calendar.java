package com.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Calendar {
        public static String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";

        public static void main(String[] args) throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get(url);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            driver.findElement(By.id("txtUsername")).sendKeys("Admin");
            driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
            driver.findElement(By.id("btnLogin")).click();
            driver.findElement(By.xpath("//b[text() = 'Leave']")).click();
            driver.findElement(By.id("menu_leave_viewLeaveList"));
            driver.findElement(By.id("calFromDate")).click();

            WebElement months = driver.findElement(By.cssSelector("select[class = 'ui-datepicker-month']"));
            Select select = new Select(months);
            select.selectByVisibleText("Aug");

            List<WebElement> dates = driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']/tbody/tr/td"));
            for(WebElement date:dates){
                if(date.getText().equals("11")){
                    date.click();
                    break;
                }
            }

            driver.findElement(By.id("calToDate")).click();

            WebElement toMonths = driver.findElement(By.cssSelector("select[class = 'ui-datepicker-month']"));
            Select selectTo = new Select(toMonths);
            selectTo.selectByVisibleText("Sep");

            List<WebElement> datesTo = driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']/tbody/tr/td"));
            for(WebElement dateTo: datesTo){
                if (dateTo.getText().equals("20")){
                    dateTo.click();
                    break;
                }
            }
            driver.findElement(By.id("leaveList_chkSearchFilter_-1")).click();
            driver.findElement(By.id("leaveList_chkSearchFilter_0")).click();

            WebElement pending = driver.findElement(By.id("leaveList_chkSearchFilter_1"));
            if(pending.isSelected()){
                pending.click();
            }

            WebElement subUnit = driver.findElement(By.id("leaveList_cmbSubunit"));
            Select selectSub = new Select(subUnit);
            selectSub.selectByVisibleText("IT Support");

            driver.findElement(By.id("btnSearch")).click();

            driver.quit();

    }
}
