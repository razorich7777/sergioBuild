package com.phonebook;

import com.phonebook.data.ContactData;
import com.phonebook.data.UserData;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import com.phonebook.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class AddContactTest extends TestBase{



    //pre-condition login
    @BeforeMethod
    public void precondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();

        //enter email
        app.getUser().fillRegisterLoginForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));

        //click on Login button
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest() {
        //click on link ADD
        app.getContact().clickOnAddLink();
        //enter name
        app.getContact().fillContentForm(new Contact(
                ContactData.NAME,
                ContactData.LASTNAME,
                ContactData.PHONE,
                ContactData.EMAIL,
                ContactData.ADDRESS,
                ContactData.DESCRIPTION));
        //click on SAVE button
        app.getContact().clickOnSaveButton();
        //verify contact is added
        Assert.assertTrue(app.getContact().isContactAdded(ContactData.NAME));
    }





    @Test(dataProvider = "addNewContact", dataProviderClass = DataProviders.class)
    public void addContactPositiveFromDataProviderTest(
            String name,
            String lastName,
            String phone,
            String email,
            String city,
            String description) {
        //click on link ADD
        app.getContact().clickOnAddLink();
        //enter name
        app.getContact().fillContentForm(new Contact(
                name,
                lastName,
                phone,
                email,
                city,
                description));
        //click on SAVE button
        app.getContact().clickOnSaveButton();
        //verify contact is added
        Assert.assertTrue(app.getContact().isContactAdded(name));
    }


    @Test(dataProvider = "addContactWithCSV", dataProviderClass = DataProviders.class)
    public void addContactPositiveFromCSVFileTest(
            Contact contact) {
        //click on link ADD
        app.getContact().clickOnAddLink();
        //enter name
        app.getContact().fillContentForm(contact);
        //click on SAVE button
        app.getContact().clickOnSaveButton();
        //verify contact is added
        Assert.assertTrue(app.getContact().isContactAdded(contact.getName()));
    }




    @AfterMethod
    public void postCondition(){
        app.getContact().deleteContact();
    }

}
