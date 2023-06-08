import java.util.*;

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

        /*
            1) Дан список (List) из слов. Нужно поменять порядок слов в списке на противоположный. Например, для списка со значениями cats are funny нужно вернуть список funny are cats.
         */
        List<String> text = new ArrayList<>();
        text.add("cats");
        text.add("are");
        text.add("funny");

        List<String> reverseText = new ArrayList<>();
        ListIterator<String> listIt = text.listIterator();
        while (listIt.hasNext()) {
            listIt.next();
        }

        while (listIt.hasPrevious()) {
            reverseText.add(listIt.previous());
        }

        System.out.println(reverseText);

        // ******************************************************************************

        /*
            2) Дан список (List) целых чисел. Используя Iterator, удалите из списка все числа, имеющие значение больше X и меньше Y.
         */
        int x=3;
        int y=6;

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(5);
        numbers.add(4);
        numbers.add(3);
        numbers.add(7);
        numbers.add(6);

        Collections.sort(numbers);

        Iterator<Integer> numbersIt = numbers.iterator();
        while (numbersIt.hasNext()) {
            Integer number = numbersIt.next();
            if(number <= x || number >= y) {
                numbersIt.remove();
            }
        }

        System.out.println(numbers);
        // ===============================================================================

        /*
            4) Даны два списка с числовыми значеними: [1, 2, 3, 2, 0] и [5, 1, 2, 7, 3, 2]. Нужно вернуть пересечение их множеств, с повторением элементов [1, 2, 2, 3]
         */
        List<Integer> arrayOne = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 0));
        List<Integer> arrayTwo = new ArrayList<>(Arrays.asList(5, 1, 2, 7, 3, 2));
        List<Integer> result = new ArrayList<>();

        // Шаг 1. Отсортировать коллекции по возрастанию
        Collections.sort(arrayOne);
        Collections.sort(arrayTwo);

        // Шаг 2. "Выровнять" коллекции, удалив первые элементы одной из коллекций, меньшие чем первый элемент второй коллекции
        Integer minValueArrayOne = arrayOne.get(0);
        Integer minValueArrayTwo = arrayTwo.get(0);
        if(minValueArrayOne < minValueArrayTwo) {
            arrayOne.removeIf(value -> value <= minValueArrayOne);
        } else {
            arrayTwo.removeIf(value -> value <= minValueArrayTwo);
        }

        // Шаг 3. Последователньо сравнить элементы двух коллекций. Если они совпадают - записать в результирующий массив.
        Iterator<Integer> arrayOneIt = arrayOne.iterator();
        Iterator<Integer> arrayTwoIt = arrayTwo.iterator();
        while (arrayOneIt.hasNext() && arrayTwoIt.hasNext()) {
            Integer numOne = arrayOneIt.next();
            Integer numTwo = arrayTwoIt.next();

            if(numOne.equals(numTwo)) {
                result.add(numOne);
            }
        }

        System.out.println(result);

        // -----------------------------------------------------------------------------


        /*
            5) Дан список целых чисел и число-цель. Нужно найти такой range (непрерывную последовательность чисел), чтобы сумма его элементов давала число-цель.
            elements = [1, -3, 4, 5, 2]
            target = 6
            result = range(2, 4) # because elements[2] + elements[3] + elements[4] == target
         */
        List<Integer> elements = new ArrayList<>(Arrays.asList(1, -3, 2, 6, 4, 5));
        int target = 9;

        for(int i=0; i<elements.size(); i++) {
            int sum=0;
            for(int j=i; j<elements.size(); j++) {
                sum = sum + elements.get(j);

                if(sum == target ) {
                    System.out.println("range("+i+","+j+")=" + sum);
                }

                if(sum > target) break;
            }
        }

        // *******************************************************************************

    }
}