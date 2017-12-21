package uapi.tutorial.service;

import uapi.log.ILogger;
import uapi.service.annotation.Inject;
import uapi.service.annotation.OnActivate;
import uapi.service.annotation.Service;
import uapi.service.annotation.Tag;

@Service(autoActive = true)
@Tag("AutoActivated")
public class AutoActivatedService {

    @Inject
    protected ILogger _logger;

    @OnActivate
    public void activated() {
        this._logger.info("I am an AutoActivatedService...");
    }
}
