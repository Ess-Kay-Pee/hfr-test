package test.queryBuilder;

public interface FacilityRepositoryCustom {
//    TFacilityInfoDtls findByFacilityId(Long id);

    String findFirstByOrderByAlternateIdDesc();
}
