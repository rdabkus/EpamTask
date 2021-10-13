package by.javabegin.training;

import by.javabegin.training.notebook.Asus;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Main {

    private static final String FILENAME = "Devices.xml";

    public static void main(String[] args) {

        Asus asus = new Asus();

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            try {
                dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.parse(new File(FILENAME));
                doc.getDocumentElement().normalize();
                NodeList list = doc.getElementsByTagName("NoteBook");
                Node node = list.item(0);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    asus.setName(element.getElementsByTagName("name").item(0).getTextContent());
                    asus.setCurrency(element.getElementsByTagName("currency").item(0).getTextContent());
                    String AsusMeasure = element.getElementsByTagName("measure").item(0).getTextContent();
                    String AsusPrice = element.getElementsByTagName("price").item(0).getTextContent();
                    String AsusWeight = element.getElementsByTagName("weight").item(0).getTextContent();

                    System.out.println("name :" + asus.getName());
                    System.out.println("currency : " + asus.getCurrency());
                    System.out.println("measure : " + AsusMeasure);
                    System.out.println("price : " + Float.parseFloat(AsusPrice));
                    System.out.println("weight : " + Float.parseFloat(AsusWeight));
                    System.out.println("weight : " + Double.parseDouble(AsusWeight) + Double.parseDouble(AsusPrice));

                }

            } catch (ParserConfigurationException | SAXException | IOException e) {
                e.printStackTrace();
            }
        }
    }