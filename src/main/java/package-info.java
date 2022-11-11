/**
 * @author Dinakar N created on 11/11/22
 */

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;

/*@javax.xml.bind.annotation.XmlSchema(namespace = "http://www.niso.org/2008/ncip", elementFormDefault = javax.xml.bind.annotation.XmlNsForm.QUALIFIED, xmlns = { @javax.xml.bind.annotation.XmlNs(namespaceURI = "http://www.niso.org/2008/ncip", prefix = "ns2") })*/
@javax.xml.bind.annotation.XmlSchema(namespace = "http://www.niso.org/2008/ncip", xmlns = {@XmlNs(prefix = "ns2", namespaceURI = "http://www.niso.org/2008/ncip")}, elementFormDefault = XmlNsForm.QUALIFIED)