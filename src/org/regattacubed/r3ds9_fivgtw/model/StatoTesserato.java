package org.regattacubed.r3ds9_fivgtw.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StatoTesserato {

    private int statoRicerca;
    private String personaDes;
    private String idPeriodo;
    private List<Tesseramento> tesseramenti;
    private List<InfoCertificatoMedico> certificati;

    public int getStatoRicerca() {
        return statoRicerca;
    }

    public void setStatoRicerca(int statoRicerca) {
        this.statoRicerca = statoRicerca;
    }

    @JsonIgnore
    public boolean isFound() {
        return (statoRicerca > 0 && statoRicerca < 99);
    }

    public String getPersonaDes() {
        return personaDes;
    }

    public void setPersonaDes(String personaDes) {
        this.personaDes = personaDes;
    }

    public String getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(String idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public List<Tesseramento> getTesseramenti() {
        return tesseramenti;
    }

    public void setTesseramenti(List<Tesseramento> tesseramenti) {
        this.tesseramenti = tesseramenti;
    }

    public List<InfoCertificatoMedico> getCertificati() {
        return certificati;
    }

    public void setCertificati(List<InfoCertificatoMedico> certificati) {
        this.certificati = certificati;
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

    @JsonIgnore
    public Tesseramento findTesseramento(int year) {

        Tesseramento t = null;
        if (tesseramenti != null) {
            String pdes = String.valueOf(year);
            for (Tesseramento t1 : tesseramenti) {
                if (t1.getPeriodo_des().equalsIgnoreCase(pdes)) {
                    t = t1;
                    break;
                } else {
                    if (t == null) {
                        t = t1;
                    } else if (t.getPeriodo_des().compareTo(t1.getPeriodo_des()) < 0) {
                        t = t1;
                    }
                }
            }
        }

                /* Non ritorno l'ultimo....
        if (t.getPeriodo_des().equalsIgnoreCase(String.valueOf(year))) {
            return t;
        }
         */

        return t;
    }

    public Tesseramento findLastTesseramento() {

        Tesseramento t = null;
        String period = "";
        if (tesseramenti != null) {            
            for (Tesseramento t1 : tesseramenti) {
                if (t1.getPeriodo_des().compareTo(period) > 0) {
                    t = t1;
                    period = t1.getPeriodo_des();
                } 
            }
        }


        return t;
    }

    @JsonIgnore
    public InfoCertificatoMedico findLastCertificato() {

        InfoCertificatoMedico m = null;
        if (certificati != null && certificati.size() > 0) {
           m = certificati.get(0);
        }

        return m;
    }
}
