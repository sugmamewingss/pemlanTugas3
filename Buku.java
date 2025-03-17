public class Buku {
    private String judul;
    private String penulis;
    private String tahunterbit;

    public Buku() {
        this.judul = "Tidak ada data";
        this.penulis = "Tidak ada data";
        this.tahunterbit = "Tidak ada data";
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public void setTahunTerbit(String tahunterbit) {
        this.tahunterbit = tahunterbit;
    }

    public String informasiBuku(String judul) {
        return "Judul Buku: " + judul;
    }

    public String informasiBuku(String judul, String penulis, String tahunterbit) {
        return "Judul Buku    : " + judul + "\nNama Penulis  : " + penulis
                + "\nTahun Terbit  : " + tahunterbit + "\n";
    }
}
