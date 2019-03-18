package uapi.tutorial.behavior;

import uapi.app.AppStartupEvent;
import uapi.behavior.IResponsible;
import uapi.behavior.IResponsibleRegistry;
import uapi.behavior.common.action.Sleep;
import uapi.common.IntervalTime;
import uapi.log.ILogger;
import uapi.service.annotation.Inject;
import uapi.service.annotation.OnActivate;
import uapi.service.annotation.Service;
import uapi.service.annotation.Tag;

@Service(autoActive = true)
@Tag("EventTrigger")
public class EventTriggerApp {

    @Inject
    protected IResponsibleRegistry _respReg;

    @Inject
    protected ILogger _logger;

    @OnActivate
    public void activate() {
        IResponsible myResp = this._respReg.register("My Responsible");
        myResp.newBehavior("My Behavior", AppStartupEvent.class, AppStartupEvent.TOPIC)
                .then(EventTriggerSourceAction.class)
                .then(Sleep.class, "Sleep", IntervalTime.parse("1s"))
                .onSuccess((success, ctx) -> { this._logger.info("{} execution done", ctx.behaviorName()); return null; })
                .build();

        IResponsible otherResp = this._respReg.register("My Other Responsible");
        otherResp.newBehavior("Other Behavior", TriggerEvent.class, TriggerEvent.TOPIC)
                .then(EventTriggerTargetAction.class)
                .build();
    }
}
