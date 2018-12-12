
package com.nibss.bvn.validationv2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for validateMultipleBVNsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="validateMultipleBVNsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SearchResults" type="{http://validationV2.bvn.nibss.com/}SearchResults" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "validateMultipleBVNsResponse", propOrder = {
    "searchResults"
})
public class ValidateMultipleBVNsResponse {

    @XmlElement(name = "SearchResults")
    protected SearchResults searchResults;

    /**
     * Gets the value of the searchResults property.
     * 
     * @return
     *     possible object is
     *     {@link SearchResults }
     *     
     */
    public SearchResults getSearchResults() {
        return searchResults;
    }

    /**
     * Sets the value of the searchResults property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchResults }
     *     
     */
    public void setSearchResults(SearchResults value) {
        this.searchResults = value;
    }

}
