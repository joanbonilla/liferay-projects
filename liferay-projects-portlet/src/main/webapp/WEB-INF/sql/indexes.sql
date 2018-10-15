create index IX_DAC6C719 on project_Project (director);
create index IX_30F6CBB on project_Project (uuid_);
create index IX_3B92E48D on project_Project (uuid_, companyId);
create unique index IX_DB52A4F on project_Project (uuid_, groupId);