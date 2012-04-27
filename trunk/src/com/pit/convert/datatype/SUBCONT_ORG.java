package com.pit.convert.datatype;

/**
 *
 * @author HAIBV
 */
public class SUBCONT_ORG extends DKT {

private String CONT_ID;//Id of Foreigner Contractor
private String SUBCON_ID;//Id of Subcontractor
private String FOREIGNER_NAME;//Name of Contractor
private String COUNTRYNAME;//Country Name
private String TINVN;//Identification Number
private String TINFR;//Ma so thue DTNN tai nuoc ngoai
private String CTNO;//Contract No
private String CTVAL;//Contact Value
private String CTVALW;//Transaction Currency
private String CONT_LOCA;//Working addr as contract
private String LOCA_REGION;//Region (State, Province, County)
private String REGIONNAME;//Description
private String EMPNB;//Number of employee
private String CONT_ID_TINC;//Sequence from tinc system
private String SUBCON_ID_TINC;//Sequence from tinc system


    public String getCONT_ID() {
        return CONT_ID;
    }

    public void setCONT_ID(String CONT_ID) {
        this.CONT_ID = CONT_ID;
    }

    public String getCONT_LOCA() {
        return CONT_LOCA;
    }

    public void setCONT_LOCA(String CONT_LOCA) {
        this.CONT_LOCA = CONT_LOCA;
    }

    public String getCOUNTRYNAME() {
        return COUNTRYNAME;
    }

    public void setCOUNTRYNAME(String COUNTRYNAME) {
        this.COUNTRYNAME = COUNTRYNAME;
    }

    public String getCTNO() {
        return CTNO;
    }

    public void setCTNO(String CTNO) {
        this.CTNO = CTNO;
    }

    public String getCTVAL() {
        return CTVAL;
    }

    public void setCTVAL(String CTVAL) {
        this.CTVAL = CTVAL;
    }

    public String getCTVALW() {
        return CTVALW;
    }

    public void setCTVALW(String CTVALW) {
        this.CTVALW = CTVALW;
    }

    public String getEMPNB() {
        return EMPNB;
    }

    public void setEMPNB(String EMPNB) {
        this.EMPNB = EMPNB;
    }

    public String getFOREIGNER_NAME() {
        return FOREIGNER_NAME;
    }

    public void setFOREIGNER_NAME(String FOREIGNER_NAME) {
        this.FOREIGNER_NAME = FOREIGNER_NAME;
    }

    public String getLOCA_REGION() {
        return LOCA_REGION;
    }

    public void setLOCA_REGION(String LOCA_REGION) {
        this.LOCA_REGION = LOCA_REGION;
    }

    public String getREGIONNAME() {
        return REGIONNAME;
    }

    public void setREGIONNAME(String REGIONNAME) {
        this.REGIONNAME = REGIONNAME;
    }

    public String getSUBCON_ID() {
        return SUBCON_ID;
    }

    public void setSUBCON_ID(String SUBCON_ID) {
        this.SUBCON_ID = SUBCON_ID;
    }

    public String getTINFR() {
        return TINFR;
    }

    public void setTINFR(String TINFR) {
        this.TINFR = TINFR;
    }

    public String getTINVN() {
        return TINVN;
    }

    public void setTINVN(String TINVN) {
        this.TINVN = TINVN;
    }

    public String getCONT_ID_TINC() {
        return CONT_ID_TINC;
    }

    public void setCONT_ID_TINC(String CONT_ID_TINC) {
        this.CONT_ID_TINC = CONT_ID_TINC;
    }

    public String getSUBCON_ID_TINC() {
        return SUBCON_ID_TINC;
    }

    public void setSUBCON_ID_TINC(String SUBCON_ID_TINC) {
        this.SUBCON_ID_TINC = SUBCON_ID_TINC;
    }    

}
