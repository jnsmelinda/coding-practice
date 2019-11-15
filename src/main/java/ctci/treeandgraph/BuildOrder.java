package ctci.treeandgraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static ctci.treeandgraph.State.*;

public class BuildOrder {

    public static void main(String[] args) {
        Node<String> a = new Node<>("A");
        Node<String> b = new Node<>("B");
        Node<String> c = new Node<>("C");
        Node<String> d = new Node<>("D");
        Node<String> e = new Node<>("E");
        Node<String> f = new Node<>("F");
        f.addChild(a, b);
        a.addChild(d);
        b.addChild(d);
        d.addChild(c);
//        d.addChild(f);

        System.out.println(recursiveDFS(f, new Stack<>()));
//        System.out.println(BFS(f));
    }

    private static <T> boolean recursiveDFS(Node<T> node, Stack stack) {
        if (node.getState() == VISITING) {
            return false;
        }
        if (node.getState() == UNVISITED) {
            node.setState(VISITING);
            System.out.println(node);
            List<Node<T>> children = node.getChildren();
            for (Node<T> child : children) {
                if (!recursiveDFS(child, stack)){
                    return false;
                }
            }
            node.setState(VISITED);
            stack.add(node);
        }
        return true;
    }

    private static <T> boolean BFS(Node<String> node) {
        LinkedList<Node<String>> queue = new LinkedList<>();
        queue.add(node);
        return recursiveBFS(node, queue);
    }

    private static <T> boolean recursiveBFS(Node<T> node, LinkedList<Node<String>> queue) {
        if (node.getState() == VISITING) {
            return false;
        }
        if (queue.isEmpty()) {
            return false;
        }
        Node<String> current = queue.poll();
        System.out.println(current);
        current.setState(VISITING);
        for (Node<String> child : current.getChildren()) {
            child.setState(VISITING);
            queue.add(child);
            recursiveBFS(child, queue);
        }
        current.setState(VISITED);
        return true;
    }

    private static <T> void iterativeDFS(Node<T> node) {
        Stack<Node<T>> stack = new Stack<>();
        List list = new ArrayList<>();
        stack.push(node);
        list.add(node);

        while (!stack.isEmpty()) {
            Node<T> actual = stack.pop();
            if (actual.getState() == UNVISITED) {
                actual.setState(VISITING);
                System.out.println(actual);
//                Collections.reverse(actual.getChildren());
                for (Node<T> child : actual.getChildren()) {
                    list.add(child);
                    stack.push(child);
                }
                actual.setState(VISITED);
            }
            else if (actual.getState() != UNVISITED){
                System.out.println("cycle");
            }
        }
    }
}
