//Задание
//
//        1) Дана строка sql-запроса "select * from students where ".
//        Сформируйте часть WHERE этого запроса, используя StringBuilder или String.
//        Данные для фильтрации приведены ниже в виде json-строки.
//        Если значение null, то параметр не должен попадать в запрос.
//        Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}


public class Task01 {
    public static void main(String[] args) {
        String sql = "select * from students where ";
        String strsql = "\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"";
        String[] newString = strsql.split(",");
        StringBuilder searchsql = new StringBuilder();
        for (String s : newString) {
            if (!s.contains("null")) searchsql.append(s);
        }

        strsql = searchsql.toString();
        String[] res = strsql.split(" ");
        String[] wellsql;

        StringBuilder result = new StringBuilder(sql);
        for (int i = 0; i < res.length; i++) {
            wellsql = res[i].split(":");
            wellsql[0] = wellsql[0].replaceAll("\"", "");
            wellsql[1] = wellsql[1].replaceAll("\"", "'");
            res[i] = String.join(" = ", wellsql[0], wellsql[1]);
            if (i!=res.length-1){result.append(res[i].concat(" AND "));}
            else result.append(res[i]);
        }
        System.out.println(result);
    }
    }

