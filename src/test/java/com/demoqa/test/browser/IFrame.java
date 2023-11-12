package com.demoqa.test.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class IFrame {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://demoqa.com/frames");

//        Switching to Iframe
        driver.switchTo().frame("frame1");

//        Getting text from iframe
        System.out.println("Getting text from Iframe: " + driver.findElement(By.id("sampleHeading")).getText());

//        return main page
        driver.switchTo().defaultContent();

//        From main page
        System.out.println("Getting text from Main Page: " + driver.findElement(By.xpath("//span[normalize-space() = 'Frames']")).getText());

        driver.quit();
    }
}
