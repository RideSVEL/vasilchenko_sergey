package ua.khpi.oop.vasilchenko12.MyList;

import ua.khpi.oop.vasilchenko12.First.Recruitment;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

//обобщенный контейнер на основе связного списка
public class LinkedContainer<T extends Recruitment> implements Linked<T>, Serializable {
    //конструктор инициализации
    public LinkedContainer() {
        head = new Node<>(null, null, tail);
        tail = new Node<>(null, head, null);
        head = new Node<>(null, null, tail);
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorList();
    }

    public class IteratorList implements Iterator<T> {
        private int position = 0;

        @Override
        public boolean hasNext() {
            return position < size;
        }

        @Override
        public T next() {
            if (this.hasNext()) {
                return getElementByIndex(position++);
            } else {
                throw new NoSuchElementException();
            }
        }
    }

    @Override
    public Iterator<T> descendingIterator() {
        return new Iterator<>() {
            int position = size - 1;

            @Override
            public boolean hasNext() {
                return position >= 0;
            }

            @Override
            public T next() {
                if (this.hasNext()) {
                    position--;
                    return getElementByIndex(position--);
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }

    @Override
    public boolean notEmpty() {
        return size > 0;
    }

    @Override
    public void clear() {
        for (Node<T> x = head; x != null; ) {
            Node<T> next = x.nextElem;
            x.currentElem = null;
            x.nextElem = null;
            x.prevElem = null;
            x = next;
        }
        head = null;
        tail = null;
        tail = new Node<>(null, head, null);
        head = new Node<>(null, null, tail);
        size = 0;
    }

    @Override
    public void add(final T obj) {
        addLast(obj);
    }


    @Override
    public void saveAll() {
        try {
            File file = new File("save1.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);
            System.out.println();
            pw.println(size);
            for (int i = 0; i < size; i++) {
                pw.println(getElementByIndex(i));
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("Error" + e);
        }
    }

    @Override
    public void saveRec() {
        try {
            File file = new File("save1.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);
            Recruitment temp;
            System.out.println();
            pw.println(size);
            for (int i = 0; i < size; i++) {
                temp = (Recruitment) getElementByIndex(i);
                pw.println(temp.getFirm());
                pw.println(temp.getSpecialty());
                pw.println(temp.getWorkingConditions());
                pw.println(temp.getPayment());
                pw.println(temp.getConfirms());
                if (temp.getConfirms()) {
                    pw.println(temp.getNeedsSpeciality());
                    pw.println(temp.getExperience());
                    pw.println(temp.getEducation());
                }
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("Error" + e);
        }
    }

    @Override
    public void readAll() {
        try (BufferedReader br = new BufferedReader(new FileReader("save1.txt"))) {
            Object temp;
            String line;
            line = br.readLine();
            int count = Integer.parseInt(line);
            for (int i = 0; i < count; i++) {
                line = br.readLine();
                temp = line;
                add((T) temp);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void readRec() {
        try (BufferedReader br = new BufferedReader(new FileReader("save1.txt"))) {
            Recruitment temp = new Recruitment();
            String line;
            line = br.readLine();
            int count = Integer.parseInt(line);
            for (int i = 0; i < count; i++) {
                line = br.readLine();
                temp.setFirm(line);
                line = br.readLine();
                temp.setSpecialty(line);
                line = br.readLine();
                temp.setWorkingConditions(line);
                line = br.readLine();
                temp.setPayment(Integer.parseInt(line));
                line = br.readLine();
                temp.setConfirm(Boolean.parseBoolean(line));
                if (temp.getConfirms()) {
                    line = br.readLine();
                    temp.setNeedsSpeciality(line);
                    line = br.readLine();
                    temp.setExperience(Integer.parseInt(line));
                    line = br.readLine();
                    temp.setEducation(line);
                }
                add((T) new Recruitment(temp));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<T> temp = head; i < size; temp = temp.nextElem) {
            result[i++] = temp.currentElem;
        }
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }


    private Node<T> head; //первый элемент
    private Node<T> tail; //последний элемент
    private int size = 0; //размер списка


    @Override
    public void addLast(final T obj) {
        Node<T> prev = tail; //сохранение данных хвоста
        prev.setCurrentElem((T) new Recruitment(obj)); //установка значения
        tail = new Node<>(null, prev, null); //изменение указателя хвоста
        prev.setNextElem(tail); //установка указателя на хвост
        size++; //увелечение размера списка
    }

    @Override
    public void addFirst(final T obj) {
        Node<T> next = head;
        next.setCurrentElem((T) new Recruitment(obj));
        head = new Node<>(null, null, next);
        next.setPrevElem(head);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T getElementByIndex(final int index) {
        Node<T> target = head.getNextElem(); //след элемент первого узла
        for (int i = 0; i < index; i++) {
            target = getNextElement(target);
        }
        return target.getCurrentElem();
    }


    private Node<T> getNextElement(final Node<T> index) {
        return index.getNextElem();
    }

    // head -> null & tail -> null
    // null <- prevElem [head(t = null)] nextElem-> & <- prevElem [head(t = null)] nextElem -> null
    private class Node<T> {
        private T currentElem; //текущий
        private Node<T> prevElem; //предыдущий
        private Node<T> nextElem; //следущий

        //конструктор копирования
        Node(final T currentElem, final Node<T> prevElem, final Node<T> nextElem) {
            this.currentElem = currentElem;
            this.prevElem = prevElem;
            this.nextElem = nextElem;
        }

        //геттеры и сеттеры
        public T getCurrentElem() {
            return currentElem;
        }

        public void setCurrentElem(final T currentElem) {
            this.currentElem = currentElem;
        }

        public Node<T> getPrevElem() {
            return prevElem;
        }

        public void setPrevElem(final Node<T> prevElem) {
            this.prevElem = prevElem;
        }

        public Node<T> getNextElem() {
            return nextElem;
        }

        public void setNextElem(final Node<T> nextElem) {
            this.nextElem = nextElem;
        }
    }

}
