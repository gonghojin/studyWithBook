package algorithm.baekjooncourse3.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair2667 {
    int x;
    int y;

    public Pair2667(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Baekjoon2667 {
    public static final int[] dx = {0, 0, -1, 1};
    public static final int[] dy = {-1, 1, 0, 0};

    public static void bfs(int[][] home, int[][] group, int groupId, int x, int y, int t) {
        Queue<Pair2667> queue = new LinkedList<Pair2667>();
        queue.add(new Pair2667(x, y));
        group[x][y] = groupId;
        while (!queue.isEmpty()) {
            Pair2667 pair = queue.poll();
            int currentX = pair.x;
            int currentY = pair.y;

            for (int i = 0; i < 4; i++) {
                int addX = currentX + dx[i];
                int addY = currentY + dy[i];
                if (0 <= addX && addX < t && 0 <= addY && addY < t) {
                    if (home[addX][addY] == 1 && group[addX][addY] == 0) {
                        queue.add(new Pair2667(addX, addY));
                        group[addX][addY] = groupId;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[][] home = new int[t][t];
        for (int i = 0; i < t; i++) {
            String line = br.readLine();
            for (int j = 0; j < t; j++) {
                home[i][j] = line.charAt(j) - '0';
            }
        }

        int[][] group = new int[t][t];
        int groupId = 0;
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < t; j++) {
                if (group[i][j] == 0 && home[i][j] == 1) {
                    bfs(home, group, ++groupId, i, j, t);
                }
            }
        }

        int[] groupIdTotal = new int[groupId];
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < t; j++) {
                if (group[i][j] != 0) {
                    groupIdTotal[group[i][j] - 1]++;
                }
            }
        }
        Arrays.sort(groupIdTotal);
        System.out.println(groupId);
        for (int x : groupIdTotal) {
            System.out.println(x);
        }
    }
}
