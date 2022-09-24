import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UnitariusTaskTest {

    private final UnitariusTask unitariusTask = new UnitariusTask();
    private String[] testedArray;

    @BeforeEach
    public void beforeEach() {
        testedArray = new String[]{
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
                "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22"
        };
    }

    @Test
    public void test_when_m_is_small() {
        // setup
        var m = 5;
        var expected = new String[]{
                "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
                "17", "18", "19", "20", "21", "22", "1", "2", "3", "4", "5"
        };

        // do
        var actual = unitariusTask.execute(testedArray, m);

        // assert
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_when_m_twice_smaller_arraySize() {
        // setup
        var m = 11;
        var expected = new String[]{
                "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22",
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"
        };

        // do
        var actual = unitariusTask.execute(testedArray, m);

        // assert
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_when_m_more_than_a_half_arraySize() {
        // setup
        var m = 15;
        var expected = new String[]{
                "16", "17", "18", "19", "20", "21", "22",
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"
        };

        // do
        var actual = unitariusTask.execute(testedArray, m);

        // assert
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_when_m_is_1() {
        // setup
        var m = 1;
        var expected = new String[]{
                "2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
                "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22",
                "1"
        };

        // do
        var actual = unitariusTask.execute(testedArray, m);

        // assert
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_when_m_is_equal_arraySize() {
        // setup
        var m = 22;

        // do
        var actual = unitariusTask.execute(testedArray, m);

        // assert
        Assertions.assertArrayEquals(testedArray, actual);
    }

    @Test
    public void test_when_m_is_0() {
        // setup
        var m = 0;

        // do
        var actual = unitariusTask.execute(testedArray, m);

        // assert
        Assertions.assertArrayEquals(testedArray, actual);
    }
}