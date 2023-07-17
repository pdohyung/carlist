package carlist.carlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import carlist.carlist.domain.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
