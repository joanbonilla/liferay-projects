package com.altran.liferay.service.persistence;

import com.altran.liferay.model.Project;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the project service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectPersistenceImpl
 * @see ProjectUtil
 * @generated
 */
public interface ProjectPersistence extends BasePersistence<Project> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ProjectUtil} to access the project persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the projects where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching projects
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.altran.liferay.model.Project> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.altran.liferay.model.Project> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.altran.liferay.model.Project> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first project in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching project
    * @throws com.altran.liferay.NoSuchProjectException if a matching project could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.altran.liferay.model.Project findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.altran.liferay.NoSuchProjectException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first project in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching project, or <code>null</code> if a matching project could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.altran.liferay.model.Project fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last project in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching project
    * @throws com.altran.liferay.NoSuchProjectException if a matching project could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.altran.liferay.model.Project findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.altran.liferay.NoSuchProjectException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last project in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching project, or <code>null</code> if a matching project could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.altran.liferay.model.Project fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.altran.liferay.model.Project[] findByUuid_PrevAndNext(
        long projectId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.altran.liferay.NoSuchProjectException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the projects where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of projects where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching projects
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the project where uuid = &#63; and groupId = &#63; or throws a {@link com.altran.liferay.NoSuchProjectException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching project
    * @throws com.altran.liferay.NoSuchProjectException if a matching project could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.altran.liferay.model.Project findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.altran.liferay.NoSuchProjectException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the project where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching project, or <code>null</code> if a matching project could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.altran.liferay.model.Project fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the project where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching project, or <code>null</code> if a matching project could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.altran.liferay.model.Project fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the project where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the project that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.altran.liferay.model.Project removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.altran.liferay.NoSuchProjectException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of projects where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching projects
    * @throws SystemException if a system exception occurred
    */
    public int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the projects where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching projects
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.altran.liferay.model.Project> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.altran.liferay.model.Project> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.altran.liferay.model.Project> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.altran.liferay.model.Project findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.altran.liferay.NoSuchProjectException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first project in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching project, or <code>null</code> if a matching project could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.altran.liferay.model.Project fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.altran.liferay.model.Project findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.altran.liferay.NoSuchProjectException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last project in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching project, or <code>null</code> if a matching project could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.altran.liferay.model.Project fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.altran.liferay.model.Project[] findByUuid_C_PrevAndNext(
        long projectId, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.altran.liferay.NoSuchProjectException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the projects where uuid = &#63; and companyId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of projects where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching projects
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the projects where director = &#63;.
    *
    * @param director the director
    * @return the matching projects
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.altran.liferay.model.Project> findByDirector(
        java.lang.String director)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.altran.liferay.model.Project> findByDirector(
        java.lang.String director, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.altran.liferay.model.Project> findByDirector(
        java.lang.String director, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first project in the ordered set where director = &#63;.
    *
    * @param director the director
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching project
    * @throws com.altran.liferay.NoSuchProjectException if a matching project could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.altran.liferay.model.Project findByDirector_First(
        java.lang.String director,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.altran.liferay.NoSuchProjectException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first project in the ordered set where director = &#63;.
    *
    * @param director the director
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching project, or <code>null</code> if a matching project could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.altran.liferay.model.Project fetchByDirector_First(
        java.lang.String director,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last project in the ordered set where director = &#63;.
    *
    * @param director the director
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching project
    * @throws com.altran.liferay.NoSuchProjectException if a matching project could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.altran.liferay.model.Project findByDirector_Last(
        java.lang.String director,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.altran.liferay.NoSuchProjectException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last project in the ordered set where director = &#63;.
    *
    * @param director the director
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching project, or <code>null</code> if a matching project could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.altran.liferay.model.Project fetchByDirector_Last(
        java.lang.String director,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.altran.liferay.model.Project[] findByDirector_PrevAndNext(
        long projectId, java.lang.String director,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.altran.liferay.NoSuchProjectException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the projects where director = &#63; from the database.
    *
    * @param director the director
    * @throws SystemException if a system exception occurred
    */
    public void removeByDirector(java.lang.String director)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of projects where director = &#63;.
    *
    * @param director the director
    * @return the number of matching projects
    * @throws SystemException if a system exception occurred
    */
    public int countByDirector(java.lang.String director)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the project in the entity cache if it is enabled.
    *
    * @param project the project
    */
    public void cacheResult(com.altran.liferay.model.Project project);

    /**
    * Caches the projects in the entity cache if it is enabled.
    *
    * @param projects the projects
    */
    public void cacheResult(
        java.util.List<com.altran.liferay.model.Project> projects);

    /**
    * Creates a new project with the primary key. Does not add the project to the database.
    *
    * @param projectId the primary key for the new project
    * @return the new project
    */
    public com.altran.liferay.model.Project create(long projectId);

    /**
    * Removes the project with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param projectId the primary key of the project
    * @return the project that was removed
    * @throws com.altran.liferay.NoSuchProjectException if a project with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.altran.liferay.model.Project remove(long projectId)
        throws com.altran.liferay.NoSuchProjectException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.altran.liferay.model.Project updateImpl(
        com.altran.liferay.model.Project project)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the project with the primary key or throws a {@link com.altran.liferay.NoSuchProjectException} if it could not be found.
    *
    * @param projectId the primary key of the project
    * @return the project
    * @throws com.altran.liferay.NoSuchProjectException if a project with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.altran.liferay.model.Project findByPrimaryKey(long projectId)
        throws com.altran.liferay.NoSuchProjectException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the project with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param projectId the primary key of the project
    * @return the project, or <code>null</code> if a project with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.altran.liferay.model.Project fetchByPrimaryKey(long projectId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the projects.
    *
    * @return the projects
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.altran.liferay.model.Project> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.altran.liferay.model.Project> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.altran.liferay.model.Project> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the projects from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of projects.
    *
    * @return the number of projects
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
