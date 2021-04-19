/**
 * AUTHOR :
 * 
 * PROJECT NAME:
 * 
 * DATE :
 * 
 * SHORT DISCRIPTION :
 * 
 * 
 * 
 * 
 */

import java.util.List;

public class OrderedList {

    public static <T extends Comparable<? super T>> boolean checkSorted(List<T> list){

        // iterate through elemnt o to (no of elemnts-2) check whether they are sorted
        for (int i = 0; i < list.size()-1; i++) {
            if (!checkSorted(list,list.get(i) )) {
                return false;
            }
        }
        return true;
    }
    
    private static <T extends Comparable<? super T>> boolean checkSorted(List<T> list, T obj) {
        //check whether next elemnt to obj is equals or greater than to obj in list
        if (list.get(list.indexOf(obj) + 1).compareTo(obj)>=0) {
            return true;
        }

        return false;
    }
}