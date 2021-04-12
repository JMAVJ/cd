public class ListTest {
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.add(1); //0 next
        sll.add(3); //1
        sll.add(5); //2
        sll.add(6); //3
        //sll.printValues();
        System.out.println("=====");
        //sll.removeLast();
        //sll.printValues();
        //System.out.println("=====");
        //System.out.println(sll.find(10));
        //System.out.println("=====");
        sll.removeAt(1);
        sll.printValues();
    }
}