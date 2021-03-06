package mathDefinitions.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Def {
    private String name;
    private String definition;
    private String topic;
    private String level;

    public static ObservableList<Def> definitions = FXCollections.observableArrayList(new ArrayList<>());
    //public static Set<Def> definitions;


    public static void betoltes(String fnev) throws IOException {

        var objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        File f = new File(fnev);
        List<Def> beolvasva = objectMapper.readValue(new FileReader(fnev), List.class);
        //definitions = (ObservableList<Def>) objectMapper.readValue(new FileReader(fnev), List.class);

        definitions.addAll(beolvasva);
        for( int i = 0; i < beolvasva.size(); i++){
            System.out.println(beolvasva.get(i));
        }

    }
    /*
    public static void load(String fnev) {


        try {
            File file = new File(fnev);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            NodeList testBusNodeList = doc.getElementsByTagName("testbus");

            for (int i = 0; i < testBusNodeList.getLength(); i++) {

                Node node = testBusNodeList.item(i);
                Def d = new Def();
                d.setName(node.getAttributes().getNamedItem("name").getNodeValue());
                d.setDefinition(node.getAttributes().getNamedItem("definition").getNodeValue());
                d.setLevel(node.getAttributes().getNamedItem("level").getNodeValue());
                d.setTopic(node.getAttributes().getNamedItem("topic").getNodeValue());
                definitions.add(d);
            }

        } catch (Exception e) {
            System.out.println("!!!!!!!!  Exception while reading xml file :" + e.getMessage());
        }
    }*/
    /*
    public static void load(String fnev){

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try{
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(fnev));

            doc.getDocumentElement().normalize();

            NodeList list = doc.getElementsByTagName("staff");

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    /*
    public static void save() {

        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

            Element root = document.createElement("");
            document.appendChild(root);

            for (Def d : definitions) {
                Element node = document.createElement("def");

                node.setAttribute("name", d.getName());
                node.setAttribute("topic", d.getTopic());
                node.setAttribute("level", d.getLevel());
                node.setAttribute("definition", d.getDefinition());

                root.appendChild(node);
            }

            File file = new File("definitions.xml");
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(new DOMSource(document), new StreamResult(new FileOutputStream(file)));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }*/

    public static void add(String nev, String def, String topic, String level){
        Def definition = new Def(nev, def, topic, level);

        Def.definitions.add(definition);
    }

}