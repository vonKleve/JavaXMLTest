package lab2try1pr;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class StAX {
    Medicine meds = new Medicine();
    
    Integer curr = -1, currDrug = -1;
    
    public void analyze(FileReader mfile){
        try{
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader eventReader = factory.createXMLEventReader(mfile);
        
        while(eventReader.hasNext()){
            XMLEvent event = eventReader.nextEvent();
            
             switch(event.getEventType()) {
                 
                  case XMLStreamConstants.START_ELEMENT:
                      StartElement startElement = event.asStartElement();
                      String qName = startElement.getName().getLocalPart();
                      
                      
                      if(qName.equals("drug")){
                          Drug drug = new Drug();
                          meds.addDrug(drug);
                          currDrug++;
                      } else if(qName.equals("version")) {
                          Iterator<Attribute> atts = startElement.getAttributes();
                          String dosage = atts.next().getValue();
                          dosage = dosage.trim();
                          
                          Drug drug = meds.get(currDrug);
                          drug.getVersion().setDosage(Integer.parseInt(dosage));
                      } else if(qName.equals("certificate")){
                          Iterator<Attribute> atts = startElement.getAttributes();
                          String number = atts.next().getValue();
                          String org = atts.next().getValue();
                          String id = atts.next().getValue();
                          String expdate = atts.next().getValue();
                          number = number.trim(); org = org.trim(); expdate = expdate.trim(); id = id.trim();
                          
                          Drug drug = meds.get(currDrug);
                          drug.getVersion().getCertificate().setNumber(Integer.parseInt(number));
                          drug.getVersion().getCertificate().setOrganisation(org);
                          drug.getVersion().getCertificate().setDate(new Date(expdate));
                          drug.getVersion().getCertificate().setID(id);
                      } else if(qName.equals("name")){
                          curr = 0;
                      } else if(qName.equals("category")){
                          curr = 1;
                      } else if(qName.equals("pharm")){
                          curr = 2;
                      } else if(qName.equals("analogs")){
                          curr = 3;
                      } else if(qName.equals("amount")) {
                          curr = 4;
                      } else if(qName.equals("price")){
                          curr = 5;
                      }
                      
                      break;
                      
                  case XMLStreamConstants.CHARACTERS:
                      Characters chars = event.asCharacters();
                      String s = chars.getData();
                      s = s.trim();
                      
                      Drug drug = null;
                      if(currDrug != -1)
                          drug = meds.get(currDrug);
                      
                      if(s.equals(""))
                          continue;
                      
                      switch(curr){
                          case 0:
                              drug.setName(s);
                              break;
                          case 1:
                              drug.setCategory(Drug.getEnum(s));
                              break;
                          case 2:
                              drug.setPharm(s);
                              break;
                          case 3:
                              drug.setAnalogs(s);
                              break;
                          case 4:
                              drug.getVersion().getPackage().setAmount(Integer.parseUnsignedInt(s));
                              break;
                          case 5:
                              drug.getVersion().getPackage().setPrice(Integer.parseUnsignedInt(s));
                              break;
                          default:
                              break;
                      }
                } 
                 
                 
             }
        
        System.out.println(meds.toString());
        
        }
        catch(XMLStreamException mex){
            System.out.println(mex.toString());
        }
        
    }
}
