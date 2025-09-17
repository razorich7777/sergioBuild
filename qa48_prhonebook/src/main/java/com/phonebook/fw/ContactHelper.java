package com.phonebook.fw;

import com.phonebook.models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelper extends BaseHelper {
    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnSaveButton() {
        click(By.cssSelector(".add_form__2rsm2 button"));
    }

    public void fillContentForm(Contact contact) {
        type(By.cssSelector("input:nth-child(1)"), contact.getName());
        //enter lastname
        type(By.cssSelector("input:nth-child(2)"), contact.getLastName());
        //enter phone
        type(By.cssSelector("input:nth-child(3)"), contact.getPhone());
        //enter email
        type(By.cssSelector("input:nth-child(4)"), contact.getEmail());
        //enter adress
        type(By.cssSelector("input:nth-child(5)"), contact.getCity());
        //enter description
        type(By.cssSelector("input:nth-child(6)"), contact.getDescription());
    }

    public void clickOnAddLink() {
        click(By.cssSelector("[href='/add']"));
    }

    public boolean isContactAdded(String name) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for (WebElement el: contacts){
            if (el.getText().contains(name))
                return true;
        }
        return false;
    }

    public void deleteContact() {
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[.='Remove']"));
    }

    public int sizeOfContacts() {
        if(isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))){
            return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        }
        return 0;
    }
}
