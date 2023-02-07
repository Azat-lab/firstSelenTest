package by.azatselentest.com;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MainPage {

    public static void main(String[] args) {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.gecko.driver", "C:\\webdrivers\\geckodriver.exe");
        //создание экземпляра драйвера
        WebDriver driver = new FirefoxDriver();
        //сайт который мы посещаем
        driver.get("http://litecart.stqa.ru/en/");
        //окно разворачивается полностью
        driver.manage().window().maximize();
        // задержка выполнения теста на 5сек
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Actions actions = new Actions(driver);


        //откроет страницу с кравной уткой
        WebElement redDuckButton = driver.findElement(By.xpath("//a[@class='link' and @href='http://litecart.stqa.ru/en/rubber-ducks-c-1/red-duck-p-3']"));
        redDuckButton.click();

        //после открытия предыдущей перейдет в главное меню
        WebElement homeButton =driver.findElement(By.xpath("//a[@href='http://litecart.stqa.ru/en/'][1]"));
        homeButton.click();

        //перейдет по логотипу обратно на главную сайта
        WebElement checkLogotype = driver.findElement(By.xpath("//img[contains(@src, '/images/logotype.png')][contains(@alt, 'My Store')]"));
        checkLogotype.click();

        //Проверит активные ли кнопки
        WebElement buttonDucks = driver.findElement(By.xpath("//li[@class='category-1']//a[@href='http://litecart.stqa.ru/en/rubber-ducks-c-1/'][1]"));
        WebElement homeButton2 =driver.findElement(By.xpath("//a[@href='http://litecart.stqa.ru/en/'][1]"));
        System.out.println(buttonDucks.isEnabled());
        System.out.println(homeButton2.isEnabled());

        //после ввода в поисковой строке нажмет Enter
        WebElement searchInput = driver.findElement(By.xpath("//div[@class='input-wrapper']//input[@type='search']"));
        searchInput.sendKeys("Red Duck");
        searchInput.sendKeys(Keys.ENTER);

        //выбор элемента в корзину
        WebElement addCartButton = driver.findElement(By.xpath("//button[@type='submit' and @name='add_cart_product']"));
        actions.clickAndHold(addCartButton).moveToElement(addCartButton).release().build().perform();
        //addCartButton.click();

        WebElement clickImitation = driver.findElement(By.xpath("//a[@href='#tab-details']"));
        actions.clickAndHold(clickImitation).moveToElement(clickImitation).release().build().perform();
    }

}

