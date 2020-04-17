package id.giyomi.vms.backend.controller.rest.model.spk.response;

public class DetailUkuranJumlahRes {
    private String ukuran;
    private Integer jumlah;

    public DetailUkuranJumlahRes() {
    }

    public DetailUkuranJumlahRes(String ukuran, Integer jumlah) {
        this.ukuran = ukuran;
        this.jumlah = jumlah;
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }
}
