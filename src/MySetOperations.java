public class MySetOperations {

    public static MySet union(MySet A, MySet B) {
        MySet C = new MySet();
        Comparable[] ArrayA = A.toArray();
        Comparable[] ArrayB = B.toArray();

        for (int i = 0; i < ArrayA.length; i++) {
            C.add(ArrayA[i]);
        }
        for (int i = 0; i < ArrayB.length; i++) {
            C.add(ArrayB[i]);
        }
        return C;
    }

    public static MySet intersection(MySet A, MySet B) {
        MySet C = new MySet();
        Comparable[] help = A.toArray();
        Comparable[] help2 = B.toArray();
        for (int i = 0; i < help2.length; i++) {
            if (A.contains(help2[i])) {
                C.add(help2[i]);
            }
        }
        for (int i = 0; i < help.length; i++) {
            if (B.contains(help[i])) {
                C.add(help[i]);
            }
        }

        return C;
    }

    public static MySet difference(MySet A, MySet B) {
        MySet C = new MySet();
        Comparable[] help = A.toArray();
        Comparable[] help2 = B.toArray();
        for (int i = 0; i < help.length; i++) {
            if (!B.contains(help[i])) {
                C.add(help[i]);
            }
        }
        return C;
    }

    public static MySet merge(MySet A, MySet B) {
        MySet C = new MySet();
        C = intersection(A, B);

        if (C.isEmpty()) {
            C = union(A, B);
        }

        return C;
    }

    public static boolean member(Integer a, MySet B) {
        if (B.contains(a)) {
            return true;
        }
        return false;
    }

    public static void makeNull(MySet B) {
        B.clear();
    }

    public static MySet insert(Integer a, MySet B) {
        MySet C = new MySet();
        B.add(a);
        C = B;
        return C;
    }

    public static MySet delete(Integer a, MySet B) {
        MySet C = new MySet();
        B.removeElement(new Element(a));
        return C;
    }

    public static void assign(MySet A, MySet B) {
        A.clear();
        Comparable[] help = B.toArray();
        for (int i = 0; i < help.length; i++) {
            A.add(help[i]);
        }
    }

    public static Comparable min(MySet A) {
        if (A.isEmpty()){
            return null;
        }
        Comparable[] help = A.toArray();
        return help[0];
    }

    public static Comparable max(MySet A) {
        Comparable[] help = A.toArray();
        return help[help.length - 1];
    }

    public static boolean equal(MySet A, MySet B) {
        Comparable[] help = A.toArray();
        Comparable[] help2 = B.toArray();
        if (help.length != help2.length) return false;
        for (int i = 0; i < help.length; i++) {
            if (!(help[i] == help2[i]))
                return false;
        }
        return true;
    }

    public static MySet find(Comparable x, MySet... lists) {

        for (int i = 0; i < lists.length - 1; i++) {
            MySet C = new MySet();
            Comparable[] help = lists[i].toArray();
            for (int k = i; k < lists.length; k++) {
                if (intersection(lists[i], lists[k]).isEmpty()) {
                    return new MySet();
                }
            }

        }
        for (int i = 0; i < lists.length ; i++) {
            if (lists[i].contains(x)){
                return lists[i];
            }
        }
        return null;

    }
}
