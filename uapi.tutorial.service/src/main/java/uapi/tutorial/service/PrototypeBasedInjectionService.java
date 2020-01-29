package uapi.tutorial.service;

import uapi.log.ILogger;
import uapi.service.annotation.Inject;
import uapi.service.annotation.OnActivate;
import uapi.service.annotation.Service;
import uapi.service.annotation.Tag;

@Service(autoActive = true)
@Tag("PrototypeBasedInjection")
public class PrototypeBasedInjectionService {

    @Inject
    protected ILogger _logger;

    @Inject
    protected PrototypeService _protoSvc;

    @OnActivate
    public void activate() {
        if (this._protoSvc != null) {
            this._logger.info("The prototype service was injected.");
        } else {
            this._logger.error("The prototype service was not injected");
        }
    }
}
