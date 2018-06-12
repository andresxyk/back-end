package mx.com.web2lab.backend.hbm.om.fundacion;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class BPacienteCuestionario implements Serializable {

    /** identifier field */
    private java.lang.Long kpacientecuestionario;

    /** nullable persistent field */
    private boolean balergias;

    /** nullable persistent field */
    private java.lang.String smedicamento;

    /** nullable persistent field */
    private boolean btabaquismo;

    /** nullable persistent field */
    private int utabaquismodia;

    /** nullable persistent field */
    private int utabaquismotiempo;

    /** nullable persistent field */
    private boolean bdiabetes;

    /** nullable persistent field */
    private int udiabetestiempo;

    /** nullable persistent field */
    private int umenarca;

    /** nullable persistent field */
    private int udiasritmo1;

    /** nullable persistent field */
    private int udiasritmo2;

    /** nullable persistent field */
    private java.util.Date dfechaultimaregla;

    /** nullable persistent field */
    private int uvidasexualactiva;

    /** nullable persistent field */
    private int unumeroparejassexuales;

    /** nullable persistent field */
    private int ugestaciones;

    /** nullable persistent field */
    private int upartosnormales;

    /** nullable persistent field */
    private int ucesarias;

    /** nullable persistent field */
    private int uabortos;

    /** nullable persistent field */
    private int uprimerembarazo;

    /** nullable persistent field */
    private boolean blactancia;

    /** nullable persistent field */
    private int uclimaterio;

    /** nullable persistent field */
    private boolean bantiritmo;

    /** nullable persistent field */
    private boolean bantilocal;

    /** nullable persistent field */
    private boolean bantiparental;

    /** nullable persistent field */
    private boolean bantioral;

    /** nullable persistent field */
    private boolean bantivasectomia;

    /** nullable persistent field */
    private boolean bantiparche;

    /** nullable persistent field */
    private boolean bantidiu;

    /** nullable persistent field */
    private boolean banticoito;

    /** nullable persistent field */
    private boolean bantisalpingoclasia;

    /** nullable persistent field */
    private boolean bantibarrera;

    /** nullable persistent field */
    private boolean bantinada;

    /** nullable persistent field */
    private boolean bantiimplante;

    /** nullable persistent field */
    private boolean bantiotro;

    /** nullable persistent field */
    private java.lang.String sotroanticonceptivo;

    /** nullable persistent field */
    private java.util.Date dfechaultimopapanicolau;

    /** nullable persistent field */
    private boolean bvph;

    /** nullable persistent field */
    private java.util.Date dfechavph;

    /** nullable persistent field */
    private boolean bantececervico;

    /** nullable persistent field */
    private boolean bantecemama;

    /** nullable persistent field */
    private java.lang.String santeceherefami;

    /** nullable persistent field */
    private java.util.Date dfechahisterectimia;

    /** nullable persistent field */
    private boolean boforectomiaderecho;

    /** nullable persistent field */
    private boolean boforectomiaizuierdo;

    /** nullable persistent field */
    private boolean boforectomiano;

    /** nullable persistent field */
    private java.util.Date dfechaoforectomia;

    /** nullable persistent field */
    private java.lang.String smotivooforectomia;

    /** nullable persistent field */
    private boolean beqx;

    /** nullable persistent field */
    private java.util.Date dfechaeqx;

    /** nullable persistent field */
    private boolean belectrocoagulacion;

    /** nullable persistent field */
    private java.util.Date dfechaelectrocoagulacion;

    /** nullable persistent field */
    private boolean bcrioterapia;

    /** nullable persistent field */
    private java.util.Date dfechacrioterapia;

    /** nullable persistent field */
    private java.lang.String smotivocrioterapia;

    /** nullable persistent field */
    private java.lang.String ssintomatologiaactual;

    /** nullable persistent field */
    private boolean bcervixcentral;

    /** nullable persistent field */
    private boolean bcervixderecho;

    /** nullable persistent field */
    private boolean bcervixizquierdo;

    /** nullable persistent field */
    private boolean bcervixanterior;

    /** nullable persistent field */
    private boolean bcervixposterior;

    /** nullable persistent field */
    private boolean bsecrecionfluida;

    /** nullable persistent field */
    private boolean bsecrecionespesa;

    /** nullable persistent field */
    private boolean bsecrecionsemiespesa;

    /** nullable persistent field */
    private boolean bsecreciongrumosa;

    /** nullable persistent field */
    private boolean bsecrecionespumosa;

    /** nullable persistent field */
    private boolean bsecrecionescasa;

    /** nullable persistent field */
    private boolean bsecrecionmoderada;

    /** nullable persistent field */
    private boolean bsecrecionabundante;

    /** nullable persistent field */
    private boolean bsecrecionmixta;

    /** nullable persistent field */
    private java.lang.String svulvaotros;

    /** nullable persistent field */
    private boolean bunionescamoclumnar;

    /** nullable persistent field */
    private java.lang.String szonasacetopositivas;

    /** nullable persistent field */
    private int utamanoectropion;

    /** nullable persistent field */
    private int utamanoperiorificiador;

    /** nullable persistent field */
    private boolean bprocesoerosivo;

    /** nullable persistent field */
    private boolean bmei;

    /** nullable persistent field */
    private boolean bmeipo;

    /** nullable persistent field */
    private boolean bquistenaboth;

    /** nullable persistent field */
    private java.lang.String squistenaboth;

    /** nullable persistent field */
    private int cestado;

    /** nullable persistent field */
    private boolean bregistroactivo;

    /** persistent field */
    private int cusuario;

    /** nullable persistent field */
    private java.util.Date dregistro;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.fundacion.COcupacionPaciente cocupacionpaciente;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.fundacion.CMotivoEQX cmotivoeqx;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.fundacion.CTiposBiopsia ctiposbiopsia;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.fundacion.CMotivoHisterectomia cmotivohisterectomia;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.fundacion.CEctropion cectropion;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.fundacion.CEscolaridad cescolaridad;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.fundacion.CCervix ccervix;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.fundacion.CLugarPapanicolau clugarpapanicolau;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.fundacion.CEstadoCivil cestadocivil;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.fundacion.CMotivoElectroCoagulacion cmotivoelectrocoagulacion;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.fundacion.CDiu cdiu;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.fundacion.CSecrecion csecrecion;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.fundacion.CPolipo cpolipo;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.fundacion.BPacienteFundacion bpacientefundacion;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.fundacion.COcupacionFamiliar cocupacionfamiliar;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.fundacion.CHTA chta;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.fundacion.CMotivoEstudio cmotivoestudio;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.fundacion.CTratamientoDiabet ctratamientodiabet;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.fundacion.CResultadoPapanicolau cresultadopapanicolau;

    /** full constructor */
    public BPacienteCuestionario(java.lang.Long kpacientecuestionario, boolean balergias, java.lang.String smedicamento, boolean btabaquismo, int utabaquismodia, int utabaquismotiempo, boolean bdiabetes, int udiabetestiempo, int umenarca, int udiasritmo1, int udiasritmo2, java.util.Date dfechaultimaregla, int uvidasexualactiva, int unumeroparejassexuales, int ugestaciones, int upartosnormales, int ucesarias, int uabortos, int uprimerembarazo, boolean blactancia, int uclimaterio, boolean bantiritmo, boolean bantilocal, boolean bantiparental, boolean bantioral, boolean bantivasectomia, boolean bantiparche, boolean bantidiu, boolean banticoito, boolean bantisalpingoclasia, boolean bantibarrera, boolean bantinada, boolean bantiimplante, boolean bantiotro, java.lang.String sotroanticonceptivo, java.util.Date dfechaultimopapanicolau, boolean bvph, java.util.Date dfechavph, boolean bantececervico, boolean bantecemama, java.lang.String santeceherefami, java.util.Date dfechahisterectimia, boolean boforectomiaderecho, boolean boforectomiaizuierdo, boolean boforectomiano, java.util.Date dfechaoforectomia, java.lang.String smotivooforectomia, boolean beqx, java.util.Date dfechaeqx, boolean belectrocoagulacion, java.util.Date dfechaelectrocoagulacion, boolean bcrioterapia, java.util.Date dfechacrioterapia, java.lang.String smotivocrioterapia, java.lang.String ssintomatologiaactual, boolean bcervixcentral, boolean bcervixderecho, boolean bcervixizquierdo, boolean bcervixanterior, boolean bcervixposterior, boolean bsecrecionfluida, boolean bsecrecionespesa, boolean bsecrecionsemiespesa, boolean bsecreciongrumosa, boolean bsecrecionespumosa, boolean bsecrecionescasa, boolean bsecrecionmoderada, boolean bsecrecionabundante, boolean bsecrecionmixta, java.lang.String svulvaotros, boolean bunionescamoclumnar, java.lang.String szonasacetopositivas, int utamanoectropion, int utamanoperiorificiador, boolean bprocesoerosivo, boolean bmei, boolean bmeipo, boolean bquistenaboth, java.lang.String squistenaboth, int cestado, boolean bregistroactivo, int cusuario, java.util.Date dregistro, mx.com.web2lab.backend.hbm.om.fundacion.COcupacionPaciente cocupacionpaciente, mx.com.web2lab.backend.hbm.om.fundacion.CMotivoEQX CMotivoEQX, mx.com.web2lab.backend.hbm.om.fundacion.CTiposBiopsia CTiposBiopsia, mx.com.web2lab.backend.hbm.om.fundacion.CMotivoHisterectomia CMotivoHisterectomia, mx.com.web2lab.backend.hbm.om.fundacion.CEctropion CEctropion, mx.com.web2lab.backend.hbm.om.fundacion.CEscolaridad CEscolaridad, mx.com.web2lab.backend.hbm.om.fundacion.CCervix CCervix, mx.com.web2lab.backend.hbm.om.fundacion.CLugarPapanicolau CLugarPapanicolau, mx.com.web2lab.backend.hbm.om.fundacion.CEstadoCivil CEstadoCivil, mx.com.web2lab.backend.hbm.om.fundacion.CMotivoElectroCoagulacion CMotivoElectroCoagulacion, mx.com.web2lab.backend.hbm.om.fundacion.CDiu CDiu, mx.com.web2lab.backend.hbm.om.fundacion.CSecrecion CSecrecion, mx.com.web2lab.backend.hbm.om.fundacion.CPolipo CPolipo, mx.com.web2lab.backend.hbm.om.fundacion.BPacienteFundacion BPacienteFundacion, mx.com.web2lab.backend.hbm.om.fundacion.COcupacionFamiliar COcupacionFamiliar, mx.com.web2lab.backend.hbm.om.fundacion.CHTA CHTA, mx.com.web2lab.backend.hbm.om.fundacion.CMotivoEstudio CMotivoEstudio, mx.com.web2lab.backend.hbm.om.fundacion.CTratamientoDiabet CTratamientoDiabet, mx.com.web2lab.backend.hbm.om.fundacion.CResultadoPapanicolau CResultadoPapanicolau) {
        this.kpacientecuestionario = kpacientecuestionario;
        this.balergias = balergias;
        this.smedicamento = smedicamento;
        this.btabaquismo = btabaquismo;
        this.utabaquismodia = utabaquismodia;
        this.utabaquismotiempo = utabaquismotiempo;
        this.bdiabetes = bdiabetes;
        this.udiabetestiempo = udiabetestiempo;
        this.umenarca = umenarca;
        this.udiasritmo1 = udiasritmo1;
        this.udiasritmo2 = udiasritmo2;
        this.dfechaultimaregla = dfechaultimaregla;
        this.uvidasexualactiva = uvidasexualactiva;
        this.unumeroparejassexuales = unumeroparejassexuales;
        this.ugestaciones = ugestaciones;
        this.upartosnormales = upartosnormales;
        this.ucesarias = ucesarias;
        this.uabortos = uabortos;
        this.uprimerembarazo = uprimerembarazo;
        this.blactancia = blactancia;
        this.uclimaterio = uclimaterio;
        this.bantiritmo = bantiritmo;
        this.bantilocal = bantilocal;
        this.bantiparental = bantiparental;
        this.bantioral = bantioral;
        this.bantivasectomia = bantivasectomia;
        this.bantiparche = bantiparche;
        this.bantidiu = bantidiu;
        this.banticoito = banticoito;
        this.bantisalpingoclasia = bantisalpingoclasia;
        this.bantibarrera = bantibarrera;
        this.bantinada = bantinada;
        this.bantiimplante = bantiimplante;
        this.bantiotro = bantiotro;
        this.sotroanticonceptivo = sotroanticonceptivo;
        this.dfechaultimopapanicolau = dfechaultimopapanicolau;
        this.bvph = bvph;
        this.dfechavph = dfechavph;
        this.bantececervico = bantececervico;
        this.bantecemama = bantecemama;
        this.santeceherefami = santeceherefami;
        this.dfechahisterectimia = dfechahisterectimia;
        this.boforectomiaderecho = boforectomiaderecho;
        this.boforectomiaizuierdo = boforectomiaizuierdo;
        this.boforectomiano = boforectomiano;
        this.dfechaoforectomia = dfechaoforectomia;
        this.smotivooforectomia = smotivooforectomia;
        this.beqx = beqx;
        this.dfechaeqx = dfechaeqx;
        this.belectrocoagulacion = belectrocoagulacion;
        this.dfechaelectrocoagulacion = dfechaelectrocoagulacion;
        this.bcrioterapia = bcrioterapia;
        this.dfechacrioterapia = dfechacrioterapia;
        this.smotivocrioterapia = smotivocrioterapia;
        this.ssintomatologiaactual = ssintomatologiaactual;
        this.bcervixcentral = bcervixcentral;
        this.bcervixderecho = bcervixderecho;
        this.bcervixizquierdo = bcervixizquierdo;
        this.bcervixanterior = bcervixanterior;
        this.bcervixposterior = bcervixposterior;
        this.bsecrecionfluida = bsecrecionfluida;
        this.bsecrecionespesa = bsecrecionespesa;
        this.bsecrecionsemiespesa = bsecrecionsemiespesa;
        this.bsecreciongrumosa = bsecreciongrumosa;
        this.bsecrecionespumosa = bsecrecionespumosa;
        this.bsecrecionescasa = bsecrecionescasa;
        this.bsecrecionmoderada = bsecrecionmoderada;
        this.bsecrecionabundante = bsecrecionabundante;
        this.bsecrecionmixta = bsecrecionmixta;
        this.svulvaotros = svulvaotros;
        this.bunionescamoclumnar = bunionescamoclumnar;
        this.szonasacetopositivas = szonasacetopositivas;
        this.utamanoectropion = utamanoectropion;
        this.utamanoperiorificiador = utamanoperiorificiador;
        this.bprocesoerosivo = bprocesoerosivo;
        this.bmei = bmei;
        this.bmeipo = bmeipo;
        this.bquistenaboth = bquistenaboth;
        this.squistenaboth = squistenaboth;
        this.cestado = cestado;
        this.bregistroactivo = bregistroactivo;
        this.cusuario = cusuario;
        this.dregistro = dregistro;
        this.cocupacionpaciente = cocupacionpaciente;
        this.cmotivoeqx = CMotivoEQX;
        this.ctiposbiopsia = CTiposBiopsia;
        this.cmotivohisterectomia = CMotivoHisterectomia;
        this.cectropion = CEctropion;
        this.cescolaridad = CEscolaridad;
        this.ccervix = CCervix;
        this.clugarpapanicolau = CLugarPapanicolau;
        this.cestadocivil = CEstadoCivil;
        this.cmotivoelectrocoagulacion = CMotivoElectroCoagulacion;
        this.cdiu = CDiu;
        this.csecrecion = CSecrecion;
        this.cpolipo = CPolipo;
        this.bpacientefundacion = BPacienteFundacion;
        this.cocupacionfamiliar = COcupacionFamiliar;
        this.chta = CHTA;
        this.cmotivoestudio = CMotivoEstudio;
        this.ctratamientodiabet = CTratamientoDiabet;
        this.cresultadopapanicolau = CResultadoPapanicolau;
    }

    /** default constructor */
    public BPacienteCuestionario() {
    }

    /** minimal constructor */
    public BPacienteCuestionario(java.lang.Long kpacientecuestionario, int cusuario, mx.com.web2lab.backend.hbm.om.fundacion.COcupacionPaciente cocupacionpaciente, mx.com.web2lab.backend.hbm.om.fundacion.CMotivoEQX CMotivoEQX, mx.com.web2lab.backend.hbm.om.fundacion.CTiposBiopsia CTiposBiopsia, mx.com.web2lab.backend.hbm.om.fundacion.CMotivoHisterectomia CMotivoHisterectomia, mx.com.web2lab.backend.hbm.om.fundacion.CEctropion CEctropion, mx.com.web2lab.backend.hbm.om.fundacion.CEscolaridad CEscolaridad, mx.com.web2lab.backend.hbm.om.fundacion.CCervix CCervix, mx.com.web2lab.backend.hbm.om.fundacion.CLugarPapanicolau CLugarPapanicolau, mx.com.web2lab.backend.hbm.om.fundacion.CEstadoCivil CEstadoCivil, mx.com.web2lab.backend.hbm.om.fundacion.CMotivoElectroCoagulacion CMotivoElectroCoagulacion, mx.com.web2lab.backend.hbm.om.fundacion.CDiu CDiu, mx.com.web2lab.backend.hbm.om.fundacion.CSecrecion CSecrecion, mx.com.web2lab.backend.hbm.om.fundacion.CPolipo CPolipo, mx.com.web2lab.backend.hbm.om.fundacion.BPacienteFundacion BPacienteFundacion, mx.com.web2lab.backend.hbm.om.fundacion.COcupacionFamiliar COcupacionFamiliar, mx.com.web2lab.backend.hbm.om.fundacion.CHTA CHTA, mx.com.web2lab.backend.hbm.om.fundacion.CMotivoEstudio CMotivoEstudio, mx.com.web2lab.backend.hbm.om.fundacion.CTratamientoDiabet CTratamientoDiabet, mx.com.web2lab.backend.hbm.om.fundacion.CResultadoPapanicolau CResultadoPapanicolau) {
        this.kpacientecuestionario = kpacientecuestionario;
        this.cusuario = cusuario;
        this.cocupacionpaciente = cocupacionpaciente;
        this.cmotivoeqx = CMotivoEQX;
        this.ctiposbiopsia = CTiposBiopsia;
        this.cmotivohisterectomia = CMotivoHisterectomia;
        this.cectropion = CEctropion;
        this.cescolaridad = CEscolaridad;
        this.ccervix = CCervix;
        this.clugarpapanicolau = CLugarPapanicolau;
        this.cestadocivil = CEstadoCivil;
        this.cmotivoelectrocoagulacion = CMotivoElectroCoagulacion;
        this.cdiu = CDiu;
        this.csecrecion = CSecrecion;
        this.cpolipo = CPolipo;
        this.bpacientefundacion = BPacienteFundacion;
        this.cocupacionfamiliar = COcupacionFamiliar;
        this.chta = CHTA;
        this.cmotivoestudio = CMotivoEstudio;
        this.ctratamientodiabet = CTratamientoDiabet;
        this.cresultadopapanicolau = CResultadoPapanicolau;
        
    }

    public java.lang.Long getKpacientecuestionario() {
        return this.kpacientecuestionario;
    }

    public void setKpacientecuestionario(java.lang.Long kpacientecuestionario) {
        this.kpacientecuestionario = kpacientecuestionario;
    }

    public boolean isBalergias() {
        return this.balergias;
    }

    public void setBalergias(boolean balergias) {
        this.balergias = balergias;
    }

    public java.lang.String getSmedicamento() {
        return this.smedicamento;
    }

    public void setSmedicamento(java.lang.String smedicamento) {
        this.smedicamento = smedicamento;
    }

    public boolean isBtabaquismo() {
        return this.btabaquismo;
    }

    public void setBtabaquismo(boolean btabaquismo) {
        this.btabaquismo = btabaquismo;
    }

    public int getUtabaquismodia() {
        return this.utabaquismodia;
    }

    public void setUtabaquismodia(int utabaquismodia) {
        this.utabaquismodia = utabaquismodia;
    }

    public int getUtabaquismotiempo() {
        return this.utabaquismotiempo;
    }

    public void setUtabaquismotiempo(int utabaquismotiempo) {
        this.utabaquismotiempo = utabaquismotiempo;
    }

    public boolean isBdiabetes() {
        return this.bdiabetes;
    }

    public void setBdiabetes(boolean bdiabetes) {
        this.bdiabetes = bdiabetes;
    }

    public int getUdiabetestiempo() {
        return this.udiabetestiempo;
    }

    public void setUdiabetestiempo(int udiabetestiempo) {
        this.udiabetestiempo = udiabetestiempo;
    }

    public int getUmenarca() {
        return this.umenarca;
    }

    public void setUmenarca(int umenarca) {
        this.umenarca = umenarca;
    }

    public int getUdiasritmo1() {
        return this.udiasritmo1;
    }

    public void setUdiasritmo1(int udiasritmo1) {
        this.udiasritmo1 = udiasritmo1;
    }

    public int getUdiasritmo2() {
        return this.udiasritmo2;
    }

    public void setUdiasritmo2(int udiasritmo2) {
        this.udiasritmo2 = udiasritmo2;
    }

    public java.util.Date getDfechaultimaregla() {
        return this.dfechaultimaregla;
    }

    public void setDfechaultimaregla(java.util.Date dfechaultimaregla) {
        this.dfechaultimaregla = dfechaultimaregla;
    }

    public int getUvidasexualactiva() {
        return this.uvidasexualactiva;
    }

    public void setUvidasexualactiva(int uvidasexualactiva) {
        this.uvidasexualactiva = uvidasexualactiva;
    }

    public int getUnumeroparejassexuales() {
        return this.unumeroparejassexuales;
    }

    public void setUnumeroparejassexuales(int unumeroparejassexuales) {
        this.unumeroparejassexuales = unumeroparejassexuales;
    }

    public int getUgestaciones() {
        return this.ugestaciones;
    }

    public void setUgestaciones(int ugestaciones) {
        this.ugestaciones = ugestaciones;
    }

    public int getUpartosnormales() {
        return this.upartosnormales;
    }

    public void setUpartosnormales(int upartosnormales) {
        this.upartosnormales = upartosnormales;
    }

    public int getUcesarias() {
        return this.ucesarias;
    }

    public void setUcesarias(int ucesarias) {
        this.ucesarias = ucesarias;
    }

    public int getUabortos() {
        return this.uabortos;
    }

    public void setUabortos(int uabortos) {
        this.uabortos = uabortos;
    }

    public int getUprimerembarazo() {
        return this.uprimerembarazo;
    }

    public void setUprimerembarazo(int uprimerembarazo) {
        this.uprimerembarazo = uprimerembarazo;
    }

    public boolean isBlactancia() {
        return this.blactancia;
    }

    public void setBlactancia(boolean blactancia) {
        this.blactancia = blactancia;
    }

    public int getUclimaterio() {
        return this.uclimaterio;
    }

    public void setUclimaterio(int uclimaterio) {
        this.uclimaterio = uclimaterio;
    }

    public boolean isBantiritmo() {
        return this.bantiritmo;
    }

    public void setBantiritmo(boolean bantiritmo) {
        this.bantiritmo = bantiritmo;
    }

    public boolean isBantilocal() {
        return this.bantilocal;
    }

    public void setBantilocal(boolean bantilocal) {
        this.bantilocal = bantilocal;
    }

    public boolean isBantiparental() {
        return this.bantiparental;
    }

    public void setBantiparental(boolean bantiparental) {
        this.bantiparental = bantiparental;
    }

    public boolean isBantioral() {
        return this.bantioral;
    }

    public void setBantioral(boolean bantioral) {
        this.bantioral = bantioral;
    }

    public boolean isBantivasectomia() {
        return this.bantivasectomia;
    }

    public void setBantivasectomia(boolean bantivasectomia) {
        this.bantivasectomia = bantivasectomia;
    }

    public boolean isBantiparche() {
        return this.bantiparche;
    }

    public void setBantiparche(boolean bantiparche) {
        this.bantiparche = bantiparche;
    }

    public boolean isBantidiu() {
        return this.bantidiu;
    }

    public void setBantidiu(boolean bantidiu) {
        this.bantidiu = bantidiu;
    }

    public boolean isBanticoito() {
        return this.banticoito;
    }

    public void setBanticoito(boolean banticoito) {
        this.banticoito = banticoito;
    }

    public boolean isBantisalpingoclasia() {
        return this.bantisalpingoclasia;
    }

    public void setBantisalpingoclasia(boolean bantisalpingoclasia) {
        this.bantisalpingoclasia = bantisalpingoclasia;
    }

    public boolean isBantibarrera() {
        return this.bantibarrera;
    }

    public void setBantibarrera(boolean bantibarrera) {
        this.bantibarrera = bantibarrera;
    }

    public boolean isBantinada() {
        return this.bantinada;
    }

    public void setBantinada(boolean bantinada) {
        this.bantinada = bantinada;
    }

    public boolean isBantiimplante() {
        return this.bantiimplante;
    }

    public void setBantiimplante(boolean bantiimplante) {
        this.bantiimplante = bantiimplante;
    }

    public boolean isBantiotro() {
        return this.bantiotro;
    }

    public void setBantiotro(boolean bantiotro) {
        this.bantiotro = bantiotro;
    }

    public java.lang.String getSotroanticonceptivo() {
        return this.sotroanticonceptivo;
    }

    public void setSotroanticonceptivo(java.lang.String sotroanticonceptivo) {
        this.sotroanticonceptivo = sotroanticonceptivo;
    }

    public java.util.Date getDfechaultimopapanicolau() {
        return this.dfechaultimopapanicolau;
    }

    public void setDfechaultimopapanicolau(java.util.Date dfechaultimopapanicolau) {
        this.dfechaultimopapanicolau = dfechaultimopapanicolau;
    }

    public boolean isBvph() {
        return this.bvph;
    }

    public void setBvph(boolean bvph) {
        this.bvph = bvph;
    }

    public java.util.Date getDfechavph() {
        return this.dfechavph;
    }

    public void setDfechavph(java.util.Date dfechavph) {
        this.dfechavph = dfechavph;
    }

    public boolean isBantececervico() {
        return this.bantececervico;
    }

    public void setBantececervico(boolean bantececervico) {
        this.bantececervico = bantececervico;
    }

    public boolean isBantecemama() {
        return this.bantecemama;
    }

    public void setBantecemama(boolean bantecemama) {
        this.bantecemama = bantecemama;
    }

    public java.lang.String getSanteceherefami() {
        return this.santeceherefami;
    }

    public void setSanteceherefami(java.lang.String santeceherefami) {
        this.santeceherefami = santeceherefami;
    }

    public java.util.Date getDfechahisterectimia() {
        return this.dfechahisterectimia;
    }

    public void setDfechahisterectimia(java.util.Date dfechahisterectimia) {
        this.dfechahisterectimia = dfechahisterectimia;
    }

    public boolean isBoforectomiaderecho() {
        return this.boforectomiaderecho;
    }

    public void setBoforectomiaderecho(boolean boforectomiaderecho) {
        this.boforectomiaderecho = boforectomiaderecho;
    }

    public boolean isBoforectomiaizuierdo() {
        return this.boforectomiaizuierdo;
    }

    public void setBoforectomiaizuierdo(boolean boforectomiaizuierdo) {
        this.boforectomiaizuierdo = boforectomiaizuierdo;
    }

    public boolean isBoforectomiano() {
        return this.boforectomiano;
    }

    public void setBoforectomiano(boolean boforectomiano) {
        this.boforectomiano = boforectomiano;
    }

    public java.util.Date getDfechaoforectomia() {
        return this.dfechaoforectomia;
    }

    public void setDfechaoforectomia(java.util.Date dfechaoforectomia) {
        this.dfechaoforectomia = dfechaoforectomia;
    }

    public java.lang.String getSmotivooforectomia() {
        return this.smotivooforectomia;
    }

    public void setSmotivooforectomia(java.lang.String smotivooforectomia) {
        this.smotivooforectomia = smotivooforectomia;
    }

    public boolean isBeqx() {
        return this.beqx;
    }

    public void setBeqx(boolean beqx) {
        this.beqx = beqx;
    }

    public java.util.Date getDfechaeqx() {
        return this.dfechaeqx;
    }

    public void setDfechaeqx(java.util.Date dfechaeqx) {
        this.dfechaeqx = dfechaeqx;
    }

    public boolean isBelectrocoagulacion() {
        return this.belectrocoagulacion;
    }

    public void setBelectrocoagulacion(boolean belectrocoagulacion) {
        this.belectrocoagulacion = belectrocoagulacion;
    }

    public java.util.Date getDfechaelectrocoagulacion() {
        return this.dfechaelectrocoagulacion;
    }

    public void setDfechaelectrocoagulacion(java.util.Date dfechaelectrocoagulacion) {
        this.dfechaelectrocoagulacion = dfechaelectrocoagulacion;
    }

    public boolean isBcrioterapia() {
        return this.bcrioterapia;
    }

    public void setBcrioterapia(boolean bcrioterapia) {
        this.bcrioterapia = bcrioterapia;
    }

    public java.util.Date getDfechacrioterapia() {
        return this.dfechacrioterapia;
    }

    public void setDfechacrioterapia(java.util.Date dfechacrioterapia) {
        this.dfechacrioterapia = dfechacrioterapia;
    }

    public java.lang.String getSmotivocrioterapia() {
        return this.smotivocrioterapia;
    }

    public void setSmotivocrioterapia(java.lang.String smotivocrioterapia) {
        this.smotivocrioterapia = smotivocrioterapia;
    }

    public java.lang.String getSsintomatologiaactual() {
        return this.ssintomatologiaactual;
    }

    public void setSsintomatologiaactual(java.lang.String ssintomatologiaactual) {
        this.ssintomatologiaactual = ssintomatologiaactual;
    }

    public boolean isBcervixcentral() {
        return this.bcervixcentral;
    }

    public void setBcervixcentral(boolean bcervixcentral) {
        this.bcervixcentral = bcervixcentral;
    }

    public boolean isBcervixderecho() {
        return this.bcervixderecho;
    }

    public void setBcervixderecho(boolean bcervixderecho) {
        this.bcervixderecho = bcervixderecho;
    }

    public boolean isBcervixizquierdo() {
        return this.bcervixizquierdo;
    }

    public void setBcervixizquierdo(boolean bcervixizquierdo) {
        this.bcervixizquierdo = bcervixizquierdo;
    }

    public boolean isBcervixanterior() {
        return this.bcervixanterior;
    }

    public void setBcervixanterior(boolean bcervixanterior) {
        this.bcervixanterior = bcervixanterior;
    }

    public boolean isBcervixposterior() {
        return this.bcervixposterior;
    }

    public void setBcervixposterior(boolean bcervixposterior) {
        this.bcervixposterior = bcervixposterior;
    }

    public boolean isBsecrecionfluida() {
        return this.bsecrecionfluida;
    }

    public void setBsecrecionfluida(boolean bsecrecionfluida) {
        this.bsecrecionfluida = bsecrecionfluida;
    }

    public boolean isBsecrecionespesa() {
        return this.bsecrecionespesa;
    }

    public void setBsecrecionespesa(boolean bsecrecionespesa) {
        this.bsecrecionespesa = bsecrecionespesa;
    }

    public boolean isBsecrecionsemiespesa() {
        return this.bsecrecionsemiespesa;
    }

    public void setBsecrecionsemiespesa(boolean bsecrecionsemiespesa) {
        this.bsecrecionsemiespesa = bsecrecionsemiespesa;
    }

    public boolean isBsecreciongrumosa() {
        return this.bsecreciongrumosa;
    }

    public void setBsecreciongrumosa(boolean bsecreciongrumosa) {
        this.bsecreciongrumosa = bsecreciongrumosa;
    }

    public boolean isBsecrecionespumosa() {
        return this.bsecrecionespumosa;
    }

    public void setBsecrecionespumosa(boolean bsecrecionespumosa) {
        this.bsecrecionespumosa = bsecrecionespumosa;
    }

    public boolean isBsecrecionescasa() {
        return this.bsecrecionescasa;
    }

    public void setBsecrecionescasa(boolean bsecrecionescasa) {
        this.bsecrecionescasa = bsecrecionescasa;
    }

    public boolean isBsecrecionmoderada() {
        return this.bsecrecionmoderada;
    }

    public void setBsecrecionmoderada(boolean bsecrecionmoderada) {
        this.bsecrecionmoderada = bsecrecionmoderada;
    }

    public boolean isBsecrecionabundante() {
        return this.bsecrecionabundante;
    }

    public void setBsecrecionabundante(boolean bsecrecionabundante) {
        this.bsecrecionabundante = bsecrecionabundante;
    }

    public boolean isBsecrecionmixta() {
        return this.bsecrecionmixta;
    }

    public void setBsecrecionmixta(boolean bsecrecionmixta) {
        this.bsecrecionmixta = bsecrecionmixta;
    }

    public java.lang.String getSvulvaotros() {
        return this.svulvaotros;
    }

    public void setSvulvaotros(java.lang.String svulvaotros) {
        this.svulvaotros = svulvaotros;
    }

    public boolean isBunionescamoclumnar() {
        return this.bunionescamoclumnar;
    }

    public void setBunionescamoclumnar(boolean bunionescamoclumnar) {
        this.bunionescamoclumnar = bunionescamoclumnar;
    }

    public java.lang.String getSzonasacetopositivas() {
        return this.szonasacetopositivas;
    }

    public void setSzonasacetopositivas(java.lang.String szonasacetopositivas) {
        this.szonasacetopositivas = szonasacetopositivas;
    }

    public int getUtamanoectropion() {
        return this.utamanoectropion;
    }

    public void setUtamanoectropion(int utamanoectropion) {
        this.utamanoectropion = utamanoectropion;
    }

    public int getUtamanoperiorificiador() {
        return this.utamanoperiorificiador;
    }

    public void setUtamanoperiorificiador(int utamanoperiorificiador) {
        this.utamanoperiorificiador = utamanoperiorificiador;
    }

    public boolean isBprocesoerosivo() {
        return this.bprocesoerosivo;
    }

    public void setBprocesoerosivo(boolean bprocesoerosivo) {
        this.bprocesoerosivo = bprocesoerosivo;
    }

    public boolean isBmei() {
        return this.bmei;
    }

    public void setBmei(boolean bmei) {
        this.bmei = bmei;
    }

    public boolean isBmeipo() {
        return this.bmeipo;
    }

    public void setBmeipo(boolean bmeipo) {
        this.bmeipo = bmeipo;
    }

    public boolean isBquistenaboth() {
        return this.bquistenaboth;
    }

    public void setBquistenaboth(boolean bquistenaboth) {
        this.bquistenaboth = bquistenaboth;
    }

    public java.lang.String getSquistenaboth() {
        return this.squistenaboth;
    }

    public void setSquistenaboth(java.lang.String squistenaboth) {
        this.squistenaboth = squistenaboth;
    }

    public int getCestado() {
        return this.cestado;
    }

    public void setCestado(int cestado) {
        this.cestado = cestado;
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

    public mx.com.web2lab.backend.hbm.om.fundacion.COcupacionPaciente getCocupacionpaciente() {
        return this.cocupacionpaciente;
    }

    public void setCocupacionpaciente(mx.com.web2lab.backend.hbm.om.fundacion.COcupacionPaciente cocupacionpaciente) {
        this.cocupacionpaciente = cocupacionpaciente;
    }

    public mx.com.web2lab.backend.hbm.om.fundacion.CMotivoEQX getCmotivoeqx() {
        return this.cmotivoeqx;
    }

    public void setCmotivoeqx(mx.com.web2lab.backend.hbm.om.fundacion.CMotivoEQX CMotivoEQX) {
        this.cmotivoeqx = CMotivoEQX;
    }

    public mx.com.web2lab.backend.hbm.om.fundacion.CTiposBiopsia getCtiposbiopsia() {
        return this.ctiposbiopsia;
    }

    public void setCtiposbiopsia(mx.com.web2lab.backend.hbm.om.fundacion.CTiposBiopsia CTiposBiopsia) {
        this.ctiposbiopsia = CTiposBiopsia;
    }

    public mx.com.web2lab.backend.hbm.om.fundacion.CMotivoHisterectomia getCmotivohisterectomia() {
        return this.cmotivohisterectomia;
    }

    public void setCmotivohisterectomia(mx.com.web2lab.backend.hbm.om.fundacion.CMotivoHisterectomia CMotivoHisterectomia) {
        this.cmotivohisterectomia = CMotivoHisterectomia;
    }

    public mx.com.web2lab.backend.hbm.om.fundacion.CEctropion getCectropion() {
        return this.cectropion;
    }

    public void setCectropion(mx.com.web2lab.backend.hbm.om.fundacion.CEctropion CEctropion) {
        this.cectropion = CEctropion;
    }

    public mx.com.web2lab.backend.hbm.om.fundacion.CEscolaridad getCescolaridad() {
        return this.cescolaridad;
    }

    public void setCescolaridad(mx.com.web2lab.backend.hbm.om.fundacion.CEscolaridad CEscolaridad) {
        this.cescolaridad = CEscolaridad;
    }

    public mx.com.web2lab.backend.hbm.om.fundacion.CCervix getCcervix() {
        return this.ccervix;
    }

    public void setCcervix(mx.com.web2lab.backend.hbm.om.fundacion.CCervix CCervix) {
        this.ccervix = CCervix;
    }

    public mx.com.web2lab.backend.hbm.om.fundacion.CLugarPapanicolau getClugarpapanicolau() {
        return this.clugarpapanicolau;
    }

    public void setClugarpapanicolau(mx.com.web2lab.backend.hbm.om.fundacion.CLugarPapanicolau CLugarPapanicolau) {
        this.clugarpapanicolau = CLugarPapanicolau;
    }

    public mx.com.web2lab.backend.hbm.om.fundacion.CEstadoCivil getCestadocivil() {
        return this.cestadocivil;
    }

    public void setCestadocivil(mx.com.web2lab.backend.hbm.om.fundacion.CEstadoCivil CEstadoCivil) {
        this.cestadocivil = CEstadoCivil;
    }

    public mx.com.web2lab.backend.hbm.om.fundacion.CMotivoElectroCoagulacion getCmotivoelectrocoagulacion() {
        return this.cmotivoelectrocoagulacion;
    }

    public void setCmotivoelectrocoagulacion(mx.com.web2lab.backend.hbm.om.fundacion.CMotivoElectroCoagulacion CMotivoElectroCoagulacion) {
        this.cmotivoelectrocoagulacion = CMotivoElectroCoagulacion;
    }

    public mx.com.web2lab.backend.hbm.om.fundacion.CDiu getCdiu() {
        return this.cdiu;
    }

    public void setCdiu(mx.com.web2lab.backend.hbm.om.fundacion.CDiu CDiu) {
        this.cdiu = CDiu;
    }

    public mx.com.web2lab.backend.hbm.om.fundacion.CSecrecion getCsecrecion() {
        return this.csecrecion;
    }

    public void setCsecrecion(mx.com.web2lab.backend.hbm.om.fundacion.CSecrecion CSecrecion) {
        this.csecrecion = CSecrecion;
    }

    public mx.com.web2lab.backend.hbm.om.fundacion.CPolipo getCpolipo() {
        return this.cpolipo;
    }

    public void setCpolipo(mx.com.web2lab.backend.hbm.om.fundacion.CPolipo CPolipo) {
        this.cpolipo = CPolipo;
    }

    public mx.com.web2lab.backend.hbm.om.fundacion.BPacienteFundacion getBpacientefundacion() {
        return this.bpacientefundacion;
    }

    public void setBpacientefundacion(mx.com.web2lab.backend.hbm.om.fundacion.BPacienteFundacion BPacienteFundacion) {
        this.bpacientefundacion = BPacienteFundacion;
    }

    public mx.com.web2lab.backend.hbm.om.fundacion.COcupacionFamiliar getCocupacionfamiliar() {
        return this.cocupacionfamiliar;
    }

    public void setCocupacionfamiliar(mx.com.web2lab.backend.hbm.om.fundacion.COcupacionFamiliar COcupacionFamiliar) {
        this.cocupacionfamiliar = COcupacionFamiliar;
    }

    public mx.com.web2lab.backend.hbm.om.fundacion.CHTA getChta() {
        return this.chta;
    }

    public void setChta(mx.com.web2lab.backend.hbm.om.fundacion.CHTA CHTA) {
        this.chta = CHTA;
    }

    public mx.com.web2lab.backend.hbm.om.fundacion.CMotivoEstudio getCmotivoestudio() {
        return this.cmotivoestudio;
    }

    public void setCmotivoestudio(mx.com.web2lab.backend.hbm.om.fundacion.CMotivoEstudio CMotivoEstudio) {
        this.cmotivoestudio = CMotivoEstudio;
    }

    public mx.com.web2lab.backend.hbm.om.fundacion.CTratamientoDiabet getCtratamientodiabet() {
        return this.ctratamientodiabet;
    }

    public void setCtratamientodiabet(mx.com.web2lab.backend.hbm.om.fundacion.CTratamientoDiabet CTratamientoDiabet) {
        this.ctratamientodiabet = CTratamientoDiabet;
    }

    public mx.com.web2lab.backend.hbm.om.fundacion.CResultadoPapanicolau getCresultadopapanicolau() {
        return this.cresultadopapanicolau;
    }

    public void setCresultadopapanicolau(mx.com.web2lab.backend.hbm.om.fundacion.CResultadoPapanicolau CResultadoPapanicolau) {
        this.cresultadopapanicolau = CResultadoPapanicolau;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("kpacientecuestionario", getKpacientecuestionario())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BPacienteCuestionario) ) return false;
        BPacienteCuestionario castOther = (BPacienteCuestionario) other;
        return new EqualsBuilder()
            .append(this.getKpacientecuestionario(), castOther.getKpacientecuestionario())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKpacientecuestionario())
            .toHashCode();
    }

}
