package xml;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XmlReader {
    private final String r;
    private final String g;
    private final String b;
    private final String policy;
    private final String clockFormat;
    private final String dateFormat;

    public XmlReader(String filename) throws ParserConfigurationException, IOException, SAXException{
            File file = new File(filename);
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
            Document doc = builder.parse(file);
            r = doc.getElementsByTagName("bg-r").item(0).getTextContent();
            g = doc.getElementsByTagName("bg-g").item(0).getTextContent();
            b = doc.getElementsByTagName("bg-b").item(0).getTextContent();
            policy = doc.getElementsByTagName("policy").item(0).getTextContent();
            clockFormat = doc.getElementsByTagName("clock-format").item(0).getTextContent();
            dateFormat = doc.getElementsByTagName("date-format").item(0).getTextContent();
        }

    public String getR() {
        return r;
    }
    public String getB(){
        return b;
    }
    public String getG(){
        return g;
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
