package org.LSNTest;

import java.util.HashSet;
import java.util.Scanner;

public class Task1 {
    static HashSet<Integer> UniqueNumbers = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please provide array size:");
        int arraySize = 0;
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

        QuickSort(array, 0, array.length - 1);

        for (int i : array){
            System.out.print(i + " ");
        }
        System.out.println("count: " + array.length);
        System.out.println("distinct: " + UniqueNumbers.size());
        System.out.println("min: " + array[0]);
        System.out.println("max: " + array[array.length - 1]);
    }

    public static void QuickSort(int[] arr, int low, int high){
        UniqueNumbers.add(low);
        UniqueNumbers.add(high);

        if (low < high){
            int pi = Partition(arr, low, high);

            QuickSort(arr, low, pi - 1);
            QuickSort(arr, pi + 1, high);
        }
    }

    public static int Partition(int[] arr, int low, int high){
        int pivot = arr[high];

        int i = low - 1;

        for (int j = low; j < high; j++){
            if (arr[j] < pivot){
                i++;
                Swap(arr, i, j);
            }
        }

        Swap(arr, i+1, high);

        return i+1;
    }

    public static void Swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
