interface SortAlgorithm {
    public void sort(int[] array);
}

class BubbleSort implements SortAlgorithm {

    @Override
    public void sort(int[] array) {
        System.out.println("Bubble Sort done!");
    }
}

class QuickSort implements SortAlgorithm {

    @Override
    public void sort(int[] array) {
        System.out.println("Quick Sort done!");
    }

}

class Service {
    private SortAlgorithm sortAlgorithm;

    public Service(SortAlgorithm sort) {
        sortAlgorithm = sort;
    }

    public requireSort(int[] array) {
            sortAlgorithm.sort(array);
    }
}

public class LooseCoupling {
    public static void main(String[] args) {
        SortAlgorithm bubbleSort = new BubbleSort();
        SortAlgorithm quickSort = new QuickSort();
        Service service1 = new Service(bubbleSort);
        Service service2 = new Service(quickSort);
    }
}
