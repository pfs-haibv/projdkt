package com.pit.convert.datatype;

/**
 *
 * @author HAIBV
 */
public class JOIN_ORG extends DKT {

private String JOIN_TIN;//Identification Number
private String CITY;//City code for city/street file
private String REGIONNAME;//Description
private String JOIN_ID_TINC;//Sequence from tinc system


    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    public String getJOIN_TIN() {
        return JOIN_TIN;
    }

    public void setJOIN_TIN(String JOIN_TIN) {
        this.JOIN_TIN = JOIN_TIN;
    }

    public String getREGIONNAME() {
        return REGIONNAME;
    }

    public void setREGIONNAME(String REGIONNAME) {
        this.REGIONNAME = REGIONNAME;
    }

    public String getJOIN_ID_TINC() {
        return JOIN_ID_TINC;
    }

    public void setJOIN_ID_TINC(String JOIN_ID_TINC) {
        this.JOIN_ID_TINC = JOIN_ID_TINC;
    }   

}
