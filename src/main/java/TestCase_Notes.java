import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase_Notes {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(
                "webdriver.chrome.driver", "src/main/resources/chromedriver"
        );
        WebDriver driver = new ChromeDriver();
        driver.get("https://diary.ru/user/login");

        // Test case - 1
        driver.findElement(By.xpath("//div [@class='form-group field-loginform-recaptcha'] ")).click();
        driver.findElement(By.id("loginform-username")).sendKeys("AY_AQA");
        Thread.sleep(10000); // 10 секунд ожидания для прохождения капчи вручную
        driver.findElement(By.id("loginform-password")).sendKeys("JAVA2022");
        driver.findElement(By.xpath("//button [@id='login_btn']")).click();

        // Test case - 2
        WebElement newRecord = (new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li [@id='writeThisDiary']"))));
        newRecord.click();

        WebElement title = (new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input [@id='postTitle']"))));
        title.sendKeys("Test");

        WebElement message = (new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("body#tinymce"))));
        message.sendKeys("Test text");

        WebElement submit = (new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input [@id='rewrite']"))));
        submit.click();
    }
}
