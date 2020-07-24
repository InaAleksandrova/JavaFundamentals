package TextProcessing_lab;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        String string = "Hello, hello, helo, heo";

        /*Map<String, Integer> leng*/

        Map<String, Integer> collect = Arrays.stream(string.split(", "))
                .collect(Collectors.toMap(e -> e, e -> e.length()));

        System.out.println(collect.toString());
    }

}
