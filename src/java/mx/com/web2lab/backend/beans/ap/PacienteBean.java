package mx.com.web2lab.backend.beans.ap;

import java.io.Serializable;

public class PacienteBean implements Serializable {

    /** identifier field */
    private java.lang.Integer kpacientefundacion = new java.lang.Integer(0);

    /** persistent field */
    private java.lang.String snombre = "";

    /** persistent field */
    private java.lang.String sappaterno = "";

    /** nullable persistent field */
    private java.lang.String sapmaterno = "";

    /** nullable persistent field */
    private java.util.Date dnacimiento;

    /** nullable persistent field */
    private java.lang.String snacimiento = "";
    
	/** nullable persistent field */
    private java.lang.String sdireccion = "";

    /** nullable persistent field */
    private java.lang.String scolonia = "";

    /** nullable persistent field */
    private java.lang.String sdelegmuni = "";

    /** nullable persistent field */
    private int ccodigopostal;    
    
    /** nullable persistent field */
    private java.lang.String scodigopostal = "";
    
    /** nullable persistent field */
    private java.lang.String stelefono = "";
    
    /** nullable persistent field */
    private java.lang.String scelular = "";

    /** nullable persistent field */
    private java.lang.String scorreoelectronico = "";

    /** nullable persistent field */
    private java.lang.String sciudad = "";

    /** nullable persistent field */
    private boolean bregistroactivo;

    /** persistent field */
    private int cusuario;

	/** persistent field */
    private int csexo;

	/** persistent field */
    private int cconvenio = 0;    

    private String svalorexpediente;
    
    private int uopcionenviocorreo = 0;

    private String spasswordexpediente = "";

    private String spasswordexpedienteenvio = "";
    
    private int cmarca = 1;

    private int csucursal = 1;

    private String sgrupoid = "";
    
    private String snumcredencial = "";
    
    private String snumnomina = "";
    
    private String snumbeneficiario = "";
    
    private String sproveedorreferencia = "";
    
    private String snombremedico = "";
    
    private String sapellidopaternomedico = "";
    
    private String sapellidomaternomedico = "";
    
    private String sfechaconsulta = "";
    
    private double msumadisponible = 0.0;
    
    private int bvitamedica = 0;
    
    private String sCPT = "";
    
    private String smensagevitamedica = "";
    
    private int utipopaciente;
    
    public PacienteBean () {

    }
    
    public PacienteBean (String sexpediente) {
    	this.svalorexpediente = sexpediente;
    	this.kpacientefundacion = new Integer(-5);
    }
    
    public java.lang.String getSnacimiento() {
		return snacimiento;
	}

	public void setSnacimiento(java.lang.String snacimiento) {
		this.snacimiento = snacimiento;
	}    
    
    public java.lang.Integer getKpacientefundacion() {
        return this.kpacientefundacion;
    }

    public void setKpacientefundacion(java.lang.Integer kpacientefundacion) {
        this.kpacientefundacion = kpacientefundacion;
    }

    public java.lang.String getSnombre() {
        return this.snombre;
    }

    public void setSnombre(java.lang.String snombre) {
        this.snombre = snombre;
    }

    public java.lang.String getSappaterno() {
        return this.sappaterno;
    }

    public void setSappaterno(java.lang.String sappaterno) {
        this.sappaterno = sappaterno;
    }

    public java.lang.String getSapmaterno() {
        return this.sapmaterno;
    }

    public void setSapmaterno(java.lang.String sapmaterno) {
        this.sapmaterno = sapmaterno;
    }

    public java.util.Date getDnacimiento() {
        return this.dnacimiento;
    }

    public void setDnacimiento(java.util.Date dnacimiento) {
        this.dnacimiento = dnacimiento;
    }

    public java.lang.String getSdireccion() {
        return this.sdireccion;
    }

    public void setSdireccion(java.lang.String sdireccion) {
        this.sdireccion = sdireccion;
    }

    public java.lang.String getScolonia() {
        return this.scolonia;
    }

    public void setScolonia(java.lang.String scolonia) {
        this.scolonia = scolonia;
    }

    public java.lang.String getSdelegmuni() {
        return this.sdelegmuni;
    }

    public void setSdelegmuni(java.lang.String sdelegmuni) {
        this.sdelegmuni = sdelegmuni;
    }


    public java.lang.String getStelefono() {
        return this.stelefono;
    }

    public void setStelefono(java.lang.String stelefono) {
        this.stelefono = stelefono;
    }

    public boolean isBregistroactivo() {
        return this.bregistroactivo;
    }

    public void setBregistroactivo(boolean bregistroactivo) {
        this.bregistroactivo = bregistroactivo;
    }

    public int getCusuario() {
        return this.cusuario;
    }

    public void setCusuario(int cusuario) {
        this.cusuario = cusuario;
    }

    public java.util.Date getDregistro() {
        return this.dregistro;
    }

    public void setDregistro(java.util.Date dregistro) {
        this.dregistro = dregistro;
    }

    public int getCsexo() {
        return this.csexo;
    }

    public void setCsexo(int csexo) {
        this.csexo = csexo;
    }
    
    /** nullable persistent field */
    private java.util.Date dregistro;


	public java.lang.String getScorreoelectronico() {
		return scorreoelectronico;
	}

	public void setScorreoelectronico(java.lang.String scorreoelectronico) {
		this.scorreoelectronico = scorreoelectronico;
	}

	public java.lang.String getSciudad() {
		return sciudad;
	}

	public void setSciudad(java.lang.String sciudad) {
		this.sciudad = sciudad;
	}

	public java.lang.String getScelular() {
		return scelular;
	}

	public void setScelular(java.lang.String scelular) {
		this.scelular = scelular;
	}

	public int getCcodigopostal() {
		return ccodigopostal;
	}

	public void setCcodigopostal(int ccodigopostal) {
		this.ccodigopostal = ccodigopostal;
	}

	public java.lang.String getScodigopostal() {
		return scodigopostal;
	}

	public void setScodigopostal(java.lang.String scodigopostal) {
		this.scodigopostal = scodigopostal;
	}

	public int getCconvenio() {
		return cconvenio;
	}

	public void setCconvenio(int cconvenio) {
		this.cconvenio = cconvenio;
	}

	public void setSvalorexpediente(String svalorexpediente) {
		this.svalorexpediente = svalorexpediente;
	}

	public String getSvalorexpediente() {
		return svalorexpediente;
	}

	public void setUopcionenviocorreo(int uopcionenviocorreo) {
		this.uopcionenviocorreo = uopcionenviocorreo;
	}

	public int getUopcionenviocorreo() {
		return uopcionenviocorreo;
	}

	public void setSpasswordexpediente(String spasswordexpediente) {
		this.spasswordexpediente = spasswordexpediente;
	}

	public String getSpasswordexpediente() {
		return spasswordexpediente;
	}

	public void setSpasswordexpedienteenvio(String spasswordexpedienteenvio) {
		this.spasswordexpedienteenvio = spasswordexpedienteenvio;
	}

	public String getSpasswordexpedienteenvio() {
		return spasswordexpedienteenvio;
	}

	public int getCmarca() {
		return cmarca;
	}

	public void setCmarca(int cmarca) {
		this.cmarca = cmarca;
	}

	public int getCsucursal() {
		return csucursal;
	}

	public void setCsucursal(int csucursal) {
		this.csucursal = csucursal;
	}

	public String getSgrupoid() {
		return sgrupoid;
	}

	public void setSgrupoid(String sgrupoid) {
		this.sgrupoid = sgrupoid;
	}

	public String getSnumcredencial() {
		return snumcredencial;
	}

	public void setSnumcredencial(String snumcredencial) {
		this.snumcredencial = snumcredencial;
	}

	public String getSnumnomina() {
		return snumnomina;
	}

	public void setSnumnomina(String snumnomina) {
		this.snumnomina = snumnomina;
	}

	public double getMsumadisponible() {
		return msumadisponible;
	}

	public void setMsumadisponible(double msumadisponible) {
		this.msumadisponible = msumadisponible;
	}

	public String getSnumbeneficiario() {
		return snumbeneficiario;
	}

	public void setSnumbeneficiario(String snumbeneficiario) {
		this.snumbeneficiario = snumbeneficiario;
	}

	public String getSproveedorreferencia() {
		return sproveedorreferencia;
	}

	public void setSproveedorreferencia(String sproveedorreferencia) {
		this.sproveedorreferencia = sproveedorreferencia;
	}

	public String getSnombremedico() {
		return snombremedico;
	}

	public void setSnombremedico(String snombremedico) {
		this.snombremedico = snombremedico;
	}

	public String getSapellidopaternomedico() {
		return sapellidopaternomedico;
	}

	public void setSapellidopaternomedico(String sapellidopaternomedico) {
		this.sapellidopaternomedico = sapellidopaternomedico;
	}

	public String getSapellidomaternomedico() {
		return sapellidomaternomedico;
	}

	public void setSapellidomaternomedico(String sapellidomaternomedico) {
		this.sapellidomaternomedico = sapellidomaternomedico;
	}

	public int getBvitamedica() {
		return bvitamedica;
	}

	public void setBvitamedica(int bvitamedica) {
		this.bvitamedica = bvitamedica;
	}

	public String getSfechaconsulta() {
		return sfechaconsulta;
	}

	public void setSfechaconsulta(String sfechaconsulta) {
		this.sfechaconsulta = sfechaconsulta;
	}

	public String getsCPT() {
		return sCPT;
	}

	public void setsCPT(String sCPT) {
		this.sCPT = sCPT;
	}

	public String getSmensagevitamedica() {
		return smensagevitamedica;
	}

	public void setSmensagevitamedica(String smensagevitamedica) {
		this.smensagevitamedica = smensagevitamedica;
	}

	public int getUtipopaciente() {
		return utipopaciente;
	}

	public void setUtipopaciente(int utipopaciente) {
		this.utipopaciente = utipopaciente;
	}
}
