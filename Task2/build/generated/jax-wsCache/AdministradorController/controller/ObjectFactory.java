
package controller;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the controller package. 
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

    private final static QName _EliminarAdministradorResponse_QNAME = new QName("http://controller/", "eliminarAdministradorResponse");
    private final static QName _GetAdministradores_QNAME = new QName("http://controller/", "getAdministradores");
    private final static QName _GuardarAdministradorResponse_QNAME = new QName("http://controller/", "guardarAdministradorResponse");
    private final static QName _GetAdministradoresResponse_QNAME = new QName("http://controller/", "getAdministradoresResponse");
    private final static QName _EliminarAdministrador_QNAME = new QName("http://controller/", "eliminarAdministrador");
    private final static QName _GuardarAdministrador_QNAME = new QName("http://controller/", "guardarAdministrador");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: controller
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GuardarAdministrador }
     * 
     */
    public GuardarAdministrador createGuardarAdministrador() {
        return new GuardarAdministrador();
    }

    /**
     * Create an instance of {@link EliminarAdministrador }
     * 
     */
    public EliminarAdministrador createEliminarAdministrador() {
        return new EliminarAdministrador();
    }

    /**
     * Create an instance of {@link GetAdministradoresResponse }
     * 
     */
    public GetAdministradoresResponse createGetAdministradoresResponse() {
        return new GetAdministradoresResponse();
    }

    /**
     * Create an instance of {@link EliminarAdministradorResponse }
     * 
     */
    public EliminarAdministradorResponse createEliminarAdministradorResponse() {
        return new EliminarAdministradorResponse();
    }

    /**
     * Create an instance of {@link GetAdministradores }
     * 
     */
    public GetAdministradores createGetAdministradores() {
        return new GetAdministradores();
    }

    /**
     * Create an instance of {@link GuardarAdministradorResponse }
     * 
     */
    public GuardarAdministradorResponse createGuardarAdministradorResponse() {
        return new GuardarAdministradorResponse();
    }

    /**
     * Create an instance of {@link AdministradorDto }
     * 
     */
    public AdministradorDto createAdministradorDto() {
        return new AdministradorDto();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarAdministradorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller/", name = "eliminarAdministradorResponse")
    public JAXBElement<EliminarAdministradorResponse> createEliminarAdministradorResponse(EliminarAdministradorResponse value) {
        return new JAXBElement<EliminarAdministradorResponse>(_EliminarAdministradorResponse_QNAME, EliminarAdministradorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAdministradores }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller/", name = "getAdministradores")
    public JAXBElement<GetAdministradores> createGetAdministradores(GetAdministradores value) {
        return new JAXBElement<GetAdministradores>(_GetAdministradores_QNAME, GetAdministradores.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GuardarAdministradorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller/", name = "guardarAdministradorResponse")
    public JAXBElement<GuardarAdministradorResponse> createGuardarAdministradorResponse(GuardarAdministradorResponse value) {
        return new JAXBElement<GuardarAdministradorResponse>(_GuardarAdministradorResponse_QNAME, GuardarAdministradorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAdministradoresResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller/", name = "getAdministradoresResponse")
    public JAXBElement<GetAdministradoresResponse> createGetAdministradoresResponse(GetAdministradoresResponse value) {
        return new JAXBElement<GetAdministradoresResponse>(_GetAdministradoresResponse_QNAME, GetAdministradoresResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarAdministrador }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller/", name = "eliminarAdministrador")
    public JAXBElement<EliminarAdministrador> createEliminarAdministrador(EliminarAdministrador value) {
        return new JAXBElement<EliminarAdministrador>(_EliminarAdministrador_QNAME, EliminarAdministrador.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GuardarAdministrador }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller/", name = "guardarAdministrador")
    public JAXBElement<GuardarAdministrador> createGuardarAdministrador(GuardarAdministrador value) {
        return new JAXBElement<GuardarAdministrador>(_GuardarAdministrador_QNAME, GuardarAdministrador.class, null, value);
    }

}
