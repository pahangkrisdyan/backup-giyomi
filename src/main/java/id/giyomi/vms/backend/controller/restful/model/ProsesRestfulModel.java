package id.giyomi.vms.backend.controller.restful.model;

import id.giyomi.vms.backend.entity.Proses;
import id.giyomi.vms.backend.entity.Proses;

public class ProsesRestfulModel{

    private Long id;
    private String nama;

    public ProsesRestfulModel() {
    }

    public ProsesRestfulModel(Proses vendor) {
        this.id = vendor.getId();
        this.nama = vendor.getNama();
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

    public Proses getEntity(){
        return new Proses(this.nama);
    }

    public Proses getEntityUpdate(Proses source){
        if(nama!=null)source.setNama(nama);
        return source;
    }
}
