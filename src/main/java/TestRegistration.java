import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestRegistration {

    private static final String BASE_URL = "https://www.diary.ru/";
    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebDriverWait driverWait5s = new WebDriverWait(driver, 5);

        driver.get(BASE_URL);

        By linkRegister = By.xpath("//a[@data-target='#modal-register']");
        driverWait5s.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOfElementLocated(linkRegister),
                ExpectedConditions.elementToBeClickable(linkRegister)));

        driver.findElement(linkRegister).click();

        By frameRegister = By.xpath("//iframe[@id='modal-register']");
        driverWait5s.until(ExpectedConditions.visibilityOfElementLocated(frameRegister));
        driverWait5s.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameRegister));

        String login = RandomStringUtils.randomAlphabetic(8);
        By inputLoginField = By.xpath("//input[@id='usrlog']");
        driver.findElement(inputLoginField).clear();
        driver.findElement(inputLoginField).sendKeys(login);

        String password = RandomStringUtils.randomAlphanumeric(12);
        By inputPasswordField = By.xpath("//input[@id='usrpass']");
        driver.findElement(inputPasswordField).clear();
        driver.findElement(inputPasswordField).sendKeys(password);

        String email = RandomStringUtils.randomAlphanumeric(5) + "@"
                + RandomStringUtils.randomAlphanumeric(5) + ".ru";
        By inputEmailField = By.xpath("//input[@name='user_email']");
        driver.findElement(inputEmailField).clear();
        driver.findElement(inputEmailField).sendKeys(email);

        By checkConfirm = By.xpath("//input[@type='checkbox' and @name='user_confirm']");
        driver.findElement(checkConfirm).click();

      
      // ниже нужно добавить строчки для нажатия на кнопку Зарегистрироваться.
      
        System.out.println("Login: " + login);
        System.out.println("Password: " + password);
        System.out.println("Email: " + email);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
