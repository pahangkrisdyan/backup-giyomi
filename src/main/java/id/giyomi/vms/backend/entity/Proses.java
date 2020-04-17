package id.giyomi.vms.backend.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Proses extends AuditModel<User> {

    private String nama;

//    private Integer durasiShort;
//
//    private Integer durasiLong;

    @JsonIgnore
    @OneToMany( targetEntity=SpkProses.class, fetch = FetchType.EAGER )
    @JoinColumn(name = "proses_id")
    private Set<SpkProses> spkProseses = new HashSet<>();

    public Proses(String nama) {
        this.nama = nama;
//        this.durasiLong = durasiLong;
//        this.durasiShort = durasiShort;
    }

    public Proses() {
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Set<SpkProses> getSpkProseses() {
        return spkProseses;
    }

    public void setSpkProseses(Set<SpkProses> spkProseses) {
        this.spkProseses = spkProseses;
    }

//    public Integer getDurasiShort() {
//        return durasiShort;
//    }
//
//    public void setDurasiShort(Integer durasiShort) {
//        this.durasiShort = durasiShort;
//    }
//
//    public Integer getDurasiLong() {
//        return durasiLong;
//    }
//
//    public void setDurasiLong(Integer durasiLong) {
//        this.durasiLong = durasiLong;
//    }
}
