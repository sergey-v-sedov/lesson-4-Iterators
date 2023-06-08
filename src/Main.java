import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple1");
        fruits.add("Plum2");
        fruits.add("Orange3");
        fruits.add("Apple4");
        fruits.add("Plum5");
        fruits.add("Orange6");

        Iterator<String> fruitsIt = fruits.iterator();
        while (fruitsIt.hasNext()) {
            String fruit = fruitsIt.next();
            System.out.println(fruit);
        }

        ListIterator<String> fruitsListIt = fruits.listIterator();
        for(int i=0; i<3; i++) {
            String f = fruitsListIt.next();
            int indx = fruitsListIt.nextIndex();
            System.out.println(indx + " " + f);
        }

        for(int i=0; i<2; i++) {
            String f = fruitsListIt.previous();
            System.out.println(f);
        }

        for(String fruit : fruits) {
            System.out.println(fruit);
        }

        fruits.forEach(System.out::println);

    }
}