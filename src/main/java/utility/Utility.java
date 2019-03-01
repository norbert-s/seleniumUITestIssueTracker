package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class Utility {
    public Properties prop;
    protected String driverPath;
    protected WebDriver d;
    protected String url;



    public WebDriverWait  wait;

    public Utility() throws IOException {
        properties();
    }

    public void properties() throws IOException {
        FileInputStream fis = new FileInputStream("D:\\Idea\\tests\\IssueTracker\\src\\main\\java\\properties\\data.properties");
        prop = new Properties();
        prop.load(fis);
        driverPath= prop.getProperty("chrome");
        ChromeInit();
        url = prop.getProperty("url");

    }


    public void ChromeInit(){
        System.setProperty("webdriver.chrome.driver",driverPath);
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("headless");
//        options.addArguments("window.size=1200*600");
        d = new ChromeDriver();
        d.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    public WebDriverWait callWait(WebElement getJsonLocation){
        wait= new WebDriverWait(d,30);

        WebElement waitForJson = wait.until(ExpectedConditions.visibilityOf(getJsonLocation));
        return wait;
    }

    public void sleep() throws InterruptedException {
        Thread.sleep(500);
    }




}
