package leetcode.p1472_browser_history;

public class User {
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");
        String param_2 = browserHistory.back(3);
        String param_3 = browserHistory.forward(2);
    }
}
