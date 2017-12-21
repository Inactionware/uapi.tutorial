package uapi.tutorial.service;

import uapi.service.annotation.Service;
import uapi.service.annotation.Tag;

@Service(ids = {"MyService"})
@Tag("IdBasedInjection")
public class IdentifiedService { }
