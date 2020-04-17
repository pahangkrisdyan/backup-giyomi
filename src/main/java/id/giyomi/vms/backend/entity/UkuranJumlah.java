package id.giyomi.vms.backend.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class UkuranJumlah extends AuditModel<User> {

    @ManyToOne
    private SpkVarian spkVarian;

    @ManyToOne
    private Ukuran ukuran;

    private Integer jumlah;

    public UkuranJumlah() {
    }

    public UkuranJumlah(SpkVarian spkVarian, Ukuran ukuran, Integer jumlah) {
        this.spkVarian = spkVarian;
        this.ukuran = ukuran;
        this.jumlah = jumlah;
    }

    public SpkVarian getSpkVarian() {
        return spkVarian;
    }

    public void setSpkVarian(SpkVarian spkVarian) {
        this.spkVarian = spkVarian;
    }

    public Ukuran getUkuran() {
        return ukuran;
    }

    public void setUkuran(Ukuran ukuran) {
        this.ukuran = ukuran;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }
}
