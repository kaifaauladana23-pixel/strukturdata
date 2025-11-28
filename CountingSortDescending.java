public class CountingSortDescending {

    public static void countingSort(int[] arr){
        int max = arr[0];
        int min = arr[0];

        for(int value : arr){
            if (value > max) max = value;
            if (value < min) min = value;
        }

        int range = max - min + 1;
        int [] count = new int [range];
        int [] output = new int [arr.length];

        for (int value : arr){
            count[value - min]++;
        }

        for (int i = range - 2; i >= 0; i--){
            count[i] += count[i + 1];
        }

        for (int value : arr){
            output[count[value - min] - 1] = value;
            count [value - min]--;
        
        }

        System.arraycopy(output, 0, arr, 0, arr.length);
    }
    public static void main (String[] args){
        int [] data = {41, 19,62, 23, 89, 5, 35, 102};

        System.out.println("Sebelum diurutkan: ");
        for (int x : data) System.out.print(x + " ");

        countingSort(data);

        System.out.println("\nSetelah diurutkan (Descending - Counting Sort): ");
        for (int x : data) System.out.print(x + " ");
    }
    
}
