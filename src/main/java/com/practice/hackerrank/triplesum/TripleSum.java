package com.practice.hackerrank;

import java.util.Arrays;
import java.util.List;

public class TripleSum {

    public static long triplets(List<Integer> a, List<Integer> b, List<Integer> c) {

        //dedup and sort
        int[] aArr = a.stream().mapToInt(i -> i).toArray();
        int[] bArr = b.stream().mapToInt(i -> i).toArray();
        int[] cArr = c.stream().mapToInt(i -> i).toArray();

        int[] aClean = Arrays.stream(aArr).distinct().sorted().toArray();
        int[] bClean = Arrays.stream(bArr).distinct().sorted().toArray();
        int[] cClean = Arrays.stream(cArr).distinct().sorted().toArray();

        long result = 0;
        //for each q in b, find p's <= q and r <= q
        for(int q: bClean){
            long numP = binarySearchCount(aClean, q);
            long numR = binarySearchCount(cClean, q);
            result += numP*numR;
        }

        return result;

    }

    public static long binarySearchCount(int[] arr, int element){
        long result = 0;
        int index = Arrays.binarySearch(arr, element);
        // recall this is (-(insertion point) - 1)
        // where insertion point is index of first element > search element
        if(index<0){
            result = -1*index-1;
        }else{
            result = index + 1;
        }
        return result;
    }

}
