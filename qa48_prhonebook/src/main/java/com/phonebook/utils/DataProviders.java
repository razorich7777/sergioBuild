package com.phonebook.utils;

import com.phonebook.models.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator<Object[]> addContactWithCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/ContactData.csv")));

        String line = reader.readLine();
        while (line!=null){
            String[] strings = line.split(",");
            list.add(new Object[]{new Contact(strings[0],strings[1],strings[2],strings[3], strings[4], strings[5])});

            line = reader.readLine();}

        return list.iterator();
    }

    @DataProvider
    public Iterator <Object[]> addNewContact(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Oliver", "Kan", "1324567890", "kan@gmail.com", "Jerusalem", "mid qa"});
        list.add(new Object[]{"Serr", "Kan", "1324567890", "kan@gmail.com", "Jerusalem", "mid qa"});
        list.add(new Object[]{"John", "Kan", "1324567890", "kan@gmail.com", "Jerusalem", "mid qa"});
        return list.iterator();
    }
}
