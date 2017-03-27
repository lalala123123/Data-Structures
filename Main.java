package Test;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(bingChaJi(new int[][]{{1,3},{4,3},{2,3}},5));
	}

	// pre通路上前一节点，arr相互连接的两节点，n节点个数
	static int[] pre;

	//arr[m 输入连同边数][2]，n节点个数
	public static int bingChaJi(int[][] arr, int n) {
		pre = new int[n];
		int total = n-1;
		for (int i = 0; i < n; i++) {
			pre[i] = i;
		}
		int f1,f2;
		for (int i = 0; i < arr.length; i++) {
			f1 = find(arr[i][0]-1);
			f2 = find(arr[i][1]-1);
			if(f1 != f2){
				pre[f1] = f2;
				total--;
			}
		}
		return total;
	}

	public static int find(int x) {
		int root = x;
		// 寻找根节点
		while (pre[root] != root) {
			root = pre[root];
		}
		// 路径压缩
		int i = x;
		int j = pre[i];
		while (i != j) {
			j = pre[i];
			pre[i] = root;
			i = j;
		}
		return root;
	}

	//连接两条路
	public static void join(int x, int y) {
		int fx = find(x);
		int fy = find(y);
		if (fx != fy) {
			pre[fy] = fx;
		}
	}

}
