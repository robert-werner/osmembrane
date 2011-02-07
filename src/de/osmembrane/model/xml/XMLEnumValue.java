/*
 * This file is part of the OSMembrane project.
 * More informations under www.osmembrane.de
 * 
 * The project is licensed under the Creative Commons
 * Attribution-NonCommercial-ShareAlike 3.0 Unported License.
 * for more details about the license see
 * http://www.osmembrane.de/license/
 * 
 * Source: $HeadURL$ ($Revision$)
 * Last changed: $Date$
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.02.04 at 11:28:46 AM MEZ 
//
package de.osmembrane.model.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * Describes an enumeration value available for use in a parameter with the
 * "enum" data type.
 * 
 * 
 * <p>
 * Java class for XMLEnumValue complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="XMLEnumValue">
 *   &lt;complexContent>
 *     &lt;extension base="{http://osmembrane.de/model/xml}XMLHasDescription">
 *       &lt;attribute name="value" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="friendlyName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMLEnumValue")
@SuppressWarnings(value = "all")
public class XMLEnumValue extends XMLHasDescription {

	@XmlAttribute(required = true)
	protected String value;
	@XmlAttribute
	protected String friendlyName;

	/**
	 * Gets the value of the value property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the value of the value property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setValue(String value) {
		this.value = value;
	}

	public boolean isSetValue() {
		return (this.value != null);
	}

	/**
	 * Gets the value of the friendlyName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFriendlyName() {
		return friendlyName;
	}

	/**
	 * Sets the value of the friendlyName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFriendlyName(String value) {
		this.friendlyName = value;
	}

	public boolean isSetFriendlyName() {
		return (this.friendlyName != null);
	}

}
