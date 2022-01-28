package org.extensiblecatalog.ncip.v2.service;

import java.util.List;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class ProblemResponseData implements NCIPResponseData {
    protected String version;
    protected List<Problem> problems;

    public ProblemResponseData() {
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setProblems(List<Problem> problems) {
        this.problems = problems;
    }

    public List<Problem> getProblems() {
        return this.problems;
    }

    public Problem getProblem(int index) {
        return (Problem)this.problems.get(index);
    }

    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
