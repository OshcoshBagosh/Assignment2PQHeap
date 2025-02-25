package org.example;

public class PQHeap implements PriorityQueue {

    private Player[] data;
    private int size;

    public PQHeap(){
        data = new Player[10000];
        size = 0;
    }

    /**
     * Given an index it should return index of parent
     * @param index
     * @return
     */
    private int getParentIndex(int index){
        return (index - 1)/2;
    }

    /**
     * Given an index it should return the index of the left child
     * @param index
     * @return
     */
    private int getLeftChildIndex(int index){

        return (2 * index) + 1;
    }

    /**
     * Given an index it should return the index of the right child
     * @param index
     * @return
     */
    private int getRightChildIndex(int index){
        return (2 * index) + 2;
    }

    /**
     * Swaps the elements at index1 and index2 of the array
     * @param index1
     * @param index2
     */
    private void swap(int index1, int index2){
        Player temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    } //end - swap

    private void heapifyUp(int index){
        int parentIndex = getParentIndex(index);
        while ((index > 0) && (data[index].getScore() > data[parentIndex].getScore())){
            swap(index, getParentIndex(index));
            index = parentIndex;
            parentIndex = getParentIndex(index);
        }
    }  //end - heapifyUp

    private void heapifyDown(int index) {
        while (true) {
            int left = getLeftChildIndex(index);
            int right = getRightChildIndex(index);
            int max = index;

            if (left < size && data[left].getScore() > data[max].getScore()) {
                max = left;
            }
            if (right < size && data[right].getScore() > data[max].getScore()) {
                max = right;
            }

            if (max == index) {
                break;
            }

            swap(index, max);
            index = max;
        }
    }

    @Override
    public void add(Player p) {
        data[size] = p;
        heapifyUp(size);
        size++;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Player getHighestScorePlayer() {
        Player priority = this.data[0];
        this.data[0] = this.data[size-1];
        size--;
        heapifyDown(0);
        return priority;
    }

    public void show(){
        for (int i = 0; i < size ; i++) {
            System.out.print("(" + data[i].getName() + " " + data[i].getScore() + ") ");
        }
        System.out.println();
    }
}
