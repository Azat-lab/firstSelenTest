package by.azatselentest.com;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;




class MainPageTest {
    //определение пути до драйвера и его настройка
    //создание экземпляра драйвера
    // задержка выполнения теста на 5сек
    //окно разворачивается полностью

    public static WebDriver driver;
    private static WebElement element;

    @BeforeAll
    static void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\webdrivers\\geckodriver.exe");
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://litecart.stqa.ru/en/");
    }
    @Test
    public void homePageTest(){
        System.out.println("Starting web page test");
        driver.get("http://litecart.stqa.ru/en/");
        driver.findElement(By.xpath("//a[@class='link' and @href='http://litecart.stqa.ru/en/rubber-ducks-c-1/red-duck-p-3']")).click();

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }


}