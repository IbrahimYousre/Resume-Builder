package com.ibrahimyousre.resumebuilder.datamodel;

/**
 * Created by ibrahim on 1/18/18.
 */

public class Experience extends ResumeEvent {
    public Experience() {
    }

    public Experience(ResumeEvent event) {
        super(event);
    }

    public String getCompany() {
        return getTitle();
    }

    public void setCompany(String company) {
        setTitle(company);
    }

    public String getLocation() {
        return getDetail();
    }

    public void setLocation(String location) {
        setDetail(location);
    }

    public String getJobTitle() {
        return getSubtitle();
    }

    public void setJobTitle(String jobTitle) {
        setSubtitle(jobTitle);
    }
}
