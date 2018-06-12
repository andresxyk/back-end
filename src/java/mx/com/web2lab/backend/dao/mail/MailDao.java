package mx.com.web2lab.backend.dao.mail;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;


import mx.com.web2lab.backend.hbm.ConfiguracionProperties;
import mx.com.web2lab.backend.hbm.om.ap.CConvenio;
import mx.com.web2lab.backend.hbm.om.ap.TPaciente;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MailDao {

	private static Log iObjLog = LogFactory.getLog(MailDao.class);	

	public int sendEmailMarketing(String strSubject,String strAddressTO,String sBodyEmail,String strPathFile) throws MessagingException,Exception {
		Message objMessage = new MimeMessage(getSession(3));
		Multipart mpBodyEmail = new MimeMultipart();
		MimeBodyPart mbpFile = new MimeBodyPart();
		BodyPart objPlantillaHTML = new MimeBodyPart();
		try {
			/*** Configuracion del Correo para envio e-mail ***/
			iObjLog.debug("Entrando a MailDao.sendEmailMarketing:...  " + strAddressTO);
			objMessage.addRecipient(RecipientType.TO, new InternetAddress(strAddressTO));
			String streMailCopy = ConfiguracionProperties.getPropiedad("mail.send.copyemailmarketing"); 
			if (streMailCopy.length() > 12){
				objMessage.addRecipient(RecipientType.TO, new InternetAddress(streMailCopy));
			}
			objMessage.addFrom(new InternetAddress[] { new InternetAddress(ConfiguracionProperties.getPropiedad("mail.send.fromemailmarketing")) });		
			objMessage.setSubject(strSubject);
			/*** Carta de presentacion en HTML ***/
			objPlantillaHTML.setContent(sBodyEmail,"text/html");
			/*** Attachment File ***/
			iObjLog.debug("Entrando a FacturarElectronicaSucursalAjax.sendEmail:...  " + strPathFile);
			if (strPathFile != "") {
				FileDataSource fdsFile = new FileDataSource(strPathFile);
				mbpFile.setDataHandler(new DataHandler(fdsFile));
				mbpFile.setFileName(fdsFile.getName());
				mpBodyEmail.addBodyPart(mbpFile);
			}
			/*** Create Body e-mail ***/
			mpBodyEmail.addBodyPart(objPlantillaHTML);
			objMessage.setContent(mpBodyEmail);
			/*** Send e-mail ***/
			objMessage.setSentDate(new Date());
			Transport.send(objMessage);
			return 0;
		} catch (MessagingException aObjMessagingException) {
			iObjLog.error("ERROR MailDao.sendEmailMarketing: ", aObjMessagingException);
			return -1;
//			throw aObjMessagingException;
		} catch (Exception aObjExcepcion) {
			iObjLog.error("ERROR MailDao.sendEmailMarketing: ", aObjExcepcion);
			return -1;
//			throw aObjExcepcion;
		}
	}
	
	public void sendEmail(String strSubject,String strAddressTO, String strPathPDF, String strPathXML, String strRFC, String strCorreoCopy,int cMarca) throws MessagingException,Exception {
		Message objMessage = new MimeMessage(getSession(1));
		Multipart mpBodyEmail = new MimeMultipart();
		MimeBodyPart mbpPDF = new MimeBodyPart();
		MimeBodyPart mbpXML = new MimeBodyPart();
		BodyPart objPlantillaHTML = new MimeBodyPart();
		try {
			/*** Configuracion del Correo para envio e-mail ***/
			iObjLog.debug("Entrando a FacturarElectronicaSucursalAjax.sendEmail:...  " + strAddressTO);
			objMessage.addRecipient(RecipientType.TO, new InternetAddress(strAddressTO));
//			String streMailCopy = ConfiguracionProperties.getPropiedad("mail.send.copyemailmarketing"); 
//			if (streMailCopy.length() > 12) {			
//				objMessage.addRecipient(RecipientType.TO, new InternetAddress(ConfiguracionProperties.getPropiedad("mail.send.copyemail")));
//				objMessage.addRecipient(RecipientType.TO, new InternetAddress("guadalupe.garcia@olab.com.mx"));
//				objMessage.addRecipient(RecipientType.TO, new InternetAddress("enrique.nery@olab.com.mx"));
//			}
			if (strCorreoCopy.length() > 5) {
				objMessage.addRecipient(RecipientType.BCC, new InternetAddress(strCorreoCopy));
				objMessage.addRecipient(RecipientType.BCC, new InternetAddress("infodiamex@olab.com.mx"));
				objMessage.addRecipient(RecipientType.BCC, new InternetAddress("guadalupe.garcia@olab.com.mx"));
//				objMessage.addRecipient(RecipientType.BCC, new InternetAddress("enrique.neri@olab.com.mx"));
			}
			objMessage.setFrom(new InternetAddress(ConfiguracionProperties.getPropiedad("mail.send.fromemail")));
			objMessage.setReplyTo(new javax.mail.Address[]
					{
					    new javax.mail.internet.InternetAddress(ConfiguracionProperties.getPropiedad("mail.send.fromemail"))
					});			
			objMessage.setSubject(strSubject);
			/*** Carta de presentacion en HTML ***/
			objPlantillaHTML.setContent(this.getFormatoFE(strRFC,cMarca),"text/html");
			/*** Attachment PDF ***/
			iObjLog.debug("Entrando a FacturarElectronicaSucursalAjax.sendEmail:...  " + strPathPDF);
			FileDataSource fdsPDF = new FileDataSource(strPathPDF);
			mbpPDF.setDataHandler(new DataHandler(fdsPDF));
			mbpPDF.setFileName(fdsPDF.getName());
			/*** Attachment XML ***/
			FileDataSource fdsXML = new FileDataSource(strPathXML);
			mbpXML.setDataHandler(new DataHandler(fdsXML));
			mbpXML.setFileName(fdsXML.getName());
			/*** Create Body e-mail ***/
			mpBodyEmail.addBodyPart(objPlantillaHTML);
			mpBodyEmail.addBodyPart(mbpPDF);
			mpBodyEmail.addBodyPart(mbpXML);
			objMessage.setContent(mpBodyEmail);
			/*** Send e-mail ***/
			objMessage.setSentDate(new Date());
			Transport.send(objMessage);
		} catch (MessagingException aObjMessagingException) {
			iObjLog.error("ERROR MailDao.sendEmail: ", aObjMessagingException);
			throw aObjMessagingException;
		} catch (Exception aObjExcepcion) {
			iObjLog.error("ERROR MailDao.sendEmail: ", aObjExcepcion);
			throw aObjExcepcion;
		}
	}
		
	public void sendEmailECEPaciente(String strSubject, TPaciente objPaciente) throws MessagingException,Exception {
		Message objMessage = new MimeMessage(getSession(2));
		Multipart mpBodyEmail = new MimeMultipart();
		BodyPart objPlantillaHTML = new MimeBodyPart();
		try {
			/*** Configuracion del Correo para envio e-mail ***/
			iObjLog.debug("Entrando a MailDao.sendEmailECEPaciente:...  " + objPaciente.getScorreoelectronico());
			objMessage.addRecipient(RecipientType.TO, new InternetAddress(objPaciente.getScorreoelectronico()));
			String streMailCopy = ConfiguracionProperties.getPropiedad("mail.send.copyfromemailece"); 
			if (streMailCopy.length() > 12){
				objMessage.addRecipient(RecipientType.BCC, new InternetAddress(streMailCopy));
			}
			objMessage.addFrom(new InternetAddress[] { new InternetAddress(ConfiguracionProperties.getPropiedad("mail.send.fromemailece")) });		
			objMessage.setSubject(strSubject);
			/*** Carta de presentacion en HTML ***/
			objPlantillaHTML.setContent(this.getFormatoECEPacienteGDA(objPaciente),"text/html");
			/*** Attachment PDF ***/
			iObjLog.debug("Entrando a MailDao.sendEmailECEPaciente:...  ECE " + this.getFormatoECEPacienteGDA(objPaciente));
			/*** Create Body e-mail ***/
			mpBodyEmail.addBodyPart(objPlantillaHTML);
			objMessage.setContent(mpBodyEmail);
			/*** Send e-mail ***/
			objMessage.setSentDate(new Date());
			Transport.send(objMessage);
		} catch (MessagingException aObjMessagingException) {
			iObjLog.error("ERROR MailDao.sendEmailECEPaciente: ", aObjMessagingException);
			throw aObjMessagingException;
		} catch (Exception aObjExcepcion) {
			iObjLog.error("ERROR MailDao.sendEmailECEPaciente: ", aObjExcepcion);
			throw aObjExcepcion;
		}
	}
	
	public void sendEmailECEEmpresaGDA2016(String strSubject, CConvenio objConvenio) throws MessagingException,Exception {
		Message objMessage = new MimeMessage(getSession(2));
		Multipart mpBodyEmail = new MimeMultipart();
		BodyPart objPlantillaHTML = new MimeBodyPart();
		try {
			/*** Configuracion del Correo para envio e-mail ***/
			iObjLog.debug("Entrando a MailDao.sendEmailECEEmpresa:...  " + objConvenio.getScorreoelectronico());
			objMessage.addRecipient(RecipientType.TO, new InternetAddress(objConvenio.getScorreoelectronico()));
			String streMailCopy = ConfiguracionProperties.getPropiedad("mail.send.copyfromemailece"); 
			if (streMailCopy.length() > 12){
				objMessage.addRecipient(RecipientType.BCC, new InternetAddress(streMailCopy));
			}
			objMessage.addFrom(new InternetAddress[] { new InternetAddress(ConfiguracionProperties.getPropiedad("mail.send.fromemailece")) });		
			objMessage.setSubject(strSubject);
			/*** Carta de presentacion en HTML ***/
			objPlantillaHTML.setContent(this.getFormatoECEEmpresaGDA2016(objConvenio),"text/html");
			/*** Attachment PDF ***/
			iObjLog.debug("Entrando a MailDao.sendEmailECEEmpresa:...  ECE " + this.getFormatoECEEmpresaGDA2016(objConvenio));
			/*** Create Body e-mail ***/
			mpBodyEmail.addBodyPart(objPlantillaHTML);
			objMessage.setContent(mpBodyEmail);
			/*** Send e-mail ***/
			objMessage.setSentDate(new Date());
			Transport.send(objMessage);
		} catch (MessagingException aObjMessagingException) {
			iObjLog.error("ERROR MailDao.sendEmailECEEmpresa: ", aObjMessagingException);
			throw aObjMessagingException;
		} catch (Exception aObjExcepcion) {
			iObjLog.error("ERROR MailDao.sendEmailECEEmpresa: ", aObjExcepcion);
			throw aObjExcepcion;
		}
	}
	
	private Session getSession(int intType) throws Exception {
		Authenticator authenticator = new Authenticator(intType);
		Properties properties = new Properties();
		try {
			properties.setProperty("mail.smtp.submitter", authenticator.getPasswordAuthentication().getUserName());
			properties.setProperty("mail.smtp.auth", "true");
			properties.setProperty("mail.smtp.host", ConfiguracionProperties.getPropiedad("mail.send.smtphost"));
			properties.setProperty("mail.smtp.port", ConfiguracionProperties.getPropiedad("mail.send.smtpport"));
			return Session.getInstance(properties, authenticator);
		} catch (Exception aObjExcepcion) {
			iObjLog.error("ERROR MailDao.getSession: ", aObjExcepcion);
			throw aObjExcepcion;
		}
	}
 	
	private class Authenticator extends javax.mail.Authenticator {
		private PasswordAuthentication authentication;
		public Authenticator(int intType) {
			String username = "";
			String password = "";			
			if (intType == 1) {
				username = ConfiguracionProperties.getPropiedad("mail.send.fromemailUser");
				password = ConfiguracionProperties.getPropiedad("mail.send.frompassword");
			} else if (intType == 2) {
				username = ConfiguracionProperties.getPropiedad("mail.send.fromemailece");
				password = ConfiguracionProperties.getPropiedad("mail.send.frompasswordece");
			} else {
				username = ConfiguracionProperties.getPropiedad("mail.send.fromemailmarketing");
				password = ConfiguracionProperties.getPropiedad("mail.send.frompasswordmarketing");
			}
			authentication = new PasswordAuthentication(username, password);
		}

		protected PasswordAuthentication getPasswordAuthentication() {
			return authentication;
		}
	}		
	
//	private String getFormatoFE() {
//		return "<html xmlns:v='urn:schemas-microsoft-com:vml'" +
//        "     xmlns:o='urn:schemas-microsoft-com:office:office'" +
//        "     xmlns:w='urn:schemas-microsoft-com:office:word'" +
//        "     xmlns:m='http:////schemas.microsoft.com//office//2004//12//omml'" +
//        "     xmlns='http:////www.w3.org//TR//REC-html40'>" +
//        "     <head>" +
//        "     <meta http-equiv=Content-Type content='text/html; charset=windows-1252'>" +
//        "     <meta name=ProgId content=Word.Document>" +
//        "     <meta name=Generator content='Microsoft Word 12'>" +
//        "     <meta name=Originator content='Microsoft Word 12'>" +
//        "     <link rel=File-List href='http://173.203.12.186:9085/Imagenes/filelist.xml'>" +
//        "     <link rel=Edit-Time-Data href='http://173.203.12.186:9085/Imagenes/editdata.mso'>" +
//        "     <!--[if !mso]>" +
//        "     <style>" +
//        "     v/:* {behavior:url(#default#VML);}" +
//        "     o/:* {behavior:url(#default#VML);}" +
//        "     w/:* {behavior:url(#default#VML);}" +
//        "     .shape {behavior:url(#default#VML);}" +
//        "     </style>" +
//        "     <![endif]--><!--[if gte mso 9]><xml>" +
//        "     <o:DocumentProperties>" +
//        "       <o:Author>orubio</o:Author>" +
//        "       <o:Template>Normal</o:Template>" +
//        "       <o:LastAuthor>orubio</o:LastAuthor>" +
//        "       <o:Revision>1</o:Revision>" +
//        "       <o:TotalTime>2</o:TotalTime>" +
//        "       <o:Created>2011-03-18T22:04:00Z</o:Created>" +
//        "       <o:LastSaved>2011-03-18T22:06:00Z</o:LastSaved>" +
//        "       <o:Pages>1</o:Pages>" +
//        "       <o:Words>73</o:Words>" +
//        "       <o:Characters>407</o:Characters>" +
//        "       <o:Company>Toshiba</o:Company>" +
//        "       <o:Lines>3</o:Lines>" +
//        "       <o:Paragraphs>1</o:Paragraphs>" +
//        "       <o:CharactersWithSpaces>479</o:CharactersWithSpaces>" +
//        "       <o:Version>12.00</o:Version>" +
//        "     </o:DocumentProperties>" +
//        "     </xml><![endif]-->" +
//        "     <link rel=themeData href='http://173.203.12.186:9085/Imagenes/themedata.thmx'>" +
//        "     <link rel=colorSchemeMapping href='http://173.203.12.186:9085/Imagenes/colorschememapping.xml'>" +
//        "     <!--[if gte mso 9]><xml>" +
//        "     <w:WordDocument>" +
//        "       <w:SpellingState>Clean</w:SpellingState>" +
//        "       <w:GrammarState>Clean</w:GrammarState>" +
//        "       <w:TrackMoves>false</w:TrackMoves>" +
//        "       <w:TrackFormatting/>" +
//        "       <w:HyphenationZone>21</w:HyphenationZone>" +
//        "       <w:PunctuationKerning/>" +
//        "       <w:ValidateAgainstSchemas/>" +
//        "       <w:SaveIfXMLInvalid>false</w:SaveIfXMLInvalid>" +
//        "       <w:IgnoreMixedContent>false</w:IgnoreMixedContent>" +
//        "       <w:AlwaysShowPlaceholderText>false</w:AlwaysShowPlaceholderText>" +
//        "       <w:DoNotPromoteQF/>" +
//        "       <w:LidThemeOther>ES-MX</w:LidThemeOther>" +
//        "       <w:LidThemeAsian>X-NONE</w:LidThemeAsian>" +
//        "       <w:LidThemeComplexScript>X-NONE</w:LidThemeComplexScript>" +
//        "       <w:Compatibility>" +
//        "        <w:BreakWrappedTables/>" +
//        "        <w:SnapToGridInCell/>" +
//        "        <w:WrapTextWithPunct/>" +
//        "        <w:UseAsianBreakRules/>" +
//        "        <w:DontGrowAutofit/>" +
//        "        <w:SplitPgBreakAndParaMark/>" +
//        "        <w:DontVertAlignCellWithSp/>" +
//        "        <w:DontBreakConstrainedForcedTables/>" +
//        "        <w:DontVertAlignInTxbx/>" +
//        "        <w:Word11KerningPairs/>" +
//        "        <w:CachedColBalance/>" +
//        "       </w:Compatibility>" +
//        "       <w:BrowserLevel>MicrosoftInternetExplorer4</w:BrowserLevel>" +
//        "       <m:mathPr>" +
//        "        <m:mathFont m:val='Cambria Math'/>" +
//        "        <m:brkBin m:val='before'/>" +
//        "        <m:brkBinSub m:val='&#45;-'/>" +
//        "        <m:smallFrac m:val='off'/>" +
//        "        <m:dispDef/>" +
//        "        <m:lMargin m:val='0'/>" +
//        "        <m:rMargin m:val='0'/>" +
//        "        <m:defJc m:val='centerGroup'/>" +
//        "        <m:wrapIndent m:val='1440'/>" +
//        "        <m:intLim m:val='subSup'/>" +
//        "        <m:naryLim m:val='undOvr'/>" +
//        "       </m:mathPr></w:WordDocument>" +
//        "     </xml><![endif]--><!--[if gte mso 9]><xml>" +
//        "     <w:LatentStyles DefLockedState='false' DefUnhideWhenUsed='true'" +
//        "       DefSemiHidden='true' DefQFormat='false' DefPriority='99'" +
//        "       LatentStyleCount='267'>" +
//        "       <w:LsdException Locked='false' Priority='0' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' QFormat='true' Name='Normal'/>" +
//        "       <w:LsdException Locked='false' Priority='9' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' QFormat='true' Name='heading 1'/>" +
//        "       <w:LsdException Locked='false' Priority='9' QFormat='true' Name='heading 2'/>" +
//        "       <w:LsdException Locked='false' Priority='9' QFormat='true' Name='heading 3'/>" +
//        "       <w:LsdException Locked='false' Priority='9' QFormat='true' Name='heading 4'/>" +
//        "       <w:LsdException Locked='false' Priority='9' QFormat='true' Name='heading 5'/>" +
//        "       <w:LsdException Locked='false' Priority='9' QFormat='true' Name='heading 6'/>" +
//        "       <w:LsdException Locked='false' Priority='9' QFormat='true' Name='heading 7'/>" +
//        "       <w:LsdException Locked='false' Priority='9' QFormat='true' Name='heading 8'/>" +
//        "       <w:LsdException Locked='false' Priority='9' QFormat='true' Name='heading 9'/>" +
//        "       <w:LsdException Locked='false' Priority='39' Name='toc 1'/>" +
//        "       <w:LsdException Locked='false' Priority='39' Name='toc 2'/>" +
//        "       <w:LsdException Locked='false' Priority='39' Name='toc 3'/>" +
//        "       <w:LsdException Locked='false' Priority='39' Name='toc 4'/>" +
//        "       <w:LsdException Locked='false' Priority='39' Name='toc 5'/>" +
//        "       <w:LsdException Locked='false' Priority='39' Name='toc 6'/>" +
//        "       <w:LsdException Locked='false' Priority='39' Name='toc 7'/>" +
//        "       <w:LsdException Locked='false' Priority='39' Name='toc 8'/>" +
//        "       <w:LsdException Locked='false' Priority='39' Name='toc 9'/>" +
//        "       <w:LsdException Locked='false' Priority='35' QFormat='true' Name='caption'/>" +
//        "       <w:LsdException Locked='false' Priority='10' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' QFormat='true' Name='Title'/>" +
//        "       <w:LsdException Locked='false' Priority='1' Name='Default Paragraph Font'/>" +
//        "       <w:LsdException Locked='false' Priority='11' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' QFormat='true' Name='Subtitle'/>" +
//        "       <w:LsdException Locked='false' Priority='22' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' QFormat='true' Name='Strong'/>" +
//        "       <w:LsdException Locked='false' Priority='20' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' QFormat='true' Name='Emphasis'/>" +
//        "       <w:LsdException Locked='false' Priority='59' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Table Grid'/>" +
//        "       <w:LsdException Locked='false' UnhideWhenUsed='false' Name='Placeholder Text'/>" +
//        "       <w:LsdException Locked='false' Priority='1' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' QFormat='true' Name='No Spacing'/>" +
//        "       <w:LsdException Locked='false' Priority='60' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Light Shading'/>" +
//        "       <w:LsdException Locked='false' Priority='61' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Light List'/>" +
//        "       <w:LsdException Locked='false' Priority='62' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Light Grid'/>" +
//        "       <w:LsdException Locked='false' Priority='63' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium Shading 1'/>" +
//        "       <w:LsdException Locked='false' Priority='64' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium Shading 2'/>" +
//        "       <w:LsdException Locked='false' Priority='65' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium List 1'/>" +
//        "       <w:LsdException Locked='false' Priority='66' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium List 2'/>" +
//        "       <w:LsdException Locked='false' Priority='67' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium Grid 1'/>" +
//        "       <w:LsdException Locked='false' Priority='68' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium Grid 2'/>" +
//        "       <w:LsdException Locked='false' Priority='69' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium Grid 3'/>" +
//        "       <w:LsdException Locked='false' Priority='70' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Dark List'/>" +
//        "       <w:LsdException Locked='false' Priority='71' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Colorful Shading'/>" +
//        "       <w:LsdException Locked='false' Priority='72' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Colorful List'/>" +
//        "       <w:LsdException Locked='false' Priority='73' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Colorful Grid'/>" +
//        "       <w:LsdException Locked='false' Priority='60' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Light Shading Accent 1'/>" +
//        "       <w:LsdException Locked='false' Priority='61' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Light List Accent 1'/>" +
//        "       <w:LsdException Locked='false' Priority='62' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Light Grid Accent 1'/>" +
//        "       <w:LsdException Locked='false' Priority='63' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium Shading 1 Accent 1'/>" +
//        "       <w:LsdException Locked='false' Priority='64' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium Shading 2 Accent 1'/>" +
//        "       <w:LsdException Locked='false' Priority='65' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium List 1 Accent 1'/>" +
//        "       <w:LsdException Locked='false' UnhideWhenUsed='false' Name='Revision'/>" +
//        "       <w:LsdException Locked='false' Priority='34' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' QFormat='true' Name='List Paragraph'/>" +
//        "       <w:LsdException Locked='false' Priority='29' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' QFormat='true' Name='Quote'/>" +
//        "       <w:LsdException Locked='false' Priority='30' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' QFormat='true' Name='Intense Quote'/>" +
//        "       <w:LsdException Locked='false' Priority='66' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium List 2 Accent 1'/>" +
//        "       <w:LsdException Locked='false' Priority='67' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium Grid 1 Accent 1'/>" +
//        "       <w:LsdException Locked='false' Priority='68' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium Grid 2 Accent 1'/>" +
//        "       <w:LsdException Locked='false' Priority='69' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium Grid 3 Accent 1'/>" +
//        "       <w:LsdException Locked='false' Priority='70' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Dark List Accent 1'/>" +
//        "       <w:LsdException Locked='false' Priority='71' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Colorful Shading Accent 1'/>" +
//        "       <w:LsdException Locked='false' Priority='72' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Colorful List Accent 1'/>" +
//        "       <w:LsdException Locked='false' Priority='73' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Colorful Grid Accent 1'/>" +
//        "       <w:LsdException Locked='false' Priority='60' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Light Shading Accent 2'/>" +
//        "       <w:LsdException Locked='false' Priority='61' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Light List Accent 2'/>" +
//        "       <w:LsdException Locked='false' Priority='62' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Light Grid Accent 2'/>" +
//        "       <w:LsdException Locked='false' Priority='63' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium Shading 1 Accent 2'/>" +
//        "       <w:LsdException Locked='false' Priority='64' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium Shading 2 Accent 2'/>" +
//        "       <w:LsdException Locked='false' Priority='65' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium List 1 Accent 2'/>" +
//        "       <w:LsdException Locked='false' Priority='66' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium List 2 Accent 2'/>" +
//        "       <w:LsdException Locked='false' Priority='67' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium Grid 1 Accent 2'/>" +
//        "       <w:LsdException Locked='false' Priority='68' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium Grid 2 Accent 2'/>" +
//        "       <w:LsdException Locked='false' Priority='69' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium Grid 3 Accent 2'/>" +
//        "       <w:LsdException Locked='false' Priority='70' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Dark List Accent 2'/>" +
//        "       <w:LsdException Locked='false' Priority='71' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Colorful Shading Accent 2'/>" +
//        "       <w:LsdException Locked='false' Priority='72' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Colorful List Accent 2'/>" +
//        "       <w:LsdException Locked='false' Priority='73' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Colorful Grid Accent 2'/>" +
//        "       <w:LsdException Locked='false' Priority='60' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Light Shading Accent 3'/>" +
//        "       <w:LsdException Locked='false' Priority='61' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Light List Accent 3'/>" +
//        "        <w:LsdException Locked='false' Priority='62' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Light Grid Accent 3'/>" +
//        "       <w:LsdException Locked='false' Priority='63' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium Shading 1 Accent 3'/>" +
//        "       <w:LsdException Locked='false' Priority='64' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium Shading 2 Accent 3'/>" +
//        "       <w:LsdException Locked='false' Priority='65' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium List 1 Accent 3'/>" +
//        "       <w:LsdException Locked='false' Priority='66' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium List 2 Accent 3'/>" +
//        "       <w:LsdException Locked='false' Priority='67' SemiHidden='false'" +
//        "       UnhideWhenUsed='false' Name='Medium Grid 1 Accent 3'/>" +
//        "       <w:LsdException Locked='false' Priority='68' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium Grid 2 Accent 3'/>" +
//        "       <w:LsdException Locked='false' Priority='69' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium Grid 3 Accent 3'/>" +
//        "       <w:LsdException Locked='false' Priority='70' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Dark List Accent 3'/>" +
//        "       <w:LsdException Locked='false' Priority='71' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Colorful Shading Accent 3'/>" +
//        "       <w:LsdException Locked='false' Priority='72' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Colorful List Accent 3'/>" +
//        "       <w:LsdException Locked='false' Priority='73' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Colorful Grid Accent 3'/>" +
//        "       <w:LsdException Locked='false' Priority='60' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Light Shading Accent 4'/>" +
//        "       <w:LsdException Locked='false' Priority='61' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Light List Accent 4'/>" +
//        "       <w:LsdException Locked='false' Priority='62' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Light Grid Accent 4'/>" +
//        "       <w:LsdException Locked='false' Priority='63' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium Shading 1 Accent 4'/>" +
//        "       <w:LsdException Locked='false' Priority='64' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium Shading 2 Accent 4'/>" +
//        "       <w:LsdException Locked='false' Priority='65' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium List 1 Accent 4'/>" +
//        "       <w:LsdException Locked='false' Priority='66' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium List 2 Accent 4'/>" +
//        "       <w:LsdException Locked='false' Priority='67' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium Grid 1 Accent 4'/>" +
//        "       <w:LsdException Locked='false' Priority='68' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium Grid 2 Accent 4'/>" +
//        "       <w:LsdException Locked='false' Priority='69' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium Grid 3 Accent 4'/>" +
//        "       <w:LsdException Locked='false' Priority='70' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Dark List Accent 4'/>" +
//        "       <w:LsdException Locked='false' Priority='71' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Colorful Shading Accent 4'/>" +
//        "       <w:LsdException Locked='false' Priority='72' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Colorful List Accent 4'/>" +
//        "       <w:LsdException Locked='false' Priority='73' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Colorful Grid Accent 4'/>" +
//        "       <w:LsdException Locked='false' Priority='60' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Light Shading Accent 5'/>" +
//        "       <w:LsdException Locked='false' Priority='61' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Light List Accent 5'/>" +
//        "       <w:LsdException Locked='false' Priority='62' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Light Grid Accent 5'/>" +
//        "       <w:LsdException Locked='false' Priority='63' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium Shading 1 Accent 5'/>" +
//        "       <w:LsdException Locked='false' Priority='64' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium Shading 2 Accent 5'/>" +
//        "       <w:LsdException Locked='false' Priority='65' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium List 1 Accent 5'/>" +
//        "       <w:LsdException Locked='false' Priority='66' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium List 2 Accent 5'/>" +
//        "       <w:LsdException Locked='false' Priority='67' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium Grid 1 Accent 5'/>" +
//        "       <w:LsdException Locked='false' Priority='68' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium Grid 2 Accent 5'/>" +
//        "       <w:LsdException Locked='false' Priority='69' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium Grid 3 Accent 5'/>" +
//        "       <w:LsdException Locked='false' Priority='70' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Dark List Accent 5'/>" +
//        "       <w:LsdException Locked='false' Priority='71' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Colorful Shading Accent 5'/>" +
//        "       <w:LsdException Locked='false' Priority='72' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Colorful List Accent 5'/>" +
//        "       <w:LsdException Locked='false' Priority='73' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Colorful Grid Accent 5'/>" +
//        "       <w:LsdException Locked='false' Priority='60' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Light Shading Accent 6'/>" +
//        "       <w:LsdException Locked='false' Priority='61' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Light List Accent 6'/>" +
//        "       <w:LsdException Locked='false' Priority='62' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Light Grid Accent 6'/>" +
//        "       <w:LsdException Locked='false' Priority='63' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium Shading 1 Accent 6'/>" +
//        "       <w:LsdException Locked='false' Priority='64' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium Shading 2 Accent 6'/>" +
//        "       <w:LsdException Locked='false' Priority='65' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium List 1 Accent 6'/>" +
//        "       <w:LsdException Locked='false' Priority='66' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium List 2 Accent 6'/>" +
//        "       <w:LsdException Locked='false' Priority='67' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium Grid 1 Accent 6'/>" +
//        "       <w:LsdException Locked='false' Priority='68' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium Grid 2 Accent 6'/>" +
//        "       <w:LsdException Locked='false' Priority='69' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Medium Grid 3 Accent 6'/>" +
//        "       <w:LsdException Locked='false' Priority='70' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Dark List Accent 6'/>" +
//        "       <w:LsdException Locked='false' Priority='71' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Colorful Shading Accent 6'/>" +
//        "       <w:LsdException Locked='false' Priority='72' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Colorful List Accent 6'/>" +
//        "       <w:LsdException Locked='false' Priority='73' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' Name='Colorful Grid Accent 6'/>" +
//        "       <w:LsdException Locked='false' Priority='19' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' QFormat='true' Name='Subtle Emphasis'/>" +
//        "       <w:LsdException Locked='false' Priority='21' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' QFormat='true' Name='Intense Emphasis'/>" +
//        "       <w:LsdException Locked='false' Priority='31' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' QFormat='true' Name='Subtle Reference'/>" +
//        "       <w:LsdException Locked='false' Priority='32' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' QFormat='true' Name='Intense Reference'/>" +
//        "       <w:LsdException Locked='false' Priority='33' SemiHidden='false'" +
//        "        UnhideWhenUsed='false' QFormat='true' Name='Book Title'/>" +
//        "       <w:LsdException Locked='false' Priority='37' Name='Bibliography'/>" +
//        "       <w:LsdException Locked='false' Priority='39' QFormat='true' Name='TOC Heading'/>" +
//        "     </w:LatentStyles>" +
//        "     </xml><![endif]-->" +
//        "     <style>" +
//        "     <!--" +
//        "     /* Font Definitions */" +
//        "     @font-face" +
//        "           {font-family:'Cambria Math';" +
//        "           panose-1:2 4 5 3 5 4 6 3 2 4;" +
//        "           mso-font-charset:1;" +
//        "           mso-generic-font-family:roman;" +
//        "           mso-font-format:other;" +
//        "           mso-font-pitch:variable;" +
//        "           mso-font-signature:0 0 0 0 0 0;}" +
//        "     @font-face" +
//        "           {font-family:Calibri;" +
//        "           panose-1:2 15 5 2 2 2 4 3 2 4;" +
//        "           mso-font-charset:0;" +
//        "           mso-generic-font-family:swiss;" +
//        "           mso-font-pitch:variable;" +
//        "           mso-font-signature:-520092929 1073786111 9 0 415 0;}" +
//        "     @font-face" +
//        "           {font-family:Tahoma;" +
//        "           panose-1:2 11 6 4 3 5 4 4 2 4;" +
//        "           mso-font-charset:0;" +
//        "           mso-generic-font-family:swiss;" +
//        "           mso-font-pitch:variable;" +
//        "           mso-font-signature:-520081665 -1073717157 41 0 66047 0;}" +
//        "     @font-face" +
//        "           {font-family:'Trebuchet MS';" +
//        "           panose-1:2 11 6 3 2 2 2 2 2 4;" +
//        "           mso-font-charset:0;" +
//        "           mso-generic-font-family:swiss;" +
//        "           mso-font-pitch:variable;" +
//        "           mso-font-signature:647 0 0 0 159 0;}" +
//        "     /* Style Definitions */" +
//        "     p.MsoNormal, li.MsoNormal, div.MsoNormal" +
//        "           {mso-style-unhide:no;" +
//        "           mso-style-qformat:yes;" +
//        "           mso-style-parent:'';" +
//        "           margin:0cm;" +
//        "           margin-bottom:.0001pt;" +
//        "           mso-pagination:widow-orphan;" +
//        "           font-size:11.0pt;" +
//        "           font-family:'Calibri','sans-serif';" +
//        "           mso-fareast-font-family:Calibri;" +
//        "           mso-fareast-theme-font:minor-latin;}" +
//        "     p.MsoAcetate, li.MsoAcetate, div.MsoAcetate" +
//        "           {mso-style-noshow:yes;" +
//        "           mso-style-priority:99;" +
//        "           mso-style-link:'Texto de globo Car';" +
//        "           margin:0cm;" +
//        "           margin-bottom:.0001pt;" +
//        "           mso-pagination:widow-orphan;" +
//        "           font-size:8.0pt;" +
//        "           font-family:'Tahoma','sans-serif';" +
//        "           mso-fareast-font-family:Calibri;" +
//        "           mso-fareast-theme-font:minor-latin;}" +
//        "     span.apple-converted-space" +
//        "           {mso-style-name:apple-converted-space;" +
//        "           mso-style-unhide:no;}" +
//        "     span.TextodegloboCar" +
//        "            {mso-style-name:'Texto de globo Car';" +
//        "           mso-style-noshow:yes;" +
//        "           mso-style-priority:99;" +
//        "           mso-style-unhide:no;" +
//        "           mso-style-locked:yes;" +
//        "           mso-style-link:'Texto de globo';" +
//        "           mso-ansi-font-size:8.0pt;" +
//        "           mso-bidi-font-size:8.0pt;" +
//        "           font-family:'Tahoma','sans-serif';" +
//        "           mso-ascii-font-family:Tahoma;" +
//        "           mso-hansi-font-family:Tahoma;" +
//        "           mso-bidi-font-family:Tahoma;" +
//        "           mso-fareast-language:ES-MX;}" +
//        "     span.SpellE" +
//        "           {mso-style-name:'';" +
//        "           mso-spl-e:yes;}" +
//        "     .MsoChpDefault" +
//        "           {mso-style-type:export-only;" +
//        "           mso-default-props:yes;" +
//        "           mso-ascii-font-family:Calibri;" +
//        "           mso-ascii-theme-font:minor-latin;" +
//        "           mso-fareast-font-family:Calibri;" +
//        "           mso-fareast-theme-font:minor-latin;" +
//        "           mso-hansi-font-family:Calibri;" +
//        "           mso-hansi-theme-font:minor-latin;" +
//        "           mso-bidi-font-family:'Times New Roman';" +
//        "           mso-bidi-theme-font:minor-bidi;" +
//        "           mso-fareast-language:EN-US;}" +
//        "     .MsoPapDefault" +
//        "           {mso-style-type:export-only;" +
//        "           margin-bottom:10.0pt;" +
//        "           line-height:115%;}" +
//        "     @page WordSection1" +
//        "           {size:612.0pt 792.0pt;" +
//        "           margin:70.85pt 3.0cm 70.85pt 3.0cm;" +
//        "           mso-header-margin:35.4pt;" +
//        "           mso-footer-margin:35.4pt;" +
//        "           mso-paper-source:0;}" +
//        "     div.WordSection1" +
//        "           {page:WordSection1;}" +
//        "     -->" +
//        "     </style>" +
//        "     <!--[if gte mso 10]>" +
//        "     <style>" +
//        "     /* Style Definitions */" +
//        "     table.MsoNormalTable" +
//        "           {mso-style-name:'Tabla normal';" +
//        "           mso-tstyle-rowband-size:0;" +
//        "           mso-tstyle-colband-size:0;" +
//        "           mso-style-noshow:yes;" +
//        "           mso-style-priority:99;" +
//        "           mso-style-qformat:yes;" +
//        "           mso-style-parent:'';" +
//        "           mso-padding-alt:0cm 5.4pt 0cm 5.4pt;" +
//        "           mso-para-margin-top:0cm;" +
//        "           mso-para-margin-right:0cm;" +
//        "           mso-para-margin-bottom:10.0pt;" +
//        "           mso-para-margin-left:0cm;" +
//        "           line-height:115%;" +
//        "           mso-pagination:widow-orphan;" +
//        "           font-size:11.0pt;" +
//        "           font-family:'Calibri','sans-serif';" +
//        "           mso-ascii-font-family:Calibri;" +
//        "           mso-ascii-theme-font:minor-latin;" +
//        "           mso-hansi-font-family:Calibri;" +
//        "           mso-hansi-theme-font:minor-latin;" +
//        "           mso-bidi-font-family:'Times New Roman';" +
//        "           mso-bidi-theme-font:minor-bidi;" +
//        "           mso-fareast-language:EN-US;}" +
//        "     </style>" +
//        "     <![endif]--><!--[if gte mso 9]><xml>" +
//        "     <o:shapedefaults v:ext='edit' spidmax='2050'/>" +
//        "     </xml><![endif]--><!--[if gte mso 9]><xml>" +
//        "     <o:shapelayout v:ext='edit'>" +
//        "       <o:idmap v:ext='edit' data='1'/>" +
//        "     </o:shapelayout></xml><![endif]-->" +
//        "     </head>                            " +
//        "     <body lang=ES-MX style='tab-interval:35.4pt'>                          " +
//        "     <div class=WordSection1>                             " +
//        "     <p class=MsoNormal><span lang=ES style='mso-ansi-language:ES'>Envio factura y <span" +
//        "     class=SpellE>xml</span><o:p></o:p></span></p>                          " +
//        "     <p class=MsoNormal><span lang=ES style='mso-ansi-language:ES'><o:p>&nbsp;</o:p></span></p>                              " +
//        "     <p class=MsoNormal style='text-align:justify'><b><i>Este archivo electronico de" +
//        "     datos<span class=apple-converted-space>&nbsp;</span></i></b><b><i><span" +
//        "     lang=ES style='mso-ansi-language:ES'>es propiedad de Estudios Clinicos Dr. T.J." +
//        "     <span class=SpellE>Oriard</span>, S.A. de C.V.<span" +
//        "     class=apple-converted-space>&nbsp;</span></span>&nbsp;<o:p></o:p></i></b></p>                           " +
//        "     <p class=MsoNormal style='text-align:justify'><b><i><o:p>&nbsp;</o:p></i></b></p>                          " +
//        "     <p class=MsoNormal style='text-align:justify'><b><i>La impresion de este" +
//        "     documento no puede ser utilizado para procesos legales.<o:p></o:p></i></b></p>                            " +
//        "     <p class=MsoNormal style='text-align:justify'><span lang=ES style='mso-ansi-language:ES'>" +
//        "     <o:p>&nbsp;</o:p></span></p>                         " +
//        "     <p class=MsoNormal style='text-align:justify'><b><i>Aviso Importante.</i></b><span" +
//        "     class=apple-converted-space><i>&nbsp;</i></span><i><span lang=ES" +
//        "     style='mso-ansi-language:ES'>Estudios Clinicos Dr. T.J. <span class=SpellE>Oriard</span>," +
//        "     S.A. de C.V.<span class=apple-converted-space>&nbsp;</span></span>NO se hace" +
//        "     responsable por cualquier modificacion, alteracion, y/o uso que se le de a la" +
//        "     informacion aqui señalada por parte de terceros.</i><span lang=ES" +
//        "     style='mso-ansi-language:ES'><o:p></o:p></span></p>                 " +         
//        "     <p class=MsoNormal><span lang=ES style='mso-ansi-language:ES'><o:p>&nbsp;</o:p></span></p>                              " +
//        "     <p class=MsoNormal><span lang=ES style='mso-ansi-language:ES'><o:p>&nbsp;</o:p></span></p>                              " +
//        "     <p class=MsoNormal><i style='mso-bidi-font-style:normal'><span" +
//        "     style='font-size:9.0pt;font-family:'Trebuchet MS','sans-serif';color:#002060;" +
//        "     mso-no-proof:yes'><!--[if gte vml 1]><v:shapetype id='_x0000_t75' coordsize='21600,21600'" +
//        "     o:spt='75' o:preferrelative='t' path='m@4@5l@4@11@9@11@9@5xe' filled='f'" +
//        "     stroked='f'>" +
//        "     <v:stroke joinstyle='miter'/>" +
//        "     <v:formulas>" +
//        "       <v:f eqn='if lineDrawn pixelLineWidth 0'/>" +
//        "       <v:f eqn='sum @0 1 0'/>" +
//        "       <v:f eqn='sum 0 0 @1'/>" +
//        "       <v:f eqn='prod @2 1 2'/>" +
//        "       <v:f eqn='prod @3 21600 pixelWidth'/>" +
//        "       <v:f eqn='prod @3 21600 pixelHeight'/>" +
//        "       <v:f eqn='sum @0 0 1'/>" +
//        "       <v:f eqn='prod @6 1 2'/>" +
//        "       <v:f eqn='prod @7 21600 pixelWidth'/>" +
//        "       <v:f eqn='sum @8 21600 0'/>" +
//        "       <v:f eqn='prod @7 21600 pixelHeight'/>" +
//        "       <v:f eqn='sum @10 21600 0'/>" +
//        "     </v:formulas>" +
//        "     <v:path o:extrusionok='f' gradientshapeok='t' o:connecttype='rect'/>" +
//        "     <o:lock v:ext='edit' aspectratio='t'/>" +
//        "     </v:shapetype><v:shape id='_x0000_i1025' type='#_x0000_t75' style='width:4in;" +
//        "     height:164.25pt;visibility:visible'>" +
//        "     <v:imagedata src='http://173.203.12.186:9085/Imagenes/image001.jpg' o:href='cid:image001.jpg@01CBE408.7C934A50'/>" +
//        "     </v:shape><![endif]--><![if !vml]><img width=384 height=219" +
//        "     src='http://173.203.12.186:9085/Imagenes/image001.jpg' v:shapes='_x0000_i1025'><![endif]></span></i></p>" +
//        "     <p class=MsoNormal><o:p>&nbsp;</o:p></p>" +
//        "     </div>" +
//        "     </body>" +
//        "     </html>";
//	}
	
	private String getFormatoFE(String strPaciente, int cMarca) {
		if (cMarca == 4) {
			return "<!DOCTYPE html>	" +
					"<html>	" +
					"<head></head>	" +
					"<body style=\"padding: 0;\">	" +
					"<table style=\"border-collapse: collapse; border: none; width: 600px;\">	" +
					"	<tr>	" +
					"		<td class=\"noPadding\" style=\"width: 600px; padding: 0;\">	" +
					"			<img src=\"http://zudulio.com/olab2/imagesEmail/top.jpg\">	" +
					"		</td>	" +
					"	</tr>	" +
					"	<tr>	" +
					"		<td style=\"width: 600px; padding: 15px 30px;\">	" +
					"			<h1 style=\"font-size: 1.25em; font-weight: bold; text-transform: uppercase;\">	" +
					"				AL MEJOR LABORATORIO DE ANÁLISIS CLÍNICOS Y GABINETE DE MÉXICO LABORATORIO QUIMICO CLINICO AZTECA " +
					"			</h1>	" +
					"		</td>	" +
					"	</tr>	" +
					"	<tr>	" +
					"		<td style=\"width: 600px; padding: 15px 30px;\">	" +
					"			<span style=\"color: #F29103; font-size: 1.25em; margin-right: 10px; font-weight: bold;\">Estimado paciente:</span> " + strPaciente +
					"		</td>	" +
					"	</tr>	" +
					"	<tr>	" +
					"		<td style=\"width: 600px; padding: 15px 30px; color: #595959;\">	" +
					"			Agradecemos tu confianza y te recordamos que en Laboratorio Azteca \"Queremos saber cómo estás\",es por ellos que contamos con médicos y técnicos altamente especializados, tecnología de	" +
					"			punta en nuestros equipos y una cultura de atención con servicio de primer nivel.	" +
					"		</td>	" +
					"	</tr>	" +
					"	<tr>	" +
					"		<td style=\"width: 600px; padding: 15px 30px; color: #595959;\">	" +
					"			A éste correo encontrarás la factura en formato pdf y xml	" +
					"		</td>	" +
					"	</tr>	" +
					"	<tr>	" +
					"		<td style=\"width: 600px; padding: 15px 30px; color: #595959;\">	" +
					"			Te recordamos que solo cuentas con una refacturación y solo la podrás realizar antes de los 5 días a la fecha de este correo.	" +
					"		</td>	" +
					"	</tr>	" +
					"	<tr>	" +
					"		<td style=\"width: 600px; padding: 15px 30px; color: #595959;\">	" +
					"			El teléfono de nuestro centro de atención a pacientes en el tema de facturación es el 40406010 extensión 4206 en el cuál podrás obtener información a tus dudas o sugerencias.</td>	" +
					"	</tr>	" +
//					"	<tr>	" +
//					"		<td class=\"right\" style=\"width: 600px; padding: 15px 30px; font-size: 1.15em; text-align: right; color: #4d4d4d; \">	" +
//					"			<h3>Mis mejores deseos para ti y toda tu familia</h3>	" +
//					"			<h3>Dr. O, Especialista en Cuidado</h3>	" +
//					"		</td>	" +
//					"	</tr>	" +
					"	<tr class=\"lineH0\" style=\"line-height: 8px;\">	" +
					"		<td class=\"noTopPadding\" style=\"width: 600px; padding: 0 30px;\">	" +
					"			<img src=\"http://zudulio.com/olab2/imagesEmail/aviso.gif\">	" +
					"		</td>	" +
					"	</tr>	" +
					"	<tr class=\"orange\" style=\"background-color: #EB6E27; color: white; font-size: .8em;\">	" +
					"		<td style=\"width: 600px; padding: 15px 30px;\">	" +
					"			En nuestro empeño por brindarle mejores servicios, \"LABORATORIO QUIMICO CLINICO AZTECA\" (en lo sucesivo Laboratorio Azteca)	" +
					"			a través de este medio proporcionará los resultados de las pruebas de análisis clínicos practicadas	" +
					"			en sus diferentes sucursales. Laboratorio Azteca no se hace responsable por cualquier modificación o alteración	" +
					"			que la información aquí ofrecida pudiera sufrir por actos del paciente o terceros por lo que en caso	" +
					"			de duda es responsabilidad del paciente.	" +
					"		</td>	" +
					"	</tr>	" +
					"	<tr class=\"orange\" style=\"background-color: #EB6E27; color: white; font-size: .8em;\">	" +
					"		<td style=\"width: 600px; padding: 15px 30px;\">	" +
					"			LABORATORIO QUIMICO CLINICO AZTECA en apego a la ley de Datos Personales, NO revelará, dará, venderá, donará o transmitirá ningún tipo	" +
					"			de información personal del paciente relacionada con los resultados de las pruebas clínicas practicadas,	" +
					"			excepto cuando esta información sea solicitada por aurotidad competente.	" +
					"		</td>	" +
					"	</tr>	" +
					"	<tr class=\"orange\" style=\"background-color: #EB6E27; color: white; font-size: .8em;\">	" +
					"		<td style=\"width: 600px; padding: 15px 30px;\">	" +
					"			Recuerda que tu médico es la única persona con conocimiento y autoridad para interpretar los resultados de tus estudios.	" +
					"		</td>	" +
					"	</tr>	" +
					"	<tr class=\"darkOrange\" style=\"background-color: #E01B26; color: white; text-align: center;\">	" +
					"		<td style=\"width: 600px; padding: 15px 30px;\">	" +
					"			Para cualquier duda o aclaración, estamos a tus órdenes en<h2 style=\"font-size: 1.5em; margin: 0; padding: 0;\">Tel. 58580900</h2>	" +
					"		</td>	" +
					"	</tr>	" +
					"</table>	" +
					"</body>	" +
					"</html>	";	
		} else {
			return "<!DOCTYPE html>	" +
					"<html>	" +
					"<head></head>	" +
					"<body style=\"padding: 0;\">	" +
					"<table style=\"border-collapse: collapse; border: none; width: 600px;\">	" +
					"	<tr>	" +
					"		<td class=\"noPadding\" style=\"width: 600px; padding: 0;\">	" +
					"			<img src=\"http://zudulio.com/olab2/imagesEmail/top.jpg\">	" +
					"		</td>	" +
					"	</tr>	" +
					"	<tr>	" +
					"		<td style=\"width: 600px; padding: 15px 30px;\">	" +
					"			<h1 style=\"font-size: 1.25em; font-weight: bold; text-transform: uppercase;\">	" +
					"				AL MEJOR LABORATORIO DE ANÁLISIS CLÍNICOS Y GABINETE DE MÉXICO	" +
					"			</h1>	" +
					"		</td>	" +
					"	</tr>	" +
					"	<tr>	" +
					"		<td style=\"width: 600px; padding: 15px 30px;\">	" +
					"			<span style=\"color: #F29103; font-size: 1.25em; margin-right: 10px; font-weight: bold;\">Estimado paciente:</span> " + strPaciente +
					"		</td>	" +
					"	</tr>	" +
					"	<tr>	" +
					"		<td style=\"width: 600px; padding: 15px 30px; color: #595959;\">	" +
					"			Agradecemos tu confianza y te recordamos que en Olab \"Queremos saber cómo estás\",es por ellos que contamos con médicos y técnicos altamente especializados, tecnología de	" +
					"			punta en nuestros equipos y una cultura de atención con servicio de primer nivel.	" +
					"		</td>	" +
					"	</tr>	" +
					"	<tr>	" +
					"		<td style=\"width: 600px; padding: 15px 30px; color: #595959;\">	" +
					"			A éste correo encontrarás la factura en formato pdf y xml	" +
					"		</td>	" +
					"	</tr>	" +
					"	<tr>	" +
					"		<td style=\"width: 600px; padding: 15px 30px; color: #595959;\">	" +
					"			Te recordamos que solo cuentas con una refacturación y solo la podrás realizar antes de los 5 días a la fecha de este correo.	" +
					"		</td>	" +
					"	</tr>	" +
					"	<tr>	" +
					"		<td style=\"width: 600px; padding: 15px 30px; color: #595959;\">	" +
					"			El teléfono de nuestro centro de atención a pacientes en el tema de facturación es el 40406010 extensión 4206 en el cuál podrás obtener información a tus dudas o sugerencias.</td>	" +
					"	</tr>	" +
					"	<tr>	" +
					"		<td class=\"right\" style=\"width: 600px; padding: 15px 30px; font-size: 1.15em; text-align: right; color: #4d4d4d; \">	" +
					"			<h3>Mis mejores deseos para ti y toda tu familia</h3>	" +
					"			<h3>Dr. O, Especialista en Cuidado</h3>	" +
					"		</td>	" +
					"	</tr>	" +
					"	<tr class=\"lineH0\" style=\"line-height: 8px;\">	" +
					"		<td class=\"noTopPadding\" style=\"width: 600px; padding: 0 30px;\">	" +
					"			<img src=\"http://zudulio.com/olab2/imagesEmail/aviso.gif\">	" +
					"		</td>	" +
					"	</tr>	" +
					"	<tr class=\"orange\" style=\"background-color: #EB6E27; color: white; font-size: .8em;\">	" +
					"		<td style=\"width: 600px; padding: 15px 30px;\">	" +
					"			En nuestro empeño por brindarle mejores servicios, \"OLAB Diágnosticos Médicos\" (en lo sucesivo OLAB)	" +
					"			a través de este medio proporcionará los resultados de las pruebas de análisis clínicos practicadas	" +
					"			en sus diferentes sucursales. OLAB no se hace responsable por cualquier modificación o alteración	" +
					"			que la información aquí ofrecida pudiera sufrir por actos del paciente o terceros por lo que en caso	" +
					"			de duda es responsabilidad del paciente.	" +
					"		</td>	" +
					"	</tr>	" +
					"	<tr class=\"orange\" style=\"background-color: #EB6E27; color: white; font-size: .8em;\">	" +
					"		<td style=\"width: 600px; padding: 15px 30px;\">	" +
					"			OLAB en apego a la ley de Datos Personales, NO revelará, dará, venderá, donará o transmitirá ningún tipo	" +
					"			de información personal del paciente relacionada con los resultados de las pruebas clínicas practicadas,	" +
					"			excepto cuando esta información sea solicitada por aurotidad competente.	" +
					"		</td>	" +
					"	</tr>	" +
					"	<tr class=\"orange\" style=\"background-color: #EB6E27; color: white; font-size: .8em;\">	" +
					"		<td style=\"width: 600px; padding: 15px 30px;\">	" +
					"			Recuerda que tu médico es la única persona con conocimiento y autoridad para interpretar los resultados de tus estudios.	" +
					"		</td>	" +
					"	</tr>	" +
					"	<tr class=\"darkOrange\" style=\"background-color: #E01B26; color: white; text-align: center;\">	" +
					"		<td style=\"width: 600px; padding: 15px 30px;\">	" +
					"			Para cualquier duda o aclaración, estamos a tus órdenes en<h2 style=\"font-size: 1.5em; margin: 0; padding: 0;\">Tel. 4040 6522</h2>	" +
					"		</td>	" +
					"	</tr>	" +
					"</table>	" +
					"</body>	" +
					"</html>	";	
		}
	}

	
	private String getFormatoECEPacienteGDA(TPaciente objPaciente) {
		return "	<html xmlns:v='urn:schemas-microsoft-com:vml' \n" +
		"	xmlns:o='urn:schemas-microsoft-com:office:office' \n" +
		"	xmlns:w='urn:schemas-microsoft-com:office:word' \n" +
		"	xmlns:m='http://schemas.microsoft.com/office/2004/12/omml' \n" +
		"	xmlns='http://www.w3.org/TR/REC-html40'> \n" +
		"	 \n" +
		"	<head> \n" +
		"	<meta http-equiv=Content-Type content='text/html; charset=windows-1252'> \n" +
		"	<meta name=ProgId content=Word.Document> \n" +
		"	<meta name=Generator content='Microsoft Word 12'> \n" +
		"	<meta name=Originator content='Microsoft Word 12'> \n" +
		"	<link rel=File-List \n" +
		"	href='Bienvenido%20estimado%20Paciente%20-%20Consulta%20de%20su%20Expediente%20Electronico_archivos/filelist.xml'> \n" +
		"	<link rel=Edit-Time-Data \n" +
		"	href='Bienvenido%20estimado%20Paciente%20-%20Consulta%20de%20su%20Expediente%20Electronico_archivos/editdata.mso'> \n" +
		"	<!--[if !mso]> \n" +
		"	<style> \n" +
		"	v\\:* {behavior:url(#default#VML);} \n" +
		"	o\\:* {behavior:url(#default#VML);} \n" +
		"	w\\:* {behavior:url(#default#VML);} \n" +
		"	.shape {behavior:url(#default#VML);} \n" +
		"	</style> \n" +
		"	<![endif]--><!--[if gte mso 9]><xml> \n" +
		"	 <o:DocumentProperties> \n" +
		"	  <o:Author>orubio</o:Author> \n" +
		"	  <o:Template>Normal</o:Template> \n" +
		"	  <o:LastAuthor>orubio</o:LastAuthor> \n" +
		"	  <o:Revision>2</o:Revision> \n" +
		"	  <o:TotalTime>6</o:TotalTime> \n" +
		"	  <o:Created>2012-03-01T17:39:00Z</o:Created> \n" +
		"	  <o:LastSaved>2012-03-01T17:39:00Z</o:LastSaved> \n" +
		"	  <o:Pages>2</o:Pages> \n" +
		"	  <o:Words>470</o:Words> \n" +
		"	  <o:Characters>2588</o:Characters> \n" +
		"	  <o:Company>Toshiba</o:Company> \n" +
		"	  <o:Lines>21</o:Lines> \n" +
		"	  <o:Paragraphs>6</o:Paragraphs> \n" +
		"	  <o:CharactersWithSpaces>3052</o:CharactersWithSpaces> \n" +
		"	  <o:Version>12.00</o:Version> \n" +
		"	 </o:DocumentProperties> \n" +
		"	</xml><![endif]--> \n" +
		"	<link rel=themeData \n" +
		"	href='Bienvenido%20estimado%20Paciente%20-%20Consulta%20de%20su%20Expediente%20Electronico_archivos/themedata.thmx'> \n" +
		"	<link rel=colorSchemeMapping \n" +
		"	href='Bienvenido%20estimado%20Paciente%20-%20Consulta%20de%20su%20Expediente%20Electronico_archivos/colorschememapping.xml'> \n" +
		"	<!--[if gte mso 9]><xml> \n" +
		"	 <w:WordDocument> \n" +
		"	  <w:SpellingState>Clean</w:SpellingState> \n" +
		"	  <w:GrammarState>Clean</w:GrammarState> \n" +
		"	  <w:TrackMoves>false</w:TrackMoves> \n" +
		"	  <w:TrackFormatting/> \n" +
		"	  <w:HyphenationZone>21</w:HyphenationZone> \n" +
		"	  <w:PunctuationKerning/> \n" +
		"	  <w:ValidateAgainstSchemas/> \n" +
		"	  <w:SaveIfXMLInvalid>false</w:SaveIfXMLInvalid> \n" +
		"	  <w:IgnoreMixedContent>false</w:IgnoreMixedContent> \n" +
		"	  <w:AlwaysShowPlaceholderText>false</w:AlwaysShowPlaceholderText> \n" +
		"	  <w:DoNotPromoteQF/> \n" +
		"	  <w:LidThemeOther>ES-MX</w:LidThemeOther> \n" +
		"	  <w:LidThemeAsian>X-NONE</w:LidThemeAsian> \n" +
		"	  <w:LidThemeComplexScript>X-NONE</w:LidThemeComplexScript> \n" +
		"	  <w:Compatibility> \n" +
		"	   <w:BreakWrappedTables/> \n" +
		"	   <w:SnapToGridInCell/> \n" +
		"	   <w:WrapTextWithPunct/> \n" +
		"	   <w:UseAsianBreakRules/> \n" +
		"	   <w:DontGrowAutofit/> \n" +
		"	   <w:DontUseIndentAsNumberingTabStop/> \n" +
		"	   <w:FELineBreak11/> \n" +
		"	   <w:WW11IndentRules/> \n" +
		"	   <w:DontAutofitConstrainedTables/> \n" +
		"	   <w:AutofitLikeWW11/> \n" +
		"	   <w:HangulWidthLikeWW11/> \n" +
		"	   <w:UseNormalStyleForList/> \n" +
		"	  </w:Compatibility> \n" +
		"	  <w:BrowserLevel>MicrosoftInternetExplorer4</w:BrowserLevel> \n" +
		"	  <m:mathPr> \n" +
		"	   <m:mathFont m:val='Cambria Math'/> \n" +
		"	   <m:brkBin m:val='before'/> \n" +
		"	   <m:brkBinSub m:val='&#45;-'/> \n" +
		"	   <m:smallFrac m:val='off'/> \n" +
		"	   <m:dispDef/> \n" +
		"	   <m:lMargin m:val='0'/> \n" +
		"	   <m:rMargin m:val='0'/> \n" +
		"	   <m:defJc m:val='centerGroup'/> \n" +
		"	   <m:wrapIndent m:val='1440'/> \n" +
		"	   <m:intLim m:val='subSup'/> \n" +
		"	   <m:naryLim m:val='undOvr'/> \n" +
		"	  </m:mathPr></w:WordDocument> \n" +
		"	</xml><![endif]--><!--[if gte mso 9]><xml> \n" +
		"	 <w:LatentStyles DefLockedState='false' DefUnhideWhenUsed='true' \n" +
		"	  DefSemiHidden='true' DefQFormat='false' DefPriority='99' \n" +
		"	  LatentStyleCount='267'> \n" +
		"	  <w:LsdException Locked='false' Priority='0' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' QFormat='true' Name='Normal'/> \n" +
		"	  <w:LsdException Locked='false' Priority='9' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' QFormat='true' Name='heading 1'/> \n" +
		"	  <w:LsdException Locked='false' Priority='9' QFormat='true' Name='heading 2'/> \n" +
		"	  <w:LsdException Locked='false' Priority='9' QFormat='true' Name='heading 3'/> \n" +
		"	  <w:LsdException Locked='false' Priority='9' QFormat='true' Name='heading 4'/> \n" +
		"	  <w:LsdException Locked='false' Priority='9' QFormat='true' Name='heading 5'/> \n" +
		"	  <w:LsdException Locked='false' Priority='9' QFormat='true' Name='heading 6'/> \n" +
		"	  <w:LsdException Locked='false' Priority='9' QFormat='true' Name='heading 7'/> \n" +
		"	  <w:LsdException Locked='false' Priority='9' QFormat='true' Name='heading 8'/> \n" +
		"	  <w:LsdException Locked='false' Priority='9' QFormat='true' Name='heading 9'/> \n" +
		"	  <w:LsdException Locked='false' Priority='39' Name='toc 1'/> \n" +
		"	  <w:LsdException Locked='false' Priority='39' Name='toc 2'/> \n" +
		"	  <w:LsdException Locked='false' Priority='39' Name='toc 3'/> \n" +
		"	  <w:LsdException Locked='false' Priority='39' Name='toc 4'/> \n" +
		"	  <w:LsdException Locked='false' Priority='39' Name='toc 5'/> \n" +
		"	  <w:LsdException Locked='false' Priority='39' Name='toc 6'/> \n" +
		"	  <w:LsdException Locked='false' Priority='39' Name='toc 7'/> \n" +
		"	  <w:LsdException Locked='false' Priority='39' Name='toc 8'/> \n" +
		"	  <w:LsdException Locked='false' Priority='39' Name='toc 9'/> \n" +
		"	  <w:LsdException Locked='false' Priority='35' QFormat='true' Name='caption'/> \n" +
		"	  <w:LsdException Locked='false' Priority='10' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' QFormat='true' Name='Title'/> \n" +
		"	  <w:LsdException Locked='false' Priority='1' Name='Default Paragraph Font'/> \n" +
		"	  <w:LsdException Locked='false' Priority='11' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' QFormat='true' Name='Subtitle'/> \n" +
		"	  <w:LsdException Locked='false' Priority='22' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' QFormat='true' Name='Strong'/> \n" +
		"	  <w:LsdException Locked='false' Priority='20' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' QFormat='true' Name='Emphasis'/> \n" +
		"	  <w:LsdException Locked='false' Priority='59' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Table Grid'/> \n" +
		"	  <w:LsdException Locked='false' UnhideWhenUsed='false' Name='Placeholder Text'/> \n" +
		"	  <w:LsdException Locked='false' Priority='1' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' QFormat='true' Name='No Spacing'/> \n" +
		"	  <w:LsdException Locked='false' Priority='60' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light Shading'/> \n" +
		"	  <w:LsdException Locked='false' Priority='61' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light List'/> \n" +
		"	  <w:LsdException Locked='false' Priority='62' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light Grid'/> \n" +
		"	  <w:LsdException Locked='false' Priority='63' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Shading 1'/> \n" +
		"	  <w:LsdException Locked='false' Priority='64' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Shading 2'/> \n" +
		"	  <w:LsdException Locked='false' Priority='65' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium List 1'/> \n" +
		"	  <w:LsdException Locked='false' Priority='66' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium List 2'/> \n" +
		"	  <w:LsdException Locked='false' Priority='67' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 1'/> \n" +
		"	  <w:LsdException Locked='false' Priority='68' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 2'/> \n" +
		"	  <w:LsdException Locked='false' Priority='69' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 3'/> \n" +
		"	  <w:LsdException Locked='false' Priority='70' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Dark List'/> \n" +
		"	  <w:LsdException Locked='false' Priority='71' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful Shading'/> \n" +
		"	  <w:LsdException Locked='false' Priority='72' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful List'/> \n" +
		"	  <w:LsdException Locked='false' Priority='73' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful Grid'/> \n" +
		"	  <w:LsdException Locked='false' Priority='60' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light Shading Accent 1'/> \n" +
		"	  <w:LsdException Locked='false' Priority='61' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light List Accent 1'/> \n" +
		"	  <w:LsdException Locked='false' Priority='62' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light Grid Accent 1'/> \n" +
		"	  <w:LsdException Locked='false' Priority='63' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Shading 1 Accent 1'/> \n" +
		"	  <w:LsdException Locked='false' Priority='64' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Shading 2 Accent 1'/> \n" +
		"	  <w:LsdException Locked='false' Priority='65' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium List 1 Accent 1'/> \n" +
		"	  <w:LsdException Locked='false' UnhideWhenUsed='false' Name='Revision'/> \n" +
		"	  <w:LsdException Locked='false' Priority='34' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' QFormat='true' Name='List Paragraph'/> \n" +
		"	  <w:LsdException Locked='false' Priority='29' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' QFormat='true' Name='Quote'/> \n" +
		"	  <w:LsdException Locked='false' Priority='30' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' QFormat='true' Name='Intense Quote'/> \n" +
		"	  <w:LsdException Locked='false' Priority='66' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium List 2 Accent 1'/> \n" +
		"	  <w:LsdException Locked='false' Priority='67' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 1 Accent 1'/> \n" +
		"	  <w:LsdException Locked='false' Priority='68' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 2 Accent 1'/> \n" +
		"	  <w:LsdException Locked='false' Priority='69' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 3 Accent 1'/> \n" +
		"	  <w:LsdException Locked='false' Priority='70' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Dark List Accent 1'/> \n" +
		"	  <w:LsdException Locked='false' Priority='71' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful Shading Accent 1'/> \n" +
		"	  <w:LsdException Locked='false' Priority='72' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful List Accent 1'/> \n" +
		"	  <w:LsdException Locked='false' Priority='73' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful Grid Accent 1'/> \n" +
		"	  <w:LsdException Locked='false' Priority='60' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light Shading Accent 2'/> \n" +
		"	  <w:LsdException Locked='false' Priority='61' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light List Accent 2'/> \n" +
		"	  <w:LsdException Locked='false' Priority='62' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light Grid Accent 2'/> \n" +
		"	  <w:LsdException Locked='false' Priority='63' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Shading 1 Accent 2'/> \n" +
		"	  <w:LsdException Locked='false' Priority='64' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Shading 2 Accent 2'/> \n" +
		"	  <w:LsdException Locked='false' Priority='65' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium List 1 Accent 2'/> \n" +
		"	  <w:LsdException Locked='false' Priority='66' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium List 2 Accent 2'/> \n" +
		"	  <w:LsdException Locked='false' Priority='67' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 1 Accent 2'/> \n" +
		"	  <w:LsdException Locked='false' Priority='68' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 2 Accent 2'/> \n" +
		"	  <w:LsdException Locked='false' Priority='69' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 3 Accent 2'/> \n" +
		"	  <w:LsdException Locked='false' Priority='70' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Dark List Accent 2'/> \n" +
		"	  <w:LsdException Locked='false' Priority='71' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful Shading Accent 2'/> \n" +
		"	  <w:LsdException Locked='false' Priority='72' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful List Accent 2'/> \n" +
		"	  <w:LsdException Locked='false' Priority='73' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful Grid Accent 2'/> \n" +
		"	  <w:LsdException Locked='false' Priority='60' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light Shading Accent 3'/> \n" +
		"	  <w:LsdException Locked='false' Priority='61' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light List Accent 3'/> \n" +
		"	  <w:LsdException Locked='false' Priority='62' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light Grid Accent 3'/> \n" +
		"	  <w:LsdException Locked='false' Priority='63' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Shading 1 Accent 3'/> \n" +
		"	  <w:LsdException Locked='false' Priority='64' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Shading 2 Accent 3'/> \n" +
		"	  <w:LsdException Locked='false' Priority='65' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium List 1 Accent 3'/> \n" +
		"	  <w:LsdException Locked='false' Priority='66' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium List 2 Accent 3'/> \n" +
		"	  <w:LsdException Locked='false' Priority='67' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 1 Accent 3'/> \n" +
		"	  <w:LsdException Locked='false' Priority='68' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 2 Accent 3'/> \n" +
		"	  <w:LsdException Locked='false' Priority='69' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 3 Accent 3'/> \n" +
		"	  <w:LsdException Locked='false' Priority='70' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Dark List Accent 3'/> \n" +
		"	  <w:LsdException Locked='false' Priority='71' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful Shading Accent 3'/> \n" +
		"	  <w:LsdException Locked='false' Priority='72' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful List Accent 3'/> \n" +
		"	  <w:LsdException Locked='false' Priority='73' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful Grid Accent 3'/> \n" +
		"	  <w:LsdException Locked='false' Priority='60' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light Shading Accent 4'/> \n" +
		"	  <w:LsdException Locked='false' Priority='61' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light List Accent 4'/> \n" +
		"	  <w:LsdException Locked='false' Priority='62' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light Grid Accent 4'/> \n" +
		"	  <w:LsdException Locked='false' Priority='63' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Shading 1 Accent 4'/> \n" +
		"	  <w:LsdException Locked='false' Priority='64' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Shading 2 Accent 4'/> \n" +
		"	  <w:LsdException Locked='false' Priority='65' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium List 1 Accent 4'/> \n" +
		"	  <w:LsdException Locked='false' Priority='66' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium List 2 Accent 4'/> \n" +
		"	  <w:LsdException Locked='false' Priority='67' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 1 Accent 4'/> \n" +
		"	  <w:LsdException Locked='false' Priority='68' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 2 Accent 4'/> \n" +
		"	  <w:LsdException Locked='false' Priority='69' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 3 Accent 4'/> \n" +
		"	  <w:LsdException Locked='false' Priority='70' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Dark List Accent 4'/> \n" +
		"	  <w:LsdException Locked='false' Priority='71' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful Shading Accent 4'/> \n" +
		"	  <w:LsdException Locked='false' Priority='72' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful List Accent 4'/> \n" +
		"	  <w:LsdException Locked='false' Priority='73' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful Grid Accent 4'/> \n" +
		"	  <w:LsdException Locked='false' Priority='60' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light Shading Accent 5'/> \n" +
		"	  <w:LsdException Locked='false' Priority='61' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light List Accent 5'/> \n" +
		"	  <w:LsdException Locked='false' Priority='62' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light Grid Accent 5'/> \n" +
		"	  <w:LsdException Locked='false' Priority='63' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Shading 1 Accent 5'/> \n" +
		"	  <w:LsdException Locked='false' Priority='64' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Shading 2 Accent 5'/> \n" +
		"	  <w:LsdException Locked='false' Priority='65' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium List 1 Accent 5'/> \n" +
		"	  <w:LsdException Locked='false' Priority='66' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium List 2 Accent 5'/> \n" +
		"	  <w:LsdException Locked='false' Priority='67' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 1 Accent 5'/> \n" +
		"	  <w:LsdException Locked='false' Priority='68' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 2 Accent 5'/> \n" +
		"	  <w:LsdException Locked='false' Priority='69' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 3 Accent 5'/> \n" +
		"	  <w:LsdException Locked='false' Priority='70' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Dark List Accent 5'/> \n" +
		"	  <w:LsdException Locked='false' Priority='71' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful Shading Accent 5'/> \n" +
		"	  <w:LsdException Locked='false' Priority='72' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful List Accent 5'/> \n" +
		"	  <w:LsdException Locked='false' Priority='73' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful Grid Accent 5'/> \n" +
		"	  <w:LsdException Locked='false' Priority='60' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light Shading Accent 6'/> \n" +
		"	  <w:LsdException Locked='false' Priority='61' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light List Accent 6'/> \n" +
		"	  <w:LsdException Locked='false' Priority='62' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light Grid Accent 6'/> \n" +
		"	  <w:LsdException Locked='false' Priority='63' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Shading 1 Accent 6'/> \n" +
		"	  <w:LsdException Locked='false' Priority='64' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Shading 2 Accent 6'/> \n" +
		"	  <w:LsdException Locked='false' Priority='65' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium List 1 Accent 6'/> \n" +
		"	  <w:LsdException Locked='false' Priority='66' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium List 2 Accent 6'/> \n" +
		"	  <w:LsdException Locked='false' Priority='67' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 1 Accent 6'/> \n" +
		"	  <w:LsdException Locked='false' Priority='68' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 2 Accent 6'/> \n" +
		"	  <w:LsdException Locked='false' Priority='69' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 3 Accent 6'/> \n" +
		"	  <w:LsdException Locked='false' Priority='70' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Dark List Accent 6'/> \n" +
		"	  <w:LsdException Locked='false' Priority='71' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful Shading Accent 6'/> \n" +
		"	  <w:LsdException Locked='false' Priority='72' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful List Accent 6'/> \n" +
		"	  <w:LsdException Locked='false' Priority='73' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful Grid Accent 6'/> \n" +
		"	  <w:LsdException Locked='false' Priority='19' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' QFormat='true' Name='Subtle Emphasis'/> \n" +
		"	  <w:LsdException Locked='false' Priority='21' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' QFormat='true' Name='Intense Emphasis'/> \n" +
		"	  <w:LsdException Locked='false' Priority='31' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' QFormat='true' Name='Subtle Reference'/> \n" +
		"	  <w:LsdException Locked='false' Priority='32' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' QFormat='true' Name='Intense Reference'/> \n" +
		"	  <w:LsdException Locked='false' Priority='33' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' QFormat='true' Name='Book Title'/> \n" +
		"	  <w:LsdException Locked='false' Priority='37' Name='Bibliography'/> \n" +
		"	  <w:LsdException Locked='false' Priority='39' QFormat='true' Name='TOC Heading'/> \n" +
		"	 </w:LatentStyles> \n" +
		"	</xml><![endif]--> \n" +
		"	<style> \n" +
		"	<!-- \n" +
		"	 /* Font Definitions */ \n" +
		"	 @font-face \n" +
		"		{font-family:Wingdings; \n" +
		"		panose-1:5 0 0 0 0 0 0 0 0 0; \n" +
		"		mso-font-charset:2; \n" +
		"		mso-generic-font-family:auto; \n" +
		"		mso-font-pitch:variable; \n" +
		"		mso-font-signature:0 268435456 0 0 -2147483648 0;} \n" +
		"	@font-face \n" +
		"		{font-family:'Cambria Math'; \n" +
		"		panose-1:2 4 5 3 5 4 6 3 2 4; \n" +
		"		mso-font-charset:0; \n" +
		"		mso-generic-font-family:roman; \n" +
		"		mso-font-pitch:variable; \n" +
		"		mso-font-signature:-536870145 1107305727 0 0 415 0;} \n" +
		"	@font-face \n" +
		"		{font-family:Calibri; \n" +
		"		panose-1:2 15 5 2 2 2 4 3 2 4; \n" +
		"		mso-font-charset:0; \n" +
		"		mso-generic-font-family:swiss; \n" +
		"		mso-font-pitch:variable; \n" +
		"		mso-font-signature:-520092929 1073786111 9 0 415 0;} \n" +
		"	@font-face \n" +
		"		{font-family:Tahoma; \n" +
		"		panose-1:2 11 6 4 3 5 4 4 2 4; \n" +
		"		mso-font-charset:0; \n" +
		"		mso-generic-font-family:swiss; \n" +
		"		mso-font-pitch:variable; \n" +
		"		mso-font-signature:-520081665 -1073717157 41 0 66047 0;} \n" +
		"	 /* Style Definitions */ \n" +
		"	 p.MsoNormal, li.MsoNormal, div.MsoNormal \n" +
		"		{mso-style-unhide:no; \n" +
		"		mso-style-qformat:yes; \n" +
		"		mso-style-parent:''; \n" +
		"		margin-top:0cm; \n" +
		"		margin-right:0cm; \n" +
		"		margin-bottom:10.0pt; \n" +
		"		margin-left:0cm; \n" +
		"		line-height:115%; \n" +
		"		mso-pagination:widow-orphan; \n" +
		"		font-size:11.0pt; \n" +
		"		font-family:'Calibri','sans-serif'; \n" +
		"		mso-fareast-font-family:Calibri; \n" +
		"		mso-bidi-font-family:'Times New Roman'; \n" +
		"		mso-fareast-language:EN-US;} \n" +
		"	p.MsoCommentText, li.MsoCommentText, div.MsoCommentText \n" +
		"		{mso-style-noshow:yes; \n" +
		"		mso-style-priority:99; \n" +
		"		mso-style-link:'Texto comentario Car'; \n" +
		"		margin-top:0cm; \n" +
		"		margin-right:0cm; \n" +
		"		margin-bottom:10.0pt; \n" +
		"		margin-left:0cm; \n" +
		"		line-height:115%; \n" +
		"		mso-pagination:widow-orphan; \n" +
		"		font-size:10.0pt; \n" +
		"		font-family:'Calibri','sans-serif'; \n" +
		"		mso-fareast-font-family:Calibri; \n" +
		"		mso-bidi-font-family:'Times New Roman'; \n" +
		"		mso-fareast-language:EN-US;} \n" +
		"	span.MsoCommentReference \n" +
		"		{mso-style-noshow:yes; \n" +
		"		mso-style-priority:99; \n" +
		"		mso-ansi-font-size:8.0pt; \n" +
		"		mso-bidi-font-size:8.0pt;} \n" +
		"	a:link, span.MsoHyperlink \n" +
		"		{mso-style-priority:99; \n" +
		"		color:blue; \n" +
		"		text-decoration:underline; \n" +
		"		text-underline:single;} \n" +
		"	a:visited, span.MsoHyperlinkFollowed \n" +
		"		{mso-style-noshow:yes; \n" +
		"		mso-style-priority:99; \n" +
		"		color:purple; \n" +
		"		mso-themecolor:followedhyperlink; \n" +
		"		text-decoration:underline; \n" +
		"		text-underline:single;} \n" +
		"	p.MsoCommentSubject, li.MsoCommentSubject, div.MsoCommentSubject \n" +
		"		{mso-style-noshow:yes; \n" +
		"		mso-style-priority:99; \n" +
		"		mso-style-parent:'Texto comentario'; \n" +
		"		mso-style-link:'Asunto del comentario Car'; \n" +
		"		mso-style-next:'Texto comentario'; \n" +
		"		margin-top:0cm; \n" +
		"		margin-right:0cm; \n" +
		"		margin-bottom:10.0pt; \n" +
		"		margin-left:0cm; \n" +
		"		line-height:115%; \n" +
		"		mso-pagination:widow-orphan; \n" +
		"		font-size:10.0pt; \n" +
		"		font-family:'Calibri','sans-serif'; \n" +
		"		mso-fareast-font-family:Calibri; \n" +
		"		mso-bidi-font-family:'Times New Roman'; \n" +
		"		mso-fareast-language:EN-US; \n" +
		"		font-weight:bold;} \n" +
		"	p.MsoAcetate, li.MsoAcetate, div.MsoAcetate \n" +
		"		{mso-style-noshow:yes; \n" +
		"		mso-style-priority:99; \n" +
		"		mso-style-link:'Texto de globo Car'; \n" +
		"		margin:0cm; \n" +
		"		margin-bottom:.0001pt; \n" +
		"		mso-pagination:widow-orphan; \n" +
		"		font-size:8.0pt; \n" +
		"		font-family:'Tahoma','sans-serif'; \n" +
		"		mso-fareast-font-family:Calibri; \n" +
		"		mso-fareast-language:EN-US;} \n" +
		"	p.MsoListParagraph, li.MsoListParagraph, div.MsoListParagraph \n" +
		"		{mso-style-priority:34; \n" +
		"		mso-style-unhide:no; \n" +
		"		mso-style-qformat:yes; \n" +
		"		margin-top:0cm; \n" +
		"		margin-right:0cm; \n" +
		"		margin-bottom:10.0pt; \n" +
		"		margin-left:36.0pt; \n" +
		"		mso-add-space:auto; \n" +
		"		line-height:115%; \n" +
		"		mso-pagination:widow-orphan; \n" +
		"		font-size:11.0pt; \n" +
		"		font-family:'Calibri','sans-serif'; \n" +
		"		mso-fareast-font-family:Calibri; \n" +
		"		mso-bidi-font-family:'Times New Roman'; \n" +
		"		mso-fareast-language:EN-US;} \n" +
		"	p.MsoListParagraphCxSpFirst, li.MsoListParagraphCxSpFirst, div.MsoListParagraphCxSpFirst \n" +
		"		{mso-style-priority:34; \n" +
		"		mso-style-unhide:no; \n" +
		"		mso-style-qformat:yes; \n" +
		"		mso-style-type:export-only; \n" +
		"		margin-top:0cm; \n" +
		"		margin-right:0cm; \n" +
		"		margin-bottom:0cm; \n" +
		"		margin-left:36.0pt; \n" +
		"		margin-bottom:.0001pt; \n" +
		"		mso-add-space:auto; \n" +
		"		line-height:115%; \n" +
		"		mso-pagination:widow-orphan; \n" +
		"		font-size:11.0pt; \n" +
		"		font-family:'Calibri','sans-serif'; \n" +
		"		mso-fareast-font-family:Calibri; \n" +
		"		mso-bidi-font-family:'Times New Roman'; \n" +
		"		mso-fareast-language:EN-US;} \n" +
		"	p.MsoListParagraphCxSpMiddle, li.MsoListParagraphCxSpMiddle, div.MsoListParagraphCxSpMiddle \n" +
		"		{mso-style-priority:34; \n" +
		"		mso-style-unhide:no; \n" +
		"		mso-style-qformat:yes; \n" +
		"		mso-style-type:export-only; \n" +
		"		margin-top:0cm; \n" +
		"		margin-right:0cm; \n" +
		"		margin-bottom:0cm; \n" +
		"		margin-left:36.0pt; \n" +
		"		margin-bottom:.0001pt; \n" +
		"		mso-add-space:auto; \n" +
		"		line-height:115%; \n" +
		"		mso-pagination:widow-orphan; \n" +
		"		font-size:11.0pt; \n" +
		"		font-family:'Calibri','sans-serif'; \n" +
		"		mso-fareast-font-family:Calibri; \n" +
		"		mso-bidi-font-family:'Times New Roman'; \n" +
		"		mso-fareast-language:EN-US;} \n" +
		"	p.MsoListParagraphCxSpLast, li.MsoListParagraphCxSpLast, div.MsoListParagraphCxSpLast \n" +
		"		{mso-style-priority:34; \n" +
		"		mso-style-unhide:no; \n" +
		"		mso-style-qformat:yes; \n" +
		"		mso-style-type:export-only; \n" +
		"		margin-top:0cm; \n" +
		"		margin-right:0cm; \n" +
		"		margin-bottom:10.0pt; \n" +
		"		margin-left:36.0pt; \n" +
		"		mso-add-space:auto; \n" +
		"		line-height:115%; \n" +
		"		mso-pagination:widow-orphan; \n" +
		"		font-size:11.0pt; \n" +
		"		font-family:'Calibri','sans-serif'; \n" +
		"		mso-fareast-font-family:Calibri; \n" +
		"		mso-bidi-font-family:'Times New Roman'; \n" +
		"		mso-fareast-language:EN-US;} \n" +
		"	span.TextodegloboCar \n" +
		"		{mso-style-name:'Texto de globo Car'; \n" +
		"		mso-style-noshow:yes; \n" +
		"		mso-style-priority:99; \n" +
		"		mso-style-unhide:no; \n" +
		"		mso-style-locked:yes; \n" +
		"		mso-style-link:'Texto de globo'; \n" +
		"		mso-ansi-font-size:8.0pt; \n" +
		"		mso-bidi-font-size:8.0pt; \n" +
		"		font-family:'Tahoma','sans-serif'; \n" +
		"		mso-ascii-font-family:Tahoma; \n" +
		"		mso-hansi-font-family:Tahoma; \n" +
		"		mso-bidi-font-family:Tahoma;} \n" +
		"	span.TextocomentarioCar \n" +
		"		{mso-style-name:'Texto comentario Car'; \n" +
		"		mso-style-noshow:yes; \n" +
		"		mso-style-priority:99; \n" +
		"		mso-style-unhide:no; \n" +
		"		mso-style-locked:yes; \n" +
		"		mso-style-link:'Texto comentario'; \n" +
		"		mso-fareast-language:EN-US;} \n" +
		"	span.AsuntodelcomentarioCar \n" +
		"		{mso-style-name:'Asunto del comentario Car'; \n" +
		"		mso-style-noshow:yes; \n" +
		"		mso-style-priority:99; \n" +
		"		mso-style-unhide:no; \n" +
		"		mso-style-locked:yes; \n" +
		"		mso-style-parent:'Texto comentario Car'; \n" +
		"		mso-style-link:'Asunto del comentario'; \n" +
		"		mso-fareast-language:EN-US; \n" +
		"		font-weight:bold;} \n" +
		"	span.SpellE \n" +
		"		{mso-style-name:''; \n" +
		"		mso-spl-e:yes;} \n" +
		"	.MsoChpDefault \n" +
		"		{mso-style-type:export-only; \n" +
		"		mso-default-props:yes; \n" +
		"		mso-ascii-font-family:Calibri; \n" +
		"		mso-fareast-font-family:Calibri; \n" +
		"		mso-hansi-font-family:Calibri;} \n" +
		"	@page WordSection1 \n" +
		"		{size:612.0pt 792.0pt; \n" +
		"		margin:70.85pt 3.0cm 70.85pt 3.0cm; \n" +
		"		mso-header-margin:35.4pt; \n" +
		"		mso-footer-margin:35.4pt; \n" +
		"		mso-paper-source:0;} \n" +
		"	div.WordSection1 \n" +
		"		{page:WordSection1;} \n" +
		 "	/* List Definitions */ \n" +
		 "	@list l0 \n" +
		"		{mso-list-id:697125077; \n" +
		"		mso-list-type:hybrid; \n" +
		"		mso-list-template-ids:-1644259862 134873103 134873113 134873115 134873103 134873113 134873115 134873103 134873113 134873115;} \n" +
		"	@list l0:level1 \n" +
		"		{mso-level-tab-stop:none; \n" +
		"		mso-level-number-position:left; \n" +
		"		text-indent:-18.0pt;} \n" +
		"	@list l1 \n" +
		"		{mso-list-id:1933122200; \n" +
		"		mso-list-type:hybrid; \n" +
		"		mso-list-template-ids:-1175787780 134873089 134873091 134873093 134873089 134873091 134873093 134873089 134873091 134873093;} \n" +
		"	@list l1:level1 \n" +
		"		{mso-level-number-format:bullet; \n" +
		"		mso-level-text:\\F0B7; \n" +
		"		mso-level-tab-stop:none; \n" +
		"		mso-level-number-position:left; \n" +
		"		text-indent:-18.0pt; \n" +
		"		font-family:Symbol;} \n" +
		"	ol \n" +
		"		{margin-bottom:0cm;} \n" +
		"	ul \n" +
		"		{margin-bottom:0cm;} \n" +
		"	--> \n" +
		"	</style> \n" +
		"	<!--[if gte mso 10]> \n" +
		"	<style> \n" +
		 "	/* Style Definitions */ \n" +
		 "	table.MsoNormalTable \n" +
		"		{mso-style-name:'Tabla normal'; \n" +
		"		mso-tstyle-rowband-size:0; \n" +
		"		mso-tstyle-colband-size:0; \n" +
		"		mso-style-noshow:yes; \n" +
		"		mso-style-priority:99; \n" +
		"		mso-style-qformat:yes; \n" +
		"		mso-style-parent:''; \n" +
		"		mso-padding-alt:0cm 5.4pt 0cm 5.4pt; \n" +
		"		mso-para-margin:0cm; \n" +
		"		mso-para-margin-bottom:.0001pt; \n" +
		"		mso-pagination:widow-orphan; \n" +
		"		font-size:10.0pt; \n" +
		"		font-family:'Calibri','sans-serif'; \n" +
		"		mso-bidi-font-family:'Times New Roman';} \n" +
		"	</style> \n" +
		"	<![endif]--><!--[if gte mso 9]><xml> \n" +
		"	 <o:shapedefaults v:ext='edit' spidmax='2050'/> \n" +
		"	</xml><![endif]--><!--[if gte mso 9]><xml> \n" +
		"	 <o:shapelayout v:ext='edit'> \n" +
		"	  <o:idmap v:ext='edit' data='1'/> \n" +
		"	 </o:shapelayout></xml><![endif]--> \n" +
		"	</head> \n" +
		"	 \n" +
		"	<body lang=ES-MX link=blue vlink=purple style='tab-interval:35.4pt'> \n" +
		"	 \n" +
		"	<div class=WordSection1> \n" +
		"	 \n" +
		"	<p class=MsoNormal><b><span lang=ES style='mso-ansi-language:ES'><o:p>&nbsp;</o:p></span></b></p> \n" +
		"	 \n" +
		"	<p class=MsoNormal align=center style='text-align:center'><b style='mso-bidi-font-weight: \n" +
		"	normal'><span style='mso-fareast-language:ES-MX;mso-no-proof:yes'><!--[if gte vml 1]><v:shapetype \n" +
		"	 id='_x0000_t75' coordsize='21600,21600' o:spt='75' o:preferrelative='t' \n" +
		"	 path='m@4@5l@4@11@9@11@9@5xe' filled='f' stroked='f'> \n" +
		"	 <v:stroke joinstyle='miter'/> \n" +
		"	 <v:formulas> \n" +
		"	  <v:f eqn='if lineDrawn pixelLineWidth 0'/> \n" +
		"	  <v:f eqn='sum @0 1 0'/> \n" +
		"	  <v:f eqn='sum 0 0 @1'/> \n" +
		"	  <v:f eqn='prod @2 1 2'/> \n" +
		"	  <v:f eqn='prod @3 21600 pixelWidth'/> \n" +
		"	  <v:f eqn='prod @3 21600 pixelHeight'/> \n" +
		"	  <v:f eqn='sum @0 0 1'/> \n" +
		"	  <v:f eqn='prod @6 1 2'/> \n" +
		"	  <v:f eqn='prod @7 21600 pixelWidth'/> \n" +
		"	  <v:f eqn='sum @8 21600 0'/> \n" +
		"	  <v:f eqn='prod @7 21600 pixelHeight'/> \n" +
		"	  <v:f eqn='sum @10 21600 0'/> \n" +
		"	 </v:formulas> \n" +
		"	 <v:path o:extrusionok='f' gradientshapeok='t' o:connecttype='rect'/> \n" +
		"	 <o:lock v:ext='edit' aspectratio='t'/> \n" +
		"	</v:shapetype><v:shape id='Imagen_x0020_1' o:spid='_x0000_i1025' type='#_x0000_t75' \n" +
		"	 style='width:232.5pt;height:116.25pt;visibility:visible'> \n" +
		"	 <v:imagedata src='http://173.203.12.186:9085/Imagenes/olab.jpg' \n" +
		"	  o:title=''/> \n" +
		"	</v:shape><![endif]--><![if !vml]><img width=310 height=155 \n" +
		"	src='Bienvenido%20estimado%20Paciente%20-%20Consulta%20de%20su%20Expediente%20Electronico_archivos/image002.jpg' \n" +
		"	v:shapes='Imagen_x0020_1'><![endif]></span></b><b><span lang=ES \n" +
		"	style='mso-ansi-language:ES'><o:p></o:p></span></b></p> \n" +
		"	 \n" +
		"	<p class=MsoNormal><b><span lang=ES style='mso-ansi-language:ES'>Bienvenido \n" +
		"	Apreciable: " + objPaciente.getSapellidopaterno() + " " + objPaciente.getSapellidomaterno() + " " + objPaciente.getSnombre() + "<o:p></o:p></span></b></p> \n" +
		"	 \n" +
		"	<p class=MsoNormal><span lang=ES style='mso-ansi-language:ES;mso-bidi-font-weight: \n" +
		"	bold'>Le damos la mas cordial bienvenida al servicio de consulta a su \n" +
		"	expediente clinico electronico, exclusivo de <span class=SpellE>Olab</span>. <span \n" +
		"	style='mso-spacerun:yes'> </span>Estos son los beneficios para usted:<o:p></o:p></span></p> \n" +
		"	 \n" +
		"	<p class=MsoListParagraphCxSpFirst style='text-indent:-18.0pt;mso-list:l1 level1 lfo1'><![if !supportLists]><span \n" +
		"	lang=ES style='font-family:Symbol;mso-fareast-font-family:Symbol;mso-bidi-font-family: \n" +
		"	Symbol;mso-ansi-language:ES;mso-bidi-font-weight:bold'><span style='mso-list: \n" +
		"	Ignore'>·<span style='font:7.0pt 'Times New Roman''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \n" +
		"	</span></span></span><![endif]><span lang=ES style='mso-ansi-language:ES; \n" +
		"	mso-bidi-font-weight:bold'>Verificar sus datos demograficos y de contacto.<o:p></o:p></span></p> \n" +
		"	 \n" +
		"	<p class=MsoListParagraphCxSpMiddle style='text-indent:-18.0pt;mso-list:l1 level1 lfo1'><![if !supportLists]><span \n" +
		"	lang=ES style='font-family:Symbol;mso-fareast-font-family:Symbol;mso-bidi-font-family: \n" +
		"	Symbol;mso-ansi-language:ES;mso-bidi-font-weight:bold'><span style='mso-list: \n" +
		"	Ignore'>·<span style='font:7.0pt 'Times New Roman''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \n" +
		"	</span></span></span><![endif]><span lang=ES style='mso-ansi-language:ES; \n" +
		"	mso-bidi-font-weight:bold'>Las fechas y numeros de ordenes de cada estudio que \n" +
		"	se ha realizado.<o:p></o:p></span></p> \n" +
		"	 \n" +
		"	<p class=MsoListParagraphCxSpMiddle style='text-indent:-18.0pt;mso-list:l1 level1 lfo1'><![if !supportLists]><span \n" +
		"	lang=ES style='font-family:Symbol;mso-fareast-font-family:Symbol;mso-bidi-font-family: \n" +
		"	Symbol;mso-ansi-language:ES;mso-bidi-font-weight:bold'><span style='mso-list: \n" +
		"	Ignore'>·<span style='font:7.0pt 'Times New Roman''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \n" +
		"	</span></span></span><![endif]><span lang=ES style='mso-ansi-language:ES; \n" +
		"	mso-bidi-font-weight:bold'>Imprimir sus resultados de Laboratorio, evitando \n" +
		"	traslados innecesarios.<o:p></o:p></span></p> \n" +
		"	 \n" +
		"	<p class=MsoListParagraphCxSpMiddle style='text-indent:-18.0pt;mso-list:l1 level1 lfo1'><![if !supportLists]><span \n" +
		"	lang=ES style='font-family:Symbol;mso-fareast-font-family:Symbol;mso-bidi-font-family: \n" +
		"	Symbol;mso-ansi-language:ES;mso-bidi-font-weight:bold'><span style='mso-list: \n" +
		"	Ignore'>·<span style='font:7.0pt 'Times New Roman''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \n" +
		"	</span></span></span><![endif]><span lang=ES style='mso-ansi-language:ES; \n" +
		"	mso-bidi-font-weight:bold'>Recibir en su correo electronico promociones y \n" +
		"	descuentos especiales.<o:p></o:p></span></p> \n" +
		"	 \n" +
		"	<p class=MsoListParagraphCxSpMiddle style='text-indent:-18.0pt;mso-list:l1 level1 lfo1'><![if !supportLists]><span \n" +
		"	lang=ES style='font-family:Symbol;mso-fareast-font-family:Symbol;mso-bidi-font-family: \n" +
		"	Symbol;mso-ansi-language:ES;mso-bidi-font-weight:bold'><span style='mso-list: \n" +
		"	Ignore'>·<span style='font:7.0pt 'Times New Roman''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \n" +
		"	</span></span></span><![endif]><span lang=ES style='mso-ansi-language:ES; \n" +
		"	mso-bidi-font-weight:bold'>Cotizar en linea nuevos estudios. (Proximamente)<o:p></o:p></span></p> \n" +
		"	 \n" +
		"	<p class=MsoListParagraphCxSpMiddle style='text-indent:-18.0pt;mso-list:l1 level1 lfo1'><![if !supportLists]><span \n" +
		"	lang=ES style='font-family:Symbol;mso-fareast-font-family:Symbol;mso-bidi-font-family: \n" +
		"	Symbol;mso-ansi-language:ES;mso-bidi-font-weight:bold'><span style='mso-list: \n" +
		"	Ignore'>·<span style='font:7.0pt 'Times New Roman''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \n" +
		"	</span></span></span><![endif]><span lang=ES style='mso-ansi-language:ES; \n" +
		"	mso-bidi-font-weight:bold'>Conocer las indicaciones previas para sus examenes. (Proximamente)<o:p></o:p></span></p> \n" +
		"	 \n" +
		"	<p class=MsoListParagraphCxSpLast style='text-indent:-18.0pt;mso-list:l1 level1 lfo1'><![if !supportLists]><span \n" +
		"	lang=ES style='font-family:Symbol;mso-fareast-font-family:Symbol;mso-bidi-font-family: \n" +
		"	Symbol;mso-ansi-language:ES;mso-bidi-font-weight:bold'><span style='mso-list: \n" +
		"	Ignore'>·<span style='font:7.0pt 'Times New Roman''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \n" +
		"	</span></span></span><![endif]><span lang=ES style='mso-ansi-language:ES; \n" +
		"	mso-bidi-font-weight:bold'>Eliminacion de filas y tiempos de espera, pague su \n" +
		"	orden por internet y solo presentese para la toma de la muestra. (Proximamente)<o:p></o:p></span></p> \n" +
		"	 \n" +
		"	<p class=MsoNormal>Acceso al Expediente Clinico Electronico, existen 2 opciones:</p> \n" +
		"	 \n" +
		"	<ol style='margin-top:0cm' start=1 type=1> \n" +
		"	 <li class=MsoNormal style='mso-list:l0 level1 lfo2'>Acceso directo, \n" +
		"	     solo copie o haga <span class=SpellE>click</span> sobre la siguiente \n" +
		"	     direccion electronica<b><span lang=ES style='mso-ansi-language:ES'>:<o:p></o:p></span></b></li> \n" +
		"	</ol> \n" +
		"	 \n" +
		"	<p class=MsoNormal><b><span lang=ES style='font-size:9.0pt;line-height:115%; \n" +
		"	mso-ansi-language:ES'><span style='mso-tab-count:1'>                </span><a \n" +
		"	href='http://173.203.12.186:8080/web2labportal/jsp/AccesoECE.jsp?strusername=" + objPaciente.getKpaciente() + "&strpassword=" + objPaciente.getSpassword().trim() + "'>Expediente " + objPaciente.getKpaciente() + "</a><o:p></o:p></span></b></p> \n" +
		"	 \n" +
		"	 \n" +
		"	<p class=MsoNormal><b><span lang=ES style='font-size:9.0pt;line-height:115%; \n" +
		"	mso-ansi-language:ES'><span style='mso-tab-count:1'></span> \n" +
		"	<o:p></o:p></span></b></p> \n" +
		"	 \n" +
		"	<p class=MsoNormal><b><span lang=ES style='font-size:9.0pt;line-height:115%; \n" +
		"	mso-ansi-language:ES'><span style='mso-tab-count:1'></span> \n" +
		"	<o:p></o:p></span></b></p> \n" +
		"	 \n" +
		"	<ol style='margin-top:0cm' start=1 type=1> \n" +
		"	 <li class=MsoNormal style='mso-list:l0 level1 lfo2'>Acceso en 3 pasos sencillos, \n" +
		"	     solo copie o haga <span class=SpellE>click</span> sobre la siguiente \n" +
		"	     direccion electronica<b><span lang=ES style='mso-ansi-language:ES'>:<o:p></o:p></span></b></li> \n" +
		"	</ol> \n" +
		"	 \n" +
		"	<p class=MsoNormal><b><span lang=ES style='font-size:9.0pt;line-height:115%; \n" +
		"	mso-ansi-language:ES'><span style='mso-tab-count:1'>                </span> \n" +
		"	<a href='www.infodiamex.com.mx/indexECE.html'>www.infodiamex.com.mx/indexECE.html</a><o:p></o:p></span></b></p> \n" +
		"	 \n" +
		"	<ol style='margin-top:0cm' start=2 type=1> \n" +
		"	 <li class=MsoNormal style='mso-list:l0 level1 lfo2'>En el espacio donde se \n" +
		"	     indica Numero de expediente, escriba su codigo de identificacion.<span \n" +
		"	     style='mso-spacerun:yes'>  </span></li> \n" +
		"	</ol> \n" +
		"	 \n" +
		"	<p class=MsoNormal><span style='mso-tab-count:1'>                </span>Este \n" +
		"	aparece en su hoja de resultados en la esquina superior izquierda<b><span \n" +
		"	lang=ES style='mso-ansi-language:ES'>: " + objPaciente.getKpaciente() + "</span></b></p> \n" +
		"	 \n" +
		"	<ol style='margin-top:0cm' start=3 type=1> \n" +
		"	 <li class=MsoNormal style='mso-list:l0 level1 lfo2'>En el espacio de \n" +
		"	     contraseña, escriba su numero<b><span lang=ES style='mso-ansi-language: \n" +
		"	     ES'>: " + objPaciente.getSpassword().trim() + "<o:p></o:p></span></b></li> \n" +
		"	</ol> \n" +
		"	 \n" +
		"	<p class=MsoNormal>Con estos sencillos pasos usted podra consultar sus datos y \n" +
		"	resultados de los estudios.<b><span lang=ES style='mso-ansi-language:ES'><o:p></o:p></span></b></p> \n" +
		"	 \n" +
		"	<p class=MsoNormal><span class=SpellE>Olab</span> garantiza la absoluta \n" +
		"	confidencialidad de sus datos, al contar con un inviolable sistema de seguridad<b><span \n" +
		"	lang=ES style='mso-ansi-language:ES'>.<o:p></o:p></span></b></p> \n" +
		"	 \n" +
		"	<p class=MsoNormal><b><span lang=ES style='mso-ansi-language:ES'>Olab es el \n" +
		"	primer Laboratorio Clinico en ofrecer la consulta del Expediente clinico \n" +
		"	electronico.<span style='mso-spacerun:yes'>  </span>Usted es la persona mas \n" +
		"	importante para todos quienes colaboramos en Olab.<o:p></o:p></span></b></p> \n" +
		"	 \n" +
		"	<p class=MsoNormal style='text-align:justify'><span lang=ES style='mso-ansi-language: \n" +
		"	ES;mso-bidi-font-weight:bold'>El formato original obra en poder<span \n" +
		"	style='mso-spacerun:yes'>  </span>de nuestras sucursales y si usted lo desea, \n" +
		"	lo podra recoger <span style='mso-spacerun:yes'> </span>en un periodo no mayor \n" +
		"	a los 3 meses de haber solicitado la orden.<o:p></o:p></span></p> \n" +
		"	 \n" +
		"	<p class=MsoNormal style='text-align:justify'><span lang=ES style='mso-ansi-language: \n" +
		"	ES;mso-bidi-font-weight:bold'>Este reporte electronico de resultados no \n" +
		"	sustituye al formato original. </span><span lang=ES style='mso-ansi-language: \n" +
		"	ES'><br> \n" +
		"	<br> \n" +
		"	&quot;<span style='mso-bidi-font-weight:bold'>Aviso Importante”</span>. En su \n" +
		"	empeño por brindarle mejores servicios, “OLAB Diagnosticos Medicos” (en lo \n" +
		"	sucesivo OLAB) a traves de este medio proporcionara los resultados de las \n" +
		"	pruebas de analisis clinicos practicadas en sus diferentes sucursales. OLAB no \n" +
		"	se hace responsable por cualquier modificacion o alteracion que la informacion \n" +
		"	aqui ofrecida pudiera sufrir por actos del paciente o de terceros, por lo que \n" +
		"	en caso de duda es responsabilidad del paciente y de su medico confrontar la \n" +
		"	informacion aqui obtenida con los resultados oficiales impresos por OLAB. <br> \n" +
		"	<br> \n" +
		"	OLAB en apego la Ley de Datos Personales, NO revelara, dara, vendera, donara o \n" +
		"	transmitira ningun tipo de informacion personal del paciente relacionada con \n" +
		"	los resultados de las pruebas clinicas practicadas, excepto cuando esta \n" +
		"	informacion sea solicitada por autoridad competente&quot; <br> \n" +
		"	<br> \n" +
		"	<span style='mso-bidi-font-weight:bold'>Recuerde que su medico es la unica \n" +
		"	persona con conocimiento y autoridad para interpretar sus resultados de laboratorio.</span><br> \n" +
		"	<br> \n" +
		"	<b style='mso-bidi-font-weight:normal'>Para cualquier duda o aclaracion, \n" +
		"	estamos a sus ordenes en el telefono: 4040-OLAB (6522)</b></span></p> \n" +
		"	 \n" +
		"	<p class=MsoNormal><a \n" +
		"	href='mailto:%20expedientelectronico_sugerencias@olab.com.mx'><span \n" +
		"	style='mso-spacerun:yes'> </span>expedientelectronico_sugerencias@olab.com.mx</a></p> \n" +
		"	 \n" +
		"	</div> \n" +
		"	 \n" +
		"	</body> \n" +
		"	 \n" +
		"	</html> \n";
	}		

	private String getFormatoECEEmpresaGDA2016(CConvenio objConvenio) {
		return "	<html xmlns:v='urn:schemas-microsoft-com:vml' \n" +
		"	xmlns:o='urn:schemas-microsoft-com:office:office' \n" +
		"	xmlns:w='urn:schemas-microsoft-com:office:word' \n" +
		"	xmlns:m='http://schemas.microsoft.com/office/2004/12/omml' \n" +
		"	xmlns='http://www.w3.org/TR/REC-html40'> \n" +
		"	 \n" +
		"	<head> \n" +
		"	<meta http-equiv=Content-Type content='text/html; charset=windows-1252'> \n" +
		"	<meta name=ProgId content=Word.Document> \n" +
		"	<meta name=Generator content='Microsoft Word 12'> \n" +
		"	<meta name=Originator content='Microsoft Word 12'> \n" +
		"	<link rel=File-List \n" +
		"	href='Bienvenido%20estimado%20Paciente%20-%20Consulta%20de%20su%20Expediente%20Electronico_archivos/filelist.xml'> \n" +
		"	<link rel=Edit-Time-Data \n" +
		"	href='Bienvenido%20estimado%20Paciente%20-%20Consulta%20de%20su%20Expediente%20Electronico_archivos/editdata.mso'> \n" +
		"	<!--[if !mso]> \n" +
		"	<style> \n" +
		"	v\\:* {behavior:url(#default#VML);} \n" +
		"	o\\:* {behavior:url(#default#VML);} \n" +
		"	w\\:* {behavior:url(#default#VML);} \n" +
		"	.shape {behavior:url(#default#VML);} \n" +
		"	</style> \n" +
		"	<![endif]--><!--[if gte mso 9]><xml> \n" +
		"	 <o:DocumentProperties> \n" +
		"	  <o:Author>orubio</o:Author> \n" +
		"	  <o:Template>Normal</o:Template> \n" +
		"	  <o:LastAuthor>orubio</o:LastAuthor> \n" +
		"	  <o:Revision>2</o:Revision> \n" +
		"	  <o:TotalTime>6</o:TotalTime> \n" +
		"	  <o:Created>2012-03-01T17:39:00Z</o:Created> \n" +
		"	  <o:LastSaved>2012-03-01T17:39:00Z</o:LastSaved> \n" +
		"	  <o:Pages>2</o:Pages> \n" +
		"	  <o:Words>470</o:Words> \n" +
		"	  <o:Characters>2588</o:Characters> \n" +
		"	  <o:Company>Toshiba</o:Company> \n" +
		"	  <o:Lines>21</o:Lines> \n" +
		"	  <o:Paragraphs>6</o:Paragraphs> \n" +
		"	  <o:CharactersWithSpaces>3052</o:CharactersWithSpaces> \n" +
		"	  <o:Version>12.00</o:Version> \n" +
		"	 </o:DocumentProperties> \n" +
		"	</xml><![endif]--> \n" +
		"	<link rel=themeData \n" +
		"	href='Bienvenido%20estimada%20Empresa%20-%20Consulta%20de%20su%20Expediente%20Electronico_archivos/themedata.thmx'> \n" +
		"	<link rel=colorSchemeMapping \n" +
		"	href='Bienvenido%20estimada%20Empresa%20-%20Consulta%20de%20su%20Expediente%20Electronico_archivos/colorschememapping.xml'> \n" +
		"	<!--[if gte mso 9]><xml> \n" +
		"	 <w:WordDocument> \n" +
		"	  <w:SpellingState>Clean</w:SpellingState> \n" +
		"	  <w:GrammarState>Clean</w:GrammarState> \n" +
		"	  <w:TrackMoves>false</w:TrackMoves> \n" +
		"	  <w:TrackFormatting/> \n" +
		"	  <w:HyphenationZone>21</w:HyphenationZone> \n" +
		"	  <w:PunctuationKerning/> \n" +
		"	  <w:ValidateAgainstSchemas/> \n" +
		"	  <w:SaveIfXMLInvalid>false</w:SaveIfXMLInvalid> \n" +
		"	  <w:IgnoreMixedContent>false</w:IgnoreMixedContent> \n" +
		"	  <w:AlwaysShowPlaceholderText>false</w:AlwaysShowPlaceholderText> \n" +
		"	  <w:DoNotPromoteQF/> \n" +
		"	  <w:LidThemeOther>ES-MX</w:LidThemeOther> \n" +
		"	  <w:LidThemeAsian>X-NONE</w:LidThemeAsian> \n" +
		"	  <w:LidThemeComplexScript>X-NONE</w:LidThemeComplexScript> \n" +
		"	  <w:Compatibility> \n" +
		"	   <w:BreakWrappedTables/> \n" +
		"	   <w:SnapToGridInCell/> \n" +
		"	   <w:WrapTextWithPunct/> \n" +
		"	   <w:UseAsianBreakRules/> \n" +
		"	   <w:DontGrowAutofit/> \n" +
		"	   <w:DontUseIndentAsNumberingTabStop/> \n" +
		"	   <w:FELineBreak11/> \n" +
		"	   <w:WW11IndentRules/> \n" +
		"	   <w:DontAutofitConstrainedTables/> \n" +
		"	   <w:AutofitLikeWW11/> \n" +
		"	   <w:HangulWidthLikeWW11/> \n" +
		"	   <w:UseNormalStyleForList/> \n" +
		"	  </w:Compatibility> \n" +
		"	  <w:BrowserLevel>MicrosoftInternetExplorer4</w:BrowserLevel> \n" +
		"	  <m:mathPr> \n" +
		"	   <m:mathFont m:val='Cambria Math'/> \n" +
		"	   <m:brkBin m:val='before'/> \n" +
		"	   <m:brkBinSub m:val='&#45;-'/> \n" +
		"	   <m:smallFrac m:val='off'/> \n" +
		"	   <m:dispDef/> \n" +
		"	   <m:lMargin m:val='0'/> \n" +
		"	   <m:rMargin m:val='0'/> \n" +
		"	   <m:defJc m:val='centerGroup'/> \n" +
		"	   <m:wrapIndent m:val='1440'/> \n" +
		"	   <m:intLim m:val='subSup'/> \n" +
		"	   <m:naryLim m:val='undOvr'/> \n" +
		"	  </m:mathPr></w:WordDocument> \n" +
		"	</xml><![endif]--><!--[if gte mso 9]><xml> \n" +
		"	 <w:LatentStyles DefLockedState='false' DefUnhideWhenUsed='true' \n" +
		"	  DefSemiHidden='true' DefQFormat='false' DefPriority='99' \n" +
		"	  LatentStyleCount='267'> \n" +
		"	  <w:LsdException Locked='false' Priority='0' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' QFormat='true' Name='Normal'/> \n" +
		"	  <w:LsdException Locked='false' Priority='9' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' QFormat='true' Name='heading 1'/> \n" +
		"	  <w:LsdException Locked='false' Priority='9' QFormat='true' Name='heading 2'/> \n" +
		"	  <w:LsdException Locked='false' Priority='9' QFormat='true' Name='heading 3'/> \n" +
		"	  <w:LsdException Locked='false' Priority='9' QFormat='true' Name='heading 4'/> \n" +
		"	  <w:LsdException Locked='false' Priority='9' QFormat='true' Name='heading 5'/> \n" +
		"	  <w:LsdException Locked='false' Priority='9' QFormat='true' Name='heading 6'/> \n" +
		"	  <w:LsdException Locked='false' Priority='9' QFormat='true' Name='heading 7'/> \n" +
		"	  <w:LsdException Locked='false' Priority='9' QFormat='true' Name='heading 8'/> \n" +
		"	  <w:LsdException Locked='false' Priority='9' QFormat='true' Name='heading 9'/> \n" +
		"	  <w:LsdException Locked='false' Priority='39' Name='toc 1'/> \n" +
		"	  <w:LsdException Locked='false' Priority='39' Name='toc 2'/> \n" +
		"	  <w:LsdException Locked='false' Priority='39' Name='toc 3'/> \n" +
		"	  <w:LsdException Locked='false' Priority='39' Name='toc 4'/> \n" +
		"	  <w:LsdException Locked='false' Priority='39' Name='toc 5'/> \n" +
		"	  <w:LsdException Locked='false' Priority='39' Name='toc 6'/> \n" +
		"	  <w:LsdException Locked='false' Priority='39' Name='toc 7'/> \n" +
		"	  <w:LsdException Locked='false' Priority='39' Name='toc 8'/> \n" +
		"	  <w:LsdException Locked='false' Priority='39' Name='toc 9'/> \n" +
		"	  <w:LsdException Locked='false' Priority='35' QFormat='true' Name='caption'/> \n" +
		"	  <w:LsdException Locked='false' Priority='10' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' QFormat='true' Name='Title'/> \n" +
		"	  <w:LsdException Locked='false' Priority='1' Name='Default Paragraph Font'/> \n" +
		"	  <w:LsdException Locked='false' Priority='11' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' QFormat='true' Name='Subtitle'/> \n" +
		"	  <w:LsdException Locked='false' Priority='22' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' QFormat='true' Name='Strong'/> \n" +
		"	  <w:LsdException Locked='false' Priority='20' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' QFormat='true' Name='Emphasis'/> \n" +
		"	  <w:LsdException Locked='false' Priority='59' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Table Grid'/> \n" +
		"	  <w:LsdException Locked='false' UnhideWhenUsed='false' Name='Placeholder Text'/> \n" +
		"	  <w:LsdException Locked='false' Priority='1' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' QFormat='true' Name='No Spacing'/> \n" +
		"	  <w:LsdException Locked='false' Priority='60' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light Shading'/> \n" +
		"	  <w:LsdException Locked='false' Priority='61' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light List'/> \n" +
		"	  <w:LsdException Locked='false' Priority='62' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light Grid'/> \n" +
		"	  <w:LsdException Locked='false' Priority='63' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Shading 1'/> \n" +
		"	  <w:LsdException Locked='false' Priority='64' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Shading 2'/> \n" +
		"	  <w:LsdException Locked='false' Priority='65' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium List 1'/> \n" +
		"	  <w:LsdException Locked='false' Priority='66' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium List 2'/> \n" +
		"	  <w:LsdException Locked='false' Priority='67' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 1'/> \n" +
		"	  <w:LsdException Locked='false' Priority='68' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 2'/> \n" +
		"	  <w:LsdException Locked='false' Priority='69' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 3'/> \n" +
		"	  <w:LsdException Locked='false' Priority='70' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Dark List'/> \n" +
		"	  <w:LsdException Locked='false' Priority='71' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful Shading'/> \n" +
		"	  <w:LsdException Locked='false' Priority='72' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful List'/> \n" +
		"	  <w:LsdException Locked='false' Priority='73' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful Grid'/> \n" +
		"	  <w:LsdException Locked='false' Priority='60' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light Shading Accent 1'/> \n" +
		"	  <w:LsdException Locked='false' Priority='61' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light List Accent 1'/> \n" +
		"	  <w:LsdException Locked='false' Priority='62' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light Grid Accent 1'/> \n" +
		"	  <w:LsdException Locked='false' Priority='63' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Shading 1 Accent 1'/> \n" +
		"	  <w:LsdException Locked='false' Priority='64' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Shading 2 Accent 1'/> \n" +
		"	  <w:LsdException Locked='false' Priority='65' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium List 1 Accent 1'/> \n" +
		"	  <w:LsdException Locked='false' UnhideWhenUsed='false' Name='Revision'/> \n" +
		"	  <w:LsdException Locked='false' Priority='34' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' QFormat='true' Name='List Paragraph'/> \n" +
		"	  <w:LsdException Locked='false' Priority='29' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' QFormat='true' Name='Quote'/> \n" +
		"	  <w:LsdException Locked='false' Priority='30' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' QFormat='true' Name='Intense Quote'/> \n" +
		"	  <w:LsdException Locked='false' Priority='66' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium List 2 Accent 1'/> \n" +
		"	  <w:LsdException Locked='false' Priority='67' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 1 Accent 1'/> \n" +
		"	  <w:LsdException Locked='false' Priority='68' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 2 Accent 1'/> \n" +
		"	  <w:LsdException Locked='false' Priority='69' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 3 Accent 1'/> \n" +
		"	  <w:LsdException Locked='false' Priority='70' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Dark List Accent 1'/> \n" +
		"	  <w:LsdException Locked='false' Priority='71' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful Shading Accent 1'/> \n" +
		"	  <w:LsdException Locked='false' Priority='72' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful List Accent 1'/> \n" +
		"	  <w:LsdException Locked='false' Priority='73' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful Grid Accent 1'/> \n" +
		"	  <w:LsdException Locked='false' Priority='60' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light Shading Accent 2'/> \n" +
		"	  <w:LsdException Locked='false' Priority='61' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light List Accent 2'/> \n" +
		"	  <w:LsdException Locked='false' Priority='62' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light Grid Accent 2'/> \n" +
		"	  <w:LsdException Locked='false' Priority='63' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Shading 1 Accent 2'/> \n" +
		"	  <w:LsdException Locked='false' Priority='64' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Shading 2 Accent 2'/> \n" +
		"	  <w:LsdException Locked='false' Priority='65' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium List 1 Accent 2'/> \n" +
		"	  <w:LsdException Locked='false' Priority='66' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium List 2 Accent 2'/> \n" +
		"	  <w:LsdException Locked='false' Priority='67' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 1 Accent 2'/> \n" +
		"	  <w:LsdException Locked='false' Priority='68' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 2 Accent 2'/> \n" +
		"	  <w:LsdException Locked='false' Priority='69' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 3 Accent 2'/> \n" +
		"	  <w:LsdException Locked='false' Priority='70' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Dark List Accent 2'/> \n" +
		"	  <w:LsdException Locked='false' Priority='71' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful Shading Accent 2'/> \n" +
		"	  <w:LsdException Locked='false' Priority='72' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful List Accent 2'/> \n" +
		"	  <w:LsdException Locked='false' Priority='73' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful Grid Accent 2'/> \n" +
		"	  <w:LsdException Locked='false' Priority='60' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light Shading Accent 3'/> \n" +
		"	  <w:LsdException Locked='false' Priority='61' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light List Accent 3'/> \n" +
		"	  <w:LsdException Locked='false' Priority='62' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light Grid Accent 3'/> \n" +
		"	  <w:LsdException Locked='false' Priority='63' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Shading 1 Accent 3'/> \n" +
		"	  <w:LsdException Locked='false' Priority='64' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Shading 2 Accent 3'/> \n" +
		"	  <w:LsdException Locked='false' Priority='65' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium List 1 Accent 3'/> \n" +
		"	  <w:LsdException Locked='false' Priority='66' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium List 2 Accent 3'/> \n" +
		"	  <w:LsdException Locked='false' Priority='67' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 1 Accent 3'/> \n" +
		"	  <w:LsdException Locked='false' Priority='68' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 2 Accent 3'/> \n" +
		"	  <w:LsdException Locked='false' Priority='69' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 3 Accent 3'/> \n" +
		"	  <w:LsdException Locked='false' Priority='70' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Dark List Accent 3'/> \n" +
		"	  <w:LsdException Locked='false' Priority='71' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful Shading Accent 3'/> \n" +
		"	  <w:LsdException Locked='false' Priority='72' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful List Accent 3'/> \n" +
		"	  <w:LsdException Locked='false' Priority='73' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful Grid Accent 3'/> \n" +
		"	  <w:LsdException Locked='false' Priority='60' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light Shading Accent 4'/> \n" +
		"	  <w:LsdException Locked='false' Priority='61' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light List Accent 4'/> \n" +
		"	  <w:LsdException Locked='false' Priority='62' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light Grid Accent 4'/> \n" +
		"	  <w:LsdException Locked='false' Priority='63' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Shading 1 Accent 4'/> \n" +
		"	  <w:LsdException Locked='false' Priority='64' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Shading 2 Accent 4'/> \n" +
		"	  <w:LsdException Locked='false' Priority='65' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium List 1 Accent 4'/> \n" +
		"	  <w:LsdException Locked='false' Priority='66' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium List 2 Accent 4'/> \n" +
		"	  <w:LsdException Locked='false' Priority='67' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 1 Accent 4'/> \n" +
		"	  <w:LsdException Locked='false' Priority='68' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 2 Accent 4'/> \n" +
		"	  <w:LsdException Locked='false' Priority='69' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 3 Accent 4'/> \n" +
		"	  <w:LsdException Locked='false' Priority='70' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Dark List Accent 4'/> \n" +
		"	  <w:LsdException Locked='false' Priority='71' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful Shading Accent 4'/> \n" +
		"	  <w:LsdException Locked='false' Priority='72' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful List Accent 4'/> \n" +
		"	  <w:LsdException Locked='false' Priority='73' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful Grid Accent 4'/> \n" +
		"	  <w:LsdException Locked='false' Priority='60' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light Shading Accent 5'/> \n" +
		"	  <w:LsdException Locked='false' Priority='61' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light List Accent 5'/> \n" +
		"	  <w:LsdException Locked='false' Priority='62' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light Grid Accent 5'/> \n" +
		"	  <w:LsdException Locked='false' Priority='63' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Shading 1 Accent 5'/> \n" +
		"	  <w:LsdException Locked='false' Priority='64' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Shading 2 Accent 5'/> \n" +
		"	  <w:LsdException Locked='false' Priority='65' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium List 1 Accent 5'/> \n" +
		"	  <w:LsdException Locked='false' Priority='66' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium List 2 Accent 5'/> \n" +
		"	  <w:LsdException Locked='false' Priority='67' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 1 Accent 5'/> \n" +
		"	  <w:LsdException Locked='false' Priority='68' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 2 Accent 5'/> \n" +
		"	  <w:LsdException Locked='false' Priority='69' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 3 Accent 5'/> \n" +
		"	  <w:LsdException Locked='false' Priority='70' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Dark List Accent 5'/> \n" +
		"	  <w:LsdException Locked='false' Priority='71' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful Shading Accent 5'/> \n" +
		"	  <w:LsdException Locked='false' Priority='72' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful List Accent 5'/> \n" +
		"	  <w:LsdException Locked='false' Priority='73' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful Grid Accent 5'/> \n" +
		"	  <w:LsdException Locked='false' Priority='60' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light Shading Accent 6'/> \n" +
		"	  <w:LsdException Locked='false' Priority='61' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light List Accent 6'/> \n" +
		"	  <w:LsdException Locked='false' Priority='62' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Light Grid Accent 6'/> \n" +
		"	  <w:LsdException Locked='false' Priority='63' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Shading 1 Accent 6'/> \n" +
		"	  <w:LsdException Locked='false' Priority='64' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Shading 2 Accent 6'/> \n" +
		"	  <w:LsdException Locked='false' Priority='65' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium List 1 Accent 6'/> \n" +
		"	  <w:LsdException Locked='false' Priority='66' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium List 2 Accent 6'/> \n" +
		"	  <w:LsdException Locked='false' Priority='67' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 1 Accent 6'/> \n" +
		"	  <w:LsdException Locked='false' Priority='68' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 2 Accent 6'/> \n" +
		"	  <w:LsdException Locked='false' Priority='69' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Medium Grid 3 Accent 6'/> \n" +
		"	  <w:LsdException Locked='false' Priority='70' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Dark List Accent 6'/> \n" +
		"	  <w:LsdException Locked='false' Priority='71' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful Shading Accent 6'/> \n" +
		"	  <w:LsdException Locked='false' Priority='72' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful List Accent 6'/> \n" +
		"	  <w:LsdException Locked='false' Priority='73' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' Name='Colorful Grid Accent 6'/> \n" +
		"	  <w:LsdException Locked='false' Priority='19' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' QFormat='true' Name='Subtle Emphasis'/> \n" +
		"	  <w:LsdException Locked='false' Priority='21' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' QFormat='true' Name='Intense Emphasis'/> \n" +
		"	  <w:LsdException Locked='false' Priority='31' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' QFormat='true' Name='Subtle Reference'/> \n" +
		"	  <w:LsdException Locked='false' Priority='32' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' QFormat='true' Name='Intense Reference'/> \n" +
		"	  <w:LsdException Locked='false' Priority='33' SemiHidden='false' \n" +
		"	   UnhideWhenUsed='false' QFormat='true' Name='Book Title'/> \n" +
		"	  <w:LsdException Locked='false' Priority='37' Name='Bibliography'/> \n" +
		"	  <w:LsdException Locked='false' Priority='39' QFormat='true' Name='TOC Heading'/> \n" +
		"	 </w:LatentStyles> \n" +
		"	</xml><![endif]--> \n" +
		"	<style> \n" +
		"	<!-- \n" +
		"	 /* Font Definitions */ \n" +
		"	 @font-face \n" +
		"		{font-family:Wingdings; \n" +
		"		panose-1:5 0 0 0 0 0 0 0 0 0; \n" +
		"		mso-font-charset:2; \n" +
		"		mso-generic-font-family:auto; \n" +
		"		mso-font-pitch:variable; \n" +
		"		mso-font-signature:0 268435456 0 0 -2147483648 0;} \n" +
		"	@font-face \n" +
		"		{font-family:'Cambria Math'; \n" +
		"		panose-1:2 4 5 3 5 4 6 3 2 4; \n" +
		"		mso-font-charset:0; \n" +
		"		mso-generic-font-family:roman; \n" +
		"		mso-font-pitch:variable; \n" +
		"		mso-font-signature:-536870145 1107305727 0 0 415 0;} \n" +
		"	@font-face \n" +
		"		{font-family:Calibri; \n" +
		"		panose-1:2 15 5 2 2 2 4 3 2 4; \n" +
		"		mso-font-charset:0; \n" +
		"		mso-generic-font-family:swiss; \n" +
		"		mso-font-pitch:variable; \n" +
		"		mso-font-signature:-520092929 1073786111 9 0 415 0;} \n" +
		"	@font-face \n" +
		"		{font-family:Tahoma; \n" +
		"		panose-1:2 11 6 4 3 5 4 4 2 4; \n" +
		"		mso-font-charset:0; \n" +
		"		mso-generic-font-family:swiss; \n" +
		"		mso-font-pitch:variable; \n" +
		"		mso-font-signature:-520081665 -1073717157 41 0 66047 0;} \n" +
		"	 /* Style Definitions */ \n" +
		"	 p.MsoNormal, li.MsoNormal, div.MsoNormal \n" +
		"		{mso-style-unhide:no; \n" +
		"		mso-style-qformat:yes; \n" +
		"		mso-style-parent:''; \n" +
		"		margin-top:0cm; \n" +
		"		margin-right:0cm; \n" +
		"		margin-bottom:10.0pt; \n" +
		"		margin-left:0cm; \n" +
		"		line-height:115%; \n" +
		"		mso-pagination:widow-orphan; \n" +
		"		font-size:11.0pt; \n" +
		"		font-family:'Calibri','sans-serif'; \n" +
		"		mso-fareast-font-family:Calibri; \n" +
		"		mso-bidi-font-family:'Times New Roman'; \n" +
		"		mso-fareast-language:EN-US;} \n" +
		"	p.MsoCommentText, li.MsoCommentText, div.MsoCommentText \n" +
		"		{mso-style-noshow:yes; \n" +
		"		mso-style-priority:99; \n" +
		"		mso-style-link:'Texto comentario Car'; \n" +
		"		margin-top:0cm; \n" +
		"		margin-right:0cm; \n" +
		"		margin-bottom:10.0pt; \n" +
		"		margin-left:0cm; \n" +
		"		line-height:115%; \n" +
		"		mso-pagination:widow-orphan; \n" +
		"		font-size:10.0pt; \n" +
		"		font-family:'Calibri','sans-serif'; \n" +
		"		mso-fareast-font-family:Calibri; \n" +
		"		mso-bidi-font-family:'Times New Roman'; \n" +
		"		mso-fareast-language:EN-US;} \n" +
		"	span.MsoCommentReference \n" +
		"		{mso-style-noshow:yes; \n" +
		"		mso-style-priority:99; \n" +
		"		mso-ansi-font-size:8.0pt; \n" +
		"		mso-bidi-font-size:8.0pt;} \n" +
		"	a:link, span.MsoHyperlink \n" +
		"		{mso-style-priority:99; \n" +
		"		color:blue; \n" +
		"		text-decoration:underline; \n" +
		"		text-underline:single;} \n" +
		"	a:visited, span.MsoHyperlinkFollowed \n" +
		"		{mso-style-noshow:yes; \n" +
		"		mso-style-priority:99; \n" +
		"		color:purple; \n" +
		"		mso-themecolor:followedhyperlink; \n" +
		"		text-decoration:underline; \n" +
		"		text-underline:single;} \n" +
		"	p.MsoCommentSubject, li.MsoCommentSubject, div.MsoCommentSubject \n" +
		"		{mso-style-noshow:yes; \n" +
		"		mso-style-priority:99; \n" +
		"		mso-style-parent:'Texto comentario'; \n" +
		"		mso-style-link:'Asunto del comentario Car'; \n" +
		"		mso-style-next:'Texto comentario'; \n" +
		"		margin-top:0cm; \n" +
		"		margin-right:0cm; \n" +
		"		margin-bottom:10.0pt; \n" +
		"		margin-left:0cm; \n" +
		"		line-height:115%; \n" +
		"		mso-pagination:widow-orphan; \n" +
		"		font-size:10.0pt; \n" +
		"		font-family:'Calibri','sans-serif'; \n" +
		"		mso-fareast-font-family:Calibri; \n" +
		"		mso-bidi-font-family:'Times New Roman'; \n" +
		"		mso-fareast-language:EN-US; \n" +
		"		font-weight:bold;} \n" +
		"	p.MsoAcetate, li.MsoAcetate, div.MsoAcetate \n" +
		"		{mso-style-noshow:yes; \n" +
		"		mso-style-priority:99; \n" +
		"		mso-style-link:'Texto de globo Car'; \n" +
		"		margin:0cm; \n" +
		"		margin-bottom:.0001pt; \n" +
		"		mso-pagination:widow-orphan; \n" +
		"		font-size:8.0pt; \n" +
		"		font-family:'Tahoma','sans-serif'; \n" +
		"		mso-fareast-font-family:Calibri; \n" +
		"		mso-fareast-language:EN-US;} \n" +
		"	p.MsoListParagraph, li.MsoListParagraph, div.MsoListParagraph \n" +
		"		{mso-style-priority:34; \n" +
		"		mso-style-unhide:no; \n" +
		"		mso-style-qformat:yes; \n" +
		"		margin-top:0cm; \n" +
		"		margin-right:0cm; \n" +
		"		margin-bottom:10.0pt; \n" +
		"		margin-left:36.0pt; \n" +
		"		mso-add-space:auto; \n" +
		"		line-height:115%; \n" +
		"		mso-pagination:widow-orphan; \n" +
		"		font-size:11.0pt; \n" +
		"		font-family:'Calibri','sans-serif'; \n" +
		"		mso-fareast-font-family:Calibri; \n" +
		"		mso-bidi-font-family:'Times New Roman'; \n" +
		"		mso-fareast-language:EN-US;} \n" +
		"	p.MsoListParagraphCxSpFirst, li.MsoListParagraphCxSpFirst, div.MsoListParagraphCxSpFirst \n" +
		"		{mso-style-priority:34; \n" +
		"		mso-style-unhide:no; \n" +
		"		mso-style-qformat:yes; \n" +
		"		mso-style-type:export-only; \n" +
		"		margin-top:0cm; \n" +
		"		margin-right:0cm; \n" +
		"		margin-bottom:0cm; \n" +
		"		margin-left:36.0pt; \n" +
		"		margin-bottom:.0001pt; \n" +
		"		mso-add-space:auto; \n" +
		"		line-height:115%; \n" +
		"		mso-pagination:widow-orphan; \n" +
		"		font-size:11.0pt; \n" +
		"		font-family:'Calibri','sans-serif'; \n" +
		"		mso-fareast-font-family:Calibri; \n" +
		"		mso-bidi-font-family:'Times New Roman'; \n" +
		"		mso-fareast-language:EN-US;} \n" +
		"	p.MsoListParagraphCxSpMiddle, li.MsoListParagraphCxSpMiddle, div.MsoListParagraphCxSpMiddle \n" +
		"		{mso-style-priority:34; \n" +
		"		mso-style-unhide:no; \n" +
		"		mso-style-qformat:yes; \n" +
		"		mso-style-type:export-only; \n" +
		"		margin-top:0cm; \n" +
		"		margin-right:0cm; \n" +
		"		margin-bottom:0cm; \n" +
		"		margin-left:36.0pt; \n" +
		"		margin-bottom:.0001pt; \n" +
		"		mso-add-space:auto; \n" +
		"		line-height:115%; \n" +
		"		mso-pagination:widow-orphan; \n" +
		"		font-size:11.0pt; \n" +
		"		font-family:'Calibri','sans-serif'; \n" +
		"		mso-fareast-font-family:Calibri; \n" +
		"		mso-bidi-font-family:'Times New Roman'; \n" +
		"		mso-fareast-language:EN-US;} \n" +
		"	p.MsoListParagraphCxSpLast, li.MsoListParagraphCxSpLast, div.MsoListParagraphCxSpLast \n" +
		"		{mso-style-priority:34; \n" +
		"		mso-style-unhide:no; \n" +
		"		mso-style-qformat:yes; \n" +
		"		mso-style-type:export-only; \n" +
		"		margin-top:0cm; \n" +
		"		margin-right:0cm; \n" +
		"		margin-bottom:10.0pt; \n" +
		"		margin-left:36.0pt; \n" +
		"		mso-add-space:auto; \n" +
		"		line-height:115%; \n" +
		"		mso-pagination:widow-orphan; \n" +
		"		font-size:11.0pt; \n" +
		"		font-family:'Calibri','sans-serif'; \n" +
		"		mso-fareast-font-family:Calibri; \n" +
		"		mso-bidi-font-family:'Times New Roman'; \n" +
		"		mso-fareast-language:EN-US;} \n" +
		"	span.TextodegloboCar \n" +
		"		{mso-style-name:'Texto de globo Car'; \n" +
		"		mso-style-noshow:yes; \n" +
		"		mso-style-priority:99; \n" +
		"		mso-style-unhide:no; \n" +
		"		mso-style-locked:yes; \n" +
		"		mso-style-link:'Texto de globo'; \n" +
		"		mso-ansi-font-size:8.0pt; \n" +
		"		mso-bidi-font-size:8.0pt; \n" +
		"		font-family:'Tahoma','sans-serif'; \n" +
		"		mso-ascii-font-family:Tahoma; \n" +
		"		mso-hansi-font-family:Tahoma; \n" +
		"		mso-bidi-font-family:Tahoma;} \n" +
		"	span.TextocomentarioCar \n" +
		"		{mso-style-name:'Texto comentario Car'; \n" +
		"		mso-style-noshow:yes; \n" +
		"		mso-style-priority:99; \n" +
		"		mso-style-unhide:no; \n" +
		"		mso-style-locked:yes; \n" +
		"		mso-style-link:'Texto comentario'; \n" +
		"		mso-fareast-language:EN-US;} \n" +
		"	span.AsuntodelcomentarioCar \n" +
		"		{mso-style-name:'Asunto del comentario Car'; \n" +
		"		mso-style-noshow:yes; \n" +
		"		mso-style-priority:99; \n" +
		"		mso-style-unhide:no; \n" +
		"		mso-style-locked:yes; \n" +
		"		mso-style-parent:'Texto comentario Car'; \n" +
		"		mso-style-link:'Asunto del comentario'; \n" +
		"		mso-fareast-language:EN-US; \n" +
		"		font-weight:bold;} \n" +
		"	span.SpellE \n" +
		"		{mso-style-name:''; \n" +
		"		mso-spl-e:yes;} \n" +
		"	.MsoChpDefault \n" +
		"		{mso-style-type:export-only; \n" +
		"		mso-default-props:yes; \n" +
		"		mso-ascii-font-family:Calibri; \n" +
		"		mso-fareast-font-family:Calibri; \n" +
		"		mso-hansi-font-family:Calibri;} \n" +
		"	@page WordSection1 \n" +
		"		{size:612.0pt 792.0pt; \n" +
		"		margin:70.85pt 3.0cm 70.85pt 3.0cm; \n" +
		"		mso-header-margin:35.4pt; \n" +
		"		mso-footer-margin:35.4pt; \n" +
		"		mso-paper-source:0;} \n" +
		"	div.WordSection1 \n" +
		"		{page:WordSection1;} \n" +
		 "	/* List Definitions */ \n" +
		 "	@list l0 \n" +
		"		{mso-list-id:697125077; \n" +
		"		mso-list-type:hybrid; \n" +
		"		mso-list-template-ids:-1644259862 134873103 134873113 134873115 134873103 134873113 134873115 134873103 134873113 134873115;} \n" +
		"	@list l0:level1 \n" +
		"		{mso-level-tab-stop:none; \n" +
		"		mso-level-number-position:left; \n" +
		"		text-indent:-18.0pt;} \n" +
		"	@list l1 \n" +
		"		{mso-list-id:1933122200; \n" +
		"		mso-list-type:hybrid; \n" +
		"		mso-list-template-ids:-1175787780 134873089 134873091 134873093 134873089 134873091 134873093 134873089 134873091 134873093;} \n" +
		"	@list l1:level1 \n" +
		"		{mso-level-number-format:bullet; \n" +
		"		mso-level-text:\\F0B7; \n" +
		"		mso-level-tab-stop:none; \n" +
		"		mso-level-number-position:left; \n" +
		"		text-indent:-18.0pt; \n" +
		"		font-family:Symbol;} \n" +
		"	ol \n" +
		"		{margin-bottom:0cm;} \n" +
		"	ul \n" +
		"		{margin-bottom:0cm;} \n" +
		"	--> \n" +
		"	</style> \n" +
		"	<!--[if gte mso 10]> \n" +
		"	<style> \n" +
		 "	/* Style Definitions */ \n" +
		 "	table.MsoNormalTable \n" +
		"		{mso-style-name:'Tabla normal'; \n" +
		"		mso-tstyle-rowband-size:0; \n" +
		"		mso-tstyle-colband-size:0; \n" +
		"		mso-style-noshow:yes; \n" +
		"		mso-style-priority:99; \n" +
		"		mso-style-qformat:yes; \n" +
		"		mso-style-parent:''; \n" +
		"		mso-padding-alt:0cm 5.4pt 0cm 5.4pt; \n" +
		"		mso-para-margin:0cm; \n" +
		"		mso-para-margin-bottom:.0001pt; \n" +
		"		mso-pagination:widow-orphan; \n" +
		"		font-size:10.0pt; \n" +
		"		font-family:'Calibri','sans-serif'; \n" +
		"		mso-bidi-font-family:'Times New Roman';} \n" +
		"	</style> \n" +
		"	<![endif]--><!--[if gte mso 9]><xml> \n" +
		"	 <o:shapedefaults v:ext='edit' spidmax='2050'/> \n" +
		"	</xml><![endif]--><!--[if gte mso 9]><xml> \n" +
		"	 <o:shapelayout v:ext='edit'> \n" +
		"	  <o:idmap v:ext='edit' data='1'/> \n" +
		"	 </o:shapelayout></xml><![endif]--> \n" +
		"	</head> \n" +
		"	 \n" +
		"	<body lang=ES-MX link=blue vlink=purple style='tab-interval:35.4pt'> \n" +
		"	 \n" +
		"	<div class=WordSection1> \n" +
		"	 \n" +
		"	<p class=MsoNormal><b><span lang=ES style='mso-ansi-language:ES'><o:p>&nbsp;</o:p></span></b></p> \n" +
		"	 \n" +
		"	<p class=MsoNormal align=center style='text-align:center'><b style='mso-bidi-font-weight: \n" +
		"	normal'><span style='mso-fareast-language:ES-MX;mso-no-proof:yes'><!--[if gte vml 1]><v:shapetype \n" +
		"	 id='_x0000_t75' coordsize='21600,21600' o:spt='75' o:preferrelative='t' \n" +
		"	 path='m@4@5l@4@11@9@11@9@5xe' filled='f' stroked='f'> \n" +
		"	 <v:stroke joinstyle='miter'/> \n" +
		"	 <v:formulas> \n" +
		"	  <v:f eqn='if lineDrawn pixelLineWidth 0'/> \n" +
		"	  <v:f eqn='sum @0 1 0'/> \n" +
		"	  <v:f eqn='sum 0 0 @1'/> \n" +
		"	  <v:f eqn='prod @2 1 2'/> \n" +
		"	  <v:f eqn='prod @3 21600 pixelWidth'/> \n" +
		"	  <v:f eqn='prod @3 21600 pixelHeight'/> \n" +
		"	  <v:f eqn='sum @0 0 1'/> \n" +
		"	  <v:f eqn='prod @6 1 2'/> \n" +
		"	  <v:f eqn='prod @7 21600 pixelWidth'/> \n" +
		"	  <v:f eqn='sum @8 21600 0'/> \n" +
		"	  <v:f eqn='prod @7 21600 pixelHeight'/> \n" +
		"	  <v:f eqn='sum @10 21600 0'/> \n" +
		"	 </v:formulas> \n" +
		"	 <v:path o:extrusionok='f' gradientshapeok='t' o:connecttype='rect'/> \n" +
		"	 <o:lock v:ext='edit' aspectratio='t'/> \n" +
		"	</v:shapetype><v:shape id='Imagen_x0020_1' o:spid='_x0000_i1025' type='#_x0000_t75' \n" +
		"	 style='width:232.5pt;height:116.25pt;visibility:visible'> \n" +
		"	 <v:imagedata src='http://173.203.12.186:9085/Imagenes/olab.jpg' \n" +
		"	  o:title=''/> \n" +
		"	</v:shape><![endif]--><![if !vml]><img width=310 height=155 \n" +
		"	src='Bienvenido%20estimada%20Empresa%20-%20Consulta%20de%20su%20Expediente%20Electronico_archivos/image002.jpg' \n" +
		"	v:shapes='Imagen_x0020_1'><![endif]></span></b><b><span lang=ES \n" +
		"	style='mso-ansi-language:ES'><o:p></o:p></span></b></p> \n" +
		"	 \n" +
		"	<p class=MsoNormal><b><span lang=ES style='mso-ansi-language:ES'>Bienvenida \n" +
		"	Apreciable: " + objConvenio.getCcliente().getSrazonsocial() + " Convenio: " + objConvenio.getSconvenio() + "<o:p></o:p></span></b></p> \n" +
		"	 \n" +
		"	<p class=MsoNormal><span lang=ES style='mso-ansi-language:ES;mso-bidi-font-weight: \n" +
		"	bold'>Le damos la mas cordial bienvenida al servicio de consulta al \n" +
		"	expediente clinico electronico, exclusivo de <span class=SpellE>Olab</span>. <span \n" +
		"	style='mso-spacerun:yes'> </span>Estos son los beneficios para usted:<o:p></o:p></span></p> \n" +
		"	 \n" +
		"	<p class=MsoListParagraphCxSpFirst style='text-indent:-18.0pt;mso-list:l1 level1 lfo1'><![if !supportLists]><span \n" +
		"	lang=ES style='font-family:Symbol;mso-fareast-font-family:Symbol;mso-bidi-font-family: \n" +
		"	Symbol;mso-ansi-language:ES;mso-bidi-font-weight:bold'><span style='mso-list: \n" +
		"	Ignore'>·<span style='font:7.0pt 'Times New Roman''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \n" +
		"	</span></span></span><![endif]><span lang=ES style='mso-ansi-language:ES; \n" +
		"	mso-bidi-font-weight:bold'>Verificar sus datos demograficos y de contacto.<o:p></o:p></span></p> \n" +
		"	 \n" +
		"	<p class=MsoListParagraphCxSpMiddle style='text-indent:-18.0pt;mso-list:l1 level1 lfo1'><![if !supportLists]><span \n" +
		"	lang=ES style='font-family:Symbol;mso-fareast-font-family:Symbol;mso-bidi-font-family: \n" +
		"	Symbol;mso-ansi-language:ES;mso-bidi-font-weight:bold'><span style='mso-list: \n" +
		"	Ignore'>·<span style='font:7.0pt 'Times New Roman''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \n" +
		"	</span></span></span><![endif]><span lang=ES style='mso-ansi-language:ES; \n" +
		"	mso-bidi-font-weight:bold'>Las fechas y numeros de ordenes de cada estudio que \n" +
		"	se ha realizado.<o:p></o:p></span></p> \n" +
		"	 \n" +
		"	<p class=MsoListParagraphCxSpMiddle style='text-indent:-18.0pt;mso-list:l1 level1 lfo1'><![if !supportLists]><span \n" +
		"	lang=ES style='font-family:Symbol;mso-fareast-font-family:Symbol;mso-bidi-font-family: \n" +
		"	Symbol;mso-ansi-language:ES;mso-bidi-font-weight:bold'><span style='mso-list: \n" +
		"	Ignore'>·<span style='font:7.0pt 'Times New Roman''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \n" +
		"	</span></span></span><![endif]><span lang=ES style='mso-ansi-language:ES; \n" +
		"	mso-bidi-font-weight:bold'>Imprimir sus resultados de Laboratorio, evitando \n" +
		"	traslados innecesarios.<o:p></o:p></span></p> \n" +
		"	 \n" +
		"	<p class=MsoListParagraphCxSpMiddle style='text-indent:-18.0pt;mso-list:l1 level1 lfo1'><![if !supportLists]><span \n" +
		"	lang=ES style='font-family:Symbol;mso-fareast-font-family:Symbol;mso-bidi-font-family: \n" +
		"	Symbol;mso-ansi-language:ES;mso-bidi-font-weight:bold'><span style='mso-list: \n" +
		"	Ignore'>·<span style='font:7.0pt 'Times New Roman''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \n" +
		"	</span></span></span><![endif]><span lang=ES style='mso-ansi-language:ES; \n" +
		"	mso-bidi-font-weight:bold'>Conocer las indicaciones previas para sus examenes. (Proximamente)<o:p></o:p></span></p> \n" +
		"	 \n" +
		"	<p class=MsoNormal>Acceso al Expediente Clinico Electronico:</p> \n" +
		"	 \n" +
		"	<ol style='margin-top:0cm' start=1 type=1> \n" +
		"	 <li class=MsoNormal style='mso-list:l0 level1 lfo2'>El acceso es muy sencillo, \n" +
		"	     solo copie o haga <span class=SpellE>click</span> sobre la siguiente \n" +
		"	     direccion electronica<b><span lang=ES style='mso-ansi-language:ES'>:<o:p></o:p></span></b></li> \n" +
		"	</ol> \n" +
		"	 \n" +
		"	<p class=MsoNormal><b><span lang=ES style='font-size:9.0pt;line-height:115%; \n" +
		"	mso-ansi-language:ES'><span style='mso-tab-count:1'>                </span> \n" +
		"	<a href='www.infodiamex.com.mx/indexECE.html'>www.infodiamex.com.mx/indexECE.html</a><o:p></o:p></span></b></p> \n" +
		"	 \n" +
		"	<ol style='margin-top:0cm' start=2 type=1> \n" +
		"	 <li class=MsoNormal style='mso-list:l0 level1 lfo2'>En el espacio donde se \n" +
		"	     indica Usuario ECE, escriba su codigo de identificacion.<span \n" +
		"	     style='mso-spacerun:yes'>  </span></li> \n" +
		"	</ol> \n" +
		"	 \n" +
		"	<p class=MsoNormal><span style='mso-tab-count:1'>                </span>Para \n" +
		"	ustedes es<b><span \n" +
		"	lang=ES style='mso-ansi-language:ES'>: CON" + objConvenio.getCconvenio() + "</span></b></p> \n" +
		"	 \n" +
		"	<ol style='margin-top:0cm' start=3 type=1> \n" +
		"	 <li class=MsoNormal style='mso-list:l0 level1 lfo2'>En el espacio de \n" +
		"	     contraseña, escriba su numero<b><span lang=ES style='mso-ansi-language: \n" +
		"	     ES'>: " + objConvenio.getSpassword() + "<o:p></o:p></span></b></li> \n" +
		"	</ol> \n" +
		"	 \n" +
		"	<p class=MsoNormal>Con estos sencillos pasos usted podra consultar sus datos y \n" +
		"	resultados de los estudios.<b><span lang=ES style='mso-ansi-language:ES'><o:p></o:p></span></b></p> \n" +
		"	 \n" +
		"	<p class=MsoNormal><span class=SpellE>Olab</span> garantiza la absoluta \n" +
		"	confidencialidad de sus datos, al contar con un inviolable sistema de seguridad<b><span \n" +
		"	lang=ES style='mso-ansi-language:ES'>.<o:p></o:p></span></b></p> \n" +
		"	 \n" +
		"	<p class=MsoNormal><b><span lang=ES style='mso-ansi-language:ES'>Olab es el \n" +
		"	primer Laboratorio Clinico en ofrecer la consulta del Expediente clinico \n" +
		"	electronico.<span style='mso-spacerun:yes'>  </span>Usted es la persona mas \n" +
		"	importante para todos quienes colaboramos en Olab.<o:p></o:p></span></b></p> \n" +
		"	 \n" +
		"	<p class=MsoNormal style='text-align:justify'><span lang=ES style='mso-ansi-language: \n" +
		"	ES;mso-bidi-font-weight:bold'>El formato original obra en poder<span \n" +
		"	style='mso-spacerun:yes'>  </span>de nuestras sucursales y si usted lo desea, \n" +
		"	lo podra recoger <span style='mso-spacerun:yes'> </span>en un periodo no mayor \n" +
		"	a los 3 meses de haber solicitado la orden.<o:p></o:p></span></p> \n" +
		"	 \n" +
		"	<p class=MsoNormal style='text-align:justify'><span lang=ES style='mso-ansi-language: \n" +
		"	ES;mso-bidi-font-weight:bold'>Este reporte electronico de resultados no \n" +
		"	sustituye al formato original. </span><span lang=ES style='mso-ansi-language: \n" +
		"	ES'><br> \n" +
		"	<br> \n" +
		"	&quot;<span style='mso-bidi-font-weight:bold'>Aviso Importante”</span>. En su \n" +
		"	empeño por brindarle mejores servicios, “OLAB Diagnosticos Medicos” (en lo \n" +
		"	sucesivo OLAB) a traves de este medio proporcionara los resultados de las \n" +
		"	pruebas de analisis clinicos practicadas en sus diferentes sucursales. OLAB no \n" +
		"	se hace responsable por cualquier modificacion o alteracion que la informacion \n" +
		"	aqui ofrecida pudiera sufrir por actos del paciente o de terceros, por lo que \n" +
		"	en caso de duda es responsabilidad del paciente y de su medico confrontar la \n" +
		"	informacion aqui obtenida con los resultados oficiales impresos por OLAB. <br> \n" +
		"	<br> \n" +
		"	OLAB en apego la Ley de Datos Personales, NO revelara, dara, vendera, donara o \n" +
		"	transmitira ningun tipo de informacion personal del paciente relacionada con \n" +
		"	los resultados de las pruebas clinicas practicadas, excepto cuando esta \n" +
		"	informacion sea solicitada por autoridad competente&quot; <br> \n" +
		"	<br> \n" +
		"	<span style='mso-bidi-font-weight:bold'>Recuerde que su medico es la unica \n" +
		"	persona con conocimiento y autoridad para interpretar sus resultados de laboratorio.</span><br> \n" +
		"	<br> \n" +
		"	<b style='mso-bidi-font-weight:normal'>Para cualquier duda o aclaracion, \n" +
		"	estamos a sus ordenes en el telefono: 4040-OLAB (6522)</b></span></p> \n" +
		"	 \n" +
		"	<p class=MsoNormal><a \n" +
		"	href='mailto:%20expedientelectronico_sugerencias@olab.com.mx'><span \n" +
		"	style='mso-spacerun:yes'> </span>expedientelectronico_sugerencias@olab.com.mx</a></p> \n" +
		"	 \n" +
		"	</div> \n" +
		"	 \n" +
		"	</body> \n" +
		"	 \n" +
		"	</html> \n";
	}		

}


