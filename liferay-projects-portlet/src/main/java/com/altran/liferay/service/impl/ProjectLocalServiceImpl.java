package com.altran.liferay.service.impl;

import java.util.Date;

import com.altran.liferay.model.Project;
import com.altran.liferay.service.base.ProjectLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the project local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.altran.liferay.service.ProjectLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.altran.liferay.service.base.ProjectLocalServiceBaseImpl
 * @see com.altran.liferay.service.ProjectLocalServiceUtil
 */
public class ProjectLocalServiceImpl extends ProjectLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.altran.liferay.service.ProjectLocalServiceUtil} to access the project local service.
     */

	public Project addProject(String title, String description, int people, String director, String comments,
			long userId, String fullname) throws SystemException {

		long projectId = counterLocalService.increment(Project.class.getName());

		Project project = projectPersistence.create(projectId);

		Date now = new Date();

		project.setTitle(title);
		project.setDescription(description);
		project.setPeople(people);
		project.setDirector(director);
		project.setComments(comments);
		project.setIsPublic(false);
		project.setFromDate(now);
		project.setToDate(now);

		project.setUserId(userId);
		project.setUserName(fullname);

		project.setModifiedDate(now);
		project.setCreateDate(now);

		return super.addProject(project);
	}
}
