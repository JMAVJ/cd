public class SinglyLinkedList {
    public Node head;
    
    public SinglyLinkedList() {
        this.head = null;
    }

    public SinglyLinkedList(int headValue) {
        Node headNode = new Node(headValue);
        this.head = headNode;
    }

    public void add(int value) {
        Node newNode = new Node(value); 
        if (this.head == null) {
            this.head = newNode;
            return;
        }
        Node lastNode = this.head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
    }

    public void removeLast() {
        Node runner = this.head;
        while (runner.next.next != null) {
            runner = runner.next;
        }
        runner.next = null;
    }

    public void printValues() {
        Node runner = this.head;
        while (true) {
            System.out.println(runner);
            if (runner.next == null) {
                break;
            }
            runner = runner.next;
        }
    }

    public Node find(int value) {
        Node runner = this.head;
        while (runner.next != null) {
            if (runner.value == value) {
                return runner;
            }
            runner = runner.next;
        }
        return null;
    }

    public void removeAt(int position) {
        if (position == 0) {
            this.head = this.head.next;
            return;
        }
        Node previousNode = this.head;
        Node currentNode = this.head.next;
        for (int i=1; i<=position; i++) {
            if (i == position) {
                previousNode.next = currentNode.next;
                break;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
    }
}