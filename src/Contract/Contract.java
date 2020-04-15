package Contract;

import Clients.Client;
import Clients.LegalEntity;

import java.time.LocalDate;
import java.util.ArrayList;

public class Contract {

    private Client client;
    private String status;
    private LocalDate date;
    private double totalAmount;
    private double tax;
    private ArrayList<Stage> stages;

    public Contract(Client client, ArrayList<Stage> stages){
        this.client = client;
        status = Status.New;
        date = LocalDate.now();
        totalAmount =0;
        tax =0;
        this.stages = stages;
    }

    public void add(Stage stage) {
        stages.add(stage);
    }
    public void remove(Stage stage) {
        stages.remove(stage);
    }
    public void update(Stage stage, String status) {
        for (int i =0; i < stages.size(); i++ ) {
           if (stages.get(i) == stage) {
            stages.get(i).setStatus(status);
           }
        }
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTotalAmount() {
        if (client.getClass() == LegalEntity.class) {
            for (int i = 0; i < stages.size(); i++){
                if (stages.get(i).getStatus().equals(Status.Finish)) {
                    totalAmount += stages.get(i).getCostForLegal();
                }
            }
        }else {
            for (int i = 0; i < stages.size(); i++) {
                if (stages.get(i).getStatus().equals(Status.Finish)) {
                    totalAmount += stages.get(i).getCostForIndiv();
                }
            }
        }
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getTax() {
        if (client.getClass() == LegalEntity.class) {
            tax = totalAmount /6;
        }else {
            tax = 0;
        }
        return tax;
    }

    public void setTax(double tax) {

        this.tax = tax;
    }

    public ArrayList<Stage> getStages() {
        return stages;
    }

    public void setStages(ArrayList<Stage> stages) {
        this.stages = stages;
    }
}
