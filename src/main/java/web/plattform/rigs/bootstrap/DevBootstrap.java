package web.plattform.rigs.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import web.plattform.rigs.model.Country;
import web.plattform.rigs.model.Owner;
import web.plattform.rigs.model.Rig;
import web.plattform.rigs.model.RigType;
import web.plattform.rigs.repositories.CountryRepositopry;
import web.plattform.rigs.repositories.OwnerRepostory;
import web.plattform.rigs.repositories.RigRepository;
import web.plattform.rigs.repositories.RigTypeRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private OwnerRepostory ownerRepostory;
    private RigRepository rigRepository;
    private RigTypeRepository rigTypeRepository;
    private CountryRepositopry countryRepositopry;

    public DevBootstrap(OwnerRepostory ownerRepostory, RigRepository rigRepository, RigTypeRepository rigTypeRepository, CountryRepositopry countryRepositopry) {
        this.ownerRepostory = ownerRepostory;
        this.rigRepository = rigRepository;
        this.rigTypeRepository = rigTypeRepository;
        this.countryRepositopry = countryRepositopry;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){

        initData();
    }

    private void initData() {

        RigType rigtype = new RigType();
        rigtype.setName("Oel");

        rigTypeRepository.save(rigtype);

        Country country = new Country();
        country.setName("Germany");

        countryRepositopry.save(country);

        //Hapag
        Owner hapag = new Owner("Hapag",country);
        Rig ocean1 = new Rig("Ocean-1",1111111,rigtype);
        hapag.getRigs().add(ocean1);
        ocean1.getOwners().add(hapag);

        ownerRepostory.save(hapag);
        rigRepository.save(ocean1);

        //WDR
        Owner wdr = new Owner("WDR",country);
        Rig pellworm = new Rig("Pellworm",2222222,rigtype);
        wdr.getRigs().add(pellworm);
        pellworm.getOwners().add(wdr);

        ownerRepostory.save(wdr);
        rigRepository.save(pellworm);
    }
}
