package ch.silviowangler.map4j

import ma.glasnost.orika.MapperFactory
import ma.glasnost.orika.impl.DefaultMapperFactory
import spock.lang.Specification

/**
 * Created by Silvio Wangler on 17/03/16.
 */
class OrikaMapperSpec extends Specification {

    void "hello"() {
        given:
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build()

        and:
        mapperFactory.classMap(PartnerDTO, PartnerVO)
                .field('vorname', 'firstname')
                .field('nachname', 'lastname')
                .field('geburtstag', 'birthdate')
                .byDefault()
                .register()

        and:
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
}
