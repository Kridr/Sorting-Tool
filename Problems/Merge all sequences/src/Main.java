import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] arrayOfArrays = new int[n][];
        for (int i = 0; i < n; i++) {
            int size = scanner.nextInt();

            int[] array = new int[size];

            for (int j = 0; j < size; j++) {
                array[j] = scanner.nextInt();
            }

            arrayOfArrays[i] = array;
        }

        scanner.close();


        int[] merge = fullMerge(arrayOfArrays);

        for (var elem : merge) {
            System.out.print(elem + " ");
        }
    }

    public static int[] fullMerge(int[][] arrayOfArrays) {
        if (arrayOfArrays.length == 0) {
            return new int[0];
        } else if (arrayOfArrays.length == 1) {
            return arrayOfArrays[0];
        } else {
            int[] partialMerge = merge(arrayOfArrays[0], arrayOfArrays[1]);

            for (int i = 2; i < arrayOfArrays.length; i++) {
                partialMerge = merge(partialMerge, arrayOfArrays[i]);
            }

            return partialMerge;
        }
    }

    public static int[] merge(int[] array1, int[] array2) {
        int i = 0;
        int j = 0;
        int k = 0;

        int[] answer = new int[array1.length + array2.length];

        while (i < array1.length && j < array2.length) {
            if (array1[i] >= array2[j]) {
                answer[k] = array1[i];
                i++;
            } else {
                answer[k] = array2[j];
                j++;
            }
            k++;
        }

        for (; i < array1.length; i++, k++) {
            answer[k] = array1[i];
        }

        for (; j < array2.length; j++, k++) {
            answer[k] = array2[j];
        }

        return answer;
    }
}