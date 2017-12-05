package lab2try1pr;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

public class Sax extends DefaultHandler{
    Medicine meds = new Medicine();
    
    String sthis = "";
    Integer indCurrDrug = -1;
    
    Integer who = -1;
    
    @Override
    public void startDocument() throws SAXException {
        
    }
    
    @Override
    public void startElement(String namespaceUrl, String localName, 
            String qName, Attributes atts) throws SAXException {
        sthis = qName;
        
        switch (sthis) {
            case "name":
                who = 0;
                break;
            case "category":
                who = 1;
                break;
            case "pharm":
                who = 2;
                break;
            case "analogs":
                who = 3;
                break;
            case "amount":
                who = 4;
                break;
            case "price":
                who = 5;
                break;
            default:
                who = -1;
                break;
        }
        
        Drug drug;
        
        if(sthis.equals("drug")){
            drug = new Drug();
            meds.addDrug(drug);
            indCurrDrug++;
        }
        
        if(sthis.equals("version")){
            String val = atts.getValue("dosage");
            val = val.trim();
            
            drug = meds.get(indCurrDrug);
            drug.getVersion().setDosage(Integer.parseUnsignedInt(val));
        }
        else if(sthis.equals("certificate")){
            drug = meds.get(indCurrDrug);
            
            String val = atts.getValue("number");
            val = val.trim();
            drug.getVersion().getCertificate().setNumber(Integer.parseUnsignedInt(val));
            
            val = atts.getValue("id");
            val = val.trim();
            drug.getVersion().getCertificate().setID(val);
            
            val = atts.getValue("expdate");
            val = val.trim();
            drug.getVersion().getCertificate().setDate(new Date(val));
            
            val = atts.getValue("organisation");
            val = val.trim();
            drug.getVersion().getCertificate().setOrganisation(val);
        }
    }
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        Drug drug = null;
        if(indCurrDrug != -1){
            drug = meds.get(indCurrDrug);
        }
        String s = new String(ch, start, length);
        s = s.trim();
        
        if(s.equals(""))
            return;
        
        switch(who){
            case 0:
                if(drug.getName().equals(""))
                    drug.setName(s);
                break;
            case 1: 
                drug.setCategory(Drug.getEnum(s));
                break;
            case 2:
                if(drug.getPharm().equals(""))  
                    drug.setPharm(s); 
                break;
            case 3:
                drug.setAnalogs(s);
                break;
            case 4:
                drug.getVersion().getPackage().setAmount(Integer.parseInt(s));
                break;
            case 5:
                drug.getVersion().getPackage().setPrice(Integer.parseInt(s));
                break;
            default:
                break;
        }
        
        
    }
    
    @Override
    public void endElement(String namespaceUrl, String localName, String qName) throws SAXException{
        sthis = "";
    }
    
    @Override
    public void endDocument(){
        System.out.println(meds.toString());
    }
}
