//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.extensiblecatalog.ncip.v2.service;

import java.util.Iterator;
import java.util.List;

public class ValidationException extends Exception {
    private final String LINE_SEPARATOR = System.getProperty("line.separator");
    protected List<Problem> problemsList;

    public ValidationException(List<Problem> problemsList) {
        super("Invalid message.");
        this.problemsList = problemsList;
    }

    public List<Problem> getProblems() {
        return this.problemsList;
    }

    public String getMessage() {
        String detailMessage = "";
        if (this.problemsList != null) {
            StringBuilder sb = new StringBuilder();
            Iterator var3 = this.problemsList.iterator();

            while(var3.hasNext()) {
                Problem p = (Problem)var3.next();
                sb.append(p.toString()).append(this.LINE_SEPARATOR);
            }

            detailMessage = sb.toString();
        }

        return detailMessage;
    }
}
