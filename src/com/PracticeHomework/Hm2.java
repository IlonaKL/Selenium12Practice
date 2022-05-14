package com.PracticeHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Hm2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.com/");
        List<WebElement> allLinks=driver.findElements(By.tagName("a"));
        int size=0;
        for (WebElement link: allLinks){
            String linkText=link.getText();
            if (!linkText.isEmpty()){
                System.out.println(linkText);
                size++;
            }
        }
        System.out.println("Size of not empty link list is "+size);
        driver.quit();
    }
}
