package lab2try1pr;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;
import java.net.URL;
import org.xml.sax.SAXException;
import java.io.File; 
import java.io.IOException;

public class MValidator {
    public void validate(File xmlSource, File schemaFile){
        
        Source xmlFile = new StreamSource(xmlSource);
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
          Schema schema = schemaFactory.newSchema(schemaFile);
          Validator validator = schema.newValidator();
          validator.validate(xmlFile);
          System.out.println(xmlFile.getSystemId() + " is valid");
        } catch (SAXException e) {
          System.out.println(xmlFile.getSystemId() + " is NOT valid reason:" + e);
        } catch (IOException e) {}
    }
}
