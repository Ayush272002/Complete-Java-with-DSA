class OptimalSolutionUsingCatalanNumbers {
    public int numTrees(int n) {
        long catalanNumber = 1;
        for (int i = 0; i < n; i++) {
            catalanNumber = catalanNumber * 2 * (2L * i + 1) / (i + 2);
        }
        return (int) catalanNumber;
    }
}
