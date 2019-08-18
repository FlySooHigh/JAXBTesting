package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bank {
    private int bik;
    private String UID;
    private LocalDate createDate;
    private List<Client> clients;

    public Bank() {
    }

    public int getBik() {
        return bik;
    }

    public void setBik(int bik) {
        this.bik = bik;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return bik == bank.bik &&
                Objects.equals(UID, bank.UID) &&
                Objects.equals(createDate, bank.createDate) &&
                Objects.equals(clients, bank.clients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bik, UID, createDate, clients);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bik=" + bik +
                ", UID='" + UID + '\'' +
                ", createDate=" + createDate +
                ", clients=" + clients +
                '}';
    }
}
