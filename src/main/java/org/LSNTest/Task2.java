package org.LSNTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please provide array size:");
        int arraySize = 1;
        try{
            arraySize = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e){
            e.printStackTrace();
        }

        if (arraySize <= 0){
            System.out.println("Array size cannot be less or equal to zero.");
            return;
        }

        int[] array = new int[arraySize];

        System.out.println("Please provide an array of integers, separated by space:");
        String[] splitInput = scanner.nextLine().split(" ");
        for (int i = 0; i < splitInput.length; i++){
            array[i] = Integer.parseInt(splitInput[i]);
        }

        System.out.println("What sum would you like to look for?:");
        int sum = scanner.nextInt();

        System.out.println();
        System.out.println("Pairs found:");
        Stack<IntPair> pairs = TwoSum(array, array.length, sum);
        for (IntPair pair : pairs){
            System.out.println(pair.A + " " + pair.B);
        }
    }

    public static Stack<IntPair> TwoSum(int[] arr, int n, int sum){
        Stack<IntPair> result = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        Arrays.sort(arr);

        for (int i=0; i<n; i++){
            int diff = sum - arr[i];

            if (!map.containsKey(diff)){
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            } else{
                for (int j=0; j<map.get(diff); j++){
                    result.add(new IntPair(diff, arr[i]));
                }
                map.put(diff, 0);
            }
        }

        return result;
    }
}
