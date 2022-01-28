//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.extensiblecatalog.ncip.v2.service;

public class Problem {
    protected ProblemType problemType;
    protected String problemDetail;
    protected String problemElement;
    protected String problemValue;

    public Problem() {
    }

    public Problem(ProblemType problemType, String problemElement, String problemValue, String problemDetail) {
        this.problemType = problemType;
        this.problemDetail = problemDetail;
        this.problemElement = problemElement;
        this.problemValue = problemValue;
    }

    public Problem(ProblemType problemType, String problemElement, String problemValue) {
        this(problemType, problemElement, problemValue, (String)null);
    }

    public void setProblemType(ProblemType problemType) {
        this.problemType = problemType;
    }

    public ProblemType getProblemType() {
        return this.problemType;
    }

    public void setProblemDetail(String problemDetail) {
        this.problemDetail = problemDetail;
    }

    public String getProblemDetail() {
        return this.problemDetail;
    }

    public void setProblemElement(String problemElement) {
        this.problemElement = problemElement;
    }

    public String getProblemElement() {
        return this.problemElement;
    }

    public void setProblemValue(String problemValue) {
        this.problemValue = problemValue;
    }

    public String getProblemValue() {
        return this.problemValue;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        if (this.problemType != null && this.problemType.getScheme() != null) {
            buffer.append(this.problemType.getScheme()).append(": ");
        }

        if (this.problemType != null) {
            buffer.append(this.problemType.getValue()).append(".");
        }

        if (this.problemType != null && (this.problemType.getScheme() != null || this.problemType.getValue() != null)) {
            buffer.append(" ");
        }

        if (this.problemElement != null) {
            buffer.append("In ").append(this.problemElement).append(".");
        }

        if (this.problemValue != null) {
            buffer.append("Contents '").append(this.problemValue).append("'.");
        }

        if (this.problemDetail != null) {
            buffer.append("(Details: ").append(this.problemDetail).append(")");
        }

        return buffer.toString();
    }
}
