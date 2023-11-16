package com.demoqa.test.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Set;

public class Cookies {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://demoqa.com");

//        create a new cookie
        driver.manage().addCookie(new Cookie("DemoQA", "DemoQA"));
        System.out.println(driver.manage().getCookieNamed("DemoQA"));

//        Get all cookies
        Set<Cookie> cookies = driver.manage().getCookies();

        for (Cookie cookie: cookies){
            System.out.println(cookie.getName());
        }

//        delete cookie
        driver.manage().deleteCookieNamed("DemoQA");


        driver.quit();
    }
}
