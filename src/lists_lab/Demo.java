package lists_lab;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();

        System.out.println(strings.size());

        strings.add("First");
        strings.add("Second");
        strings.add("Third");

        System.out.println(strings.size());

        System.out.println(strings.get(2));

        strings.remove(1);
        strings.remove("First");

        System.out.println(strings.size());

        System.out.println(strings.get(0));

        strings.set(0, "Edited");

        System.out.println(strings.get(0));

    }
}
