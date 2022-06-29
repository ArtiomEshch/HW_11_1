import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestCase_Notes {
    public static void main(String[] args) {
        System.setProperty(
                "webdriver.chrome.driver", "src/main/resources/chromedriver"
        );
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.21vek.by/");

        // Test case - 1
        driver.findElement(By.xpath("//span[@class='userToolsText']")).click();
        driver.findElement(By.xpath("//button[@title='Вход']")).click();
        driver.findElement(By.xpath("//input[@label='Электронная почта']"))
                .sendKeys("maza2009i@mail.ru");
        WebElement password = driver.findElement(By.xpath("//input[@label='Пароль']"));
        password.sendKeys("UserP@ssword");
        password.submit();

        // Test case - 2
        driver.findElement(By.id("catalogSearch"))
                .sendKeys("Смартфон Apple iPhone 11 64GB / MHDA3 (черный)");
        driver.findElement(By.xpath("//button[@class='Search_searchBtn__3fSOy']"))
                .click();
        driver.findElement(By.xpath("//a[@class='result__link j-ga_track']")).click();
        driver.findElement(By.xpath("//div[@id=\"j-item-buyzone\"]//form[@class='j-to_basket']")).click();
    }
}
