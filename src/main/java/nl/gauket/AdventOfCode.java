package nl.gauket;

import nl.gauket.common.Generate;
import nl.gauket.common.InputService;
import nl.gauket.common.NewDay;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.Month;

public class AdventOfCode {

    private static final int YEAR = -1;
    private static final int DAY = -1;

    public static void main(String[] args) {
        if (!isValidYear(YEAR)) {
            runAll();
        } else {
            if (!isValidDay(DAY)) {
                runYear(YEAR);
            } else {
                runSpecificYearAndDay(YEAR, DAY);
            }
        }
    }

    private static boolean isValidDay(int day) {
        return day >= 1 && day <= 25;
    }

    private static boolean isValidYear(int year) {
        return year >= 2015 && year <= determineLatestAdventOfCode();
    }

    private static void runSpecificYearAndDay(int year, int day) {
        var obj = getNewDayInstanceOf(year, day);
        if (obj != null) {
            obj.run(year, day);
        } else if (isValidYear(year) && isValidDay(day)) {
            System.out.println("> WARNING :Day" + day + " not found");
            new InputService().prepareDailyInput(year, day);
            System.out.println("> INFO :Generate new Day... ");
            Generate.newDay(year, day);
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

    private static NewDay getNewDayInstanceOf(int year, int day) {
        try {
            return (NewDay) Class.forName("nl.gauket.mission" + year + ".Day" + day).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // ignore exception null is checked later
        }

        return null;
    }
}
