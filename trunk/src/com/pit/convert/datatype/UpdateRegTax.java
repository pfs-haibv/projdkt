/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pit.convert.datatype;

/**
 *
 * @author QuanPTT
 */
public class UpdateRegTax {

    private String PARTNER;
    private String TYPE;
    private String ORSTA;
    private String ORRES;
    private String BUKRS;
    private String REDAT;
    private String PRCTR;
    private String GSBER;
    private String BPKIND;

    public UpdateRegTax() {
    }

    public UpdateRegTax(String PARTNER, String TYPE, String ORSTA, String ORRES, String BUKRS, String REDAT, String PRCTR, String GSBER, String BPKIND) {
        this.PARTNER = PARTNER;
        this.TYPE = TYPE;
        this.ORSTA = ORSTA;
        this.ORRES = ORRES;
        this.BUKRS = BUKRS;
        this.REDAT = REDAT;
        this.PRCTR = PRCTR;
        this.GSBER = GSBER;
        this.BPKIND = BPKIND;
    }

    public String getBPKIND() {
        return BPKIND;
    }

    public void setBPKIND(String BPKIND) {
        this.BPKIND = BPKIND;
    }

    public String getBUKRS() {
        return BUKRS;
    }

    public void setBUKRS(String BUKRS) {
        this.BUKRS = BUKRS;
    }

    public String getGSBER() {
        return GSBER;
    }

    public void setGSBER(String GSBER) {
        this.GSBER = GSBER;
    }

    public String getORRES() {
        return ORRES;
    }

    public void setORRES(String ORRES) {
        this.ORRES = ORRES;
    }

    public String getORSTA() {
        return ORSTA;
    }

    public void setORSTA(String ORSTA) {
        this.ORSTA = ORSTA;
    }

    public String getPARTNER() {
        return PARTNER;
    }

    public void setPARTNER(String PARTNER) {
        this.PARTNER = PARTNER;
    }

    public String getPRCTR() {
        return PRCTR;
    }

    public void setPRCTR(String PRCTR) {
        this.PRCTR = PRCTR;
    }

    public String getREDAT() {
        return REDAT;
    }

    public void setREDAT(String REDAT) {
        this.REDAT = REDAT;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }
}
