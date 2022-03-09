package lanqiao2021;

import java.util.*;

/**
 * 在平面直角坐标系中，两点可以确定一条直线。
 * 如果有多点在一条直线上，那么这些点中任意两点确定的直线是同一条。
 * 给定平面上2 × 3 个整点{(x, y)|0 ≤ x < 2, 0 ≤ y < 3, x ∈ Z, y ∈ Z}，
 * 即横坐标是0 到1 (包含0 和1) 之间的整数、纵坐标是0 到2 (包含0 和2) 之间的整数的点。
 * 这些点一共确定了11 条不同的直线。
 * 给定平面上20 × 21 个整点{(x, y)|0 ≤ x < 20, 0 ≤ y < 21, x ∈ Z, y ∈ Z}，
 * 即横坐标是0 到19 (包含0 和19) 之间的整数、纵坐标是0 到20 (包含0 和20) 之间的整数的点。
 * 请问这些点一共确定了多少条不同的直线。
 */
public class ZhiXian {
    /**
     * 最大公因数,由于java精度不够，所以会导致结果数量多余理论数量，改用最大公约数求斜率和截距。
     *
     * @param a a
     * @param b b
     * @return 最大公因数
     */
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int x = 20, y = 21;
        List<int[]> points = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                points.add(new int[]{i, j});
            }
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                int[] pointX = points.get(i);
                int[] pointY = points.get(j);
                int differenceY = pointY[1] - pointX[1];
                int differenceX = pointY[0] - pointX[0];
                if (differenceX == 0) {
                    set.add("x=" + pointY[0]);
                } else {
                    int c1 = gcd(differenceY, differenceX);
                    String k = differenceY / c1 + " " + differenceX / c1;
                    int c2 = gcd(differenceX * pointY[1] - differenceY * pointY[0], differenceX);
                    String b = (differenceX * pointY[1] - differenceY * pointY[0]) / c2 + " " + differenceX / c2;
                    set.add(k + " " + b);
                }
            }
        }
        System.out.println(set.size());
    }
}
