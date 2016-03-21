package ch.silviowangler.map4j

import ma.glasnost.orika.MapperFactory
import ma.glasnost.orika.impl.DefaultMapperFactory
import spock.lang.Specification

/**
 * Created by Silvio Wangler on 17/03/16.
 */
class OrikaMapperSpec extends Specification {


    MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build()

    void setup() {

        mapperFactory.classMap(PartnerDTO, PartnerVO)
                .field('vorname', 'firstname')
                .field('nachname', 'lastname')
                .field('geburtstag', 'birthdate')
                .byDefault()
                .register()
    }

    void "Map PartnerDTO to a new PartnerVO instance using Orika"() {
        given:
        Mapper mapper = new OrikaMapper(mapperFactory.getMapperFacade())

        and:
        PartnerVO partnerVO = new PartnerVO(firstname: 'Silvio', lastname: 'Wangler', birthdate: new Date())

        when:
        PartnerDTO partnerDTO = mapper.map(partnerVO, PartnerDTO)

        then:
        partnerDTO

        and:
        partnerDTO.vorname == partnerVO.firstname
        partnerDTO.nachname == partnerVO.lastname
        partnerDTO.geburtstag == partnerVO.birthdate
        partnerDTO.telephone == partnerVO.telephone
    }

    void "Map PartnerDTO to an existing PartnerVO instance using Orika"() {
        given:
        Mapper mapper = new OrikaMapper(mapperFactory.getMapperFacade())

        and:
        PartnerVO partnerVO = new PartnerVO(firstname: 'Silvio', lastname: 'Wangler', birthdate: new Date())
        PartnerDTO partnerDTO = new PartnerDTO()

        when:
        mapper.map(partnerVO, partnerDTO)

        then:
        partnerDTO

        and:
        partnerDTO.vorname == partnerVO.firstname
        partnerDTO.nachname == partnerVO.lastname
        partnerDTO.geburtstag == partnerVO.birthdate
        partnerDTO.telephone == partnerVO.telephone
    }
}
