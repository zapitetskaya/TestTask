package Contract;

import java.time.LocalDate;
import java.util.ArrayList;

public class Stage {

    private String name;
    private String status;
    private LocalDate timeDate;
    private double cost;
    private ArrayList<Work> invoice;
    private ArrayList<Work> actWorkComplete;
    private static final double tax = 20;


    public Stage(String name, ArrayList<Work> invoice) {
        this.name = name;
        this.invoice = invoice;
        actWorkComplete = invoice;
        status = Status.New;
    }

    private void checkWorks() {
        int count = 0;
        for (int i = 0; i < invoice.size(); i++) {
            if (invoice.get(i).getStatus().equals(Status.Finish)) {
                count++;
            }

        }
        if (count == invoice.size()) {
            this.status = Status.Finish;
        }

    }

    public double getCostForIndiv() {
        for (int i = 0; i < actWorkComplete.size(); i++) {
            if (actWorkComplete.get(i).getStatus().equals(Status.Finish)) {
                cost += actWorkComplete.get(i).getCost();
            }
        }
        return cost;
    }

    public double getCostForLegal() {
        for (int i = 0; i < actWorkComplete.size(); i++) {
            if (actWorkComplete.get(i).getStatus().equals(Status.Finish)) {
                cost += (1 + tax / 100) * actWorkComplete.get(i).getCost();
            }
        }
        return cost;
    }

    public void add(Work work) {
        invoice.add(work);
        actWorkComplete.add(work);
    }

    public void remove(Work work) {
        invoice.remove(work);
        actWorkComplete.add(work);
    }

    public void update(Work work, String status) {
        for (int i = 0; i < invoice.size(); i++) {
            if (invoice.get(i) == work) {
                invoice.get(i).setStatus(status);
            } else actWorkComplete.get(i).setStatus(status);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(LocalDate timeDate) {
        this.timeDate = timeDate;
    }

    public ArrayList<Work> getInvoice() {
        return invoice;
    }

    public void setInvoice(ArrayList<Work> invoice) {
        this.invoice = invoice;
    }

    public ArrayList<Work> getActWorkComplete() {
        return actWorkComplete;
    }

    public void setActWorkComplete(ArrayList<Work> actWorkComplete) {
        this.actWorkComplete = actWorkComplete;
    }

    @Override
    public String toString() {
        return "Stage{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", timeDate=" + timeDate +
                ", cost=" + cost +
                ", invoice=" + invoice +
                ", actWorkComplete=" + actWorkComplete +
                '}';
    }
}