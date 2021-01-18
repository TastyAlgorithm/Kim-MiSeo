import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class QUADTREE {
	public static String tree;
	public static int index;
	public static String result;
	
	private static BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int C=Integer.parseInt(input.readLine());  //test case
		
		while(C-->0) {
			tree=(String) input.readLine();
			index=0;
			result=solve();
			
			writer.append(result);
			writer.newLine();
			
		}
		writer.flush();
		writer.close();				
	}
	
	public static String solve() {
		char c=tree.charAt(index);
		
		if(c!='x') { //x가 아니면
			return c+""; //string 으로 만들어주기 위해 "" 추가
		}
		
		index++;
		String str1=solve();
		
		index++;
		String str2=solve();
		
		index++;
		String str3=solve();
		
		index++;
		String str4=solve();
		
		return "x"+str3+str4+str1+str2;
	}

}
