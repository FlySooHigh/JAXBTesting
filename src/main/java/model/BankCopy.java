package model;

import java.util.List;
import java.util.Objects;

public class BankCopy {
    private String UID;
    private List<Client> clients;

    public BankCopy() {
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "BankCopy{" +
                "UID='" + UID + '\'' +
                ", clients=" + clients +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankCopy bankCopy = (BankCopy) o;
        return Objects.equals(UID, bankCopy.UID) &&
                Objects.equals(clients, bankCopy.clients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(UID, clients);
    }
}
