
package com.edicom.ediwinws.service.ediwinintegration;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="getCustomDataReturn" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getCustomDataReturn"
})
@XmlRootElement(name = "getCustomDataResponse")
public class GetCustomDataResponse {

    @XmlElement(required = true)
    protected byte[] getCustomDataReturn;

    /**
     * Gets the value of the getCustomDataReturn property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getGetCustomDataReturn() {
        return getCustomDataReturn;
    }

    /**
     * Sets the value of the getCustomDataReturn property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setGetCustomDataReturn(byte[] value) {
        this.getCustomDataReturn = value;
    }

}
