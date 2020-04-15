package Clients;

public class Individual extends Client {

    private String name;
    private String number;

    public Individual(String address, String name, String number) {
        super(address);
        this.name = name;
        this.number = number;
    }

    public String getNumber() {

        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Individual{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
