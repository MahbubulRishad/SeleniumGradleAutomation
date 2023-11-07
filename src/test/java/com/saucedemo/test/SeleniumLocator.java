package com.saucedemo.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class SeleniumLocator {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

//        id
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

//        name
        driver.findElement(By.name("password")).sendKeys("secret_sauce");

//        xpath
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();

//        ClassName
        List<WebElement> webElements = driver.findElements(By.className("inventory_item_name"));
        for (WebElement element : webElements) {
            System.out.println(element.getText());
        }

//        LinkText
        String linkText = driver.findElement(By.linkText("Sauce Labs Backpack")).getText();
        System.out.println(linkText);

//        PartialLinkText
//        String partialLinkText = driver.findElement(By.linkText("Fleece")).getText();
//        System.out.println(partialLinkText);

//        TagName
        List<WebElement> aTag = driver.findElements(By.tagName("a"));
        for (WebElement a : aTag) {
            System.out.println(a.getText());
        }

//        CssSelector
        driver.findElement(By.cssSelector("[data-test=\"add-to-cart-sauce-labs-backpack\" ]"))
                .click();


        driver.quit();
    }
}
