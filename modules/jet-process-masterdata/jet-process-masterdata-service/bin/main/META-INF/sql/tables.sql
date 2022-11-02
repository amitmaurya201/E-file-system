create table Masterdata_Masterdata (
	masterdataId VARCHAR(75) not null primary key,
	referenceId VARCHAR(75) null,
	value VARCHAR(75) null,
	code_ VARCHAR(75) null
);

create table Masterdata_UserPost (
	uuid_ VARCHAR(75) null,
	userPostId VARCHAR(75) not null primary key,
	groupId LONG,
	postId LONG,
	sectionId LONG,
	description LONG,
	userName VARCHAR(75) null,
	shortName VARCHAR(75) null
);