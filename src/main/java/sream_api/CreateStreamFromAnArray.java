package sream_api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** These first two patterns are very similar.
The first one uses the <B>of()</B> factory method in the Stream interface.
The second one uses the stream() factory method of the Arrays factory class.
And in fact, if you check the source of the Stream.of() method,
you will see that it calls <B>Arrays.stream()</B>.
*/

public class CreateStreamFromAnArray {

    public static void main(String[] args) {
        /* Here is this first pattern in action */
        Stream<Integer> intStream = Stream.of(1, 2, 3);
        List<Integer> ints = intStream.collect(Collectors.toList());
        System.out.println("ints = " + ints);


        /* Here is the second one. */
        String[] stringArray = {"one", "two", "three"};
        Stream<String> stringStream = Arrays.stream(stringArray);
        List<String> strings = stringStream.collect(Collectors.toList());
        System.out.println("strings = " + strings);
    }
}
