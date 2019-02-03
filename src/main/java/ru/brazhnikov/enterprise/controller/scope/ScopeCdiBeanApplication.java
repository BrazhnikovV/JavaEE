package ru.brazhnikov.enterprise.controller.scope;

import com.ocpsoft.pretty.faces.annotation.URLMapping;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
@URLMapping(id = "scope-cdi-application", pattern = "/scope-cdi-application", viewId = "/WEB-INF/faces/scope-cdi-application.xhtml")
public class ScopeCdiBeanApplication {

    public long timestamp() {
        return System.currentTimeMillis();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
