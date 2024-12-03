import java.util.Scanner;

public class hitungTotalHarga {

    public static double hitungTotalHarga(int pilihanMenu, int banyakItem, String kodePromo) {
        int[] hargaItems = { 15000, 20000, 12000, 18000 };

        // Hitung total harga awal
        double hargaTotal = hargaItems[pilihanMenu - 1] * banyakItem;

        // Cek kode promo dan terapkan diskon jika berlaku
        if (kodePromo.equalsIgnoreCase("DISKON50")) {
            hargaTotal *= 0.5; // Diskon 50%
            System.out.println("Berikan diskon 50%");
        } else if (kodePromo.equalsIgnoreCase("DISKON30")) {
            hargaTotal *= 0.7; // Diskon 30%
            System.out.println("Berikan diskon 30%");
        } else if (!kodePromo.isEmpty()) {
            System.out.println("Kode promo tidak valid! Tidak ada diskon yang diterapkan.");
        }

        return hargaTotal;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double totalKeseluruhan = 0;

        while (true) {
            // Input nomor menu
            System.out.print("\nMasukkan nomor menu yang ingin Anda pesan (1-4) atau 0 untuk selesai: ");
            int pilihanMenu = s.nextInt();

            // Jika pengguna memasukkan 0, keluar dari loop
            if (pilihanMenu == 0) {
                break;
            }

            // Validasi input menu
            if (pilihanMenu < 1 || pilihanMenu > 4) {
                System.out.println("Pilihan menu tidak valid! Silakan coba lagi.");
                continue;
            }

            // Input jumlah item
            System.out.print("Masukkan jumlah item yang ingin dipesan: ");
            int banyakItem = s.nextInt();

            // Input kode promo
            s.nextLine(); // Konsumsi newline setelah nextInt()
            System.out.print("Masukkan kode promo (jika ada): ");
            String kodePromo = s.nextLine();

            // Hitung total harga setelah diskon untuk pesanan ini
            double hargaSetDis = hitungTotalHarga(pilihanMenu, banyakItem, kodePromo);

            // Menambahkan ke total keseluruhan
            totalKeseluruhan += hargaSetDis;

            // Menampilkan harga untuk pesanan ini
            System.out.println("Harga setelah diskon untuk pesanan ini: Rp" + hargaSetDis);
        }

        // Menampilkan total keseluruhan pesanan
        System.out.println("\nTotal keseluruhan pesanan: Rp" + totalKeseluruhan);

        s.close(); // Menutup scanner
    }
}