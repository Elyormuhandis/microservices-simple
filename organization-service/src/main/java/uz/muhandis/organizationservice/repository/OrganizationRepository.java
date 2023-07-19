package uz.muhandis.organizationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.muhandis.organizationservice.entity.Organization;

import java.util.Optional;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    Optional<Organization> findByOrganizationCode(String organizationCode);
}
