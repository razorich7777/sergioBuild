package com.phonebook.fw;

import com.phonebook.utils.Listener2;
import com.phonebook.utils.MyListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

// те функции что не имеют аннотаций
// веб драйвер нужен и в аппменеджер и в бейзхелпере
public class ApplicaticationManager{
    Logger logger = LoggerFactory.getLogger(ApplicaticationManager.class);
    WebDriver driver;
    String browser;
    UserHelper user;
    ContactHelper contact;

    public ApplicaticationManager(String browser) {
        this.browser = browser;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public UserHelper getUser() {
        return user;
    }

    public void setUser(UserHelper user) {
        this.user = user;
    }

    public ContactHelper getContact() {
        return contact;
    }

    public void setContact(ContactHelper contact) {
        this.contact = contact;
    }

    public HomePageHelper getHome() {
        return home;
    }

    public void setHome(HomePageHelper home) {
        this.home = home;
    }

    HomePageHelper home;

    public void init() {
        if(browser.equalsIgnoreCase("chrome")){
        driver = new ChromeDriver();
        logger.info("Test start in ChromeDriver");

        } else if (browser.equalsIgnoreCase("firefox")) {
            driver= new FirefoxDriver();
            logger.info("Test start in FirefoxDriver");

        }else if (browser.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
            logger.info("Test start in EdgeDriver");
        }

        WebDriverListener listener = new Listener2();
        driver = new EventFiringDecorator<>(listener).decorate(driver);
        driver.get("https://telranedu.web.app/home");
        logger.info("Current url --> " + driver.getCurrentUrl());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        user = new UserHelper(driver);
        contact = new ContactHelper(driver);
        home = new HomePageHelper(driver);
    }

    public void exit() {
        driver.quit();
    }

}
