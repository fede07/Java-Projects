import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JinetesTest {

	@Test
	void test1() {
		
		Jinete a = new Jinete();
		
		assertEquals(1, a.jinetes(new int[] {18, 15}));

	}
	
	@Test
	void test2() {
		
		Jinete a = new Jinete();
		
		assertEquals(2, a.jinetes(new int[] {43, 23, 40, 13}));
	}
	
	@Test
	void test3() {
		
		Jinete a = new Jinete();
		
		assertEquals(3, a.jinetes(new int[] {33, 8, 16, 47, 30, 30, 46}));
	}

	@Test
	void test4() {
		
		Jinete a = new Jinete();
		
		assertEquals(3, a.jinetes(new int[] {51, 51, 51}));
	}
	
	@Test
	void test5() {
		
		Jinete a = new Jinete();
		
		assertEquals(4, a.jinetes(new int[] {6, 24, 6, 8, 28, 8, 23, 47, 17, 29, 37, 18, 40, 49}));
	}
	
	@Test
	void test6() {
		
		Jinete a = new Jinete();
		
		assertEquals(3, a.jinetes(new int[] {100,54,96}));
	}
	
	@Test
	void test7() {
		
		Jinete a = new Jinete();
		
		assertEquals(1, a.jinetes(new int[] {0}));
	}
	
	@Test
	public void test8() {
		Jinete a = new Jinete();
		
		assertEquals(1, a.jinetes(new int[] {50,50}));
	}
	
}
