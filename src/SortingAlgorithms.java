/**
*There are four sorting algorithms here: Insertion Sort, Merge Sort, Heap Sort and Binary Tree sort
*/

import java.util.Arrays;

/**
 *
 * @author Hossain
 */
public class SortingAlgorithms {
// complexity = O (n x n) but constant space

    public static int[] insertionSort(int[] input) {
        if (input.length > 1) {
            for (int i = 1; i < input.length; i++) {
                while (i > 0 && input[i] < input[i - 1]) {
                    int temp = input[i - 1];
                    input[i - 1] = input[i];
                    input[i] = temp;
                    i -= 1;
                }
            }
        }
        return input;
    }
// complexity = O (n log n) with extra space

    public static void mergeSort(int[] input) {
        if (input.length == 1) {
            return;
        }

        int mid = input.length / 2;
        int[] left = Arrays.copyOfRange(input, 0, mid);
        int[] right = Arrays.copyOfRange(input, mid, input.length);

        mergeSort(left);
        mergeSort(right);
        merge(left, right, input);
    }

    public static void merge(int[] left, int[] right, int[] input) {

        int i = 0;
        int j = 0;
        int k = 0;
        while (i <= left.length - 1 && j <= right.length - 1) {
            if (left[i] <= right[j]) {
                input[k] = left[i];
                i++;
            } else if (left[i] >= right[j]) {
                input[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            input[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            input[k] = right[j];
            j++;
            k++;
        }
    }
// complexity = O (n log n) but constant space

    public static void heapSort(int[] input) {

        int length = input.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            maxHeapify(i, length, input);
        }
        for (int i = length - 1; i >= 0; i--) {
            int temp = input[0];
            input[0] = input[i];
            input[i] = temp;
            maxHeapify(0, i, input);
        }
    }

    public static void maxHeapify(int i, int len, int[] array) {

        int leftIndex = 2 * i + 1;
        int rightIndex = 2 * i + 2;
        int larger = i;

        if (leftIndex < len && array[leftIndex] > array[larger]) {
            larger = leftIndex;
        }
        if (rightIndex < len && array[rightIndex] > array[larger]) {
            larger = rightIndex;
        }
        if (larger != i) {
            int temp = array[i];
            array[i] = array[larger];
            array[larger] = temp;
            maxHeapify(larger, len, array);
        }

    }

// complexity = O (n log n) but constant space
    public static void binaryTreeSort(int[] array) {

        class Node {
            int i = 0;
            
            int val;
            Node lc;
            Node rc;
            boolean hasLC = false;
            boolean hasRC = false;

            public Node(int val) {
                this.val = val;
            }

            public int getVal() {
                return val;
            }

            public Node getLc() {
                return lc;
            }

            public void setLc(Node lc) {
                this.lc = lc;
                this.hasLC = true;
            }

            public Node getRc() {
                return rc;
            }

            public void setRc(Node rc) {
                this.rc = rc;
                this.hasRC = true;
            }

            public boolean isHasLC() {
                return hasLC;
            }

            public void setHasLC(boolean hasLC) {
                this.hasLC = hasLC;
            }

            public boolean isHasRC() {
                return hasRC;
            }

            public void setHasRC(boolean hasRC) {
                this.hasRC = hasRC;
            }

            public void addNode(int node) {
                if (node > this.getVal() && this.isHasRC() == false) {
                    this.setRc(new Node(node));
                    this.setHasRC(true);
                } else if (node > this.getVal() && this.isHasRC() == true) {
                    this.getRc().addNode(node);
                }

                if (node < this.getVal() && this.isHasLC() == false) {
                    this.setLc(new Node(node));
                    this.setHasLC(true);
                } else if (node < this.getVal() && this.isHasLC() == true) {
                    this.getLc().addNode(node);
                }
            }

            public void sortTree() {
                sortTree(this);
            }
            
            public void sortTree(Node node) {
                if (node == null) {
                    return;
                }
                sortTree(node.getLc());
                array[i]=node.getVal();
                i++;
                sortTree(node.getRc());
            }

        }

        Node binarySearchTree = new Node(array[0]);
        for (int i = 1; i < array.length; i++) {
            binarySearchTree.addNode(array[i]);
        }
        binarySearchTree.sortTree();
    
    }

    public static void main(String[] args) {
        int[] input1 = {5, 4, 1, 2, 6, 9};
        int[] input2 = {9, 8, 7, 6, 5, 4};
        int[] input3 = {9, -8, 7, 6, 5, -4};
        int[] input4 = {2, -1};
        int[] input5 = {-1};
        int[] input6 = {};
        binaryTreeSort(input1);
        print(input1);
    }

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                System.out.print(array[i] + "\n");
            } else {
                System.out.print(array[i] + ",");
            }
        }
    }
}
