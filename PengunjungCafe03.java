public class PengunjungCafe03 {

    public static void daftarPengunjung(String... namaPengunjung) {
        System.out.println("Daftar Nama pengunjung: ");
        for (String nama : namaPengunjung) {
            System.out.println("- " + nama);
        }
    }

    public static void main(String[] args) {
        daftarPengunjung("ali", "budi", "citra", "rachel");
    }
}