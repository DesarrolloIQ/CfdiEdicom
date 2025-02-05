
package com.edicom.ediwinws.service.ediwinintegration;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.edicom.ediwinws.service.ediwinintegration package. 
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

    private final static QName _Fault_QNAME = new QName("http://ediwinIntegration.service.ediwinws.edicom.com", "fault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.edicom.ediwinws.service.ediwinintegration
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PublishDocument }
     * 
     */
    public PublishDocument createPublishDocument() {
        return new PublishDocument();
    }

    /**
     * Create an instance of {@link Param }
     * 
     */
    public Param createParam() {
        return new Param();
    }

    /**
     * Create an instance of {@link PublishDocumentResponse }
     * 
     */
    public PublishDocumentResponse createPublishDocumentResponse() {
        return new PublishDocumentResponse();
    }

    /**
     * Create an instance of {@link EdiwinIntegrationException }
     * 
     */
    public EdiwinIntegrationException createEdiwinIntegrationException() {
        return new EdiwinIntegrationException();
    }

    /**
     * Create an instance of {@link ChangeExtendedFieldValues }
     * 
     */
    public ChangeExtendedFieldValues createChangeExtendedFieldValues() {
        return new ChangeExtendedFieldValues();
    }

    /**
     * Create an instance of {@link OperationParam }
     * 
     */
    public OperationParam createOperationParam() {
        return new OperationParam();
    }

    /**
     * Create an instance of {@link ChangeExtendedFieldValuesResponse }
     * 
     */
    public ChangeExtendedFieldValuesResponse createChangeExtendedFieldValuesResponse() {
        return new ChangeExtendedFieldValuesResponse();
    }

    /**
     * Create an instance of {@link TransformData }
     * 
     */
    public TransformData createTransformData() {
        return new TransformData();
    }

    /**
     * Create an instance of {@link TransformDataResponse }
     * 
     */
    public TransformDataResponse createTransformDataResponse() {
        return new TransformDataResponse();
    }

    /**
     * Create an instance of {@link GetCustomData }
     * 
     */
    public GetCustomData createGetCustomData() {
        return new GetCustomData();
    }

    /**
     * Create an instance of {@link GetCustomDataResponse }
     * 
     */
    public GetCustomDataResponse createGetCustomDataResponse() {
        return new GetCustomDataResponse();
    }

    /**
     * Create an instance of {@link GetUnzipDocument }
     * 
     */
    public GetUnzipDocument createGetUnzipDocument() {
        return new GetUnzipDocument();
    }

    /**
     * Create an instance of {@link GetUnzipDocumentResponse }
     * 
     */
    public GetUnzipDocumentResponse createGetUnzipDocumentResponse() {
        return new GetUnzipDocumentResponse();
    }

    /**
     * Create an instance of {@link GetDocument }
     * 
     */
    public GetDocument createGetDocument() {
        return new GetDocument();
    }

    /**
     * Create an instance of {@link GetDocumentResponse }
     * 
     */
    public GetDocumentResponse createGetDocumentResponse() {
        return new GetDocumentResponse();
    }

    /**
     * Create an instance of {@link Error }
     * 
     */
    public Error createError() {
        return new Error();
    }

    /**
     * Create an instance of {@link ArrayOfError }
     * 
     */
    public ArrayOfError createArrayOfError() {
        return new ArrayOfError();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EdiwinIntegrationException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EdiwinIntegrationException }{@code >}
     */
    @XmlElementDecl(namespace = "http://ediwinIntegration.service.ediwinws.edicom.com", name = "fault")
    public JAXBElement<EdiwinIntegrationException> createFault(EdiwinIntegrationException value) {
        return new JAXBElement<EdiwinIntegrationException>(_Fault_QNAME, EdiwinIntegrationException.class, null, value);
    }

}
