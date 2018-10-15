package com.altran.liferay.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Project}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Project
 * @generated
 */
public class ProjectWrapper implements Project, ModelWrapper<Project> {
    private Project _project;

    public ProjectWrapper(Project project) {
        _project = project;
    }

    @Override
    public Class<?> getModelClass() {
        return Project.class;
    }

    @Override
    public String getModelClassName() {
        return Project.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("projectId", getProjectId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("title", getTitle());
        attributes.put("description", getDescription());
        attributes.put("director", getDirector());
        attributes.put("isPublic", getIsPublic());
        attributes.put("people", getPeople());
        attributes.put("fromDate", getFromDate());
        attributes.put("toDate", getToDate());
        attributes.put("comments", getComments());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        Long projectId = (Long) attributes.get("projectId");

        if (projectId != null) {
            setProjectId(projectId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String director = (String) attributes.get("director");

        if (director != null) {
            setDirector(director);
        }

        Boolean isPublic = (Boolean) attributes.get("isPublic");

        if (isPublic != null) {
            setIsPublic(isPublic);
        }

        Integer people = (Integer) attributes.get("people");

        if (people != null) {
            setPeople(people);
        }

        Date fromDate = (Date) attributes.get("fromDate");

        if (fromDate != null) {
            setFromDate(fromDate);
        }

        Date toDate = (Date) attributes.get("toDate");

        if (toDate != null) {
            setToDate(toDate);
        }

        String comments = (String) attributes.get("comments");

        if (comments != null) {
            setComments(comments);
        }
    }

    /**
    * Returns the primary key of this project.
    *
    * @return the primary key of this project
    */
    @Override
    public long getPrimaryKey() {
        return _project.getPrimaryKey();
    }

    /**
    * Sets the primary key of this project.
    *
    * @param primaryKey the primary key of this project
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _project.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this project.
    *
    * @return the uuid of this project
    */
    @Override
    public java.lang.String getUuid() {
        return _project.getUuid();
    }

    /**
    * Sets the uuid of this project.
    *
    * @param uuid the uuid of this project
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _project.setUuid(uuid);
    }

    /**
    * Returns the project ID of this project.
    *
    * @return the project ID of this project
    */
    @Override
    public long getProjectId() {
        return _project.getProjectId();
    }

    /**
    * Sets the project ID of this project.
    *
    * @param projectId the project ID of this project
    */
    @Override
    public void setProjectId(long projectId) {
        _project.setProjectId(projectId);
    }

    /**
    * Returns the group ID of this project.
    *
    * @return the group ID of this project
    */
    @Override
    public long getGroupId() {
        return _project.getGroupId();
    }

    /**
    * Sets the group ID of this project.
    *
    * @param groupId the group ID of this project
    */
    @Override
    public void setGroupId(long groupId) {
        _project.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this project.
    *
    * @return the company ID of this project
    */
    @Override
    public long getCompanyId() {
        return _project.getCompanyId();
    }

    /**
    * Sets the company ID of this project.
    *
    * @param companyId the company ID of this project
    */
    @Override
    public void setCompanyId(long companyId) {
        _project.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this project.
    *
    * @return the user ID of this project
    */
    @Override
    public long getUserId() {
        return _project.getUserId();
    }

    /**
    * Sets the user ID of this project.
    *
    * @param userId the user ID of this project
    */
    @Override
    public void setUserId(long userId) {
        _project.setUserId(userId);
    }

    /**
    * Returns the user uuid of this project.
    *
    * @return the user uuid of this project
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _project.getUserUuid();
    }

    /**
    * Sets the user uuid of this project.
    *
    * @param userUuid the user uuid of this project
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _project.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this project.
    *
    * @return the user name of this project
    */
    @Override
    public java.lang.String getUserName() {
        return _project.getUserName();
    }

    /**
    * Sets the user name of this project.
    *
    * @param userName the user name of this project
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _project.setUserName(userName);
    }

    /**
    * Returns the create date of this project.
    *
    * @return the create date of this project
    */
    @Override
    public java.util.Date getCreateDate() {
        return _project.getCreateDate();
    }

    /**
    * Sets the create date of this project.
    *
    * @param createDate the create date of this project
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _project.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this project.
    *
    * @return the modified date of this project
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _project.getModifiedDate();
    }

    /**
    * Sets the modified date of this project.
    *
    * @param modifiedDate the modified date of this project
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _project.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the title of this project.
    *
    * @return the title of this project
    */
    @Override
    public java.lang.String getTitle() {
        return _project.getTitle();
    }

    /**
    * Sets the title of this project.
    *
    * @param title the title of this project
    */
    @Override
    public void setTitle(java.lang.String title) {
        _project.setTitle(title);
    }

    /**
    * Returns the description of this project.
    *
    * @return the description of this project
    */
    @Override
    public java.lang.String getDescription() {
        return _project.getDescription();
    }

    /**
    * Sets the description of this project.
    *
    * @param description the description of this project
    */
    @Override
    public void setDescription(java.lang.String description) {
        _project.setDescription(description);
    }

    /**
    * Returns the director of this project.
    *
    * @return the director of this project
    */
    @Override
    public java.lang.String getDirector() {
        return _project.getDirector();
    }

    /**
    * Sets the director of this project.
    *
    * @param director the director of this project
    */
    @Override
    public void setDirector(java.lang.String director) {
        _project.setDirector(director);
    }

    /**
    * Returns the is public of this project.
    *
    * @return the is public of this project
    */
    @Override
    public boolean getIsPublic() {
        return _project.getIsPublic();
    }

    /**
    * Returns <code>true</code> if this project is is public.
    *
    * @return <code>true</code> if this project is is public; <code>false</code> otherwise
    */
    @Override
    public boolean isIsPublic() {
        return _project.isIsPublic();
    }

    /**
    * Sets whether this project is is public.
    *
    * @param isPublic the is public of this project
    */
    @Override
    public void setIsPublic(boolean isPublic) {
        _project.setIsPublic(isPublic);
    }

    /**
    * Returns the people of this project.
    *
    * @return the people of this project
    */
    @Override
    public int getPeople() {
        return _project.getPeople();
    }

    /**
    * Sets the people of this project.
    *
    * @param people the people of this project
    */
    @Override
    public void setPeople(int people) {
        _project.setPeople(people);
    }

    /**
    * Returns the from date of this project.
    *
    * @return the from date of this project
    */
    @Override
    public java.util.Date getFromDate() {
        return _project.getFromDate();
    }

    /**
    * Sets the from date of this project.
    *
    * @param fromDate the from date of this project
    */
    @Override
    public void setFromDate(java.util.Date fromDate) {
        _project.setFromDate(fromDate);
    }

    /**
    * Returns the to date of this project.
    *
    * @return the to date of this project
    */
    @Override
    public java.util.Date getToDate() {
        return _project.getToDate();
    }

    /**
    * Sets the to date of this project.
    *
    * @param toDate the to date of this project
    */
    @Override
    public void setToDate(java.util.Date toDate) {
        _project.setToDate(toDate);
    }

    /**
    * Returns the comments of this project.
    *
    * @return the comments of this project
    */
    @Override
    public java.lang.String getComments() {
        return _project.getComments();
    }

    /**
    * Sets the comments of this project.
    *
    * @param comments the comments of this project
    */
    @Override
    public void setComments(java.lang.String comments) {
        _project.setComments(comments);
    }

    @Override
    public boolean isNew() {
        return _project.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _project.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _project.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _project.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _project.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _project.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _project.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _project.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _project.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _project.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _project.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ProjectWrapper((Project) _project.clone());
    }

    @Override
    public int compareTo(com.altran.liferay.model.Project project) {
        return _project.compareTo(project);
    }

    @Override
    public int hashCode() {
        return _project.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.altran.liferay.model.Project> toCacheModel() {
        return _project.toCacheModel();
    }

    @Override
    public com.altran.liferay.model.Project toEscapedModel() {
        return new ProjectWrapper(_project.toEscapedModel());
    }

    @Override
    public com.altran.liferay.model.Project toUnescapedModel() {
        return new ProjectWrapper(_project.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _project.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _project.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _project.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ProjectWrapper)) {
            return false;
        }

        ProjectWrapper projectWrapper = (ProjectWrapper) obj;

        if (Validator.equals(_project, projectWrapper._project)) {
            return true;
        }

        return false;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return _project.getStagedModelType();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Project getWrappedProject() {
        return _project;
    }

    @Override
    public Project getWrappedModel() {
        return _project;
    }

    @Override
    public void resetOriginalValues() {
        _project.resetOriginalValues();
    }
}
