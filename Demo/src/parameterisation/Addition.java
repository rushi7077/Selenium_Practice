package parameterisation;

import org.testng.annotations.*;

public class Addition {
	
	@Test
	@Parameters({"num1","num2"})
	public void add(int a,int b) {
		System.out.println("Addition is "+(a+b));
	}

}
