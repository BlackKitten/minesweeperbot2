package be.blackkitten.minesweeperbot.solver.dataset;

import org.junit.Test;

import static be.blackkitten.minesweeperbot.solver.dataset.TestConstants.*;
import static org.assertj.core.api.Assertions.assertThat;

public class DataSetValueTest {

    @Test
    public void apply_1surroundingBomb_0d1() throws Exception {
        assertThat(new DataSetValue().apply(MINE_FIELD_CENTER)).isEqualTo(0.1);

    }

    @Test
    public void apply_isBomb_0d9() throws Exception {
        assertThat(new DataSetValue().apply(MINE_FIELD_LEFT)).isEqualTo(0.9);

    }

    @Test
    public void apply_isUnknown() throws Exception {
        assertThat(new DataSetValue().apply(MINE_FIELD_RIGHT)).isEqualTo(1);
    }
}