package com.sets;

import java.util.function.Consumer;

public class BSTNode<K extends Comparable<K>> {
    K val;
    BSTNode<K> lchild, rchild;

    protected BSTNode() {
        val = null;
        lchild = rchild = null;
    }

    public BSTNode(K e) {
        val = e;
        lchild = rchild = new BSTOuter<K>();
    }

    public BSTNode<K> add(K e) {
        if (this.val.compareTo(e) == 0)
            return this;
        else if (this.val.compareTo(e) < 0) {
            rchild = rchild.add(e);
        } else {
            lchild = lchild.add(e);
        }
        return this;
    }

    public BSTNode<K> remove(K e) {
        int cmp = val.compareTo(e);
        if (cmp > 0) {
            lchild = lchild.remove(e);
        } else if (cmp < 0) {
            rchild = rchild.remove(e);
        } else {
            // Przypadek 1: Węzeł ma 0 lub 1 dziecko
            if (lchild instanceof BSTOuter)
                return rchild;
            if (rchild instanceof BSTOuter)
                return lchild;

            // Przypadek 2: Węzeł ma dwoje dzieci (szukamy minimum w prawym poddrzewie)
            BSTNode<K> min = rchild.getMin();
            this.val = min.val;
            this.rchild = rchild.remove(min.val);
        }
        return this;
    }

    public BSTNode<K> getMin() {
        // TODO

        if (lchild instanceof BSTOuter)
            return this;
        return lchild.getMin();
    }

    public void inOrder(Consumer<K> action) {
        lchild.inOrder(action);
        action.accept(val);
        rchild.inOrder(action);
    }

    public boolean contains(K e) {
        int cmp = val.compareTo(e);
        if (cmp == 0)
            return true;
        if (cmp < 0)
            return rchild.contains(e);
        return lchild.contains(e);
    }

    public String toString() {
        String ret = lchild.toString();
        ret += val.toString() + " | ";
        return ret + rchild.toString();
    }
}
