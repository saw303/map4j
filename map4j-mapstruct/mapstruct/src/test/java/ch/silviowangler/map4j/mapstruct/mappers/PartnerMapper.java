package ch.silviowangler.map4j.mapstruct.mappers;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import ch.silviowangler.map4j.PartnerDTO;
import ch.silviowangler.map4j.PartnerVO;
import ch.silviowangler.map4j.mapstruct.BaseMapper;

/**
 * Created by Silvio Wangler on 15/04/16.
 */
@Mapper
public interface PartnerMapper extends BaseMapper<PartnerVO, PartnerDTO>
{

   PartnerMapper INSTANCE = Mappers.getMapper(PartnerMapper.class);

   @Override
   @Mappings({
           @Mapping(source = "firstname", target = "vorname"),
           @Mapping(source = "lastname", target = "nachname"),
           @Mapping(source = "birthdate", target = "geburtstag")
   })
   PartnerDTO createFromSource(PartnerVO source);

   @Override
   @InheritConfiguration
   void updateFromSource(PartnerVO source, @MappingTarget PartnerDTO target);
}
