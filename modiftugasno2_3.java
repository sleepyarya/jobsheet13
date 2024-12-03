import java.util.Scanner;

public class modiftugasno2_3 {

    // Variabel global
    static int[][] penjualan; // Array untuk menyimpan data penjualan
    static String[] menu;     // Array untuk menyimpan nama menu

    // Fungsi untuk inisialisasi data berdasarkan input user
    public static void inisialisasiData() {
        Scanner scanner = new Scanner(System.in);

        // Input jumlah menu
        System.out.print("Masukkan jumlah menu: ");
        int jumlahMenu = scanner.nextInt();
        menu = new String[jumlahMenu];

        // Input nama menu
        System.out.println("Masukkan nama menu:");
        for (int i = 0; i < jumlahMenu; i++) {
            System.out.print("Menu ke-" + (i + 1) + ": ");
            menu[i] = scanner.next();
        }

        // Input jumlah hari (jumlah tugas untuk mahasiswa)
        System.out.print("Masukkan jumlah hari: ");
        int jumlahHari = scanner.nextInt();
        penjualan = new int[jumlahMenu][jumlahHari];

        // Input data penjualan awal
        System.out.println("Masukkan data penjualan untuk masing-masing menu:");
        for (int i = 0; i < jumlahMenu; i++) {
            System.out.println("Penjualan untuk menu " + menu[i] + ":");
            for (int j = 0; j < jumlahHari; j++) {
                System.out.print("Hari ke-" + (j + 1) + ": ");
                penjualan[i][j] = scanner.nextInt();
            }
        }
    }

    // a. Fungsi untuk menambahkan data penjualan
    public static void tambahPenjualan(int menuIndex, int hari, int jumlah) {
        penjualan[menuIndex][hari - 1] += jumlah;
        System.out.println("Data penjualan berhasil ditambahkan.");
    }

    // b. Fungsi untuk menampilkan seluruh data penjualan
    public static void tampilkanDataPenjualan() {
        System.out.println("\nData Penjualan:");
        System.out.printf("%-12s", "Menu");
        for (int j = 0; j < penjualan[0].length; j++) {
            System.out.printf("Hari %-8d", j + 1);
        }
        System.out.println();

        for (int i = 0; i < penjualan.length; i++) {
            System.out.printf("%-12s", menu[i]);
            for (int j = 0; j < penjualan[i].length; j++) {
                System.out.printf("%-12d", penjualan[i][j]);
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
        System.out.println("\nRata-rata penjualan untuk setiap menu:");
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

        // Inisialisasi data
        System.out.println("=== Inisialisasi Data Penjualan ===");
        inisialisasiData();

        // Program interaktif
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
                    System.out.print("Masukkan hari (1-" + penjualan[0].length + "): ");
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
