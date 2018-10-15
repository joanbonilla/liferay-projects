create table project_Project (
	uuid_ VARCHAR(75) null,
	projectId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	description VARCHAR(75) null,
	director VARCHAR(75) null,
	isPublic BOOLEAN,
	people INTEGER,
	fromDate DATE null,
	toDate DATE null,
	comments VARCHAR(75) null
);