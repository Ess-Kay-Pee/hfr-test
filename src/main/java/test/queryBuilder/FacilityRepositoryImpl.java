package test.queryBuilder;

import com.abdm.hfr.entity.TFacilityInfoDtls;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class FacilityRepositoryImpl implements FacilityRepositoryCustom {
    @PersistenceContext
    EntityManager em;
//    @Override
//    public TFacilityInfoDtls findByFacilityId(Long id) {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<TFacilityInfoDtls> cq = cb.createQuery(TFacilityInfoDtls.class);
//
//        Root<TFacilityInfoDtls> facility = cq.from(TFacilityInfoDtls.class);
//        Predicate facilityPredicate = cb.equal(facility.get("facilityId"), id);
//        cq.where(facilityPredicate);
//
//        TypedQuery<TFacilityInfoDtls> query = em.createQuery(cq);
//        return query.getSingleResult();
//    }

    @Override
    public String findFirstByOrderByAlternateIdDesc() {
        log.info("Inside criteria query");
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TFacilityInfoDtls> root = cq.from(TFacilityInfoDtls.class);
        cq.select(cb.substring(root.get("alternateId"),5).as(Long.class))
                .where(cb.isNotNull(root.get("alternateId")))
                .orderBy(cb.desc(cb.substring(root.get("alternateId"),5).as(Long.class)));

        TypedQuery<Long> typedQuery = em.createQuery(cq);
        typedQuery.setMaxResults(1);

        Long result = typedQuery.getSingleResult() + 1;
        return result.toString();
//        TFacilityInfoDtls tFacilityInfoDtls = new TFacilityInfoDtls();
//        tFacilityInfoDtls.setAlternateId(result.toString());
//        return typedQuery.getSingleResult();
    }
}
