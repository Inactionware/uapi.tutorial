package uapi.tutorial.behavior;

import uapi.app.AppStartupEvent;
import uapi.behavior.IResponsibleRegistry;
import uapi.log.ILogger;
import uapi.service.annotation.Inject;
import uapi.service.annotation.OnActivate;
import uapi.service.annotation.Service;
import uapi.service.annotation.Tag;

@Service(autoActive = true)
@Tag("SimpleBehavior")
public class SimpleApp {

    @Inject
    protected IResponsibleRegistry _respReg;

    @Inject
    protected ILogger _logger;

    @OnActivate
    public void activate() {
        this._respReg.register("A Responsible")
                .newBehavior("Simple Behavior", AppStartupEvent.class, AppStartupEvent.TOPIC)
                .then(SimpleAction.actionId)
                .call(execCtx -> this._logger.info("End execute SimpleAction by {}.", execCtx.behaviorName()))
                .build();
    }
}
