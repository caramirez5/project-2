/**
 * 
 */

/**
 * @author 15715
 *
 */
public class ArrayList<T> {

	T[] arr;
	int size;

	private class ListIterator<T> {

		private int nextItem;

		public ListIterator() {
			nextItem = 0;
		}

		public boolean hasNext() {
			if (nextItem < size)
				return true;
			return false;
		}

		public T next() {
			return (T) arr[nextItem++];
		}
	}

	public ArrayList() {
		size = 0;
		arr = (T[]) new Object[10];
	}

	public ListIterator<T> iterator() {
		return new ListIterator<T>();
	}

	public void growArray() {
		T[] newarr = (T[]) new Object[arr.length*2];
		for (int i = 0; i < arr.length; i++)
			newarr[i] = arr[i];
		arr = newarr;
	}

	public void add(T item) {
		if (size == arr.length)
			growArray();
		arr[size++] = item;
	}

	public T get(int pos) throws Exception {
		if (pos < 0 || pos > size-1)
			throw new Exception("List index out of bounds");
		else return arr[pos];
	}

	public T remove(int pos) {
		if (pos < 0 || pos > size - 1)
			throw new IndexOutOfBoundsException("Index out of bounds.");
		T item = arr[pos];
		for (int i = pos; i < size-1; i++)
			arr[i] = arr[i+1];
		--size;
		return item;
	}

	public int size() {
		return size;
	}

	public boolean contains(String s) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(s))
				return true;
		}
		return false;
	}

	public void clear() {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = null;
			size--;
		}
	}
}
