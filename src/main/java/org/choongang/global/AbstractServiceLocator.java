package org.choongang.global;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractServiceLocator implements ServiceLocator{
    protected Map<Menu, Service> services;

    public AbstractServiceLocator() {
        services = new HashMap<>();
    }

}


