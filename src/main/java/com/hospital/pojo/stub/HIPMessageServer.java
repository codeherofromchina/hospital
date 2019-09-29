
package com.hospital.pojo.stub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="input1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="input2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "input1",
    "input2"
})
@XmlRootElement(name = "HIPMessageServer")
public class HIPMessageServer {

    protected String input1;
    protected String input2;

    /**
     * 获取input1属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInput1() {
        return input1;
    }

    /**
     * 设置input1属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInput1(String value) {
        this.input1 = value;
    }

    /**
     * 获取input2属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInput2() {
        return input2;
    }

    /**
     * 设置input2属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInput2(String value) {
        this.input2 = value;
    }

}
