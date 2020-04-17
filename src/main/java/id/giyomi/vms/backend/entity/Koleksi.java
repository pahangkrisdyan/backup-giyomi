package id.giyomi.vms.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Koleksi extends AuditModel<User> {

    private String nama;

    private String fotoDownloadUrl;

    @ManyToOne
    private JenisKoleksi jenisKoleksi;

    @JsonIgnore
    @OneToMany( targetEntity= Varian.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "koleksi_id")
    private Set<Varian> varians = new HashSet<>();

    public Koleksi(String nama, String fotoDownloadUrl,  JenisKoleksi jenisKoleksi) {
        this.nama = nama;
        this.jenisKoleksi = jenisKoleksi;
        this.fotoDownloadUrl = fotoDownloadUrl;
    }

    public Koleksi() {
    }

    public Set<Varian> getVarians() {
        return varians;
    }

    public void setVarians(Set<Varian> varians) {
        this.varians = varians;
    }

    public JenisKoleksi getJenisKoleksi() {
        return jenisKoleksi;
    }

    public void setJenisKoleksi(JenisKoleksi jenisKoleksi) {
        this.jenisKoleksi = jenisKoleksi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getFotoDownloadUrl() {
        return fotoDownloadUrl;
    }

    public void setFotoDownloadUrl(String fotoDownloadUrl) {
        this.fotoDownloadUrl = fotoDownloadUrl;
    }
}
