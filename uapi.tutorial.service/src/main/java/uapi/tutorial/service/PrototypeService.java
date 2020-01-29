package uapi.tutorial.service;

import uapi.service.annotation.Service;
import uapi.service.annotation.Tag;
import uapi.service.annotation.helper.ServiceType;

@Service(type = ServiceType.Prototype)
@Tag("PrototypeBasedInjection")
public class PrototypeService {
}
