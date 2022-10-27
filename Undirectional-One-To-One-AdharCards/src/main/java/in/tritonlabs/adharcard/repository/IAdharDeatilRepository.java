package in.tritonlabs.adharcard.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.tritonlabs.adharcard.entity.AdharDetail;

@Repository
public interface IAdharDeatilRepository extends JpaRepository<AdharDetail, Long> {

	
	@Query(value="select *from adhardetail where adhar_id_fkey=:id",nativeQuery = true)
	public Optional<AdharDetail> getOne(long id);
}
