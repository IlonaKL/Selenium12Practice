package com.Alerts;

import com.sun.glass.ui.Window;
import com.sun.javafx.event.EventHandlerManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Alerts {
    public static String url = "https://demoqa.com/browser-windows";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        String mainHandle = driver.getWindowHandle();

        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement newTab = driver.findElement(By.id("tabButton"));
        WebElement newWindow=driver.findElement(By.id("windowButton"));
        WebElement newWM=driver.findElement(By.id("messageWindowButton"));

        newTab.click();
        newWindow.click();
        newWM.click();

        /*WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("messageWindowButton")));
        */



        Set<String> handles=driver.getWindowHandles();
        Iterator<String> iterator=handles.iterator();
        while (iterator.hasNext()) {
            String i=iterator.next();
            driver.switchTo().window(i);
            if(!mainHandle.equals(i)) {
                WebElement text=driver.findElement(By.xpath("//body"));
                System.out.println(text.getText());
            }
            String  title=driver.getTitle();
            if(title.isEmpty()){
                System.out.println("Empty");
            }
            else
                System.out.println(title);

        }
        driver.close();
    }}
