package test.controller;

import com.abdm.hfr.entity.TFacilityInfoDtls;
import com.abdm.hfr.requestDTO.TFacilityInfoDtlsRequestDTO;
import com.abdm.hprData.entity.States;
import test.repository.FacilityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    FacilityRepository facilityRepository;
    @Autowired
    ModelMapper modelMapper;
    @GetMapping("/{id}")
    public ResponseEntity<TFacilityInfoDtls> getFacility(@PathVariable String id){
        TFacilityInfoDtls tFacilityInfoDtls = facilityRepository.findByFacilityId(id);
        return ResponseEntity.ok(tFacilityInfoDtls);
    }

    @PostMapping
    public ResponseEntity<TFacilityInfoDtls> saveFacility(@RequestBody TFacilityInfoDtlsRequestDTO tFacilityInfoDtlsRequestDTO){
        TFacilityInfoDtls tFacilityInfoDtls = modelMapper.map(tFacilityInfoDtlsRequestDTO,TFacilityInfoDtls.class);//facilityRepository.save(tFacilityInfoDtlsDTO);
        String alternateId = facilityRepository.findFirstByOrderByAlternateIdDesc();
        States states = tFacilityInfoDtlsRequestDTO.getState();
        tFacilityInfoDtls.setState(states.getIsoCode());
        tFacilityInfoDtls.setAlternateId(alternateId);
        facilityRepository.save(tFacilityInfoDtls);
        return ResponseEntity.ok(tFacilityInfoDtls);
    }
}
