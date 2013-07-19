package com.javelingroup.navigate.dto;

import java.util.List;

import com.javelingroup.navigate.model.Media;

public class NavigateResult {
    private String breadCrumb;

    private List<Media> media;

    public NavigateResult(String breadCrumb, List<Media> media) {
        this.breadCrumb = breadCrumb;
        this.media = media;
    }

    public String getBreadCrumb() {
        return breadCrumb;
    }

    public List<Media> getMedia() {
        return media;
    }

}
