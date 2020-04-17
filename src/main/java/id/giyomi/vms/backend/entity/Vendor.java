package id.giyomi.vms.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

@Entity
public class Vendor extends AuditModel<User> {

    private String alamat;

    private String email;

    private String nama;

    private Double skor;

    private String telepon;

    @JsonIgnore
    @OneToMany( targetEntity=Spk.class, fetch = FetchType.EAGER )
    @JoinColumn(name = "vendor_id")
    private Set<Spk> spks = new HashSet<>();

    public Vendor() {
    }

    public Vendor(String alamat, String email, String nama, String telepon) {
        this.alamat = alamat;
        this.email = email;
        this.nama = nama;
        this.telepon = telepon;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Double getSkor() {
        return skor;
    }

    public void setSkor(Double skor) {
        this.skor = skor;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public Set<Spk> getSpks() {
        return spks;
    }

    public void setSpks(Set<Spk> spks) {
        this.spks = spks;
    }
}
