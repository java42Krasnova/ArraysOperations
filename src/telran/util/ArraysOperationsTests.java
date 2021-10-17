package telran.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static telran.util.ArraysOperations.*;

class ArraysOperationsTests {

	private static final String INSERTED_STRING = "World and ";
	private static final int INSERTED_NUMBER = 100;

	@Test
	void testInsert() {
		String arStr[] = {"hello", "Java"}; 
		String expectedStr[] = {"hello", INSERTED_STRING, "Java"}; 
		String actualStr[] = new String[arStr.length + 1];
		int indexInsert = 1;
		assertEquals(OK,insert(arStr, INSERTED_STRING, indexInsert, actualStr));
		assertArrayEquals(expectedStr, actualStr);
		assertEquals(WRONG_INDEX,insert(arStr, INSERTED_STRING, 100, actualStr));
		actualStr = new String[1];
		assertEquals(WRONG_RESULT_LENGTH,insert(arStr, INSERTED_STRING, indexInsert, actualStr));
		Integer numbers[] = {1, 2, 3};
		indexInsert = 0;
		Integer actualNumbers[] = new Integer[numbers.length + 1];
		Integer expectedFirst[] = {INSERTED_NUMBER, 1, 2, 3};
		insert(numbers,INSERTED_NUMBER, indexInsert, actualNumbers );
		assertArrayEquals(expectedFirst, actualNumbers);
		indexInsert = numbers.length;
		Integer expectedLast[] = { 1, 2, 3, INSERTED_NUMBER};
		insert(numbers,INSERTED_NUMBER, indexInsert, actualNumbers );
		assertArrayEquals(expectedLast, actualNumbers);
		
		
		
		
	}

	@Test
	void testRemove() {
		fail("Not yet implemented");
	}

	@Test
	void testInsertSorted() {
		fail("Not yet implemented");
	}

	@Test
	void testAddLast() {
		fail("Not yet implemented");
	}

	@Test
	void testAddFirst() {
		fail("Not yet implemented");
	}

}
