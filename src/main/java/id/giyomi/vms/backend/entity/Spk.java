package id.giyomi.vms.backend.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Spk extends AuditModel<User> {

    @ManyToOne
    private Vendor vendor;

    @JsonIgnore
    @OneToMany(
            targetEntity= SpkStatus.class,
            fetch = FetchType.EAGER ,
            cascade = {
                CascadeType.ALL
            }
    )
    @JoinColumn(name = "spk_id")
    private Set<SpkStatus> spkStatuses = new HashSet<>();

    @JsonIgnore
    @OneToMany(
            targetEntity=SpkProses.class,
            fetch = FetchType.EAGER,
            cascade = {
                CascadeType.ALL
            }
    )
    @JoinColumn(name = "spk_id")
    private Set<SpkProses> spkProseses = new HashSet<>();

    @JsonIgnore
    @OneToMany(
            targetEntity= SpkVarian.class,
            fetch = FetchType.EAGER,
            cascade = {
                CascadeType.ALL
            }
    )
    @JoinColumn(name = "spk_id")
    private Set<SpkVarian> spkVarians = new HashSet<>();

    public Spk() {
    }

    public Spk(Vendor vendor) {
        this.vendor = vendor;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Set<SpkStatus> getSpkStatuses() {
        return spkStatuses;
    }

    public void setSpkStatuses(Set<SpkStatus> spkStatuses) {
        this.spkStatuses = spkStatuses;
    }

    public Set<SpkProses> getSpkProseses() {
        return spkProseses;
    }

    public void setSpkProseses(Set<SpkProses> spkproseses) {
        this.spkProseses = spkproseses;
    }

    public Set<SpkVarian> getSpkVarians() {
        return spkVarians;
    }

    public void setSpkVarians(Set<SpkVarian> spkVarians) {
        this.spkVarians = spkVarians;
    }
}
