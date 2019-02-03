package ru.brazhnikov.enterprise.controller.scope;

import com.ocpsoft.pretty.faces.annotation.URLMapping;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
@URLMapping(id = "csope-mb-view", pattern = "/scope-mb-view", viewId = "/WEB-INF/faces/scope-mb-view.xhtml")
public class ScopeManagedBeanView {
    public final String title = "ScopeManagedBeanView";

    public long timestamp() {
        return System.currentTimeMillis();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
