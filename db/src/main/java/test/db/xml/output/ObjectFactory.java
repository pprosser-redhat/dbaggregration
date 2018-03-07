//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.03.07 at 11:38:23 AM GMT 
//


package test.db.xml.output;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the test.db.xml.output package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Output_QNAME = new QName("http://www.example.org/OutputSchema", "output");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: test.db.xml.output
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OutputData }
     * 
     */
    public OutputData createOutputData() {
        return new OutputData();
    }

    /**
     * Create an instance of {@link AssetList }
     * 
     */
    public AssetList createAssetList() {
        return new AssetList();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OutputData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/OutputSchema", name = "output")
    public JAXBElement<OutputData> createOutput(OutputData value) {
        return new JAXBElement<OutputData>(_Output_QNAME, OutputData.class, null, value);
    }

}
