import java.util.Scanner;

public class CafePenjualan {

    // Data penjualan (menu x hari ke-1 hingga ke-7)
    static int[][] penjualan = {
        {20, 20, 25, 20, 10, 60, 10}, // Kopi
        {30, 80, 40, 10, 15, 20, 25}, // Teh
        {5, 9, 20, 25, 10, 5, 45},    // Es Degan
        {50, 8, 17, 18, 10, 30, 6},   // Roti Bakar
        {15, 10, 16, 15, 10, 10, 55}  // Gorengan
    };

    // Nama menu
    static String[] menu = {"Kopi", "Teh", "Es Degan", "Roti Bakar", "Gorengan"};

    // a. Fungsi untuk menambahkan data penjualan
    public static void tambahPenjualan(int menuIndex, int hari, int jumlah) {
        penjualan[menuIndex][hari - 1] += jumlah;
        System.out.println("Data penjualan berhasil ditambahkan.");
    }

    // b. Fungsi untuk menampilkan seluruh data penjualan
    public static void tampilkanDataPenjualan() {
        System.out.println("Data Penjualan:");
        System.out.printf("%-12s%-8s%-8s%-8s%-8s%-8s%-8s%-8s\n", "Menu", "Hari 1", "Hari 2", "Hari 3", "Hari 4", "Hari 5", "Hari 6", "Hari 7");
        for (int i = 0; i < penjualan.length; i++) {
            System.out.printf("%-12s", menu[i]);
            for (int j = 0; j < penjualan[i].length; j++) {
                System.out.printf("%-8d", penjualan[i][j]);
            }
            System.out.println();
        }
    }

    // c. Fungsi untuk menampilkan menu dengan penjualan tertinggi
    public static void menuPenjualanTertinggi() {
        int maxPenjualan = 0;
        String menuTertinggi = "";
        for (int i = 0; i < penjualan.length; i++) {
            int totalPenjualan = 0;
            for (int j = 0; j < penjualan[i].length; j++) {
                totalPenjualan += penjualan[i][j];
            }
            if (totalPenjualan > maxPenjualan) {
                maxPenjualan = totalPenjualan;
                menuTertinggi = menu[i];
            }
        }
        System.out.println("Menu dengan penjualan tertinggi adalah " + menuTertinggi + " dengan total penjualan " + maxPenjualan);
    }

    // d. Fungsi untuk menampilkan rata-rata penjualan untuk setiap menu
    public static void rataRataPenjualan() {
        System.out.println("Rata-rata penjualan untuk setiap menu:");
        for (int i = 0; i < penjualan.length; i++) {
            int totalPenjualan = 0;
            for (int j = 0; j < penjualan[i].length; j++) {
                totalPenjualan += penjualan[i][j];
            }
            double rataRata = (double) totalPenjualan / penjualan[i].length;
            System.out.printf("%-12s: %.2f\n", menu[i], rataRata);
        }
    }

    // Main Program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Menu Program Penjualan ---");
            System.out.println("1. Tambah Data Penjualan");
            System.out.println("2. Tampilkan Seluruh Data Penjualan");
            System.out.println("3. Tampilkan Menu dengan Penjualan Tertinggi");
            System.out.println("4. Tampilkan Rata-rata Penjualan Setiap Menu");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.println("Pilih menu:");
                    for (int i = 0; i < menu.length; i++) {
                        System.out.println((i + 1) + ". " + menu[i]);
                    }
                    System.out.print("Masukkan nomor menu: ");
                    int menuIndex = scanner.nextInt() - 1;
                    System.out.print("Masukkan hari (1-7): ");
                    int hari = scanner.nextInt();
                    System.out.print("Masukkan jumlah penjualan: ");
                    int jumlah = scanner.nextInt();
                    tambahPenjualan(menuIndex, hari, jumlah);
                    break;

                case 2:
                    tampilkanDataPenjualan();
                    break;

                case 3:
                    menuPenjualanTertinggi();
                    break;

                case 4:
                    rataRataPenjualan();
                    break;

                case 5:
                    running = false;
                    System.out.println("Program selesai. Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }

        scanner.close();
    }
}
