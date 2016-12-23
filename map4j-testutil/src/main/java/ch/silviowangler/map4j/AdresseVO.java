package ch.silviowangler.map4j;

import java.util.Date;

/**
 * Created by Silvio Wangler on 17/03/16.
 */
public class AdresseVO {

    private String street;
    private int number;
    private String plz;
    private String town;

    public AdresseVO() {
    }

    public AdresseVO(String street, int number, String plz, String town) {
        this.street = street;
        this.number = number;
        this.plz = plz;
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
