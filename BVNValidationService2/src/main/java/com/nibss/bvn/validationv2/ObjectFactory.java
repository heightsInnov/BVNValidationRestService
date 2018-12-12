
package com.nibss.bvn.validationv2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.nibss.bvn.validationv2 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ValidateSingleBVNResponse_QNAME = new QName("http://validationV2.bvn.nibss.com/", "validateSingleBVNResponse");
    private final static QName _ValidateMultipleBVNs_QNAME = new QName("http://validationV2.bvn.nibss.com/", "validateMultipleBVNs");
    private final static QName _ValidateSingleBVN_QNAME = new QName("http://validationV2.bvn.nibss.com/", "validateSingleBVN");
    private final static QName _ValidateMultipleBVNsResponse_QNAME = new QName("http://validationV2.bvn.nibss.com/", "validateMultipleBVNsResponse");
    private final static QName _SearchResults_QNAME = new QName("http://validationV2.bvn.nibss.com/", "SearchResults");
    private final static QName _Exception_QNAME = new QName("http://validationV2.bvn.nibss.com/", "Exception");
    private final static QName _SearchResult_QNAME = new QName("http://validationV2.bvn.nibss.com/", "SearchResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.nibss.bvn.validationv2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ValidateMultipleBVNs }
     * 
     */
    public ValidateMultipleBVNs createValidateMultipleBVNs() {
        return new ValidateMultipleBVNs();
    }

    /**
     * Create an instance of {@link ValidateSingleBVN }
     * 
     */
    public ValidateSingleBVN createValidateSingleBVN() {
        return new ValidateSingleBVN();
    }

    /**
     * Create an instance of {@link ValidateSingleBVNResponse }
     * 
     */
    public ValidateSingleBVNResponse createValidateSingleBVNResponse() {
        return new ValidateSingleBVNResponse();
    }

    /**
     * Create an instance of {@link SearchResult }
     * 
     */
    public SearchResult createSearchResult() {
        return new SearchResult();
    }

    /**
     * Create an instance of {@link SearchResults }
     * 
     */
    public SearchResults createSearchResults() {
        return new SearchResults();
    }

    /**
     * Create an instance of {@link ValidateMultipleBVNsResponse }
     * 
     */
    public ValidateMultipleBVNsResponse createValidateMultipleBVNsResponse() {
        return new ValidateMultipleBVNsResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateSingleBVNResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://validationV2.bvn.nibss.com/", name = "validateSingleBVNResponse")
    public JAXBElement<ValidateSingleBVNResponse> createValidateSingleBVNResponse(ValidateSingleBVNResponse value) {
        return new JAXBElement<ValidateSingleBVNResponse>(_ValidateSingleBVNResponse_QNAME, ValidateSingleBVNResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateMultipleBVNs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://validationV2.bvn.nibss.com/", name = "validateMultipleBVNs")
    public JAXBElement<ValidateMultipleBVNs> createValidateMultipleBVNs(ValidateMultipleBVNs value) {
        return new JAXBElement<ValidateMultipleBVNs>(_ValidateMultipleBVNs_QNAME, ValidateMultipleBVNs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateSingleBVN }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://validationV2.bvn.nibss.com/", name = "validateSingleBVN")
    public JAXBElement<ValidateSingleBVN> createValidateSingleBVN(ValidateSingleBVN value) {
        return new JAXBElement<ValidateSingleBVN>(_ValidateSingleBVN_QNAME, ValidateSingleBVN.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateMultipleBVNsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://validationV2.bvn.nibss.com/", name = "validateMultipleBVNsResponse")
    public JAXBElement<ValidateMultipleBVNsResponse> createValidateMultipleBVNsResponse(ValidateMultipleBVNsResponse value) {
        return new JAXBElement<ValidateMultipleBVNsResponse>(_ValidateMultipleBVNsResponse_QNAME, ValidateMultipleBVNsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchResults }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://validationV2.bvn.nibss.com/", name = "SearchResults")
    public JAXBElement<SearchResults> createSearchResults(SearchResults value) {
        return new JAXBElement<SearchResults>(_SearchResults_QNAME, SearchResults.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://validationV2.bvn.nibss.com/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://validationV2.bvn.nibss.com/", name = "SearchResult")
    public JAXBElement<SearchResult> createSearchResult(SearchResult value) {
        return new JAXBElement<SearchResult>(_SearchResult_QNAME, SearchResult.class, null, value);
    }

}
