package xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

public class XmlWriter {

    private File file;
    private Document doc;

    public XmlWriter(String filename) {
        try {
            file = new File(filename);

            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

            if (file.exists()) {
                doc = builder.parse(file);
            }
            else {
                doc = builder.newDocument();
                Element root = doc.createElement("config");
                doc.appendChild(root);
                save();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setValue(String tag, String value) {
        Element root = doc.getDocumentElement();

        NodeList list = doc.getElementsByTagName(tag);

        if (list.getLength() > 0) {
            list.item(0).setTextContent(value);
        } else {
            Element element = doc.createElement(tag);
            element.appendChild(doc.createTextNode(value));
            root.appendChild(element);
        }

        save();
    }

    private void save() {
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(file);

            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void setR(String r) {
        setValue("bg-r", r);
    }
    public void setG(String g) {
        setValue("bg-g", g);
    }
    public void setB(String b) {
        setValue("bg-b", b);
    }


    public void setPolicy(String policy) {
        setValue("policy", policy);
    }

    public void setClockFormat(String clockFormat) {
        setValue("clock-format", clockFormat);
    }

    public void setDateFormat(String dateFormat) {
        setValue("date-format", dateFormat);
    }
}