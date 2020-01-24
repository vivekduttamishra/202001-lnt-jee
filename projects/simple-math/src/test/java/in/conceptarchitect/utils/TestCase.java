package in.conceptarchitect.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCase {

	@Test
	public void test1() {
		double x=50, y=15;
		double result=SimpleMath.plus(x, y);
		System.out.printf("sum(%f,%f) => %f\n",x,y,result);
	}
	
	@Test
	public void test2() {
		double x=50, y=15;
		double result=SimpleMath.minus(x, y);
		System.out.printf("minus(%f,%f) => %f\n",x,y,result);
		assertEquals(x-y, result, 0.01);
	}
	
	@Test
	public void testMultiply() {
		double x=50, y=15;
		double result=SimpleMath.multiply(x, y);
		System.out.printf("multiply(%f,%f) => %f\n",x,y,result);
		
		if(result!=x*y) //I failed. there is an error
			throw new RuntimeException("expected "+(x*y)+ " got "+result);
	}
	
	@Test
	public void testDivide() {
		double x=50, y=15;
		double result=SimpleMath.divide(x, y);
		System.out.printf("divide(%f,%f) => %f\n",x,y,result);
		if(result!=x/y)
			throw new AssertionError("expected "+(x/y)+" found "+result);
	}
	
	@Test
	public void divideReturnsValueBetween0And1IfDrIsGreaterThanNr() {
		
	}

}
