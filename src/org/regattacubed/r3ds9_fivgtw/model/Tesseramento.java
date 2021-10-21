package org.regattacubed.r3ds9_fivgtw.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.regattacubed.r3ds9_fivgtw.util.DateUtil;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Tesseramento {

    private long id;
    private long idK;
    private long codiceTessera;
    private String dataEmissione;
    private String dataScadenza;
    private int approvato;
    private long idPersona;
    private String necessarioPermesso;
    private int stato;
    private String periodo_des;
    private int societa_id;
    private String societa_des;
    private String discipline_des;
    private String discipline;
    private String discipline_rssd;
    private String tesserato_nome;
    private String tesserato_cognome;
    private String tesserato_dataNascita;
    private String tesserato_codiceFiscale;
    private String persona_des;
    private String tesserato_sesso;
    private int idTipoTessera;
    private int idCategoria;
    private String tipoTessera;
    private String tipoTessera_complete;
    private String categoria;
    private String codiceCategoria;
    private String tesserato_provincia_residenza;
    private String telefono1;
    private int livelloTessera;
    private String comitato_des;
    private String ultimaAffiliazione_codice;
    private int privacy1;
    private int privacy2;
    private int privacy3;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdK() {
        return idK;
    }

    public void setIdK(long idK) {
        this.idK = idK;
    }

    public long getCodiceTessera() {
        return codiceTessera;
    }

    public void setCodiceTessera(long codiceTessera) {
        this.codiceTessera = codiceTessera;
    }

    public String getDataEmissione() {
        return DateUtil.getDateAs(dataEmissione, DateUtil.DateFormat.yyyy_mm_dd);
    }

    public void setDataEmissione(String dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public String getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(String dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public int getApprovato() {
        return approvato;
    }

    public void setApprovato(int approvato) {
        this.approvato = approvato;
    }

    public long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(long idPersona) {
        this.idPersona = idPersona;
    }

    public String getNecessarioPermesso() {
        return necessarioPermesso;
    }

    public void setNecessarioPermesso(String necessarioPermesso) {
        this.necessarioPermesso = necessarioPermesso;
    }

    public int getStato() {
        return stato;
    }

    public void setStato(int stato) {
        this.stato = stato;
    }

    public String getPeriodo_des() {
        return periodo_des;
    }

    public void setPeriodo_des(String periodo_des) {
        this.periodo_des = periodo_des;
    }

    public int getSocieta_id() {
        return societa_id;
    }

    public void setSocieta_id(int societa_id) {
        this.societa_id = societa_id;
    }

    public String getSocieta_des() {
        return societa_des;
    }

    public void setSocieta_des(String societa_des) {
        this.societa_des = societa_des;
    }

    public String getDiscipline_des() {
        return discipline_des;
    }

    public void setDiscipline_des(String discipline_des) {
        this.discipline_des = discipline_des;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getDiscipline_rssd() {
        return discipline_rssd;
    }

    public void setDiscipline_rssd(String discipline_rssd) {
        this.discipline_rssd = discipline_rssd;
    }

    public String getTesserato_nome() {
        return tesserato_nome;
    }

    public void setTesserato_nome(String tesserato_nome) {
        this.tesserato_nome = tesserato_nome;
    }

    public String getTesserato_cognome() {
        return tesserato_cognome;
    }

    public void setTesserato_cognome(String tesserato_cognome) {
        this.tesserato_cognome = tesserato_cognome;
    }

    public String getTesserato_dataNascita() {
        return DateUtil.getDateAs(tesserato_dataNascita, DateUtil.DateFormat.yyyy_mm_dd);
    }

    public void setTesserato_dataNascita(String tesserato_dataNascita) {
        this.tesserato_dataNascita = tesserato_dataNascita;
    }

    public String getTesserato_codiceFiscale() {
        return tesserato_codiceFiscale;
    }

    public void setTesserato_codiceFiscale(String tesserato_codiceFiscale) {
        this.tesserato_codiceFiscale = tesserato_codiceFiscale;
    }

    public String getPersona_des() {
        return persona_des;
    }

    public void setPersona_des(String persona_des) {
        this.persona_des = persona_des;
    }

    public String getTesserato_sesso() {
        return tesserato_sesso;
    }

    public void setTesserato_sesso(String tesserato_sesso) {
        this.tesserato_sesso = tesserato_sesso;
    }

    public int getIdTipoTessera() {
        return idTipoTessera;
    }

    public void setIdTipoTessera(int idTipoTessera) {
        this.idTipoTessera = idTipoTessera;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getTipoTessera() {
        return tipoTessera;
    }

    public void setTipoTessera(String tipoTessera) {
        this.tipoTessera = tipoTessera;
    }

    public String getTipoTessera_complete() {
        return tipoTessera_complete;
    }

    public void setTipoTessera_complete(String tipoTessera_complete) {
        this.tipoTessera_complete = tipoTessera_complete;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCodiceCategoria() {
        return codiceCategoria;
    }

    public void setCodiceCategoria(String codiceCategoria) {
        this.codiceCategoria = codiceCategoria;
    }

    public String getTesserato_provincia_residenza() {
        return tesserato_provincia_residenza;
    }

    public void setTesserato_provincia_residenza(String tesserato_provincia_residenza) {
        this.tesserato_provincia_residenza = tesserato_provincia_residenza;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public int getLivelloTessera() {
        return livelloTessera;
    }

    public void setLivelloTessera(int livelloTessera) {
        this.livelloTessera = livelloTessera;
    }

    public String getComitato_des() {
        return comitato_des;
    }

    public void setComitato_des(String comitato_des) {
        this.comitato_des = comitato_des;
    }

    public String getUltimaAffiliazione_codice() {
        return ultimaAffiliazione_codice;
    }

    public void setUltimaAffiliazione_codice(String ultimaAffiliazione_codice) {
        this.ultimaAffiliazione_codice = ultimaAffiliazione_codice;
    }

    public int getPrivacy1() {
        return privacy1;
    }

    public void setPrivacy1(int privacy1) {
        this.privacy1 = privacy1;
    }

    public int getPrivacy2() {
        return privacy2;
    }

    public void setPrivacy2(int privacy2) {
        this.privacy2 = privacy2;
    }

    public int getPrivacy3() {
        return privacy3;
    }

    public void setPrivacy3(int privacy3) {
        this.privacy3 = privacy3;
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
