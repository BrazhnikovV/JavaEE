package ru.brazhnikov.enterprise.controller.scope;

import com.ocpsoft.pretty.faces.annotation.URLMapping;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
@URLMapping(id = "csope-mb-application", pattern = "/scope-mb-application", viewId = "/WEB-INF/faces/scope-mb-application.jsp")
public class ScopeManagedBeanApplication {

        public final String title = "ScopeManagedBeanApplication";

        public long timestamp() {
        return System.currentTimeMillis();
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }
}
