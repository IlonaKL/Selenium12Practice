package com.PracticeHomework;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.security.mscapi.CPublicKey;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TC4 {
    /*
    TC:4 --> do on selenium project
Go to http://www.uitestpractice.com/
interact with drag and drop, iframe, double click
click on home
delete one user from the table
go to the next link
click on the ajax link and wait for the text
verify that the text is displayed
go to Form
and fill out everything
go to widgets
upload any file and verify it is uploaded
go to actions and perform all the necessary actions
go to SwitchTo
work with alerts and frames
go to select
perform actions on all dropdowns
     */

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.uitestpractice.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver,20);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        Actions action = new Actions(driver);
        action.clickAndHold(draggable).moveToElement(droppable).release().build().perform();

        driver.switchTo().frame("iframe_a");
        driver.findElement(By.id("name")).sendKeys("Ilona");

        driver.switchTo().defaultContent();
        WebElement ddBtn=driver.findElement(By.xpath("//button[@name = 'dblClick']"));
        action.doubleClick(ddBtn).perform();
        driver.switchTo().alert().accept();

        driver.findElement(By.xpath("//a[text() = 'Home']")).click();
        driver.switchTo().defaultContent();


        js.executeScript("window.scrollBy(0,200)");


        boolean flag=true;
        while (flag){
            List<WebElement> tr=driver.findElements(By.xpath("//table[@class = 'table']/tbody/tr"));
            for (int i=0;i<tr.size();i++) {
                String rowText=tr.get(i).getText();
                if (rowText.contains("Ilona") && rowText.contains("Keenan")) {
                    flag=false;
                    driver.findElement(By.xpath("(//button[text() = 'EDIT'])["+i+"]")).click();
                    driver.findElement(By.xpath("//a[text() = 'Back to List']")).click();

                    driver.findElement(By.xpath("(//button[text() = 'DELETE'])["+i+"]")).click();
                    driver.findElement(By.xpath("//input[@value = 'Delete']")).click();
                    break;
                }
            }
            if(flag) {
                WebElement next=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@rel = 'next']")));
                next.click();
                Thread.sleep(2000);
                js.executeScript("window.scrollBy(0,200)");

            }
        }

        driver.findElement(By.xpath("//a[text() = 'AjaxCall']")).click();
        WebElement ajaxText=driver.findElement(By.xpath("//p[text() = '© 2022 - Testing Controls']"));
        System.out.println(ajaxText.getText());
        if(ajaxText.isDisplayed())
            System.out.println("Displayed");
        else
            System.out.println("Not Displayed");

        driver.findElement(By.xpath("//a[text() = 'Form']")).click();

        driver.findElement(By.id("firstname")).sendKeys("Ilona");
        driver.findElement(By.id("lastname")).sendKeys("Keenan");
        driver.findElement(By.xpath("(//input[@type = 'radio'])[1]")).click();
        driver.findElement(By.xpath("(//input[@type = 'checkbox'])[2]")).click();
        WebElement dd=driver.findElement(By.id("sel1"));
        Select select=new Select(dd);
        select.selectByVisibleText("Canada");

        driver.findElement(By.id("datepicker")).click();

        WebElement dob=driver.findElement(By.xpath("//select[@data-handler = 'selectMonth']"));
        Select select1=new Select(dob);
        select1.selectByVisibleText("Jan");

        WebElement year=driver.findElement(By.xpath("//select[@data-handler = 'selectYear']"));
        Select select2=new Select(year);
        select2.selectByVisibleText("1990");

        List<WebElement> dobTable = driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']/tbody/tr/td"));
        for(WebElement dobT:dobTable){
            if(dobT.getText().equals("10"))
                dobT.click();
        }

        driver.findElement(By.id("phonenumber")).sendKeys("2153551521");

        driver.findElement(By.id("username")).sendKeys("ilonalitv");

        js.executeScript("window.scrollBy(0,200)");
        driver.findElement(By.id("email")).sendKeys("ilonalitv@gmail.com");

        driver.findElement(By.id("comment")).sendKeys("blaaaa");

        driver.findElement(By.id("pwd")).sendKeys("5464yhd@@gd");

        driver.findElement(By.xpath("//button[@type= 'submit']")).click();


        driver.findElement(By.xpath("//a[text() = 'Widgets']")).click();

        driver.findElement(By.id("image_file")).sendKeys("C:\\Users\\Jormsie PC\\Desktop\\Interview.txt");

        driver.findElement(By.xpath("//input[@value = 'Upload']")).click();

        if(driver.findElement(By.xpath("//div[@class = 'ContactUs']")).getText().equals("File Successfully Uploaded"))
            System.out.println("Uploaded");
        else
            System.out.println("Not uploaded");


        driver.findElement(By.xpath("//a[text() = 'Actions']")).click();

        WebElement clickMe = driver.findElement(By.xpath("//button[text() = 'Click Me !']"));
        action.click(clickMe).perform();
        driver.switchTo().alert().accept();


        WebElement ddClickMe = driver.findElement(By.xpath("//button[text() = 'Double Click Me !']"));
        action.doubleClick(ddClickMe).perform();
        driver.switchTo().alert().accept();

        action.clickAndHold(driver.findElement(By.id("draggable"))).moveToElement(driver.findElement(By.id("droppable"))).release().build().perform();

        WebElement box=driver.findElement(By.id("div2"));
        action.moveToElement(box).build().perform();
        if(box.getAttribute("style").equals("background-color: rgb(0, 128, 0);"))
            System.out.println("color green");
        else if(box.getAttribute("value").equals("background-color: rgb(0, 0, 255);"))
            System.out.println("Color blue");
        else
            System.out.println("Wrong color");

        List<WebElement> table2=driver.findElements(By.xpath("//ol[@id = 'selectable']/li"));
        for (WebElement t:table2){
            if (t.getText().equals("6")) {
                t.click();
                break;
            }
        }


        driver.findElement(By.xpath("//a[text() = 'Switch to']")).click();

        driver.findElement(By.id("alert")).click();
        driver.switchTo().alert().accept();

        driver.findElement(By.id("confirm")).click();
        driver.switchTo().alert().dismiss();
        if(driver.findElement(By.id("demo")).getText().equals("You pressed Cancel in confirm window"))
            System.out.println("Pressed Cancel to alert");
        else if(driver.findElement(By.id("demo")).getText().equals("You pressed Ok in confirm window"))
            System.out.println("Pressed Ok to alert");
        else
            System.out.println("Didn't press anything for alert");

        driver.findElement(By.id("prompt")).click();
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("Ilona");
        promptAlert.accept();

        driver.findElement(By.xpath("//button[@data-target = '#myModal']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'modal-body']")));
        System.out.println(driver.findElement(By.xpath("//div[@class = 'modal-body']")).getText());
        driver.findElement(By.xpath("//button[text() = 'Ok']")).click();

        driver.findElement(By.id("basicAuthentication")).click();


        driver.switchTo().frame("iframe_a");
        driver.findElement(By.id("name")).sendKeys("Ilona");

        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//a[@target = 'iframe_a']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text() = 'Opens in a new window']")).click();
        Set<String> handles = driver.getWindowHandles();

        Iterator<String> it=handles.iterator();
        String mainHandle=it.next();
        String childHandle=it.next();
        driver.switchTo().window(childHandle);
        driver.close();
        driver.switchTo().window(mainHandle);



        driver.findElement(By.xpath("//a[text() = 'Select']")).click();

        WebElement ddSelect=driver.findElement(By.id("countriesSingle"));
        Select selectSelect=new Select(ddSelect);
        List<WebElement> options = selectSelect.getOptions();
        selectSelect.selectByVisibleText("China");

        WebElement multS = driver.findElement(By.id("countriesMultiple"));
        Select selectMult = new Select(multS);
        boolean isMult=selectMult.isMultiple();

        if(isMult){
            List<WebElement> opt = selectMult.getOptions();
            selectMult.selectByVisibleText("England");
            selectMult.selectByVisibleText("China");
        }
        Thread.sleep(2000);
        selectMult.deselectAll();

        driver.findElement(By.id("dropdownMenu1")).click();
        driver.findElement(By.xpath("//a[text() = 'United States of America']")).click();




        //driver.quit();
    }
}
