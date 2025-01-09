package com.stackroute.collections;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ArrayListSort {
    //write logic to sort given list in descending order
    public ArrayList<BigInteger> arrayListSortDesc(ArrayList<BigInteger> list) {
        //Collections.sort(list, Comparator.reverseOrder());
        list.sort(Comparator.reverseOrder());
        return list;
    }
}
