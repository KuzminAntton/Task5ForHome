package com.epam.task5;


import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;


import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SAXException, IOException, jdk.internal.org.xml.sax.SAXException {
        XMLReader reader =  XMLReaderFactory.createXMLReader();
        MenuSaxHandler handler = new MenuSaxHandler();
        reader.setContentHandler(handler);
        reader.parse(new InputSource("menuu.xml"));

        List<Meal> mealsList = handler.getMealList();

        for(Meal meal : mealsList) {
            System.out.println(meal);
        }
    }
}
