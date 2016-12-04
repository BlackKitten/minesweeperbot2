package be.blackkitten.minesweeperbot.solver.dataset;

import be.blackkitten.commons.utilities.InstanceBuilder;
import org.neuroph.core.data.DataSetRow;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class MineSet10x10 {

    private final static int xMax = 10;
    private final static int yMax = 10;
    private final static double BOMB_CHANCE = 0.1;

    private List<MineField> mineFields;

    public static MineSet10x10 random() {

        return random(xMax, yMax, BOMB_CHANCE);
    }

    public static MineSet10x10 random(int xMax, int yMax, double bombChance) {
        List<MineField> mineFields = createMineFieldsAndPopulateWithBombs(xMax, yMax, bombChance);

        mineFields.stream()
                .forEach(mineField -> mineField.setSurroundingFields(
                        mineFields.stream()
                                .filter(mineField1 -> {return PositionComparator.of(mineField).isSurroundingField(mineField1);})
                                .collect(toList())
                ));

        return new Builder()
                .withFields(mineFields)
                .build();
    }

    private static List<MineField> createMineFieldsAndPopulateWithBombs(int xMax, int yMax, double bombChance) {
        List<MineField> mineFields = new ArrayList<>();

        for (int x = 0; x < xMax; x++) {
            for (int y = 0; y < yMax; y++) {
                mineFields.add(new MineField(x, y, Math.random() < bombChance));
            }
        }
        return mineFields;
    }

    public void print(){
        IntStream.rangeClosed(0, yMax).forEach(
                y -> {
                    IntStream.rangeClosed(0, xMax).forEach(
                            x -> {System.out.print(" \t" + getField(x,y).map(MineField::getText).orElse(""));}
                    );
                    System.out.println("");
                }
        );

    }

    private Optional<MineField> getField(int x, int y) {
        return mineFields.stream()
                .filter(mineField -> mineField.x == x && mineField.y == y)
                .findFirst();
    }

    public DataSetRow toDataSetRow() {
//        mineFields.stream().flatMap(mineField -> {
//            mineField.getValue() })
        throw new RuntimeException("not implemented");
    }

    private static class Builder extends InstanceBuilder<MineSet10x10> {

        @Override
        protected MineSet10x10 createInstance() {
            return new MineSet10x10();
        }

        public Builder withFields(List<MineField> fields) {
            instance().mineFields = fields;
            return this;
        }
    }

}
