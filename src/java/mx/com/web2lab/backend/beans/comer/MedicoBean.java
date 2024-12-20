package mx.com.web2lab.backend.beans.comer;

import java.io.Serializable;

import mx.com.web2lab.backend.util.formatos.Formatos;

public class MedicoBean implements Serializable {

    /** identifier field */
    private int czona = 0;

    /** identifier field */
    private int kmedico = 0;
    
    /** identifier field */
    private java.lang.Long cmedico = new Long(0);

    /** persistent field */
    private java.lang.String snombre = "";

    /** persistent field */
    private java.lang.String sappaterno = "";

    /** nullable persistent field */
    private java.lang.String sapmaterno = "";

    /** nullable persistent field */
    private java.util.Date dnacimiento = new java.util.Date();

    /** nullable persistent field */
    private java.lang.String snacimiento = "";
    
    /** nullable persistent field */
    private java.lang.String sdireccion = "";

    /** nullable persistent field */
    private java.lang.String scolonia = "";

    /** nullable persistent field */
    private java.lang.String sdelegmuni = "";

    /** nullable persistent field */
    private java.lang.String scodigopostal = "";

    /** nullable persistent field */
    private int kcodigopostal = 0;
    
    /** nullable persistent field */
    private java.lang.String stelefono = "";

    /** nullable persistent field */
    private boolean bregistroactivo = true;

    /** persistent field */
    private int cusuario = 0;

    /** nullable persistent field */
    private java.util.Date dregistro = new java.util.Date();;

    /** persistent field */
    private int usexo = 0;

    /** nullable persistent field */
    private java.lang.String scorreoelectro = "";

    /** nullable persistent field */
    private java.lang.String sciudad = "";

    private int casentamiento = 0;

    /** persistent field */
    private int cespecialidad = 0;

    /** persistent field */
    private String sespecialidad = "";

    /** persistent field */
    private String srfc = "";
    
    /** persistent field */
    private int utipooperacion = 0;

    private int cformapagomedico;

    private java.lang.String shorariovisita;

    private java.lang.String scurp;

    private int ucategoriamedico;

    private String sestadomedico;
    
    private int uestadomedico = 0;
    
    private String sorderby = "";
    
    private String sgriddirecciones = "";
    
    private String sgridtelefonos = "";
    
    private String tipoDireccion;
    
    private int ctipoDireccion;
    
    private int creferenciadireccion;
    
    private String sreferenciadireccion;
    
    private int userid;
    
    private boolean marcaolab = false;
    
    private boolean marcaazteca = false;
    
    private boolean marcaswisslab = false;
    
    private boolean marcajenner = false;
    
    private boolean marcaliacsa = false;
    
    private boolean marcafamilylabsnorte = false;
    
    private boolean marcaasesoressur = false;
    
    private boolean marcaexakta = false;
    
    private boolean marcamoreira = false;
    
    private boolean marcapolab = false;
    
    private boolean marcabiomedicareferencia = false;
    
    private boolean marcapromedic = false;
    
    private boolean marcaswisshospital = false;
    
    private String smarcasventa;
   
    private String susuarioweb;
    
    private int cestadoregistro;
    
    private boolean bsustentable;
    
    
   

	public boolean isMarcaswisshospital() {
		return marcaswisshospital;
	}

	public void setMarcaswisshospital(boolean marcaswisshospital) {
		this.marcaswisshospital = marcaswisshospital;
	}

	public boolean isMarcamoreira() {
		return marcamoreira;
	}

	public void setMarcamoreira(boolean marcamoreira) {
		this.marcamoreira = marcamoreira;
	}

	public boolean isMarcapolab() {
		return marcapolab;
	}

	public void setMarcapolab(boolean marcapolab) {
		this.marcapolab = marcapolab;
	}

	public boolean isMarcabiomedicareferencia() {
		return marcabiomedicareferencia;
	}

	public void setMarcabiomedicareferencia(boolean marcabiomedicareferencia) {
		this.marcabiomedicareferencia = marcabiomedicareferencia;
	}

	public boolean isMarcapromedic() {
		return marcapromedic;
	}

	public void setMarcapromedic(boolean marcapromedic) {
		this.marcapromedic = marcapromedic;
	}

	public boolean isBsustentable() {
		return bsustentable;
	}

	public void setBsustentable(boolean bsustentable) {
		this.bsustentable = bsustentable;
	}

	public boolean isMarcaasesoressur() {
		return marcaasesoressur;
	}

	public void setMarcaasesoressur(boolean marcaasesoressur) {
		this.marcaasesoressur = marcaasesoressur;
	}

	public boolean isMarcaexakta() {
		return marcaexakta;
	}

	public void setMarcaexakta(boolean marcaexakta) {
		this.marcaexakta = marcaexakta;
	}

	public boolean isMarcafamilylabsnorte() {
		return marcafamilylabsnorte;
	}

	public void setMarcafamilylabsnorte(boolean marcafamilylabsnorte) {
		this.marcafamilylabsnorte = marcafamilylabsnorte;
	}

	public int getCestadoregistro() {
		return cestadoregistro;
	}

	public void setCestadoregistro(int cestadoregistro) {
		this.cestadoregistro = cestadoregistro;
	}

	public String getSmarcasventa() {
		return smarcasventa;
	}

	public void setSmarcasventa(String smarcasventa) {
		this.smarcasventa = smarcasventa;
	}

	public String getSusuarioweb() {
		return susuarioweb;
	}

	public void setSusuarioweb(String susuarioweb) {
		this.susuarioweb = susuarioweb;
	}

	public boolean isMarcaolab() {
		return marcaolab;
	}

	public void setMarcaolab(boolean marcaolab) {
		this.marcaolab = marcaolab;
	}

	public boolean isMarcaazteca() {
		return marcaazteca;
	}

	public void setMarcaazteca(boolean marcaazteca) {
		this.marcaazteca = marcaazteca;
	}

	public boolean isMarcaswisslab() {
		return marcaswisslab;
	}

	public void setMarcaswisslab(boolean marcaswisslab) {
		this.marcaswisslab = marcaswisslab;
	}

	public boolean isMarcajenner() {
		return marcajenner;
	}

	public void setMarcajenner(boolean marcajenner) {
		this.marcajenner = marcajenner;
	}

	public boolean isMarcaliacsa() {
		return marcaliacsa;
	}

	public void setMarcaliacsa(boolean marcaliacsa) {
		this.marcaliacsa = marcaliacsa;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getCreferenciadireccion() {
		return creferenciadireccion;
	}

	public void setCreferenciadireccion(int creferenciadireccion) {
		this.creferenciadireccion = creferenciadireccion;
	}

	public String getSreferenciadireccion() {
		return sreferenciadireccion;
	}

	public void setSreferenciadireccion(String sreferenciadireccion) {
		this.sreferenciadireccion = sreferenciadireccion;
	}

	public int getCtipoDireccion() {
		return ctipoDireccion;
	}

	public void setCtipoDireccion(int ctipoDireccion) {
		this.ctipoDireccion = ctipoDireccion;
	}

	public String getTipoDireccion() {
		return tipoDireccion;
	}

	public void setTipoDireccion(String tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}

	/** default constructor */
    public MedicoBean() {
    }

    public java.lang.Long getCmedico() {
        return this.cmedico;
    }

    public void setCmedico(java.lang.Long cmedico) {
        this.cmedico = cmedico;
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
        this.snacimiento = (new Formatos().getFechaNumeros(this.dnacimiento));
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

    public java.lang.String getScodigopostal() {
        return this.scodigopostal;
    }

    public void setScodigopostal(java.lang.String scodigopostal) {
        this.scodigopostal = scodigopostal;
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

    public int getUsexo() {
        return this.usexo;
    }

    public void setUsexo(int usexo) {
        this.usexo = usexo;
    }

    public java.lang.String getScorreoelectro() {
        return this.scorreoelectro;
    }

    public void setScorreoelectro(java.lang.String scorreoelectro) {
        this.scorreoelectro = scorreoelectro;
    }

    public java.lang.String getSciudad() {
        return this.sciudad;
    }

    public void setSciudad(java.lang.String sciudad) {
        this.sciudad = sciudad;
    }

	public int getCzona() {
		return czona;
	}

	public void setCzona(int czona) {
		this.czona = czona;
	}

	public int getUtipooperacion() {
		return utipooperacion;
	}

	public void setUtipooperacion(int utipooperacion) {
		this.utipooperacion = utipooperacion;
	}

	public int getCasentamiento() {
		return casentamiento;
	}

	public void setCasentamiento(int casentamiento) {
		this.casentamiento = casentamiento;
	}

	public int getCespecialidad() {
		return cespecialidad;
	}

	public void setCespecialidad(int cespecialidad) {
		this.cespecialidad = cespecialidad;
	}

	public String getSespecialidad() {
		return sespecialidad;
	}

	public void setSespecialidad(String sespecialidad) {
		this.sespecialidad = sespecialidad;
	}

	public java.lang.String getSnacimiento() {
		return snacimiento;
	}

	public void setSnacimiento(java.lang.String snacimiento) {
		this.snacimiento = snacimiento;
	}

	public int getKcodigopostal() {
		return kcodigopostal;
	}

	public void setKcodigopostal(int kcodigopostal) {
		this.kcodigopostal = kcodigopostal;
	}

	public String getSrfc() {
		return srfc;
	}

	public void setSrfc(String srfc) {
		this.srfc = srfc;
	}

	public int getKmedico() {
		return kmedico;
	}

	public void setKmedico(int kmedico) {
		this.kmedico = kmedico;
	}

	public int getCformapagomedico() {
		return cformapagomedico;
	}

	public void setCformapagomedico(int cformapagomedico) {
		this.cformapagomedico = cformapagomedico;
	}

	public java.lang.String getShorariovisita() {
		return shorariovisita;
	}

	public void setShorariovisita(java.lang.String shorariovisita) {
		this.shorariovisita = shorariovisita;
	}

	public java.lang.String getScurp() {
		return scurp;
	}

	public void setScurp(java.lang.String scurp) {
		this.scurp = scurp;
	}

	public int getUcategoriamedico() {
		return ucategoriamedico;
	}

	public void setUcategoriamedico(int ucategoriamedico) {
		this.ucategoriamedico = ucategoriamedico;
	}

	public String getSestadomedico() {
		return sestadomedico;
	}

	public void setSestadomedico(String sestadomedico) {
		this.sestadomedico = sestadomedico;
	}

	public int getUestadomedico() {
		return uestadomedico;
	}

	public void setUestadomedico(int uestadomedico) {
		this.uestadomedico = uestadomedico;
	}

	public String getSorderby() {
		return sorderby;
	}

	public void setSorderby(String sorderby) {
		this.sorderby = sorderby;
	}

	public String getSgriddirecciones() {
		return sgriddirecciones;
	}

	public void setSgriddirecciones(String sgriddirecciones) {
		this.sgriddirecciones = sgriddirecciones;
	}

	public String getSgridtelefonos() {
		return sgridtelefonos;
	}

	public void setSgridtelefonos(String sgridtelefonos) {
		this.sgridtelefonos = sgridtelefonos;
	}
}
