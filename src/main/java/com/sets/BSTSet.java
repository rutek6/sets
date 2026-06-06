package com.sets;

public class BSTSet<E extends Comparable<E>> {
    private BSTNode<E> root;
    int size;

    public BSTSet() {
        root = BSTOuter.getInstance();
        size = 0;
    }

    public BSTSet<E> sum(BSTSet<E> other) {
        BSTSet<E> result = new BSTSet<>();
        this.root.inOrder(result::add);
        other.root.inOrder(result::add);
        return result;
    }

    public BSTSet<E> difference(BSTSet<E> other) {
        BSTSet<E> result = new BSTSet<>();
        this.root.inOrder(e -> {
            if (!other.contains(e)) {
                result.add(e);
            }
        });
        return result;
    }

    public BSTSet<E> intersect(BSTSet<E> other) {
        BSTSet<E> result = new BSTSet<>();
        this.root.inOrder(e -> {
            if (other.contains(e)) {
                result.add(e);
            }
        });
        return result;
    }

    public BSTSet<E> add(BSTSet<E> other) {
        other.root.inOrder(this::add);
        return this;
    }

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
        this.root = BSTOuter.getInstance();
        this.size = 0;
        intersection.root.inOrder(this::add);
        return this;
    }

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
        String treeStr = root.toString().trim();
        if (treeStr.isEmpty()) {
            return "Tree: []";
        }
        return "Tree: [" + treeStr.replace(" ", ", ") + "]";
    }
}
