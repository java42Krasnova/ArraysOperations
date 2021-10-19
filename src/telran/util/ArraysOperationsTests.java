package telran.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static telran.util.ArraysOperations.*;

import java.util.Arrays;

/* V.R.
 *  All is OK. I don't see any problem
 */
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
		
		String actWrongLenght[]= new String [2];
		int indexWr=1;
		assertEquals(WRONG_RESULT_LENGTH, remove(arStr, indexWr, actWrongLenght));
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
		//element exists
		String arrStr[] = {"a","b","c","d","e","f"};
		String expectedStr []= {"a","b","c","c","d","e","f"};
		String elemExists= "c";
		int expPosition = 3;
		String actualStr1 []= new String [arrStr.length+1];
		assertEquals(OK, insertSorted(arrStr, elemExists, actualStr1));
		assertEquals(expPosition, Arrays.binarySearch(actualStr1, elemExists));
		assertArrayEquals(expectedStr, actualStr1);
		
		
		//inserting no existing element
		Integer sortArr[] = {1,2,3,5,6,7};
		Integer expectedInt[] = {1,2,3,4,5,6,7};
		Integer newElem = 4;
		int expPositionIOfNewElement = 3;
		Integer actualInt1[] = new Integer [sortArr.length+1];
		assertEquals(OK,insertSorted(sortArr, newElem, actualInt1));
		assertEquals(expPositionIOfNewElement, Arrays.binarySearch(actualInt1, newElem));
		assertArrayEquals(expectedInt, actualInt1);
		assertEquals(OK,insertSorted(sortArr, newElem, actualInt1));
		
		Integer sortArr3[] = {100,200,300,301,600,700,786,9454};
		Integer expectedInt3[] = {100,200,300,301,600,659,700,786,9454};
		Integer newElem3 = 659;
		int expPositionIOfNewElement3 = 5;
		Integer actualInt3[] = new Integer [sortArr3.length+1];
		assertEquals(OK,insertSorted(sortArr3, newElem3, actualInt3));
		assertEquals(expPositionIOfNewElement3, Arrays.binarySearch(actualInt3, newElem3));
		assertArrayEquals(expectedInt3, actualInt3);
		
		//inserting no existing element < then element in 0 position
		Integer sortArr4[] = {100,200,300,301,600,700,786,9454};
		Integer expectedInt4[] = {5,100,200,300,301,600,700,786,9454};
		Integer newElem4 = 5;
		int expPositionIOfNewElement4 = 0;
		Integer actualInt4[] = new Integer [sortArr4.length+1];
		assertEquals(OK,insertSorted(sortArr4, newElem4, actualInt4));
		assertEquals(expPositionIOfNewElement4, Arrays.binarySearch(actualInt4, newElem4));
		assertArrayEquals(expectedInt4, actualInt4);

		//inserting no existing element > then  last element 
		String arrStr2[] = {"a","b","c","d","e","f"};
		String expectedStr2 []= {"a","b","c","d","e","f","g"};
		String elemExists2= "g";
		int expPosition2 = arrStr.length;
		String actualStr2 []= new String [arrStr.length+1];
		assertEquals(OK, insertSorted(arrStr2, elemExists2, actualStr2));
		assertEquals(expPosition2, Arrays.binarySearch(actualStr2, elemExists2));
		assertArrayEquals(expectedStr2, actualStr2);
		
		String actualStr3 []= new String [1];
		assertEquals(WRONG_RESULT_LENGTH, insertSorted(arrStr2, elemExists2, actualStr3));

		
	}
	
	

	@Test
	void testAddLast() {
		String arrStr[] = {"a","b","c","d","e","f"};
		String expectedStr []= {"a","b","c","d","e","f","g"};
		String insertStr = "g";
		String actual1[] = new String [arrStr.length+1];
		assertEquals(OK,addLast(arrStr, insertStr, actual1) );
		assertArrayEquals(expectedStr, actual1);
		//wrong  length of the res array 
		String actual2[] = new String [2];
		assertEquals(WRONG_RESULT_LENGTH, addLast(arrStr, insertStr, actual2));
		
		Integer arrInt[] = {1,2,3,4};
		Integer expectedInt []= {1,2,3,4,5};
		Integer inserInt = 5;
		Integer actualInt[] = new Integer [arrInt.length+1];
		assertEquals(OK, addLast(arrInt, inserInt, actualInt));
		assertArrayEquals(expectedInt, actualInt);
		
	}

	@Test
	void testAddFirst() {
		String arrStr[] = {"b","c","d","e","f"};
		String expectedStr []= {"a","b","c","d","e","f"};
		String insertStr = "a";
		String actual1[] = new String [arrStr.length+1];
		assertEquals(OK,addFirst(arrStr, insertStr, actual1) );
		assertArrayEquals(expectedStr, actual1);
		//wrong  length of the res array 
		String actual2[] = new String [2];
		assertEquals(WRONG_RESULT_LENGTH, addFirst(arrStr, insertStr, actual2));
		
		Integer arrInt[] = {2,3,4};
		Integer expectedInt []= {1,2,3,4};
		Integer inserInt = 1;
		Integer actualInt[] = new Integer [arrInt.length+1];
		assertEquals(OK, addFirst(arrInt, inserInt, actualInt));
		assertArrayEquals(expectedInt, actualInt);
	}

}
