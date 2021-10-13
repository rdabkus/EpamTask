package by.javabegin.training;

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
import java.io.InputStream;

public class ReadXmlDomParser {

    private static final String FILENAME = "Devices.xml";

    public static void main(String[] args) {

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
                    String AsusName = element.getElementsByTagName("name").item(0).getTextContent();
                    String currency = element.getElementsByTagName("currency").item(0).getTextContent();
                    String measure = element.getElementsByTagName("measure").item(0).getTextContent();
                    String price = element.getElementsByTagName("price").item(0).getTextContent();
                    String weight = element.getElementsByTagName("weight").item(0).getTextContent();

                    System.out.println("name :" + AsusName);
                    System.out.println("currency : " + currency);
                    System.out.println("measure : " + measure);
                    System.out.println("price : " + Float.parseFloat(price));
                    System.out.println("weight : " + Float.parseFloat(weight));


                }


        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }


    }


}
