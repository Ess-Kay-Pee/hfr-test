package test.repository;

import com.abdm.hfr.entity.TFacilityInfoDtls;
import test.queryBuilder.FacilityRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

//@Repository
public interface FacilityRepository extends JpaRepository<TFacilityInfoDtls, String>, FacilityRepositoryCustom, JpaSpecificationExecutor<TFacilityInfoDtls> {
//    @Query(value = "SELECT * FROM t_facility_info_dtls WHERE fac_unique_id = :id", nativeQuery = true)
    TFacilityInfoDtls findByFacilityId(/*@Param("id")*/ String id);
}
