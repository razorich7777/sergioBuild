package com.phonebook.fw;

import com.phonebook.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper{
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnRegistrationButton() {
        click(By.name("registration"));
    }

    public void fillRegisterLoginForm(User user) {
        //enter email
        type(By.name("email"), user.getEmail());

        //enter password
        type(By.name("password"), user.getPassword());
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    public boolean isSignOutPresent() {
        return isElementPresent(By.xpath("//*[.='Sign Out']"));
    }

    public void clickOnLoginButton() {
        click(By.name("login"));
    }
    public boolean isErrorDisplayed() {
        return isElementPresent(By.cssSelector(".login_login__3EHKB>div"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.cssSelector("[href='/login']"));
    }

    public void clickOnSignOutButton() {
        click(By.xpath("//*[.='Sign Out']"));
    }
}
