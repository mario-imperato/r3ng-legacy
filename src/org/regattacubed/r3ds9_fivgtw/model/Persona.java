package org.regattacubed.r3ds9_fivgtw.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Persona {

    private long   id;
    private String nome;
    private String cognome;
    private String codiceFiscale;
    private String sesso;
    private String nascita_data;
    private String nascita_luogo;
    private String nascita_luogo_codice;
    private String matricola;
    private String telefono1;
    private String email;
    private int    eliminato;
    private String campoTmp;
    private long   idPersona;
    private int    nascita_idLuogo;
    private int    cittadinanza_idNazione;
    private int    residenza_idNazione;
    private String residenza_nazione;
    private int    residenza_idComune;
    private int    residenza_idProvincia;
    private int    residenza_idRegione;
    private String residenza_indirizzo;
    private String residenza_cap;
    private String residenza_localita;
    private int    domicilio_idNazione;
    private String domicilio_nazione;
    private int    domicilio_idComune;
    private int    domicilio_idProvincia;
    private int    domicilio_idRegione;
    private String domicilio_indirizzo;
    private String domicilio_cap;
    private String domicilio_localita;
    private String telefono2;
    private String mobile;
    private String fax;
    private String skype;
    private int    documento_tipo;
    private String documento_numero;
    private int    documento_rilasciato_da;
    private int    documento_idComune;
    private int    documento_idProvincia;
    private int    documento_idRegione;
    private String documento_data_rilascio;
    private String documento_data_scadenza;
    private int    privacyTesseramento;
    private int    privacyRssd;
    private String disabile;
    private int    deceduto;
    private String deceduto_data;
    private int    idSocieta_ultimoTesseramento;
    private int    idPeriodo_ultimoTesseramento;
    private int    dSocieta_ultimoTesseramento_civile;
    private int    idPeriodo_ultimoTesseramento_civile;
    private int    membroPiuConsigli;
    private int    esenteQuotaTesseramento;
    private int    bloccata;
    private String bloccataDa;
    private String bloccataA;
    private String insolvente;
    private String insolvente_aPartireDa;
    private String comune_residenza;
    private String provincia_residenza;
    private int    bloccataDef;
    private int    etaReale;
    private String insolvente_conData;
    private int    eta;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getNascita_luogo_codice() {
        return nascita_luogo_codice;
    }

    public void setNascita_luogo_codice(String nascita_luogo_codice) {
        this.nascita_luogo_codice = nascita_luogo_codice;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEliminato() {
        return eliminato;
    }

    public void setEliminato(int eliminato) {
        this.eliminato = eliminato;
    }

    public String getCampoTmp() {
        return campoTmp;
    }

    public void setCampoTmp(String campoTmp) {
        this.campoTmp = campoTmp;
    }

    public long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(long idPersona) {
        this.idPersona = idPersona;
    }

    public int getNascita_idLuogo() {
        return nascita_idLuogo;
    }

    public void setNascita_idLuogo(int nascita_idLuogo) {
        this.nascita_idLuogo = nascita_idLuogo;
    }

    public int getCittadinanza_idNazione() {
        return cittadinanza_idNazione;
    }

    public void setCittadinanza_idNazione(int cittadinanza_idNazione) {
        this.cittadinanza_idNazione = cittadinanza_idNazione;
    }

    public int getResidenza_idNazione() {
        return residenza_idNazione;
    }

    public void setResidenza_idNazione(int residenza_idNazione) {
        this.residenza_idNazione = residenza_idNazione;
    }

    public String getResidenza_nazione() {
        return residenza_nazione;
    }

    public void setResidenza_nazione(String residenza_nazione) {
        this.residenza_nazione = residenza_nazione;
    }

    public int getResidenza_idComune() {
        return residenza_idComune;
    }

    public void setResidenza_idComune(int residenza_idComune) {
        this.residenza_idComune = residenza_idComune;
    }

    public int getResidenza_idProvincia() {
        return residenza_idProvincia;
    }

    public void setResidenza_idProvincia(int residenza_idProvincia) {
        this.residenza_idProvincia = residenza_idProvincia;
    }

    public int getResidenza_idRegione() {
        return residenza_idRegione;
    }

    public void setResidenza_idRegione(int residenza_idRegione) {
        this.residenza_idRegione = residenza_idRegione;
    }

    public String getResidenza_indirizzo() {
        return residenza_indirizzo;
    }

    public void setResidenza_indirizzo(String residenza_indirizzo) {
        this.residenza_indirizzo = residenza_indirizzo;
    }

    public String getResidenza_cap() {
        return residenza_cap;
    }

    public void setResidenza_cap(String residenza_cap) {
        this.residenza_cap = residenza_cap;
    }

    public String getResidenza_localita() {
        return residenza_localita;
    }

    public void setResidenza_localita(String residenza_localita) {
        this.residenza_localita = residenza_localita;
    }

    public int getDomicilio_idNazione() {
        return domicilio_idNazione;
    }

    public void setDomicilio_idNazione(int domicilio_idNazione) {
        this.domicilio_idNazione = domicilio_idNazione;
    }

    public String getDomicilio_nazione() {
        return domicilio_nazione;
    }

    public void setDomicilio_nazione(String domicilio_nazione) {
        this.domicilio_nazione = domicilio_nazione;
    }

    public int getDomicilio_idComune() {
        return domicilio_idComune;
    }

    public void setDomicilio_idComune(int domicilio_idComune) {
        this.domicilio_idComune = domicilio_idComune;
    }

    public int getDomicilio_idProvincia() {
        return domicilio_idProvincia;
    }

    public void setDomicilio_idProvincia(int domicilio_idProvincia) {
        this.domicilio_idProvincia = domicilio_idProvincia;
    }

    public int getDomicilio_idRegione() {
        return domicilio_idRegione;
    }

    public void setDomicilio_idRegione(int domicilio_idRegione) {
        this.domicilio_idRegione = domicilio_idRegione;
    }

    public String getDomicilio_indirizzo() {
        return domicilio_indirizzo;
    }

    public void setDomicilio_indirizzo(String domicilio_indirizzo) {
        this.domicilio_indirizzo = domicilio_indirizzo;
    }

    public String getDomicilio_cap() {
        return domicilio_cap;
    }

    public void setDomicilio_cap(String domicilio_cap) {
        this.domicilio_cap = domicilio_cap;
    }

    public String getDomicilio_localita() {
        return domicilio_localita;
    }

    public void setDomicilio_localita(String domicilio_localita) {
        this.domicilio_localita = domicilio_localita;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public int getDocumento_tipo() {
        return documento_tipo;
    }

    public void setDocumento_tipo(int documento_tipo) {
        this.documento_tipo = documento_tipo;
    }

    public String getDocumento_numero() {
        return documento_numero;
    }

    public void setDocumento_numero(String documento_numero) {
        this.documento_numero = documento_numero;
    }

    public int getDocumento_rilasciato_da() {
        return documento_rilasciato_da;
    }

    public void setDocumento_rilasciato_da(int documento_rilasciato_da) {
        this.documento_rilasciato_da = documento_rilasciato_da;
    }

    public int getDocumento_idComune() {
        return documento_idComune;
    }

    public void setDocumento_idComune(int documento_idComune) {
        this.documento_idComune = documento_idComune;
    }

    public int getDocumento_idProvincia() {
        return documento_idProvincia;
    }

    public void setDocumento_idProvincia(int documento_idProvincia) {
        this.documento_idProvincia = documento_idProvincia;
    }

    public int getDocumento_idRegione() {
        return documento_idRegione;
    }

    public void setDocumento_idRegione(int documento_idRegione) {
        this.documento_idRegione = documento_idRegione;
    }

    public String getDocumento_data_rilascio() {
        return documento_data_rilascio;
    }

    public void setDocumento_data_rilascio(String documento_data_rilascio) {
        this.documento_data_rilascio = documento_data_rilascio;
    }

    public String getDocumento_data_scadenza() {
        return documento_data_scadenza;
    }

    public void setDocumento_data_scadenza(String documento_data_scadenza) {
        this.documento_data_scadenza = documento_data_scadenza;
    }

    public int getPrivacyTesseramento() {
        return privacyTesseramento;
    }

    public void setPrivacyTesseramento(int privacyTesseramento) {
        this.privacyTesseramento = privacyTesseramento;
    }

    public int getPrivacyRssd() {
        return privacyRssd;
    }

    public void setPrivacyRssd(int privacyRssd) {
        this.privacyRssd = privacyRssd;
    }

    public String getDisabile() {
        return disabile;
    }

    public void setDisabile(String disabile) {
        this.disabile = disabile;
    }

    public int getDeceduto() {
        return deceduto;
    }

    public void setDeceduto(int deceduto) {
        this.deceduto = deceduto;
    }

    public String getDeceduto_data() {
        return deceduto_data;
    }

    public void setDeceduto_data(String deceduto_data) {
        this.deceduto_data = deceduto_data;
    }

    public int getIdSocieta_ultimoTesseramento() {
        return idSocieta_ultimoTesseramento;
    }

    public void setIdSocieta_ultimoTesseramento(int idSocieta_ultimoTesseramento) {
        this.idSocieta_ultimoTesseramento = idSocieta_ultimoTesseramento;
    }

    public int getIdPeriodo_ultimoTesseramento() {
        return idPeriodo_ultimoTesseramento;
    }

    public void setIdPeriodo_ultimoTesseramento(int idPeriodo_ultimoTesseramento) {
        this.idPeriodo_ultimoTesseramento = idPeriodo_ultimoTesseramento;
    }

    public int getdSocieta_ultimoTesseramento_civile() {
        return dSocieta_ultimoTesseramento_civile;
    }

    public void setdSocieta_ultimoTesseramento_civile(int dSocieta_ultimoTesseramento_civile) {
        this.dSocieta_ultimoTesseramento_civile = dSocieta_ultimoTesseramento_civile;
    }

    public int getIdPeriodo_ultimoTesseramento_civile() {
        return idPeriodo_ultimoTesseramento_civile;
    }

    public void setIdPeriodo_ultimoTesseramento_civile(int idPeriodo_ultimoTesseramento_civile) {
        this.idPeriodo_ultimoTesseramento_civile = idPeriodo_ultimoTesseramento_civile;
    }

    public int getMembroPiuConsigli() {
        return membroPiuConsigli;
    }

    public void setMembroPiuConsigli(int membroPiuConsigli) {
        this.membroPiuConsigli = membroPiuConsigli;
    }

    public int getEsenteQuotaTesseramento() {
        return esenteQuotaTesseramento;
    }

    public void setEsenteQuotaTesseramento(int esenteQuotaTesseramento) {
        this.esenteQuotaTesseramento = esenteQuotaTesseramento;
    }

    public int getBloccata() {
        return bloccata;
    }

    public void setBloccata(int bloccata) {
        this.bloccata = bloccata;
    }

    public String getBloccataDa() {
        return bloccataDa;
    }

    public void setBloccataDa(String bloccataDa) {
        this.bloccataDa = bloccataDa;
    }

    public String getBloccataA() {
        return bloccataA;
    }

    public void setBloccataA(String bloccataA) {
        this.bloccataA = bloccataA;
    }

    public String getInsolvente() {
        return insolvente;
    }

    public void setInsolvente(String insolvente) {
        this.insolvente = insolvente;
    }

    public String getInsolvente_aPartireDa() {
        return insolvente_aPartireDa;
    }

    public void setInsolvente_aPartireDa(String insolvente_aPartireDa) {
        this.insolvente_aPartireDa = insolvente_aPartireDa;
    }

    public String getComune_residenza() {
        return comune_residenza;
    }

    public void setComune_residenza(String comune_residenza) {
        this.comune_residenza = comune_residenza;
    }

    public String getProvincia_residenza() {
        return provincia_residenza;
    }

    public void setProvincia_residenza(String provincia_residenza) {
        this.provincia_residenza = provincia_residenza;
    }

    public int getBloccataDef() {
        return bloccataDef;
    }

    public void setBloccataDef(int bloccataDef) {
        this.bloccataDef = bloccataDef;
    }

    public int getEtaReale() {
        return etaReale;
    }

    public void setEtaReale(int etaReale) {
        this.etaReale = etaReale;
    }

    public String getInsolvente_conData() {
        return insolvente_conData;
    }

    public void setInsolvente_conData(String insolvente_conData) {
        this.insolvente_conData = insolvente_conData;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
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
