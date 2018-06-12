package mx.com.web2lab.backend.hbm.om.ap;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class EExamenLugarProcesamiento implements Serializable {

    /** identifier field */
    private java.lang.Integer kexamenprocesamiento;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.lis.CExamen cexamen;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.lis.CLugarProcesamiento clugarprocesamiento;

    /** full constructor */
    public EExamenLugarProcesamiento(java.lang.Integer kexamenprocesamiento, mx.com.web2lab.backend.hbm.om.lis.CExamen cexamen, mx.com.web2lab.backend.hbm.om.lis.CLugarProcesamiento clugarprocesamiento) {
        this.kexamenprocesamiento = kexamenprocesamiento;
        this.cexamen = cexamen;
        this.clugarprocesamiento = clugarprocesamiento;
    }

    /** default constructor */
    public EExamenLugarProcesamiento() {
    }

    public java.lang.Integer getKexamenprocesamiento() {
        return this.kexamenprocesamiento;
    }

    public void setKexamenprocesamiento(java.lang.Integer kexamenprocesamiento) {
        this.kexamenprocesamiento = kexamenprocesamiento;
    }

    public mx.com.web2lab.backend.hbm.om.lis.CExamen getCexamen() {
        return this.cexamen;
    }

    public void setCexamen(mx.com.web2lab.backend.hbm.om.lis.CExamen cexamen) {
        this.cexamen = cexamen;
    }

    public mx.com.web2lab.backend.hbm.om.lis.CLugarProcesamiento getClugarprocesamiento() {
        return this.clugarprocesamiento;
    }

    public void setClugarprocesamiento(mx.com.web2lab.backend.hbm.om.lis.CLugarProcesamiento clugarprocesamiento) {
        this.clugarprocesamiento = clugarprocesamiento;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("kexamenprocesamiento", getKexamenprocesamiento())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof EExamenLugarProcesamiento) ) return false;
        EExamenLugarProcesamiento castOther = (EExamenLugarProcesamiento) other;
        return new EqualsBuilder()
            .append(this.getKexamenprocesamiento(), castOther.getKexamenprocesamiento())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKexamenprocesamiento())
            .toHashCode();
    }

}
