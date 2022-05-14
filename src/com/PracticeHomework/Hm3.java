package com.PracticeHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hm3 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        WebElement login= driver.findElement(By.cssSelector("input#txtUsername"));
        login.sendKeys("Admin");
        WebElement button=driver.findElement(By.cssSelector("input#btnLogin"));
        button.click();
        WebElement error=driver.findElement(By.cssSelector("span#spanMessage"));
        if(error.isDisplayed()){
            if (error.getText().equals("Password cannot be empty"))
                System.out.println("Correct display of error");
            else
                System.out.println("Incorrect text displayed");
        }
        else
            System.out.println("Nothing displayed");
        driver.quit();
    }
}
