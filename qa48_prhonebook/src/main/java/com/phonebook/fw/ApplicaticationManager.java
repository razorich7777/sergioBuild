package com.phonebook.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

// те функции что не имеют аннотаций
// веб драйвер нужен и в аппменеджер и в бейзхелпере
public class ApplicaticationManager{

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
        driver = new ChromeDriver();} else if (browser.equalsIgnoreCase("firefox")) {
            driver= new FirefoxDriver();
        }else if (browser.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        }
        driver.get("https://telranedu.web.app/home");
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
