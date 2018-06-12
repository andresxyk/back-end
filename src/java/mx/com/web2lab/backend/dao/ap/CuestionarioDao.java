package mx.com.web2lab.backend.dao.ap;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mx.com.web2lab.backend.beans.ap.PacienteBean;
import mx.com.web2lab.backend.hbm.HibernateUtil;

import mx.com.web2lab.backend.hbm.om.fundacion.BPacienteCuestionario;
import mx.com.web2lab.backend.hbm.om.fundacion.BPacienteFundacion;
import mx.com.web2lab.backend.hbm.om.fundacion.CCervix;
import mx.com.web2lab.backend.hbm.om.fundacion.CClaveEnvio;
import mx.com.web2lab.backend.hbm.om.fundacion.CComunidad;
import mx.com.web2lab.backend.hbm.om.fundacion.CDiu;
import mx.com.web2lab.backend.hbm.om.fundacion.CEctropion;
import mx.com.web2lab.backend.hbm.om.fundacion.CEscolaridad;
import mx.com.web2lab.backend.hbm.om.fundacion.CEstadoCivil;
import mx.com.web2lab.backend.hbm.om.fundacion.CFuenteEnvio;
import mx.com.web2lab.backend.hbm.om.fundacion.CHTA;
import mx.com.web2lab.backend.hbm.om.fundacion.CLugarPapanicolau;
import mx.com.web2lab.backend.hbm.om.fundacion.CMotivoEQX;
import mx.com.web2lab.backend.hbm.om.fundacion.CMotivoElectroCoagulacion;
import mx.com.web2lab.backend.hbm.om.fundacion.CMotivoEstudio;
import mx.com.web2lab.backend.hbm.om.fundacion.CMotivoHisterectomia;
import mx.com.web2lab.backend.hbm.om.fundacion.CNivelSocieconomico;
import mx.com.web2lab.backend.hbm.om.fundacion.COcupacionFamiliar;
import mx.com.web2lab.backend.hbm.om.fundacion.COcupacionPaciente;
import mx.com.web2lab.backend.hbm.om.fundacion.CPolipo;
import mx.com.web2lab.backend.hbm.om.fundacion.CResultadoPapanicolau;
import mx.com.web2lab.backend.hbm.om.fundacion.CSecrecion;
import mx.com.web2lab.backend.hbm.om.fundacion.CTiposBiopsia;
import mx.com.web2lab.backend.hbm.om.fundacion.CTratamientoDiabet;
import mx.com.web2lab.backend.util.beans.fundacion.BPacienteCuestionarioBean;
import mx.com.web2lab.backend.util.formatos.Formatos;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CuestionarioDao {

	private static Log iObjLog = LogFactory.getLog(CuestionarioDao.class);
	    
	private Session iObjSesion = null;
	
	public CuestionarioDao(){
		iObjSesion = HibernateUtil.getSession();
	}

	public BPacienteCuestionarioBean setCuestionarioActualizacion(BPacienteCuestionarioBean objCuestionarioBean) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		BPacienteFundacion objPaciente = new BPacienteFundacion();
		BPacienteCuestionario objCuestionario = new BPacienteCuestionario();		
		CEscolaridad objEscolaridad = new CEscolaridad();
		CEstadoCivil objEstadoCivil = new CEstadoCivil();
		COcupacionPaciente objOcupacionPaciente = new COcupacionPaciente();
		COcupacionFamiliar objOcupacionFamiliar = new COcupacionFamiliar();
		CCervix objCervix = new CCervix();
		CDiu objDiu = new CDiu();
		CEctropion objElectropion = new CEctropion();
		CHTA objHTA = new CHTA();
		CPolipo objPolipo = new CPolipo();
		CSecrecion objSecrecion = new CSecrecion();
		CTiposBiopsia objTipoBiopsia = new CTiposBiopsia();
		CLugarPapanicolau objLugarPapanicolau = new CLugarPapanicolau();
		CResultadoPapanicolau objResultadoPapanicolau = new CResultadoPapanicolau();
		CTratamientoDiabet objTratamientoDiabet = new CTratamientoDiabet();
		
		Formatos objFormatos = new Formatos();
		iObjLog.debug("Entrando a CuestionarioDao.setCuestionarioActualizacion...Consulta" + objCuestionarioBean.getUTamanoEctropion());
		try {						
			objCuestionario.setBalergias(objCuestionarioBean.isBalergias());
			objCuestionario.setSmedicamento(objCuestionarioBean.getSmedicamento());
			objCuestionario.setBantececervico(objCuestionarioBean.isBanteceCervico());
			objCuestionario.setBantecemama(objCuestionarioBean.isBanteceMama());
			objCuestionario.setBantibarrera(objCuestionarioBean.isBantiBarrera());
			objCuestionario.setBanticoito(objCuestionarioBean.isBantiCoito());
			objCuestionario.setBantidiu(objCuestionarioBean.isBantiDiu());
			objCuestionario.setBantiimplante(objCuestionarioBean.isBantiImplante());
			objCuestionario.setBantilocal(objCuestionarioBean.isBantiLocal());
			objCuestionario.setBantinada(objCuestionarioBean.isBantiNada());
			objCuestionario.setBantioral(objCuestionarioBean.isBantiOral());
			objCuestionario.setBantiotro(objCuestionarioBean.isBantiOtro());
			objCuestionario.setBantiparche(objCuestionarioBean.isBantiParche());
			objCuestionario.setBantiparental(objCuestionarioBean.isBantiParenteral());
			objCuestionario.setBantiritmo(objCuestionarioBean.isBantiRitmo());
			objCuestionario.setBantisalpingoclasia(objCuestionarioBean.isBantiSalpingoclasia());
			objCuestionario.setBantivasectomia(objCuestionarioBean.isBantiVasectomia());
			objCuestionario.setBcervixanterior(objCuestionarioBean.isBcervixAnterior());
			objCuestionario.setBcervixcentral(objCuestionarioBean.isBcervixCentral());
			objCuestionario.setBcervixderecho(objCuestionarioBean.isBcervixDerecho());
			objCuestionario.setBcervixizquierdo(objCuestionarioBean.isBcervixIzquierdo());
			objCuestionario.setBcervixposterior(objCuestionarioBean.isBcervixPosterior());
			objCuestionario.setBcrioterapia(objCuestionarioBean.isBcrioterapia());
			objCuestionario.setBdiabetes(objCuestionarioBean.isBdiabetes());
			objCuestionario.setBelectrocoagulacion(objCuestionarioBean.isBelectroCoagulacion());
			objCuestionario.setBeqx(objCuestionarioBean.isBeqx());
			objCuestionario.setBlactancia(objCuestionarioBean.isBlactancia());
			objCuestionario.setBmei(objCuestionarioBean.isBmei());
			objCuestionario.setBmeipo(objCuestionarioBean.isBmeipo());
			objCuestionario.setBoforectomiaderecho(objCuestionarioBean.isBoforectomiaDerecho());
			objCuestionario.setBoforectomiaizuierdo(objCuestionarioBean.isBoforectomiaIzuierdo());
			objCuestionario.setBoforectomiano(objCuestionarioBean.isBoforectomiaNo());
			objPaciente.setKpacientefundacion(new Long(objCuestionarioBean.getBpacientefundacion()));
			objCuestionario.setBpacientefundacion(objPaciente);
			objCuestionario.setBprocesoerosivo(objCuestionarioBean.isBprocesoErosivo());
			objCuestionario.setBquistenaboth(objCuestionarioBean.isBquisteNaboth());
			objCuestionario.setBregistroactivo(true);
			objCuestionario.setBsecrecionabundante(objCuestionarioBean.isBsecresionAbundante());
			objCuestionario.setBsecrecionescasa(objCuestionarioBean.isBsecresionEscasa());
			objCuestionario.setBsecrecionespesa(objCuestionarioBean.isBsecresionEspesa());
			objCuestionario.setBsecrecionespumosa(objCuestionarioBean.isBsecresionEspumosa());
			objCuestionario.setBsecrecionfluida(objCuestionarioBean.isBsecresionFluida());
			objCuestionario.setBsecreciongrumosa(objCuestionarioBean.isBsecresionGrumosa());
			objCuestionario.setBsecrecionmixta(objCuestionarioBean.isBsecresionMixta());
			objCuestionario.setBsecrecionmoderada(objCuestionarioBean.isBsecresionModerada());
			objCuestionario.setBsecrecionsemiespesa(objCuestionarioBean.isBsecresionSemiespesa());
			objCuestionario.setBtabaquismo(objCuestionarioBean.isBtabaquismo());
			objCuestionario.setBunionescamoclumnar(objCuestionarioBean.isBunionEscamoclumnar());
			objCuestionario.setBvph(objCuestionarioBean.isBvph());
			objEscolaridad.setCescolaridad(new Integer(objCuestionarioBean.getCescolaridad()));			
			objCuestionario.setCescolaridad(objEscolaridad);
			objEstadoCivil.setCestadocivil(new Integer(objCuestionarioBean.getCestadocivil()));
			objCuestionario.setCestadocivil(objEstadoCivil);			
			objOcupacionFamiliar.setCocupacionfamiliar(new Integer(objCuestionarioBean.getCocupacionfamiliar()));			
			objCuestionario.setCocupacionfamiliar(objOcupacionFamiliar);			
			objOcupacionPaciente.setCocupacionpaciente(new Integer(objCuestionarioBean.getCocupacionpaciente()));
			objCuestionario.setCocupacionpaciente(objOcupacionPaciente);			
			if (objCuestionarioBean.getCcervix() > 0) {
				objCervix.setCcervix(new Integer(objCuestionarioBean.getCcervix()));
				objCuestionario.setCcervix(objCervix);
			} else {
				objCuestionario.setCcervix(null);
			}
			if (objCuestionarioBean.getCdiu() > 0) {
				objDiu.setCdiu(new Integer(objCuestionarioBean.getCdiu()));
				objCuestionario.setCdiu(objDiu);
			} else {
				objCuestionario.setCdiu(null);
			}
			if (objCuestionarioBean.getCectropion() > 0) {
				objElectropion.setCectropion(new Integer(objCuestionarioBean.getCectropion()));
				objCuestionario.setCectropion(objElectropion);
			} else {
				objCuestionario.setCectropion(null);
			}
			objCuestionario.setCestado(1);
			objCuestionario.setCusuario(objCuestionarioBean.getIdUsuario());
			
			if (objCuestionarioBean.getChta() > 0) {
				objHTA.setChta(new Integer(objCuestionarioBean.getChta()));
				objCuestionario.setChta(objHTA);
			} else {
				objCuestionario.setChta(null);
			}

			if (objCuestionarioBean.getClugarPapanicolau() > 0) {
				objLugarPapanicolau.setClugarPapanicolau(new Integer(objCuestionarioBean.getClugarPapanicolau()));
				objCuestionario.setClugarpapanicolau(objLugarPapanicolau);
			} else {
				objCuestionario.setClugarpapanicolau(null);
			}

			if (objCuestionarioBean.getCpolipo() > 0) {
				objPolipo.setCpolipo(new Integer(objCuestionarioBean.getCpolipo()));
				objCuestionario.setCpolipo(objPolipo);
			} else {
				objCuestionario.setCpolipo(null);				
			}
			if (objCuestionarioBean.getCresultadoPapanicolau() > 0 ) {
				objResultadoPapanicolau.setCresultadoPapanicolau(new Integer(objCuestionarioBean.getCresultadoPapanicolau()));			
				objCuestionario.setCresultadopapanicolau(objResultadoPapanicolau);
			} else {
				objCuestionario.setCresultadopapanicolau(null);				
			}
			if(objCuestionarioBean.getCsecrecion() > 0) { 
				objSecrecion.setCsecrecion(new Integer(objCuestionarioBean.getCsecrecion()));
				objCuestionario.setCsecrecion(objSecrecion);
			} else {
				objCuestionario.setCsecrecion(null);				
			}
			if (objCuestionarioBean.getCtiposBiopsia() > 0) {
				objTipoBiopsia.setCtiposBiopsia(new Integer(objCuestionarioBean.getCtiposBiopsia()));
				objCuestionario.setCtiposbiopsia(objTipoBiopsia);
			} else {
				objCuestionario.setCtiposbiopsia(null);				
			}
			if (objCuestionarioBean.getCtratamientodiabet() > 0) {
				objTratamientoDiabet.setCtratamientodiabetes(new Integer(objCuestionarioBean.getCtratamientodiabet()));
				objCuestionario.setCtratamientodiabet(objTratamientoDiabet);
			} else {
				objCuestionario.setCtratamientodiabet(null);				
			}
			if (objCuestionarioBean.getDfechaCrioterapia().trim() != "") {
				objCuestionario.setDfechacrioterapia(objFormatos.getFecha(objCuestionarioBean.getDfechaCrioterapia()));
			} else {
				objCuestionario.setDfechacrioterapia(null);				
			}
			if (objCuestionarioBean.getDfechaElectroCoagulacion().trim() != "") {
				objCuestionario.setDfechaelectrocoagulacion(objFormatos.getFecha(objCuestionarioBean.getDfechaElectroCoagulacion()));
			} else {
				objCuestionario.setDfechaelectrocoagulacion(null);				
			}
			if (objCuestionarioBean.getDfechaEqx().trim() != "") {
				objCuestionario.setDfechaeqx(objFormatos.getFecha(objCuestionarioBean.getDfechaEqx()));
			} else {
				objCuestionario.setDfechaeqx(null);				
			}
			if (objCuestionarioBean.getDfechaHisterectomia().trim() != "") {
				objCuestionario.setDfechahisterectimia(objFormatos.getFecha(objCuestionarioBean.getDfechaHisterectomia()));
			} else {
				objCuestionario.setDfechahisterectimia(null);				
			}
			if (objCuestionarioBean.getDfechaOforectomia().trim() != "") {
				objCuestionario.setDfechaoforectomia(objFormatos.getFecha(objCuestionarioBean.getDfechaOforectomia()));
			} else {
				objCuestionario.setDfechaoforectomia(null);				
			}
			if (objCuestionarioBean.getDfechaUltimaRegla().trim() != "") {
				objCuestionario.setDfechaultimaregla(objFormatos.getFecha(objCuestionarioBean.getDfechaUltimaRegla()));
			} else {
				objCuestionario.setDfechaultimaregla(null);				
			}
			if (objCuestionarioBean.getDfechaUltimoPapanicolau().trim() != "") {
				objCuestionario.setDfechaultimopapanicolau(objFormatos.getFecha(objCuestionarioBean.getDfechaUltimoPapanicolau()));
			} else {
				objCuestionario.setDfechaultimopapanicolau(null);				
			}
			if (objCuestionarioBean.getDfechaVph().trim() != "") {
				objCuestionario.setDfechavph(objFormatos.getFecha(objCuestionarioBean.getDfechaVph()));				
			} else {
				objCuestionario.setDfechavph(null);								
			}
			objCuestionario.setDregistro(new Date());
			objCuestionario.setSanteceherefami(objCuestionarioBean.getSanteceHereFami());
			objCuestionario.setSmotivocrioterapia(objCuestionarioBean.getSmotivoCrioterapia());			
			CMotivoElectroCoagulacion objMEC = new CMotivoElectroCoagulacion();
			objMEC.setCmotivoelectrocoagulacion(new Integer(objCuestionarioBean.getCmotivoElectroCoagulacion()));
			objCuestionario.setCmotivoelectrocoagulacion(objMEC);
			CMotivoEQX objMEXQ = new CMotivoEQX();
			objMEXQ.setCmotivoeqx(new Integer(objCuestionarioBean.getCmotivoEqx()));
			objCuestionario.setCmotivoeqx(objMEXQ);
			CMotivoEstudio objME = new CMotivoEstudio();
			objME.setCmotivoestudio(new Integer(objCuestionarioBean.getCmotivoEstudio()));
			objCuestionario.setCmotivoestudio(objME);
			CMotivoHisterectomia objMH = new CMotivoHisterectomia();
			objMH.setCmotivohisterectomia(new Integer(objCuestionarioBean.getCmotivoHisterectomia()));
			objCuestionario.setCmotivohisterectomia(objMH);
			objCuestionario.setSmotivooforectomia(objCuestionarioBean.getSmotivoOforectomia());
			objCuestionario.setSotroanticonceptivo(objCuestionarioBean.getSotroAnticonceptivo());
			objCuestionario.setSquistenaboth(objCuestionarioBean.getSquisteNaboth());
			objCuestionario.setSsintomatologiaactual(objCuestionarioBean.getSsintomatologiaActual());
			objCuestionario.setSvulvaotros(objCuestionarioBean.getSvulvaOtros());
			objCuestionario.setSzonasacetopositivas(objCuestionarioBean.getSzonasAcetopositivas());
			objCuestionario.setUabortos(objCuestionarioBean.getUabortos());
			objCuestionario.setUcesarias(objCuestionarioBean.getUcesareas());
			objCuestionario.setUclimaterio(objCuestionarioBean.getUclimaterio());
			objCuestionario.setUdiabetestiempo(objCuestionarioBean.getUdiabetestiempo());
			objCuestionario.setUdiasritmo1(objCuestionarioBean.getUdiasritmo1());
			objCuestionario.setUdiasritmo2(objCuestionarioBean.getUdiasritmo2());
			objCuestionario.setUgestaciones(objCuestionarioBean.getUgestaciones());
			objCuestionario.setUmenarca(objCuestionarioBean.getUmenarca());
			objCuestionario.setUnumeroparejassexuales(objCuestionarioBean.getUnumeroParejasSexuales());
			objCuestionario.setUpartosnormales(objCuestionarioBean.getUpartosNormales());
			objCuestionario.setUprimerembarazo(objCuestionarioBean.getUprimerEmbarazo());
			objCuestionario.setUtabaquismodia(objCuestionarioBean.getUtabaquismodia());
			objCuestionario.setUtabaquismotiempo(objCuestionarioBean.getUtabaquismotiempo());
			iObjLog.debug("Entrando a CuestionarioDao.setCuestionarioActualizacion...Consulta 2.." + objCuestionarioBean.getUTamanoEctropion());			
			objCuestionario.setUtamanoectropion(objCuestionarioBean.getUTamanoEctropion());
			objCuestionario.setUtamanoperiorificiador(objCuestionarioBean.getUtamanoPeriorificiador());
			objCuestionario.setUvidasexualactiva(objCuestionarioBean.getUvidaSexualActiva());			
            HibernateUtil.beginTrans();
            	if (objCuestionarioBean.getKpacientecuestionario() == 0) {
            		iObjSesion.save(objCuestionario);
            	} else {
        			objCuestionario.setKpacientecuestionario(new Long(objCuestionarioBean.getKpacientecuestionario()));
            		iObjSesion.update(objCuestionario);            		
            	}
	    		iObjSesion.flush();            	
            //HibernateUtil.commitTrans();	 
            objCuestionarioBean.setKpacientecuestionario(objCuestionario.getKpacientecuestionario().intValue());
			iObjLog.debug("Saliendo PacientesDao.setPacienteActualizacion:Saliendo...  " + objPaciente.toString());
			return objCuestionarioBean;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR PacientesDao.setPacienteActualizacion: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}	
	
	
	
	
	public BPacienteCuestionarioBean buscarPaciente(BPacienteCuestionarioBean objPCuestionarioBean) throws Exception {
		iObjSesion = HibernateUtil.getSession();
			List objListaPacientes = new ArrayList();
			Query objQuery = null;
			String strQuery = "";
			BPacienteCuestionarioBean objCuestionario = new BPacienteCuestionarioBean();
	    	try{
	            HibernateUtil.beginTrans();
					strQuery = "select bPF " +					
							" from BPacienteCuestionario bPF " +					
							" where bPF.bpacientefundacion.kpacientefundacion =  " + objPCuestionarioBean.getBpacientefundacion();
					objQuery = iObjSesion.createQuery(strQuery);
					objListaPacientes = objQuery.list();
	            //HibernateUtil.commitTrans();	 				
				if(objListaPacientes != null) {
					if (objListaPacientes.size() > 0) {
						BPacienteCuestionario objCuestionarioBean = (BPacienteCuestionario)objListaPacientes.get(0);
						objCuestionario.setBalergias(objCuestionarioBean.isBalergias());
						objCuestionario.setBanteceCervico(objCuestionarioBean.isBantececervico());
						objCuestionario.setBanteceMama(objCuestionarioBean.isBantecemama());
						objCuestionario.setBantiBarrera(objCuestionarioBean.isBantibarrera());
						objCuestionario.setBantiCoito(objCuestionarioBean.isBanticoito());
						objCuestionario.setBantiDiu(objCuestionarioBean.isBantidiu());
						objCuestionario.setBantiImplante(objCuestionarioBean.isBantiimplante());
						objCuestionario.setBantiLocal(objCuestionarioBean.isBantilocal());
						objCuestionario.setBantiNada(objCuestionarioBean.isBantinada());
						objCuestionario.setBantiOral(objCuestionarioBean.isBantioral());
						objCuestionario.setBantiOtro(objCuestionarioBean.isBantiotro());
						objCuestionario.setBantiParche(objCuestionarioBean.isBantiparche());
						objCuestionario.setBantiParenteral(objCuestionarioBean.isBantiparental());
						objCuestionario.setBantiRitmo(objCuestionarioBean.isBantiritmo());
						objCuestionario.setBantiSalpingoclasia(objCuestionarioBean.isBantisalpingoclasia());
						objCuestionario.setBantiVasectomia(objCuestionarioBean.isBantivasectomia());
						objCuestionario.setBcervixAnterior(objCuestionarioBean.isBcervixanterior());
						objCuestionario.setBcervixCentral(objCuestionarioBean.isBcervixcentral());
						objCuestionario.setBcervixDerecho(objCuestionarioBean.isBcervixderecho());
						objCuestionario.setBcervixIzquierdo(objCuestionarioBean.isBcervixizquierdo());
						objCuestionario.setBcervixPosterior(objCuestionarioBean.isBcervixposterior());
						objCuestionario.setBcrioterapia(objCuestionarioBean.isBcrioterapia());
						objCuestionario.setBdiabetes(objCuestionarioBean.isBdiabetes());
						objCuestionario.setBelectroCoagulacion(objCuestionarioBean.isBelectrocoagulacion());
						objCuestionario.setBeqx(objCuestionarioBean.isBeqx());
						objCuestionario.setBlactancia(objCuestionarioBean.isBlactancia());
						objCuestionario.setBmei(objCuestionarioBean.isBmei());
						objCuestionario.setBmeipo(objCuestionarioBean.isBmeipo());
						objCuestionario.setBoforectomiaDerecho(objCuestionarioBean.isBoforectomiaderecho());
						objCuestionario.setBoforectomiaIzuierdo(objCuestionarioBean.isBoforectomiaizuierdo());
						objCuestionario.setBoforectomiaNo(objCuestionarioBean.isBoforectomiano());
						objCuestionario.setBprocesoErosivo(objCuestionarioBean.isBprocesoerosivo());
						objCuestionario.setBquisteNaboth(objCuestionarioBean.isBquistenaboth());
						objCuestionario.setBsecresionAbundante(objCuestionarioBean.isBsecrecionabundante());
						objCuestionario.setBsecresionEscasa(objCuestionarioBean.isBsecrecionescasa());
						objCuestionario.setBsecresionEspesa(objCuestionarioBean.isBsecrecionespesa());
						objCuestionario.setBsecresionEspumosa(objCuestionarioBean.isBsecrecionespumosa());
						objCuestionario.setBsecresionFluida(objCuestionarioBean.isBsecrecionfluida());
						objCuestionario.setBsecresionGrumosa(objCuestionarioBean.isBsecreciongrumosa());
						objCuestionario.setBsecresionMixta(objCuestionarioBean.isBsecrecionmixta());
						objCuestionario.setBsecresionModerada(objCuestionarioBean.isBsecrecionmoderada());
						objCuestionario.setBsecresionSemiespesa(objCuestionarioBean.isBsecrecionsemiespesa());
						objCuestionario.setBtabaquismo(objCuestionarioBean.isBtabaquismo());
						objCuestionario.setBunionEscamoclumnar(objCuestionarioBean.isBunionescamoclumnar());
						objCuestionario.setBvph(objCuestionarioBean.isBvph());
						if (objCuestionarioBean.getCcervix() != null) {
							objCuestionario.setCcervix(objCuestionarioBean.getCcervix().getCcervix().intValue());
						} else {
							objCuestionario.setCcervix(0);
						}
						if (objCuestionarioBean.getCdiu() != null) {
							objCuestionario.setCdiu(objCuestionarioBean.getCdiu().getCdiu().intValue());
						} else {
							objCuestionario.setCdiu(0);
						}
						if (objCuestionarioBean.getCectropion() != null) {
							objCuestionario.setCectropion(objCuestionarioBean.getCectropion().getCectropion().intValue());
						} else {
							objCuestionario.setCectropion(0);
						}					
						if (objCuestionarioBean.getChta() != null) {
							objCuestionario.setChta(objCuestionarioBean.getChta().getChta().intValue());
						} else {
							objCuestionario.setChta(0);
						}
	
						if (objCuestionarioBean.getClugarpapanicolau() != null) {
							objCuestionario.setClugarPapanicolau(objCuestionarioBean.getClugarpapanicolau().getClugarPapanicolau().intValue());
						} else {
							objCuestionario.setClugarPapanicolau(0);
						}
	
						if (objCuestionarioBean.getCpolipo() != null) {
							objCuestionario.setCpolipo(objCuestionarioBean.getCpolipo().getCpolipo().intValue());
						} else {
							objCuestionario.setCpolipo(0);				
						}
						if (objCuestionarioBean.getCresultadopapanicolau() != null ) {
							objCuestionario.setCresultadoPapanicolau(objCuestionarioBean.getCresultadopapanicolau().getCresultadoPapanicolau().intValue());
						} else {
							objCuestionario.setCresultadoPapanicolau(0);				
						}
						if(objCuestionarioBean.getCsecrecion() != null) { 
							objCuestionario.setCsecrecion(objCuestionarioBean.getCsecrecion().getCsecrecion().intValue());
						} else {
							objCuestionario.setCsecrecion(0);				
						}
						if (objCuestionarioBean.getCtiposbiopsia() != null) {
							objCuestionario.setCtiposBiopsia(objCuestionarioBean.getCtiposbiopsia().getCtiposBiopsia().intValue());
						} else {
							objCuestionario.setCtiposBiopsia(0);				
						}
						if (objCuestionarioBean.getCtratamientodiabet() != null) {
							objCuestionario.setCtratamientodiabet(objCuestionarioBean.getCtratamientodiabet().getCtratamientodiabetes().intValue());
						} else {
							objCuestionario.setCtratamientodiabet(0);				
						}
						if (objCuestionarioBean.getDfechaultimopapanicolau() != null) {
							objCuestionario.setDfechaUltimoPapanicolau(new Formatos().getFechaNumeros(objCuestionarioBean.getDfechaultimopapanicolau()));
						} else {
							objCuestionario.setDfechaUltimoPapanicolau("");				
						}

						if (objCuestionarioBean.getDfechacrioterapia() != null) {
							objCuestionario.setDfechaCrioterapia(new Formatos().getFechaNumeros(objCuestionarioBean.getDfechacrioterapia()));
						} else {
							objCuestionario.setDfechaCrioterapia("");				
						}
						if (objCuestionarioBean.getDfechaelectrocoagulacion() != null) {
							objCuestionario.setDfechaElectroCoagulacion(new Formatos().getFechaNumeros(objCuestionarioBean.getDfechaelectrocoagulacion()));
						} else {
							objCuestionario.setDfechaElectroCoagulacion("");				
						}
						if (objCuestionarioBean.getDfechaeqx() != null) {
							objCuestionario.setDfechaEqx(new Formatos().getFechaNumeros(objCuestionarioBean.getDfechaeqx()));
						} else {
							objCuestionario.setDfechaEqx("");				
						}
						if (objCuestionarioBean.getDfechahisterectimia() != null) {
							objCuestionario.setDfechaHisterectomia(new Formatos().getFechaNumeros(objCuestionarioBean.getDfechahisterectimia()));
						} else {
							objCuestionario.setDfechaHisterectomia("");				
						}
						if (objCuestionarioBean.getDfechaoforectomia() != null) {
							objCuestionario.setDfechaOforectomia(new Formatos().getFechaNumeros(objCuestionarioBean.getDfechaoforectomia()));
						} else {
							objCuestionario.setDfechaOforectomia("");				
						}
						if (objCuestionarioBean.getDfechaultimaregla() != null) {
							objCuestionario.setDfechaUltimaRegla(new Formatos().getFechaNumeros(objCuestionarioBean.getDfechaultimaregla()));
						} else {
							objCuestionario.setDfechaUltimaRegla("");				
						}
						if (objCuestionarioBean.getDfechaultimopapanicolau() != null) {
							objCuestionario.setDfechaUltimoPapanicolau(new Formatos().getFechaNumeros(objCuestionarioBean.getDfechaultimopapanicolau()));
						} else {
							objCuestionario.setDfechaUltimoPapanicolau("");				
						}
						if (objCuestionarioBean.getDfechavph() != null) {
							objCuestionario.setDfechaVph(new Formatos().getFechaNumeros(objCuestionarioBean.getDfechavph()));				
						} else {
							objCuestionario.setDfechaVph("");								
						}
						
						if (objCuestionarioBean.getSanteceherefami() != null) {
							objCuestionario.setSanteceHereFami(objCuestionarioBean.getSanteceherefami());				
						} else {
							objCuestionario.setSanteceHereFami("");								
						}
						if (objCuestionarioBean.getSmotivocrioterapia() != null) {
							objCuestionario.setSmotivoCrioterapia(objCuestionarioBean.getSmotivocrioterapia());				
						} else {
							objCuestionario.setSmotivoCrioterapia("");								
						}

						if (objCuestionarioBean.getSmedicamento() != null) {
							objCuestionario.setSmedicamento(objCuestionarioBean.getSmedicamento());				
						} else {
							objCuestionario.setSmedicamento("");								
						}
						objCuestionario.setCescolaridad(objCuestionarioBean.getCescolaridad().getCescolaridad().intValue());
						objCuestionario.setCestadocivil(objCuestionarioBean.getCestadocivil().getCestadocivil().intValue());
						objCuestionario.setCocupacionfamiliar(objCuestionarioBean.getCocupacionfamiliar().getCocupacionfamiliar().intValue());
						objCuestionario.setCocupacionpaciente(objCuestionarioBean.getCocupacionpaciente().getCocupacionpaciente().intValue());						
						objCuestionario.setCmotivoElectroCoagulacion(objCuestionarioBean.getCmotivoelectrocoagulacion().getCmotivoelectrocoagulacion().intValue());
						objCuestionario.setCmotivoEqx(objCuestionarioBean.getCmotivoeqx().getCmotivoeqx().intValue());
						objCuestionario.setCmotivoEstudio(objCuestionarioBean.getCmotivoestudio().getCmotivoestudio().intValue());
						objCuestionario.setCmotivoHisterectomia(objCuestionarioBean.getCmotivohisterectomia().getCmotivohisterectomia().intValue());
						if (objCuestionarioBean.getSmotivooforectomia() != null) {
							objCuestionario.setSmotivoOforectomia(objCuestionarioBean.getSmotivooforectomia());				
						} else {
							objCuestionario.setSmotivoOforectomia("");								
						}
						if (objCuestionarioBean.getSotroanticonceptivo() != null) {
							objCuestionario.setSotroAnticonceptivo(objCuestionarioBean.getSotroanticonceptivo());				
						} else {
							objCuestionario.setSotroAnticonceptivo("");								
						}
						if (objCuestionarioBean.getSquistenaboth() != null) {
							objCuestionario.setSquisteNaboth(objCuestionarioBean.getSquistenaboth());				
						} else {
							objCuestionario.setSquisteNaboth("");								
						}
						if (objCuestionarioBean.getSsintomatologiaactual() != null) {
							objCuestionario.setSsintomatologiaActual(objCuestionarioBean.getSsintomatologiaactual());				
						} else {
							objCuestionario.setSsintomatologiaActual("");								
						}
						if (objCuestionarioBean.getSvulvaotros() != null) {
							objCuestionario.setSvulvaOtros(objCuestionarioBean.getSvulvaotros());				
						} else {
							objCuestionario.setSvulvaOtros("");								
						}
						if (objCuestionarioBean.getSzonasacetopositivas() != null) {
							objCuestionario.setSzonasAcetopositivas(objCuestionarioBean.getSzonasacetopositivas());				
						} else {
							objCuestionario.setSzonasAcetopositivas("");								
						}
						objCuestionario.setUabortos(objCuestionarioBean.getUabortos());
						objCuestionario.setUcesareas(objCuestionarioBean.getUcesarias());
						objCuestionario.setUclimaterio(objCuestionarioBean.getUclimaterio());
						objCuestionario.setUdiabetestiempo(objCuestionarioBean.getUdiabetestiempo());
						objCuestionario.setUdiasritmo1(objCuestionarioBean.getUdiasritmo1());
						objCuestionario.setUdiasritmo2(objCuestionarioBean.getUdiasritmo2());
						objCuestionario.setUgestaciones(objCuestionarioBean.getUgestaciones());
						objCuestionario.setUmenarca(objCuestionarioBean.getUmenarca());
						objCuestionario.setUnumeroParejasSexuales(objCuestionarioBean.getUnumeroparejassexuales());
						objCuestionario.setUpartosNormales(objCuestionarioBean.getUpartosnormales());
						objCuestionario.setUprimerEmbarazo(objCuestionarioBean.getUprimerembarazo());
						objCuestionario.setUtabaquismodia(objCuestionarioBean.getUtabaquismodia());
						objCuestionario.setUtabaquismotiempo(objCuestionarioBean.getUtabaquismotiempo());
						objCuestionario.setUTamanoEctropion(objCuestionarioBean.getUtamanoectropion());
						objCuestionario.setUtamanoPeriorificiador(objCuestionarioBean.getUtamanoperiorificiador());
						objCuestionario.setUvidaSexualActiva(objCuestionarioBean.getUvidasexualactiva());			
						objCuestionario.setKpacientecuestionario(objCuestionarioBean.getKpacientecuestionario().intValue());
					}
				}			
			iObjLog.debug("Saliendo PacientesDao.buscarPaciente:Saliendo...  " + objCuestionario.getObject());
			return objCuestionario;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR PacientesDao.buscarPaciente: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}	

	public List buscarPacientes(PacienteBean objPacienteBean) throws Exception {
		iObjSesion = HibernateUtil.getSession();
			List objListaPacientes = new ArrayList();
			List lstReturn = new ArrayList();
			Query objQuery = null;
			String strQuery = "";
	    	try{
				iObjLog.debug("Entrando PacientesDao.buscarPacientes:Entrando...  " + objPacienteBean.toString());
	            HibernateUtil.beginTrans();
					strQuery = "select bPF " +					
							" from BPacienteFundacion bPF " +					
							" where bPF.snombre=bPF.snombre ";
					if (objPacienteBean.getSnombre().trim() != "") {
						strQuery += " AND bPF.snombre like ('" + objPacienteBean.getSnombre() + "%') ";
					}
					if (objPacienteBean.getSappaterno().trim() != "") {
						strQuery += " AND bPF.sappaterno like ('" + objPacienteBean.getSappaterno() + "%') ";
					}
					if (objPacienteBean.getSapmaterno().trim() != "") {
						strQuery += " AND bPF.sapmaterno like ('" + objPacienteBean.getSapmaterno() + "%') ";
					}
					iObjLog.debug("Entrando PacientesDao.buscarPacientes:Consulta...  " + strQuery);
					objQuery = iObjSesion.createQuery(strQuery);
					objListaPacientes = objQuery.list();
					iObjLog.debug("Entrando PacientesDao.buscarPacientes:Resultado...  " + objListaPacientes.size());
					 if (objListaPacientes != null) {
							for (int i = 0; i < objListaPacientes.size() ; i++)
							{
								BPacienteFundacion objPaciente = (BPacienteFundacion)objListaPacientes.get(i);
								objPacienteBean = new PacienteBean();
								objPacienteBean.setSnombre(objPaciente.getSnombre());
								objPacienteBean.setSappaterno(objPaciente.getSappaterno());
								objPacienteBean.setSapmaterno(objPaciente.getSapmaterno());
								objPacienteBean.setKpacientefundacion(new Integer(objPaciente.getKpacientefundacion().intValue()));
								objPacienteBean.setSnacimiento(new Formatos().getFechaNumeros(objPaciente.getDnacimiento()));					
								lstReturn.add(objPacienteBean);
							}
						}
				//HibernateUtil.commitTrans();	 				
			iObjLog.debug("Saliendo PacientesDao.buscarPacientes:Saliendo...  " + objPacienteBean.toString());
			return lstReturn;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR PacientesDao.buscarPacientes:: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}		
}
