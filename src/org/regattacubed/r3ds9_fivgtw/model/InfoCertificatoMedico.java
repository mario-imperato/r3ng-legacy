package org.regattacubed.r3ds9_fivgtw.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.regattacubed.r3ds9_fivgtw.util.DateUtil;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InfoCertificatoMedico {

    private long   idK;
    private String persona;
    private long   idPersona;
    private String codiceFiscale;
    private String descrizione;
    private int    idTipoCertificato;
    private String dataInizio;
    private String dataFine;
    private String dataFineMySql;
    private String dataIns;
    private int    eliminato;
    private int    scaduto;

    public long getIdK() {
        return idK;
    }

    public void setIdK(long idK) {
        this.idK = idK;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(long idPersona) {
        this.idPersona = idPersona;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getIdTipoCertificato() {
        return idTipoCertificato;
    }

    public void setIdTipoCertificato(int idTipoCertificato) {
        this.idTipoCertificato = idTipoCertificato;
    }

    public String getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(String dataInizio) {
        this.dataInizio = dataInizio;
    }

    public String getDataFine() {
        return DateUtil.getDateAs(dataFine, DateUtil.DateFormat.yyyy_mm_dd);
    }

    public void setDataFine(String dataFine) {
        this.dataFine = dataFine;
    }

    public String getDataFineMySql() {
        return dataFineMySql;
    }

    public void setDataFineMySql(String dataFineMySql) {
        this.dataFineMySql = dataFineMySql;
    }

    public String getDataIns() {
        return dataIns;
    }

    public void setDataIns(String dataIns) {
        this.dataIns = dataIns;
    }

    public int getEliminato() {
        return eliminato;
    }

    public void setEliminato(int eliminato) {
        this.eliminato = eliminato;
    }

    public int getScaduto() {
        return scaduto;
    }

    public void setScaduto(int scaduto) {
        this.scaduto = scaduto;
    }

    @JsonIgnore
    public String toJsonString() {
        ObjectMapper om = new ObjectMapper();

        try {
            return om.writeValueAsString(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "error converting json persona to object";
    }
}
