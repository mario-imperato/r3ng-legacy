package org.regattacubed.r3ds9_fivgtw.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Societa {
    private long   id;
    private String denominazione_ufficiale;
    private String denominazione_abbreviata;
    private String codiceFiscale;
    private String partitaIva;
    private int    sedeLegale_comune_codice;
    private String sedeLegale_comune;
    private String sedeLegale_indirizzo;
    private String ultimaAffiliazione_codice;
    private String ultimaAffiliazione_comitato;
    private String ultimaAffiliazione_idComitato;
    private String ultimaAffiliazione_idComitato_padre;
    private String ultimaAffiliazione_periodo;
    private String ultimaAffiliazione_stato;
    private String ultimaAffiliazione_dataInizio;
    private String ultimaAffiliazione_dataFine;
    private String maxScoperto;
    private int    eliminato;
    private String testoWeb;
    private int    idSocieta;
    private long   responsabileLegale_idPersona;
    private long   referente_idPersona;
    private int    naturaGiuridica_id;
    private int    amministratoreUnico;
    private int    polisportiva;
    private int    attivitaParalimpica;
    private String primaAffiliazione;
    private String email;
    private String pec;
    private String iban;
    private String web;
    private String attoCostitutivo_descrizione;
    private String attoCostitutivo_data;
    private String statutoVigente;
    private String statutoVigente_data;
    private int    gruppoSportivo_id;
    private String costituzione_data;
    private int    sedeLegale_idComune;
    private String sedeLegale_presso;
    private String sedeLegale_localita;
    private String sedeLegale_cap;
    private String sedeLegale_telefono;
    private String sedeLegale_telefono2;
    private String sedeLegale_fax;
    private String sedeLegale_mobile;
    private int    sedeRecapito_idComune;
    private String sedeRecapito_presso;
    private String sedeRecapito_localita;
    private String sedeRecapito_cap;
    private String sedeRecapito_indirizzo;
    private int    sciolta;
    private String sciolta_data;
    private String note;
    private int    idTipoSocieta;
    private int    sedeSociale_idComune;
    private String sedeSociale_indirizzo;
    private String sedeSociale_localita;
    private String sedeSociale_cap;
    private String sedeSociale_telefono;
    private String sedeSociale_telefono2;
    private String sedeSociale_fax;
    private String sedeSociale_email;
    private String banca_intestatario;
    private String banca_banca;
    private String banca_agenzia;
    private String sedeSociale_mobile;
    private int    bloccata;
    private int    affiliazioneSenzaRequisiti;
    private String bloccataDa;
    private String bloccataA;
    private String insolvente;
    private String insolvente_aPartireDa;
    private int    autorizzazioneSEPA;
    private String ultimaAffiliazione_codiceComitato;
    private String bloccataDef;
    private String naturaGiuridica;
    private int    sedeLegale_idProvincia;
    private String sedeLegale_comuneNome;
    private String sedeLegale_provincia;
    private String sedeSociale_comune;
    private String sedeSociale_provincia;
    private String sedePostale_comune;
    private String sedePostale_provincia;
    private String tipoSocieta;
    private int    insolvente_conData;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDenominazione_ufficiale() {
        return denominazione_ufficiale;
    }

    public void setDenominazione_ufficiale(String denominazione_ufficiale) {
        this.denominazione_ufficiale = denominazione_ufficiale;
    }

    public String getDenominazione_abbreviata() {
        return denominazione_abbreviata;
    }

    public void setDenominazione_abbreviata(String denominazione_abbreviata) {
        this.denominazione_abbreviata = denominazione_abbreviata;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getPartitaIva() {
        return partitaIva;
    }

    public void setPartitaIva(String partitaIva) {
        this.partitaIva = partitaIva;
    }

    public int getSedeLegale_comune_codice() {
        return sedeLegale_comune_codice;
    }

    public void setSedeLegale_comune_codice(int sedeLegale_comune_codice) {
        this.sedeLegale_comune_codice = sedeLegale_comune_codice;
    }

    public String getSedeLegale_comune() {
        return sedeLegale_comune;
    }

    public void setSedeLegale_comune(String sedeLegale_comune) {
        this.sedeLegale_comune = sedeLegale_comune;
    }

    public String getSedeLegale_indirizzo() {
        return sedeLegale_indirizzo;
    }

    public void setSedeLegale_indirizzo(String sedeLegale_indirizzo) {
        this.sedeLegale_indirizzo = sedeLegale_indirizzo;
    }

    public String getUltimaAffiliazione_codice() {
        return ultimaAffiliazione_codice;
    }

    public void setUltimaAffiliazione_codice(String ultimaAffiliazione_codice) {
        this.ultimaAffiliazione_codice = ultimaAffiliazione_codice;
    }

    public String getUltimaAffiliazione_comitato() {
        return ultimaAffiliazione_comitato;
    }

    public void setUltimaAffiliazione_comitato(String ultimaAffiliazione_comitato) {
        this.ultimaAffiliazione_comitato = ultimaAffiliazione_comitato;
    }

    public String getUltimaAffiliazione_idComitato() {
        return ultimaAffiliazione_idComitato;
    }

    public void setUltimaAffiliazione_idComitato(String ultimaAffiliazione_idComitato) {
        this.ultimaAffiliazione_idComitato = ultimaAffiliazione_idComitato;
    }

    public String getUltimaAffiliazione_idComitato_padre() {
        return ultimaAffiliazione_idComitato_padre;
    }

    public void setUltimaAffiliazione_idComitato_padre(String ultimaAffiliazione_idComitato_padre) {
        this.ultimaAffiliazione_idComitato_padre = ultimaAffiliazione_idComitato_padre;
    }

    public String getUltimaAffiliazione_periodo() {
        return ultimaAffiliazione_periodo;
    }

    public void setUltimaAffiliazione_periodo(String ultimaAffiliazione_periodo) {
        this.ultimaAffiliazione_periodo = ultimaAffiliazione_periodo;
    }

    public String getUltimaAffiliazione_stato() {
        return ultimaAffiliazione_stato;
    }

    public void setUltimaAffiliazione_stato(String ultimaAffiliazione_stato) {
        this.ultimaAffiliazione_stato = ultimaAffiliazione_stato;
    }

    public String getUltimaAffiliazione_dataInizio() {
        return ultimaAffiliazione_dataInizio;
    }

    public void setUltimaAffiliazione_dataInizio(String ultimaAffiliazione_dataInizio) {
        this.ultimaAffiliazione_dataInizio = ultimaAffiliazione_dataInizio;
    }

    public String getUltimaAffiliazione_dataFine() {
        return ultimaAffiliazione_dataFine;
    }

    public void setUltimaAffiliazione_dataFine(String ultimaAffiliazione_dataFine) {
        this.ultimaAffiliazione_dataFine = ultimaAffiliazione_dataFine;
    }

    public String getMaxScoperto() {
        return maxScoperto;
    }

    public void setMaxScoperto(String maxScoperto) {
        this.maxScoperto = maxScoperto;
    }

    public int getEliminato() {
        return eliminato;
    }

    public void setEliminato(int eliminato) {
        this.eliminato = eliminato;
    }

    public String getTestoWeb() {
        return testoWeb;
    }

    public void setTestoWeb(String testoWeb) {
        this.testoWeb = testoWeb;
    }

    public int getIdSocieta() {
        return idSocieta;
    }

    public void setIdSocieta(int idSocieta) {
        this.idSocieta = idSocieta;
    }

    public long getResponsabileLegale_idPersona() {
        return responsabileLegale_idPersona;
    }

    public void setResponsabileLegale_idPersona(long responsabileLegale_idPersona) {
        this.responsabileLegale_idPersona = responsabileLegale_idPersona;
    }

    public long getReferente_idPersona() {
        return referente_idPersona;
    }

    public void setReferente_idPersona(long referente_idPersona) {
        this.referente_idPersona = referente_idPersona;
    }

    public int getNaturaGiuridica_id() {
        return naturaGiuridica_id;
    }

    public void setNaturaGiuridica_id(int naturaGiuridica_id) {
        this.naturaGiuridica_id = naturaGiuridica_id;
    }

    public int getAmministratoreUnico() {
        return amministratoreUnico;
    }

    public void setAmministratoreUnico(int amministratoreUnico) {
        this.amministratoreUnico = amministratoreUnico;
    }

    public int getPolisportiva() {
        return polisportiva;
    }

    public void setPolisportiva(int polisportiva) {
        this.polisportiva = polisportiva;
    }

    public int getAttivitaParalimpica() {
        return attivitaParalimpica;
    }

    public void setAttivitaParalimpica(int attivitaParalimpica) {
        this.attivitaParalimpica = attivitaParalimpica;
    }

    public String getPrimaAffiliazione() {
        return primaAffiliazione;
    }

    public void setPrimaAffiliazione(String primaAffiliazione) {
        this.primaAffiliazione = primaAffiliazione;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPec() {
        return pec;
    }

    public void setPec(String pec) {
        this.pec = pec;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getAttoCostitutivo_descrizione() {
        return attoCostitutivo_descrizione;
    }

    public void setAttoCostitutivo_descrizione(String attoCostitutivo_descrizione) {
        this.attoCostitutivo_descrizione = attoCostitutivo_descrizione;
    }

    public String getAttoCostitutivo_data() {
        return attoCostitutivo_data;
    }

    public void setAttoCostitutivo_data(String attoCostitutivo_data) {
        this.attoCostitutivo_data = attoCostitutivo_data;
    }

    public String getStatutoVigente() {
        return statutoVigente;
    }

    public void setStatutoVigente(String statutoVigente) {
        this.statutoVigente = statutoVigente;
    }

    public String getStatutoVigente_data() {
        return statutoVigente_data;
    }

    public void setStatutoVigente_data(String statutoVigente_data) {
        this.statutoVigente_data = statutoVigente_data;
    }

    public int getGruppoSportivo_id() {
        return gruppoSportivo_id;
    }

    public void setGruppoSportivo_id(int gruppoSportivo_id) {
        this.gruppoSportivo_id = gruppoSportivo_id;
    }

    public String getCostituzione_data() {
        return costituzione_data;
    }

    public void setCostituzione_data(String costituzione_data) {
        this.costituzione_data = costituzione_data;
    }

    public int getSedeLegale_idComune() {
        return sedeLegale_idComune;
    }

    public void setSedeLegale_idComune(int sedeLegale_idComune) {
        this.sedeLegale_idComune = sedeLegale_idComune;
    }

    public String getSedeLegale_presso() {
        return sedeLegale_presso;
    }

    public void setSedeLegale_presso(String sedeLegale_presso) {
        this.sedeLegale_presso = sedeLegale_presso;
    }

    public String getSedeLegale_localita() {
        return sedeLegale_localita;
    }

    public void setSedeLegale_localita(String sedeLegale_localita) {
        this.sedeLegale_localita = sedeLegale_localita;
    }

    public String getSedeLegale_cap() {
        return sedeLegale_cap;
    }

    public void setSedeLegale_cap(String sedeLegale_cap) {
        this.sedeLegale_cap = sedeLegale_cap;
    }

    public String getSedeLegale_telefono() {
        return sedeLegale_telefono;
    }

    public void setSedeLegale_telefono(String sedeLegale_telefono) {
        this.sedeLegale_telefono = sedeLegale_telefono;
    }

    public String getSedeLegale_telefono2() {
        return sedeLegale_telefono2;
    }

    public void setSedeLegale_telefono2(String sedeLegale_telefono2) {
        this.sedeLegale_telefono2 = sedeLegale_telefono2;
    }

    public String getSedeLegale_fax() {
        return sedeLegale_fax;
    }

    public void setSedeLegale_fax(String sedeLegale_fax) {
        this.sedeLegale_fax = sedeLegale_fax;
    }

    public String getSedeLegale_mobile() {
        return sedeLegale_mobile;
    }

    public void setSedeLegale_mobile(String sedeLegale_mobile) {
        this.sedeLegale_mobile = sedeLegale_mobile;
    }

    public int getSedeRecapito_idComune() {
        return sedeRecapito_idComune;
    }

    public void setSedeRecapito_idComune(int sedeRecapito_idComune) {
        this.sedeRecapito_idComune = sedeRecapito_idComune;
    }

    public String getSedeRecapito_presso() {
        return sedeRecapito_presso;
    }

    public void setSedeRecapito_presso(String sedeRecapito_presso) {
        this.sedeRecapito_presso = sedeRecapito_presso;
    }

    public String getSedeRecapito_localita() {
        return sedeRecapito_localita;
    }

    public void setSedeRecapito_localita(String sedeRecapito_localita) {
        this.sedeRecapito_localita = sedeRecapito_localita;
    }

    public String getSedeRecapito_cap() {
        return sedeRecapito_cap;
    }

    public void setSedeRecapito_cap(String sedeRecapito_cap) {
        this.sedeRecapito_cap = sedeRecapito_cap;
    }

    public String getSedeRecapito_indirizzo() {
        return sedeRecapito_indirizzo;
    }

    public void setSedeRecapito_indirizzo(String sedeRecapito_indirizzo) {
        this.sedeRecapito_indirizzo = sedeRecapito_indirizzo;
    }

    public int getSciolta() {
        return sciolta;
    }

    public void setSciolta(int sciolta) {
        this.sciolta = sciolta;
    }

    public String getSciolta_data() {
        return sciolta_data;
    }

    public void setSciolta_data(String sciolta_data) {
        this.sciolta_data = sciolta_data;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getIdTipoSocieta() {
        return idTipoSocieta;
    }

    public void setIdTipoSocieta(int idTipoSocieta) {
        this.idTipoSocieta = idTipoSocieta;
    }

    public int getSedeSociale_idComune() {
        return sedeSociale_idComune;
    }

    public void setSedeSociale_idComune(int sedeSociale_idComune) {
        this.sedeSociale_idComune = sedeSociale_idComune;
    }

    public String getSedeSociale_indirizzo() {
        return sedeSociale_indirizzo;
    }

    public void setSedeSociale_indirizzo(String sedeSociale_indirizzo) {
        this.sedeSociale_indirizzo = sedeSociale_indirizzo;
    }

    public String getSedeSociale_localita() {
        return sedeSociale_localita;
    }

    public void setSedeSociale_localita(String sedeSociale_localita) {
        this.sedeSociale_localita = sedeSociale_localita;
    }

    public String getSedeSociale_cap() {
        return sedeSociale_cap;
    }

    public void setSedeSociale_cap(String sedeSociale_cap) {
        this.sedeSociale_cap = sedeSociale_cap;
    }

    public String getSedeSociale_telefono() {
        return sedeSociale_telefono;
    }

    public void setSedeSociale_telefono(String sedeSociale_telefono) {
        this.sedeSociale_telefono = sedeSociale_telefono;
    }

    public String getSedeSociale_telefono2() {
        return sedeSociale_telefono2;
    }

    public void setSedeSociale_telefono2(String sedeSociale_telefono2) {
        this.sedeSociale_telefono2 = sedeSociale_telefono2;
    }

    public String getSedeSociale_fax() {
        return sedeSociale_fax;
    }

    public void setSedeSociale_fax(String sedeSociale_fax) {
        this.sedeSociale_fax = sedeSociale_fax;
    }

    public String getSedeSociale_email() {
        return sedeSociale_email;
    }

    public void setSedeSociale_email(String sedeSociale_email) {
        this.sedeSociale_email = sedeSociale_email;
    }

    public String getBanca_intestatario() {
        return banca_intestatario;
    }

    public void setBanca_intestatario(String banca_intestatario) {
        this.banca_intestatario = banca_intestatario;
    }

    public String getBanca_banca() {
        return banca_banca;
    }

    public void setBanca_banca(String banca_banca) {
        this.banca_banca = banca_banca;
    }

    public String getBanca_agenzia() {
        return banca_agenzia;
    }

    public void setBanca_agenzia(String banca_agenzia) {
        this.banca_agenzia = banca_agenzia;
    }

    public String getSedeSociale_mobile() {
        return sedeSociale_mobile;
    }

    public void setSedeSociale_mobile(String sedeSociale_mobile) {
        this.sedeSociale_mobile = sedeSociale_mobile;
    }

    public int getBloccata() {
        return bloccata;
    }

    public void setBloccata(int bloccata) {
        this.bloccata = bloccata;
    }

    public int getAffiliazioneSenzaRequisiti() {
        return affiliazioneSenzaRequisiti;
    }

    public void setAffiliazioneSenzaRequisiti(int affiliazioneSenzaRequisiti) {
        this.affiliazioneSenzaRequisiti = affiliazioneSenzaRequisiti;
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

    public int getAutorizzazioneSEPA() {
        return autorizzazioneSEPA;
    }

    public void setAutorizzazioneSEPA(int autorizzazioneSEPA) {
        this.autorizzazioneSEPA = autorizzazioneSEPA;
    }

    public String getUltimaAffiliazione_codiceComitato() {
        return ultimaAffiliazione_codiceComitato;
    }

    public void setUltimaAffiliazione_codiceComitato(String ultimaAffiliazione_codiceComitato) {
        this.ultimaAffiliazione_codiceComitato = ultimaAffiliazione_codiceComitato;
    }

    public String getBloccataDef() {
        return bloccataDef;
    }

    public void setBloccataDef(String bloccataDef) {
        this.bloccataDef = bloccataDef;
    }

    public String getNaturaGiuridica() {
        return naturaGiuridica;
    }

    public void setNaturaGiuridica(String naturaGiuridica) {
        this.naturaGiuridica = naturaGiuridica;
    }

    public int getSedeLegale_idProvincia() {
        return sedeLegale_idProvincia;
    }

    public void setSedeLegale_idProvincia(int sedeLegale_idProvincia) {
        this.sedeLegale_idProvincia = sedeLegale_idProvincia;
    }

    public String getSedeLegale_comuneNome() {
        return sedeLegale_comuneNome;
    }

    public void setSedeLegale_comuneNome(String sedeLegale_comuneNome) {
        this.sedeLegale_comuneNome = sedeLegale_comuneNome;
    }

    public String getSedeLegale_provincia() {
        return sedeLegale_provincia;
    }

    public void setSedeLegale_provincia(String sedeLegale_provincia) {
        this.sedeLegale_provincia = sedeLegale_provincia;
    }

    public String getSedeSociale_comune() {
        return sedeSociale_comune;
    }

    public void setSedeSociale_comune(String sedeSociale_comune) {
        this.sedeSociale_comune = sedeSociale_comune;
    }

    public String getSedeSociale_provincia() {
        return sedeSociale_provincia;
    }

    public void setSedeSociale_provincia(String sedeSociale_provincia) {
        this.sedeSociale_provincia = sedeSociale_provincia;
    }

    public String getSedePostale_comune() {
        return sedePostale_comune;
    }

    public void setSedePostale_comune(String sedePostale_comune) {
        this.sedePostale_comune = sedePostale_comune;
    }

    public String getSedePostale_provincia() {
        return sedePostale_provincia;
    }

    public void setSedePostale_provincia(String sedePostale_provincia) {
        this.sedePostale_provincia = sedePostale_provincia;
    }

    public String getTipoSocieta() {
        return tipoSocieta;
    }

    public void setTipoSocieta(String tipoSocieta) {
        this.tipoSocieta = tipoSocieta;
    }

    public int getInsolvente_conData() {
        return insolvente_conData;
    }

    public void setInsolvente_conData(int insolvente_conData) {
        this.insolvente_conData = insolvente_conData;
    }

    @JsonIgnore
    public String toJsonString() {
        ObjectMapper om = new ObjectMapper();

        try {
            return om.writeValueAsString(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "error converting json stato-tesserato to object";
    }
}
