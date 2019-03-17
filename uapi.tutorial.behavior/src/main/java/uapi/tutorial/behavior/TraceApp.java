package uapi.tutorial.behavior;

import uapi.app.AppStartupEvent;
import uapi.behavior.BehaviorExecutingEventHandler;
import uapi.behavior.IResponsible;
import uapi.behavior.IResponsibleRegistry;
import uapi.common.CollectionHelper;
import uapi.log.ILogger;
import uapi.service.annotation.Inject;
import uapi.service.annotation.OnActivate;
import uapi.service.annotation.Service;
import uapi.service.annotation.Tag;

@Service(autoActive = true)
@Tag("TraceBehavior")
public class TraceApp {

    @Inject
    protected IResponsibleRegistry _respReg;

    @Inject
    protected ILogger _logger;

    private final BehaviorExecutingEventHandler execHandler = (execEvent) -> {
        this._logger.info(
                "Action executed: {}\n\tAction inputs: {}\n\tAction outputs: {}",
                execEvent.executingActionId().toString(),
                CollectionHelper.asString(execEvent.currentInputs()),
                CollectionHelper.asString(execEvent.currentOutputs()));
        return null;
    };

    @OnActivate
    public void activate() {
        IResponsible resp = this._respReg.register("Tracer");
        resp.newBehavior("Tracer Behavior", AppStartupEvent.class, AppStartupEvent.TOPIC)
                .then(TraceAction.class)
                .traceable(true)
                .build();
        resp.on(execHandler);
    }
}
