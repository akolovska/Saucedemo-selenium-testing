import org.example.Page;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TestMain {
    WebDriver driver;
    Page page;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        page = new Page(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void addToCart() {
        page.login();
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        driver.findElement(By.className("shopping_cart_link")).click();
        assertEquals(2, driver.findElements(By.className("cart_item")).size());
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("name");
        driver.findElement(By.id("last-name")).sendKeys("surname");
        driver.findElement(By.id("postal-code")).sendKeys("1000");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();
        assertTrue(driver.findElement(By.className("complete-text")).isDisplayed());
    }

}
