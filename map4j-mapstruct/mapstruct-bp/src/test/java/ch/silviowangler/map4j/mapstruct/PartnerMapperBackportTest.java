package ch.silviowangler.map4j.mapstruct;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import ch.silviowangler.map4j.PartnerDTO;
import ch.silviowangler.map4j.PartnerVO;
import ch.silviowangler.map4j.mapstruct.mappers.PartnerMapper;

/**
 * Created by Silvio Wangler on 15/04/16.
 */
public class PartnerMapperBackportTest
{

   @Test
   public void mapPartnerDtoToPartnerVO ()
   {
      MapperRegistry registry = new MapperRegistry ();

      registry.addMapping (PartnerVO.class, PartnerDTO.class, new MapperWrapper<PartnerVO, PartnerDTO>()
      {
         @Override
         public PartnerDTO createInstance(PartnerVO source)
         {
            return PartnerMapper.INSTANCE.createFromSource (source);
         }

         @Override
         public void updateInstance(PartnerVO source, PartnerDTO target)
         {
            PartnerMapper.INSTANCE.updateFromSource (source, target);
         }
      });

      MapStructMapper mapper = new MapStructMapper (registry);

      PartnerVO partnerVO = new PartnerVO ("Silvio", "Wangler", new Date (), "+41 44 444 44 44");

      PartnerDTO partnerDTO = mapper.map (partnerVO, PartnerDTO.class);

      assertEquals (partnerDTO.getVorname (), partnerVO.getFirstname ());
      assertEquals (partnerDTO.getNachname (), partnerVO.getLastname ());
      assertEquals (partnerDTO.getTelephone (), partnerVO.getTelephone ());
      assertEquals (partnerDTO.getGeburtstag (), partnerVO.getBirthdate ());

      PartnerDTO partnerDTO1 = new PartnerDTO ();

      mapper.map (partnerVO, partnerDTO1);

      assertEquals (partnerDTO1.getVorname (), partnerVO.getFirstname ());
      assertEquals (partnerDTO1.getNachname (), partnerVO.getLastname ());
      assertEquals (partnerDTO1.getTelephone (), partnerVO.getTelephone ());
      assertEquals (partnerDTO1.getGeburtstag (), partnerVO.getBirthdate ());
   }
}
