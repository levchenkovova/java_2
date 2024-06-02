import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {
    List<Integer> values = new ArrayList<>();

    public static void main (String[] args) {
        Test test = new Test();
        test.printPositiveNumbers();
    }

    public Test () {
        Integer[] array = new Integer[]{1 , 2 , 3, 4, -5, -8, -10, 7};
        values.addAll(Arrays.stream(array).toList());
    }

    public void printPositiveNumbers () {
        List<Integer> positiveNumbers = values.stream().filter(value -> value > 0).collect(Collectors.toList());
        positiveNumbers.forEach(number -> {
            System.out.println(number);
        });
    }

}
