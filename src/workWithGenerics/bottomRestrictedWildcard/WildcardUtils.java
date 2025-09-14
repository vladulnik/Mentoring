package workWithGenerics.bottomRestrictedWildcard;

import java.util.List;

public class WildcardUtils {

    void putBanana(Box<? super Banana> box) {
        box.setValue(new Banana());
    }

    void addAllIntegers(List<? super Integer> dest, List<Integer> src) {
        for(Integer i : src) {
            dest.add(i);
        }
    }
}
