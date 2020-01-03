import uapi.IModulePortal;
import uapi.tutorial.quickstart.TutorialQuickstartModulePortal;

module uapi.tutorial.quickstart {
    requires static uapi.codegen;
    requires static uapi.service.apt;
    requires static uapi.behavior.apt;

    requires uapi.common;
    requires uapi.exception;
    requires uapi.service;
    requires uapi.config;
    requires uapi.event;
    requires uapi.behavior;
    requires uapi.app;
    requires uapi.app.terminal;

    provides IModulePortal with TutorialQuickstartModulePortal;
}