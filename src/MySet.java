public class MySet<T extends Comparable> {
    private MyList<T> linkedList;

    public MySet() {
        linkedList = new MyList<>();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
    public void clear(){
        linkedList.clear();
    }
    public void removeElement(Element<T> el){
        linkedList.removeElement(el);
    }

    public boolean has(T x) {
        return linkedList.contains(x);
    }

    public void add(T x) {
        if (linkedList.getSize() == 0) {
            linkedList.prepend(x);
            return;
        }
        Element<T> el = linkedList.getHead();
        if (linkedList.isEmpty() || x.compareTo(el.getData()) < 0) {
            linkedList.prepend(x);
            return;
        }
        if (linkedList.contains(x)) return;
        while (el.getNext() != null && (x.compareTo(el.getNext().getData()) > 0)) {
            el = el.getNext();
        }
        if (el.getNext() == null || x.compareTo(el.getData()) > 0) {
            linkedList.insertAfter(x, el);
            return;
        }
                linkedList.insertBefore(x,el);
    }

    public boolean contains(T x){
        if (linkedList.contains(x)){
            return true;
        }
        return false;
    }

    public void del(T x) {
        Element<T> el = linkedList.getHead();
        while (el != null) {
            if (x.compareTo(el.getData()) == 0) {
                linkedList.removeElement(el);
            }
            if (x.compareTo(el.getData()) < 0) {
                return;
            }
            el = el.getNext();
        }
    }

    public String toString() {
        return "" + linkedList;
    }

    public Comparable[] toArray() {
        return linkedList.intArray();
    }

}
