package com.pit.convert.datatype;

/**
 *
 * @author HAIBV
 */
public class DIPLOMATIC {

private String STAFF_ID;//sequence number
private String NAME;//Name of Diplomatic Staff
private String NATIONALITY;//Country Key
private String COUNTRYT;//Country Name
private String STAFF_POS;//Staff Position
private String ID_CARD_NO;//Passport or ID card
private String STAFF_ID_TINC;

    public DIPLOMATIC() {
    }

    public DIPLOMATIC(String STAFF_ID, String NAME, String NATIONALITY, String COUNTRYT, String STAFF_POS, String ID_CARD_NO) {
        this.STAFF_ID = STAFF_ID;
        this.NAME = NAME;
        this.NATIONALITY = NATIONALITY;
        this.COUNTRYT = COUNTRYT;
        this.STAFF_POS = STAFF_POS;
        this.ID_CARD_NO = ID_CARD_NO;
    }

    public String getCOUNTRYT() {
        return COUNTRYT;
    }

    public void setCOUNTRYT(String COUNTRYT) {
        this.COUNTRYT = COUNTRYT;
    }

    public String getID_CARD_NO() {
        return ID_CARD_NO;
    }

    public void setID_CARD_NO(String ID_CARD_NO) {
        this.ID_CARD_NO = ID_CARD_NO;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getNATIONALITY() {
        return NATIONALITY;
    }

    public void setNATIONALITY(String NATIONALITY) {
        this.NATIONALITY = NATIONALITY;
    }

    public String getSTAFF_ID() {
        return STAFF_ID;
    }

    public void setSTAFF_ID(String STAFF_ID) {
        this.STAFF_ID = STAFF_ID;
    }

    public String getSTAFF_POS() {
        return STAFF_POS;
    }

    public void setSTAFF_POS(String STAFF_POS) {
        this.STAFF_POS = STAFF_POS;
    }

    public String getSTAFF_ID_TINC() {
        return STAFF_ID_TINC;
    }

    public void setSTAFF_ID_TINC(String STAFF_ID_TINC) {
        this.STAFF_ID_TINC = STAFF_ID_TINC;
    }  

}
