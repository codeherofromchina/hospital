
package com.hospital.pojo.stub;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.hospital.pojo.stub package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.hospital.pojo.stub
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OPRegistration }
     * 
     */
    public OPRegistration createOPRegistration() {
        return new OPRegistration();
    }

    /**
     * Create an instance of {@link OPRegistrationResponse }
     * 
     */
    public OPRegistrationResponse createOPRegistrationResponse() {
        return new OPRegistrationResponse();
    }

}
