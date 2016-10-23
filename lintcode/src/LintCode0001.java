/**
 * Created by imink on 22/10/2016.
 */
import java.util.*;




public class LintCode0001 {

    class Cell {
        public int x, y, h;
        Cell(int _x, int _y, int _h){
            x = _x;
            y = _y;
            h = _h;
        }
    }

    class CellComparator implements Comparator<Cell> {
        @Override
        public int compare(Cell o1, Cell o2) {
            if(o1.h > o2.h) return 1;
            else if (o1.h == o2.h) {
                return 0;
            } else {
                return -1;
            }
        }
    }

    /**
     * @param heights: a matrix of integers
     * @return: an integer
     */
    int []dx = {1,-1,0,0};
    int []dy = {0,0,1,-1};
    public  int trapRainWater(int[][] heights) {
        // write your code here
        if(heights.length == 0)
            return 0;
        // 1 is the init capacity
        PriorityQueue<Cell> q =  new PriorityQueue<Cell>(1,new CellComparator());
        int n = heights.length;
        int m = heights[0].length;
        int [][]visit = new int[n][m];

        for(int i = 0; i < n; i++) {
            q.offer(new Cell(i,0,heights[i][0]));

            q.offer(new Cell(i,m-1,heights[i][m-1]));
            visit[i][0] = 1;
            visit[i][m-1] = 1;
        }
        for(int i = 0; i < m; i++) {
            q.offer(new Cell(0,i,heights[0][i]));

            q.offer(new Cell(n-1,i,heights[n-1][i]));
            visit[0][i] = 1;
            visit[n-1][i] = 1;

        }
        int ans = 0 ;
//        while(!q.isEmpty()){
//            Cell now = q.poll();
//            System.out.println(now.h);
//        }

        while(!q.isEmpty()) {

            Cell now = q.poll();
//            System.out.println(now.h);



            for(int i = 0; i < 4; i++) {

                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(0<=nx && nx < n && 0 <= ny && ny < m && visit[nx][ny] == 0) {
                    visit[nx][ny] = 1;
                    q.offer(new Cell(nx,ny,Math.max(now.h,heights[nx][ny])));
                    ans = ans + Math.max(0,now.h - heights[nx][ny]);
//                    System.out.println(ans);

                }

            }
        }
        return ans;
    }

    public static void main(String args[]) {
        int[][] array = {{12,13,0,12},
                {13,4,13,12},
                {13,8,10,12},
                {12,13,12,12},
                {13,13,13,13}};
        LintCode0001 obj = new LintCode0001();
        System.out.println(obj.trapRainWater(array));
    }

}
