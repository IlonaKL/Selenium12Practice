package com.PracticeHomework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.safari.SafariDriver;

import java.util.ArrayList;


//open new browser
//open a new tab
//navigate to a different URL on a new tab

public class HWNewTab {

    public static void main(String[] args) {
        String url="https://www.google.com/";
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('about:blank','_blank');");

        ArrayList<String> handles=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));
        driver.get(url);

    }
}
