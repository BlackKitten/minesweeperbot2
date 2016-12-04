package be.blackkitten.minesweeperbot.solver.dataset;

public class TestConstants {

    public static final MineField MINE_FIELD_LEFT = new MineField.Builder()
            .withCoordinates(0, 1)
            .withIsBomb(true)
            .withIsKnown(true)
            .build();

    public static final MineField MINE_FIELD_RIGHT = new MineField.Builder()
            .withCoordinates(2, 1)
            .withIsBomb(false)
            .build();

    public static final MineField MINE_FIELD_CENTER = new MineField.Builder()
            .withCoordinates(1, 1)
            .withIsBomb(false)
            .withIsKnown(true)
            .withSurroundingFields(MINE_FIELD_LEFT, MINE_FIELD_RIGHT)
            .build();
}
