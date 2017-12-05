package lab2try1pr;

import java.io.*;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;
import org.xml.sax.SAXException;

public class XsdCheck {
    
    private String sXmlSource = "C:\\Users\\Dell\\Desktop\\Materials\\PRL2\\xdescr.xml";
    private String sXsdSource = "C:\\Users\\Dell\\Desktop\\Materials\\PRL2\\descr.xsd";
    
    public void check() throws SAXException, IOException{
         // 1. Поиск и создание экземпляра фабрики для языка XML Schema
        // 2. Компиляция схемы
        // Схема загружается в объект типа java.io.File, но вы также можете использовать 
        // классы java.net.URL и javax.xml.transform.Source
        // 3. Создание валидатора для схемы
        // 4. Разбор проверяемого документа
         // 5. Валидация документа
           //           targetNamespace="https://www.example.ortg/Test"   xmlns="https://www.example.org/Test elementFormDefault="qualified">
        
        
        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
         
        File schemaLocation = new File(sXsdSource);
        Schema schema = factory.newSchema(schemaLocation);
        
        
        Validator validator = schema.newValidator();
         
        
        Source source = new StreamSource(sXmlSource);
         
        try {
            validator.validate(source);
            System.out.println(sXmlSource + " is valid.");
        }
        catch (SAXException ex) {
            System.out.println(sXmlSource + " is not valid because ");
            System.out.println(ex.getMessage());
        }  
    }
}
