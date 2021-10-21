package org.regattacubed.r3ds9_fivgtw.resources.persona;

import org.regattacubed.r3ds9_fivgtw.resources.Query;

import java.net.URI;
import java.net.URISyntaxException;

public class QueryPersona extends Query {

    /*
     * campi di query.
     *
     * cognome (like '....%')
     * nome: (like '....%')
     * codiceFiscale
     * matricola
     * dataNascita_da (format - yyyy-MM-dd)
     * dataNascita_a (format - yyyy-MM-dd)
     * email
     * telefono
     */

    public QueryPersona withMatricola(long matricola) {
        withParam("matricola", String.valueOf(matricola));
        return this;
    }

    public QueryPersona withCognome(String aCognome) {
        withParam("cognome", aCognome);
        return this;
    }

    public QueryPersona withNome(String aNome) {
        withParam("nome", aNome);
        return this;
    }

    public QueryPersona withCodiceFiscale(String aCodiceFiscale) {
        withParam("codiceFiscale", aCodiceFiscale);
        return this;
    }

    public QueryPersona withDataNascita_da(String aDataNascita_da) {
        withParam("dataNascita_da", aDataNascita_da);
        return this;
    }

    public QueryPersona withDataNascita_a(String aDataNascita_a) {
        withParam("dataNascita_a", aDataNascita_a);
        return this;
    }

    public QueryPersona withEmail(String email) {
        withParam("email", email);
        return this;
    }

    public QueryPersona withTelefono(String telefono) {
        withParam("telefono", telefono);
        return this;
    }

    public QueryPersona orderByCognome() {
        withOrder("cognome");
        return this;
    }

    @Override
    public URI getUri() throws URISyntaxException {
        return new URI("/rest/Persone/PersonaHandle/elenco");
    }
}
