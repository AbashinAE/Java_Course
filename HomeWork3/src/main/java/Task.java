import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

//Задание
//
//        Пусть дан произвольный список целых чисел.
//
//        1) Нужно удалить из него чётные числа
//        2) Найти минимальное значение
//        3) Найти максимальное значение
//        4) Найти среднее значение

public class Task {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integers.add(new Random().nextInt(50));
        }
        System.out.println("\nНачальный список => " + integers);

        for (int i = 0; i < integers.size(); i++){
            if(integers.get(i) % 2 == 0){
                integers.remove(i);
                i--;
            }

        }
        System.out.println("\nСписок без четных чисел => " + integers);
        System.out.println("\nМинимальное значение => " + Collections.min(integers));
        System.out.println("\nМаксимальное значение => " + Collections.max(integers));
        int Average = 0;
        for (Integer integer : integers) {
            Average += integer;
        }
//        System.out.println(Average);
        System.out.println("\nСреднее значение => " + Average / integers.size());
    }

}
