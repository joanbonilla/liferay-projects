package com.altran.liferay.service.persistence;

import com.altran.liferay.NoSuchProjectException;
import com.altran.liferay.model.Project;
import com.altran.liferay.model.impl.ProjectImpl;
import com.altran.liferay.model.impl.ProjectModelImpl;
import com.altran.liferay.service.persistence.ProjectPersistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the project service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectPersistence
 * @see ProjectUtil
 * @generated
 */
public class ProjectPersistenceImpl extends BasePersistenceImpl<Project>
    implements ProjectPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ProjectUtil} to access the project persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ProjectImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
            ProjectModelImpl.FINDER_CACHE_ENABLED, ProjectImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
            ProjectModelImpl.FINDER_CACHE_ENABLED, ProjectImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
            ProjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
            ProjectModelImpl.FINDER_CACHE_ENABLED, ProjectImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
            ProjectModelImpl.FINDER_CACHE_ENABLED, ProjectImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
            new String[] { String.class.getName() },
            ProjectModelImpl.UUID_COLUMN_BITMASK |
            ProjectModelImpl.TITLE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
            ProjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "project.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "project.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(project.uuid IS NULL OR project.uuid = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
            ProjectModelImpl.FINDER_CACHE_ENABLED, ProjectImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() },
            ProjectModelImpl.UUID_COLUMN_BITMASK |
            ProjectModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
            ProjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "project.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "project.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(project.uuid IS NULL OR project.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "project.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
            ProjectModelImpl.FINDER_CACHE_ENABLED, ProjectImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
            new String[] {
                String.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
        new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
            ProjectModelImpl.FINDER_CACHE_ENABLED, ProjectImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() },
            ProjectModelImpl.UUID_COLUMN_BITMASK |
            ProjectModelImpl.COMPANYID_COLUMN_BITMASK |
            ProjectModelImpl.TITLE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
            ProjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "project.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "project.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(project.uuid IS NULL OR project.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "project.companyId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DIRECTOR = new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
            ProjectModelImpl.FINDER_CACHE_ENABLED, ProjectImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDirector",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DIRECTOR =
        new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
            ProjectModelImpl.FINDER_CACHE_ENABLED, ProjectImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDirector",
            new String[] { String.class.getName() },
            ProjectModelImpl.DIRECTOR_COLUMN_BITMASK |
            ProjectModelImpl.TITLE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_DIRECTOR = new FinderPath(ProjectModelImpl.ENTITY_CACHE_ENABLED,
            ProjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDirector",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_DIRECTOR_DIRECTOR_1 = "project.director IS NULL";
    private static final String _FINDER_COLUMN_DIRECTOR_DIRECTOR_2 = "project.director = ?";
    private static final String _FINDER_COLUMN_DIRECTOR_DIRECTOR_3 = "(project.director IS NULL OR project.director = '')";
    private static final String _SQL_SELECT_PROJECT = "SELECT project FROM Project project";
    private static final String _SQL_SELECT_PROJECT_WHERE = "SELECT project FROM Project project WHERE ";
    private static final String _SQL_COUNT_PROJECT = "SELECT COUNT(project) FROM Project project";
    private static final String _SQL_COUNT_PROJECT_WHERE = "SELECT COUNT(project) FROM Project project WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "project.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Project exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Project exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ProjectPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "uuid"
            });
    private static Project _nullProject = new ProjectImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Project> toCacheModel() {
                return _nullProjectCacheModel;
            }
        };

    private static CacheModel<Project> _nullProjectCacheModel = new CacheModel<Project>() {
            @Override
            public Project toEntityModel() {
                return _nullProject;
            }
        };

    public ProjectPersistenceImpl() {
        setModelClass(Project.class);
    }

    /**
     * Returns all the projects where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the matching projects
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Project> findByUuid(String uuid) throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the projects where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.altran.liferay.model.impl.ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of projects
     * @param end the upper bound of the range of projects (not inclusive)
     * @return the range of matching projects
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Project> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
    }

    /**
     * Returns an ordered range of all the projects where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.altran.liferay.model.impl.ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of projects
     * @param end the upper bound of the range of projects (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching projects
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Project> findByUuid(String uuid, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid, start, end, orderByComparator };
        }

        List<Project> list = (List<Project>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Project project : list) {
                if (!Validator.equals(uuid, project.getUuid())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_PROJECT_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ProjectModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                if (!pagination) {
                    list = (List<Project>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Project>(list);
                } else {
                    list = (List<Project>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first project in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching project
     * @throws com.altran.liferay.NoSuchProjectException if a matching project could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Project findByUuid_First(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchProjectException, SystemException {
        Project project = fetchByUuid_First(uuid, orderByComparator);

        if (project != null) {
            return project;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchProjectException(msg.toString());
    }

    /**
     * Returns the first project in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching project, or <code>null</code> if a matching project could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Project fetchByUuid_First(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        List<Project> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last project in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching project
     * @throws com.altran.liferay.NoSuchProjectException if a matching project could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Project findByUuid_Last(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchProjectException, SystemException {
        Project project = fetchByUuid_Last(uuid, orderByComparator);

        if (project != null) {
            return project;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchProjectException(msg.toString());
    }

    /**
     * Returns the last project in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching project, or <code>null</code> if a matching project could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Project fetchByUuid_Last(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid(uuid);

        if (count == 0) {
            return null;
        }

        List<Project> list = findByUuid(uuid, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the projects before and after the current project in the ordered set where uuid = &#63;.
     *
     * @param projectId the primary key of the current project
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next project
     * @throws com.altran.liferay.NoSuchProjectException if a project with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Project[] findByUuid_PrevAndNext(long projectId, String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchProjectException, SystemException {
        Project project = findByPrimaryKey(projectId);

        Session session = null;

        try {
            session = openSession();

            Project[] array = new ProjectImpl[3];

            array[0] = getByUuid_PrevAndNext(session, project, uuid,
                    orderByComparator, true);

            array[1] = project;

            array[2] = getByUuid_PrevAndNext(session, project, uuid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Project getByUuid_PrevAndNext(Session session, Project project,
        String uuid, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PROJECT_WHERE);

        boolean bindUuid = false;

        if (uuid == null) {
            query.append(_FINDER_COLUMN_UUID_UUID_1);
        } else if (uuid.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_UUID_UUID_3);
        } else {
            bindUuid = true;

            query.append(_FINDER_COLUMN_UUID_UUID_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(ProjectModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindUuid) {
            qPos.add(uuid);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(project);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Project> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the projects where uuid = &#63; from the database.
     *
     * @param uuid the uuid
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid(String uuid) throws SystemException {
        for (Project project : findByUuid(uuid, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(project);
        }
    }

    /**
     * Returns the number of projects where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the number of matching projects
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUuid(String uuid) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

        Object[] finderArgs = new Object[] { uuid };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_PROJECT_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the project where uuid = &#63; and groupId = &#63; or throws a {@link com.altran.liferay.NoSuchProjectException} if it could not be found.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching project
     * @throws com.altran.liferay.NoSuchProjectException if a matching project could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Project findByUUID_G(String uuid, long groupId)
        throws NoSuchProjectException, SystemException {
        Project project = fetchByUUID_G(uuid, groupId);

        if (project == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("uuid=");
            msg.append(uuid);

            msg.append(", groupId=");
            msg.append(groupId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchProjectException(msg.toString());
        }

        return project;
    }

    /**
     * Returns the project where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching project, or <code>null</code> if a matching project could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Project fetchByUUID_G(String uuid, long groupId)
        throws SystemException {
        return fetchByUUID_G(uuid, groupId, true);
    }

    /**
     * Returns the project where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching project, or <code>null</code> if a matching project could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Project fetchByUUID_G(String uuid, long groupId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { uuid, groupId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs, this);
        }

        if (result instanceof Project) {
            Project project = (Project) result;

            if (!Validator.equals(uuid, project.getUuid()) ||
                    (groupId != project.getGroupId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_PROJECT_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_G_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(groupId);

                List<Project> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                        finderArgs, list);
                } else {
                    Project project = list.get(0);

                    result = project;

                    cacheResult(project);

                    if ((project.getUuid() == null) ||
                            !project.getUuid().equals(uuid) ||
                            (project.getGroupId() != groupId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                            finderArgs, project);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (Project) result;
        }
    }

    /**
     * Removes the project where uuid = &#63; and groupId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the project that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Project removeByUUID_G(String uuid, long groupId)
        throws NoSuchProjectException, SystemException {
        Project project = findByUUID_G(uuid, groupId);

        return remove(project);
    }

    /**
     * Returns the number of projects where uuid = &#63; and groupId = &#63;.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the number of matching projects
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUUID_G(String uuid, long groupId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

        Object[] finderArgs = new Object[] { uuid, groupId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_PROJECT_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_G_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(groupId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the projects where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the matching projects
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Project> findByUuid_C(String uuid, long companyId)
        throws SystemException {
        return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the projects where uuid = &#63; and companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.altran.liferay.model.impl.ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param start the lower bound of the range of projects
     * @param end the upper bound of the range of projects (not inclusive)
     * @return the range of matching projects
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Project> findByUuid_C(String uuid, long companyId, int start,
        int end) throws SystemException {
        return findByUuid_C(uuid, companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the projects where uuid = &#63; and companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.altran.liferay.model.impl.ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param start the lower bound of the range of projects
     * @param end the upper bound of the range of projects (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching projects
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Project> findByUuid_C(String uuid, long companyId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
            finderArgs = new Object[] { uuid, companyId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
            finderArgs = new Object[] {
                    uuid, companyId,
                    
                    start, end, orderByComparator
                };
        }

        List<Project> list = (List<Project>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Project project : list) {
                if (!Validator.equals(uuid, project.getUuid()) ||
                        (companyId != project.getCompanyId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_PROJECT_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_C_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ProjectModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(companyId);

                if (!pagination) {
                    list = (List<Project>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Project>(list);
                } else {
                    list = (List<Project>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first project in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching project
     * @throws com.altran.liferay.NoSuchProjectException if a matching project could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Project findByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchProjectException, SystemException {
        Project project = fetchByUuid_C_First(uuid, companyId, orderByComparator);

        if (project != null) {
            return project;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchProjectException(msg.toString());
    }

    /**
     * Returns the first project in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching project, or <code>null</code> if a matching project could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Project fetchByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Project> list = findByUuid_C(uuid, companyId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last project in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching project
     * @throws com.altran.liferay.NoSuchProjectException if a matching project could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Project findByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchProjectException, SystemException {
        Project project = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

        if (project != null) {
            return project;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchProjectException(msg.toString());
    }

    /**
     * Returns the last project in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching project, or <code>null</code> if a matching project could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Project fetchByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid_C(uuid, companyId);

        if (count == 0) {
            return null;
        }

        List<Project> list = findByUuid_C(uuid, companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the projects before and after the current project in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param projectId the primary key of the current project
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next project
     * @throws com.altran.liferay.NoSuchProjectException if a project with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Project[] findByUuid_C_PrevAndNext(long projectId, String uuid,
        long companyId, OrderByComparator orderByComparator)
        throws NoSuchProjectException, SystemException {
        Project project = findByPrimaryKey(projectId);

        Session session = null;

        try {
            session = openSession();

            Project[] array = new ProjectImpl[3];

            array[0] = getByUuid_C_PrevAndNext(session, project, uuid,
                    companyId, orderByComparator, true);

            array[1] = project;

            array[2] = getByUuid_C_PrevAndNext(session, project, uuid,
                    companyId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Project getByUuid_C_PrevAndNext(Session session, Project project,
        String uuid, long companyId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PROJECT_WHERE);

        boolean bindUuid = false;

        if (uuid == null) {
            query.append(_FINDER_COLUMN_UUID_C_UUID_1);
        } else if (uuid.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_UUID_C_UUID_3);
        } else {
            bindUuid = true;

            query.append(_FINDER_COLUMN_UUID_C_UUID_2);
        }

        query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(ProjectModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindUuid) {
            qPos.add(uuid);
        }

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(project);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Project> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the projects where uuid = &#63; and companyId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid_C(String uuid, long companyId)
        throws SystemException {
        for (Project project : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(project);
        }
    }

    /**
     * Returns the number of projects where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the number of matching projects
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUuid_C(String uuid, long companyId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

        Object[] finderArgs = new Object[] { uuid, companyId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_PROJECT_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_C_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(companyId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the projects where director = &#63;.
     *
     * @param director the director
     * @return the matching projects
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Project> findByDirector(String director)
        throws SystemException {
        return findByDirector(director, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the projects where director = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.altran.liferay.model.impl.ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param director the director
     * @param start the lower bound of the range of projects
     * @param end the upper bound of the range of projects (not inclusive)
     * @return the range of matching projects
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Project> findByDirector(String director, int start, int end)
        throws SystemException {
        return findByDirector(director, start, end, null);
    }

    /**
     * Returns an ordered range of all the projects where director = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.altran.liferay.model.impl.ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param director the director
     * @param start the lower bound of the range of projects
     * @param end the upper bound of the range of projects (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching projects
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Project> findByDirector(String director, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DIRECTOR;
            finderArgs = new Object[] { director };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DIRECTOR;
            finderArgs = new Object[] { director, start, end, orderByComparator };
        }

        List<Project> list = (List<Project>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Project project : list) {
                if (!Validator.equals(director, project.getDirector())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_PROJECT_WHERE);

            boolean bindDirector = false;

            if (director == null) {
                query.append(_FINDER_COLUMN_DIRECTOR_DIRECTOR_1);
            } else if (director.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_DIRECTOR_DIRECTOR_3);
            } else {
                bindDirector = true;

                query.append(_FINDER_COLUMN_DIRECTOR_DIRECTOR_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ProjectModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindDirector) {
                    qPos.add(director);
                }

                if (!pagination) {
                    list = (List<Project>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Project>(list);
                } else {
                    list = (List<Project>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first project in the ordered set where director = &#63;.
     *
     * @param director the director
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching project
     * @throws com.altran.liferay.NoSuchProjectException if a matching project could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Project findByDirector_First(String director,
        OrderByComparator orderByComparator)
        throws NoSuchProjectException, SystemException {
        Project project = fetchByDirector_First(director, orderByComparator);

        if (project != null) {
            return project;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("director=");
        msg.append(director);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchProjectException(msg.toString());
    }

    /**
     * Returns the first project in the ordered set where director = &#63;.
     *
     * @param director the director
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching project, or <code>null</code> if a matching project could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Project fetchByDirector_First(String director,
        OrderByComparator orderByComparator) throws SystemException {
        List<Project> list = findByDirector(director, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last project in the ordered set where director = &#63;.
     *
     * @param director the director
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching project
     * @throws com.altran.liferay.NoSuchProjectException if a matching project could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Project findByDirector_Last(String director,
        OrderByComparator orderByComparator)
        throws NoSuchProjectException, SystemException {
        Project project = fetchByDirector_Last(director, orderByComparator);

        if (project != null) {
            return project;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("director=");
        msg.append(director);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchProjectException(msg.toString());
    }

    /**
     * Returns the last project in the ordered set where director = &#63;.
     *
     * @param director the director
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching project, or <code>null</code> if a matching project could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Project fetchByDirector_Last(String director,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByDirector(director);

        if (count == 0) {
            return null;
        }

        List<Project> list = findByDirector(director, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the projects before and after the current project in the ordered set where director = &#63;.
     *
     * @param projectId the primary key of the current project
     * @param director the director
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next project
     * @throws com.altran.liferay.NoSuchProjectException if a project with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Project[] findByDirector_PrevAndNext(long projectId,
        String director, OrderByComparator orderByComparator)
        throws NoSuchProjectException, SystemException {
        Project project = findByPrimaryKey(projectId);

        Session session = null;

        try {
            session = openSession();

            Project[] array = new ProjectImpl[3];

            array[0] = getByDirector_PrevAndNext(session, project, director,
                    orderByComparator, true);

            array[1] = project;

            array[2] = getByDirector_PrevAndNext(session, project, director,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Project getByDirector_PrevAndNext(Session session,
        Project project, String director, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PROJECT_WHERE);

        boolean bindDirector = false;

        if (director == null) {
            query.append(_FINDER_COLUMN_DIRECTOR_DIRECTOR_1);
        } else if (director.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_DIRECTOR_DIRECTOR_3);
        } else {
            bindDirector = true;

            query.append(_FINDER_COLUMN_DIRECTOR_DIRECTOR_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(ProjectModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindDirector) {
            qPos.add(director);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(project);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Project> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the projects where director = &#63; from the database.
     *
     * @param director the director
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByDirector(String director) throws SystemException {
        for (Project project : findByDirector(director, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(project);
        }
    }

    /**
     * Returns the number of projects where director = &#63;.
     *
     * @param director the director
     * @return the number of matching projects
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByDirector(String director) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_DIRECTOR;

        Object[] finderArgs = new Object[] { director };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_PROJECT_WHERE);

            boolean bindDirector = false;

            if (director == null) {
                query.append(_FINDER_COLUMN_DIRECTOR_DIRECTOR_1);
            } else if (director.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_DIRECTOR_DIRECTOR_3);
            } else {
                bindDirector = true;

                query.append(_FINDER_COLUMN_DIRECTOR_DIRECTOR_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindDirector) {
                    qPos.add(director);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the project in the entity cache if it is enabled.
     *
     * @param project the project
     */
    @Override
    public void cacheResult(Project project) {
        EntityCacheUtil.putResult(ProjectModelImpl.ENTITY_CACHE_ENABLED,
            ProjectImpl.class, project.getPrimaryKey(), project);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
            new Object[] { project.getUuid(), project.getGroupId() }, project);

        project.resetOriginalValues();
    }

    /**
     * Caches the projects in the entity cache if it is enabled.
     *
     * @param projects the projects
     */
    @Override
    public void cacheResult(List<Project> projects) {
        for (Project project : projects) {
            if (EntityCacheUtil.getResult(
                        ProjectModelImpl.ENTITY_CACHE_ENABLED,
                        ProjectImpl.class, project.getPrimaryKey()) == null) {
                cacheResult(project);
            } else {
                project.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all projects.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ProjectImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ProjectImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the project.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Project project) {
        EntityCacheUtil.removeResult(ProjectModelImpl.ENTITY_CACHE_ENABLED,
            ProjectImpl.class, project.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(project);
    }

    @Override
    public void clearCache(List<Project> projects) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Project project : projects) {
            EntityCacheUtil.removeResult(ProjectModelImpl.ENTITY_CACHE_ENABLED,
                ProjectImpl.class, project.getPrimaryKey());

            clearUniqueFindersCache(project);
        }
    }

    protected void cacheUniqueFindersCache(Project project) {
        if (project.isNew()) {
            Object[] args = new Object[] { project.getUuid(), project.getGroupId() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, project);
        } else {
            ProjectModelImpl projectModelImpl = (ProjectModelImpl) project;

            if ((projectModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        project.getUuid(), project.getGroupId()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                    project);
            }
        }
    }

    protected void clearUniqueFindersCache(Project project) {
        ProjectModelImpl projectModelImpl = (ProjectModelImpl) project;

        Object[] args = new Object[] { project.getUuid(), project.getGroupId() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

        if ((projectModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
            args = new Object[] {
                    projectModelImpl.getOriginalUuid(),
                    projectModelImpl.getOriginalGroupId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
        }
    }

    /**
     * Creates a new project with the primary key. Does not add the project to the database.
     *
     * @param projectId the primary key for the new project
     * @return the new project
     */
    @Override
    public Project create(long projectId) {
        Project project = new ProjectImpl();

        project.setNew(true);
        project.setPrimaryKey(projectId);

        String uuid = PortalUUIDUtil.generate();

        project.setUuid(uuid);

        return project;
    }

    /**
     * Removes the project with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param projectId the primary key of the project
     * @return the project that was removed
     * @throws com.altran.liferay.NoSuchProjectException if a project with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Project remove(long projectId)
        throws NoSuchProjectException, SystemException {
        return remove((Serializable) projectId);
    }

    /**
     * Removes the project with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the project
     * @return the project that was removed
     * @throws com.altran.liferay.NoSuchProjectException if a project with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Project remove(Serializable primaryKey)
        throws NoSuchProjectException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Project project = (Project) session.get(ProjectImpl.class,
                    primaryKey);

            if (project == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchProjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(project);
        } catch (NoSuchProjectException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Project removeImpl(Project project) throws SystemException {
        project = toUnwrappedModel(project);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(project)) {
                project = (Project) session.get(ProjectImpl.class,
                        project.getPrimaryKeyObj());
            }

            if (project != null) {
                session.delete(project);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (project != null) {
            clearCache(project);
        }

        return project;
    }

    @Override
    public Project updateImpl(com.altran.liferay.model.Project project)
        throws SystemException {
        project = toUnwrappedModel(project);

        boolean isNew = project.isNew();

        ProjectModelImpl projectModelImpl = (ProjectModelImpl) project;

        if (Validator.isNull(project.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            project.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            if (project.isNew()) {
                session.save(project);

                project.setNew(false);
            } else {
                session.merge(project);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ProjectModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((projectModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { projectModelImpl.getOriginalUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);

                args = new Object[] { projectModelImpl.getUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);
            }

            if ((projectModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        projectModelImpl.getOriginalUuid(),
                        projectModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);

                args = new Object[] {
                        projectModelImpl.getUuid(),
                        projectModelImpl.getCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);
            }

            if ((projectModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DIRECTOR.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        projectModelImpl.getOriginalDirector()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DIRECTOR, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DIRECTOR,
                    args);

                args = new Object[] { projectModelImpl.getDirector() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DIRECTOR, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DIRECTOR,
                    args);
            }
        }

        EntityCacheUtil.putResult(ProjectModelImpl.ENTITY_CACHE_ENABLED,
            ProjectImpl.class, project.getPrimaryKey(), project);

        clearUniqueFindersCache(project);
        cacheUniqueFindersCache(project);

        return project;
    }

    protected Project toUnwrappedModel(Project project) {
        if (project instanceof ProjectImpl) {
            return project;
        }

        ProjectImpl projectImpl = new ProjectImpl();

        projectImpl.setNew(project.isNew());
        projectImpl.setPrimaryKey(project.getPrimaryKey());

        projectImpl.setUuid(project.getUuid());
        projectImpl.setProjectId(project.getProjectId());
        projectImpl.setGroupId(project.getGroupId());
        projectImpl.setCompanyId(project.getCompanyId());
        projectImpl.setUserId(project.getUserId());
        projectImpl.setUserName(project.getUserName());
        projectImpl.setCreateDate(project.getCreateDate());
        projectImpl.setModifiedDate(project.getModifiedDate());
        projectImpl.setTitle(project.getTitle());
        projectImpl.setDescription(project.getDescription());
        projectImpl.setDirector(project.getDirector());
        projectImpl.setIsPublic(project.isIsPublic());
        projectImpl.setPeople(project.getPeople());
        projectImpl.setFromDate(project.getFromDate());
        projectImpl.setToDate(project.getToDate());
        projectImpl.setComments(project.getComments());

        return projectImpl;
    }

    /**
     * Returns the project with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the project
     * @return the project
     * @throws com.altran.liferay.NoSuchProjectException if a project with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Project findByPrimaryKey(Serializable primaryKey)
        throws NoSuchProjectException, SystemException {
        Project project = fetchByPrimaryKey(primaryKey);

        if (project == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchProjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return project;
    }

    /**
     * Returns the project with the primary key or throws a {@link com.altran.liferay.NoSuchProjectException} if it could not be found.
     *
     * @param projectId the primary key of the project
     * @return the project
     * @throws com.altran.liferay.NoSuchProjectException if a project with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Project findByPrimaryKey(long projectId)
        throws NoSuchProjectException, SystemException {
        return findByPrimaryKey((Serializable) projectId);
    }

    /**
     * Returns the project with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the project
     * @return the project, or <code>null</code> if a project with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Project fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Project project = (Project) EntityCacheUtil.getResult(ProjectModelImpl.ENTITY_CACHE_ENABLED,
                ProjectImpl.class, primaryKey);

        if (project == _nullProject) {
            return null;
        }

        if (project == null) {
            Session session = null;

            try {
                session = openSession();

                project = (Project) session.get(ProjectImpl.class, primaryKey);

                if (project != null) {
                    cacheResult(project);
                } else {
                    EntityCacheUtil.putResult(ProjectModelImpl.ENTITY_CACHE_ENABLED,
                        ProjectImpl.class, primaryKey, _nullProject);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(ProjectModelImpl.ENTITY_CACHE_ENABLED,
                    ProjectImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return project;
    }

    /**
     * Returns the project with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param projectId the primary key of the project
     * @return the project, or <code>null</code> if a project with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Project fetchByPrimaryKey(long projectId) throws SystemException {
        return fetchByPrimaryKey((Serializable) projectId);
    }

    /**
     * Returns all the projects.
     *
     * @return the projects
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Project> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the projects.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.altran.liferay.model.impl.ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of projects
     * @param end the upper bound of the range of projects (not inclusive)
     * @return the range of projects
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Project> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the projects.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.altran.liferay.model.impl.ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of projects
     * @param end the upper bound of the range of projects (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of projects
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Project> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Project> list = (List<Project>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_PROJECT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_PROJECT;

                if (pagination) {
                    sql = sql.concat(ProjectModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Project>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Project>(list);
                } else {
                    list = (List<Project>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the projects from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Project project : findAll()) {
            remove(project);
        }
    }

    /**
     * Returns the number of projects.
     *
     * @return the number of projects
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_PROJECT);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the project persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.altran.liferay.model.Project")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Project>> listenersList = new ArrayList<ModelListener<Project>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Project>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ProjectImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
