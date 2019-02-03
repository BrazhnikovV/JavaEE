package ru.brazhnikov.enterprise.controller.scope;

import com.ocpsoft.pretty.faces.annotation.URLMapping;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
@URLMapping(id = "scope-cdi-session", pattern = "/scope-cdi-session", viewId = "/WEB-INF/faces/scope-cdi-session.xhtml")
public class ScopeCdiBeanSession implements Serializable {
    public long timestamp() {
        return System.currentTimeMillis();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
