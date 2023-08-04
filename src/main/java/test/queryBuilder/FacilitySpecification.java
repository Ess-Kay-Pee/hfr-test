package test.queryBuilder;

import com.abdm.hfr.entity.TFacilityInfoDtls;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class FacilitySpecification implements Specification<TFacilityInfoDtls> {
    private String facilityId;

    public FacilitySpecification(String facilityId) {
        this.facilityId = facilityId;
    }

    @Override
    public Predicate toPredicate(Root<TFacilityInfoDtls> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        System.out.println("Value - "+root.get("facilityId"));
        return criteriaBuilder.equal(root.get("facilityId"), facilityId);
    }
}
