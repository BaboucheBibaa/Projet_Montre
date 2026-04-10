package xml;

public class Test {
    public static void main(String[] args) {

        XmlWriter writer = new XmlWriter("config.xml");
        writer.setBackground("WHITE");
        writer.setPolicy("COMIC");
        writer.setClockFormat("analog");
        writer.setDateFormat("12");

        try {
            XmlReader reader = new XmlReader("config.xml");
            System.out.println(reader.getBackground());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}