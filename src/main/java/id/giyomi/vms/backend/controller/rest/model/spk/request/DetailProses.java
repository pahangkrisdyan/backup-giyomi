package id.giyomi.vms.backend.controller.rest.model.spk.request;

public class DetailProses {
    private Long prosesId;
    private Integer durasiRencana;

    public DetailProses(Long prosesId, Integer durasiRencana) {
        this.prosesId = prosesId;
        this.durasiRencana = durasiRencana;
    }

    public DetailProses() {
    }

    public Long getProsesId() {
        return prosesId;
    }

    public void setProsesId(Long prosesId) {
        this.prosesId = prosesId;
    }

    public Integer getDurasiRencana() {
        return durasiRencana;
    }

    public void setDurasiRencana(Integer durasiRencana) {
        this.durasiRencana = durasiRencana;
    }
}
