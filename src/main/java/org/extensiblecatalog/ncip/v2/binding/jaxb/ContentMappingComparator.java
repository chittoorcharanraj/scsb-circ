//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.extensiblecatalog.ncip.v2.binding.jaxb;

import java.util.Comparator;
import java.util.List;
import javax.xml.bind.JAXBElement;

class ContentMappingComparator implements Comparator {
    final List<String> elementOrderByName;

    ContentMappingComparator(List<String> elementOrderByName) {
        this.elementOrderByName = elementOrderByName;
    }

    public int compare(Object firstElement, Object secondElement) {
        String firstElementName;
        if (firstElement instanceof JAXBElement) {
            firstElementName = ((JAXBElement)firstElement).getName().getLocalPart();
        } else {
            firstElementName = firstElement.getClass().getSimpleName();
        }

        String secondElementName;
        if (secondElement instanceof JAXBElement) {
            secondElementName = ((JAXBElement)secondElement).getName().getLocalPart();
        } else {
            secondElementName = secondElement.getClass().getSimpleName();
        }

        int firstIndex = this.elementOrderByName.indexOf(firstElementName);
        int secondIndex = this.elementOrderByName.indexOf(secondElementName);
        byte result;
        if (firstIndex > secondIndex) {
            result = 1;
        } else if (firstIndex == secondIndex) {
            result = 0;
        } else {
            result = -1;
        }

        return result;
    }
}
