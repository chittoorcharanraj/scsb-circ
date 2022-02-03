package org.extensiblecatalog.ncip.v2.binding.ncipv2_02.jaxb.elements;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"author", "authorOfComponent", "edition", "pagination", "placeOfPublication", "publicationDate", "publicationDateOfComponent", "publisher", "seriesTitleNumber", "title", "titleOfComponent", "bibliographicLevel", "sponsoringBody", "electronicDataFormatType", "language", "mediumType", "ext"}
)
@XmlRootElement(
        name = "BibliographicDescription"
)
public class BibliographicDescription {
    @XmlElement(
            name = "Author"
    )
    protected String author;
    @XmlElement(
            name = "AuthorOfComponent"
    )
    protected String authorOfComponent;
    @XmlElement(
            name = "Edition"
    )
    protected String edition;
    @XmlElement(
            name = "Pagination"
    )
    protected String pagination;
    @XmlElement(
            name = "PlaceOfPublication"
    )
    protected String placeOfPublication;
    @XmlElement(
            name = "PublicationDate"
    )
    protected String publicationDate;
    @XmlElement(
            name = "PublicationDateOfComponent"
    )
    protected String publicationDateOfComponent;
    @XmlElement(
            name = "Publisher"
    )
    protected String publisher;
    @XmlElement(
            name = "SeriesTitleNumber"
    )
    protected String seriesTitleNumber;
    @XmlElement(
            name = "Title"
    )
    protected String title;
    @XmlElement(
            name = "TitleOfComponent"
    )
    protected String titleOfComponent;
    @XmlElement(
            name = "BibliographicLevel"
    )
    protected SchemeValuePair bibliographicLevel;
    @XmlElement(
            name = "SponsoringBody"
    )
    protected String sponsoringBody;
    @XmlElement(
            name = "ElectronicDataFormatType"
    )
    protected SchemeValuePair electronicDataFormatType;
    @XmlElement(
            name = "Language"
    )
    protected SchemeValuePair language;
    @XmlElement(
            name = "MediumType"
    )
    protected SchemeValuePair mediumType;
    @XmlElement(
            name = "Ext"
    )
    protected Ext ext;

    public BibliographicDescription() {
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String value) {
        this.author = value;
    }

    public String getAuthorOfComponent() {
        return this.authorOfComponent;
    }

    public void setAuthorOfComponent(String value) {
        this.authorOfComponent = value;
    }

    public String getEdition() {
        return this.edition;
    }

    public void setEdition(String value) {
        this.edition = value;
    }

    public String getPagination() {
        return this.pagination;
    }

    public void setPagination(String value) {
        this.pagination = value;
    }

    public String getPlaceOfPublication() {
        return this.placeOfPublication;
    }

    public void setPlaceOfPublication(String value) {
        this.placeOfPublication = value;
    }

    public String getPublicationDate() {
        return this.publicationDate;
    }

    public void setPublicationDate(String value) {
        this.publicationDate = value;
    }

    public String getPublicationDateOfComponent() {
        return this.publicationDateOfComponent;
    }

    public void setPublicationDateOfComponent(String value) {
        this.publicationDateOfComponent = value;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String value) {
        this.publisher = value;
    }

    public String getSeriesTitleNumber() {
        return this.seriesTitleNumber;
    }

    public void setSeriesTitleNumber(String value) {
        this.seriesTitleNumber = value;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public String getTitleOfComponent() {
        return this.titleOfComponent;
    }

    public void setTitleOfComponent(String value) {
        this.titleOfComponent = value;
    }

    public SchemeValuePair getBibliographicLevel() {
        return this.bibliographicLevel;
    }

    public void setBibliographicLevel(SchemeValuePair value) {
        this.bibliographicLevel = value;
    }

    public String getSponsoringBody() {
        return this.sponsoringBody;
    }

    public void setSponsoringBody(String value) {
        this.sponsoringBody = value;
    }

    public SchemeValuePair getElectronicDataFormatType() {
        return this.electronicDataFormatType;
    }

    public void setElectronicDataFormatType(SchemeValuePair value) {
        this.electronicDataFormatType = value;
    }

    public SchemeValuePair getLanguage() {
        return this.language;
    }

    public void setLanguage(SchemeValuePair value) {
        this.language = value;
    }

    public SchemeValuePair getMediumType() {
        return this.mediumType;
    }

    public void setMediumType(SchemeValuePair value) {
        this.mediumType = value;
    }

    public Ext getExt() {
        return this.ext;
    }

    public void setExt(Ext value) {
        this.ext = value;
    }
}
