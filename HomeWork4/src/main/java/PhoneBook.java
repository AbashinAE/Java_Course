import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class PhoneBook {
    static Scanner scanner;
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        ArrayList<String> secondName = new ArrayList<>();
        ArrayList<String> firstName = new ArrayList<>();
        ArrayList<String> surname = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<Boolean> gender = new ArrayList<>();
        ArrayList<Integer> id = new ArrayList<>();
        while (true) {
            System.out.println("Введите фамилию -> ");
            secondName.add(scanner.nextLine());
            System.out.println("Введите имя -> ");
            firstName.add(scanner.nextLine());
            System.out.println("Введите отчество -> ");
            surname.add(scanner.nextLine());
            System.out.println("Введите возраст -> ");
            age.add(Integer.valueOf(scanner.nextLine()));
            System.out.println("Введите пол -> ");
            gender.add(scanner.nextLine().toLowerCase().contains("ж"));
            id.add(gender.size()-1);
            System.out.println("==".repeat(50));
            System.out.println("Продолжить ввод да/нет? -> ");
            System.out.println("==".repeat(50));
            String tmp = scanner.nextLine();
            if (tmp.toLowerCase().contains("нет")) break;
        }

        for (int i = 0; i < secondName.size(); i++) {
            System.out.println(id.get(i) + ". " + secondName.get(i)
                    + " "+ firstName.get(i).toUpperCase().charAt(0)
                    + "." + surname.get(i).toUpperCase().charAt(0)
                    + "." + " " + age.get(i) + " " + (gender.get(i)?"Ж":"М"));
        }

        System.out.println("==".repeat(50));
        System.out.println("Сортировать по возрасту да/нет? -> ");
        String tmp = scanner.nextLine();
        if (tmp.toLowerCase().contains("да")){
            id.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {

                    return age.get(o1)-age.get(o2);}

            });
            System.out.println("==".repeat(50));
            for (int i = 0; i < id.size(); i++) {
                System.out.println(id.get(i) + ". " +  secondName.get(id.get(i)) + " " + firstName.get(id.get(i)).toUpperCase().charAt(0) + "." + surname.get(id.get(i)).toUpperCase().charAt(0) + "." + " " + age.get(id.get(i)) + " " + (gender.get(id.get(i))?"Ж":"М"));
            }

            System.out.println("==".repeat(50));
            System.out.println("Сортировать по возрасту и полу да/нет? -> ");
            String tmp1 = scanner.nextLine();
            if (tmp1.toLowerCase().contains("да")) {
                id.sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        if (gender.get(o1)==true) return 1;
                        else return -1;
                    }
                });
                id.sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        if (gender.get(o1) == gender.get(o2)) return age.get(o1) - age.get(o2);
                        return 0;
                    }
                });
                System.out.println("==".repeat(50));
                for (int i = 0; i < id.size(); i++) {
                    System.out.println(id.get(i) + ". " + secondName.get(id.get(i)) + " " + firstName.get(id.get(i)).toUpperCase().charAt(0) + "." + surname.get(id.get(i)).toUpperCase().charAt(0) + "." + " " + age.get(id.get(i)) + " " + (gender.get(id.get(i)) ? "Ж" : "М"));
                }
            }

        }
    }
}