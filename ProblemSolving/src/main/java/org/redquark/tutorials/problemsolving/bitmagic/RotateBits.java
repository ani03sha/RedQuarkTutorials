package org.redquark.tutorials.problemsolving.bitmagic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anirudh Sharma
 * <p>
 * Given an integer N and an integer D, rotate the binary representation of the integer N by D digits to the
 * left as well as right and print the results in decimal values after each of the rotation.
 */
public class RotateBits {

    private static List<Integer> rotate(int N, int D) {
        // Reduce D to its effective value for a 16 bit number
        D %= 16;
        // This list will store the left and right rotations of N by D
        List<Integer> output = new ArrayList<>();
        // Left rotation
        int left = (N << D | N >> (16 - D)) & 0xFFFF;
        // Right rotation
        int right = ((N >> D | N << (16 - D))) & 0xFFFF;
        output.add(left);
        output.add(right);
        return output;
    }

    public static void main(String[] args) {
        System.out.println(rotate(28, 2));
        System.out.println(rotate(29, 2));
        System.out.println(rotate(54, 6));
    }
}
