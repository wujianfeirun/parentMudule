package com.main._04Lambda;

import java.util.Arrays;
import java.util.List;

/**
 * parallelStream 是并行处理的； 底层使用的是fork/join
 * stream是串行执行的
 */

public class LambLearn {
    //rebase branch
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(10,20,30,40);
        int res = new LambLearn().add(values);
        System.out.println(res);
    }
    //change from new branch
    public int add(List<Integer> values){
        return values.parallelStream().mapToInt(a -> a).sum();
    }

}
