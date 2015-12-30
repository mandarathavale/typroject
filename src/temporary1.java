
public class temporary1 
{
	public static Integer getstring(String binary)
	{
		Integer result = 0;
		int cnt=0;
		for(int i=binary.length()-1;i>=0;i--)
		{
			if(binary.charAt(i)=='1')
				result+=(int) Math.pow(2, cnt);
			
			cnt++;
		}
		return result;
	}
}