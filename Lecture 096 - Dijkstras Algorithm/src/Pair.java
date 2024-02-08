class Pair implements Comparable<Pair>
{
    int first; //node
    int second;  //weight

    Pair(int first, int second)
    {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Pair other) {
        return Integer.compare(this.first, other.first);
    }
}
