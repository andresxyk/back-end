package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CDireccionMedico implements Serializable {

    /** identifier field */
    private java.lang.Integer cdireccionmedico;

    /** nullable persistent field */
    private java.lang.String sdireccion;

    /** nullable persistent field */
    private java.lang.String stelefono;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CCodigoPostal ccodigopostal;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CReferenciaDireccion creferenciadireccion;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.ap.medico.CMedico cmedico;
    
    private java.lang.Integer user_id;
    
    private java.lang.Integer user_id_change;

    /** full constructor */
    public CDireccionMedico(java.lang.Integer cdireccionmedico, java.lang.String sdireccion, java.lang.String stelefono, mx.com.web2lab.backend.hbm.om.ap.CCodigoPostal ccodigopostal, mx.com.web2lab.backend.hbm.om.ap.CReferenciaDireccion creferenciadireccion, mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro, mx.com.web2lab.backend.hbm.om.ap.medico.CMedico cmedico) {
        this.cdireccionmedico = cdireccionmedico;
        this.sdireccion = sdireccion;
        this.stelefono = stelefono;
        this.ccodigopostal = ccodigopostal;
        this.creferenciadireccion = creferenciadireccion;
        this.cestadoregistro = cestadoregistro;
        this.cmedico = cmedico;
    }

    /** default constructor */
    public CDireccionMedico() {
    }

    /** minimal constructor */
    public CDireccionMedico(java.lang.Integer cdireccionmedico, mx.com.web2lab.backend.hbm.om.ap.CCodigoPostal ccodigopostal, mx.com.web2lab.backend.hbm.om.ap.CReferenciaDireccion creferenciadireccion, mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro, mx.com.web2lab.backend.hbm.om.ap.medico.CMedico cmedico) {
        this.cdireccionmedico = cdireccionmedico;
        this.ccodigopostal = ccodigopostal;
        this.creferenciadireccion = creferenciadireccion;
        this.cestadoregistro = cestadoregistro;
        this.cmedico = cmedico;
    }

    
    public java.lang.Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(java.lang.Integer user_id) {
		this.user_id = user_id;
	}

	public java.lang.Integer getUser_id_change() {
		return user_id_change;
	}

	public void setUser_id_change(java.lang.Integer user_id_change) {
		this.user_id_change = user_id_change;
	}

	public java.lang.Integer getCdireccionmedico() {
        return this.cdireccionmedico;
    }

    public void setCdireccionmedico(java.lang.Integer cdireccionmedico) {
        this.cdireccionmedico = cdireccionmedico;
    }

    public java.lang.String getSdireccion() {
        return this.sdireccion;
    }

    public void setSdireccion(java.lang.String sdireccion) {
        this.sdireccion = sdireccion;
    }

    public java.lang.String getStelefono() {
        return this.stelefono;
    }

    public void setStelefono(java.lang.String stelefono) {
        this.stelefono = stelefono;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CCodigoPostal getCcodigopostal() {
        return this.ccodigopostal;
    }

    public void setCcodigopostal(mx.com.web2lab.backend.hbm.om.ap.CCodigoPostal ccodigopostal) {
        this.ccodigopostal = ccodigopostal;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CReferenciaDireccion getCreferenciadireccion() {
        return this.creferenciadireccion;
    }

    public void setCreferenciadireccion(mx.com.web2lab.backend.hbm.om.ap.CReferenciaDireccion creferenciadireccion) {
        this.creferenciadireccion = creferenciadireccion;
    }

    public mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro getCestadoregistro() {
        return this.cestadoregistro;
    }

    public void setCestadoregistro(mx.com.web2lab.backend.hbm.om.ap.CEstadoRegistro cestadoregistro) {
        this.cestadoregistro = cestadoregistro;
    }

    public mx.com.web2lab.backend.hbm.om.ap.medico.CMedico getCmedico() {
        return this.cmedico;
    }

    public void setCmedico(mx.com.web2lab.backend.hbm.om.ap.medico.CMedico cmedico) {
        this.cmedico = cmedico;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cdireccionmedico", getCdireccionmedico())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CDireccionMedico) ) return false;
        CDireccionMedico castOther = (CDireccionMedico) other;
        return new EqualsBuilder()
            .append(this.getCdireccionmedico(), castOther.getCdireccionmedico())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCdireccionmedico())
            .toHashCode();
    }

}
