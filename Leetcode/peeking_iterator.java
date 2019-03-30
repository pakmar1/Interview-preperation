// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> iterator;
    Integer nextValue;
	public PeekingIterator(Iterator<Integer> iterator) {
	    this.iterator = iterator;
        nextValue = iterator.next();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return nextValue;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int result = nextValue;
        if (iterator.hasNext()) {
            nextValue = iterator.next();
        } else {
            nextValue = null;
        }
        return result;
	}

	@Override
	public boolean hasNext() {
	    if (nextValue != null) {
            return true;
        }
        return false;
	}
}
