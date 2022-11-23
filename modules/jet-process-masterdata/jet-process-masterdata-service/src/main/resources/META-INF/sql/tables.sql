create table Masterdata_Masterdata (
	masterdataId VARCHAR(75) not null primary key,
	referenceId VARCHAR(75) null,
	value VARCHAR(75) null,
	code_ VARCHAR(75) null
);

create table Masterdata_UserPost (
	uuid_ VARCHAR(75) null,
	userPostId LONG not null primary key,
	groupId LONG,
	postId LONG,
	sectionId LONG,
	description VARCHAR(75) null,
	userName VARCHAR(75) null,
	shortName VARCHAR(75) null,
	userId LONG,
	postName VARCHAR(75) null,
	sectionName VARCHAR(75) null,
	departmentName VARCHAR(75) null,
	departmentId LONG,
	postMarking VARCHAR(75) null
);