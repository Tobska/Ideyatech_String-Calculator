package ideyatech.stringcalc.test;

import org.junit.*;
import static org.junit.Assert.*;

import ideyatech.stringcalc.StringCalculator;

public class StringCalculatorTest {
	
	StringCalculator stringCalc;
	
	@Before
	public void init() {
		stringCalc = new StringCalculator();
	}

	@Test
	public void testCase1 () {
		
		assertEquals(0, stringCalc.calculate(""));
		assertEquals(0, stringCalc.calculate("   "));
		assertEquals(0, stringCalc.calculate(null));
		
	}
	
	@Test
	public void testCase2 () {
		
		assertEquals(55, stringCalc.calculate("55"));
		
	}
	
	@Test
	public void testCase3 () {
	
		assertEquals(100, stringCalc.calculate("10,20,30,40"));
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCase4 () {
		
		stringCalc.calculate("-100");
		
	}
	
	@Test
	public void testCase5 () {
		
		assertEquals(0, stringCalc.calculate("1001"));
		
	}
	
	@Test
	public void testCase6 () {
		
		assertEquals(21, stringCalc.calculate("//=1=2=3=4=5=6"));
		assertEquals(21, stringCalc.calculate("//[abc]1abc2abc3abc4abc5abc6"));
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void allTestCases () {
		
		assertEquals(100, stringCalc.calculate("//[abc]10abc20abc30abc40abc1001"));
		assertEquals(60, stringCalc.calculate("10,20,30,1001"));
		
		stringCalc.calculate("//[abc]10abc20abc30abc40abc1000abc-90");
		stringCalc.calculate("//[abc]10abc20abc30abc40abc-90");
		stringCalc.calculate("10,20,30,40,-80");
		
	}
	
}
