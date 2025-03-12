import java.io.*;
import java.util.*;

public class Hipuy10 {

    static class MaxHeap {
        private List<Integer> heap;

        public MaxHeap() {
            heap = new ArrayList<>();
        }

        public void insert(int value) {
            heap.add(value);
            heapifyUp(heap.size() - 1);
        }

        public int extractMax() {
            if (heap.size() == 0) {
                throw new NoSuchElementException();
            }
            int max = heap.get(0);
            int last = heap.get(heap.size() - 1);
            heap.set(0, last);
            heap.remove(heap.size() - 1);
            heapifyDown(0);
            return max;
        }

        private void heapifyUp(int index) {
            while (index > 0) {
                int parentIndex = (index - 1) / 2;
                if (heap.get(index) <= heap.get(parentIndex)) {
                    break;
                }
                Collections.swap(heap, index, parentIndex);
                index = parentIndex;
            }
        }

        private void heapifyDown(int index) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int largest = index;

            if (leftChildIndex < heap.size() && heap.get(leftChildIndex) > heap.get(largest)) {
                largest = leftChildIndex;
            }
            if (rightChildIndex < heap.size() && heap.get(rightChildIndex) > heap.get(largest)) {
                largest = rightChildIndex;
            }

            if (largest != index) {
                Collections.swap(heap, index, largest);
                heapifyDown(largest);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine().trim());
        MaxHeap maxHeap = new MaxHeap();

        for (int i = 0; i < N; i++) {
            String[] command = reader.readLine().split(" ");
            if (command[0].equals("0")) {
                int number = Integer.parseInt(command[1]);
                maxHeap.insert(number);
            } else if (command[0].equals("1")) {
                int max = maxHeap.extractMax();
                writer.write(max + "\n");
            }
        }

        reader.close();
        writer.close();
    }
}
