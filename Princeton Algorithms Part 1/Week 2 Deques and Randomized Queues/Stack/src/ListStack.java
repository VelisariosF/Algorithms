import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ListStack<Item> implements Iterable<Item> {

    private Node first;
    public ListStack() {
        first = null;
    }

    private class Node {
        Item data;
        Node next = null;

        Node(Item data) {
            this.data = data;
        }
    }

    public void push(Item item) {
        Node n = new Node(item);
        n.next = first;
        first = n;
    }

    public Item pop() {
        if (first == null)
            throw new NoSuchElementException();
        Item temp = first.data;
        first = first.next;
        return temp;
    }

    private class StackIterator implements Iterator<Item> {

        Node start = first;
        @Override
        public boolean hasNext() {
            return start != null;
        }

        @Override
        public Item next() {
            Item temp = start.data;
            start = start.next;
            return temp;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    public static void main(String args[]) {
        ListStack<String> stack = new ListStack<String>();
        stack.push("FIRST");
        stack.pop();
//        stack.push("SECOND");
        try{
            stack.pop();
        }
        catch(NoSuchElementException e) {
            System.out.println("No element found in stack!!!");
        }
        for (int i = 1; i <= 10; i++) {
            stack.push(String.valueOf(i) + " * 10 = " + String.valueOf(i * 10) );
        }

        for (String key : stack) {
            System.out.println(key);
        }
    }
}
