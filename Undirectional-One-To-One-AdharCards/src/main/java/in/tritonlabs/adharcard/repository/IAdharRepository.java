package in.tritonlabs.adharcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.tritonlabs.adharcard.entity.Adhar;

@Repository
public interface IAdharRepository extends JpaRepository<Adhar, Long> {

}
