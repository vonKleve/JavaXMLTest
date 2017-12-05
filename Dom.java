package lab2try1pr;

import java.io.File; 
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder; 
import javax.xml.parsers.DocumentBuilderFactory; 
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.w3c.dom.Document; 
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import java.util.ArrayList;

public class Dom {
    
    public void analyze(File xmlSource, Medicine meds){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try{
            builder = factory.newDocumentBuilder();
        }
        catch(ParserConfigurationException mex){
            System.out.println(mex);
        }
        Document document = null;
        try{
            document = builder.parse(xmlSource);
        }
        catch(SAXException | IOException mex){
            System.out.println(mex.toString());
        }
        
        getMedicine(document, meds);
    }
    
    public void getMedicine(Document doc, Medicine meds){
        NodeList drugs = doc.getElementsByTagName("drug");
        
        for(int i = 0; i < drugs.getLength(); i++){
            
            Node ndrug = drugs.item(i);
            if(ndrug.getNodeType() == Node.ELEMENT_NODE){
               Element element = (Element)ndrug;
               
               String name = element.getElementsByTagName("name").item(0).getTextContent().trim();
               String scategory = element.getElementsByTagName("category").item(0).getTextContent().trim();
               Drug.Category category = Drug.getEnum(scategory);
               
               String pharm = element.getElementsByTagName("pharm").item(0).getTextContent().trim();
               
               
               String analogs = element.getElementsByTagName("analogs").item(0).getTextContent().trim();
//               NodeList as = element.getElementsByTagName("analogs");
//               ArrayList<String> analogs = new ArrayList<>(as.getLength());
//               for(int j = 0; j < as.getLength(); j++){
//                   
//                   Node nAnalog = as.item(j);
//                   if(nAnalog.getNodeType() == Node.ELEMENT_NODE){
//                       String sElement = nAnalog.getTextContent().trim();
//                       analogs.add(sElement);
//                   }
//               }
               
               Node nVersion = element.getElementsByTagName("version").item(0);
               Element proxyElement = (Element) nVersion;
               Integer dosage = Integer.parseUnsignedInt(proxyElement.getAttribute("dosage"));
               
               proxyElement = (Element) element.getElementsByTagName("certificate").item(0);
               Integer certNumber = Integer.parseUnsignedInt(proxyElement.getAttribute("number"));
               String id = proxyElement.getAttribute("id");
               String date = proxyElement.getAttribute("expdate");
               String organisation = proxyElement.getAttribute("organisation");
               
               proxyElement = (Element) element.getElementsByTagName("package").item(0);
               
               Integer amount = Integer.parseUnsignedInt(element.getElementsByTagName("amount").item(0).getTextContent().trim());
               Integer price = Integer.parseUnsignedInt(element.getElementsByTagName("price").item(0).getTextContent().trim());
               
               Package pack = new Package(amount, price);
               Certificate certificate = new Certificate(certNumber, new Date(date), organisation, id);
               Version version = new Version(dosage, certificate, pack);
               Drug drug = new Drug(name, category, pharm, analogs, version);
               
               meds.addDrug(drug);
               System.out.println(meds.toString());
            }
        }
    }
}
