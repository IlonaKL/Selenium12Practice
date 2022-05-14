package com.Alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
        public static String url="https://syntaxprojects.com/bootstrap-iframe.php";

        public static void main(String[] args) throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
            WebDriver driver=new ChromeDriver();
            driver.get(url);

            if(driver.getTitle().equals("AUTOMATION TESTING PLATFORM BY SYNTAX"));
            System.out.println("True");

            WebElement display=driver.findElement(By.cssSelector("a[href = 'index.php']"));
            if (display.isDisplayed())
                System.out.println("Displayed");

            Thread.sleep(2000);

            driver.switchTo().frame(1);

            //Alert alert=driver.switchTo().alert();
            //alert.dismiss();

            WebElement enrol=driver.findElement(By.xpath("//p[@class= 'paragraph']/following-sibling::a"));
            if(enrol.isEnabled())
                System.out.println("Enabled");
            else
                System.out.println("Not");

            driver.switchTo().defaultContent();

            driver.quit();
    }
}
