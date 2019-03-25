public class Main {
    public static void main(String[] args) {
        MySet<Integer> example = new MySet();
        example.add(9);
        System.out.println(example);
        example.add(44);
        System.out.println(example);
        MySet<Integer> examle2 = new MySet();
        examle2.add(70);
        System.out.println(examle2);
        examle2.add(64);
        System.out.println(examle2);
        examle2 = MySetOperations.union(example,examle2);
        System.out.println("result: " + examle2);


    }


}
