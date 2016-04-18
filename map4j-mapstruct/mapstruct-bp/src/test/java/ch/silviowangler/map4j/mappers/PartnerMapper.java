package ch.silviowangler.map4j.mappers;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import ch.silviowangler.map4j.PartnerDTO;
import ch.silviowangler.map4j.PartnerVO;

/**
 * Created by Silvio Wangler on 15/04/16.
 */
@Mapper
public interface PartnerMapper
{

   PartnerMapper INSTANCE = Mappers.getMapper(PartnerMapper.class);

   @Mappings({
        @Mapping(source = "firstname", target = "vorname"),
        @Mapping(source = "lastname", target = "nachname"),
        @Mapping(source = "birthdate", target = "geburtstag")
   })
   PartnerDTO partnerVoToPartnerDto(PartnerVO partnerVO);


   @InheritConfiguration
   void updatePartnerDTOfromPartnerVO(PartnerVO partnerVO, @MappingTarget PartnerDTO partnerDTO);
}
