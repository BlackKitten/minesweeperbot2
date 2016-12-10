package be.blackkitten.minesweeperbot.solver;

import be.blackkitten.minesweeperbot.solver.dataset.MineSet10x10;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SolverApplication {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SolverApplication.class);

        MineSet10x10 randomSet = MineSet10x10.random();
        randomSet.print();

        System.out.println(randomSet.toDataSetRow().toString());
    }
}
