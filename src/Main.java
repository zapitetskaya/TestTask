import Clients.*;
import Contract.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Work work = new Work("Clear", 1230);
        Work work1 = new Work("Wash", 3430);
        Work work2 = new Work("Dinner", 780);
        Work work3 = new Work("Delivery", 500);
        Work work4 = new Work("Taxi", 670);
        work3.setStatus(Status.Finish);

        ArrayList<Work> works = new ArrayList<>();
        works.add(work);
        works.add(work1);
        works.add(work2);

        ArrayList<Work> works1 = new ArrayList<>();
        works1.add(work3);
        works1.add(work4);

        Stage stage = new Stage("step", works);
        Stage stage1 = new Stage("step1", works1);

        ArrayList<Stage> stages = new ArrayList<Stage>();
        stages.add(stage);

        ArrayList<Stage> stages1 = new ArrayList<Stage>();
        stages1.add(stage1);
        stages1.add(stage);

        Individual individual = new Individual ("Saratov","Alina","9277097024");
        LegalEntity legalEntity = new LegalEntity("Moscow",945677738);

        Contract contract = new Contract(individual,stages);
        Contract contract1 = new Contract(legalEntity,stages1);
        System.out.println(contract.getTotalAmount());
        System.out.println(contract1.getTotalAmount());

    }
}
