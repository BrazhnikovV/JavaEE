package ru.brazhnikov.enterprise.controller.scope;

import com.ocpsoft.pretty.faces.annotation.URLMapping;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
@URLMapping(id = "csope-mb-session", pattern = "/scope-mb-session", viewId = "/WEB-INF/faces/scope-mb-session.xhtml")
public class ScopeManagedBeanSession {
    public final String title = "ScopeManagedBeanSession";

    public long timestamp() {
        return System.currentTimeMillis();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
