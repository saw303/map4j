package ch.silviowangler.map4j.mapstruct;

import ch.silviowangler.map4j.AdresseDTO;
import ch.silviowangler.map4j.AdresseVO;
import ch.silviowangler.map4j.PartnerDTO;
import ch.silviowangler.map4j.PartnerVO;
import ch.silviowangler.map4j.mapstruct.mappers.AdresseMapper;
import ch.silviowangler.map4j.mapstruct.mappers.PartnerMapper;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Date;

import static org.junit.Assert.assertEquals;


/**
 * Created by Silvio Wangler on 15/04/16.
 */
public class AdresseMapperTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void mapAdresseDtoToAdresseVOInverse() {
        MapperRegistry registry = new MapperRegistry();

        registry.addInverseBaseMapping(AdresseVO.class, AdresseDTO.class, AdresseMapper.class);
        MapStructMapper mapper = new MapStructMapper(registry);

        AdresseDTO adresseDTO = new AdresseDTO("Haupstrasse", "4", "9001", "St. Gallen");
        AdresseVO adresseVO = mapper.map(adresseDTO, AdresseVO.class);

        assertEquals( adresseDTO.getStrasse(), adresseVO.getStreet());
        assertEquals( adresseDTO.getHausnummer(), String.valueOf(adresseVO.getNumber()));
        assertEquals( adresseDTO.getPlz(), adresseVO.getPlz());
        assertEquals( adresseDTO.getOrt(), adresseVO.getTown());
    }


    @Test
    public void checkNoSuchMappingExceptionIsThrown() {
        MapperRegistry registry = new MapperRegistry();
        MapStructMapper mapper = new MapStructMapper(registry);
        AdresseDTO adresseDTO = new AdresseDTO("Haupstrasse", "4", "9001", "St. Gallen");

        exception.expect(NoSuchMappingException.class);
        AdresseVO adresseVO = mapper.map(adresseDTO, AdresseVO.class);
    }

    @Test
    public void checkMappingAlreadyRegisteredExceptionIsThrown() {
        MapperRegistry registry = new MapperRegistry();
        registry.addBaseMapping(AdresseVO.class, AdresseDTO.class, AdresseMapper.class);
        exception.expect(IllegalArgumentException.class);
        registry.addInverseBaseMapping(AdresseVO.class, AdresseDTO.class, AdresseMapper.class);
    }

    @Test
    public void checkMappingAlreadyRegisteredExceptionIsThrown2() {
        MapperRegistry registry = new MapperRegistry();
        registry.addInverseBaseMapping(AdresseVO.class, AdresseDTO.class, AdresseMapper.class);
        exception.expect(IllegalArgumentException.class);
        registry.addBaseMapping(AdresseVO.class, AdresseDTO.class, AdresseMapper.class);
    }

    @Test
    public void checkMappingAlreadyRegisteredExceptionIsThrown3() {
        MapperRegistry registry = new MapperRegistry();
        registry.addInverseBaseMapping(AdresseVO.class, AdresseDTO.class, AdresseMapper.class);
        exception.expect(IllegalArgumentException.class);
        registry.addMapping(AdresseVO.class, AdresseDTO.class, (a, b) ->  {
            if (b == null) {
                return AdresseMapper.INSTANCE.createFromSource((AdresseVO) a);
            }
            throw new NotImplementedException();
        });
        ;
    }

}
