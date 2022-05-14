package com.Alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {
    public static String url="https://syntaxprojects.com/javascript-alert-box-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement b1 = driver.findElement(By.cssSelector("button[class = 'btn btn-default']"));
        b1.click();
        Thread.sleep(2000);

        Alert a=driver.switchTo().alert();
        a.accept();
        Thread.sleep(2000);

        WebElement b2=driver.findElement(By.cssSelector("button[onclick = 'myConfirmFunction()']"));
        b2.click();
        Thread.sleep(2000);

        a=driver.switchTo().alert();
        String aText=a.getText();
        System.out.println(aText);
        a.dismiss();
        Thread.sleep(2000);

        WebElement b3= driver.findElement(By.cssSelector("button[onclick = 'myPromptFunction()']"));
        b3.click();
        Thread.sleep(2000);

        a=driver.switchTo().alert();
        a.sendKeys("Ilona");
        Thread.sleep(2000);
        a.accept();
        Thread.sleep(2000);

        driver.quit();
    }
}
