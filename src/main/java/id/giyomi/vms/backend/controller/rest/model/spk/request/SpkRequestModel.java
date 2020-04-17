package id.giyomi.vms.backend.controller.rest.model.spk.request;

import java.util.ArrayList;

public class SpkRequestModel {
    private Long vendorId;
    private ArrayList<DetailVarianReq> varians;
    private ArrayList<DetailProses> proseses;
    private String fotoDownloadUrl;

    public SpkRequestModel() {
    }

    public SpkRequestModel(Long vendorId, ArrayList<DetailVarianReq> varians, ArrayList<DetailProses> proseses, String fotoDownloadUrl) {
        this.vendorId = vendorId;
        this.varians = varians;
        this.proseses = proseses;
        this.fotoDownloadUrl = fotoDownloadUrl;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public ArrayList<DetailVarianReq> getVarians() {
        return varians;
    }

    public void setVarians(ArrayList<DetailVarianReq> varians) {
        this.varians = varians;
    }

    public ArrayList<DetailProses> getProseses() {
        return proseses;
    }

    public void setProseses(ArrayList<DetailProses> proseses) {
        this.proseses = proseses;
    }

    public String getFotoDownloadUrl() {
        return fotoDownloadUrl;
    }

    public void setFotoDownloadUrl(String fotoDownloadUrl) {
        this.fotoDownloadUrl = fotoDownloadUrl;
    }
}
