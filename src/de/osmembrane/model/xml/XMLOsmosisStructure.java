//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.12.21 at 11:27:21 PM MEZ 
//


package de.osmembrane.model.xml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://osmembrane.de/model/xml}functionGroup" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="formatVersion" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="osmosisVersion" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "functionGroup"
})
@XmlRootElement(name = "XMLOsmosisStructure")
public class XMLOsmosisStructure
    implements Serializable
{

    private final static long serialVersionUID = 2010122123020001L;
    protected List<XMLFunctionGroup> functionGroup;
    @XmlAttribute(required = true)
    protected String formatVersion;
    @XmlAttribute(required = true)
    protected String osmosisVersion;

    /**
     * Gets the value of the functionGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the functionGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFunctionGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XMLFunctionGroup }
     * 
     * 
     */
    public List<XMLFunctionGroup> getFunctionGroup() {
        if (functionGroup == null) {
            functionGroup = new ArrayList<XMLFunctionGroup>();
        }
        return this.functionGroup;
    }

    public boolean isSetFunctionGroup() {
        return ((this.functionGroup!= null)&&(!this.functionGroup.isEmpty()));
    }

    public void unsetFunctionGroup() {
        this.functionGroup = null;
    }

    /**
     * Gets the value of the formatVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormatVersion() {
        return formatVersion;
    }

    /**
     * Sets the value of the formatVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormatVersion(String value) {
        this.formatVersion = value;
    }

    public boolean isSetFormatVersion() {
        return (this.formatVersion!= null);
    }

    /**
     * Gets the value of the osmosisVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOsmosisVersion() {
        return osmosisVersion;
    }

    /**
     * Sets the value of the osmosisVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOsmosisVersion(String value) {
        this.osmosisVersion = value;
    }

    public boolean isSetOsmosisVersion() {
        return (this.osmosisVersion!= null);
    }

}
