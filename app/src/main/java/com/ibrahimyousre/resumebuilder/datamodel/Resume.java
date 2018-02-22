package com.ibrahimyousre.resumebuilder.datamodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ibrahim on 1/18/18.
 */

public class Resume implements Serializable {
    public PersonalInfo personalInfo;
    public List<Project> projects;
    public List<School> schools;
    public List<Experience> experience;
    public String languages;
    public String skills;

    private Resume() {

    }

    static public Resume createNewResume() {
        Resume resume = new Resume();
        resume.personalInfo = new PersonalInfo();
        resume.schools = new ArrayList<>();
        resume.experience = new ArrayList<>();
        resume.projects = new ArrayList<>();
        resume.languages = "";
        resume.skills = "";
        return resume;
    }
}
