import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By; //Identifikationstyp xpath, oder class name, id  etc.
import org.openqa.selenium.WebElement; //das identifizierte Element funktionen ausführen zB klick

import java.util.List;

public class VakanzenGrabber {

    @org.testng.annotations.Test // Ausführbarkeit von der Funktion als Test

    public void vakanzenGrabben (){

        String url = "https://www.freelance.de";
        String suchBegriff = "Test";

        // "//*[@id='__search']//input[@name= '__search_freetext']"

        //Passenden WebDriverManger für Chrome finden und setup
        WebDriverManager.chromedriver().setup();

        //Webdriver initialisieren:

        WebDriver wd = new ChromeDriver(); // Browser wir auto geöffnet

       wd.manage().window().maximize();
    wd.navigate().to(url);
        WebElement suchfeld = wd.findElement(By.xpath( "(//*[@id='__search']//input[@name= '__search_freetext'])[1]"));
        suchfeld.sendKeys(suchBegriff);
       // suchButton.click();

     //   WebElement suchButton = wd.findElement(By.xpath( "//*[@id='__search']//input[@name= '__search_freetext']/..//button"));
        // WebElement suchButton = wd.findElement(By.xpath( "//*[@id='__search']//input[@name= '__search_freetext']/..//button[@id='_search']"));
        //( " //*[@id='_search_simple'][0]")); ////*[@id="_search_simple"]/span[2]
      //   wd.close();

        // Alle ELemente
        List<WebElement> ListeSuchergebnisse = wd.findElements(By.xpath("//div[@class='project-list']/*"));

        System.out.println(ListeSuchergebnisse.size());
        for (WebElement ErgebnisBlock: ListeSuchergebnisse) {
            WebElement suchJobTitel =ErgebnisBlock.findElement(By.xpath(".//h3/a"));;
            suchJobTitel.click();
/*            try {
                wd.wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
 */
            wd.navigate().back();
        }

/*            for (int i=0; i<ListeSuchergebnisse.size(); i++) {
    //        WebElement suchJobtitel = wd.findElement(By.xpath("(//*[contains(@id,\"project_link\")])[" + i + "]"));
            WebElement ErgebnisBLock =  ListeSuchergebnisse.get(i);
            ErgebnisBLock.click();
            wd.navigate().back();
            // Speichere Daten dieser Seite
            // Gehe zurück auf Ergebnissseite
*/


  /*      for (int i=1; i<10; i++) {
            WebElement suchJobtitel = wd.findElement(By.xpath("(//*[contains(@id,\"project_link\")])[" + i + "]"));
            suchJobtitel.click();
            wd.navigate().back();
            // Speichere Daten dieser Seite
            // Gehe zurück auf Ergebnissseite
        }
*/
     //   "(//*[contains(@id,\"project_link\")])[1]"
     //   /html/body/div[2]/div[1]/section[1]/div[1]/article/div/form/div/input[3]
     //   //*[@id="__search"]/div/input[3]
    }

}
