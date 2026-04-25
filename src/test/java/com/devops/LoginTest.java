package com.devops;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class LoginTest {

    @Test
    void test_login_with_incorrect_credentials() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("http://103.139.122.250:4000/");
        try { TimeUnit.SECONDS.sleep(3); } catch (Exception e) {}
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("qasim@malik.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("abcdefg");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        try { TimeUnit.SECONDS.sleep(5); } catch (Exception e) {}
        String pageSource = driver.getPageSource();
        assert(pageSource.contains("Invalid") || pageSource.contains("incorrect") || pageSource.contains("error"));
        driver.quit();
    }
}
