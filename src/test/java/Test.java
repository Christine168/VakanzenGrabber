import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
public class Test {
    @org.testng.annotations.Test
    public void test() {
        System.out.println("Hallo Welt");
        //Befehl zum vergleich zweier Werte
        //Assert.assertEquals(2,3);
        //Zugriff auf den Chrome Browser - Webdriver wird initialisiert
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("http://google.com");
        WebElement searchField = driver.findElement(By.xpath("//input[@name='q']"));
       //driver.findElement(By.path) xpath nachlesen // finde elements input findet alle, @name findet
        searchField.sendKeys("what is love");
        WebElement searchButton = driver.findElement(By.xpath("(//input[@name='btnK'])[2]"));
        searchButton.click(); // Klick den Button

        WebElement suchFeld = driver.findElement(By.xpath("//a[@id='hero-work-link']"));
        suchFeld.click();
        Assert.assertFalse(driver.getPageSource().contains("hate"));
    }
}



