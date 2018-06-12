package mx.com.web2lab.backend.hbm.om.fundacion;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class BOrdenDiagFundacion implements Serializable {

    /** identifier field */
    private java.lang.Long kordendiagfundacion;

    /** nullable persistent field */
    private java.lang.String svulvarotros;

    /** persistent field */
    private long ctiposbiopsia;

    /** nullable persistent field */
    private boolean bvulvaberruga;

    /** nullable persistent field */
    private boolean bvulvabartho;

    /** nullable persistent field */
    private boolean bvulvapapilomatosis;

    /** nullable persistent field */
    private boolean bvulvamolusco;

    /** nullable persistent field */
    private boolean bvulvanevos;

    /** nullable persistent field */
    private boolean bvulvaquiste;

    /** nullable persistent field */
    private boolean bvulvavph;

    /** persistent field */
    private long cvulvitis;

    /** nullable persistent field */
    private boolean bvulvaacuminada;

    /** nullable persistent field */
    private boolean bvulvaperianal;

    /** nullable persistent field */
    private boolean bvulvavaginal;

    /** nullable persistent field */
    private boolean bvulvavulvar;

    /** persistent field */
    private long catrifia;

    /** nullable persistent field */
    private boolean bvulvafolicutilits;

    /** nullable persistent field */
    private int ccervix;

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
    private int csecrecion;

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
    private int cdiu;

    /** nullable persistent field */
    private boolean bunionescamoclumnar;

    /** nullable persistent field */
    private java.lang.String szonasacetopositivas;

    /** nullable persistent field */
    private int cectropion;

    /** nullable persistent field */
    private int utamanoectropion;

    /** nullable persistent field */
    private int cpolipo;

    /** nullable persistent field */
    private int utamanopolipo;

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
    private boolean bcolposano;

    /** nullable persistent field */
    private boolean bcolpoleibg;

    /** nullable persistent field */
    private boolean bcolpoleiag;

    /** nullable persistent field */
    private boolean bcolpocancer;

    /** nullable persistent field */
    private boolean bcolpobacteriana;

    /** nullable persistent field */
    private boolean bcolpomicotica;

    /** nullable persistent field */
    private boolean bcolpoparasitaria;

    /** nullable persistent field */
    private boolean bcolpomiomaedocervical;

    /** nullable persistent field */
    private boolean bcolpocondilomatosis;

    /** persistent field */
    private long cmucosaatrofica;

    /** persistent field */
    private long cpolipovagino;

    /** persistent field */
    private long upolipovaginotamano;

    /** persistent field */
    private long cmucosaatroficavagino;

    /** persistent field */
    private long cvaginosisvagino;

    /** nullable persistent field */
    private boolean bvaginoscoacuminado;

    /** nullable persistent field */
    private boolean bvaginosconiva;

    /** nullable persistent field */
    private boolean bvaginoscogranuloma;

    /** nullable persistent field */
    private boolean bpapaleibg;

    /** nullable persistent field */
    private boolean bpapaleiag;

    /** nullable persistent field */
    private boolean bpapacarciinsitu;

    /** nullable persistent field */
    private boolean bpapacarcimicroinvasor;

    /** nullable persistent field */
    private boolean bpapacarcinomainvasor;

    /** nullable persistent field */
    private boolean bpapaadenoinsitu;

    /** nullable persistent field */
    private boolean bpapaadenoinvasor;

    /** nullable persistent field */
    private boolean bpapacarciepidermoide;

    /** nullable persistent field */
    private boolean bpapaascus;

    /** nullable persistent field */
    private boolean bpapaasch;

    /** nullable persistent field */
    private boolean bpapacandida;

    /** nullable persistent field */
    private boolean bpapatrichomona;

    /** nullable persistent field */
    private boolean bpapaactinomyces;

    /** nullable persistent field */
    private boolean bpapavaginosis;

    /** nullable persistent field */
    private boolean bcervixleibg;

    /** nullable persistent field */
    private boolean bcervixleiag;

    /** nullable persistent field */
    private boolean bcervixcarciinsitu;

    /** nullable persistent field */
    private boolean bcervixcarcimicroinvasor;

    /** nullable persistent field */
    private boolean bcervixcarciinvasor;

    /** nullable persistent field */
    private boolean bcervixadenoinsitu;

    /** nullable persistent field */
    private boolean bcervixadenoinvasor;

    /** nullable persistent field */
    private boolean bcervixcarciepidermoide;

    /** nullable persistent field */
    private boolean bcervixcondilom;

    /** nullable persistent field */
    private boolean bcervixpolipo;

    /** nullable persistent field */
    private boolean bcervixaguda;

    /** nullable persistent field */
    private boolean bcervixcronica;

    /** nullable persistent field */
    private boolean bconoleibgsin;

    /** nullable persistent field */
    private boolean bconoleiagsin;

    /** nullable persistent field */
    private boolean bconoleibgcon;

    /** nullable persistent field */
    private boolean bconoleiagcon;

    /** nullable persistent field */
    private boolean bconocarcinoma;

    /** nullable persistent field */
    private boolean bconoadenosin;

    /** nullable persistent field */
    private boolean bconoadenocon;

    /** nullable persistent field */
    private boolean bconoadenoinvasor;

    /** nullable persistent field */
    private boolean bconoaguda;

    /** nullable persistent field */
    private boolean bconocronica;

    /** nullable persistent field */
    private boolean bblandoscondiloma;

    /** nullable persistent field */
    private boolean bblandosniva;

    /** nullable persistent field */
    private boolean bblandosmoluco;

    /** nullable persistent field */
    private boolean bblandosberruga;

    /** nullable persistent field */
    private boolean bblandosnevo;

    /** nullable persistent field */
    private boolean bvaginacondiloma;

    /** nullable persistent field */
    private boolean bvaginapolipo;

    /** nullable persistent field */
    private boolean bvaginaniva;

    /** nullable persistent field */
    private boolean bvaginaproceso;

    /** nullable persistent field */
    private int cestado;

    /** persistent field */
    private int cusuario;

    /** nullable persistent field */
    private java.util.Date dregistro;

    /** persistent field */
    private mx.com.web2lab.backend.hbm.om.fundacion.BOrdenFundacion bordenfundacion;

    /** full constructor */
    public BOrdenDiagFundacion(java.lang.Long kordendiagfundacion, java.lang.String svulvarotros, long ctiposbiopsia, boolean bvulvaberruga, boolean bvulvabartho, boolean bvulvapapilomatosis, boolean bvulvamolusco, boolean bvulvanevos, boolean bvulvaquiste, boolean bvulvavph, long cvulvitis, boolean bvulvaacuminada, boolean bvulvaperianal, boolean bvulvavaginal, boolean bvulvavulvar, long catrifia, boolean bvulvafolicutilits, int ccervix, boolean bcervixcentral, boolean bcervixderecho, boolean bcervixizquierdo, boolean bcervixanterior, boolean bcervixposterior, int csecrecion, boolean bsecrecionfluida, boolean bsecrecionespesa, boolean bsecrecionsemiespesa, boolean bsecreciongrumosa, boolean bsecrecionespumosa, boolean bsecrecionescasa, boolean bsecrecionmoderada, boolean bsecrecionabundante, int cdiu, boolean bunionescamoclumnar, java.lang.String szonasacetopositivas, int cectropion, int utamanoectropion, int cpolipo, int utamanopolipo, boolean bprocesoerosivo, boolean bmei, boolean bmeipo, boolean bquistenaboth, java.lang.String squistenaboth, boolean bcolposano, boolean bcolpoleibg, boolean bcolpoleiag, boolean bcolpocancer, boolean bcolpobacteriana, boolean bcolpomicotica, boolean bcolpoparasitaria, boolean bcolpomiomaedocervical, boolean bcolpocondilomatosis, long cmucosaatrofica, long cpolipovagino, long upolipovaginotamano, long cmucosaatroficavagino, long cvaginosisvagino, boolean bvaginoscoacuminado, boolean bvaginosconiva, boolean bvaginoscogranuloma, boolean bpapaleibg, boolean bpapaleiag, boolean bpapacarciinsitu, boolean bpapacarcimicroinvasor, boolean bpapacarcinomainvasor, boolean bpapaadenoinsitu, boolean bpapaadenoinvasor, boolean bpapacarciepidermoide, boolean bpapaascus, boolean bpapaasch, boolean bpapacandida, boolean bpapatrichomona, boolean bpapaactinomyces, boolean bpapavaginosis, boolean bcervixleibg, boolean bcervixleiag, boolean bcervixcarciinsitu, boolean bcervixcarcimicroinvasor, boolean bcervixcarciinvasor, boolean bcervixadenoinsitu, boolean bcervixadenoinvasor, boolean bcervixcarciepidermoide, boolean bcervixcondilom, boolean bcervixpolipo, boolean bcervixaguda, boolean bcervixcronica, boolean bconoleibgsin, boolean bconoleiagsin, boolean bconoleibgcon, boolean bconoleiagcon, boolean bconocarcinoma, boolean bconoadenosin, boolean bconoadenocon, boolean bconoadenoinvasor, boolean bconoaguda, boolean bconocronica, boolean bblandoscondiloma, boolean bblandosniva, boolean bblandosmoluco, boolean bblandosberruga, boolean bblandosnevo, boolean bvaginacondiloma, boolean bvaginapolipo, boolean bvaginaniva, boolean bvaginaproceso, int cestado, int cusuario, java.util.Date dregistro, mx.com.web2lab.backend.hbm.om.fundacion.BOrdenFundacion bordenfundacion) {
        this.kordendiagfundacion = kordendiagfundacion;
        this.svulvarotros = svulvarotros;
        this.ctiposbiopsia = ctiposbiopsia;
        this.bvulvaberruga = bvulvaberruga;
        this.bvulvabartho = bvulvabartho;
        this.bvulvapapilomatosis = bvulvapapilomatosis;
        this.bvulvamolusco = bvulvamolusco;
        this.bvulvanevos = bvulvanevos;
        this.bvulvaquiste = bvulvaquiste;
        this.bvulvavph = bvulvavph;
        this.cvulvitis = cvulvitis;
        this.bvulvaacuminada = bvulvaacuminada;
        this.bvulvaperianal = bvulvaperianal;
        this.bvulvavaginal = bvulvavaginal;
        this.bvulvavulvar = bvulvavulvar;
        this.catrifia = catrifia;
        this.bvulvafolicutilits = bvulvafolicutilits;
        this.ccervix = ccervix;
        this.bcervixcentral = bcervixcentral;
        this.bcervixderecho = bcervixderecho;
        this.bcervixizquierdo = bcervixizquierdo;
        this.bcervixanterior = bcervixanterior;
        this.bcervixposterior = bcervixposterior;
        this.csecrecion = csecrecion;
        this.bsecrecionfluida = bsecrecionfluida;
        this.bsecrecionespesa = bsecrecionespesa;
        this.bsecrecionsemiespesa = bsecrecionsemiespesa;
        this.bsecreciongrumosa = bsecreciongrumosa;
        this.bsecrecionespumosa = bsecrecionespumosa;
        this.bsecrecionescasa = bsecrecionescasa;
        this.bsecrecionmoderada = bsecrecionmoderada;
        this.bsecrecionabundante = bsecrecionabundante;
        this.cdiu = cdiu;
        this.bunionescamoclumnar = bunionescamoclumnar;
        this.szonasacetopositivas = szonasacetopositivas;
        this.cectropion = cectropion;
        this.utamanoectropion = utamanoectropion;
        this.cpolipo = cpolipo;
        this.utamanopolipo = utamanopolipo;
        this.bprocesoerosivo = bprocesoerosivo;
        this.bmei = bmei;
        this.bmeipo = bmeipo;
        this.bquistenaboth = bquistenaboth;
        this.squistenaboth = squistenaboth;
        this.bcolposano = bcolposano;
        this.bcolpoleibg = bcolpoleibg;
        this.bcolpoleiag = bcolpoleiag;
        this.bcolpocancer = bcolpocancer;
        this.bcolpobacteriana = bcolpobacteriana;
        this.bcolpomicotica = bcolpomicotica;
        this.bcolpoparasitaria = bcolpoparasitaria;
        this.bcolpomiomaedocervical = bcolpomiomaedocervical;
        this.bcolpocondilomatosis = bcolpocondilomatosis;
        this.cmucosaatrofica = cmucosaatrofica;
        this.cpolipovagino = cpolipovagino;
        this.upolipovaginotamano = upolipovaginotamano;
        this.cmucosaatroficavagino = cmucosaatroficavagino;
        this.cvaginosisvagino = cvaginosisvagino;
        this.bvaginoscoacuminado = bvaginoscoacuminado;
        this.bvaginosconiva = bvaginosconiva;
        this.bvaginoscogranuloma = bvaginoscogranuloma;
        this.bpapaleibg = bpapaleibg;
        this.bpapaleiag = bpapaleiag;
        this.bpapacarciinsitu = bpapacarciinsitu;
        this.bpapacarcimicroinvasor = bpapacarcimicroinvasor;
        this.bpapacarcinomainvasor = bpapacarcinomainvasor;
        this.bpapaadenoinsitu = bpapaadenoinsitu;
        this.bpapaadenoinvasor = bpapaadenoinvasor;
        this.bpapacarciepidermoide = bpapacarciepidermoide;
        this.bpapaascus = bpapaascus;
        this.bpapaasch = bpapaasch;
        this.bpapacandida = bpapacandida;
        this.bpapatrichomona = bpapatrichomona;
        this.bpapaactinomyces = bpapaactinomyces;
        this.bpapavaginosis = bpapavaginosis;
        this.bcervixleibg = bcervixleibg;
        this.bcervixleiag = bcervixleiag;
        this.bcervixcarciinsitu = bcervixcarciinsitu;
        this.bcervixcarcimicroinvasor = bcervixcarcimicroinvasor;
        this.bcervixcarciinvasor = bcervixcarciinvasor;
        this.bcervixadenoinsitu = bcervixadenoinsitu;
        this.bcervixadenoinvasor = bcervixadenoinvasor;
        this.bcervixcarciepidermoide = bcervixcarciepidermoide;
        this.bcervixcondilom = bcervixcondilom;
        this.bcervixpolipo = bcervixpolipo;
        this.bcervixaguda = bcervixaguda;
        this.bcervixcronica = bcervixcronica;
        this.bconoleibgsin = bconoleibgsin;
        this.bconoleiagsin = bconoleiagsin;
        this.bconoleibgcon = bconoleibgcon;
        this.bconoleiagcon = bconoleiagcon;
        this.bconocarcinoma = bconocarcinoma;
        this.bconoadenosin = bconoadenosin;
        this.bconoadenocon = bconoadenocon;
        this.bconoadenoinvasor = bconoadenoinvasor;
        this.bconoaguda = bconoaguda;
        this.bconocronica = bconocronica;
        this.bblandoscondiloma = bblandoscondiloma;
        this.bblandosniva = bblandosniva;
        this.bblandosmoluco = bblandosmoluco;
        this.bblandosberruga = bblandosberruga;
        this.bblandosnevo = bblandosnevo;
        this.bvaginacondiloma = bvaginacondiloma;
        this.bvaginapolipo = bvaginapolipo;
        this.bvaginaniva = bvaginaniva;
        this.bvaginaproceso = bvaginaproceso;
        this.cestado = cestado;
        this.cusuario = cusuario;
        this.dregistro = dregistro;
        this.bordenfundacion = bordenfundacion;
    }

    /** default constructor */
    public BOrdenDiagFundacion() {
    }

    /** minimal constructor */
    public BOrdenDiagFundacion(java.lang.Long kordendiagfundacion, long ctiposbiopsia, long cvulvitis, long catrifia, long cmucosaatrofica, long cpolipovagino, long upolipovaginotamano, long cmucosaatroficavagino, long cvaginosisvagino, int cusuario, mx.com.web2lab.backend.hbm.om.fundacion.BOrdenFundacion bordenfundacion) {
        this.kordendiagfundacion = kordendiagfundacion;
        this.ctiposbiopsia = ctiposbiopsia;
        this.cvulvitis = cvulvitis;
        this.catrifia = catrifia;
        this.cmucosaatrofica = cmucosaatrofica;
        this.cpolipovagino = cpolipovagino;
        this.upolipovaginotamano = upolipovaginotamano;
        this.cmucosaatroficavagino = cmucosaatroficavagino;
        this.cvaginosisvagino = cvaginosisvagino;
        this.cusuario = cusuario;
        this.bordenfundacion = bordenfundacion;
    }

    public java.lang.Long getKordendiagfundacion() {
        return this.kordendiagfundacion;
    }

    public void setKordendiagfundacion(java.lang.Long kordendiagfundacion) {
        this.kordendiagfundacion = kordendiagfundacion;
    }

    public java.lang.String getSvulvarotros() {
        return this.svulvarotros;
    }

    public void setSvulvarotros(java.lang.String svulvarotros) {
        this.svulvarotros = svulvarotros;
    }

    public long getCtiposbiopsia() {
        return this.ctiposbiopsia;
    }

    public void setCtiposbiopsia(long ctiposbiopsia) {
        this.ctiposbiopsia = ctiposbiopsia;
    }

    public boolean isBvulvaberruga() {
        return this.bvulvaberruga;
    }

    public void setBvulvaberruga(boolean bvulvaberruga) {
        this.bvulvaberruga = bvulvaberruga;
    }

    public boolean isBvulvabartho() {
        return this.bvulvabartho;
    }

    public void setBvulvabartho(boolean bvulvabartho) {
        this.bvulvabartho = bvulvabartho;
    }

    public boolean isBvulvapapilomatosis() {
        return this.bvulvapapilomatosis;
    }

    public void setBvulvapapilomatosis(boolean bvulvapapilomatosis) {
        this.bvulvapapilomatosis = bvulvapapilomatosis;
    }

    public boolean isBvulvamolusco() {
        return this.bvulvamolusco;
    }

    public void setBvulvamolusco(boolean bvulvamolusco) {
        this.bvulvamolusco = bvulvamolusco;
    }

    public boolean isBvulvanevos() {
        return this.bvulvanevos;
    }

    public void setBvulvanevos(boolean bvulvanevos) {
        this.bvulvanevos = bvulvanevos;
    }

    public boolean isBvulvaquiste() {
        return this.bvulvaquiste;
    }

    public void setBvulvaquiste(boolean bvulvaquiste) {
        this.bvulvaquiste = bvulvaquiste;
    }

    public boolean isBvulvavph() {
        return this.bvulvavph;
    }

    public void setBvulvavph(boolean bvulvavph) {
        this.bvulvavph = bvulvavph;
    }

    public long getCvulvitis() {
        return this.cvulvitis;
    }

    public void setCvulvitis(long cvulvitis) {
        this.cvulvitis = cvulvitis;
    }

    public boolean isBvulvaacuminada() {
        return this.bvulvaacuminada;
    }

    public void setBvulvaacuminada(boolean bvulvaacuminada) {
        this.bvulvaacuminada = bvulvaacuminada;
    }

    public boolean isBvulvaperianal() {
        return this.bvulvaperianal;
    }

    public void setBvulvaperianal(boolean bvulvaperianal) {
        this.bvulvaperianal = bvulvaperianal;
    }

    public boolean isBvulvavaginal() {
        return this.bvulvavaginal;
    }

    public void setBvulvavaginal(boolean bvulvavaginal) {
        this.bvulvavaginal = bvulvavaginal;
    }

    public boolean isBvulvavulvar() {
        return this.bvulvavulvar;
    }

    public void setBvulvavulvar(boolean bvulvavulvar) {
        this.bvulvavulvar = bvulvavulvar;
    }

    public long getCatrifia() {
        return this.catrifia;
    }

    public void setCatrifia(long catrifia) {
        this.catrifia = catrifia;
    }

    public boolean isBvulvafolicutilits() {
        return this.bvulvafolicutilits;
    }

    public void setBvulvafolicutilits(boolean bvulvafolicutilits) {
        this.bvulvafolicutilits = bvulvafolicutilits;
    }

    public int getCcervix() {
        return this.ccervix;
    }

    public void setCcervix(int ccervix) {
        this.ccervix = ccervix;
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

    public int getCsecrecion() {
        return this.csecrecion;
    }

    public void setCsecrecion(int csecrecion) {
        this.csecrecion = csecrecion;
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

    public int getCdiu() {
        return this.cdiu;
    }

    public void setCdiu(int cdiu) {
        this.cdiu = cdiu;
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

    public int getCectropion() {
        return this.cectropion;
    }

    public void setCectropion(int cectropion) {
        this.cectropion = cectropion;
    }

    public int getUtamanoectropion() {
        return this.utamanoectropion;
    }

    public void setUtamanoectropion(int utamanoectropion) {
        this.utamanoectropion = utamanoectropion;
    }

    public int getCpolipo() {
        return this.cpolipo;
    }

    public void setCpolipo(int cpolipo) {
        this.cpolipo = cpolipo;
    }

    public int getUtamanopolipo() {
        return this.utamanopolipo;
    }

    public void setUtamanopolipo(int utamanopolipo) {
        this.utamanopolipo = utamanopolipo;
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

    public boolean isBcolposano() {
        return this.bcolposano;
    }

    public void setBcolposano(boolean bcolposano) {
        this.bcolposano = bcolposano;
    }

    public boolean isBcolpoleibg() {
        return this.bcolpoleibg;
    }

    public void setBcolpoleibg(boolean bcolpoleibg) {
        this.bcolpoleibg = bcolpoleibg;
    }

    public boolean isBcolpoleiag() {
        return this.bcolpoleiag;
    }

    public void setBcolpoleiag(boolean bcolpoleiag) {
        this.bcolpoleiag = bcolpoleiag;
    }

    public boolean isBcolpocancer() {
        return this.bcolpocancer;
    }

    public void setBcolpocancer(boolean bcolpocancer) {
        this.bcolpocancer = bcolpocancer;
    }

    public boolean isBcolpobacteriana() {
        return this.bcolpobacteriana;
    }

    public void setBcolpobacteriana(boolean bcolpobacteriana) {
        this.bcolpobacteriana = bcolpobacteriana;
    }

    public boolean isBcolpomicotica() {
        return this.bcolpomicotica;
    }

    public void setBcolpomicotica(boolean bcolpomicotica) {
        this.bcolpomicotica = bcolpomicotica;
    }

    public boolean isBcolpoparasitaria() {
        return this.bcolpoparasitaria;
    }

    public void setBcolpoparasitaria(boolean bcolpoparasitaria) {
        this.bcolpoparasitaria = bcolpoparasitaria;
    }

    public boolean isBcolpomiomaedocervical() {
        return this.bcolpomiomaedocervical;
    }

    public void setBcolpomiomaedocervical(boolean bcolpomiomaedocervical) {
        this.bcolpomiomaedocervical = bcolpomiomaedocervical;
    }

    public boolean isBcolpocondilomatosis() {
        return this.bcolpocondilomatosis;
    }

    public void setBcolpocondilomatosis(boolean bcolpocondilomatosis) {
        this.bcolpocondilomatosis = bcolpocondilomatosis;
    }

    public long getCmucosaatrofica() {
        return this.cmucosaatrofica;
    }

    public void setCmucosaatrofica(long cmucosaatrofica) {
        this.cmucosaatrofica = cmucosaatrofica;
    }

    public long getCpolipovagino() {
        return this.cpolipovagino;
    }

    public void setCpolipovagino(long cpolipovagino) {
        this.cpolipovagino = cpolipovagino;
    }

    public long getUpolipovaginotamano() {
        return this.upolipovaginotamano;
    }

    public void setUpolipovaginotamano(long upolipovaginotamano) {
        this.upolipovaginotamano = upolipovaginotamano;
    }

    public long getCmucosaatroficavagino() {
        return this.cmucosaatroficavagino;
    }

    public void setCmucosaatroficavagino(long cmucosaatroficavagino) {
        this.cmucosaatroficavagino = cmucosaatroficavagino;
    }

    public long getCvaginosisvagino() {
        return this.cvaginosisvagino;
    }

    public void setCvaginosisvagino(long cvaginosisvagino) {
        this.cvaginosisvagino = cvaginosisvagino;
    }

    public boolean isBvaginoscoacuminado() {
        return this.bvaginoscoacuminado;
    }

    public void setBvaginoscoacuminado(boolean bvaginoscoacuminado) {
        this.bvaginoscoacuminado = bvaginoscoacuminado;
    }

    public boolean isBvaginosconiva() {
        return this.bvaginosconiva;
    }

    public void setBvaginosconiva(boolean bvaginosconiva) {
        this.bvaginosconiva = bvaginosconiva;
    }

    public boolean isBvaginoscogranuloma() {
        return this.bvaginoscogranuloma;
    }

    public void setBvaginoscogranuloma(boolean bvaginoscogranuloma) {
        this.bvaginoscogranuloma = bvaginoscogranuloma;
    }

    public boolean isBpapaleibg() {
        return this.bpapaleibg;
    }

    public void setBpapaleibg(boolean bpapaleibg) {
        this.bpapaleibg = bpapaleibg;
    }

    public boolean isBpapaleiag() {
        return this.bpapaleiag;
    }

    public void setBpapaleiag(boolean bpapaleiag) {
        this.bpapaleiag = bpapaleiag;
    }

    public boolean isBpapacarciinsitu() {
        return this.bpapacarciinsitu;
    }

    public void setBpapacarciinsitu(boolean bpapacarciinsitu) {
        this.bpapacarciinsitu = bpapacarciinsitu;
    }

    public boolean isBpapacarcimicroinvasor() {
        return this.bpapacarcimicroinvasor;
    }

    public void setBpapacarcimicroinvasor(boolean bpapacarcimicroinvasor) {
        this.bpapacarcimicroinvasor = bpapacarcimicroinvasor;
    }

    public boolean isBpapacarcinomainvasor() {
        return this.bpapacarcinomainvasor;
    }

    public void setBpapacarcinomainvasor(boolean bpapacarcinomainvasor) {
        this.bpapacarcinomainvasor = bpapacarcinomainvasor;
    }

    public boolean isBpapaadenoinsitu() {
        return this.bpapaadenoinsitu;
    }

    public void setBpapaadenoinsitu(boolean bpapaadenoinsitu) {
        this.bpapaadenoinsitu = bpapaadenoinsitu;
    }

    public boolean isBpapaadenoinvasor() {
        return this.bpapaadenoinvasor;
    }

    public void setBpapaadenoinvasor(boolean bpapaadenoinvasor) {
        this.bpapaadenoinvasor = bpapaadenoinvasor;
    }

    public boolean isBpapacarciepidermoide() {
        return this.bpapacarciepidermoide;
    }

    public void setBpapacarciepidermoide(boolean bpapacarciepidermoide) {
        this.bpapacarciepidermoide = bpapacarciepidermoide;
    }

    public boolean isBpapaascus() {
        return this.bpapaascus;
    }

    public void setBpapaascus(boolean bpapaascus) {
        this.bpapaascus = bpapaascus;
    }

    public boolean isBpapaasch() {
        return this.bpapaasch;
    }

    public void setBpapaasch(boolean bpapaasch) {
        this.bpapaasch = bpapaasch;
    }

    public boolean isBpapacandida() {
        return this.bpapacandida;
    }

    public void setBpapacandida(boolean bpapacandida) {
        this.bpapacandida = bpapacandida;
    }

    public boolean isBpapatrichomona() {
        return this.bpapatrichomona;
    }

    public void setBpapatrichomona(boolean bpapatrichomona) {
        this.bpapatrichomona = bpapatrichomona;
    }

    public boolean isBpapaactinomyces() {
        return this.bpapaactinomyces;
    }

    public void setBpapaactinomyces(boolean bpapaactinomyces) {
        this.bpapaactinomyces = bpapaactinomyces;
    }

    public boolean isBpapavaginosis() {
        return this.bpapavaginosis;
    }

    public void setBpapavaginosis(boolean bpapavaginosis) {
        this.bpapavaginosis = bpapavaginosis;
    }

    public boolean isBcervixleibg() {
        return this.bcervixleibg;
    }

    public void setBcervixleibg(boolean bcervixleibg) {
        this.bcervixleibg = bcervixleibg;
    }

    public boolean isBcervixleiag() {
        return this.bcervixleiag;
    }

    public void setBcervixleiag(boolean bcervixleiag) {
        this.bcervixleiag = bcervixleiag;
    }

    public boolean isBcervixcarciinsitu() {
        return this.bcervixcarciinsitu;
    }

    public void setBcervixcarciinsitu(boolean bcervixcarciinsitu) {
        this.bcervixcarciinsitu = bcervixcarciinsitu;
    }

    public boolean isBcervixcarcimicroinvasor() {
        return this.bcervixcarcimicroinvasor;
    }

    public void setBcervixcarcimicroinvasor(boolean bcervixcarcimicroinvasor) {
        this.bcervixcarcimicroinvasor = bcervixcarcimicroinvasor;
    }

    public boolean isBcervixcarciinvasor() {
        return this.bcervixcarciinvasor;
    }

    public void setBcervixcarciinvasor(boolean bcervixcarciinvasor) {
        this.bcervixcarciinvasor = bcervixcarciinvasor;
    }

    public boolean isBcervixadenoinsitu() {
        return this.bcervixadenoinsitu;
    }

    public void setBcervixadenoinsitu(boolean bcervixadenoinsitu) {
        this.bcervixadenoinsitu = bcervixadenoinsitu;
    }

    public boolean isBcervixadenoinvasor() {
        return this.bcervixadenoinvasor;
    }

    public void setBcervixadenoinvasor(boolean bcervixadenoinvasor) {
        this.bcervixadenoinvasor = bcervixadenoinvasor;
    }

    public boolean isBcervixcarciepidermoide() {
        return this.bcervixcarciepidermoide;
    }

    public void setBcervixcarciepidermoide(boolean bcervixcarciepidermoide) {
        this.bcervixcarciepidermoide = bcervixcarciepidermoide;
    }

    public boolean isBcervixcondilom() {
        return this.bcervixcondilom;
    }

    public void setBcervixcondilom(boolean bcervixcondilom) {
        this.bcervixcondilom = bcervixcondilom;
    }

    public boolean isBcervixpolipo() {
        return this.bcervixpolipo;
    }

    public void setBcervixpolipo(boolean bcervixpolipo) {
        this.bcervixpolipo = bcervixpolipo;
    }

    public boolean isBcervixaguda() {
        return this.bcervixaguda;
    }

    public void setBcervixaguda(boolean bcervixaguda) {
        this.bcervixaguda = bcervixaguda;
    }

    public boolean isBcervixcronica() {
        return this.bcervixcronica;
    }

    public void setBcervixcronica(boolean bcervixcronica) {
        this.bcervixcronica = bcervixcronica;
    }

    public boolean isBconoleibgsin() {
        return this.bconoleibgsin;
    }

    public void setBconoleibgsin(boolean bconoleibgsin) {
        this.bconoleibgsin = bconoleibgsin;
    }

    public boolean isBconoleiagsin() {
        return this.bconoleiagsin;
    }

    public void setBconoleiagsin(boolean bconoleiagsin) {
        this.bconoleiagsin = bconoleiagsin;
    }

    public boolean isBconoleibgcon() {
        return this.bconoleibgcon;
    }

    public void setBconoleibgcon(boolean bconoleibgcon) {
        this.bconoleibgcon = bconoleibgcon;
    }

    public boolean isBconoleiagcon() {
        return this.bconoleiagcon;
    }

    public void setBconoleiagcon(boolean bconoleiagcon) {
        this.bconoleiagcon = bconoleiagcon;
    }

    public boolean isBconocarcinoma() {
        return this.bconocarcinoma;
    }

    public void setBconocarcinoma(boolean bconocarcinoma) {
        this.bconocarcinoma = bconocarcinoma;
    }

    public boolean isBconoadenosin() {
        return this.bconoadenosin;
    }

    public void setBconoadenosin(boolean bconoadenosin) {
        this.bconoadenosin = bconoadenosin;
    }

    public boolean isBconoadenocon() {
        return this.bconoadenocon;
    }

    public void setBconoadenocon(boolean bconoadenocon) {
        this.bconoadenocon = bconoadenocon;
    }

    public boolean isBconoadenoinvasor() {
        return this.bconoadenoinvasor;
    }

    public void setBconoadenoinvasor(boolean bconoadenoinvasor) {
        this.bconoadenoinvasor = bconoadenoinvasor;
    }

    public boolean isBconoaguda() {
        return this.bconoaguda;
    }

    public void setBconoaguda(boolean bconoaguda) {
        this.bconoaguda = bconoaguda;
    }

    public boolean isBconocronica() {
        return this.bconocronica;
    }

    public void setBconocronica(boolean bconocronica) {
        this.bconocronica = bconocronica;
    }

    public boolean isBblandoscondiloma() {
        return this.bblandoscondiloma;
    }

    public void setBblandoscondiloma(boolean bblandoscondiloma) {
        this.bblandoscondiloma = bblandoscondiloma;
    }

    public boolean isBblandosniva() {
        return this.bblandosniva;
    }

    public void setBblandosniva(boolean bblandosniva) {
        this.bblandosniva = bblandosniva;
    }

    public boolean isBblandosmoluco() {
        return this.bblandosmoluco;
    }

    public void setBblandosmoluco(boolean bblandosmoluco) {
        this.bblandosmoluco = bblandosmoluco;
    }

    public boolean isBblandosberruga() {
        return this.bblandosberruga;
    }

    public void setBblandosberruga(boolean bblandosberruga) {
        this.bblandosberruga = bblandosberruga;
    }

    public boolean isBblandosnevo() {
        return this.bblandosnevo;
    }

    public void setBblandosnevo(boolean bblandosnevo) {
        this.bblandosnevo = bblandosnevo;
    }

    public boolean isBvaginacondiloma() {
        return this.bvaginacondiloma;
    }

    public void setBvaginacondiloma(boolean bvaginacondiloma) {
        this.bvaginacondiloma = bvaginacondiloma;
    }

    public boolean isBvaginapolipo() {
        return this.bvaginapolipo;
    }

    public void setBvaginapolipo(boolean bvaginapolipo) {
        this.bvaginapolipo = bvaginapolipo;
    }

    public boolean isBvaginaniva() {
        return this.bvaginaniva;
    }

    public void setBvaginaniva(boolean bvaginaniva) {
        this.bvaginaniva = bvaginaniva;
    }

    public boolean isBvaginaproceso() {
        return this.bvaginaproceso;
    }

    public void setBvaginaproceso(boolean bvaginaproceso) {
        this.bvaginaproceso = bvaginaproceso;
    }

    public int getCestado() {
        return this.cestado;
    }

    public void setCestado(int cestado) {
        this.cestado = cestado;
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

    public mx.com.web2lab.backend.hbm.om.fundacion.BOrdenFundacion getBordenfundacion() {
        return this.bordenfundacion;
    }

    public void setBordenfundacion(mx.com.web2lab.backend.hbm.om.fundacion.BOrdenFundacion bordenfundacion) {
        this.bordenfundacion = bordenfundacion;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("kordendiagfundacion", getKordendiagfundacion())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BOrdenDiagFundacion) ) return false;
        BOrdenDiagFundacion castOther = (BOrdenDiagFundacion) other;
        return new EqualsBuilder()
            .append(this.getKordendiagfundacion(), castOther.getKordendiagfundacion())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getKordendiagfundacion())
            .toHashCode();
    }

}
