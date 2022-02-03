package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"problemType", "problemDetail", "problemElement", "problemValue", "ext"}
)
@XmlRootElement(
        name = "Problem"
)
public class Problem {
    @XmlElement(
            name = "ProblemType",
            required = true
    )
    protected SchemeValuePair problemType;
    @XmlElement(
            name = "ProblemDetail"
    )
    protected String problemDetail;
    @XmlElement(
            name = "ProblemElement"
    )
    protected String problemElement;
    @XmlElement(
            name = "ProblemValue"
    )
    protected String problemValue;
    @XmlElement(
            name = "Ext"
    )
    protected Ext ext;

    public Problem() {
    }

    public SchemeValuePair getProblemType() {
        return this.problemType;
    }

    public void setProblemType(SchemeValuePair value) {
        this.problemType = value;
    }

    public String getProblemDetail() {
        return this.problemDetail;
    }

    public void setProblemDetail(String value) {
        this.problemDetail = value;
    }

    public String getProblemElement() {
        return this.problemElement;
    }

    public void setProblemElement(String value) {
        this.problemElement = value;
    }

    public String getProblemValue() {
        return this.problemValue;
    }

    public void setProblemValue(String value) {
        this.problemValue = value;
    }

    public Ext getExt() {
        return this.ext;
    }

    public void setExt(Ext value) {
        this.ext = value;
    }
}
