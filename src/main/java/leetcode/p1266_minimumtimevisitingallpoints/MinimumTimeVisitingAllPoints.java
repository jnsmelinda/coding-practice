package leetcode.p1266_minimumtimevisitingallpoints;

public class MinimumTimeVisitingAllPoints {
    public static void main(String[] args) {
        int[][] points = {{1,1},{3,4},{-1,0}};
        System.out.println(distance(points));
    }

    public static int distance(int[][] points) {
        int distance = 0;
        for (int i = 1; i < points.length; i++) {
            distance += Math.max(Math.abs(points[i][0] - points[i-1][0]),
                Math.abs(points[i][1] - points[i-1][1]));
        }
        return distance;
    }

}
