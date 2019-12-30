package ctci.recursionanddynamic;

import java.util.*;

public class StackOfBoxes {
    public static void main(String[] args) throws CloneNotSupportedException {
        List<Box> boxes = new ArrayList<>();
        boxes.add(new Box(2, 4, 0));
        boxes.add(new Box(1, 9, 0));
        boxes.add(new Box(5, 7, 0));
        boxes.add(new Box(4, 3, 0));
        boxes.add(new Box(8, 9, 0));
        boxes.add(new Box(3, 5, 0));

        stackBoxes(boxes, 0);
    }

    public static int stackBoxes(List<Box> boxes, int height) throws CloneNotSupportedException {
        List<Box> pile = new ArrayList();
        Collections.sort(boxes);
        System.out.println(boxes);
        if (pile.isEmpty()) {
            pile.add(boxes.get(0));
        }

        for (int i = 0; i < boxes.size(); i++) {
            Box bottomBox = boxes.get(i);
            if (bottomBox.getW() >= boxes.get(i + 1).getW()) {
                height += bottomBox.getH();
                pile.add(bottomBox);
            }
            else {

            }
        }

        return height;
    }
}

class Box implements Comparable<Box>, Cloneable{
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

    @Override
    public String toString() {
        return "h:" + h + ",w:" + w + ",l:" + l;
    }

    @Override
    public int compareTo(Box other) {
        return other.h - this.h;
    }

    @Override
    protected Box clone() throws CloneNotSupportedException {
        return (Box) super.clone();
    }
}

