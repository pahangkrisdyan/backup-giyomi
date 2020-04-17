package id.giyomi.vms.backend.controller.restful.model;

import id.giyomi.vms.backend.entity.SatuanPanjangKain;

public class SatuanPanjangKainRestfulModel{

    private Long id;
    private String nama;

    public SatuanPanjangKainRestfulModel() {}

    public SatuanPanjangKainRestfulModel(SatuanPanjangKain satuanPanjangKain) {
        this.id = satuanPanjangKain.getId();
        this.nama = satuanPanjangKain.getNama();
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

    public SatuanPanjangKain getEntity() {
        return new SatuanPanjangKain(this.nama);
    }

    public SatuanPanjangKain getEntityUpdate(SatuanPanjangKain source) {
        if(nama!=null)source.setNama(nama);
        return source;
    }

}
