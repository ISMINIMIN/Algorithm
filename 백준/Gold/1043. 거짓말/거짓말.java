import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int[] root;
	static int[] persons;
	static ArrayList<Integer> party[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int P = sc.nextInt();
		if(P != 0) {
			persons = new int[P];
			for(int i=0; i<P; i++) {
				persons[i] = sc.nextInt();
			}
		}
		
		root = new int[N+1];
		for(int i=1; i<N+1; i++) {
			root[i] = i;
		}
		
		party = new ArrayList[M];
		
		for(int i=0; i<M; i++) {
			party[i] = new ArrayList<>();
			
			int V = sc.nextInt();
			for(int j=0; j<V; j++) {
				party[i].add(sc.nextInt());
			}
		}
		
		for(int i=0; i<M; i++) {
			int first = party[i].get(0);
			for(int j=1; j<party[i].size(); j++) {
				union(first, party[i].get(j));
			}
		}
		
		int result = 0;
		
		for(int i=0; i<M; i++) {
			boolean flag = true;
			int rootPerson = party[i].get(0);
			for(int j=0; j<P; j++) {
				if(find(rootPerson) == find(persons[j])) {
					flag = false;
					break;
				}
			}
			
			if(flag) result++;
		}
		
		System.out.println(result);
	}

	private static void union(int a, Integer b) {
		a = find(a);
		b = find(b);
		
		if(a != b) root[b] = a;
	}

	private static int find(int a) {
		if(a == root[a]) return a;
		return root[a] = find(root[a]);
	}
}