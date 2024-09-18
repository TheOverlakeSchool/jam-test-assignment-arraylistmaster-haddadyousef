public class ArrayIntList {
    private int[] contents;

    public ArrayIntList(int userSize) {
        contents = new int[userSize];
    }
        
    public ArrayIntList() {
        this(1); 
    }
    

    @Override
    public String toString() {
        if (size() == 0) {
            return "[]";
        } else {
            String result = "[" + contents[0];
            for (int i = 1; i < size(); i++) {
                result += ", " + contents[i];
            }
            result += "]";
            return result;
        }
    }

    public void add (int newValue) {
        contents[size()] = newValue;
    }

    public int size() {
        int count = 0;
        for (int i = 0; i < contents.length; i++) {
            if (contents[i] != 0) {
                count++;
            }
        }
        return count;
    }

    public void add(int index, int value) {
        for (int i = size(); i > index; i--) {
            contents[i] = contents[i - 1];
        }
        contents[index] = value;
    }

    public void set(int index, int value) {
        contents[index] = value;
    }

    public int get(int index) {
        return contents[index];
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int indexOf(int value) {
        for (int i = 0; i < size(); i++) {
            if (contents[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

}
