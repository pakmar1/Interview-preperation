Queue<Iterator<Integer>> queue = new LinkedList<>();
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        if (v1.iterator().hasNext()) {
            queue.offer(v1.iterator());
        }
        if (v2.iterator().hasNext()) {
            queue.offer(v2.iterator());
        }
    }

    public int next() {
        Iterator<Integer> iterator = queue.poll();
        int res = iterator.next();
        if (iterator.hasNext()) {
            queue.offer(iterator);
        }
        return res;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
