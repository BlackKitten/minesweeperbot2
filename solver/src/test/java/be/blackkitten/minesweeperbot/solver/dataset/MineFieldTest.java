package be.blackkitten.minesweeperbot.solver.dataset;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;

public class MineFieldTest {
    @Test
    public void getValue() throws Exception {
        MineField subject = new MineField(1, 2, false);
        MineField neighbor1 = new MineField(2, 2, true);
        subject.setSurroundingFields(Arrays.asList(neighbor1));

        Assertions.assertThat(subject.getValue()).isEqualTo(1);


    }
}