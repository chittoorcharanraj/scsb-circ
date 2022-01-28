package org.extensiblecatalog.ncip.v2.service;

import java.util.List;

public interface NCIPResponseData extends NCIPData {
    List<Problem> getProblems();
}
