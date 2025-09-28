import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Comparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Data awal
        int[] arr = {10, 20, 30, 40, 50};
        ArrayList<Integer> arrList = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));

        int choice;
        do {
            System.out.println("\n=== MENU OPERASI ===");
            System.out.println("1. Tampilkan Array & ArrayList");
            System.out.println("2. Cari elemen");
            System.out.println("3. Sisipkan elemen");
            System.out.println("4. Hapus elemen");
            System.out.println("5. Bandingkan waktu pencarian (10000 elemen)");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Array: ");
                    ArrayOperations.traverse(arr);
                    System.out.print("ArrayList: ");
                    ArrayListOperations.traverse(arrList);
                    break;

                case 2:
                    System.out.print("Masukkan nilai yang dicari: ");
                    int target = sc.nextInt();

                    long start = System.nanoTime();
                    int idxArr = ArrayOperations.linearSearch(arr, target);
                    long end = System.nanoTime();
                    if (idxArr != -1) {
                        System.out.println("Array -> ditemukan di indeks " + idxArr + " | waktu " + (end - start) + " ns");
                    } else {
                        System.out.println("Array -> tidak ditemukan.");
                    }

                    start = System.nanoTime();
                    int idxList = ArrayListOperations.search(arrList, target);
                    end = System.nanoTime();
                    if (idxList != -1) {
                        System.out.println("ArrayList -> ditemukan di indeks " + idxList + " | waktu " + (end - start) + " ns");
                    } else {
                        System.out.println("ArrayList -> tidak ditemukan.");
                    }
                    break;

                case 3:
                    System.out.print("Masukkan nilai yang ingin disisipkan: ");
                    int val = sc.nextInt();
                    System.out.print("Masukkan posisi index (Array): ");
                    int pos = sc.nextInt();

                    if (pos >= 0 && pos <= arr.length) {
                        arr = ArrayOperations.insert(arr, pos, val);
                        System.out.println("Array setelah sisip: " + Arrays.toString(arr));
                    } else {
                        System.out.println("Index tidak valid untuk Array.");
                    }

                    ArrayListOperations.add(arrList, val);
                    ArrayListOperations.sort(arrList);
                    System.out.println("ArrayList setelah sisip + sort: " + arrList);
                    break;

                case 4:
                    System.out.print("Masukkan index yang ingin dihapus dari Array: ");
                    int delIdx = sc.nextInt();
                    if (delIdx >= 0 && delIdx < arr.length) {
                        arr = ArrayOperations.delete(arr, delIdx);
                        System.out.println("Array setelah hapus: " + Arrays.toString(arr));
                    } else {
                        System.out.println("Index tidak valid untuk Array.");
                    }

                    System.out.print("Masukkan nilai yang ingin dihapus dari ArrayList: ");
                    int delVal = sc.nextInt();
                    arrList.remove(Integer.valueOf(delVal));
                    System.out.println("ArrayList setelah hapus: " + arrList);
                    break;

                case 5:
                    int n = 10000;
                    int[] bigArr = new int[n];
                    ArrayList<Integer> bigList = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        bigArr[i] = i;
                        bigList.add(i);
                    }

                    long startTime = System.nanoTime();
                    ArrayOperations.linearSearch(bigArr, n - 1);
                    long endTime = System.nanoTime();
                    System.out.println("Waktu pencarian Array: " + (endTime - startTime) + " ns");

                    startTime = System.nanoTime();
                    ArrayListOperations.search(bigList, n - 1);
                    endTime = System.nanoTime();
                    System.out.println("Waktu pencarian ArrayList: " + (endTime - startTime) + " ns");
                    break;

                case 0:
                    System.out.println("Keluar program...");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (choice != 0);

        sc.close();
    }
}
