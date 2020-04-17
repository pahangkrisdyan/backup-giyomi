package id.giyomi.vms.backend.controller.restful.model;

import id.giyomi.vms.backend.entity.AuditModel;
import id.giyomi.vms.backend.entity.User;
import id.giyomi.vms.backend.entity.Vendor;

public class VendorRestfulModel{

    private Long id;
    private String alamat;
    private String email;
    private String nama;
    private Double skor;
    private String telepon;

    public VendorRestfulModel() {
    }

    public VendorRestfulModel(Vendor vendor) {
        this.id = vendor.getId();
        this.alamat = vendor.getAlamat();
        this.email = vendor.getEmail();
        this.nama = vendor.getNama();
        this.skor = vendor.getSkor();
        this.telepon = vendor.getTelepon();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Vendor getEntity(){
        return new Vendor(this.alamat, this.email, this.nama, this.telepon);
    }

    public Vendor getEntityUpdate(Vendor source){
        if(alamat!=null)source.setAlamat(alamat);
        if(email!=null)source.setEmail(email);
        if(nama!=null)source.setNama(nama);
        if(skor!=null)source.setSkor(skor);
        if(telepon!=null)source.setTelepon(telepon);
        return source;
    }
}
