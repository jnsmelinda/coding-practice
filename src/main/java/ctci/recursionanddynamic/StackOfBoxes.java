package ctci.recursionanddynamic;

import java.util.*;

public class StackOfBoxes {
    public static void main(String[] args) throws CloneNotSupportedException {
        List<Box> boxes = new ArrayList<>();
        boxes.add(new Box(2, 2, 2));
        boxes.add(new Box(1, 1, 1));
        boxes.add(new Box(2, 3, 3));
//        boxes.add(new Box(4, 3, 0));
//        boxes.add(new Box(8, 9, 0));
//        boxes.add(new Box(3, 5, 0));

        System.out.println(stackBoxes(boxes));
    }

    public static int stackBoxes(List<Box> boxes) {
        Collections.sort(boxes);
        int maxHeight = 0;
        for (int i = 0; i < boxes.size(); i++) {
            maxHeight = Math.max(stackBoxes(boxes, i), maxHeight);
        }

        return maxHeight;
    }

    private static int stackBoxes(List<Box> boxes, int bottomIndex) {
        Box bottom = boxes.get(bottomIndex);
        int maxHeight = 0;
        for (int i = bottomIndex + 1; i < boxes.size(); i++) {
            if (boxes.get(i).canBeAbove(bottom)) {
                maxHeight = Math.max(stackBoxes(boxes, i), maxHeight);
            }
        }

        maxHeight += bottom.getH();
        return maxHeight;
    }
}

class Box implements Comparable<Box>{
    private int h, w, l;

    public Box(int height, int width, int length) {
        this.h = height;
        this.w = width;
        this.l = length;
    }

    public int getH() {
        return h;
    }

    public int getW() {
        return w;
    }

    public int getL() {
        return l;
    }

    public boolean canBeAbove(Box other) {
        if (this.getW() < other.getW() && this.getL() < other.getL()){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "h:" + h + ",w:" + w + ",l:" + l;
    }

    @Override
    public int compareTo(Box other) {
        return other.h - this.h;
    }

}

