package parameterisation;

import org.testng.annotations.Parameters;
import org.testng.annotations.*;

public class Subtraction {
	
	@Test
	@Parameters({"num1","num2"})
	public void subtract(int a,int b) {
		System.out.println("Addition is "+(a-b));
	}

}
