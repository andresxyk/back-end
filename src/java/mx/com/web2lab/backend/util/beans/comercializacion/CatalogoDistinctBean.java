package mx.com.web2lab.backend.util.beans.comercializacion;

import java.io.Serializable;

public class CatalogoDistinctBean implements Serializable {

    /** identifier field */
    private int kdistinct;

    /** identifier field */
    private int cdistinct;

    /** nullable persistent field */
    private java.lang.String sdistinct;


    /** full constructor */
    public CatalogoDistinctBean(int kdistinct, java.lang.String sdistinct) {
        this.kdistinct = kdistinct;
        this.sdistinct = sdistinct;
    }

    /** default constructor */
    public CatalogoDistinctBean() {
    }


    public int getKdistinct() {
        return this.kdistinct;
    }

    public void setKdistinct(int kdistinct) {
        this.kdistinct = kdistinct;
    }
    
    public java.lang.String getSdistinct() {
        return this.sdistinct;
    }

    public void setSdistinct(java.lang.String sdistinct) {
        this.sdistinct = sdistinct;
    }

	public int getCdistinct() {
		return cdistinct;
	}

	public void setCdistinct(int cdistinct) {
		this.cdistinct = cdistinct;
	}
}
