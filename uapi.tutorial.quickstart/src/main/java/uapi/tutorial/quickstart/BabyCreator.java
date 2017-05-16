package uapi.tutorial.quickstart;

import uapi.app.AppStartupEvent;
import uapi.behavior.IResponsible;
import uapi.behavior.IResponsibleRegistry;
import uapi.service.annotation.Inject;
import uapi.service.annotation.OnActivate;
import uapi.service.annotation.Service;
import uapi.service.annotation.Tag;

/**
 * Hello world application demo
 */
@Service(autoActive=true)
@Tag("BabyHello")
public class BabyCreator {

    @Inject
    protected IResponsibleRegistry _responsibleReg;

    @OnActivate
    public void activate() {
        IResponsible baby = this._responsibleReg.register("Baby");
        baby.newBehavior("Say Hello", AppStartupEvent.class, AppStartupEvent.TOPIC)
                .then(Greeting.actionId)
                .traceable(true)
                .build();
    }
}
