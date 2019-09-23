
package controller;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para guardarAdministrador complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="guardarAdministrador">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="administrador" type="{http://controller/}administradorDto" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "guardarAdministrador", propOrder = {
    "administrador"
})
public class GuardarAdministrador {

    protected AdministradorDto administrador;

    /**
     * Obtiene el valor de la propiedad administrador.
     * 
     * @return
     *     possible object is
     *     {@link AdministradorDto }
     *     
     */
    public AdministradorDto getAdministrador() {
        return administrador;
    }

    /**
     * Define el valor de la propiedad administrador.
     * 
     * @param value
     *     allowed object is
     *     {@link AdministradorDto }
     *     
     */
    public void setAdministrador(AdministradorDto value) {
        this.administrador = value;
    }

}
