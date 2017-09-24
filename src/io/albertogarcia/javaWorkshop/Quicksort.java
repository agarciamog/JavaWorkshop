package io.albertogarcia.javaWorkshop;

import java.util.Arrays;

public class Quicksort  {

    public static void main(String[] args) {
        int[] nums = {4, 6, 0, 8, 2, 22, 38, 1};

        Quicksort quicksort = new Quicksort();
        quicksort.sort(nums);

//        System.out.println(Arrays.toString(nums));
    }


    private int[] numbers;
    private int number;

    private void sort(int[] values) {
        // check for empty or null array
        if (values ==null || values.length==0){
            return;
        }
        this.numbers = values;
        number = values.length;
        quicksort(0, number - 1);
    }

    private void quicksort(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = numbers[low + (high-low)/2];
        //System.out.println("Pivot: " + pivot);

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
            while (numbers[i] < pivot) {
                i++;
            }
            //System.out.println("i=" + i + ", " + numbers[i] + " < " + pivot);

            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
            while (numbers[j] > pivot) {
                j--;
            }
            //System.out.println("j=" + j + ", " + numbers[j] + " < " + pivot);

            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                System.out.println("PIVOT = " + pivot);
                exchange(i, j);
                i++;
                j--;
            } else {
                System.out.println("No Swap");
            }
            System.out.println("i=" + i + " j=" + j);
            System.out.println("-------------------------------------------");
        }
        // Recursion
//        System.out.println("Sort Low\n");
        if (low < j)
            quicksort(low, j);
//        System.out.println("Sort High\n");
        if (i < high)
            quicksort(i, high);
    }

    private void exchange(int i, int j) {
        System.out.println("Swapped: numbers[" + i + "]=" + numbers[i] + " and numbers[" + j + "]=" + numbers[j]);

        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
        System.out.println(Arrays.toString(numbers));

    }
}