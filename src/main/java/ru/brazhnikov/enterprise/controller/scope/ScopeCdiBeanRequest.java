package ru.brazhnikov.enterprise.controller.scope;

import com.ocpsoft.pretty.faces.annotation.URLMapping;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
@URLMapping(id = "scope-cdi-request", pattern = "/scope-cdi-request", viewId = "/WEB-INF/faces/scope-cdi-request.xhtml")
public class ScopeCdiBeanRequest {
    public long timestamp() {
        return System.currentTimeMillis();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
