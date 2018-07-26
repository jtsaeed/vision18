package com.evh98.vision.ui.card;

import com.evh98.vision.ui.Icon;
import com.evh98.vision.ui.Palette;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class HomeCardsLoader {

    public static ArrayList<Card> loadCards() {
        ArrayList<Card> cards = new ArrayList<Card>();

        try {
            File fXmlFile = new File(System.getProperty("user.home") + "/vision.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("card");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    String title = eElement.getElementsByTagName("title").item(0).getTextContent();
                    String type = eElement.getElementsByTagName("type").item(0).getTextContent();
                    String action = eElement.getElementsByTagName("action").item(0).getTextContent();
                    String color = eElement.getElementsByTagName("color").item(0).getTextContent();
                    String icon = eElement.getElementsByTagName("icon").item(0).getTextContent();

                    cards.add(new Card(title, new Icon(icon),
                            Palette.colorsFromText(color), new CardAction(type, action)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cards;
    }
}