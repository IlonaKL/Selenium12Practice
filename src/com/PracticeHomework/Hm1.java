package com.PracticeHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hm1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/loginv");
        WebElement login=driver.findElement(By.cssSelector("input#txtUsername"));
        Thread.sleep(2000);
        login.sendKeys("Admin");
        WebElement password=driver.findElement(By.cssSelector("input#txtPassword"));
        Thread.sleep(2000);
        password.sendKeys("Hum@nhrm123");
        WebElement button=driver.findElement(By.cssSelector("input#btnLogin"));
        button.click();
        WebElement logo=driver.findElement(By.cssSelector("img[width='283']"));
        System.out.println(logo.isDisplayed());
        driver.quit();
    }
}
