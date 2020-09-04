package leetcode.p1472_browser_history;

import java.util.Stack;

public class BrowserHistory {
    Stack<String> history = new Stack<>();
    Stack<String> historyToFuture = new Stack<>();
    String current;

    public BrowserHistory(String homepage) {
        current = homepage;
    }

    public void visit(String url) {
        history.push(current);
        current = url;
        historyToFuture.clear();
    }

    public String back(int steps) {
        while (!history.isEmpty() && steps > 0) {
            historyToFuture.push(current);
            current = history.pop();
            steps--;
        }

        return current;
    }

    public String forward(int steps) {
        while (!historyToFuture.isEmpty() && steps > 0) {
            history.push(current);
            current = historyToFuture.pop();
            steps--;
        }

        return current;
    }
}
