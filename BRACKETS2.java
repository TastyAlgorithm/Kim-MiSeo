import java.util.*;

public class Main {
	static int C;
	static String brackets;
	static int result[];
	static Stack stack;
	
	public static void main(String[] args) {
		stack=new Stack<Object>();
		
		Scanner sc=new Scanner(System.in); 
		C=Integer.parseInt(sc.nextLine());
		result=new int[C];
		
		for(int i=0;i<C;i++) {
			brackets=sc.nextLine(); //trim() 은 공백을 없애줌.
			//System.out.println(brackets.length());
			result[i]=calbrackets(brackets);			
		}
		
		for(int i=0;i<C;i++) {
			if(result[i]!=0) 
				System.out.println("NO");
			else
				System.out.println("YES");
		}
	}

public static int calbrackets(String b) {
	stack.clear();		
	if(b.length()%2!=0)//짝수가 아니라면
		return -1;
	
	//String[]array=b.split("");
	char [] array=b.toCharArray();
	String openstring="({["; //열린괄호 설정
	
	for(int i=0;i<array.length;i++) {	
		//indexOf() 는 특정 문자나 문자열이 앞에서부터 처음발견되는 인덱스 반환
		//없을경우 -1을 반환
		if(openstring.indexOf(array[i])>-1) { //열린괄호가 있을 때
			stack.push(array[i]); //stack에 push			
		} 
		
		else { //열린괄호가 아닐때
			if(stack.empty())  //스택이 비어있다 
				return -1;	
			
			if(array[i]=='}') {
				if((char)stack.pop()=='{') {
					continue;
				}else
					return -1;
			}
			
			if(array[i]==']') {
				if((char)stack.pop()=='[') {
					continue;
				}else
					return -1;
			}
			
			if(array[i]==')') {
				if((char)stack.pop()=='(') {
					continue;
				}else
					return -1;
			}
		}	
	}
	
	if(!stack.isEmpty()) //stack이 비어있지 않다면
		return -1;
	
	return 0;		
}	
}

