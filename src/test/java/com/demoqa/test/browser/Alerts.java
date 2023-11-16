package com.demoqa.test.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Alerts {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://demoqa.com/alerts");

//        JavaScript alert
        driver.findElement(By.id("alertButton")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

//        confirmation alert
        driver.findElement(By.id("confirmButton")).click();
        Thread.sleep(3000);
        System.out.println("Confirmation Alert Message: " + driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();

        Thread.sleep(1000);

//        Prompt alert
        System.out.println(driver.findElement(By.id("promtButton")).getText());
        driver.findElement(By.id("promtButton")).click();
        driver.switchTo().alert().sendKeys("Please Confirm!!!");
        driver.switchTo().alert().accept();

        Thread.sleep(3000);



//        javascript alert
        driver.findElement(By.id("alertButton")).click();

//        Optimization and alert object creation
        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);
        alert.accept();

//        Confirmation alert
        driver.findElement(By.id("confirmButton")).click();
        System.out.println("Confirmation Alert Message: " + alert.getText());
        alert.dismiss();
        Thread.sleep(3000);

////        prompt alert
        driver.findElement(By.id("promtButton")).click();
        Alert alert2 = driver.switchTo().alert();
        alert2.sendKeys("Please Confirm!!!");
        alert2.accept();
        Thread.sleep(3000);


        driver.quit();
    }
}
