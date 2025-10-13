package Begginer427;

import java.util.Scanner;

// 実装方針：
// 辺削除の全探索を先に行ってしまうと、TLEになってしまうので、先に頂点の色分けをした後に、同じ色の頂点をつないでいる辺削除を行うことで計算量を削減する。
// グローバル変数に辺の最小削除回数をもっておき、色の組み合わせ事の辺の削除回数と比較していくことで、最小の削除回数を求める


public class C {
    private static int minDeleteNum = 0;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            // 頂点と辺の数を取得。配列の番号に合わせて-1をする            
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] node = new int[n];  /* 各頂点の色を保持する配列　黒＝0、白＝1 */
            int[][] edge = new int[m][2]; /* 各辺がつなぐ頂点を保持する配列 */

            // 辺の情報を取得
            for (int i=0; i<m; i++) {
                edge[i][0] = sc.nextInt()-1;
                edge[i][1] = sc.nextInt()-1;
            }
            
            minDeleteNum = edge.length;
            
            C c = new C();
            c.setColor(0, n, node, edge);

            System.out.println(minDeleteNum);
        } 
    }

    // 再起呼び出しで各頂点の色の組み合わせを全探索
    private void setColor(int v,int n,int[] node,int[][] edge) {
        
        if (v==n) {
            // System.out.println(Arrays.toString(node));
            int DeleteNum = 0;

            for(int[] e : edge) {
                if (node[e[0]] == node[e[1]]) {
                    DeleteNum++;
                }
            }

            minDeleteNum = Math.min(minDeleteNum, DeleteNum);
            return;
        }

        // 白に設定
        node[v]=1;
        setColor(v+1,n, node, edge);
        
        // 黒に設定
        node[v]=0;
        setColor(v+1,n, node, edge);
    }
}