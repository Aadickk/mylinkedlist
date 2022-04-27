class MyHeap <T extends Comparable<T>> {
    MyArrayList<T> heap = new MyArrayList<> ();
    public void heapify(int i) {
    }
    public void add(T data) {
        heap.add(data);
        heapify((int)data);
    }
    public T remove(int i) {
        T item = heap.get(i);
        T temp = heap.get(i);
        heap.add(heap.get(size()-1), i);
        heap.add(temp, i);
        heap.remove(size()-1);
        heapify(i);
        return item;
    }
    public void removeRoot(int index) {
        heap.remove(index/2);
    }
    public int size() {
        return heap.size();
    }
}