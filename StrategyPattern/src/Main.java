import java.util.Random;

public class Main {
    public static void main(String[] args){

        ArrayGenerator arrayGenerator = new ArrayGenerator();
        SortingContext sorting = new SortingContext();

        for (int i=1; i<=3; i++){
            switch (i){
                case 1:
                    sorting.setSortingAlgorithms(new HeapSort());
                    break;
                case 2:
                    sorting.setSortingAlgorithms(new SelectionSort());
                    break;
                case 3:
                    sorting.setSortingAlgorithms(new InsertionSort());
                    break;
                default:
                    break;
            }
            System.out.println("Array size 30 elements:");
            sorting.algorithmSorting(arrayGenerator.getArr30(), new Timer());
            System.out.println("Array size 100k elements:");
            sorting.algorithmSorting(arrayGenerator.getArr100k(), new Timer());
        }










    }
}
