package es.brouse;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Sort a set of N=10_000 elements using {@link Collections#sort(List)} and then
 * a binary search {@link Collections#binarySearch(List, Object)}to get a specific
 * element index.
 *
 * @author Brouse
 * @version 1.0
 * @see <a href="https://github.com/Brouse13">Brouse Github</a>
 */
public class Main {
    private static final int MAX_LENGTH = 10_000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Create array of MAX_LENGTH size and elements (0, MAX_ELEMENTS)
        System.out.println("Creating 10000 elements array...");
        List<Integer> numbers = new Random().ints(MAX_LENGTH, 0, MAX_LENGTH)
                .boxed().collect(Collectors.toList());

        //Sort the array and output result
        System.out.println("Sorting array...");
        Collections.sort(numbers);
        numbers.forEach(integer -> System.out.print(integer + " "));

        //Perform binary search to find the given index number
        System.out.print("\nWhich number do you want to find: ");
        final int index = Collections.binarySearch(numbers, scanner.nextInt());

        //User output
        if (index > 0) System.out.printf("Found number at index %d", index);
        else System.out.println("Number not found");
    }
}