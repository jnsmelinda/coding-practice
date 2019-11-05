package treeandgraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static treeandgraph.State.UNVISITED;
import static treeandgraph.State.VISITED;

public class RouteBetweenNodes {
    public static void main(String[] args) {
        Node<String> a = new Node<>("A");
        Node<String> b = new Node<>("B");
        Node<String> c = new Node<>("C");
        Node<String> d = new Node<>("D");
        Node<String> e = new Node<>("E");
        Node<String> f = new Node<>("F");
        Node<String> g = new Node<>("G");
        Node<String> h = new Node<>("H");
        a.addChild(b, f, h);
        b.addChild(c, e);
        c.addChild(d, a);
        e.addChild(g);
        f.addChild(g);

//        recursiveDFS(a);
//        iterativeDFS(a);
//        iterativeBFS(a);

        System.out.println(isPathBetween(b, f));
    }

    private static <T> void iterativeBFS(Node<T> node) {
        Queue<Node<T>> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            Node<T> current = q.remove();
            if (current.getState() == UNVISITED) {
                visit(current);
                for (Node<T> child : current.getChildren()) {
                    q.add(child);
                }
            }
        }
    }

    private static <T> void iterativeDFS(Node<T> node) {
        Stack<Node<T>> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            Node<T> actual = stack.pop();
            if (actual.getState() == UNVISITED) {
                visit(actual);
//                Collections.reverse(actual.getChildren());
                for (Node<T> child : actual.getChildren()) {
                    stack.push(child);
                }
            }
        }
    }

    private static <T> boolean isPathBetween(Node<T> startNode, Node<T> destinationNode) {
        Stack<Node<T>> stack =  new Stack<>();
        stack.push(startNode);

        while (!stack.isEmpty()) {
            Node<T> current = stack.pop();
            if (current.getState() == UNVISITED) {
                visit(current);
                if (current.equals(destinationNode)) {
                    return true;
                }
//                Collections.reverse(current.getChildren());
                for (Node<T> child : current.getChildren()) {
                    stack.push(child);
                }
            }
        }

        return false;
    }

    private static <T> void recursiveDFS(Node<T> node) {
        if (node != null && node.getState() == UNVISITED) {
            visit(node);
//            node.children.forEach(RouteBetweenNodes::recursiveDFS);
            for (Node<T> child : node.getChildren()) {
                recursiveDFS(child);
            }
        }
    }

    private static <T> void visit(Node<T> node) {
        node.setState(VISITED);
        System.out.println(node);
    }
}
