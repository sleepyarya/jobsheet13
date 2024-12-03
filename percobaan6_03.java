import java.util.Scanner;

public class percobaan6_03{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int p,l,t,L,vol;

        System.out.println("Masukkan Panjang: ");
        p = s.nextInt();
        System.out.println("Masukkan Lebar: ");
        l = s.nextInt();
        System.out.println("Masukkan Tinggi: ");
        t = s.nextInt();

        L = hitungLuas(p, l);
        System.out.println("Luas persegi panjang adalah: "+L);

        vol = hitungV(t, l, p);
        System.out.println("Volume balok adalah: " + vol);
    }

    static int hitungLuas(int pjg, int lb){
        int luas = pjg*lb;
        return luas;
    }

    static int hitungV(int tinggi, int a, int b){
        int volume = hitungLuas(a, b) * tinggi;
        return volume;
    }
}