package com.sets;

public class BSTSet<E extends Comparable<E>> {
    private BSTNode<E> root;
    int size;

    public BSTSet() {
        root = new BSTOuter<E>();
        size = 0;
    }

    public BSTSet<E> sum(BSTSet<E> other) {
        BSTSet<E> result = new BSTSet<>();
        this.root.inOrder(result::add);
        other.root.inOrder(result::add);
        return result;
    } // suma

    public BSTSet<E> difference(BSTSet<E> other) {
        BSTSet<E> result = new BSTSet<>();
        this.root.inOrder(e -> {
            if (!other.contains(e)) {
                result.add(e);
            }
        });
        return result;
    } // roznica

    public BSTSet<E> intersect(BSTSet<E> other) {
        BSTSet<E> result = new BSTSet<>();
        this.root.inOrder(e -> {
            if (other.contains(e)) {
                result.add(e);
            }
        });
        return result;
    } // przeciecie

    public BSTSet<E> add(BSTSet<E> other) {
        other.root.inOrder(this::add);
        return this;
    } // suma

    public BSTSet<E> add(E e) {
        if (!contains(e)) {
            root = root.add(e);
            size++;
        }
        return this;
    }

    public BSTSet<E> remove(BSTSet<E> other) {
        other.root.inOrder(this::remove);
        return this;
    }

    public BSTSet<E> remove(E e) {
        if (contains(e)) {
            root = root.remove(e);
            size--;
        }
        return this;
    }

    public BSTSet<E> cut(BSTSet<E> other) {
        BSTSet<E> intersection = this.intersect(other);
        this.root = new BSTOuter<E>();
        this.size = 0;
        intersection.root.inOrder(this::add);
        return this;
    } // iloczyn

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean contains(E e) {
        if (e == null)
            return false;
        return root.contains(e);
    }

    @Override

    public String toString() {

        return "Tree: " + root.toString();

    }
}
