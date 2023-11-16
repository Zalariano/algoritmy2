package org.example;

import org.example.exceptions.InvalidIndexException;
import org.example.exceptions.NullItemException;
import org.example.exceptions.StorageIsFullException;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListImplTest {
    private final IntegerListImpl integerListImpl = new IntegerListImpl();

    @org.junit.jupiter.api.Test
    void add_success() {
        Assertions.assertEquals(integerListImpl.add(1), 1);
    }
    @org.junit.jupiter.api.Test
    void add_StorageIsFullException() {
        setUp();
        integerListImpl.add(9);
        assertThrows(StorageIsFullException.class, () -> integerListImpl.add(9));
    }
    @org.junit.jupiter.api.Test
    void add_NullItemException() {
        setUp();
        assertThrows(NullItemException.class, () -> integerListImpl.add(null));
    }

    @org.junit.jupiter.api.Test
    void AddByIndex_success() {
        setUp();
        Assertions.assertEquals(integerListImpl.add(1, 0), 0);
        Assertions.assertArrayEquals(integerListImpl.toArray(), new Integer[]{1, 0,2, 3});
    }
    @org.junit.jupiter.api.Test
    void AddByIndex_InvalidIndexException() {
        setUp();
        assertThrows(InvalidIndexException.class, () -> integerListImpl.add(5, 0));
    }

    @org.junit.jupiter.api.Test
    void set_success() {
        setUp();
        Assertions.assertEquals(integerListImpl.set(1, 0), 0);
        Assertions.assertArrayEquals(integerListImpl.toArray(), new Integer[]{1, 0,3});
    }

    @org.junit.jupiter.api.Test
    void remove_success() {
        setUp();
        integerListImpl.remove(0);
        Assertions.assertArrayEquals(integerListImpl.toArray(), new Integer[]{2,3});
    }

    @org.junit.jupiter.api.Test
    void RemoveByIndex() {
        setUp();
        Assertions.assertEquals(integerListImpl.remove(1), 2);
        Assertions.assertArrayEquals(integerListImpl.toArray(), new Integer[]{1, 3});
    }

    @org.junit.jupiter.api.Test
    void contains() {
        setUp();
        Assertions.assertTrue(integerListImpl.contains(1));
    }

    @org.junit.jupiter.api.Test
    void indexOf() {
        setUp();
        integerListImpl.set(0, 8);
        integerListImpl.set(1, 8);
        Assertions.assertEquals(integerListImpl.indexOf(8), 0);
        Assertions.assertEquals(integerListImpl.indexOf(10), -1);
    }

    @org.junit.jupiter.api.Test
    void lastIndexOf() {
        setUp();
        integerListImpl.set(0, 8);
        integerListImpl.set(2, 8);
        Assertions.assertEquals(integerListImpl.lastIndexOf(8), 2);
        Assertions.assertEquals(integerListImpl.indexOf(10), -1);
    }

    @org.junit.jupiter.api.Test
    void get_success() {
        setUp();
        Assertions.assertEquals(integerListImpl.get(2), 3);
    }

    @org.junit.jupiter.api.Test
    void Equals_success() {
        setUp();
        IntegerListImpl newIntegerList = new IntegerListImpl();
        newIntegerList.add(1);
        newIntegerList.add(2);
        newIntegerList.add(3);
        Assertions.assertTrue(integerListImpl.equals(newIntegerList));
    }
    @org.junit.jupiter.api.Test
    void size_success() {
        setUp();
        integerListImpl.remove(2);
        Assertions.assertEquals(integerListImpl.size(), 2);
    }

    @org.junit.jupiter.api.Test
    void isEmpty_success() {
        integerListImpl.add(1);
        integerListImpl.remove(1);
        Assertions.assertTrue(integerListImpl.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void clear_success() {
        integerListImpl.clear();
        Assertions.assertTrue(integerListImpl.isEmpty());
    }

    @org.junit.jupiter.api.Test
    public void toArray_success() {
        setUp();
        Assertions.assertArrayEquals(integerListImpl.toArray(), new Integer[]{1, 2, 3});

    }

    private void setUp(){
        integerListImpl.add(1);
        integerListImpl.add(2);
        integerListImpl.add(3);
    }
}
