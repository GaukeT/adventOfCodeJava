package nl.gauket;

import nl.gauket.common.NewDay;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.Month;

public class AdventOfCode {
    public static void main(String[] args) {
        // runSpecificYearAndDay(2021, 1);
        // runYear(2021);
        runAll();
    }

    private static void runSpecificYearAndDay(int year, int day) {
        var obj = getDayInstanceOf(year, day);
        if (obj != null) {
            obj.run(year, false);
        }
    }

    private static void runYear(int year) {
        System.out.println("\n> Task :Year" + year);
        for (int day = 1; day <= 25; day++) {
            runSpecificYearAndDay(year, day);
        }
    }

    private static void runAll() {
        for (int year = 2015; year <= determineLatestAdventOfCode(); year++) {
            runYear(year);
        }
    }

    private static int determineLatestAdventOfCode() {
        var curr = LocalDate.now();
        return curr.getMonth().equals(Month.DECEMBER) ? curr.getYear() : curr.getYear() - 1;
    }

    private static NewDay getDayInstanceOf(int year, int day) {
        try {
            return (NewDay) Class.forName("nl.gauket.mission" + year + ".Day" + day).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // e.printStackTrace();
        }

        return null;
    }
}
