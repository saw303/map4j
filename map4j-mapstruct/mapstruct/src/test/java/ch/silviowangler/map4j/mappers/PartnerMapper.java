package ch.silviowangler.map4j.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import ch.silviowangler.map4j.PartnerDTO;
import ch.silviowangler.map4j.PartnerVO;

/**
 * Created by Silvio Wangler on 15/04/16.
 */
@Mapper
public interface PartnerMapper
{

   @Mappings({
        @Mapping(source = "firstname", target = "vorname"),
        @Mapping(source = "lastname", target = "nachname"),
        @Mapping(source = "birthdate", target = "geburtstag")
   })
   PartnerDTO partnerVoToPartnerDto (PartnerVO partnerVO);


   @Mappings({
           @Mapping(source = "firstname", target = "vorname"),
           @Mapping(source = "lastname", target = "nachname"),
           @Mapping(source = "birthdate", target = "geburtstag")
   })
   void updatePartnerDTOfromPartnerVO(PartnerVO partnerVO, @MappingTarget PartnerDTO partnerDTO);
}
