/**
 * 货物堆砌：仓库有许多箱子，长A，宽B，
 * 要求：小货物只能堆在大货物之上，即小货物长度和宽度都小于大货物，
 * 输出可能堆出的最大宽度，输入为一个整数，代表有多少个箱子，紧接着是每个箱子的长度和宽度，
 * 每个箱子参数以“；”为边界，样例输入：5；5，5；3，8；7，7；2，9；8，10 样例输出：3
 * Created by imink on 20/12/2016.
 */
import java.util.*;
class Box {
    int l;
    int w;
    Box(int len, int wid) {
        this.l = len;
        this.w = wid;
    }
}

public class NumOfPiles {

    public static Comparator<Box> BoxPQ = new Comparator<Box>() {
        @Override
        public int compare(Box o1, Box o2) {
//            if ((o1.l > o2.l && o1.w > o2.w) || (o1.w > o2.l && o1.l > o2.w)) {
//                return -1;
//            } else if ((o1.l < o2.l && o1.w < o2.w) || (o1.w < o2.l && o1.l < o2.w)) {
//                return 1;
//            } else {
//                return 0;
//            }
            if (o1.l > o2.l || o1.w > o2.w || o1.l > o2.w || o1.w > o2.l) {
                return -1;
            } else {
                return 1;
            }
        }
    };

    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Enter String: ");
//        String input = scan.next();
        String input = "5,5;3,9;7,7;10,8;2,8";
//        String input = "3,3;4,4;6,6;5,5;9,8";
        String[] token = input.split(";");
        PriorityQueue<Box> pq = new PriorityQueue<Box>(5, BoxPQ);
        for (String item: token) {
            String[] temp = item.split(",");
            int len = Integer.parseInt(temp[0]);
            int wid = Integer.parseInt(temp[1]);
            Box box = new Box(len, wid);
            pq.offer(box);
        }

        while (pq.size() != 0) {
            Box newBox = pq.poll();
            System.out.println(newBox.l + " " + newBox.w);
        }

    }
}
