
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
 *         &lt;element name="user" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="domain" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="group" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *         &lt;element name="process" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "user",
    "password",
    "domain",
    "group",
    "message",
    "process"
})
@XmlRootElement(name = "transformData")
public class TransformData {

    @XmlElement(required = true)
    protected String user;
    @XmlElement(required = true)
    protected String password;
    @XmlElement(required = true)
    protected String domain;
    @XmlElement(required = true)
    protected String group;
    @XmlElement(required = true)
    protected byte[] message;
    @XmlElement(required = true)
    protected String process;

    /**
     * Gets the value of the user property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUser(String value) {
        this.user = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the domain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomain() {
        return domain;
    }

    /**
     * Sets the value of the domain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomain(String value) {
        this.domain = value;
    }

    /**
     * Gets the value of the group property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroup() {
        return group;
    }

    /**
     * Sets the value of the group property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroup(String value) {
        this.group = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setMessage(byte[] value) {
        this.message = value;
    }

    /**
     * Gets the value of the process property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcess() {
        return process;
    }

    /**
     * Sets the value of the process property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcess(String value) {
        this.process = value;
    }

}
