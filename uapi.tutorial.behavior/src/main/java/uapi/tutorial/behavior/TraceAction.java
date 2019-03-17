package uapi.tutorial.behavior;

import uapi.behavior.annotation.Action;
import uapi.behavior.annotation.ActionDo;
import uapi.log.ILogger;
import uapi.service.annotation.Inject;
import uapi.service.annotation.Service;
import uapi.service.annotation.Tag;

@Service
@Action
@Tag("TraceBehavior")
public class TraceAction {

    @Inject
    protected ILogger _logger;

    @ActionDo
    public void execute() {
        this._logger.info("I am TraceAction");
    }
}
