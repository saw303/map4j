package ch.silviowangler.map4j;

import java.util.Date;

/**
 * Created by Silvio Wangler on 17/03/16.
 */
public class PartnerDTO {

    private String vorname;
    private String nachname;
    private Date geburtstag;
    private String telephone;

    public PartnerDTO() {
    }

    public PartnerDTO(String vorname, String nachname, Date geburtstag, String telephone) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtstag = geburtstag;
        this.telephone = telephone;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public Date getGeburtstag() {
        return geburtstag;
    }

    public void setGeburtstag(Date geburtstag) {
        this.geburtstag = geburtstag;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
