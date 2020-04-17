package id.giyomi.vms.backend.repository;

import id.giyomi.vms.backend.entity.Role;
import id.giyomi.vms.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    List<User> findAllByRoleOrderByCreatedAt(Role role);

}
