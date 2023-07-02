import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Task02 {
    public static void main(String[] args) {
        createFile();
        String string = readString(new File("Students"));
        System.out.println(string);
        String[] arraystring = replaceString(string);
        printString(arraystring);
        }
    static void createFile() {

        //Создание файла и записей в нем
        char[] chars = null;
        try {
            File file = new File("Students");
            if (!file.exists()) {
                String s = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
                FileWriter writer = new FileWriter(file);
                writer.write(s);
                writer.close();
            } else {
                FileReader reader = new FileReader(file);
                chars = new char[(int) file.length()];
                reader.read(chars);
            }
        } catch (IOException e) {
            System.out.println("There is an exception!)");
        }
}


    static String readString(File file) {
        String newStr = "";
        try {
            FileReader reader = new FileReader(file);
            StringBuilder builder = new StringBuilder();
            int s;
            while ((s = reader.read()) != -1) {
                builder.append((char) s);
            }
            return newStr = builder.toString();
        } catch (IOException e) {
            System.out.println("There is an exception!)");
        }
        return newStr;
    }

    static String[] replaceString(String string) {
        String[] s = string.split(" ");
        for (int i = 0; i < s.length; i++) {
            if (s[i].contains("[")) {
                s[i] = s[i].replace("[", "");
            }
            if (s[i].contains("]")) {
                s[i] = s[i].replace("]", "");
            }
            if (s[i].contains("{")) {
                s[i] = s[i].replace("{", "");
            }
            if (s[i].contains("}")) {
                s[i] = s[i].replace("}", "");
            }
            if (s[i].contains(",")) {
                s[i] = s[i].replace(",", " ");
            }
            if (s[i].contains(":")) {
                s[i] = s[i].replace(":", " ");
            }
            if (s[i].contains("\"")) {
                s[i] = s[i].replace("\"", "");
            }
            if (s[i].contains("предмет")) {
                s[i] = s[i].replace("предмет", "по предмету");
            }
            if (s[i].contains("фамилия")) {
                s[i] = s[i].replace("фамилия", "");
            }
            if (s[i].contains("оценка")) {
                s[i] = s[i].replace("оценка", "получил(а)");
            }
        }
        return s;
    }

    static void printString(String[] array) {
        StringBuilder builder = new StringBuilder("Студент:");
        for (String str : array) {
            System.out.println(builder.toString() + str);
        }
    }

}
