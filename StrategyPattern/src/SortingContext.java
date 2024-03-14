public class SortingContext {

    private SortingAlgorithms sortingAlgorithms;

    public SortingContext(SortingAlgorithms sortingAlgorithms){
        this.sortingAlgorithms = sortingAlgorithms;
    }

    public void setSortingAlgorithms(SortingAlgorithms sortingAlgorithms){
        this.sortingAlgorithms = sortingAlgorithms;
    }

    public void sort(int[] arr){
        sortingAlgorithms.sort(arr);
    }
}
