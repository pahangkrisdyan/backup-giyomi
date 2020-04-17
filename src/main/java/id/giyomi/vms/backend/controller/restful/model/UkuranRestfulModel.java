package id.giyomi.vms.backend.controller.restful.model;

import id.giyomi.vms.backend.entity.Ukuran;

public class UkuranRestfulModel{

    private Long id;
    private String nama;

    public UkuranRestfulModel() {
    }

    public UkuranRestfulModel(Ukuran ukuran) {
        this.id = ukuran.getId();
        this.nama = ukuran.getNama();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Ukuran getEntity() {
        return new Ukuran(this.nama);
    }

    public Ukuran getEntityUpdate(Ukuran source) {
        if(nama!=null)source.setNama(nama);
        return source;
    }
}
