package com.Alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MoreWaits {
    public static String url = "https://the-internet.herokuapp.com/dynamic_controls";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        String mainHandle = driver.getWindowHandle();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement box=driver.findElement(By.cssSelector("input[type = 'checkbox']"));
        box.click();

        WebElement remove= driver.findElement(By.cssSelector("button[onclick = 'swapCheckbox()']"));
        remove.click();

        WebElement text= driver.findElement(By.cssSelector("p#message"));
        if(text.getText().equals("It's gone!"))
            System.out.println("Correct text displayed");
        else
            System.out.println("Incorrect text displayed");

        WebElement enable= driver.findElement(By.cssSelector("button[onclick='swapInput()']"));
        if(enable.isEnabled()){
            System.out.println("Enable is enabled");
            enable.click();
        }
        else
            System.out.println("Enable is disabled");

        WebElement enterText= driver.findElement(By.cssSelector("input[type='text']"));
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(enterText));

        enterText.sendKeys("Hello World!");

        Thread.sleep(2000);
        enable.click();

        if(enable.isEnabled()){
            System.out.println("Enable is enabled");
            enable.click();
        }
        else
            System.out.println("Enable is disabled");




        driver.quit();

    }
}
