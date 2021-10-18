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
		String arStr[] = {"a","b","c","d","e","f","g"};
		String expectedStr []= {"a","b","c","e","f","g"};
		String actualStr [] = new String [arStr.length-1];
		int index = 3;
		assertEquals(OK, remove(arStr, index, actualStr));
		assertArrayEquals(expectedStr, actualStr);
		
		String expectedStr1 []= {"a","b","c","d","e","g"};
		String actualStr1 [] = new String [arStr.length-1];
		int index1 = 5;
		assertEquals(OK, remove(arStr, index1, actualStr1));
		assertArrayEquals(expectedStr1, actualStr1);
		
		//index<0
		String actualStr2 [] = new String [arStr.length-1];
		int index2 = -97;
		assertEquals(WRONG_INDEX, remove(arStr, index2, actualStr2));

		//index>langht
		String actualStr3 [] = new String [arStr.length-1];
		int index3 = 8;
		assertEquals(WRONG_INDEX, remove(arStr, index3, actualStr2));
		
		//remove 0 element
		Integer arrInt[]= {0,1,2,3,4,5,6};
		Integer expInt[] = {1,2,3,4,5,6};
		Integer actInt[] = new Integer [arrInt.length-1];
		int indexInt = 0;
		assertEquals(OK, remove(arrInt, indexInt, actInt));
		
		//remove last element
				
				Integer expInt1[] = {0,1,2,3,4,5};
				Integer actInt1[] = new Integer [arrInt.length-1];
				int indexIntLast = arrInt.length-1;
				assertEquals(OK, remove(arrInt, indexInt, actInt));
		
		
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
