package regularExpressions_Lab;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
    public static void main(String[] args) {
        String text = "RegExr was created by gskinner.com, and is proudly hosted by Media Temple.\n" +
                "\n" +
                "Edit the Expression & Text to see matches. Roll over matches or the expression for details. PCRE & JavaScript flavors of RegEx are supported. Validate your expression with Tests mode.\n" +
                "\n" +
                "The side bar includes a Cheatsheet, full Reference, and Help. You can also Save & Share with the Community, and view patterns you create or favorite in My Patterns.\n" +
                "\n" +
                "Explore results with the Tools below. Replace & List output custom results. Details lists capture groups. Explain describes your expression in plain English.\n" +
                "\n" +
                "123@softuni.bg\n" +
                "ina@gmail.com\n" +
                "\n" +
                "\n" +
                "19-Jan-1993\n" +
                "10-Ont-3020\n" +
                "1-Oct-2000\n" +
                "a-Feb-1993\n" +
                "119-Kun-1983\n";

        String regex = "(\\w+)@(?<domain>[A-Za-z]+)\\.([A-Za-z]+)";
        //String a = "\\\\"; //за еспейп на наклонена черта

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            matcher.reset();
            System.out.println(matcher.group(1));
            System.out.println(matcher.group("domain"));
            System.out.println(matcher.group(3));

        }
    }
}
