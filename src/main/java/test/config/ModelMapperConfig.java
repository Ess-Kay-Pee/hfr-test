package test.config;

import com.abdm.hfr.entity.TFacilityInfoDtls;
import com.abdm.hfr.requestDTO.TFacilityInfoDtlsRequestDTO;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper getModelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setPropertyCondition(Conditions.isNotNull())
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.addMappings(new PropertyMap<TFacilityInfoDtlsRequestDTO, TFacilityInfoDtls>() {
            @Override
            protected void configure() {
                skip().setState(null);
                skip().setAlternateId(null);
            }
        });
        return modelMapper;
    }
}
