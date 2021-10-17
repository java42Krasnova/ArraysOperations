package telran.util;



import java.util.Arrays;
import java.util.Comparator;

public class ArraysOperations {
	public static final String OK = "ok";
	public static final String WRONG_INDEX = "wrong-index";
	public static final String WRONG_RESULT_LENGTH = "wrong-result-length";
	
public static  <T> String insert(T[] array, T element, int index, T[] res) {
	if (index < 0 || index > array.length) {
		return WRONG_INDEX;
	}
	if (res.length != array.length + 1) {
		return WRONG_RESULT_LENGTH;
	}
	System.arraycopy(array, 0, res, 0, index);
	res[index] = element;
	System.arraycopy(array, index, res, index + 1, array.length - index);
	return OK;
	
}
public static <T> String remove(T[] array, int index, T[] res) {
	//TODO removes any object at the given index
	return "";
}
public static <T> String insertSorted (T[] sortedArray, T element, T[] res) {
	//TODO inserts a given any element at index to keep array sorted
	//below is the example of binarySearch call
	//How to use a result of that call - is your challenge
	Arrays.binarySearch(sortedArray, element, (Comparator<T>)Comparator.naturalOrder());
	return "";
	
}
public static <T> String addLast(T[] array, T element, T[]res) {
	//TODO adds a given element at end  of the result array
	return "";
}
public static <T> String addFirst(T[] array, T element, T[]res) {
	//TODO adds a given element at beginning  of the result array
	return "";
}

}
