package id.giyomi.vms.backend.controller.restful.model;

import id.giyomi.vms.backend.entity.JenisKoleksi;
import id.giyomi.vms.backend.entity.Proses;

public class JenisKoleksiRestfulModel {

    private Long id;
    private String nama;

    public JenisKoleksiRestfulModel() {
    }

    public JenisKoleksiRestfulModel(JenisKoleksi jenisKoleksi) {
        this.id = jenisKoleksi.getId();
        this.nama = jenisKoleksi.getNama();
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

    public JenisKoleksi getEntity(){
        return new JenisKoleksi(this.nama);
    }

    public JenisKoleksi getEntityUpdate(JenisKoleksi source){
        if(nama!=null)source.setNama(nama);
        return source;
    }
}
