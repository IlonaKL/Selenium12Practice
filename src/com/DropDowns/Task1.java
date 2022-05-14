package com.DropDowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Collections;
import java.util.List;

public class Task1 {

    public static String url="https://www.facebook.com/";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get(url);
        WebElement create=driver.findElement(By.cssSelector("a[class = \"_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy\"]"));
        create.click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("input[name = 'firstname']")).sendKeys("Ilona");
        driver.findElement(By.cssSelector("input[name = 'lastname']")).sendKeys("Keenan");
        driver.findElement(By.cssSelector("input[name = 'reg_email__']")).sendKeys("2444");
        driver.findElement(By.cssSelector("input[name = 'reg_passwd__']")).sendKeys("14476bhhb435");


        WebElement dMonth=driver.findElement(By.cssSelector("select#month"));
        Select select=new Select(dMonth);
        if(!select.isMultiple()){
            List<WebElement> month=select.getOptions();
            System.out.println("Month= "+month.size());
            for (WebElement i: month){
                System.out.println(i.getText());
            }
        }

        WebElement dDate=driver.findElement(By.cssSelector("select#day"));
        Select select1=new Select(dDate);
        if(!select1.isMultiple()){
            List<WebElement> date=select1.getOptions();
            System.out.println("Date= "+date.size());
        }

        WebElement dYear=driver.findElement(By.cssSelector("select#year"));
        Select select2=new Select(dYear);
        if(!select2.isMultiple()){
            List<WebElement> year=select2.getOptions();
            System.out.println("Year= "+year.size());
        }

        select.selectByVisibleText("Jan");
        select1.selectByValue("10");
        Thread.sleep(2000);
        select2.selectByValue("1990");

        List<WebElement> dGender= driver.findElements(By.cssSelector("span[class= '_5k_2 _5dba']"));
        for (WebElement option: dGender){
            String value=option.getText();
            if(value.equals("Female")) {
                option.click();
                break;
            }
        }

        driver.findElement(By.cssSelector("button[class= '_6j mvm _6wk _6wl _58mi _3ma _6o _6v']")).click();
        Thread.sleep(2000);
        driver.quit();
    }
}
