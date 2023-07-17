import java.util.*;
public class Task {
    /* Задание сымитировать работу HashSet используя другие коллекции, которая будет хранить в себе Integer
   реализовать методы:
   добавления элемента
   удаления элемента
   поиска значения по индексу
   переопределение toString
   */
    public static void main(String[] args) {
        HashSet<Integer> sSet = new HashSet<>();
        System.out.println(sSet.add(111));
        System.out.println(sSet.add(222));
        System.out.println(sSet.add(333));
        System.out.println(sSet.add(444));
        System.out.println(sSet.remove(222));
        System.out.println(sSet.add(222));

        System.out.println(sSet.valueOf(1));

        System.out.println(sSet);

        Iterator<Integer> iterator = sSet.iterator();
        while(iterator.hasNext()){
            System.out.print( iterator.next() + " ");
        }


    }
    static class HashSet<T>{
        private HashMap<T,Object> mySet = new HashMap<>();
        private static final Object CONSTANT = new Object();

        public boolean add(T value){
            return mySet.put(value,CONSTANT)==null;
        }
        public boolean remove(T value){
            return mySet.remove(value)!=null;
        }
        public String toString(){
            return mySet.keySet().toString();
        }
        public Iterator<T> iterator(){
            return mySet.keySet().iterator();
        }
        public T valueOf(int index){
            ArrayList<T> arrayList = new ArrayList<>(mySet.keySet());
            return arrayList.get(index);
        }
    }
}
