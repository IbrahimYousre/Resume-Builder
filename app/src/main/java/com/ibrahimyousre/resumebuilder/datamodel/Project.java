package com.ibrahimyousre.resumebuilder.datamodel;

/**
 * Created by ibrahim on 1/18/18.
 */

public class Project extends ResumeEvent {

    public Project() {
    }

    public Project(ResumeEvent event) {
        super(event);
    }

    public String getName() {
        return getTitle();
    }

    public void setName(String name) {
        setTitle(name);
    }
}
