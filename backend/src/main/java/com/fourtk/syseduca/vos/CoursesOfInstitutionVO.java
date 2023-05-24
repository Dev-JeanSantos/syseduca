package com.fourtk.syseduca.vos;

public class CoursesOfInstitutionVO {
    private String name;
    private String segment;
    private String status;

    public CoursesOfInstitutionVO() {
    }

    public CoursesOfInstitutionVO(String name, String segment, String status) {
        this.name = name;
        this.segment = segment;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getSegment() {
        return segment;
    }

    public String getStatus() {
        return status;
    }
}
