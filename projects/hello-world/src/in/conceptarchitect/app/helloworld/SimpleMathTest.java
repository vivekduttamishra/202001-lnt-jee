package in.conceptarchitect.app.helloworld;

import static org.junit.Assert.*;

import org.junit.Test;

import in.conceptarchitect.utils.SimpleMath;

public class SimpleMathTest {

	@Test
	public void test() {
		double x=50,y=15;
		double result= SimpleMath.plus(x,y);
		System.out.printf("plus(%f,%f)=%f",x,y,result);
	}

}
