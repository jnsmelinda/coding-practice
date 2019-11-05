package treeandgraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node<T> {
    private State state;
    private final T data;
    private final List<Node<T>> children;

    public Node(T data) {
        this.data = data;
        this.state = State.UNVISITED;
        this.children = new ArrayList<>();
    }

    public Node<T> setState(State state) {
        this.state = state;
        return this;
    }

    public State getState() {
        return state;
    }

    public Node<T> addChild(Node<T>... child) {
        children.addAll(Arrays.asList(child));
        return this;
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
