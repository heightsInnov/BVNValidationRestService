
package com.nibss.bvn.validationv2;

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
@WebService(name = "BVNValidationService", targetNamespace = "http://validationV2.bvn.nibss.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface BVNValidationService {


    /**
     * 
     * @param searchInputs
     * @return
     *     returns com.nibss.bvn.validationv2.SearchResults
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(name = "SearchResults", targetNamespace = "")
    @RequestWrapper(localName = "validateMultipleBVNs", targetNamespace = "http://validationV2.bvn.nibss.com/", className = "com.nibss.bvn.validationv2.ValidateMultipleBVNs")
    @ResponseWrapper(localName = "validateMultipleBVNsResponse", targetNamespace = "http://validationV2.bvn.nibss.com/", className = "com.nibss.bvn.validationv2.ValidateMultipleBVNsResponse")
    public SearchResults validateMultipleBVNs(
        @WebParam(name = "SearchInputs", targetNamespace = "")
        String searchInputs)
        throws Exception_Exception
    ;

    /**
     * 
     * @param searchInput
     * @return
     *     returns com.nibss.bvn.validationv2.SearchResult
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(name = "SearchResult", targetNamespace = "")
    @RequestWrapper(localName = "validateSingleBVN", targetNamespace = "http://validationV2.bvn.nibss.com/", className = "com.nibss.bvn.validationv2.ValidateSingleBVN")
    @ResponseWrapper(localName = "validateSingleBVNResponse", targetNamespace = "http://validationV2.bvn.nibss.com/", className = "com.nibss.bvn.validationv2.ValidateSingleBVNResponse")
    public SearchResult validateSingleBVN(
        @WebParam(name = "SearchInput", targetNamespace = "")
        String searchInput)
        throws Exception_Exception
    ;

}
