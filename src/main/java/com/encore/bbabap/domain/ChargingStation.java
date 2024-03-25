package com.encore.bbabap.domain;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "item")
public class ChargingStation {
    private String objtId;
    private String statNm;
    private String statId;
    private String chgerId;
    private String chgerTy;
    private String useTm;
    private String busiId;
    private String busiNm;
    private String telno;
    private String adres;
    private String rnAdres;
    private String ctprvnCd;
    private String sggCd;
    private String emdCd;
    private String x;
    private String y;

    @XmlElement(name = "OBJT_ID")
    public String getObjtId() {
        return objtId;
    }

    public void setObjtId(String objtId) {
        this.objtId = objtId;
    }

    @XmlElement(name = "STAT_NM")
    public String getStatNm() {
        return statNm;
    }

    public void setStatNm(String statNm) {
        this.statNm = statNm;
    }

    @XmlElement(name = "STAT_ID")
    public String getStatId() {
        return statId;
    }

    public void setStatId(String statId) {
        this.statId = statId;
    }

    @XmlElement(name = "CHGER_ID")
    public String getChgerId() {
        return chgerId;
    }

    public void setChgerId(String chgerId) {
        this.chgerId = chgerId;
    }

    @XmlElement(name = "CHGER_TY")
    public String getChgerTy() {
        return chgerTy;
    }

    public void setChgerTy(String chgerTy) {
        this.chgerTy = chgerTy;
    }

    @XmlElement(name = "USE_TM")
    public String getUseTm() {
        return useTm;
    }

    public void setUseTm(String useTm) {
        this.useTm = useTm;
    }

    @XmlElement(name = "BUSI_ID")
    public String getBusiId() {
        return busiId;
    }

    public void setBusiId(String busiId) {
        this.busiId = busiId;
    }

    @XmlElement(name = "BUSI_NM")
    public String getBusiNm() {
        return busiNm;
    }

    public void setBusiNm(String busiNm) {
        this.busiNm = busiNm;
    }

    @XmlElement(name = "TELNO")
    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }

    @XmlElement(name = "ADRES")
    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    @XmlElement(name = "RN_ADRES")
    public String getRnAdres() {
        return rnAdres;
    }

    public void setRnAdres(String rnAdres) {
        this.rnAdres = rnAdres;
    }

    @XmlElement(name = "CTPRVN_CD")
    public String getCtprvnCd() {
        return ctprvnCd;
    }

    public void setCtprvnCd(String ctprvnCd) {
        this.ctprvnCd = ctprvnCd;
    }

    @XmlElement(name = "SGG_CD")
    public String getSggCd() {
        return sggCd;
    }

    public void setSggCd(String sggCd) {
        this.sggCd = sggCd;
    }

    @XmlElement(name = "EMD_CD")
    public String getEmdCd() {
        return emdCd;
    }

    public void setEmdCd(String emdCd) {
        this.emdCd = emdCd;
    }

    @XmlElement(name = "X")
    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }
    // 마지막 필드의 Getter와 Setter
    @XmlElement(name = "Y")
    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }
}
