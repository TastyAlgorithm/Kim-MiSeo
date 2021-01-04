import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	private static BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int C=Integer.parseInt(input.readLine());
		
		while(C-->0) {
			String[]data=input.readLine().split(" ");
			int N=Integer.parseInt(data[0]);
			int K=Integer.parseInt(data[1]);
			
			writer.append(calculate_josephus(N,K));
			writer.newLine();
		}		
		writer.flush();
		writer.close();			
}

private static String calculate_josephus(int n,int k) {
	List<Integer> list=new LinkedList<>();
	for(int i=1;i<=n;i++) {
		list.add(i);  //연결리스트 만들기
	}
	
	//Iterator를 이용하여 리스트를 옮겨다닌다.
	Iterator<Integer> iterator=list.iterator();
	iterator.next(); //첫 노드를 가리키는 헤드니까 첫 노드로 이동해준다.
	
	while(n>2) { //사람 2명남으면 끝
		iterator.remove();
		if(!iterator.hasNext()) { //다음 노드가 없으면
			iterator=list.iterator();
		}
		iterator.next(); //다음 노드가 있으면 옮김.
		n--; //사람한명 죽었으니까
		
		for(int i=0;i<k-1;i++) { //k번째로 이동
			if(!iterator.hasNext()) {
				iterator=list.iterator();
			}
			iterator.next();
		}
	}
	return list.stream().map(String::valueOf).collect(Collectors.joining(" "));		
	}	
}
