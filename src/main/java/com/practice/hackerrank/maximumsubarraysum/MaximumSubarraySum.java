package com.practice.hackerrank.triplesum;

import java.util.List;
import java.util.TreeSet;

public class MaximumSubarraySum {

    public static long maximumSum(List<Long> a, long m) {
        long max = 0, curr = 0;
        TreeSet<Long> tree = new TreeSet<>();

        for(int i=0; i<a.size(); i++){
            curr = (curr + a.get(i) % m) % m;
            max = Math.max(curr, max);
            Long higher = 0L;

            higher = tree.higher(curr);

            if(higher != null){
                max = Math.max(max, (curr-higher+m)%m);
            }

            tree.add(curr);
        }

        return max;
    }
}
