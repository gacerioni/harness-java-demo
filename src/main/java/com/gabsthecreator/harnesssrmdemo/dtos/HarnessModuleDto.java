package com.gabsthecreator.harnesssrmdemo.dtos;

import javax.validation.constraints.NotBlank;

public class HarnessModuleDto {

    @NotBlank
    private String shortName;
    @NotBlank
    private String imagePath;
    @NotBlank
    private String url;
    @NotBlank
    private String description;

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName.toUpperCase();
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
