
package com.hospital.pojo.stub;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PUB0008Soap", targetNamespace = "http://www.dhcc.com.cn")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PUB0008Soap {


    /**
     * 
     * @param input2
     * @param input1
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "HIPMessageServer", action = "http://www.dhcc.com.cn/DHC.Published.PUB0008.BS.PUB0008.HIPMessageServer")
    @WebResult(name = "HIPMessageServerResult", targetNamespace = "http://www.dhcc.com.cn")
    @RequestWrapper(localName = "HIPMessageServer", targetNamespace = "http://www.dhcc.com.cn", className = "com.hospital.pojo.stub.HIPMessageServer")
    @ResponseWrapper(localName = "HIPMessageServerResponse", targetNamespace = "http://www.dhcc.com.cn", className = "com.hospital.pojo.stub.HIPMessageServerResponse")
    public String hipMessageServer(
            @WebParam(name = "input1", targetNamespace = "http://www.dhcc.com.cn")
                    String input1,
            @WebParam(name = "input2", targetNamespace = "http://www.dhcc.com.cn")
                    String input2);

}