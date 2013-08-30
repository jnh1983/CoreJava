package com.test;

import java.util.Arrays;
import java.util.List;

public class ArrayIndex
{

    public static void main(String[] args)
    {
        int length = 10;
        int[] array = new int[length];
        for (int i = 0; i < length; i++)
        {
            array[i] = i;
        }

        System.out.println(Arrays.binarySearch(array, 5));

        String[] arrStr = new String[5];
        arrStr[0] = "a";
        arrStr[1] = "c";
        arrStr[2] = "b";
        arrStr[3] = "f";
        arrStr[4] = "e";
        Arrays.sort(arrStr);
        ArrayIndex.printArray(arrStr);
        String key = "d";
        System.out.println(key + "\t" + ArrayIndex.getIndex(arrStr, key));

    }

    public static int getIndex(String[] p_array, String key)
    {
        return Arrays.binarySearch(p_array, key);
    }

    public static void printArray(String[] p_array)
    {
        for (int i = 0; i < p_array.length; i++)
        {
            System.out.print(p_array[i] + ", ");
        }
        System.out.println();
    }
}
