package xml;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XmlReader {

    private String filename;
    private Document doc;

    public XmlReader(String filename) throws Exception {
            this.filename = filename;
            File file = new File(filename);
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
            doc = builder.parse(file);
    }

    private void recharger() throws Exception {
        File file = new File(filename);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
        doc = builder.parse(file);
    }
    public int getR() {
        //On essaye de recharger le document afin d'avoir les nouvelles valeurs, en cas de maj du background par l'utilisateur
        try {
            recharger();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Integer.parseInt(doc.getElementsByTagName("bg-r").item(0).getTextContent());
    }

    public int getB() {
        try {
            recharger();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Integer.parseInt(doc.getElementsByTagName("bg-b").item(0).getTextContent());
    }

    public int getG() {
        try {
            recharger();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Integer.parseInt(doc.getElementsByTagName("bg-g").item(0).getTextContent());
    }

    public String getPolicy() {
        try {
            recharger();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doc.getElementsByTagName("policy").item(0).getTextContent();
    }

    public String getClockFormat() {
        try {
            recharger();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doc.getElementsByTagName("clock-format").item(0).getTextContent();
    }

    public String getDateFormat() {
        try {
            recharger();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doc.getElementsByTagName("date-format").item(0).getTextContent();
    }
}
