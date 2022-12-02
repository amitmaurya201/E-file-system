create table JET_PROCESS_DocFile (
	uuid_ VARCHAR(75) null,
	docFileId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	nature VARCHAR(75) null,
	type_ VARCHAR(75) null,
	basicHeadId LONG,
	primaryHeadId LONG,
	secondaryHeadId LONG,
	tertiaryHeadId LONG,
	fileCodeId LONG,
	subject VARCHAR(75) null,
	fileNumber VARCHAR(75) null,
	categoryId LONG,
	subCategoryId LONG,
	remarks VARCHAR(75) null,
	reference VARCHAR(75) null,
	year LONG,
	userPostId LONG,
	currentlyWith LONG,
	currentState INTEGER
);

create table JET_PROCESS_FileMovement (
	uuid_ VARCHAR(75) null,
	fmId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	receiverId LONG,
	senderId LONG,
	fileId LONG,
	priority VARCHAR(75) null,
	dueDate VARCHAR(75) null,
	remark VARCHAR(75) null
);

create table JET_PROCESS_Receipt (
	uuid_ VARCHAR(75) null,
	receiptId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	typeId LONG,
	deliveryModeId LONG,
	receivedOn VARCHAR(75) null,
	letterDate VARCHAR(75) null,
	referenceNumber VARCHAR(75) null,
	modeNumber VARCHAR(75) null,
	receiptCategoryId LONG,
	receiptSubCategoryId LONG,
	subject VARCHAR(500) null,
	remarks VARCHAR(75) null,
	name VARCHAR(75) null,
	designation VARCHAR(75) null,
	mobile VARCHAR(75) null,
	email VARCHAR(75) null,
	address VARCHAR(500) null,
	countryId LONG,
	stateId LONG,
	pinCode VARCHAR(75) null,
	receiptNumber VARCHAR(75) null,
	organizationId LONG,
	city VARCHAR(75) null,
	subOrganizationId LONG,
	userPostId LONG,
	viewPdfUrl VARCHAR(1024) null,
	dmFileId LONG,
	nature VARCHAR(75) null,
	currentlyWith LONG,
	currentState INTEGER
);

create table JET_PROCESS_ReceiptMovement (
	uuid_ VARCHAR(75) null,
	rmId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	receiverId LONG,
	senderId LONG,
	receiptId LONG,
	priority VARCHAR(75) null,
	dueDate VARCHAR(75) null,
	remark VARCHAR(75) null
);