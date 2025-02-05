
package com.edicom.ediwinws.service.ediwinintegration;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EdiwinIntegrationException complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EdiwinIntegrationException"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cod" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="errors" type="{http://ediwinIntegration.service.ediwinws.edicom.com}ArrayOfError"/&gt;
 *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EdiwinIntegrationException", propOrder = {
    "cod",
    "errors",
    "text"
})
public class EdiwinIntegrationException {

    protected int cod;
    @XmlElement(required = true, nillable = true)
    protected ArrayOfError errors;
    @XmlElement(required = true, nillable = true)
    protected String text;

    /**
     * Gets the value of the cod property.
     * 
     */
    public int getCod() {
        return cod;
    }

    /**
     * Sets the value of the cod property.
     * 
     */
    public void setCod(int value) {
        this.cod = value;
    }

    /**
     * Gets the value of the errors property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfError }
     *     
     */
    public ArrayOfError getErrors() {
        return errors;
    }

    /**
     * Sets the value of the errors property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfError }
     *     
     */
    public void setErrors(ArrayOfError value) {
        this.errors = value;
    }

    /**
     * Gets the value of the text property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setText(String value) {
        this.text = value;
    }

}
