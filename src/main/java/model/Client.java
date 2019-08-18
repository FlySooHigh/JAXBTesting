package model;

import java.util.Objects;

public class Client {
    private int INN;
    private String SNILS;
    private String passportNumber;

    public Client() {
    }

    public int getINN() {
        return INN;
    }

    public void setINN(int INN) {
        this.INN = INN;
    }

    public String getSNILS() {
        return SNILS;
    }

    public void setSNILS(String SNILS) {
        this.SNILS = SNILS;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Override
    public String toString() {
        return "Client{" +
                "INN=" + INN +
                ", SNILS='" + SNILS + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return INN == client.INN &&
                Objects.equals(SNILS, client.SNILS) &&
                Objects.equals(passportNumber, client.passportNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(INN, SNILS, passportNumber);
    }
}
