import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.InputStreamReader;
import java.io.FileInputStream;

public class lab13 
{
	public ArrayList<Integer> y = new ArrayList<>();

	public void readData(String filename)
	{
		try
		{
			BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			String inn;
			while((inn = input.readLine()) != null)
			{
				y.add(Integer.parseInt(inn));
			}
			input.close();
		}
		catch(Exception e)
		{
		}
	}
	
	public long getTotalCount()
	{
		return y.size();
	}
	
	public long getOddCount()
	{
		return y.stream().filter(x -> x % 2 != 0).count();
	}
	
	public long getEvenCount()
	{
		return y.stream().filter(x -> x % 2 == 0).count();
	}
	
	public long getDistinctGreaterThanFiveCount()
	{
		return y.stream().filter(x -> x > 5).count();
	}
	
	public Integer[] getResult1()
	{
		return y.stream().filter(x -> x % 2 == 0).filter(x -> x > 5).filter(x -> x < 50).toArray(Integer[]::new);
	}
	
	public Integer[] getResult2()
	{
		return y.stream().limit(50).map(x -> Math.sqrt(x)).map(x -> x*3).toArray(Integer[]::new);

	}
	
	public Integer[] getResult3()
	{
		return y.stream().filter(x -> x % 2 != 0).map(x -> x*2).sorted().skip(20).distinct().toArray(Integer[]::new);

	}
}