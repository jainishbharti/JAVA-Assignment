package com.assignment.java.question2;

import java.util.Arrays;

public class TripletProblem {
//    Brute-Force Approach
//    public static int findTripletCount(int[] arr){
//        Arrays.sort(arr);
//        int count = 0;
////        int i=0, j =i+1;
//        for(int k = 0; k< arr.length; k++){
//            for(int i = k + 1; i< arr.length-1; i++){
//                int sum = arr[i] + arr[k];
//                for(int j = i+1; j<arr.length; j++){
//                    if(arr[j] == sum) count++;
//                }
//            }
//        }
//        return count;
//    }

//  A Little Optimised Code
//  Time Complexiety O(n2)
    public static int findTripletCount(int[] arr){
        if (arr.length < 3) {
            System.out.println();
            return 0;
        }
        int count = 0;
        int n = arr.length;
        Arrays.sort(arr);
        int left = 0;
        int right = left + 1;
        while (left < n - 2 && right < n - 1) {
            for (int i = right + 1; i < n; i++) {
                    if (arr[left] + arr[right] == arr[i]) {
                        count++;
                    }
                right++;
            }
            left++;
            right = left + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(TripletProblem.findTripletCount(new int[] {1,5,3,2}));
    }
}
