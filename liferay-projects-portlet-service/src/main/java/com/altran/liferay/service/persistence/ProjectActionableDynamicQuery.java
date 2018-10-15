package com.altran.liferay.service.persistence;

import com.altran.liferay.model.Project;
import com.altran.liferay.service.ProjectLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class ProjectActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ProjectActionableDynamicQuery() throws SystemException {
        setBaseLocalService(ProjectLocalServiceUtil.getService());
        setClass(Project.class);

        setClassLoader(com.altran.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("projectId");
    }
}
