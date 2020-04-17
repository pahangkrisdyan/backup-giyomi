package id.giyomi.vms.backend.repository;

import id.giyomi.vms.backend.entity.SpkStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpkStatusRepository extends JpaRepository<SpkStatus, Long> {
}
