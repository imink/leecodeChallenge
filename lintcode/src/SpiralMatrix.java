/**
 * Created by imink on 12/12/2016.
 */
import java.util.*;
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null) return null;
        if (matrix.length == 0) return res;
        int n = matrix.length;
        int m = matrix[0].length;
        int len = n * m;
        int flag = 0;
        int n1 = 0, m1 = -1;
        while (m != 0 || n != 0) {
            int x = 0;
//            System.out.println(flag);
            if (flag % 4 == 0) {

                m1 ++;
                while (x < m) {
                    res.add(matrix[n1][m1]);
                    x ++;
                    m1 ++;
                }
                m1 --;
                n --;
            }
            else if (flag % 4 == 1) {
                n1 ++;
                while (x < n) {
                    res.add(matrix[n1][m1]);
                    x ++;
                    n1 ++;
                }
                n1 --;
                m --;
            }
            else if (flag % 4 == 2) {
                x = m - 1;
                m1 --;
                while (x >= 0) {
                    res.add(matrix[n1][m1]);
                    x --;
                    m1 --;
                }
                m1 ++;
                n --;
            }
            else if (flag % 4 == 3) {
                x = n - 1;
                n1 --;
                while (x >= 0) {
                    res.add(matrix[n1][m1]);
                    x --;
                    n1 --;
                }
                n1 ++;
                m --;
            }
            flag ++;
            System.out.println(res.size() + " " +len);
            if (res.size() == len) break;

        }
        return res;
    }

    public static void main (String[] args) {
        SpiralMatrix sp = new SpiralMatrix();
        int[][] matrix = {{1,3,4}, {4, 5, 6}, {2,7,7}};
        System.out.println(sp.spiralOrder(matrix));
    }
}
