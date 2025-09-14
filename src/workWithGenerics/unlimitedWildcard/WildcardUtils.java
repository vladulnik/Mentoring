package workWithGenerics.unlimitedWildcard;

import workWithGenerics.wildcardLimitedAbove.Animal;
import workWithGenerics.wildcardLimitedAbove.Box;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class WildcardUtils {

    public static void printList(List<?> list) {
        for(Object x : list) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static Object firstOrNull(List<?> list) {
        if(list == null || list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }

    public static int countNonNull(Collection<?> c) {
        int count = 0;
        for(Object x : c) {
            if(x != null) {
                count++;
            }
        }
        return count;
    }

    public static boolean contains(Collection<?> c, Object target) {
        for(Object element : c) {
            if(Objects.equals(element, target)) {
                return true;
            }
        }
        return false;
    }
}
