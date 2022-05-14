package com.Alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesReview {
    public static String url="https://chercher.tech/practice/frames";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        driver.switchTo().frame("frame1");
        driver.switchTo().frame("frame3");

        driver.findElement(By.cssSelector("input#a")).click();
        Thread.sleep(2000);
        driver.switchTo().defaultContent();

        driver.quit();
    }
}
