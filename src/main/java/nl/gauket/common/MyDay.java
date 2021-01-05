package nl.gauket.common;

import java.util.List;

public abstract class MyDay implements iDay {
    protected static boolean DEBUG = false;

    protected String[] INPUT;
    protected List<String> INPUT_STR_LIST;
    protected char[][] INPUT_CH_MATRIX;
    protected int[] INPUT_INT;
    protected long[] INPUT_LONG;

    @Override
    public void before(int year, int day) {
        INPUT = InputReader.readInputAsStringArray(year, day);
    }
}
