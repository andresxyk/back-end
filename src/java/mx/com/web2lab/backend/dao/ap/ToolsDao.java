package mx.com.web2lab.backend.dao.ap;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import mx.com.web2lab.backend.hbm.HibernateUtil;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ToolsDao {

	private static Log iObjLog = LogFactory.getLog(ToolsDao.class);
	private Session iObjSesion = null;
	    	
	public ToolsDao(){
		iObjSesion = HibernateUtil.getSession();		
	}
		
    public Integer getSequenceNextId(String strSequence,Connection objCon)
    throws Exception{
    	iObjLog.debug("Ejecutando ToolsDao.getSequenceNextId...");
        Integer objRet = null;
        Statement objSta = null;
        ResultSet objRs = null;
    	try{
	        objSta = objCon.createStatement();
	        objRs = objSta.executeQuery("select " + strSequence + ".nextVal sig from dual");
        	iObjLog.debug("select " + strSequence + ".nextVal sig from dual");
	        while(objRs.next()){
	        	iObjLog.debug("_____>>>>> Id encontrado " + objRs.toString());
	        	objRet = new Integer(objRs.getString("sig"));
	        	iObjLog.debug("_____>>>>> Id encontrado " + objRet);
	        }
    	} catch (Exception aError){
        	iObjLog.error("ERROR EN QUERY: ToolsDao.getSequenceNextId" + aError.toString());
        	throw aError;
        } finally {
            if(objRs != null)objRs.close();
            if(objSta !=  null)objSta.close();
        }
    	return objRet;
    }	
    
    public String guardarGasto(double dblGasto,String strDescripcion,int cUsuario)
    throws Exception{
    	iObjLog.debug("Ejecutando ToolsDao.guardarGasto... ");
    	String strReturn = "";
		iObjSesion = HibernateUtil.getSession();
    	Connection objCon = iObjSesion.connection();
        Statement objSta = null;
    	try{    		
	        objSta = objCon.createStatement();
	        objSta.execute("INSERT INTO BGASTOFUNDACION VALUES (BGASTOFUNDACION_SEQUENCE.NEXTVAL,SYSDATE," + dblGasto + ",'" + strDescripcion + "',0,1,1," + cUsuario + ")");
	        strReturn = "Exito en el registro del Gasto";
    	} catch (Exception aError){
        	iObjLog.error("ERROR EN QUERY: ToolsDao.guardarGasto" + aError.toString());
        	throw aError;
        } finally {
        	HibernateUtil.closeSession();
        }
    	return strReturn;
    }	

    public String actualizarGasto(int kCorteCaja,Session iObjSesion)
    throws Exception{
    	iObjLog.debug("Ejecutando ToolsDao.actualizarGasto... ");
    	String strReturn = "";
    	Connection objCon = iObjSesion.connection();    	
        Statement objSta = null;
    	try{    		
	        objSta = objCon.createStatement();
	        objSta.execute("UPDATE BGASTOFUNDACION SET KCORTECAJAFUNDACION = " + kCorteCaja + " WHERE KCORTECAJAFUNDACION=0");
	        strReturn = "Exito en la actualizacion de los Pagos";
    	} catch (Exception aError){
        	iObjLog.error("ERROR EN QUERY: ToolsDao.actualizarGasto" + aError.toString());
        	throw aError;
        } finally {
            if(objSta !=  null)objSta.close();
            if(objCon != null)objCon.close();
        }
    	return strReturn;
    }	    
}
