package mx.com.web2lab.backend.dao.ap;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mx.com.web2lab.backend.hbm.HibernateUtil;
import mx.com.web2lab.backend.hbm.om.fundacion.BOrdenDiagFundacion;
import mx.com.web2lab.backend.hbm.om.fundacion.BOrdenFundacion;

import mx.com.web2lab.backend.util.beans.fundacion.BOrdenDiagFundacionBean;
import mx.com.web2lab.backend.util.formatos.Formatos;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DiagnosticoDao {

	private static Log iObjLog = LogFactory.getLog(DiagnosticoDao.class);
	    
	private Session iObjSesion = null;
	
	public DiagnosticoDao(){
		iObjSesion = HibernateUtil.getSession();
	}

	public BOrdenDiagFundacionBean actualizarDiagnostico(BOrdenDiagFundacionBean objDiagnosticoBean) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		BOrdenDiagFundacion objDiagnostico = new BOrdenDiagFundacion();
		BOrdenFundacion objOrdenFundacion = new BOrdenFundacion();
		iObjLog.debug("Entrandoa DiagnosticoDao.setDiagnosticoActualizacion...Consulta");
		try {					
            HibernateUtil.beginTrans();
            objOrdenFundacion.setKordenfundacion(new Long(objDiagnosticoBean.getKordenfundacion()));
            objDiagnostico.setBordenfundacion(objOrdenFundacion);
            objDiagnostico.setSvulvarotros(objDiagnosticoBean.getSvulvarotros());
            objDiagnostico.setCtiposbiopsia(objDiagnosticoBean.getCtiposbiopsia());
            objDiagnostico.setBvulvaberruga(objDiagnosticoBean.isBvulvaberruga());
            objDiagnostico.setBvulvabartho(objDiagnosticoBean.isBvulvabartho());
            objDiagnostico.setBvulvapapilomatosis(objDiagnosticoBean.isBvulvapapilomatosis());
            objDiagnostico.setBvulvamolusco(objDiagnosticoBean.isBvulvamolusco());
            objDiagnostico.setBvulvanevos(objDiagnosticoBean.isBvulvanevos());
            objDiagnostico.setBvulvaquiste(objDiagnosticoBean.isBvulvaquiste());
            objDiagnostico.setBvulvavph(objDiagnosticoBean.isBvulvavph());
            objDiagnostico.setCvulvitis(objDiagnosticoBean.getCvulvitis());
            objDiagnostico.setBvulvaacuminada(objDiagnosticoBean.isBvulvaacuminada());
            objDiagnostico.setBvulvaperianal(objDiagnosticoBean.isBvulvaperianal());
            objDiagnostico.setBvulvavaginal(objDiagnosticoBean.isBvulvavaginal());
            objDiagnostico.setBvulvavulvar(objDiagnosticoBean.isBvulvavulvar());
            objDiagnostico.setCatrifia(objDiagnosticoBean.getCatrifia());
            objDiagnostico.setBvulvafolicutilits(objDiagnosticoBean.isBvulvafolicutilits());
            objDiagnostico.setCcervix(objDiagnosticoBean.getCcervix());
            objDiagnostico.setBcervixcentral(objDiagnosticoBean.isBcervixcentral());
            objDiagnostico.setBcervixderecho(objDiagnosticoBean.isBcervixderecho());
            objDiagnostico.setBcervixizquierdo(objDiagnosticoBean.isBcervixizquierdo());
            objDiagnostico.setBcervixanterior(objDiagnosticoBean.isBcervixanterior());
            objDiagnostico.setBcervixposterior(objDiagnosticoBean.isBcervixposterior());
            objDiagnostico.setCsecrecion(objDiagnosticoBean.getCsecrecion());
            objDiagnostico.setBsecrecionfluida(objDiagnosticoBean.isBsecrecionfluida());
            objDiagnostico.setBsecrecionespesa(objDiagnosticoBean.isBsecrecionespesa());
            objDiagnostico.setBsecrecionsemiespesa(objDiagnosticoBean.isBsecrecionsemiespesa());
            objDiagnostico.setBsecreciongrumosa(objDiagnosticoBean.isBsecreciongrumosa());
            objDiagnostico.setBsecrecionespumosa(objDiagnosticoBean.isBsecrecionespumosa());
            objDiagnostico.setBsecrecionescasa(objDiagnosticoBean.isBsecrecionescasa());
            objDiagnostico.setBsecrecionmoderada(objDiagnosticoBean.isBsecrecionmoderada());
            objDiagnostico.setBsecrecionabundante(objDiagnosticoBean.isBsecrecionabundante());
            objDiagnostico.setCdiu(objDiagnosticoBean.getCdiu());
            objDiagnostico.setBunionescamoclumnar(objDiagnosticoBean.isBunionescamoclumnar());
            objDiagnostico.setSzonasacetopositivas(objDiagnosticoBean.getSzonasacetopositivas());
            objDiagnostico.setCectropion(objDiagnosticoBean.getCectropion());
            objDiagnostico.setUtamanoectropion(objDiagnosticoBean.getUtamanoectropion());
            objDiagnostico.setCpolipo(objDiagnosticoBean.getCpolipo());
            objDiagnostico.setUtamanopolipo(objDiagnosticoBean.getUtamanopolipo());
            objDiagnostico.setBprocesoerosivo(objDiagnosticoBean.isBprocesoerosivo());
            objDiagnostico.setBmei(objDiagnosticoBean.isBmei());
            objDiagnostico.setBmeipo(objDiagnosticoBean.isBmeipo());
            objDiagnostico.setBquistenaboth(objDiagnosticoBean.isBquistenaboth());
            objDiagnostico.setSquistenaboth(objDiagnosticoBean.getSquistenaboth());
            objDiagnostico.setBcolposano(objDiagnosticoBean.isBcolposano());
            objDiagnostico.setBcolpoleibg(objDiagnosticoBean.isBcolpoleibg());
            objDiagnostico.setBcolpoleiag(objDiagnosticoBean.isBcolpoleiag());
            objDiagnostico.setBcolpocancer(objDiagnosticoBean.isBcolpocancer());
            objDiagnostico.setBcolpobacteriana(objDiagnosticoBean.isBcolpobacteriana());
            objDiagnostico.setBcolpomicotica(objDiagnosticoBean.isBcolpomicotica());
            objDiagnostico.setBcolpoparasitaria(objDiagnosticoBean.isBcolpoparasitaria());
            objDiagnostico.setBcolpomiomaedocervical(objDiagnosticoBean.isBcolpomiomaedocervical());
            objDiagnostico.setBcolpocondilomatosis(objDiagnosticoBean.isBcolpocondilomatosis());
            objDiagnostico.setCmucosaatrofica(objDiagnosticoBean.getCmucosaatrofica());
            objDiagnostico.setCpolipovagino(objDiagnosticoBean.getCpolipovagino());
            objDiagnostico.setUpolipovaginotamano(objDiagnosticoBean.getUpolipovaginotamano());
            objDiagnostico.setCmucosaatroficavagino(objDiagnosticoBean.getCmucosaatroficavagino());
            objDiagnostico.setCvaginosisvagino(objDiagnosticoBean.getCvaginosisvagino());
            objDiagnostico.setBvaginoscoacuminado(objDiagnosticoBean.isBvaginoscoacuminado());
            objDiagnostico.setBvaginosconiva(objDiagnosticoBean.isBvaginosconiva());
            objDiagnostico.setBvaginoscogranuloma(objDiagnosticoBean.isBvaginoscogranuloma());
            objDiagnostico.setBpapaleibg(objDiagnosticoBean.isBpapaleibg());
            objDiagnostico.setBpapaleiag(objDiagnosticoBean.isBpapaleiag());
            objDiagnostico.setBpapacarciinsitu(objDiagnosticoBean.isBpapacarciinsitu());
            objDiagnostico.setBpapacarcimicroinvasor(objDiagnosticoBean.isBpapacarcimicroinvasor());
            objDiagnostico.setBpapacarcinomainvasor(objDiagnosticoBean.isBpapacarcinomainvasor());
            objDiagnostico.setBpapaadenoinsitu(objDiagnosticoBean.isBpapaadenoinsitu());
            objDiagnostico.setBpapaadenoinvasor(objDiagnosticoBean.isBpapaadenoinvasor());
            objDiagnostico.setBpapacarciepidermoide(objDiagnosticoBean.isBpapacarciepidermoide());
            objDiagnostico.setBpapaascus(objDiagnosticoBean.isBpapaascus());
            objDiagnostico.setBpapaasch(objDiagnosticoBean.isBpapaasch());
            objDiagnostico.setBpapacandida(objDiagnosticoBean.isBpapacandida());
            objDiagnostico.setBpapatrichomona(objDiagnosticoBean.isBpapatrichomona());
            objDiagnostico.setBpapaactinomyces(objDiagnosticoBean.isBpapaactinomyces());
            objDiagnostico.setBpapavaginosis(objDiagnosticoBean.isBpapavaginosis());
            objDiagnostico.setBcervixleibg(objDiagnosticoBean.isBcervixleibg());
            objDiagnostico.setBcervixleiag(objDiagnosticoBean.isBcervixleiag());
            objDiagnostico.setBcervixcarciinsitu(objDiagnosticoBean.isBcervixcarciinsitu());
            objDiagnostico.setBcervixcarcimicroinvasor(objDiagnosticoBean.isBcervixcarcimicroinvasor());
            objDiagnostico.setBcervixcarciinvasor(objDiagnosticoBean.isBcervixcarciinvasor());
            objDiagnostico.setBcervixadenoinsitu(objDiagnosticoBean.isBcervixadenoinsitu());
            objDiagnostico.setBcervixadenoinvasor(objDiagnosticoBean.isBcervixadenoinvasor());
            objDiagnostico.setBcervixcarciepidermoide(objDiagnosticoBean.isBcervixcarciepidermoide());
            objDiagnostico.setBcervixcondilom(objDiagnosticoBean.isBcervixcondilom());
            objDiagnostico.setBcervixpolipo(objDiagnosticoBean.isBcervixpolipo());
            objDiagnostico.setBcervixaguda(objDiagnosticoBean.isBcervixaguda());
            objDiagnostico.setBcervixcronica(objDiagnosticoBean.isBcervixcronica());
            objDiagnostico.setBconoleibgsin(objDiagnosticoBean.isBconoleibgsin());
            objDiagnostico.setBconoleiagsin(objDiagnosticoBean.isBconoleiagsin());
            objDiagnostico.setBconoleibgcon(objDiagnosticoBean.isBconoleibgcon());
            objDiagnostico.setBconoleiagcon(objDiagnosticoBean.isBconoleiagcon());
            objDiagnostico.setBconocarcinoma(objDiagnosticoBean.isBconocarcinoma());
            objDiagnostico.setBconoadenosin(objDiagnosticoBean.isBconoadenosin());
            objDiagnostico.setBconoadenocon(objDiagnosticoBean.isBconoadenocon());
            objDiagnostico.setBconoadenoinvasor(objDiagnosticoBean.isBconoadenoinvasor());
            objDiagnostico.setBconoaguda(objDiagnosticoBean.isBconoaguda());
            objDiagnostico.setBconocronica(objDiagnosticoBean.isBconocronica());
            objDiagnostico.setBblandoscondiloma(objDiagnosticoBean.isBblandoscondiloma());
            objDiagnostico.setBblandosniva(objDiagnosticoBean.isBblandosniva());
            objDiagnostico.setBblandosmoluco(objDiagnosticoBean.isBblandosmoluco());
            objDiagnostico.setBblandosberruga(objDiagnosticoBean.isBblandosberruga());
            objDiagnostico.setBblandosnevo(objDiagnosticoBean.isBblandosnevo());
            objDiagnostico.setBvaginacondiloma(objDiagnosticoBean.isBvaginacondiloma());
            objDiagnostico.setBvaginapolipo(objDiagnosticoBean.isBvaginapolipo());
            objDiagnostico.setBvaginaniva(objDiagnosticoBean.isBvaginaniva());
            objDiagnostico.setBvaginaproceso(objDiagnosticoBean.isBvaginaproceso());
            objDiagnostico.setCestado(objDiagnosticoBean.getCestado());
            objDiagnostico.setCusuario(objDiagnosticoBean.getCusuario());
            objDiagnostico.setDregistro(new Date());
        	if (objDiagnosticoBean.getKordendiagfundacion() == 0) {
        		iObjSesion.save(objDiagnostico);
        	} else {
        		objDiagnostico.setKordendiagfundacion(new Long(objDiagnosticoBean.getKordendiagfundacion()));
        		iObjSesion.update(objDiagnostico);            		
        	}
    		iObjSesion.flush();            	
            //HibernateUtil.commitTrans();	 
			iObjLog.debug("Saliendo DiagnosticoDao.setDiagnosticoActualizacion:Saliendo...  ");
			return objDiagnosticoBean;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR DiagnosticoDao.setDiagnosticoActualizacion: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}	
	
	public BOrdenDiagFundacionBean buscarDiagnostico(BOrdenDiagFundacionBean objDiagnosticoBean) throws Exception {
		iObjSesion = HibernateUtil.getSession();
		List objListaPacientes = new ArrayList();
		Query objQuery = null;
		String strQuery = "";
	    try{
			iObjLog.debug("Entrando DiagnosticoDao.buscarDiagnostico:Entrando...  ");
            HibernateUtil.beginTrans();
			strQuery = "select bPF " +					
					" from BPacienteFundacion bPF " +					
					" where bPF.snombre=bPF.snombre ";
			iObjLog.debug("Entrando DiagnosticoDao.buscarDiagnostico:Consulta...  " + strQuery);
			objQuery = iObjSesion.createQuery(strQuery);
			objListaPacientes = objQuery.list();
			iObjLog.debug("Entrando DiagnosticoDao.buscarDiagnostico:Resultado...  " + objListaPacientes.size());
			if (objListaPacientes != null) {
			}
			//HibernateUtil.commitTrans();	 				
			iObjLog.debug("Saliendo DiagnosticoDao.buscarDiagnostico:Saliendo...  ");
			return objDiagnosticoBean;
		} catch (Exception aObjExcepcion) { 
			iObjLog.error("ERROR DiagnosticoDao.buscarDiagnostico:: ", aObjExcepcion);
			throw aObjExcepcion;
        } finally{
        	HibernateUtil.closeSession();
		}		
	}		
}
