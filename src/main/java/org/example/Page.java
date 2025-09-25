package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page {
    WebDriver driver;
    By username;
    By password;
    By loginButton;

    public Page(WebDriver driver) {
        this.driver = driver;
        username = By.id("user-name");
        password = By.id("password");
        loginButton = By.id("login-button");
    }
    public void login() {
        driver.findElement(username).sendKeys("standard_user");
        driver.findElement(password).sendKeys("secret_sauce");
        driver.findElement(loginButton).click();
    }
}
