import uapi.IModulePortal;
import uapi.tutorial.behavior.TutorialBehaviorModulePortal;

module uapi.tutorial.behavior {
    requires static uapi.codegen;
    requires static uapi.service.apt;
    requires static uapi.behavior.apt;

    requires uapi.common;
    requires uapi.exception;
    requires uapi.service;
    requires uapi.log;
    requires uapi.event;
    requires uapi.behavior;
    requires uapi.app;
    requires uapi.behavior.common;

    provides IModulePortal with TutorialBehaviorModulePortal;
}