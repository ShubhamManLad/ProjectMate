package com.eample.projectmate.model;

import java.util.List;

public class ProjectsModel {

    private String projectId;
    private String ownerId;
    private String ownerName;
    private String projectName;
    private String projectDesc;
    private String  projectLink;
    private List<String> requirements;

    public ProjectsModel() {
    }

    public ProjectsModel(String projectId, String ownerId, String ownerName, String projectName, String projectDesc, String projectLink, List<String> requirements) {
        this.projectId = projectId;
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.projectName = projectName;
        this.projectDesc = projectDesc;
        this.projectLink = projectLink;
        this.requirements = requirements;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    public String getProjectLink() {
        return projectLink;
    }

    public void setProjectLink(String projectLink) {
        this.projectLink = projectLink;
    }

    public List<String> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<String> requirements) {
        this.requirements = requirements;
    }
}
