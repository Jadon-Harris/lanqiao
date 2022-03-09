package lanqiao2021;

/**
 * 小蓝有一个超大的仓库，可以摆放很多货物。
 * 现在，小蓝有n 箱货物要摆放在仓库，每箱货物都是规则的正方体。
 * 小蓝规定了长、宽、高三个互相垂直的方向，每箱货物的边都必须严格平行于长、宽、高。
 * 小蓝希望所有的货物最终摆成一个大的立方体。即在长、宽、高的方向上分别堆L、W、H 的货物，满足n = L × W × H。
 * 给定n，请问有多少种堆放货物的方案满足要求。
 * 例如，当n = 4 时，有以下6 种方案：1×1×4、1×2×2、1×4×1、2×1×2、2×2×1、4×1×1。
 * 请问，当n = 2021041820210418 （注意有16 位数字）时，总共有多少种
 * 方案？
 */
public class HuoWuBaiFang {
    /**
     * 找因子
     *
     * @return 所有因子
     */
    public static long[] factors(long n) {
        long[] factors = new long[300];
        int pos = 0;
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                factors[pos++] = i;
                if (i != n / i) {
                    factors[pos++] = n / i;
                }
            }
        }
        return factors;
    }

    public static void main(String[] args) {
        long n = 2021041820210418L;
        long[] factors = factors(n);
        int res = 0;
        for (long factor1 : factors) {
            for (long factor2 : factors) {
                if (factor1 * factor2 > n) {
                    continue;
                }
                for (long factor3 : factors) {
                    if (factor1 * factor2 * factor3 == n) {
                        res++;
                    }
                }
            }
        }
        System.out.println(res);
    }
}
