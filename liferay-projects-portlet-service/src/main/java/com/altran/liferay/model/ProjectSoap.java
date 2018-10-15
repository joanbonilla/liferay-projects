package com.altran.liferay.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.altran.liferay.service.http.ProjectServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.altran.liferay.service.http.ProjectServiceSoap
 * @generated
 */
public class ProjectSoap implements Serializable {
    private String _uuid;
    private long _projectId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _title;
    private String _description;
    private String _director;
    private boolean _isPublic;
    private int _people;
    private Date _fromDate;
    private Date _toDate;
    private String _comments;

    public ProjectSoap() {
    }

    public static ProjectSoap toSoapModel(Project model) {
        ProjectSoap soapModel = new ProjectSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setProjectId(model.getProjectId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setTitle(model.getTitle());
        soapModel.setDescription(model.getDescription());
        soapModel.setDirector(model.getDirector());
        soapModel.setIsPublic(model.getIsPublic());
        soapModel.setPeople(model.getPeople());
        soapModel.setFromDate(model.getFromDate());
        soapModel.setToDate(model.getToDate());
        soapModel.setComments(model.getComments());

        return soapModel;
    }

    public static ProjectSoap[] toSoapModels(Project[] models) {
        ProjectSoap[] soapModels = new ProjectSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ProjectSoap[][] toSoapModels(Project[][] models) {
        ProjectSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ProjectSoap[models.length][models[0].length];
        } else {
            soapModels = new ProjectSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ProjectSoap[] toSoapModels(List<Project> models) {
        List<ProjectSoap> soapModels = new ArrayList<ProjectSoap>(models.size());

        for (Project model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ProjectSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _projectId;
    }

    public void setPrimaryKey(long pk) {
        setProjectId(pk);
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public long getProjectId() {
        return _projectId;
    }

    public void setProjectId(long projectId) {
        _projectId = projectId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String userName) {
        _userName = userName;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getDirector() {
        return _director;
    }

    public void setDirector(String director) {
        _director = director;
    }

    public boolean getIsPublic() {
        return _isPublic;
    }

    public boolean isIsPublic() {
        return _isPublic;
    }

    public void setIsPublic(boolean isPublic) {
        _isPublic = isPublic;
    }

    public int getPeople() {
        return _people;
    }

    public void setPeople(int people) {
        _people = people;
    }

    public Date getFromDate() {
        return _fromDate;
    }

    public void setFromDate(Date fromDate) {
        _fromDate = fromDate;
    }

    public Date getToDate() {
        return _toDate;
    }

    public void setToDate(Date toDate) {
        _toDate = toDate;
    }

    public String getComments() {
        return _comments;
    }

    public void setComments(String comments) {
        _comments = comments;
    }
}
