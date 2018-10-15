package com.altran.liferay.controller;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.altran.liferay.model.Project;
import com.altran.liferay.service.ProjectLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class ProjectController extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		try {
			List<Project> projects = ProjectLocalServiceUtil.getProjects(0, 10);
			renderRequest.setAttribute("projects", projects);
		} catch (SystemException e) {
			e.printStackTrace();
		}

		super.doView(renderRequest, renderResponse);
	}

	public void addProject(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String title = ParamUtil.getString(actionRequest, "title", "");
		String description = ParamUtil.getString(actionRequest, "description", "");
		String director = ParamUtil.getString(actionRequest, "director", "");
		String comments = ParamUtil.getString(actionRequest, "comments", "");
		int people = ParamUtil.getInteger(actionRequest, "people", 0);

		Project project = ProjectLocalServiceUtil.addProject(title, description, people, director, comments, themeDisplay.getUserId(),
				themeDisplay.getUser().getFullName());

		// Redirect to view

		String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);

		PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),
				portletName, themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);

		redirectURL.setParameter("projectId", String.valueOf(project.getProjectId()));
		
		actionResponse.sendRedirect(redirectURL.toString());
	}

}
