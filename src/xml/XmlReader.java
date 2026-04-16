package xml;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XmlReader {

    private static XmlReader instance;

    private String r;
    private String g;
    private String b;
    private String policy;
    private String clockFormat;
    private String dateFormat;
    private Document doc;

    public XmlReader(String filename) throws Exception {
            File file = new File(filename);
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
            doc = builder.parse(file);
            r = doc.getElementsByTagName("bg-r").item(0).getTextContent();
            g = doc.getElementsByTagName("bg-g").item(0).getTextContent();
            b = doc.getElementsByTagName("bg-b").item(0).getTextContent();
            policy = doc.getElementsByTagName("policy").item(0).getTextContent();
            clockFormat = doc.getElementsByTagName("clock-format").item(0).getTextContent();
            dateFormat = doc.getElementsByTagName("date-format").item(0).getTextContent();
    }


    public static XmlReader getInstance(String filename) throws Exception {
        /*Pas un vrai design pattern singleton contrairement à XmlWriter car:
         *   Pour une instance de XmlReader, on a UNE SEULE valeur de r,g,b, etc...
         *   Sauf qu'XmlWriter permet de réécrire dans le Xml une autre valeur de r,g,b
         *   Donc si on applique un design pattern singleton, le changement opérera à chaque redémarrage de l'appli, ce qu'on ne veut pas
         *   Mais par soucis de lisibilité, on fait cette fonction qui sera utilisée comme si on appliquait un vrai design pattern singleton.
         *   Mais en fait non.*/
        //instance = new XmlReader("config.xml");
        if (instance == null){
            instance = new XmlReader("config.xml");
        }
        instance.r = instance.doc.getElementsByTagName("bg-r").item(0).getTextContent();
        instance.g = instance.doc.getElementsByTagName("bg-g").item(0).getTextContent();
        instance.b = instance.doc.getElementsByTagName("bg-b").item(0).getTextContent();
        instance.policy = instance.doc.getElementsByTagName("policy").item(0).getTextContent();
        instance.clockFormat = instance.doc.getElementsByTagName("clock-format").item(0).getTextContent();
        instance.dateFormat = instance.doc.getElementsByTagName("date-format").item(0).getTextContent();

        return instance;
    }

    public int getR() {
        return Integer.parseInt(r);
    }
    public int getB() {
        return Integer.parseInt(b);
    }
    public int getG() {
        return Integer.parseInt(g);
    }

    public String getPolicy() {
        return policy;
    }

    public String getClockFormat() {
        return clockFormat;
    }

    public String getDateFormat() {
        return dateFormat;
    }
}
