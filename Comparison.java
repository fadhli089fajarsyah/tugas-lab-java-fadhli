import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// Kelas utama yang isinya menu interaktif buat ngetes Array dan ArrayList
public class Comparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Data awal, kita punya array biasa dan juga ArrayList
        int[] arr = {10, 20, 30, 40, 50};
        ArrayList<Integer> arrList = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));

        int choice; // ini buat nyimpan pilihan menu dari user
        do {
            // Tampilan menu setiap kali loop
            System.out.println("\n=== MENU OPERASI ===");
            System.out.println("1. Tampilkan Array & ArrayList");
            System.out.println("2. Cari angka");
            System.out.println("3. Tambahkan angka");
            System.out.println("4. Hapus angka");
            System.out.println("5. Bandingkan waktu pencarian (10000 elemen)");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // Menampilkan isi array dan arraylist
                    System.out.print("Array: ");
                    ArrayOperations.traverse(arr);
                    System.out.print("ArrayList: ");
                    ArrayListOperations.traverse(arrList);
                    break;

                case 2:
                    // Cari angka di Array dan ArrayList
                    System.out.print("Masukkan angka yang mau dicari: ");
                    int target = sc.nextInt();

                    // Cari di array (pakai linear search manual)
                    long start = System.nanoTime();
                    int idxArr = ArrayOperations.linearSearch(arr, target);
                    long end = System.nanoTime();
                    if (idxArr != -1) {
                        System.out.println("Array -> ketemu di index " + idxArr + " | waktu " + (end - start) + " ns");
                    } else {
                        System.out.println("Array -> angka tidak ada.");
                    }

                    // Cari di ArrayList (pakai method search di ArrayListOperations)
                    start = System.nanoTime();
                    int idxList = ArrayListOperations.search(arrList, target);
                    end = System.nanoTime();
                    if (idxList != -1) {
                        System.out.println("ArrayList -> ketemu di index " + idxList + " | waktu " + (end - start) + " ns");
                    } else {
                        System.out.println("ArrayList -> angka tidak ada.");
                    }
                    break;

                case 3:
                    // Tambah angka baru
                    System.out.print("Masukkan angka baru: ");
                    int val = sc.nextInt();
                    System.out.print("Masukkan posisi index (Array): ");
                    int pos = sc.nextInt();

                    // Karena array itu ukurannya tetap, kita bikin array baru kalau mau nambahin
                    if (pos >= 0 && pos <= arr.length) {
                        arr = ArrayOperations.insert(arr, pos, val);
                        System.out.println("Array setelah ditambah: " + Arrays.toString(arr));
                    } else {
                        System.out.println("Index tidak valid untuk Array.");
                    }

                    // Kalau ArrayList tinggal add aja, terus biar rapih kita sort
                    ArrayListOperations.add(arrList, val);
                    ArrayListOperations.sort(arrList);
                    System.out.println("ArrayList setelah ditambah + diurutkan: " + arrList);
                    break;

                case 4:
                    // Hapus angka dari array (berdasarkan index)
                    System.out.print("Masukkan index yang mau dihapus dari Array: ");
                    int delIdx = sc.nextInt();
                    if (delIdx >= 0 && delIdx < arr.length) {
                        arr = ArrayOperations.delete(arr, delIdx);
                        System.out.println("Array setelah dihapus: " + Arrays.toString(arr));
                    } else {
                        System.out.println("Index tidak valid untuk Array.");
                    }

                    // Hapus angka dari ArrayList (berdasarkan nilai)
                    System.out.print("Masukkan angka yang mau dihapus dari ArrayList: ");
                    int delVal = sc.nextInt();
                    arrList.remove(Integer.valueOf(delVal));
                    System.out.println("ArrayList setelah dihapus: " + arrList);
                    break;

                case 5:
                    // Tes performa cari di Array vs ArrayList kalau isinya banyak (10000 elemen)
                    int n = 10000;
                    int[] bigArr = new int[n];
                    ArrayList<Integer> bigList = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        bigArr[i] = i;
                        bigList.add(i);
                    }

                    // Cari elemen terakhir di array
                    long startTime = System.nanoTime();
                    ArrayOperations.linearSearch(bigArr, n - 1);
                    long endTime = System.nanoTime();
                    System.out.println("Waktu cari di Array: " + (endTime - startTime) + " ns");

                    // Cari elemen terakhir di ArrayList
                    startTime = System.nanoTime();
                    ArrayListOperations.search(bigList, n - 1);
                    endTime = System.nanoTime();
                    System.out.println("Waktu cari di ArrayList: " + (endTime - startTime) + " ns");
                    break;

                case 0:
                    // Keluar program
                    System.out.println("Keluar program...");
                    break;

                default:
                    // Kalau input menu gak ada
                    System.out.println("Pilihan tidak valid!");
            }

        } while (choice != 0); // ulang terus sampai pilih keluar

        sc.close(); // nutup scanner biar gak bocor resource
    }
}
