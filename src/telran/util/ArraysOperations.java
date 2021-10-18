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
	if (index < 0 || index >= array.length ) {
		return WRONG_INDEX;
	}
	if (res.length != array.length - 1 ) {
		return WRONG_RESULT_LENGTH;
	}

	System.arraycopy(array, 0, res, 0, index);
	System.arraycopy(array, index+1, res, index, array.length-index-1);
	
	return OK;
}
public static <T> String insertSorted (T[] sortedArray, T element, T[] res) {	
	if (res.length != sortedArray.length+1) {
		return WRONG_RESULT_LENGTH;
	}
	
	int index = Arrays.binarySearch(sortedArray, element, (Comparator<T>)Comparator.naturalOrder());
	
	if (index>=0) {
		insert(sortedArray, element, index+1, res);
		return OK;
	}
	index = (-1)*(++index);
	insert(sortedArray, element, index, res);
		
	return OK;
	
}
public static <T> String addLast(T[] array, T element, T[]res) {
	if (res.length != array.length+1) {
		return WRONG_RESULT_LENGTH;
	}
	
	//res = Arrays.copyOf(array, array.length+1); * not work why???
	System.arraycopy(array, 0, res, 0, array.length);
	res[array.length] = element;
	
	return OK;
}
public static <T> String addFirst(T[] array, T element, T[]res) {
	if (res.length != array.length+1) {
		return WRONG_RESULT_LENGTH;
	}
	
	System.arraycopy(array, 0, res, 1, array.length);
	res[0]=element;
	return OK;
}

}
