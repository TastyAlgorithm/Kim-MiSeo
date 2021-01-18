import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FENCE {
	public static int N;
	public static int height[];
	public static String result;
	
	private static BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int C=Integer.parseInt(input.readLine());  //test case
		
		while(C-->0) {
			N=Integer.parseInt(input.readLine());
			height=new int[N];
			
			String[]data=input.readLine().split(" ");
			for(int i=0;i<N;i++) {
				height[i]=Integer.parseInt(data[i]);
			}
			
			result=MaxArea(0,N-1);
		
			writer.append(result);
			writer.newLine();						
		}
		writer.flush();
		writer.close();		
	}
	
	public static String MaxArea(int left,int right) {
		String resultarea;
		if(left==right) {
			resultarea=Integer.toString(height[left]);
			return resultarea;
		}
		
		int mid=(right+left)/2;
		int area=Math.max(Integer.parseInt(MaxArea(left,mid)),Integer.parseInt(MaxArea(mid+1,right)));
		
		int l=mid;
		int r=mid+1;
		int midheight=Math.min(height[l], height[r]);
		
		area=Math.max(area, midheight*2);
		
		while(left<l || r<right) {
			if(r<right && (l==left || height[l-1]<height[r+1])) {
				r++;
				midheight=Math.min(midheight, height[r]);
			}
			else {
				l--;
				midheight=Math.min(midheight, height[l]);
			}
			area=Math.max(area, midheight*(r-l+1));
		}
		resultarea=Integer.toString(area);
		return resultarea;
	}

}
