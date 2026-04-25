package xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

/**
 * Classe permettant d'écrire dans un fichier XML
 * */
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
            throw new RuntimeException("Erreur lors du chargement du fichier XML", e);
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
            throw new RuntimeException("Erreur lors de la création du PanelCadran", e);
        }
    }


    public void setRGB(String r, String g, String b) {
        setValue("bg-r", r);
        setValue("bg-g",g);
        setValue("bg-b",b);
    }


    public void setPolicy(String policy) {
        setValue("policy", policy);
    }

    public void setClockFormat(String clockFormat) {
        setValue("clock-format", clockFormat);
    }

    public void setHeureFormat(String heureFormat) {
        setValue("heure-format", heureFormat);
    }
    public void setDateFormat(String dateFormat){
        setValue("date-format",dateFormat);
    }

    public void setAlarme(int h , int m , boolean active){
        setValue("alarme-h", String.valueOf(h));
        setValue("alarme-m", String.valueOf(m));
        setValue("alarme-active", String.valueOf(active));
    }
}