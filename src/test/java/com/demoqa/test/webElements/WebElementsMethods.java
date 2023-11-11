package com.demoqa.test.webElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class WebElementsMethods {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        driver.get("https://demoqa.com/checkbox");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

//        Checking web element is available or not -- isDisplayed()
        System.out.println("Text Box is available: " + driver.findElement(By.className("rct-checkbox")).isDisplayed()); // true/false

//        Checking web element is enabled or disabled -- isEnabled()
        System.out.println("Text Box is Enable: " + driver.findElement(By.className("rct-checkbox")).isEnabled()); // true/false

//        Checking web element is selected or not -- isSelected()
        System.out.println("Text Box is Selected: " + driver.findElement(By.className("rct-icon-uncheck")).isSelected()); // true/false

//        get Tag name
        System.out.println("The Tag name is : " + driver.findElement(By.className("rct-title")).getTagName()); // printed the associated HTML tag

//        get CSS Property's value
        System.out.println("CSS Specific Property's value: " + driver.findElement(By.className("rct-title")).getCssValue("padding")); // will print the css value
        System.out.println("CSS Specific Property's value: " + driver.findElement(By.className("rct-title")).getCssValue("font-size")); // will print the css value


//        Getting value from Tag/Attribute
        System.out.println("Getting value from Tag/Attribute: " + driver.findElement(By.className("rct-title")).getAttribute("class"));

        driver.quit();
    }
}
