package be.blackkitten.minesweeperbot.solver.dataset;

import java.util.function.Function;

public class DataSetValue implements Function<MineField, Double> {

    @Override
    public Double apply(MineField mineField) {

        if (mineField.isBomb()) {
            return 0.9;
        }

        return mineField.getValue()
                .map(value -> value.doubleValue() / 10)
                .orElse(new Double(1));
    }
}
