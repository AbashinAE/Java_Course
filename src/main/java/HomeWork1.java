import java.util.Random;

public class HomeWork1 {
    public static void main(String[] args) {
        int i = new Random().nextInt(2000);           //возвращает значение от 0 до n
        System.out.println("\n1. Случайное число от 0 до 2000 равен: " + i);

        int n = highBit(i);
        System.out.println("\n2. Номер старшего значащего бита равен: " + n);

        int[] m1 = findNumber1(n, i, Short.MAX_VALUE);
        System.out.println("\n3. Все кратные числа " + n + " в диапозоне от " + i + " до " + Short.MAX_VALUE + " сохранены в массиве: ");
        printArray(m1);

        int[] m2 = findNumber2(n, Short.MIN_VALUE, i);
        System.out.println("\n\n4. Все НЕкратные числа " + n + " в диапозоне от " + Short.MIN_VALUE + " до " + i + " сохранены в массиве: ");
        printArray(m2);

    }

    static int highBit(int i) {
        return Integer.highestOneBit(i);                // фнкция возврата старшего значащего бита
    }

    static int[] findNumber1(int n, int start, int end) { //
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (i % n == 0) {
                count++;
            }
        }
        int[] myArray = new int[count];
        int element = 0;
        for (int i = start; i <= end; i++) {
            if (i % n == 0) {
                myArray[element++] = i;
            }
        }
        return myArray;
    }

    static int[] findNumber2(int n, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (i % n != 0) {
                count++;
            }
        }
        int[] myArray = new int[count];
        int element = 0;
        for (int i = start; i <= end; i++) {
            if (i % n != 0) {
                myArray[element++] = i;
            }
        }
        return myArray;
    }

    static void printArray(int[] array){          // функция заполнения массива
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }

    }

}
