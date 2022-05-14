package com.PracticeHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestNG {
    /*
    HW: TestNG and use assertions
TC 1: HRMS blank password validation
Navigate to "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login"
Enter valid username and leave password field empty
Click on login button
Verify error message with text "Password cannot be empty" is displayed
     */

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("btnLogin")).click();

        WebElement error=driver.findElement(By.id("spanMessage"));
        if(error.isDisplayed()){
            if(error.getText().equals("Password cannot be empty"))
                System.out.println("Displayed and correct");
            else
                System.out.println("Displayed wrong");
        }
        else
            System.out.println("Not displayed");

    }
}
