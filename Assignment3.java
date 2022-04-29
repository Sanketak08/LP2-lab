import java.util.Scanner;

public class Assignment3 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n******** MENU ********");
            System.out.println("1.Selection Sort\n2.Exit\n");
            System.out.print("Enter choice: ");
            choice=sc.nextInt();

            if(choice==1){
                System.out.print("Enter size of Array: ");
                int n=sc.nextInt();
                int[] arr=new int[n];
        
                for (int i = 0; i < n; i++) {
                    System.out.print("Enter element "+(i+1)+": ");
                    arr[i]=sc.nextInt();
                }

                selectionSort(arr,arr.length, 0, 0);
                
                System.out.println("After sorting");
                for (int i : arr) {
                    System.out.print(i+" ");
                }
                System.out.println();
            }else if(choice==2){
                System.exit(0);
            }
        } while (choice!=2);


        sc.close();
    }

    static void selectionSort(int[] arr,int row,int col, int max){
        if(row==0){
            return;
        }

        if(col<row){
            if(arr[col] > arr[max]){
                selectionSort(arr, row, col+1, col);
            }else{
                selectionSort(arr, row, col+1, max);
            }
        }else{
            int temp = arr[max];
            arr[max] = arr[row - 1];
            arr[row - 1] = temp;
            selectionSort(arr, row - 1, 0, 0);
        }         
    }
}
