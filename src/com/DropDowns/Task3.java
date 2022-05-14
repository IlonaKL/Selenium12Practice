package com.DropDowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Task3 {
    public static String url="https://www.ebay.com/";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get(url);

        WebElement categ=driver.findElement(By.cssSelector("select[class = 'gh-sb ']"));
        Select select=new Select(categ);
        if(!select.isMultiple()){
            List<WebElement> options=select.getOptions();
            for (WebElement option: options){
                System.out.println(option.getText());
                select.selectByVisibleText("Computers/Tablets & Networking");
            }


        }
        driver.findElement(By.cssSelector("input#gh-btn")).click();
        WebElement header=driver.findElement(By.cssSelector("span[class = 'b-pageheader__text']"));
        if(header.getText().equals("Computers, Tablets & Network Hardware"))
            System.out.println("true");
        else
            System.out.println("wrong");
        System.out.println(header.getText());

        Thread.sleep(2000);
        driver.quit();
    }
}
