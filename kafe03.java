public class kafe03 {

    public static void Menu(String namaPel, boolean isMember, String kodePromo) {
        System.out.println("Selamat datang, " + namaPel + "!");

        // Informasi jika pelanggan adalah member
        if (isMember) {
            System.out.println("Anda adalah member, dapatkan diskon 10% untuk setiap pembelian.");
        }

        // Tampilkan menu
        System.out.println("==== MENU RESTO KAFE ====");
        System.out.println("1. Kopi Hitam - Rp 15,000");
        System.out.println("2. Cappuccino - Rp 20,000");
        System.out.println("3. Latte - Rp 22,000");
        System.out.println("4. Teh Tarik - Rp 12,000");
        System.out.println("5. Roti Bakar - Rp 10,000");
        System.out.println("6. Mie Goreng - Rp 18,000");
        System.out.println("=========================");

        // Tampilkan diskon berdasarkan kode promo
        if (kodePromo.equalsIgnoreCase("DISKON50")) {
            System.out.println("Selamat! " + namaPel + " Anda mendapatkan diskon 50% untuk setiap pembelian.");
        } else if (kodePromo.equalsIgnoreCase("DISKON30")) {
            System.out.println("Selamat! " + namaPel + " Anda mendapatkan diskon 30% untuk setiap pembelian.");
        } else if (!kodePromo.isEmpty()) {
            System.out.println("Kode promo tidak valid!");
        }

    }

    public static void main(String[] args) {
        // Pemanggilan fungsi Menu dengan parameter
        Menu("Jake", true, "diskon50");
        // Panggil fungsi Menu
    }
}
