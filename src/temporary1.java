
public class temporary1 {
	
	public static Integer getstring(String binary){
		char[] numbers = binary.toCharArray();
		Integer result = 0;
		int cnt = 0;
		
		for(int i=numbers.length-1;i>=0;i--){
			if(numbers[i]=='1')
				result+=(int)Math.pow(2, cnt);
			cnt++;
		}
		
		return result;
	}

	
	public static void main(String[] args){
		System.out.println(getstring("11111111111101111111001011101010"));
	}
}
