package com.altran.liferay.model.impl;

import com.altran.liferay.model.Project;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Project in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Project
 * @generated
 */
public class ProjectCacheModel implements CacheModel<Project>, Externalizable {
    public String uuid;
    public long projectId;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public String title;
    public String description;
    public String director;
    public boolean isPublic;
    public int people;
    public long fromDate;
    public long toDate;
    public String comments;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(33);

        sb.append("{uuid=");
        sb.append(uuid);
        sb.append(", projectId=");
        sb.append(projectId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", userName=");
        sb.append(userName);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", title=");
        sb.append(title);
        sb.append(", description=");
        sb.append(description);
        sb.append(", director=");
        sb.append(director);
        sb.append(", isPublic=");
        sb.append(isPublic);
        sb.append(", people=");
        sb.append(people);
        sb.append(", fromDate=");
        sb.append(fromDate);
        sb.append(", toDate=");
        sb.append(toDate);
        sb.append(", comments=");
        sb.append(comments);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Project toEntityModel() {
        ProjectImpl projectImpl = new ProjectImpl();

        if (uuid == null) {
            projectImpl.setUuid(StringPool.BLANK);
        } else {
            projectImpl.setUuid(uuid);
        }

        projectImpl.setProjectId(projectId);
        projectImpl.setGroupId(groupId);
        projectImpl.setCompanyId(companyId);
        projectImpl.setUserId(userId);

        if (userName == null) {
            projectImpl.setUserName(StringPool.BLANK);
        } else {
            projectImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            projectImpl.setCreateDate(null);
        } else {
            projectImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            projectImpl.setModifiedDate(null);
        } else {
            projectImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (title == null) {
            projectImpl.setTitle(StringPool.BLANK);
        } else {
            projectImpl.setTitle(title);
        }

        if (description == null) {
            projectImpl.setDescription(StringPool.BLANK);
        } else {
            projectImpl.setDescription(description);
        }

        if (director == null) {
            projectImpl.setDirector(StringPool.BLANK);
        } else {
            projectImpl.setDirector(director);
        }

        projectImpl.setIsPublic(isPublic);
        projectImpl.setPeople(people);

        if (fromDate == Long.MIN_VALUE) {
            projectImpl.setFromDate(null);
        } else {
            projectImpl.setFromDate(new Date(fromDate));
        }

        if (toDate == Long.MIN_VALUE) {
            projectImpl.setToDate(null);
        } else {
            projectImpl.setToDate(new Date(toDate));
        }

        if (comments == null) {
            projectImpl.setComments(StringPool.BLANK);
        } else {
            projectImpl.setComments(comments);
        }

        projectImpl.resetOriginalValues();

        return projectImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        uuid = objectInput.readUTF();
        projectId = objectInput.readLong();
        groupId = objectInput.readLong();
        companyId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        title = objectInput.readUTF();
        description = objectInput.readUTF();
        director = objectInput.readUTF();
        isPublic = objectInput.readBoolean();
        people = objectInput.readInt();
        fromDate = objectInput.readLong();
        toDate = objectInput.readLong();
        comments = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (uuid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(uuid);
        }

        objectOutput.writeLong(projectId);
        objectOutput.writeLong(groupId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(userId);

        if (userName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(userName);
        }

        objectOutput.writeLong(createDate);
        objectOutput.writeLong(modifiedDate);

        if (title == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(title);
        }

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        if (director == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(director);
        }

        objectOutput.writeBoolean(isPublic);
        objectOutput.writeInt(people);
        objectOutput.writeLong(fromDate);
        objectOutput.writeLong(toDate);

        if (comments == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(comments);
        }
    }
}
