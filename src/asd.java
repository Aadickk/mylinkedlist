public interface asd<T> {
    void add(T item, int index);

    void add(int index, T e);

    T remove(int index);

    void clear();

    int indexOf(T e);

    int lastIndexOf(T e);
}
