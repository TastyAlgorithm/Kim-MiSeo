import java.io.*;
import java.util.Arrays;

public class Main { //왜 오답인지 모르겠네?
	private static BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int T=Integer.parseInt(input.readLine());
		
		while(T-->0) {
			int sum=0;
			int N=Integer.parseInt(input.readLine());
			String men[]=input.readLine().split(" ");
			String women[]=input.readLine().split(" ");					
			
			Arrays.sort(men); //오름차순으로 정렬하기
			Arrays.sort(women);
			
			for(int i=0;i<N;i++) {
				int diff=Integer.parseInt(men[i])-Integer.parseInt(women[i]);
				if(diff<0)
					diff=-diff;				
				sum+=diff;					
			}			
			writer.append(Integer.toString(sum));
			writer.newLine();			
		}		
		writer.flush();
		writer.close();	
	}
}
