package com.phonebook;

import com.phonebook.data.UserData;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest  extends TestBase{
    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
    }
    @Test(priority = 1)
    public void loginPositiveTest(){

        //click on login link
        app.getUser().clickOnLoginLink();

        //enter email
        app.getUser().fillRegisterLoginForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));

        //click on Login button
        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isSignOutPresent());
    }@Test(priority = 2)
    public void loginNegativeWithoutMailTest(){

        //click on login link
        app.getUser().clickOnLoginLink();

        //enter email
        app.getUser().fillRegisterLoginForm(new User().setPassword(UserData.PASSWORD));

        //click on Login button
        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isAlertDisplayed());
    }

}
