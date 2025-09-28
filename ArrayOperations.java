import java.util.Arrays;

// Kelas ArrayOperations berisi metode-metode dasar untuk bekerja dengan array
public class ArrayOperations {

    // Menampilkan seluruh isi array
    public static void traverse(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    // Linear search: mencari nilai dalam array secara berurutan (dari indeks 0 sampai akhir).
    // Jika ketemu, kembalikan indeks. Kalau tidak ketemu, kembalikan -1.
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i; // ketemu, langsung balikin indeks
        }
        return -1; // tidak ketemu
    }

    // Binary search: mencari nilai dalam array yang sudah terurut.
    // Membagi array jadi dua bagian, lalu cek ke kiri atau ke kanan sampai ketemu.
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2; // posisi tengah
            if (arr[mid] == target) return mid; // ketemu
            if (arr[mid] < target) left = mid + 1; // geser ke kanan
            else right = mid - 1; // geser ke kiri
        }
        return -1; // tidak ketemu
    }

    // Insert: masukkan nilai baru ke posisi tertentu dalam array.
    // Karena ukuran array fixed, kita buat array baru dengan ukuran +1.
    public static int[] insert(int[] arr, int index, int value) {
        int[] newArr = new int[arr.length + 1]; // array baru lebih besar 1
        System.arraycopy(arr, 0, newArr, 0, index); // salin elemen sebelum index
        newArr[index] = value; // taruh nilai baru
        System.arraycopy(arr, index, newArr, index + 1, arr.length - index); // geser elemen setelah index
        return newArr; // hasil akhir
    }

    // Delete: hapus nilai dari array berdasarkan index.
    // Kita buat array baru dengan ukuran -1.
    public static int[] delete(int[] arr, int index) {
        int[] newArr = new int[arr.length - 1]; // array baru lebih kecil 1
        System.arraycopy(arr, 0, newArr, 0, index); // salin elemen sebelum index
        System.arraycopy(arr, index + 1, newArr, index, arr.length - index - 1); // salin elemen setelah index
        return newArr; // hasil akhir
    }
}
