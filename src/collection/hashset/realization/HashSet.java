package collection.hashset.realization;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HashSet<E> {
    private List<E> elements;

    public HashSet() {
        elements = new ArrayList<>();
    }

    /**
     * Метод add().
     * Добавляет элемент в HashSet, если его там еще нет.
     * @param element элемент для добавления
     * @return true, если элемент успешно добавлен, false, если элемент уже присутствует в HashSet
     */

    public boolean add(E element) {
        if (!contains(element)) {
            elements.add(element);
            return true;
        }
        return false;
    }

    /**
     * Метод remove().
     * Удаляет элемент из HashSet.
     * @param element элемент для удаления
     * @return true, если элемент успешно удален, false, если элемент отсутствует в HashSet
     */

    public boolean remove(E element) {
        return elements.remove(element);
    }

    /**
     * Метод contains().
     * Проверяет, содержит ли HashSet указанный элемент.
     * @param element элемент для проверки наличия
     * @return true, если HashSet содержит указанный элемент, иначе false
     */

    public boolean contains(E element) {
        return elements.contains(element);
    }

    /**
     * Метод set().
     * Заменяет элемент по индексу новым элементом.
     * @param index индекс элемента для замены
     * @param newElement новый элемент
     */

    public void set(int index, E newElement) {
        elements.set(index, newElement);
    }

    /**
     * Метод sublist().
     * Возвращает подсписок элементов в указанном диапазоне индексов.
     * @param fromIndex начальный индекс подсписка
     * @param toIndex конечный индекс подсписка
     * @return подсписок элементов в заданном диапазоне
     */

    public List<E> sublist(int fromIndex, int toIndex) {
        return elements.subList(fromIndex, toIndex);
    }

    /**
     * Метод size().
     * Возвращает количество элементов в HashSet.
     * @return количество элементов в HashSet
     */

    public int size() {
        return elements.size();
    }

    public static void main(String[] args) {
        HashSet<Integer> mySet = new HashSet<>();
        mySet.add(1);
        mySet.add(2);
        mySet.add(3);
        mySet.add(4);
        mySet.add(5);

        System.out.println("Size of set: " + mySet.size());

        System.out.println("Elements in set:");
        for (Integer element : mySet.sublist(0, mySet.size())) {
            System.out.println(element);
        }

        mySet.remove(2);

        System.out.println("Size of set after removing element: " + mySet.size());

        System.out.println("Is 2 in set? " + mySet.contains(2));


    }
}