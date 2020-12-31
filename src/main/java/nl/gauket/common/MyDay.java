package nl.gauket.common;

public abstract class MyDay implements iDay {
    protected String[] INPUT;
    protected int[] INPUT_INT;

    @Override
    public void before(int year, int day) {
        INPUT = InputReader.readInputAsStringArray(year, day);
    }
}
