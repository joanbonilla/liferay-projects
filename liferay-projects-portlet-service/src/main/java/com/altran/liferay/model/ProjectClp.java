package com.altran.liferay.model;

import com.altran.liferay.service.ClpSerializer;
import com.altran.liferay.service.ProjectLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class ProjectClp extends BaseModelImpl<Project> implements Project {
    private String _uuid;
    private long _projectId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
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
    private BaseModel<?> _projectRemoteModel;
    private Class<?> _clpSerializerClass = com.altran.liferay.service.ClpSerializer.class;

    public ProjectClp() {
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
    public long getPrimaryKey() {
        return _projectId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setProjectId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _projectId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public String getUuid() {
        return _uuid;
    }

    @Override
    public void setUuid(String uuid) {
        _uuid = uuid;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setUuid", String.class);

                method.invoke(_projectRemoteModel, uuid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getProjectId() {
        return _projectId;
    }

    @Override
    public void setProjectId(long projectId) {
        _projectId = projectId;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setProjectId", long.class);

                method.invoke(_projectRemoteModel, projectId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_projectRemoteModel, groupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_projectRemoteModel, companyId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_projectRemoteModel, userId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @Override
    public String getUserName() {
        return _userName;
    }

    @Override
    public void setUserName(String userName) {
        _userName = userName;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setUserName", String.class);

                method.invoke(_projectRemoteModel, userName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_projectRemoteModel, createDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_projectRemoteModel, modifiedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTitle() {
        return _title;
    }

    @Override
    public void setTitle(String title) {
        _title = title;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setTitle", String.class);

                method.invoke(_projectRemoteModel, title);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDescription() {
        return _description;
    }

    @Override
    public void setDescription(String description) {
        _description = description;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_projectRemoteModel, description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDirector() {
        return _director;
    }

    @Override
    public void setDirector(String director) {
        _director = director;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setDirector", String.class);

                method.invoke(_projectRemoteModel, director);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getIsPublic() {
        return _isPublic;
    }

    @Override
    public boolean isIsPublic() {
        return _isPublic;
    }

    @Override
    public void setIsPublic(boolean isPublic) {
        _isPublic = isPublic;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setIsPublic", boolean.class);

                method.invoke(_projectRemoteModel, isPublic);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getPeople() {
        return _people;
    }

    @Override
    public void setPeople(int people) {
        _people = people;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setPeople", int.class);

                method.invoke(_projectRemoteModel, people);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getFromDate() {
        return _fromDate;
    }

    @Override
    public void setFromDate(Date fromDate) {
        _fromDate = fromDate;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setFromDate", Date.class);

                method.invoke(_projectRemoteModel, fromDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getToDate() {
        return _toDate;
    }

    @Override
    public void setToDate(Date toDate) {
        _toDate = toDate;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setToDate", Date.class);

                method.invoke(_projectRemoteModel, toDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getComments() {
        return _comments;
    }

    @Override
    public void setComments(String comments) {
        _comments = comments;

        if (_projectRemoteModel != null) {
            try {
                Class<?> clazz = _projectRemoteModel.getClass();

                Method method = clazz.getMethod("setComments", String.class);

                method.invoke(_projectRemoteModel, comments);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public StagedModelType getStagedModelType() {
        return new StagedModelType(PortalUtil.getClassNameId(
                Project.class.getName()));
    }

    public BaseModel<?> getProjectRemoteModel() {
        return _projectRemoteModel;
    }

    public void setProjectRemoteModel(BaseModel<?> projectRemoteModel) {
        _projectRemoteModel = projectRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _projectRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_projectRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ProjectLocalServiceUtil.addProject(this);
        } else {
            ProjectLocalServiceUtil.updateProject(this);
        }
    }

    @Override
    public Project toEscapedModel() {
        return (Project) ProxyUtil.newProxyInstance(Project.class.getClassLoader(),
            new Class[] { Project.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ProjectClp clone = new ProjectClp();

        clone.setUuid(getUuid());
        clone.setProjectId(getProjectId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setTitle(getTitle());
        clone.setDescription(getDescription());
        clone.setDirector(getDirector());
        clone.setIsPublic(getIsPublic());
        clone.setPeople(getPeople());
        clone.setFromDate(getFromDate());
        clone.setToDate(getToDate());
        clone.setComments(getComments());

        return clone;
    }

    @Override
    public int compareTo(Project project) {
        int value = 0;

        value = getTitle().compareTo(project.getTitle());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ProjectClp)) {
            return false;
        }

        ProjectClp project = (ProjectClp) obj;

        long primaryKey = project.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(33);

        sb.append("{uuid=");
        sb.append(getUuid());
        sb.append(", projectId=");
        sb.append(getProjectId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", userName=");
        sb.append(getUserName());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", director=");
        sb.append(getDirector());
        sb.append(", isPublic=");
        sb.append(getIsPublic());
        sb.append(", people=");
        sb.append(getPeople());
        sb.append(", fromDate=");
        sb.append(getFromDate());
        sb.append(", toDate=");
        sb.append(getToDate());
        sb.append(", comments=");
        sb.append(getComments());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(52);

        sb.append("<model><model-name>");
        sb.append("com.altran.liferay.model.Project");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>uuid</column-name><column-value><![CDATA[");
        sb.append(getUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>projectId</column-name><column-value><![CDATA[");
        sb.append(getProjectId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userName</column-name><column-value><![CDATA[");
        sb.append(getUserName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
        sb.append(getModifiedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>title</column-name><column-value><![CDATA[");
        sb.append(getTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>director</column-name><column-value><![CDATA[");
        sb.append(getDirector());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>isPublic</column-name><column-value><![CDATA[");
        sb.append(getIsPublic());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>people</column-name><column-value><![CDATA[");
        sb.append(getPeople());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fromDate</column-name><column-value><![CDATA[");
        sb.append(getFromDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>toDate</column-name><column-value><![CDATA[");
        sb.append(getToDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>comments</column-name><column-value><![CDATA[");
        sb.append(getComments());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
