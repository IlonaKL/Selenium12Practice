package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class HomeWorkBank {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22");
        driver.findElement(By.id("customer.firstName")).sendKeys("Ilona");
        driver.findElement(By.id("customer.lastName")).sendKeys("Keenan");
        driver.findElement(By.id("customer.address.street")).sendKeys("12 Valley Run Rd");
        driver.findElement(By.id("customer.address.city")).sendKeys("Sewell");
        driver.findElement(By.id("customer.address.state")).sendKeys("PA");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("08080");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("267-306-7409");
        driver.findElement(By.id("customer.ssn")).sendKeys("1234567890");
        driver.findElement(By.id("customer.username")).sendKeys("ilonaK");
        driver.findElement(By.id("customer.password")).sendKeys("thisIsMyPassword");
        driver.findElement(By.id("repeatedPassword")).sendKeys("thisIsMyPassword");
        Thread.sleep(2000);
        driver.findElement(By.className("button")).click();
        driver.quit();
    }
}
