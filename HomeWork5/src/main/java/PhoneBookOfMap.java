import java.util.*;

public class PhoneBookOfMap {

/*Реализуйте структуру телефонной книги с помощью HashMap.
Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами,
их необходимо считать, как одного человека с разными телефонами.
Вывод должен быть отсортирован по убыванию числа телефонов. */

    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> bookPhone = new HashMap<>();
        addNumber("Иванов Иван Иванович", 123, bookPhone);
        addNumber("Петров Петр Петрович", 1234, bookPhone);
        addNumber("Петров Петр Петрович", 546585, bookPhone);
        addNumber("Сидоров Олег Владимирович", 8956477, bookPhone);
        addNumber("Иванов Иван Иванович", 12356233, bookPhone);
        addNumber("Петров Петр Петрович", 787897, bookPhone);

        bookPhone.entrySet().stream().sorted(Map.Entry.comparingByValue((o1, o2) -> o2.size() - o1.size())).forEach(System.out::println);
    }
//     Метод, добавления номера
    public static void addNumber(String key, int value, Map<String, ArrayList<Integer>> map){
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }
    }
}
