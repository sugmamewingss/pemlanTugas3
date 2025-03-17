package DUA.praktikumperpus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner masukan = new Scanner(System.in);
        System.out.println("====================================================");
        System.out.println("    HAI, SELAMAT DATANG DI PERPUSTAKAAN OVERLOAD");
        System.out.println("====================================================");
        while (true) {
            System.out.println();
            System.out.println("MENU");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Tampilkan Daftar Buku");
            System.out.println("3. Keluar");
            System.out.print("System: ");
            String menu = masukan.next();
            String a = null;
            switch (menu) {
                case "1":
                    System.out.println("Berapa banyak buku yang ingin ditambahkan?");
                    System.out.print("System: ");
                    int banyakbuku = masukan.nextInt();
                    masukan.nextLine();

                    Buku[] buku = new Buku[banyakbuku]; // UNTUK MEMBUAT ARRAY OBJECT DARI BERAPA BANYAK BUKU

                    try { // TRY CATCH UNTUK MEMASUKKAN DATA KE FILE
                        BufferedWriter tulis = new BufferedWriter(new FileWriter("dataBuku.txt", true));
                        // append berfungsi agar data sebelumnya tidak ditimpa ataupun dihapus
                        for (int i = 0; i < banyakbuku; i++) { // perulangan for agar sesuai dengan jumlah buku yg ingin
                                                               // ditambahkan
                            buku[i] = new Buku();
                            System.out.println("BUKU " + (i + 1));
                            System.out.print("Masukkan judul buku: ");
                            a = masukan.nextLine();
                            buku[i].setJudul(a);
                            System.out.print("Masukkan nama penulis: ");
                            String b = masukan.nextLine();
                            buku[i].setPenulis(b);
                            System.out.print("Masukkan tahun terbit buku: ");
                            String c = masukan.nextLine();
                            buku[i].setTahunTerbit(c);
                            tulis.write(buku[i].informasiBuku(a, b, c));
                        }
                        tulis.close(); // JANGAN LUPA DI CLOSE, AGAR FILE BISA DITULIS
                    } catch (IOException e) {
                        e.printStackTrace(); // mengambil error
                    }
                    break;

                case "2":
                    Buku buku1 = new Buku();
                    System.out.println("1. Tampilan Ringkas");
                    System.out.println("2. Tampilan Detail");
                    System.out.print("System: ");
                    int hmm = masukan.nextInt();
                    if (hmm == 1) {
                        if (a == null) {
                            try {
                                BufferedReader baca = new BufferedReader(new FileReader("dataBuku.txt"));
                                String line;
                                while ((line = baca.readLine()) != null) {
                                    System.out.println(line);
                                    baca.readLine(); // membaca line selanjutnya
                                    baca.readLine(); // membaca line selanjutya juga, biar langsung ke judul berikutnya
                                }
                                baca.close(); // JANGAN LUPA TUTUP CLOSE AGAR FILE TIDAK TERKUNCI
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            buku1.informasiBuku(a);
                        }
                    } else if (hmm == 2) {
                        try {
                            BufferedReader baca = new BufferedReader(new FileReader("dataBuku.txt"));
                            String line;
                            while ((line = baca.readLine()) != null) { // membaca semua data dalam file, hingga tidak
                                                                       // ada lagi data
                                System.out.println(line);
                            }
                            baca.close(); // JANGAN LUPA TUTUP CLOSE AGAR FILE TIDAK TERKUNCI
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("Maaf, opsi tidak tersedia.");
                    }
                    break;
                case "3":
                    System.out.println("TERIMAKASIH SUDAH BERKUNJUNG!");
                    return;
                default:
                    System.out.println("Maaf, opsi tidak tersedia.");
                    break;
            }
        }
    }
}
