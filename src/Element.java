public class Element<T> {
    private T data;
    private Element<T> next;

    public Element(T data) {
        this.next = null;
        this.data = data;
    }

    public Element<T> getNext() {
        return this.next;
    }

    public void setData(T data){
        this.data = data;
    }
    public T getData() {
        return this.data;
    }

    public void setNext(Element<T> el) {
        this.next = el;
    }

    public boolean equals(Element<T> el) {
        if (el == null) {
            return false;
        }

        if ((el.data == null) && (this.data == null)) {
            return true;
        }

        if ((el.data == null) || (this.data == null)) {
            return false;
        }

        return (el.data.equals(this.data));
    }


}