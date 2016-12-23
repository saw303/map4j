package ch.silviowangler.map4j.mapstruct.mappers;

import ch.silviowangler.map4j.AdresseDTO;
import ch.silviowangler.map4j.AdresseVO;
import ch.silviowangler.map4j.PartnerDTO;
import ch.silviowangler.map4j.PartnerVO;
import ch.silviowangler.map4j.mapstruct.BaseMapper;
import ch.silviowangler.map4j.mapstruct.InverseBaseMapper;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * Created by Silvio Wangler on 15/04/16.
 */
@Mapper
public interface AdresseMapper extends InverseBaseMapper<AdresseVO, AdresseDTO>
{

   AdresseMapper INSTANCE = Mappers.getMapper(AdresseMapper.class);

   @Override
   @Mapping(source = "street", target = "strasse")
   @Mapping(source = "number", target = "hausnummer")
   @Mapping(source = "town", target = "ort")
   AdresseDTO createFromSource(AdresseVO source);

   @Override
   @InheritInverseConfiguration(name="createFromSource")
   AdresseVO createFromSourceInverse(AdresseDTO source);


   @Override
   @InheritConfiguration(name="createFromSource")
   void updateFromSource(AdresseVO source, @MappingTarget AdresseDTO target);
}
