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
        resume.schools.add(new School());
        resume.schools.add(new School());
        resume.experience = new ArrayList<>();
        resume.experience.add(new Experience());
        resume.projects = new ArrayList<>();
        resume.projects.add(new Project());
        resume.languages = "Lorem ipsum, Dolor sit amet, Consectetuer";
        resume.skills = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean ac interdum nisi. Sed in consequat mi. Sed pulvinar lacinia felis eu finibus.";
        return resume;
    }
}
