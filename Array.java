package com.mycompany.operationatarray;

public class Array {

    private int data[];
    private int currentPosition = -1;

    public Array(int size) {
        data = new int[size];
    }

    public boolean addFirst(int value) {
        if (currentPosition < data.length - 1) {
            currentPosition++;
            for (int i = currentPosition; i > 0; i--) {
                data[i] = data[i - 1];
            }
            data[0] = value;
            return true;
        }
        return false;
    }

    public boolean addLast(int value) {
        if (currentPosition >= 0) {
            currentPosition++;
            data[currentPosition] = value;
            return true;
        }
        return false;
    }

    public boolean addIndex(int index, int value) {
        if (currentPosition >= 0 && index >= 0 && index <= currentPosition) {
            currentPosition++;
            for (int i = currentPosition; i > index; i--) {
                data[i] = data[i - 1];
            }
            data[index] = value;
            return true;
        }
        return false;
    }

    public boolean removeFirst() {
        if (currentPosition >= 0) {

            for (int i = 0; i < currentPosition; i++) {
                data[i] = data[i + 1];
            }
            data[currentPosition] = 0;
            currentPosition--;
            return true;
        }
        return false;
    }

    public boolean removeLast() {
        if (currentPosition >= 0) {
            data[currentPosition] = 0;
            currentPosition--;
            return true;
        }
        return false;
    }

    public boolean removeIndex(int index) {
        if (currentPosition >= 0 && index >= 0 && index <= currentPosition) {

            for (int i = index; i < currentPosition; i++) {
                data[i] = data[i + 1];
            }
            data[currentPosition] = 0;
            currentPosition--;
            return true;
        }
        return false;
    }

    public int linearSearch(int target) {
        if (currentPosition >= 0) {

            for (int i = 0; i < currentPosition; i++) {
                if (data[i] == target) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean updateFirst(int value) {
        if (currentPosition >= 0) {
            data[0] = value;
            return true;
        }
        return false;
    }

    public boolean updateLast(int value) {
        if (currentPosition >= 0) {
            data[currentPosition] = value;
            return true;
        }
        return false;
    }

    public boolean upadateIndex(int index, int value) {
        if (currentPosition >= 0 && index >= 0 && index <= currentPosition) {
            data[index] = value;
            return true;
        }
        return false;
    }

    public boolean ascendingSorting() {
        if (currentPosition >= 1) {
            for (int i = 0; i < currentPosition; i++) {
                for (int j = 0; j < currentPosition - i; j++) {
                    if (data[j] > data[j + 1]) {
                        int temp = data[j];
                        data[j] = data[j + 1];
                        data[j + 1] = temp;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public boolean decendingSorting() {
        if (currentPosition >= 1) {
            for (int i = 0; i < currentPosition; i++) {
                for (int j = 0; j < currentPosition - i; j++) {
                    if (data[j] < data[j + 1]) {
                        int temp = data[j];
                        data[j] = data[j + 1];
                        data[j + 1] = temp;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public boolean replaceFirst(int oldValue, int newValue) {
        if (currentPosition >= 0) {
            for (int i = 0; i <= currentPosition; i++) {
                if (data[i] == oldValue) {
                    data[i] = newValue;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean replaceAll(int oldValue, int newValue) {
        if (currentPosition >= 0) {
            for (int i = 0; i <= currentPosition; i++) {
                if (data[i] == oldValue) {
                    data[i] = newValue;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean replaceLast(int oldValue, int newValue) {
        if (currentPosition >= 0) {
            for (int i = currentPosition; i >= 0; i--) {
                if (data[i] == oldValue) {
                    data[i] = newValue;
                    return true;
                }
            }
        }
        return false;
    }

    public void viewFirst() {
        if (currentPosition >= 0) {
            System.out.println(data[0]);
        } else {
            System.out.println("No Data Found. Array is empty");
        }

    }

    public void viewLast() {
        if (currentPosition >= 0) {
            System.out.println(data[currentPosition]);
        } else {
            System.out.println("No Data Found. Array is empty");
        }

    }

    public void viewFirst(int index) {
        if (currentPosition >= 0 && index >= 0 && index <= currentPosition) {
            System.out.println(data[index]);
        } else {
            System.out.println("No Data Found. Array is empty");
        }

    }

    public int binarySearch(int target) {
        if (currentPosition >= 0) {

            ascendingSorting();
            int start = 0;
            int end = currentPosition;
            while (start <= end) {
                int mid = start + (end - start) / 2;

                if (data[mid] == target) {
                    return mid;
                } else if (data[mid] < target) {
                    start = mid + 1;
                } else if (data[mid] > target) {
                    end = mid - 1;
                }
            }
            return -1;
        }
        return -1;
    }

    public int getFirst() {
        if (currentPosition >= 0) {
            return data[0];
        } else {
            return -1;
        }
    }

    public int getLast() {
        if (currentPosition >= 0) {
            return data[currentPosition];
        } else {
            return -1;
        }
    }

    public int getIndex(int index) {
        if (currentPosition >= 0 && index >= 0 && index <= currentPosition) {
            return data[index];
        } else {
            return -1;
        }
    }

    public boolean mergeFirst(int newData[]) {
        int oldSize = data.length;
        int newSize = newData.length;
        int availability = oldSize - (currentPosition + 1);

        if (availability >= newSize) {
            int shiftValue = newSize;
            int marker = currentPosition;

            currentPosition = currentPosition + shiftValue;

            for (int i = currentPosition; i > newSize - 1; i--) {
                data[i] = data[marker];
                marker--;
            }
            for (int i = 0; i < newData.length; i++) {
                data[i] = newData[i];
            }
            return true;
        }

        return false;
    }

    public boolean mergeIndex(int newData[], int index) {
        int oldSize = data.length;
        int newSize = newData.length;
        int availability = oldSize - (currentPosition + 1);

        if (availability >= newSize) {
            int shiftValue = newSize;
            int marker = currentPosition;

            currentPosition = currentPosition + shiftValue;

            for (int i = currentPosition; i > newSize + 1; i--) {
                data[i] = data[marker];
                marker--;
            }
            int size = index;
            for (int i = 0; i < newData.length; i++) {
                data[size] = newData[i];
                size++;
            }
//            int c = 0;
//            while (c < newSize) {
//                data[index] = newData[c];
//                c++;
//                index++;
//            }

            return true;
        }

        return false;
    }

    public boolean mergeLast(int newData[]) {
        int oldSize = data.length;
        int newSize = newData.length;
        int availability = oldSize - (currentPosition + 1);

        if (availability >= newSize) {
            int shiftValue = newSize;
            int totalsize = currentPosition + newSize;
            int c = 0;
            int i = currentPosition + 1;
            while (c < newSize) {
                data[i] = newData[c];
                c++;
                i++;
            }

            return true;
        }

        return false;
    }

    public boolean mergeLast1(int newData[]) {
        int oldSize = data.length;
        int newSize = newData.length;
        int availability = oldSize - (currentPosition + 1);

        if (availability >= newSize) {
            int shiftValue = newSize;
            int marker = currentPosition;
            currentPosition = currentPosition + newSize;
            for (int i = 0; i < newData.length; i++) {
                data[++marker] = newData[i];
            }

            return true;
        }

        return false;
    }

    public void print() {
        for (int i = 0; i <= currentPosition; i++) {
            System.out.println(data[i]);
        }
    }
}
