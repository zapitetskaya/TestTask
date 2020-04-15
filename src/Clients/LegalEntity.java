package Clients;

public class LegalEntity extends Client {

    private int inn;

    public LegalEntity(String address, int inn) {
        super(address);
        this.inn = inn;
    }

    public int getInn() {
        return inn;
    }

    public void setInn(int inn) {
        this.inn = inn;
    }

    @Override
    public String toString() {
        return "LegalEntity{" +
                "inn=" + inn +
                '}';
    }
}
