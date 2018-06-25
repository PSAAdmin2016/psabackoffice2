/*Copyright (c) 2016-2018 performance-contractors.com All Rights Reserved.
 This software is the confidential and proprietary information of performance-contractors.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with performance-contractors.com*/
package com.psabackoffice.psa.models.query;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class GetHelpMenuVideosResponse implements Serializable {


    @JsonProperty("Category")
    @ColumnAlias("Category")
    private String category;

    @JsonProperty("CategoryID")
    @ColumnAlias("CategoryID")
    private Integer categoryId;

    @JsonProperty("SubCategory")
    @ColumnAlias("SubCategory")
    private String subCategory;

    @JsonProperty("SubCategoryID")
    @ColumnAlias("SubCategoryID")
    private Integer subCategoryId;

    @JsonProperty("fileName")
    @ColumnAlias("fileName")
    private String fileName;

    @JsonProperty("title")
    @ColumnAlias("title")
    private String title;

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getSubCategory() {
        return this.subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public Integer getSubCategoryId() {
        return this.subCategoryId;
    }

    public void setSubCategoryId(Integer subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetHelpMenuVideosResponse)) return false;
        final GetHelpMenuVideosResponse getHelpMenuVideosResponse = (GetHelpMenuVideosResponse) o;
        return Objects.equals(getCategory(), getHelpMenuVideosResponse.getCategory()) &&
                Objects.equals(getCategoryId(), getHelpMenuVideosResponse.getCategoryId()) &&
                Objects.equals(getSubCategory(), getHelpMenuVideosResponse.getSubCategory()) &&
                Objects.equals(getSubCategoryId(), getHelpMenuVideosResponse.getSubCategoryId()) &&
                Objects.equals(getFileName(), getHelpMenuVideosResponse.getFileName()) &&
                Objects.equals(getTitle(), getHelpMenuVideosResponse.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCategory(),
                getCategoryId(),
                getSubCategory(),
                getSubCategoryId(),
                getFileName(),
                getTitle());
    }
}
