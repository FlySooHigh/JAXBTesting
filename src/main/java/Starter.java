import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import com.example.myschema.ObjectFactory;
import com.example.myschema.Shipordertype;
import org.xml.sax.SAXException;

import java.io.File;

public class Starter {
    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI );
            Schema schema = sf.newSchema(new File("src\\main\\resources\\xsd\\ExampleSchema.xsd"));
            jaxbUnmarshaller.setSchema(schema);

            Shipordertype shipordertype = ((JAXBElement<Shipordertype>) jaxbUnmarshaller.unmarshal(new File("src\\main\\resources\\xsd\\ExampleSchema.xml"))).getValue();

            System.out.println(shipordertype);
        } catch (JAXBException | SAXException e) {
            e.printStackTrace();
        }
    }
}
