package com.pit.convert.datatype;

/**
 *
 * @author HAIBV
 */
public class SUBDIARY extends DKT {   

    private String SUB_TIN;//Identification Number
    private String CITY_CODE;//City code for city/street file
    private String REGIONNAME;//Description
    private String SUB_ID_TINC;//Sequence from tinc system
    
    public SUBDIARY() {
    }

    public String getCITY_CODE() {
        return CITY_CODE;
    }

    public void setCITY_CODE(String CITY_CODE) {
        this.CITY_CODE = CITY_CODE;
    }

    public String getREGIONNAME() {
        return REGIONNAME;
    }

    public void setREGIONNAME(String REGIONNAME) {
        this.REGIONNAME = REGIONNAME;
    }

    public String getSUB_TIN() {
        return SUB_TIN;
    }

    public void setSUB_TIN(String SUB_TIN) {
        this.SUB_TIN = SUB_TIN;
    }

    public String getSUB_ID_TINC() {
        return SUB_ID_TINC;
    }

    public void setSUB_ID_TINC(String SUB_ID_TINC) {
        this.SUB_ID_TINC = SUB_ID_TINC;
    }
    
    


}
