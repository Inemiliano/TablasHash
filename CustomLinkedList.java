public class CustomLinkedList {
    Node head;

    public void insert(String key, String[] data) {
        Node newNode = new Node(key, data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public String[] search(String key) {
        Node temp = head;
        while (temp != null) {
            if (temp.key.equals(key)) {
                return temp.data;
            }
            temp = temp.next;
        }
        return null;
    }
}
