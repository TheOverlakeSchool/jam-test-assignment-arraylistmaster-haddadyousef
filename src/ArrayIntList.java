import java.util.Scanner;

public class ArrayIntList {

    public static void main(String[] args) {
        boolean isRunning = true;
        ArrayIntList valuesList = new ArrayIntList();
        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            System.out.println("Select an option:");
            System.out.println("'A' to append to the list.");
            System.out.println("'I' to insert at a position.");
            System.out.println("'D' to remove a value.");
            System.out.println("'P' to display all values.");
            System.out.println("'Q' to quit.");

            String choice = scanner.next();
            scanner.nextLine();

            switch (choice) {
                case "A":
                    addToValuesList(valuesList, scanner);
                    break;
                case "I":
                    insertIntoValuesList(valuesList, scanner);
                    break;
                case "D":
                    removeFromValuesList(valuesList, scanner);
                    break;
                case "P":
                    displayValuesList(valuesList);
                    break;
                case "Q":
                    isRunning = false;
                    break;
            }
        }

        scanner.close();
    }

    private static void displayValuesList(ArrayIntList valuesList) {
        valuesList.display();
    }

    private static void addToValuesList(ArrayIntList valuesList, Scanner scanner) {
        System.out.println("Enter a number to add:");
        int number = scanner.nextInt();
        valuesList.append(number);
    }

    private static void insertIntoValuesList(ArrayIntList valuesList, Scanner scanner) {
        System.out.println("Enter a number to insert:");
        int number = scanner.nextInt();
        System.out.println("Enter the index to insert at:");
        int index = scanner.nextInt();
        valuesList.insert(number, index);
    }

    private static void removeFromValuesList(ArrayIntList valuesList, Scanner scanner) {
        System.out.println("Enter the index of the number to remove:");
        int index = scanner.nextInt();
        valuesList.remove(index);
    }
}

class ArrayIntList {
    private int[] elements;
    private int count;

    public ArrayIntList() {
        elements = new int[10]; // Default capacity of 10
        count = 0;
    }

    public void append(int value) {
        ensureCapacity();
        elements[count] = value;
        count++;
    }

    public void insert(int value, int index) {
        if (index < 0 || index > count) {
            System.out.println("Invalid index.");
            return;
        }
        ensureCapacity();
        for (int i = count; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = value;
        count++;
    }

    public void remove(int index) {
        if (index < 0 || index >= count) {
            System.out.println("Invalid index.");
            return;
        }
        for (int i = index; i < count - 1; i++) {
            elements[i] = elements[i + 1];
        }
        count--;
    }

    public void display() {
        if (count == 0) {
            System.out.println("The list is empty.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }

    private void ensureCapacity() {
        if (count >= elements.length) {
            int[] newElements = new int[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
    }
}
