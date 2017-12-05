package lab2try1pr;

import javax.xml.transform.*;
import java.net.*;
import java.io.*;

public class HtmlTransf {
    public void transform(String xslPath, String xmlPath, String toPath){
        try{
            StringWriter sw = new StringWriter();
            FileWriter fw = new FileWriter(toPath);
            TransformerFactory tFactory = TransformerFactory.newInstance();
            
            Transformer transformer = tFactory.newTransformer(new javax.xml.transform.stream.StreamSource(xslPath));
            
            transformer.transform(new javax.xml.transform.stream.StreamSource(xmlPath),
               new javax.xml.transform.stream.StreamResult(sw));
            fw.write(sw.toString());
            fw.close();
        }
        catch (Exception e) {
            e.printStackTrace( );
        }
    }
}
