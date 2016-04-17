package ch.silviowangler.map4j;

import java.util.Date;

/**
 * Created by Silvio Wangler on 17/03/16.
 */
public class PartnerVO {

    private String firstname;
    private String lastname;
    private Date birthdate;
    private String telephone;

    public PartnerVO() {
    }

    public PartnerVO(String firstname, String lastname, Date birthdate, String telephone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.telephone = telephone;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
