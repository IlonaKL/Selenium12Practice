package com.PracticeHomework;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class HM_ScreenShot {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/loginv");
        WebElement login=driver.findElement(By.cssSelector("input#txtUsername"));
        login.sendKeys("Admin");
        WebElement password=driver.findElement(By.cssSelector("input#txtPassword"));
        password.sendKeys("Hum@nhrm123");
        WebElement button=driver.findElement(By.cssSelector("input#btnLogin"));
        button.click();

        driver.findElement(By.xpath("//b[text() = 'PIM']")).click();
        driver.findElement(By.id("ohrmList_chkSelectRecord_32346")).click();

        TakesScreenshot ts = (TakesScreenshot) driver;
        File tsFile = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(tsFile, new File("src/com/PracticeHomework/ScreenShots/screenShot1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
