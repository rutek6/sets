package com.sets;

public class Main {
    public static void main(String[] args) throws Exception {
        BSTSet<Integer> t = new BSTSet<Integer>();

        t.add(1);
        t.add(2);
        t.add(-1);

        System.out.println(t);
    }
}
