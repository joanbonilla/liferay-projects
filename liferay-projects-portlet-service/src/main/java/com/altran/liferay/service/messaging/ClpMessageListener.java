package com.altran.liferay.service.messaging;

import com.altran.liferay.service.ClpSerializer;
import com.altran.liferay.service.ProjectLocalServiceUtil;
import com.altran.liferay.service.ProjectServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            ProjectLocalServiceUtil.clearService();

            ProjectServiceUtil.clearService();
        }
    }
}
