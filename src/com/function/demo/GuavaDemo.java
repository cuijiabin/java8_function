package com.function.demo;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import org.apache.commons.collections.CollectionUtils;

import java.util.Arrays;
import java.util.List;

public class GuavaDemo {


    public static String joinByGuava(List<String> list,String dlimiter){
        return Joiner.on(dlimiter).skipNulls().join(list);
    }

    public static void main(String[] args) {

        System.out.println(Objects.equal("a", null));
        System.out.println(Objects.hashCode("1", "2", "3"));

        System.out.println(joinByGuava(Arrays.asList("665", "45454"), "-"));

        System.out.println(Objects.equal("",""));
        System.out.println(Objects.equal(null,null));
        System.out.println(CollectionUtils.isEmpty(null));

    }
}
