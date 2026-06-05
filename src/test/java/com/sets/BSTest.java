package com.sets;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class BSTSetTest {

    private BSTSet<Integer> set1;
    private BSTSet<Integer> set2;

    @BeforeEach
    void setUp() {
        set1 = new BSTSet<>();
        set1.add(1).add(2).add(3).add(4); // set1: [1, 2, 3, 4]

        set2 = new BSTSet<>();
        set2.add(3).add(4).add(5).add(6); // set2: [3, 4, 5, 6]
    }

    @Test
    void testAddAndSize() {
        BSTSet<Integer> set = new BSTSet<>();
        assertTrue(set.isEmpty());
        assertEquals(0, set.size());

        set.add(10).add(5).add(15);

        assertFalse(set.isEmpty());
        assertEquals(3, set.size());
        assertEquals("Tree: [5, 10, 15]", set.toString());

        set.add(10);
        assertEquals(3, set.size(), "Zbiór nie powinien powiększać się przy dodawaniu duplikatów");
    }

    @Test
    void testContains() {
        assertTrue(set1.contains(2));
        assertFalse(set1.contains(99));
        assertFalse(set1.contains(null));
    }

    @Test
    void testRemoveElement() {
        set1.remove(2);
        assertFalse(set1.contains(2));
        assertEquals(3, set1.size());
        assertEquals("Tree: [1, 3, 4]", set1.toString());

        set1.remove(1);
        assertEquals("Tree: [3, 4]", set1.toString());
    }

    @Test
    void testNonMutatingSum() {
        BSTSet<Integer> result = set1.sum(set2);

        assertEquals("Tree: [1, 2, 3, 4, 5, 6]", result.toString());
        assertEquals(6, result.size());

        // Upewniamy się, że zbiory pierwotne pozostały nienaruszone
        assertEquals(4, set1.size(), "set1 nie powinien zostać zmodyfikowany");
        assertEquals("Tree: [1, 2, 3, 4]", set1.toString());
    }

    @Test
    void testNonMutatingDifference() {
        BSTSet<Integer> result = set1.difference(set2);

        assertEquals("Tree: [1, 2]", result.toString());
        assertEquals(2, result.size());

        assertEquals(4, set1.size(), "set1 nie powinien zostać zmodyfikowany");
    }

    @Test
    void testNonMutatingIntersect() {
        BSTSet<Integer> result = set1.intersect(set2);

        assertEquals("Tree: [3, 4]", result.toString());
        assertEquals(2, result.size());

        assertEquals(4, set1.size(), "set1 nie powinien zostać zmodyfikowany");
    }

    @Test
    void testMutatingAddSet() {
        set1.add(set2);

        assertEquals("Tree: [1, 2, 3, 4, 5, 6]", set1.toString());
        assertEquals(6, set1.size());
    }

    @Test
    void testMutatingRemoveSet() {
        set1.remove(set2);

        assertEquals("Tree: [1, 2]", set1.toString());
        assertEquals(2, set1.size());
    }

    @Test
    void testMutatingCut() {
        set1.cut(set2);

        assertEquals("Tree: [3, 4]", set1.toString());
        assertEquals(2, set1.size());
    }
}