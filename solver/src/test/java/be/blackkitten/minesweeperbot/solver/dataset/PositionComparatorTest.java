package be.blackkitten.minesweeperbot.solver.dataset;

import com.google.common.primitives.Ints;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class PositionComparatorTest {

    private MineField objectField;

    @Before
    public void setUp() throws Exception {
        objectField = new MineField(2, 2, true);
    }

    @Test
    public void isSurroundingField_fieldLeftUp() throws Exception {
        MineField subjectField = new MineField(1, 1, true);

        assertThat(PositionComparator.of(subjectField).isSurroundingField(objectField)).isTrue();
    }

    @Test
    public void isSurroundingField_fieldUp() throws Exception {
        MineField subjectField = new MineField(2, 1, true);

        assertThat(PositionComparator.of(subjectField).isSurroundingField(objectField)).isTrue();
    }

    @Test
    public void isSurroundingField_fieldRightUp() throws Exception {
        MineField subjectField = new MineField(3, 1, true);

        assertThat(PositionComparator.of(subjectField).isSurroundingField(objectField)).isTrue();
    }

    @Test
    public void isSurroundingField_fieldRight() throws Exception {
        MineField subjectField = new MineField(3, 2, true);

        assertThat(PositionComparator.of(subjectField).isSurroundingField(objectField)).isTrue();
    }

    @Test
    public void isSurroundingField_fieldRightDown() throws Exception {
        MineField subjectField = new MineField(3, 3, true);

        assertThat(PositionComparator.of(subjectField).isSurroundingField(objectField)).isTrue();
    }

    @Test
    public void isSurroundingField_fieldDown() throws Exception {
        MineField subjectField = new MineField(2, 3, true);

        assertThat(PositionComparator.of(subjectField).isSurroundingField(objectField)).isTrue();
    }

    @Test
    public void isSurroundingField_fieldLeftDown() throws Exception {
        MineField subjectField = new MineField(1, 3, true);

        assertThat(PositionComparator.of(subjectField).isSurroundingField(objectField)).isTrue();
    }

    @Test
    public void isSurroundingField_fieldLeft() throws Exception {
        MineField subjectField = new MineField(1, 2, true);

        assertThat(PositionComparator.of(subjectField).isSurroundingField(objectField)).isTrue();
    }

    @Test
    public void isSurroundingField_self() throws Exception {
        MineField subjectField = new MineField(2, 2, true);

        assertThat(PositionComparator.of(subjectField).isSurroundingField(objectField)).isFalse();
    }


    @Test
    public void isSurroundingField_fieldOthers() throws Exception {

        List<Integer> validRange = Ints.asList(1, 2, 3);
        List<Integer> invalidRange = Ints.asList(0, 4);

        List<MineField> subjectFields = validRange.stream()
                .map(valid -> {
                    return
                            invalidRange.stream()
                                    .map(
                                            invalid -> {
                                                return new MineField(valid, invalid, true);
                                            }
                                    )
                                    .collect(toList());
                })
                .flatMap(mineFields -> mineFields.stream())
                .collect(toList());

        subjectFields.stream().forEach(
                mineField ->  assertThat(PositionComparator.of(mineField).isSurroundingField(objectField)).isFalse()
        );

    }


}