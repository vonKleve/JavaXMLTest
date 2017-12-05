package lab2try1pr;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import java.io.*;
import java.io.FileReader;

import org.xml.sax.helpers.DefaultHandler; 
import org.xml.sax.*; 

public class Lab2Try1PR {
 
    public static void main(String[] args) {
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try{
           builder = factory.newDocumentBuilder();
        }
        catch(ParserConfigurationException mex)
        {
           System.out.println(mex.toString());
        }
        
        File mXMLfile = new File("PRL2\\xdescr.xml");
        File mXSDfile = new File("PRL2\\descr.xsd");
       
        Document doc = null;
        try{
            doc = builder.parse(mXMLfile);
        }
        catch(SAXException | IOException mex)
        {
            System.out.println(mex.toString());
        }
        
        Element root = doc.getDocumentElement();
        
        System.out.println(root.getTagName());
        
        Dom mdom = new Dom();
        
        Medicine mMed = new Medicine();
        mdom.analyze(mXMLfile, mMed);
        
        
        SAXParserFactory saxParserF = SAXParserFactory.newInstance();
        SAXParser saxParser = null;
        try{
            saxParser = saxParserF.newSAXParser();
        }
        catch(ParserConfigurationException | SAXException mex){
            System.out.println(mex.toString());
        }
        Sax saxp = new Sax();
        
        try{
            saxParser.parse(mXMLfile, saxp);
        }
        catch(SAXException | IOException mex){
            System.out.println(mex.toString());
        }
        
        try{
            StAX mstax = new StAX();
            FileReader mread;
            mread = new FileReader("PRL2\\xdescr.xml");
            
            mstax.analyze(mread);
        }
        catch(FileNotFoundException mex){
            System.out.println(mex.toString());
        }
        
        MValidator validator = new MValidator();
        validator.validate(mXMLfile, mXSDfile);
        
        
        String sXmlSource = "PRL2\\xdescr.xml";
        String sXslSource = "PRL2\\xsldescr.xsl";
        String sHtmlSource = "PRL2\\htmldescr.html";
        
        String xmltest = "\PRL2\\test2.xml";
        String xsltest = "PRL2\\xsldescr.xsl";
        
        HtmlTransf htmltt = new HtmlTransf();
        htmltt.transform(xsltest, xmltest, sHtmlSource);
    }
    
}
