package uapi.tutorial.service;

import uapi.log.ILogger;
import uapi.service.annotation.Inject;
import uapi.service.annotation.OnActivate;
import uapi.service.annotation.Service;
import uapi.service.annotation.Tag;

@Service(autoActive = true)
@Tag("MethodBasedInjection")
public class MethodBasedInjectionService {

    @Inject
    protected ILogger _logger;

    private TypedService _svc;

    @Inject
    protected void setService(TypedService service) {
        this._svc = service;
        System.out.println("The TypedService is injected.");
    }

    @OnActivate
    public void activate() {
        if (this._svc != null) {
            this._logger.info("The service is injected by method!");
        } else {
            this._logger.error("The service is NOT injected!");
        }
    }
}
