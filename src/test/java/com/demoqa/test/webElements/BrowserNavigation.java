package com.demoqa.test.webElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BrowserNavigation {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://demoqa.com/text-box");

//        Navigation
        driver.navigate().to("https://demoqa.com/checkbox");
        Thread.sleep(2000);

//        back to previous link
        driver.navigate().back();
        Thread.sleep(2000);

//        forward the link
        driver.navigate().forward();
        Thread.sleep(2000);

//        refresh the web page
        driver.navigate().refresh();
        Thread.sleep(2000);

        driver.quit();
    }
}
