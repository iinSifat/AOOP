class ArraySumThread extends Thread {
    private int[] arr;
    private int start, end;
    private int partialSum = 0;

    // Constructor to initialize the thread with the array and the range of indices
    public ArraySumThread(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    // Method to calculate the partial sum for the given range
    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            partialSum += arr[i];
        }
    }

    // Method to return the partial sum calculated by the thread
    public int getPartialSum() {
        return partialSum;
    }
}

public class MultiThreadSum {
    public static void main(String[] args) throws InterruptedException {
        // Create an array of 10 integers
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Divide the array into 3 parts
        int size = arr.length;
        int partitionSize = size / 3;

        // Create three threads to compute partial sums
        ArraySumThread thread1 = new ArraySumThread(arr, 0, partitionSize);        // Sum first third
        ArraySumThread thread2 = new ArraySumThread(arr, partitionSize, 2 * partitionSize); // Sum second third
        ArraySumThread thread3 = new ArraySumThread(arr, 2 * partitionSize, size); // Sum last third

        // Start all threads
        thread1.start();
        thread2.start();
        thread3.start();

        // Wait for all threads to finish
        thread1.join();
        thread2.join();
        thread3.join();

        // Get the partial sums from all threads
        int totalSum = thread1.getPartialSum() + thread2.getPartialSum() + thread3.getPartialSum();

        // Print the final sum
        System.out.println("Total sum of array: " + totalSum);
    }
}