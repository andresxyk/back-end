package mx.com.web2lab.backend.util.beans.fundacion;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

public class BPacienteCuestionarioBean implements Serializable {

    /** identifier field */
    private int kpacientecuestionario;    
    private boolean balergias;
    private java.lang.String smedicamento;
    private int cocupacionpaciente;
    private int cocupacionfamiliar;
    private int cestadocivil;
    private int cescolaridad;
    private boolean btabaquismo;    
    private int utabaquismodia;    
    private int utabaquismotiempo;    
    private boolean bdiabetes;    
    private int udiabetestiempo;    
    private int umenarca;    
    private int udiasritmo1;    
    private int udiasritmo2;    
    private String dfechaUltimaRegla;    
    private int uvidaSexualActiva;    
    private int unumeroParejasSexuales;    
    private int ugestaciones;    
    private int upartosNormales;    
    private int ucesareas;    
    private int uabortos;    
    private int uprimerEmbarazo;    
    private boolean blactancia;    
    private int uclimaterio;    
    private boolean bantiRitmo;    
    private boolean bantiLocal;    
    private boolean bantiParenteral;    
    private boolean bantiOral;    
    private boolean bantiVasectomia;    
    private boolean bantiParche;    
    private boolean bantiDiu;    
    private boolean bantiCoito;    
    private boolean bantiSalpingoclasia;    
    private boolean bantiBarrera;    
    private boolean bantiNada;    
    private boolean bantiImplante;    
    private boolean bantiOtro;
    private String sotroAnticonceptivo;    
    private String dfechaUltimoPapanicolau;    
    private boolean bvph;    
    private String dfechaVph;    
    private boolean banteceCervico;    
    private boolean banteceMama;
    private String santeceHereFami;    
    private String dfechaHisterectomia;
    private int cmotivoHisterectomia;    
    private boolean boforectomiaDerecho;    
    private boolean boforectomiaIzuierdo;    
    private boolean boforectomiaNo;    
    private String dfechaOforectomia;
    private String smotivoOforectomia;    
    private boolean beqx;    
    private String dfechaEqx;
    private int cmotivoEqx;    
    private boolean belectroCoagulacion;    
    private String dfechaElectroCoagulacion;
    private int cmotivoElectroCoagulacion;    
    private boolean bcrioterapia;    
    private String dfechaCrioterapia;
    private String smotivoCrioterapia;
    private int cmotivoEstudio;
    private String ssintomatologiaActual;    
    private boolean bcervixCentral;    
    private boolean bcervixDerecho;    
    private boolean bcervixIzquierdo;    
    private boolean bcervixAnterior;    
    private boolean bcervixPosterior;    
    private boolean bsecresionFluida;    
    private boolean bsecresionEspesa;    
    private boolean bsecresionSemiespesa;    
    private boolean bsecresionGrumosa;    
    private boolean bsecresionEspumosa;    
    private boolean bsecresionEscasa;    
    private boolean bsecresionModerada;    
    private boolean bsecresionAbundante;    
    private boolean bsecresionMixta;
    private String svulvaOtros;    
    private boolean bunionEscamoclumnar;
    private String szonasAcetopositivas;    
    private int utamanoPeriorificiador;    
    private boolean bprocesoErosivo;    
    private boolean bmei;    
    private boolean bmeipo;    
    private boolean bquisteNaboth;    
    private String squisteNaboth;    
    private int cectropion;    
    private int csecrecion;    
    private int cdiu;    
    private int ccervix;    
    private int clugarPapanicolau;    
    private int bpacientefundacion;    
    private int cresultadoPapanicolau;    
    private int chta;    
    private int ctratamientodiabet;    
    private int ctiposBiopsia;    
    private int cpolipo;
    private int utamanoEctropion;
    private int idUsuario;
    
    
    /** default constructor */
    public BPacienteCuestionarioBean() {
    }

    public int getKpacientecuestionario() {
        return this.kpacientecuestionario;
    }

    public void setKpacientecuestionario(int kpacientecuestionario) {
        this.kpacientecuestionario = kpacientecuestionario;
    }

    public boolean isBalergias() {
        return this.balergias;
    }

    public void setBalergias(boolean balergias) {
        this.balergias = balergias;
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

    public String getDfechaUltimaRegla() {
        return this.dfechaUltimaRegla;
    }

    public void setDfechaUltimaRegla(String dfechaUltimaRegla) {
    	if (dfechaUltimaRegla == "null" || dfechaUltimaRegla == null) {
            this.dfechaUltimaRegla = "";    		    		
    	} else {
            this.dfechaUltimaRegla = dfechaUltimaRegla;    		
    	}
    }

    public int getUvidaSexualActiva() {
        return this.uvidaSexualActiva;
    }

    public void setUvidaSexualActiva(int uvidaSexualActiva) {
        this.uvidaSexualActiva = uvidaSexualActiva;
    }

    public int getUnumeroParejasSexuales() {
        return this.unumeroParejasSexuales;
    }

    public void setUnumeroParejasSexuales(int unumeroParejasSexuales) {
        this.unumeroParejasSexuales = unumeroParejasSexuales;
    }

    public int getUgestaciones() {
        return this.ugestaciones;
    }

    public void setUgestaciones(int ugestaciones) {
        this.ugestaciones = ugestaciones;
    }

    public int getUpartosNormales() {
        return this.upartosNormales;
    }

    public void setUpartosNormales(int upartosNormales) {
        this.upartosNormales = upartosNormales;
    }

    public int getUcesareas() {
        return this.ucesareas;
    }

    public void setUcesareas(int ucesareas) {
        this.ucesareas = ucesareas;
    }

    public int getUabortos() {
        return this.uabortos;
    }

    public void setUabortos(int uabortos) {
        this.uabortos = uabortos;
    }

    public int getUprimerEmbarazo() {
        return this.uprimerEmbarazo;
    }

    public void setUprimerEmbarazo(int uprimerEmbarazo) {
        this.uprimerEmbarazo = uprimerEmbarazo;
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

    public boolean isBantiRitmo() {
        return this.bantiRitmo;
    }

    public void setBantiRitmo(boolean bantiRitmo) {
        this.bantiRitmo = bantiRitmo;
    }

    public boolean isBantiLocal() {
        return this.bantiLocal;
    }

    public void setBantiLocal(boolean bantiLocal) {
        this.bantiLocal = bantiLocal;
    }

    public boolean isBantiParenteral() {
        return this.bantiParenteral;
    }

    public void setBantiParenteral(boolean bantiParenteral) {
        this.bantiParenteral = bantiParenteral;
    }

    public boolean isBantiOral() {
        return this.bantiOral;
    }

    public void setBantiOral(boolean bantiOral) {
        this.bantiOral = bantiOral;
    }

    public boolean isBantiVasectomia() {
        return this.bantiVasectomia;
    }

    public void setBantiVasectomia(boolean bantiVasectomia) {
        this.bantiVasectomia = bantiVasectomia;
    }

    public boolean isBantiParche() {
        return this.bantiParche;
    }

    public void setBantiParche(boolean bantiParche) {
        this.bantiParche = bantiParche;
    }

    public boolean isBantiDiu() {
        return this.bantiDiu;
    }

    public void setBantiDiu(boolean bantiDiu) {
        this.bantiDiu = bantiDiu;
    }

    public boolean isBantiCoito() {
        return this.bantiCoito;
    }

    public void setBantiCoito(boolean bantiCoito) {
        this.bantiCoito = bantiCoito;
    }

    public boolean isBantiSalpingoclasia() {
        return this.bantiSalpingoclasia;
    }

    public void setBantiSalpingoclasia(boolean bantiSalpingoclasia) {
        this.bantiSalpingoclasia = bantiSalpingoclasia;
    }

    public boolean isBantiBarrera() {
        return this.bantiBarrera;
    }

    public void setBantiBarrera(boolean bantiBarrera) {
        this.bantiBarrera = bantiBarrera;
    }

    public boolean isBantiNada() {
        return this.bantiNada;
    }

    public void setBantiNada(boolean bantiNada) {
        this.bantiNada = bantiNada;
    }

    public boolean isBantiImplante() {
        return this.bantiImplante;
    }

    public void setBantiImplante(boolean bantiImplante) {
        this.bantiImplante = bantiImplante;
    }

    public boolean isBantiOtro() {
        return this.bantiOtro;
    }

    public void setBantiOtro(boolean bantiOtro) {
        this.bantiOtro = bantiOtro;
    }

    public java.lang.String getSmedicamento() {
        return this.smedicamento;
    }

    public void setSmedicamento(java.lang.String smedicamento) {
    	if (smedicamento == "null" || smedicamento == null) {
            this.smedicamento = "";    		    		
    	} else {
            this.smedicamento = smedicamento;    		
    	}
    }
    
    
    public java.lang.String getSotroAnticonceptivo() {
        return this.sotroAnticonceptivo;
    }

    public void setSotroAnticonceptivo(java.lang.String sotroAnticonceptivo) {
    	if (sotroAnticonceptivo == "null" || sotroAnticonceptivo == null) {
            this.sotroAnticonceptivo = "";    		    		
    	} else {
            this.sotroAnticonceptivo = sotroAnticonceptivo;    		
    	}
    }

    public String getDfechaUltimoPapanicolau() {
        return this.dfechaUltimoPapanicolau;
    }

    public void setDfechaUltimoPapanicolau(String dfechaUltimoPapanicolau) {
    	if (dfechaUltimoPapanicolau == "null" || dfechaUltimoPapanicolau == null) {
            this.dfechaUltimoPapanicolau = "";    		    		
    	} else {
            this.dfechaUltimoPapanicolau = dfechaUltimoPapanicolau;    		
    	}
    }

    public boolean isBvph() {
        return this.bvph;
    }

    public void setBvph(boolean bvph) {
        this.bvph = bvph;
    }

    public String getDfechaVph() {
        return this.dfechaVph;
    }

    public void setDfechaVph(String dfechaVph) {
    	if (dfechaVph == "null" || dfechaVph == null) {
            this.dfechaVph = "";    		    		
    	} else {
            this.dfechaVph = dfechaVph;    		
    	}
    }

    public boolean isBanteceCervico() {
        return this.banteceCervico;
    }

    public void setBanteceCervico(boolean banteceCervico) {
        this.banteceCervico = banteceCervico;
    }

    public boolean isBanteceMama() {
        return this.banteceMama;
    }

    public void setBanteceMama(boolean banteceMama) {
        this.banteceMama = banteceMama;
    }

    public java.lang.String getSanteceHereFami() {
        return this.santeceHereFami;
    }

    public void setSanteceHereFami(java.lang.String santeceHereFami) {
    	if (santeceHereFami == "null" || santeceHereFami == null) {
            this.santeceHereFami = "";    		    		
    	} else {
            this.santeceHereFami = santeceHereFami;    		
    	}
    }

    public String getDfechaHisterectomia() {
        return this.dfechaHisterectomia;
    }

    public void setDfechaHisterectomia(String dfechaHisterectomia) {
    	if (dfechaHisterectomia == "null" || dfechaHisterectomia == null) {
            this.dfechaHisterectomia = "";    		    		
    	} else {
            this.dfechaHisterectomia = dfechaHisterectomia;    		
    	}
    }

    public int getCescolaridad() {
        return this.cescolaridad;
    }

    public void setCescolaridad(int cescolaridad) {
        this.cescolaridad = cescolaridad;
    }    
    
    public int getCestadocivil() {
        return this.cestadocivil;
    }

    public void setCestadocivil(int cestadocivil) {
        this.cestadocivil = cestadocivil;
    }    
    
    public int getCocupacionfamiliar() {
        return this.cocupacionfamiliar;
    }

    public void setCocupacionfamiliar(int cocupacionfamiliar) {
        this.cocupacionfamiliar = cocupacionfamiliar;
    }    
    
    public int getCocupacionpaciente() {
        return this.cocupacionpaciente;
    }

    public void setCocupacionpaciente(int cocupacionpaciente) {
        this.cocupacionpaciente = cocupacionpaciente;
    }    
    
    public int getCmotivoHisterectomia() {
        return this.cmotivoHisterectomia;
    }

    public void setCmotivoHisterectomia(int cmotivoHisterectomia) {
        this.cmotivoHisterectomia = cmotivoHisterectomia;
    }

    public boolean isBoforectomiaDerecho() {
        return this.boforectomiaDerecho;
    }

    public void setBoforectomiaDerecho(boolean boforectomiaDerecho) {
        this.boforectomiaDerecho = boforectomiaDerecho;
    }

    public boolean isBoforectomiaIzuierdo() {
        return this.boforectomiaIzuierdo;
    }

    public void setBoforectomiaIzuierdo(boolean boforectomiaIzuierdo) {
        this.boforectomiaIzuierdo = boforectomiaIzuierdo;
    }

    public boolean isBoforectomiaNo() {
        return this.boforectomiaNo;
    }

    public void setBoforectomiaNo(boolean boforectomiaNo) {
        this.boforectomiaNo = boforectomiaNo;
    }

    public String getDfechaOforectomia() {
        return this.dfechaOforectomia;
    }

    public void setDfechaOforectomia(String dfechaOforectomia) {
    	if (dfechaOforectomia == "null" || dfechaOforectomia == null) {
            this.dfechaOforectomia = "";    		    		
    	} else {
            this.dfechaOforectomia = dfechaOforectomia;    		
    	}
    }

    public java.lang.String getSmotivoOforectomia() {
        return this.smotivoOforectomia;
    }

    public void setSmotivoOforectomia(java.lang.String smotivoOforectomia) {
    	if (smotivoOforectomia == "null" || smotivoOforectomia == null) {
            this.smotivoOforectomia = "";    		    		
    	} else {
            this.smotivoOforectomia = smotivoOforectomia;    		
    	}
    }

    public boolean isBeqx() {
        return this.beqx;
    }

    public void setBeqx(boolean beqx) {
        this.beqx = beqx;
    }

    public String getDfechaEqx() {
        return this.dfechaEqx;
    }

    public void setDfechaEqx(String dfechaEqx) {
    	if (dfechaEqx == "null" || dfechaEqx == null) {
            this.dfechaEqx = "";    		    		
    	} else {
            this.dfechaEqx = dfechaEqx;    		
    	}
    }

    public int getCmotivoEqx() {
        return this.cmotivoEqx;
    }

    public void setCmotivoEqx(int cmotivoEqx) {
        this.cmotivoEqx = cmotivoEqx;
    }

    public boolean isBelectroCoagulacion() {
        return this.belectroCoagulacion;
    }

    public void setBelectroCoagulacion(boolean belectroCoagulacion) {
        this.belectroCoagulacion = belectroCoagulacion;
    }

    public String getDfechaElectroCoagulacion() {
        return this.dfechaElectroCoagulacion;
    }

    public void setDfechaElectroCoagulacion(String dfechaElectroCoagulacion) {
    	if (dfechaElectroCoagulacion == "null" || dfechaElectroCoagulacion == null) {
            this.dfechaElectroCoagulacion = "";    		    		
    	} else {
            this.dfechaElectroCoagulacion = dfechaElectroCoagulacion;    		
    	}
    }

    public int getCmotivoElectroCoagulacion() {
        return this.cmotivoElectroCoagulacion;
    }

    public void setCmotivoElectroCoagulacion(int cmotivoElectroCoagulacion) {
        this.cmotivoElectroCoagulacion = cmotivoElectroCoagulacion;
    }

    public boolean isBcrioterapia() {
        return this.bcrioterapia;
    }

    public void setBcrioterapia(boolean bcrioterapia) {
        this.bcrioterapia = bcrioterapia;
    }

    public String getDfechaCrioterapia() {
        return this.dfechaCrioterapia;
    }

    public void setDfechaCrioterapia(String dfechaCrioterapia) {
    	if (dfechaCrioterapia == "null" || dfechaCrioterapia == null) {
            this.dfechaCrioterapia = "";    		    		
    	} else {
            this.dfechaCrioterapia = dfechaCrioterapia;    		
    	}
    }

    public java.lang.String getSmotivoCrioterapia() {
        return this.smotivoCrioterapia;
    }

    public void setSmotivoCrioterapia(java.lang.String smotivoCrioterapia) {
    	if (smotivoCrioterapia == "null" || smotivoCrioterapia == null) {
            this.smotivoCrioterapia = "";    		    		
    	} else {
            this.smotivoCrioterapia = smotivoCrioterapia;    		
    	}
    }

    public int getCmotivoEstudio() {
        return this.cmotivoEstudio;
    }

    public void setCmotivoEstudio(int cmotivoEstudio) {
        this.cmotivoEstudio = cmotivoEstudio;
    }

    public java.lang.String getSsintomatologiaActual() {
        return this.ssintomatologiaActual;
    }

    public void setSsintomatologiaActual(java.lang.String ssintomatologiaActual) {
    	if (ssintomatologiaActual == "null" || ssintomatologiaActual == null) {
            this.ssintomatologiaActual = "";    		    		
    	} else {
            this.ssintomatologiaActual = ssintomatologiaActual;    		
    	}
    }

    public boolean isBcervixCentral() {
        return this.bcervixCentral;
    }

    public void setBcervixCentral(boolean bcervixCentral) {
        this.bcervixCentral = bcervixCentral;
    }

    public boolean isBcervixDerecho() {
        return this.bcervixDerecho;
    }

    public void setBcervixDerecho(boolean bcervixDerecho) {
        this.bcervixDerecho = bcervixDerecho;
    }

    public boolean isBcervixIzquierdo() {
        return this.bcervixIzquierdo;
    }

    public void setBcervixIzquierdo(boolean bcervixIzquierdo) {
        this.bcervixIzquierdo = bcervixIzquierdo;
    }

    public boolean isBcervixAnterior() {
        return this.bcervixAnterior;
    }

    public void setBcervixAnterior(boolean bcervixAnterior) {
        this.bcervixAnterior = bcervixAnterior;
    }

    public boolean isBcervixPosterior() {
        return this.bcervixPosterior;
    }

    public void setBcervixPosterior(boolean bcervixPosterior) {
        this.bcervixPosterior = bcervixPosterior;
    }

    public boolean isBsecresionFluida() {
        return this.bsecresionFluida;
    }

    public void setBsecresionFluida(boolean bsecresionFluida) {
        this.bsecresionFluida = bsecresionFluida;
    }

    public boolean isBsecresionEspesa() {
        return this.bsecresionEspesa;
    }

    public void setBsecresionEspesa(boolean bsecresionEspesa) {
        this.bsecresionEspesa = bsecresionEspesa;
    }

    public boolean isBsecresionSemiespesa() {
        return this.bsecresionSemiespesa;
    }

    public void setBsecresionSemiespesa(boolean bsecresionSemiespesa) {
        this.bsecresionSemiespesa = bsecresionSemiespesa;
    }

    public boolean isBsecresionGrumosa() {
        return this.bsecresionGrumosa;
    }

    public void setBsecresionGrumosa(boolean bsecresionGrumosa) {
        this.bsecresionGrumosa = bsecresionGrumosa;
    }

    public boolean isBsecresionEspumosa() {
        return this.bsecresionEspumosa;
    }

    public void setBsecresionEspumosa(boolean bsecresionEspumosa) {
        this.bsecresionEspumosa = bsecresionEspumosa;
    }

    public boolean isBsecresionEscasa() {
        return this.bsecresionEscasa;
    }

    public void setBsecresionEscasa(boolean bsecresionEscasa) {
        this.bsecresionEscasa = bsecresionEscasa;
    }

    public boolean isBsecresionModerada() {
        return this.bsecresionModerada;
    }

    public void setBsecresionModerada(boolean bsecresionModerada) {
        this.bsecresionModerada = bsecresionModerada;
    }

    public boolean isBsecresionAbundante() {
        return this.bsecresionAbundante;
    }

    public void setBsecresionAbundante(boolean bsecresionAbundante) {
        this.bsecresionAbundante = bsecresionAbundante;
    }

    public boolean isBsecresionMixta() {
        return this.bsecresionMixta;
    }

    public void setBsecresionMixta(boolean bsecresionMixta) {
        this.bsecresionMixta = bsecresionMixta;
    }

    public java.lang.String getSvulvaOtros() {
        return this.svulvaOtros;
    }

    public void setSvulvaOtros(java.lang.String svulvaOtros) {
    	if (svulvaOtros == "null" || svulvaOtros == null) {
            this.svulvaOtros = "";    		    		
    	} else {
            this.svulvaOtros = svulvaOtros;    		
    	}
    }

    public boolean isBunionEscamoclumnar() {
        return this.bunionEscamoclumnar;
    }

    public void setBunionEscamoclumnar(boolean bunionEscamoclumnar) {
        this.bunionEscamoclumnar = bunionEscamoclumnar;
    }

    public java.lang.String getSzonasAcetopositivas() {
        return this.szonasAcetopositivas;
    }

    public void setSzonasAcetopositivas(java.lang.String szonasAcetopositivas) {
    	if (szonasAcetopositivas == "null" || szonasAcetopositivas == null) {
            this.szonasAcetopositivas = "";    		    		
    	} else {
            this.szonasAcetopositivas = szonasAcetopositivas;    		
    	}
    }

    public int getUtamanoPeriorificiador() {
        return this.utamanoPeriorificiador;
    }

    public void setUtamanoPeriorificiador(int utamanoPeriorificiador) {
        this.utamanoPeriorificiador = utamanoPeriorificiador;
    }

    public boolean isBprocesoErosivo() {
        return this.bprocesoErosivo;
    }

    public void setBprocesoErosivo(boolean bprocesoErosivo) {
        this.bprocesoErosivo = bprocesoErosivo;
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

    public boolean isBquisteNaboth() {
        return this.bquisteNaboth;
    }

    public void setBquisteNaboth(boolean bquisteNaboth) {
        this.bquisteNaboth = bquisteNaboth;
    }

    public java.lang.String getSquisteNaboth() {
        return this.squisteNaboth;
    }

    public void setSquisteNaboth(java.lang.String squisteNaboth) {
    	if (squisteNaboth == "null" || squisteNaboth == null) {
            this.squisteNaboth = "";    		    		
    	} else {
            this.squisteNaboth = squisteNaboth;    		
    	}
    }

    public int getCectropion() {
        return this.cectropion;
    }

    public void setCectropion(int cectropion) {
        this.cectropion = cectropion;
    }

    public int getCsecrecion() {
        return this.csecrecion;
    }

    public void setCsecrecion(int csecrecion) {
        this.csecrecion = csecrecion;
    }

    public int getCdiu() {
        return this.cdiu;
    }

    public void setCdiu(int cdiu) {
        this.cdiu = cdiu;
    }

    public int getCcervix() {
        return this.ccervix;
    }

    public void setCcervix(int ccervix) {
        this.ccervix = ccervix;
    }

    public int getClugarPapanicolau() {
        return this.clugarPapanicolau;
    }

    public void setClugarPapanicolau(int clugarPapanicolau) {
        this.clugarPapanicolau = clugarPapanicolau;
    }

    public int getBpacientefundacion() {
        return this.bpacientefundacion;
    }

    public void setBpacientefundacion(int bpacientefundacion) {
        this.bpacientefundacion = bpacientefundacion;
    }

    public int getCresultadoPapanicolau() {
        return this.cresultadoPapanicolau;
    }

    public void setCresultadoPapanicolau(int cresultadoPapanicolau) {
        this.cresultadoPapanicolau = cresultadoPapanicolau;
    }

    public int getChta() {
        return this.chta;
    }

    public void setChta(int chta) {
        this.chta = chta;
    }

    public int getCtratamientodiabet() {
        return this.ctratamientodiabet;
    }

    public void setCtratamientodiabet(int ctratamientodiabet) {
        this.ctratamientodiabet = ctratamientodiabet;
    }

    public int getCtiposBiopsia() {
        return this.ctiposBiopsia;
    }

    public void setCtiposBiopsia(int ctiposBiopsia) {
        this.ctiposBiopsia = ctiposBiopsia;
    }

    public int getCpolipo() {
        return this.cpolipo;
    }

    public void setCpolipo(int cpolipo) {
        this.cpolipo = cpolipo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("kpacientecuestionario", getKpacientecuestionario())
            .toString();
    }

	public int getUTamanoEctropion() {
		return utamanoEctropion;
	}

	public void setUTamanoEctropion(int utamanoEctropion) {
		utamanoEctropion = utamanoEctropion;
	}
	
	public String getObject() {
		return ("kpacientecuestionario = " + kpacientecuestionario     + "\n" +
				"	balergias = " + balergias     + "\n" +
				"	smedicamento = " + smedicamento     + "\n" +
				"	cocupacionpaciente = " + cocupacionpaciente     + "\n" +
				"	cocupacionfamiliar = " + cocupacionfamiliar     + "\n" +
				"	cestadocivil = " + cestadocivil     + "\n" +
				"	cescolaridad = " + cescolaridad     + "\n" +				
				" btabaquismo     = " + btabaquismo     + "\n" +
				" utabaquismodia     = " + utabaquismodia     + "\n" +
				" utabaquismotiempo     = " + utabaquismotiempo     + "\n" +
				" bdiabetes     = " + bdiabetes     + "\n" +
				" udiabetestiempo     = " + udiabetestiempo     + "\n" +
				" umenarca     = " + umenarca     + "\n" +
				" udiasritmo1     = " + udiasritmo1     + "\n" +
				" udiasritmo2     = " + udiasritmo2     + "\n" +
				" dfechaUltimaRegla     = " + dfechaUltimaRegla     + "\n" +
				" uvidaSexualActiva     = " + uvidaSexualActiva     + "\n" +
				" unumeroParejasSexuales     = " + unumeroParejasSexuales     + "\n" +
				" ugestaciones     = " + ugestaciones     + "\n" +
				" upartosNormales     = " + upartosNormales     + "\n" +
				" ucesareas     = " + ucesareas     + "\n" +
				" uabortos     = " + uabortos     + "\n" +
				" uprimerEmbarazo     = " + uprimerEmbarazo     + "\n" +
				" blactancia     = " + blactancia     + "\n" +
				" uclimaterio     = " + uclimaterio     + "\n" +
/*
				" bantiRitmo     = " + bantiRitmo     + "\n" +
				" bantiLocal     = " + bantiLocal     + "\n" +
				" bantiParenteral     = " + bantiParenteral     + "\n" +
				" bantiOral     = " + bantiOral     + "\n" +
				" bantiVasectomia     = " + bantiVasectomia     + "\n" +
				" bantiParche     = " + bantiParche     + "\n" +
				" bantiDiu     = " + bantiDiu     + "\n" +
				" bantiCoito     = " + bantiCoito     + "\n" +
				" bantiSalpingoclasia     = " + bantiSalpingoclasia     + "\n" +
				" bantiBarrera     = " + bantiBarrera     + "\n" +
				" bantiNada     = " + bantiNada     + "\n" +
				" bantiImplante     = " + bantiImplante     + "\n" +
				" bantiOtro = " + bantiOtro +
				" sotroAnticonceptivo     = " + sotroAnticonceptivo     + "\n" +
*/				
				" dfechaUltimoPapanicolau     = " + dfechaUltimoPapanicolau     + "\n" +
				" bvph     = " + bvph     + "\n" +
				" dfechaVph     = " + dfechaVph     + "\n" +
				" banteceCervico     = " + banteceCervico     + "\n" +
				" banteceMama = " + banteceMama +
				" santeceHereFami     = " + santeceHereFami     + "\n" +
				" cHTA = " + chta + 							"\n" +				
				" dfechaHisterectomia = " + dfechaHisterectomia +
				" cmotivoHisterectomia     = " + cmotivoHisterectomia     + "\n" + 
				" boforectomiaDerecho     = " + boforectomiaDerecho   +  "\n" + 
				" boforectomiaIzuierdo     = " + boforectomiaIzuierdo     + 
				" boforectomiaNo     = " + boforectomiaNo     + 
				" dfechaOforectomia = " + dfechaOforectomia +
				" smotivoOforectomia     = " + smotivoOforectomia     + "\n" + 
				" beqx     = " + beqx     + "\n" +
				" dfechaEqx = " + dfechaEqx +
				" cmotivoEqx     = " + cmotivoEqx     + "\n" + 
				" belectroCoagulacion     = " + belectroCoagulacion     + "\n" +
				" dfechaElectroCoagulacion = " + dfechaElectroCoagulacion +
				" cmotivoElectroCoagulacion     = " + cmotivoElectroCoagulacion     + "\n" +
				" bcrioterapia     = " + bcrioterapia     + "\n" +
				" dfechaCrioterapia = " + dfechaCrioterapia +
				" smotivoCrioterapia = " + smotivoCrioterapia + "\n" +
				" cmotivoEstudio = " + cmotivoEstudio +
				" ssintomatologiaActual     = " + ssintomatologiaActual     + "\n" +
				" bcervixCentral     = " + bcervixCentral     + "\n" +
				" bcervixDerecho     = " + bcervixDerecho     + 
				" bcervixIzquierdo     = " + bcervixIzquierdo     + 
				" bcervixAnterior     = " + bcervixAnterior     + 
				" bcervixPosterior     = " + bcervixPosterior     + "\n" +
				" bsecresionFluida     = " + bsecresionFluida     + "\n" +
				" bsecresionEspesa     = " + bsecresionEspesa     + 
				" bsecresionSemiespesa     = " + bsecresionSemiespesa     + 
				" bsecresionGrumosa     = " + bsecresionGrumosa     + 
				" bsecresionEspumosa     = " + bsecresionEspumosa     + 
				" bsecresionEscasa     = " + bsecresionEscasa     + 
				" bsecresionModerada     = " + bsecresionModerada     + 
				" bsecresionAbundante     = " + bsecresionAbundante     + 
				" bsecresionMixta = " + bsecresionMixta + "\n" +
				" svulvaOtros     = " + svulvaOtros     + "\n" +
				" bunionEscamoclumnar = " + bunionEscamoclumnar +
				" szonasAcetopositivas     = " + szonasAcetopositivas     + "\n" +
				" utamanoPeriorificiador     = " + utamanoPeriorificiador     + "\n" +
				" bprocesoErosivo     = " + bprocesoErosivo     + "\n" +
				" bmei     = " + bmei     + "\n" +
				" bmeipo     = " + bmeipo     + "\n" +
				" bquisteNaboth     = " + bquisteNaboth     + "\n" +
				" squisteNaboth     = " + squisteNaboth     + "\n" +
				" cectropion     = " + cectropion     + "\n" +
				" csecrecion     = " + csecrecion     + "\n" +
				" cdiu     = " + cdiu     + "\n" +
				" ccervix     = " + ccervix     + "\n" +
				" clugarPapanicolau     = " + clugarPapanicolau     + "\n" +
				" bpacientefundacion     = " + bpacientefundacion     + "\n" +
				" cresultadoPapanicolau     = " + cresultadoPapanicolau     + "\n" +
				" chta     = " + chta     + "\n" +
				" ctratamientodiabet     = " + ctratamientodiabet     + "\n" +
				" ctiposBiopsia     = " + ctiposBiopsia     + "\n" +
				" cpolipo = " + cpolipo +
				" utamanoEctropion = " + utamanoEctropion);
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
}
