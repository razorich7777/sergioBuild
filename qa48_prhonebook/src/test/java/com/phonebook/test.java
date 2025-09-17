package com.phonebook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test extends TestBase {


        @BeforeMethod
        public void ensurePrecondition(){
            if(!app.getHome().isHomeComponentPresentTest()){
                app.getHome().clickOnHomeClick();
            }
        }
        //System.out.println("Home Component " + isExist());

    @Test
    public void testHomePage(){
    Assert.assertTrue(app.getHome().isHomeComponentPresentTest());
}

}
