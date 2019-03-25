import java.io.FileNotFoundException;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class MyList<T extends Comparable> {


    private Element<T> head;
    private int size;

    public MyList() {
        size = 0;
    }

    public MyList(T data) {
        this(new Element<>(data));
    }

    private MyList(Element<T> head) {
        this.head = head;
        size = 1;
    }

    public MyList(MyList<T> list) {
        head = list.head;
        size = list.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Element<T> getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    public void prepend(T data) {
        prepend(new Element<>(data));
    }

    private void prepend(Element<T> el) {
        el.setNext(head);
        head = el;
        size++;
    }

    private void delPrev() {
        head = head.getNext();
        size--;
    }

    public void clear() {
        while (!isEmpty()) {
            delPrev();
        }
        size = 0;
    }

    public void append(T data) {
        append(new Element<>(data));
    }

    private void append(Element<T> el) {
        if (size == 0) {
            prepend(el);
        } else {
            Element<T> p = head;

            while (p.getNext() != null) {
                p.setNext(p.getNext());
            }

            p.setNext(el);
            size++;
        }
    }

    public void insert(T data, int position) {
        insert(new Element<>(data), position);
    }

    public void insertAfter(T x, Element<T> el) {
        Element<T> value = new Element<>(x);
        Element<T> curr = this.head;
        while (el.getData().compareTo(curr.getData()) > 0) {
            if (curr.getNext() == null) break;
            curr = curr.getNext();
        }
        value.setNext(el.getNext());
        el.setNext(value);

        size++;
        return;

    }

    public void insertBefore(T x, Element<T> el){
        Element<T> value = new Element<>(x);
        Element<T> curr = this.head;
        while (!value.equals(curr.getNext())){
            curr = curr.getNext();
        }
        value.setNext(curr.getNext());
        curr.setNext(value);
    }

    private void insert(Element<T> el, int position) {
        if (size == 0 || position <= 0) {
            prepend(el);
        } else if (position >= size) {
            append(el);
        } else {
            Element<T> p = head;
            for (int i = 1; i < position; i++, p = p.getNext()) ;

            el.setNext(p.getNext());
            p.setNext(el);
            size++;
        }
    }


    public void removeElement(Element<T> el) {
        Element<T> curr = this.head;
        while (curr.getNext() != null && !(el.getData().compareTo(curr.getNext().getData()) == 0)) {
            curr = curr.getNext();
        }
        if (curr.getNext().getNext() != null)
            curr.setNext(curr.getNext().getNext());
        else curr.setNext(null);
        size--;
    }

    public void remove(int position) {
        if (size == 0 || position < 0 || position >= size)
            throw new NoSuchElementException();

        if (position == 0) {
            head.setNext(head.getNext());
            size--;
        } else {
            Element<T> p = head;
            for (int i = 1; i < position - 1 && p.getNext() != null; i++, p.setNext(p.getNext())) ;

            Element<T> q = p.getNext().getNext();
            p.getNext().getNext().setNext(null);
            p.setNext(q);
            size--;
        }
    }

    public boolean contains(T data) {
        return contains(new Element<>(data));
    }

    private boolean contains(Element<T> el) {
        if (size == 0) {
            return false;
        }

        Element<T> p = head;

        while (p.getNext() != null) {
            if (p.equals(el)) {
                return true;
            }

            p = p.getNext();
        }

        return p.equals(el);
    }

    public Comparable[] intArray() {
        Comparable[] array = new Comparable[size];
        Element<T> current = head;
        for (int i = 0; i < array.length; i++) {
            array[i] = current.getData();
            current = current.getNext();
        }
        return array;
    }

    public String toString() {
        String res = "[";
        Element<T> curr = head;
        while (curr != null) {
            res += " " + curr.getData() + " ";
            curr = curr.getNext();
        }
        res += "]";
        return res;
    }
}
