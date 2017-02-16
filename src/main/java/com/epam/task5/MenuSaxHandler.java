package com.epam.task5;



import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MenuSaxHandler extends DefaultHandler {
    private List<Meal> mealList = new ArrayList<Meal>();
    private Meal meal;
    private StringBuilder text;

    public List<Meal> getMealList() {
        return mealList;
    }

    public void setDocumentLocator(Locator locator) {

    }

    public void startDocument() {
        System.out.println("Parsing started");
    }


    public void endDocument() {
        System.out.println("Parsing ended");
    }


    public void startElement(String uri, String localeName, String qName, Attributes attributes) {

        //System.out.println("startElement -> " + "uri: " + uri + ", localeName: " + localeName + ", qName: " + qName );

        text = new StringBuilder();

        if(qName.equals("element")) {
            meal = new Meal();
            meal.setId((Integer.parseInt(attributes.getValue("id"))));
        }

    }

    public void characters(char[] buffer , int start, int length) {
        text.append(buffer,start,length);
    }

    public void endElement(String uri, String localeName, String qName) throws SAXException {

    MenuTagName tagName = MenuTagName.valueOf(qName.toUpperCase().replace("-","_"));
        switch (tagName) {
            case NAME:
                meal.setName(text.toString());
                break;
            case PRICE:
                meal.setPrice(Integer.parseInt(text.toString()));
                break;
            case DISCRIPTION:
                meal.setDiscription(text.toString());
                break;
            case PORTION:
                meal.setPortion(text.toString());
                break;
            case ELEMENT:
                mealList.add(meal);
                meal = null;
                break;

        }

    }
}
