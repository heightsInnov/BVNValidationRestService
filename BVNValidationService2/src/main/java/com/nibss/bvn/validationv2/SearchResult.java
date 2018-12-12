
package com.nibss.bvn.validationv2;

import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BvnSearchResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BinaryImage" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchResult", propOrder = {
    "bvnSearchResult",
    "binaryImage"
})
public class SearchResult {

    @XmlElement(name = "BvnSearchResult", required = true)
    protected String bvnSearchResult;
    @XmlElement(name = "BinaryImage", required = true)
    @XmlMimeType("application/octet-stream")
    protected DataHandler binaryImage;

    /**
     * Gets the value of the bvnSearchResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBvnSearchResult() {
        return bvnSearchResult;
    }

    /**
     * Sets the value of the bvnSearchResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBvnSearchResult(String value) {
        this.bvnSearchResult = value;
    }

    /**
     * Gets the value of the binaryImage property.
     * 
     * @return
     *     possible object is
     *     {@link DataHandler }
     *     
     */
    public DataHandler getBinaryImage() {
        return binaryImage;
    }

    /**
     * Sets the value of the binaryImage property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataHandler }
     *     
     */
    public void setBinaryImage(DataHandler value) {
        this.binaryImage = value;
    }

}
