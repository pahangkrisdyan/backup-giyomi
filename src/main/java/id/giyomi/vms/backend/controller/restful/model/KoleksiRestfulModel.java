package id.giyomi.vms.backend.controller.restful.model;

import id.giyomi.vms.backend.entity.JenisKoleksi;
import id.giyomi.vms.backend.entity.Koleksi;
import id.giyomi.vms.backend.entity.Varian;
import id.giyomi.vms.backend.repository.JenisKoleksiRepository;
import id.giyomi.vms.backend.repository.KoleksiRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import javax.persistence.ManyToOne;

public class KoleksiRestfulModel {
    private Long id;
    private String nama;
    private String fotoDownloadUrl;
    private Long jenisKoleksiId;

    public KoleksiRestfulModel() {}

    public KoleksiRestfulModel(Koleksi koleksi) {
        this.id = koleksi.getId();
        this.nama = koleksi.getNama();
        this.fotoDownloadUrl = koleksi.getFotoDownloadUrl();
        this.jenisKoleksiId = koleksi.getJenisKoleksi().getId();
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

    public String getFotoDownloadUrl() {
        return fotoDownloadUrl;
    }

    public void setFotoDownloadUrl(String fotoDownloadUrl) {
        this.fotoDownloadUrl = fotoDownloadUrl;
    }

    public Long getJenisKoleksiId() {
        return jenisKoleksiId;
    }

    public void setJenisKoleksiId(Long jenisKoleksiId) {
        this.jenisKoleksiId = jenisKoleksiId;
    }

    public Koleksi getEntity(JenisKoleksiRepository jenisKoleksiRepository) {
        JenisKoleksi jenisKoleksi = jenisKoleksiRepository
                .findById(jenisKoleksiId)
                .orElseThrow(()-> new ResourceNotFoundException("Not found koleksijenisid with id " + jenisKoleksiId));
        return new Koleksi(nama, fotoDownloadUrl, jenisKoleksi);
    }

    public Koleksi getEntityUpdate(Koleksi source, JenisKoleksiRepository jenisKoleksiRepository) {
        if(jenisKoleksiId!=null){
            JenisKoleksi jenisKoleksi = jenisKoleksiRepository
                    .findById(jenisKoleksiId)
                    .orElseThrow(()-> new ResourceNotFoundException("Not found koleksijenisid with id " + jenisKoleksiId));
            source.setJenisKoleksi(jenisKoleksi);
        }
        if(nama!=null) source.setNama(nama);
        if(fotoDownloadUrl!=null) source.setFotoDownloadUrl(fotoDownloadUrl);
        return source;
    }

}
