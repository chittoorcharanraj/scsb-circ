//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.extensiblecatalog.ncip.v2.service;

import java.util.List;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class BibliographicDescription {
    protected String author;
    protected String authorOfComponent;
    protected String edition;
    protected String pagination;
    protected String placeOfPublication;
    protected String publicationDate;
    protected String publicationDateOfComponent;
    protected String publisher;
    protected String seriesTitleNumber;
    protected String title;
    protected String uniformTitle;
    protected String titleOfComponent;
    protected String sponsoringBody;

    public BibliographicDescription() {
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorOfComponent() {
        return this.authorOfComponent;
    }

    public void setAuthorOfComponent(String authorOfComponent) {
        this.authorOfComponent = authorOfComponent;
    }


    public String getEdition() {
        return this.edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getPagination() {
        return this.pagination;
    }

    public void setPagination(String pagination) {
        this.pagination = pagination;
    }

    public String getPlaceOfPublication() {
        return this.placeOfPublication;
    }

    public void setPlaceOfPublication(String placeOfPublication) {
        this.placeOfPublication = placeOfPublication;
    }

    public String getPublicationDate() {
        return this.publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getPublicationDateOfComponent() {
        return this.publicationDateOfComponent;
    }

    public void setPublicationDateOfComponent(String publicationDateOfComponent) {
        this.publicationDateOfComponent = publicationDateOfComponent;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getSeriesTitleNumber() {
        return this.seriesTitleNumber;
    }

    public void setSeriesTitleNumber(String seriesTitleNumber) {
        this.seriesTitleNumber = seriesTitleNumber;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUniformTitle() {
        return this.uniformTitle;
    }

    public void setUniformTitle(String uniformTitle) {
        this.uniformTitle = uniformTitle;
    }

    public String getTitleOfComponent() {
        return this.titleOfComponent;
    }

    public void setTitleOfComponent(String titleOfComponent) {
        this.titleOfComponent = titleOfComponent;
    }


    public String getSponsoringBody() {
        return this.sponsoringBody;
    }

    public void setSponsoringBody(String sponsoringBody) {
        this.sponsoringBody = sponsoringBody;
    }

    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
