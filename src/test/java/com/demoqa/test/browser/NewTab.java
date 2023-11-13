package com.demoqa.test.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class NewTab {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://demoqa.com/browser-windows");

//        storing a window in a variable
        String originalWindow = driver.getWindowHandle();

        driver.findElement(By.cssSelector("#tabButton")).click();
        Thread.sleep(3000);

//        switching to new window
        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(3000);

//        get the new window link
        driver.get("https://demoqa.com/sample");

//        getting text from new window
        System.out.println("Getting text from new tab: " + driver.findElement(By.cssSelector("#sampleHeading")).getText());

//        closing new window
        driver.close();

//        return to main window
        driver.switchTo().window(originalWindow);

        System.out.println("Text from main window: " + driver.findElement(By.cssSelector("#messageWindowButton")).getText());

        driver.quit();

    }
}
