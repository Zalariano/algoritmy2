package org.example;

import org.example.exceptions.InvalidIndexException;
import org.example.exceptions.NullItemException;
import org.example.exceptions.StorageIsFullException;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {

        private final Integer[] storage;
        private int size;

        public IntegerListImpl() {
            storage = new Integer[4];
        }

        public IntegerListImpl(int initSize) {
            storage = new Integer[initSize];
        }

        private void validateIteme(Integer item) {
            if (item == null) {
                throw new NullItemException();
            }
        }

        private void validateSize() {
            if (size == storage.length) {
                throw new StorageIsFullException();
            }
        }

        private void validateIndex(int index) {
            if (index < 0 || index > size) {
                throw new InvalidIndexException();
            }
        }

        @Override
        public Integer add(Integer item) {
            validateSize();
            validateIteme(item);
            storage[size++] = item;
            return item;
        }

        @Override
        public Integer add(int index, Integer item) {
            validateSize();
            validateIteme(item);
            validateIndex(index);

            if (index == size) {
                storage[size++] = item;
                return item;
            }
            System.arraycopy(storage, index, storage, index + 1, size - index);
            storage[index] = item;
            size++;

            return item;
        }

        @Override
        public Integer set(int index, Integer item) {
            validateIndex(index);
            validateIteme(item);
            storage[index] = item;
            return item;
        }

        @Override
        public Integer remove(Integer item) {
            validateIteme(item);
            int index = indexOf(item);

            return remove(index);
        }

        @Override
        public Integer remove(int index) {
            validateIndex(index);

            Integer item = storage[index];
            if (index != size) {
                System.arraycopy(storage, index + 1, storage, index, size - (index + 1));
            }
            size--;
            return item;
        }

        @Override
        public boolean contains(Integer item) {
            return indexOf(item) != -1;
        }

        @Override
        public int indexOf(Integer item) {
            for (int i = 0; i < size; i++) {
                if (storage[i].equals(item)) {
                    return i;
                }
            }
            return -1;
        }

        @Override
        public int lastIndexOf(Integer item) {
            for (int i = size - 1; i >= 0; i--) {
                if (storage[i].equals(item)) {
                    return i;
                }
            }
            return -1;
        }

        @Override
        public Integer get(int index) {
            validateIndex(index);
            return storage[index];
        }

        @Override
        public boolean equals(IntegerList otherList) {
            return Arrays.equals(this.toArray(), otherList.toArray());
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public boolean isEmpty() {
            return size == 0;
        }

        @Override
        public void clear() {
            size = 0;
        }

        @Override
        public Integer[] toArray() {
            return Arrays.copyOf(storage,  size);
        }
    }

