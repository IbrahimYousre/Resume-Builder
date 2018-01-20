package com.ibrahimyousre.resumebuilder.datamodel;

/**
 * Created by ibrahim on 1/18/18.
 */

public class School extends ResumeEvent {
    public School() {
        super(
                "School Name",
                "Location",
                "Degree",
                "Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore.",
                null,
                null
        );
    }

    public School(ResumeEvent event) {
        super(event);
    }

    public String getSchoolName() {
        return getTitle();
    }

    public void setSchoolName(String school) {
        setTitle(school);
    }

    public String getLocation() {
        return getDetail();
    }

    public void setLocation(String location) {
        setDetail(location);
    }

    public String getDegree() {
        return getSubtitle();
    }

    public void setDegree(String degree) {
        setSubtitle(degree);
    }
}
