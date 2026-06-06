package com.sets;

import java.util.function.Consumer;

public class BSTOuter<K extends Comparable<K>> extends BSTNode<K> {

    @SuppressWarnings("rawtypes")
    private static final BSTOuter INSTANCE = new BSTOuter();

    private BSTOuter() {
        super();
    }

    @SuppressWarnings("unchecked")
    public static <K extends Comparable<K>> BSTOuter<K> getInstance() {
        return (BSTOuter<K>) INSTANCE;
    }

    @Override
    public BSTNode<K> add(K e) {
        return new BSTNode<K>(e);
    }

    public String toString() {
        return "";
    }

    @Override
    public boolean contains(K e) {
        return false;
    }

    @Override
    public BSTNode<K> remove(K e) {
        return this;
    }

    @Override
    public BSTNode<K> getMin() {
        return this;
    }

    @Override
    public void inOrder(Consumer<K> action) {
    }

    @Override
    public boolean isEmpty() {
        return true;
    }
}
