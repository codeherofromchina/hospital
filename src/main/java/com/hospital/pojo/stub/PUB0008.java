
package com.hospital.pojo.stub;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "PUB0008", targetNamespace = "http://www.dhcc.com.cn", wsdlLocation = "http://183.196.0.25:8092/csp/hsb/DHC.Published.PUB0008.BS.PUB0008.CLS?wsdl")
public class PUB0008
    extends Service
{

    private final static URL PUB0008_WSDL_LOCATION;
    private final static WebServiceException PUB0008_EXCEPTION;
    private final static QName PUB0008_QNAME = new QName("http://www.dhcc.com.cn", "PUB0008");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://183.196.0.25:8092/csp/hsb/DHC.Published.PUB0008.BS.PUB0008.CLS?WSDL");
//            url = new URL("http://172.18.20.146/csp/hsb/DHC.Published.PUB0008.BS.PUB0008.cls?wsdl");
//            url = new URL("file:///C:/apache-tomcat-7.0.63/conf/wsdl.xml");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PUB0008_WSDL_LOCATION = url;
        PUB0008_EXCEPTION = e;
    }

    public PUB0008() {
        super(__getWsdlLocation(), PUB0008_QNAME);
    }

    public PUB0008(WebServiceFeature... features) {
        super(__getWsdlLocation(), PUB0008_QNAME, features);
    }

    public PUB0008(URL wsdlLocation) {
        super(wsdlLocation, PUB0008_QNAME);
    }

    public PUB0008(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PUB0008_QNAME, features);
    }

    public PUB0008(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PUB0008(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns PUB0008Soap
     */
    @WebEndpoint(name = "PUB0008Soap")
    public PUB0008Soap getPUB0008Soap() {
        return super.getPort(new QName("http://www.dhcc.com.cn", "PUB0008Soap"), PUB0008Soap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PUB0008Soap
     */
    @WebEndpoint(name = "PUB0008Soap")
    public PUB0008Soap getPUB0008Soap(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.dhcc.com.cn", "PUB0008Soap"), PUB0008Soap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (PUB0008_EXCEPTION!= null) {
            throw PUB0008_EXCEPTION;
        }
        return PUB0008_WSDL_LOCATION;
    }

}
