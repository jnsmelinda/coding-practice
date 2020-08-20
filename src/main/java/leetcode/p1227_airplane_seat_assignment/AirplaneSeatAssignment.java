package leetcode.p1227_airplane_seat_assignment;

import javax.sound.midi.Soundbank;

public class AirplaneSeatAssignment {
    public static void main(String[] args) {
        System.out.println(nthPersonGetsNthSeat(9));
    }
    public static double nthPersonGetsNthSeat(int n) {
        if (n == 1) {
            return 1;
        }
        else {
            return 0.5;
        }
    }
}
