package com.Alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
    public static String url="https://syntaxprojects.com/dynamic-elements-loading.php";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get(url);

        WebElement start=driver.findElement(By.id("startButton"));
        start.click();

        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text() = 'Welcome Syntax Technologies']")));

        WebElement text=driver.findElement(By.xpath("//h4[text() = 'Welcome Syntax Technologies']"));
        if(text.getText().equals("Welcome Syntax Technologies"))
            System.out.println("Correct");
        else
            System.out.println("Wrong");

        driver.quit();
    }
}
