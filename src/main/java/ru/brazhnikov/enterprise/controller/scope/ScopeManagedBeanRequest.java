package ru.brazhnikov.enterprise.controller.scope;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.ocpsoft.pretty.faces.annotation.URLMapping;

@ManagedBean
@RequestScoped
@URLMapping(id = "csope-mb-request", pattern = "/scope-mb-request", viewId = "/WEB-INF/faces/scope-mb-request.xhtml")
public class ScopeManagedBeanRequest {

    public final String title = "ScopeManagedBeanRequest";

    public long timestamp() {
        return System.currentTimeMillis();
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
