package com.phonebook;

import com.phonebook.data.UserData;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateAccountTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
    }
    SoftAssert sf = new SoftAssert();
    @Test(enabled = false)
    public void newUserRegistrationPositive(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        //click on login link
        app.getUser().clickOnLoginLink();
        //enter email
        app.getUser().fillRegisterLoginForm(new User().setEmail("sss" + i + "@ss.com").setPassword(UserData.PASSWORD));
        //click on registration button
        app.getUser().clickOnRegistrationButton();
        //verify singout is displayed
        Assert.assertTrue(app.getUser().isSignOutPresent());
    }

    @Test
    public void existedUserRegistrationNegativeTest(){
        //click on login link
        app.getUser().clickOnLoginLink();
        //enter email
        app.getUser().fillRegisterLoginForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));


        //click on registration button
        app.getUser().clickOnRegistrationButton();

        //verify alert is displayed
        sf.assertTrue(app.getUser().isAlertDisplayed());
        sf.assertTrue(app.getUser().isErrorDisplayed());

    }


}
