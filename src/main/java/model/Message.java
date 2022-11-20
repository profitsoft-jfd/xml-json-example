
package model;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * <p>Java class for message complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="message">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="header" type="{}stringtype"/>
 *         &lt;element name="body" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="messid" type="{}messidtype"/>
 *         &lt;element name="size" type="{}inttype"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "message", propOrder = {
    "header", "body",  "size"
})
@JsonPropertyOrder({"_id", "header", "body",  "size"})
public class Message {

    @XmlElement(required = true)
    protected String header;
    protected String body;
    @XmlAttribute(required = true)
    @JsonIgnore
    protected String messid;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger size;

    /**
     * Gets the value of the header property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setHeader(String value) {
        this.header = value;
    }

    /**
     * Gets the value of the body property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets the value of the body property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setBody(String value) {
        this.body = value;
    }

    /**
     * Gets the value of the messid property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMessid() {
        return messid;
    }

    /**
     * Sets the value of the messid property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMessid(String value) {
        this.messid = value;
    }

    /**
     * Gets the value of the size property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getSize() {
        return size;
    }

    /**
     * Sets the value of the size property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setSize(BigInteger value) {
        this.size = value;
    }

    @Override
    public String toString() {
        return "Id:" + messid + ", Header: " + header + ", Body:" + body + ", Size: " + size;
    }
}
