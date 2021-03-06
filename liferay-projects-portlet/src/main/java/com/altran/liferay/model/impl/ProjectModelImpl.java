package com.altran.liferay.model.impl;

import com.altran.liferay.model.Project;
import com.altran.liferay.model.ProjectModel;
import com.altran.liferay.model.ProjectSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Project service. Represents a row in the &quot;project_Project&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.altran.liferay.model.ProjectModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProjectImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectImpl
 * @see com.altran.liferay.model.Project
 * @see com.altran.liferay.model.ProjectModel
 * @generated
 */
@JSON(strict = true)
public class ProjectModelImpl extends BaseModelImpl<Project>
    implements ProjectModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a project model instance should use the {@link com.altran.liferay.model.Project} interface instead.
     */
    public static final String TABLE_NAME = "project_Project";
    public static final Object[][] TABLE_COLUMNS = {
            { "uuid_", Types.VARCHAR },
            { "projectId", Types.BIGINT },
            { "groupId", Types.BIGINT },
            { "companyId", Types.BIGINT },
            { "userId", Types.BIGINT },
            { "userName", Types.VARCHAR },
            { "createDate", Types.TIMESTAMP },
            { "modifiedDate", Types.TIMESTAMP },
            { "title", Types.VARCHAR },
            { "description", Types.VARCHAR },
            { "director", Types.VARCHAR },
            { "isPublic", Types.BOOLEAN },
            { "people", Types.INTEGER },
            { "fromDate", Types.TIMESTAMP },
            { "toDate", Types.TIMESTAMP },
            { "comments", Types.VARCHAR }
        };
    public static final String TABLE_SQL_CREATE = "create table project_Project (uuid_ VARCHAR(75) null,projectId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,title VARCHAR(75) null,description VARCHAR(75) null,director VARCHAR(75) null,isPublic BOOLEAN,people INTEGER,fromDate DATE null,toDate DATE null,comments VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table project_Project";
    public static final String ORDER_BY_JPQL = " ORDER BY project.title ASC";
    public static final String ORDER_BY_SQL = " ORDER BY project_Project.title ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.altran.liferay.model.Project"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.altran.liferay.model.Project"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.altran.liferay.model.Project"),
            true);
    public static long COMPANYID_COLUMN_BITMASK = 1L;
    public static long DIRECTOR_COLUMN_BITMASK = 2L;
    public static long GROUPID_COLUMN_BITMASK = 4L;
    public static long UUID_COLUMN_BITMASK = 8L;
    public static long TITLE_COLUMN_BITMASK = 16L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.altran.liferay.model.Project"));
    private static ClassLoader _classLoader = Project.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            Project.class
        };
    private String _uuid;
    private String _originalUuid;
    private long _projectId;
    private long _groupId;
    private long _originalGroupId;
    private boolean _setOriginalGroupId;
    private long _companyId;
    private long _originalCompanyId;
    private boolean _setOriginalCompanyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _title;
    private String _description;
    private String _director;
    private String _originalDirector;
    private boolean _isPublic;
    private int _people;
    private Date _fromDate;
    private Date _toDate;
    private String _comments;
    private long _columnBitmask;
    private Project _escapedModel;

    public ProjectModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static Project toModel(ProjectSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        Project model = new ProjectImpl();

        model.setUuid(soapModel.getUuid());
        model.setProjectId(soapModel.getProjectId());
        model.setGroupId(soapModel.getGroupId());
        model.setCompanyId(soapModel.getCompanyId());
        model.setUserId(soapModel.getUserId());
        model.setUserName(soapModel.getUserName());
        model.setCreateDate(soapModel.getCreateDate());
        model.setModifiedDate(soapModel.getModifiedDate());
        model.setTitle(soapModel.getTitle());
        model.setDescription(soapModel.getDescription());
        model.setDirector(soapModel.getDirector());
        model.setIsPublic(soapModel.getIsPublic());
        model.setPeople(soapModel.getPeople());
        model.setFromDate(soapModel.getFromDate());
        model.setToDate(soapModel.getToDate());
        model.setComments(soapModel.getComments());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<Project> toModels(ProjectSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<Project> models = new ArrayList<Project>(soapModels.length);

        for (ProjectSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
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

    @JSON
    @Override
    public String getUuid() {
        if (_uuid == null) {
            return StringPool.BLANK;
        } else {
            return _uuid;
        }
    }

    @Override
    public void setUuid(String uuid) {
        if (_originalUuid == null) {
            _originalUuid = _uuid;
        }

        _uuid = uuid;
    }

    public String getOriginalUuid() {
        return GetterUtil.getString(_originalUuid);
    }

    @JSON
    @Override
    public long getProjectId() {
        return _projectId;
    }

    @Override
    public void setProjectId(long projectId) {
        _projectId = projectId;
    }

    @JSON
    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _columnBitmask |= GROUPID_COLUMN_BITMASK;

        if (!_setOriginalGroupId) {
            _setOriginalGroupId = true;

            _originalGroupId = _groupId;
        }

        _groupId = groupId;
    }

    public long getOriginalGroupId() {
        return _originalGroupId;
    }

    @JSON
    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _columnBitmask |= COMPANYID_COLUMN_BITMASK;

        if (!_setOriginalCompanyId) {
            _setOriginalCompanyId = true;

            _originalCompanyId = _companyId;
        }

        _companyId = companyId;
    }

    public long getOriginalCompanyId() {
        return _originalCompanyId;
    }

    @JSON
    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @JSON
    @Override
    public String getUserName() {
        if (_userName == null) {
            return StringPool.BLANK;
        } else {
            return _userName;
        }
    }

    @Override
    public void setUserName(String userName) {
        _userName = userName;
    }

    @JSON
    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    @JSON
    @Override
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    @JSON
    @Override
    public String getTitle() {
        if (_title == null) {
            return StringPool.BLANK;
        } else {
            return _title;
        }
    }

    @Override
    public void setTitle(String title) {
        _columnBitmask = -1L;

        _title = title;
    }

    @JSON
    @Override
    public String getDescription() {
        if (_description == null) {
            return StringPool.BLANK;
        } else {
            return _description;
        }
    }

    @Override
    public void setDescription(String description) {
        _description = description;
    }

    @JSON
    @Override
    public String getDirector() {
        if (_director == null) {
            return StringPool.BLANK;
        } else {
            return _director;
        }
    }

    @Override
    public void setDirector(String director) {
        _columnBitmask |= DIRECTOR_COLUMN_BITMASK;

        if (_originalDirector == null) {
            _originalDirector = _director;
        }

        _director = director;
    }

    public String getOriginalDirector() {
        return GetterUtil.getString(_originalDirector);
    }

    @JSON
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
    }

    @JSON
    @Override
    public int getPeople() {
        return _people;
    }

    @Override
    public void setPeople(int people) {
        _people = people;
    }

    @JSON
    @Override
    public Date getFromDate() {
        return _fromDate;
    }

    @Override
    public void setFromDate(Date fromDate) {
        _fromDate = fromDate;
    }

    @JSON
    @Override
    public Date getToDate() {
        return _toDate;
    }

    @Override
    public void setToDate(Date toDate) {
        _toDate = toDate;
    }

    @JSON
    @Override
    public String getComments() {
        if (_comments == null) {
            return StringPool.BLANK;
        } else {
            return _comments;
        }
    }

    @Override
    public void setComments(String comments) {
        _comments = comments;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return new StagedModelType(PortalUtil.getClassNameId(
                Project.class.getName()));
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
            Project.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public Project toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (Project) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        ProjectImpl projectImpl = new ProjectImpl();

        projectImpl.setUuid(getUuid());
        projectImpl.setProjectId(getProjectId());
        projectImpl.setGroupId(getGroupId());
        projectImpl.setCompanyId(getCompanyId());
        projectImpl.setUserId(getUserId());
        projectImpl.setUserName(getUserName());
        projectImpl.setCreateDate(getCreateDate());
        projectImpl.setModifiedDate(getModifiedDate());
        projectImpl.setTitle(getTitle());
        projectImpl.setDescription(getDescription());
        projectImpl.setDirector(getDirector());
        projectImpl.setIsPublic(getIsPublic());
        projectImpl.setPeople(getPeople());
        projectImpl.setFromDate(getFromDate());
        projectImpl.setToDate(getToDate());
        projectImpl.setComments(getComments());

        projectImpl.resetOriginalValues();

        return projectImpl;
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

        if (!(obj instanceof Project)) {
            return false;
        }

        Project project = (Project) obj;

        long primaryKey = project.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
        ProjectModelImpl projectModelImpl = this;

        projectModelImpl._originalUuid = projectModelImpl._uuid;

        projectModelImpl._originalGroupId = projectModelImpl._groupId;

        projectModelImpl._setOriginalGroupId = false;

        projectModelImpl._originalCompanyId = projectModelImpl._companyId;

        projectModelImpl._setOriginalCompanyId = false;

        projectModelImpl._originalDirector = projectModelImpl._director;

        projectModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<Project> toCacheModel() {
        ProjectCacheModel projectCacheModel = new ProjectCacheModel();

        projectCacheModel.uuid = getUuid();

        String uuid = projectCacheModel.uuid;

        if ((uuid != null) && (uuid.length() == 0)) {
            projectCacheModel.uuid = null;
        }

        projectCacheModel.projectId = getProjectId();

        projectCacheModel.groupId = getGroupId();

        projectCacheModel.companyId = getCompanyId();

        projectCacheModel.userId = getUserId();

        projectCacheModel.userName = getUserName();

        String userName = projectCacheModel.userName;

        if ((userName != null) && (userName.length() == 0)) {
            projectCacheModel.userName = null;
        }

        Date createDate = getCreateDate();

        if (createDate != null) {
            projectCacheModel.createDate = createDate.getTime();
        } else {
            projectCacheModel.createDate = Long.MIN_VALUE;
        }

        Date modifiedDate = getModifiedDate();

        if (modifiedDate != null) {
            projectCacheModel.modifiedDate = modifiedDate.getTime();
        } else {
            projectCacheModel.modifiedDate = Long.MIN_VALUE;
        }

        projectCacheModel.title = getTitle();

        String title = projectCacheModel.title;

        if ((title != null) && (title.length() == 0)) {
            projectCacheModel.title = null;
        }

        projectCacheModel.description = getDescription();

        String description = projectCacheModel.description;

        if ((description != null) && (description.length() == 0)) {
            projectCacheModel.description = null;
        }

        projectCacheModel.director = getDirector();

        String director = projectCacheModel.director;

        if ((director != null) && (director.length() == 0)) {
            projectCacheModel.director = null;
        }

        projectCacheModel.isPublic = getIsPublic();

        projectCacheModel.people = getPeople();

        Date fromDate = getFromDate();

        if (fromDate != null) {
            projectCacheModel.fromDate = fromDate.getTime();
        } else {
            projectCacheModel.fromDate = Long.MIN_VALUE;
        }

        Date toDate = getToDate();

        if (toDate != null) {
            projectCacheModel.toDate = toDate.getTime();
        } else {
            projectCacheModel.toDate = Long.MIN_VALUE;
        }

        projectCacheModel.comments = getComments();

        String comments = projectCacheModel.comments;

        if ((comments != null) && (comments.length() == 0)) {
            projectCacheModel.comments = null;
        }

        return projectCacheModel;
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
