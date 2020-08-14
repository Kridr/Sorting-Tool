import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();

        if (size == 0) {
            System.out.println(0);
        } else {
            int[] mas = new int[size];

            for (int i = 0; i < size; i++) {
                mas[i] = scanner.nextInt();
            }

            System.out.println(mergeSort(mas, 0, size));
        }
    }

    public static long mergeSort(int[] array, int leftIncl, int rightExcl) {
        if (rightExcl == leftIncl + 1) {
            return 0;
        }

        int middle = leftIncl + (rightExcl - leftIncl) / 2;


        long lC = mergeSort(array, leftIncl, middle);
        long rC = mergeSort(array, middle, rightExcl);

        long c = merge(array, leftIncl, middle, rightExcl);

        return lC + rC + c;
    }

    private static long merge(int[] array, int left, int middle, int right) {
        int i = left;
        int j = middle;
        int k = 0;
        long count = 0;

        int[] temp = new int[right - left];

        while (i < middle && j < right) {
            if (array[i] <= array[j]) {
                temp[k] = array[i];
                i++;
            } else {
                temp[k] = array[j];
                j++;
                count += middle - i;
            }
            k++;
        }

        for (; i < middle; i++, k++) {
            temp[k] = array[i];
        }

        for (; j < right; j++, k++) {
            temp[k] = array[j];
        }

        System.arraycopy(temp, 0, array, left, temp.length);

        return count;
    }
}