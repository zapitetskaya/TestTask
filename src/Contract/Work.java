package Contract;

public class Work {

    private String description;
    private double cost;
    private String status;

    public Work(String description, double cost) {
        this.description = description;
        this.cost = cost;
        status = Status.New;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
