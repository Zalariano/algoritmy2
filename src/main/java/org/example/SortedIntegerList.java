package org.example;

import org.example.exceptions.NullItemException;

import java.util.Arrays;
import java.util.Collections;

public class SortedIntegerList extends IntegerListImpl {


    public SortedIntegerList() {
    }

    public SortedIntegerList(int size) {
        super(size);
    }

    @Override
    public int indexOf(Integer item) {
        if (item == null) {
            throw new NullItemException("Параметр item не должен равняться null");
        }

        return Collections.binarySearch(Arrays.asList(storage), item);
    }

    private void sort() {
        SortUtilities.sortSelection(storage);
    }

    @Override
    protected void compress() {
        sort();
        super.compress();
    }
}
