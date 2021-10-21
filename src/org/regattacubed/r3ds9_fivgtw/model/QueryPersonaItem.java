package org.regattacubed.r3ds9_fivgtw.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryPersonaItem {

    private long   idK              ;
    private String nome             ;
    private String cognome          ;
    private String codiceFiscale    ;
    private String sesso            ;
    private long   matricola        ;
    private String nascita_data     ;
    private String nascita_luogo    ;
    private int    utenzaCreata     ;
    private int    idSesso          ;
    private String icona            ;
    private int    bloccataDef      ;
    private int    insolvente       ;

    public long getIdK() {
        return idK;
    }

    public void setIdK(long idK) {
        this.idK = idK;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public long getMatricola() {
        return matricola;
    }

    public void setMatricola(long matricola) {
        this.matricola = matricola;
    }

    public String getNascita_data() {
        return nascita_data;
    }

    public void setNascita_data(String nascita_data) {
        this.nascita_data = nascita_data;
    }

    public String getNascita_luogo() {
        return nascita_luogo;
    }

    public void setNascita_luogo(String nascita_luogo) {
        this.nascita_luogo = nascita_luogo;
    }

    public int getUtenzaCreata() {
        return utenzaCreata;
    }

    public void setUtenzaCreata(int utenzaCreata) {
        this.utenzaCreata = utenzaCreata;
    }

    public int getIdSesso() {
        return idSesso;
    }

    public void setIdSesso(int idSesso) {
        this.idSesso = idSesso;
    }

    public String getIcona() {
        return icona;
    }

    public void setIcona(String icona) {
        this.icona = icona;
    }

    public int getBloccataDef() {
        return bloccataDef;
    }

    public void setBloccataDef(int bloccataDef) {
        this.bloccataDef = bloccataDef;
    }

    public int getInsolvente() {
        return insolvente;
    }

    public void setInsolvente(int insolvente) {
        this.insolvente = insolvente;
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
