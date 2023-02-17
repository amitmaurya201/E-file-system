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
	remarks VARCHAR(500) null,
	reference VARCHAR(75) null,
	year LONG,
	userPostId LONG,
	currentlyWith LONG,
	currentState INTEGER
);

create table JET_PROCESS_FileCorr (
	uuid_ VARCHAR(75) null,
	fileCorrId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	docFileId LONG,
	receiptId LONG,
	userPostId LONG,
	correspondenceType VARCHAR(75) null,
	remarks VARCHAR(75) null,
	fileMovementId LONG,
	receiptMovementId LONG
);

create table JET_PROCESS_FileCorrReceipt (
	uuid_ VARCHAR(75) null,
	fileCorrReceiptId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	docFileId LONG,
	receiptId LONG,
	userPostId LONG,
	receiptMovementId LONG,
	correspondenceType VARCHAR(75) null,
	remarks VARCHAR(75) null,
	fileMovementId LONG
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
	dueDate DATE null,
	remark VARCHAR(75) null,
	readOn VARCHAR(75) null,
	receivedOn VARCHAR(75) null,
	pullBackRemark VARCHAR(500) null,
	active_ BOOLEAN,
	movementType LONG
);

create table JET_PROCESS_FileNote (
	uuid_ VARCHAR(75) null,
	fileNoteId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	fileId LONG,
	fileMovementId LONG,
	noteId LONG,
	movementType LONG
);

create table JET_PROCESS_Note (
	uuid_ VARCHAR(75) null,
	noteId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	content TEXT null,
	createdBy LONG,
	signature VARCHAR(500) null
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
	receivedOn DATE null,
	letterDate DATE null,
	referenceNumber VARCHAR(75) null,
	modeNumber VARCHAR(75) null,
	receiptCategoryId LONG,
	receiptSubCategoryId LONG,
	subject VARCHAR(500) null,
	remarks VARCHAR(500) null,
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
	currentState INTEGER,
	attachStatus VARCHAR(75) null
);

create table JET_PROCESS_ReceiptCloseDetail (
	uuid_ VARCHAR(75) null,
	ReceiptClosedId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	receiptId LONG,
	closedBy LONG,
	closingRemarks VARCHAR(500) null,
	reopenDate DATE null,
	reopenRemarks VARCHAR(500) null,
	closingReceiptMovementId LONG,
	reopenBy LONG
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
	dueDate DATE null,
	remark VARCHAR(75) null,
	readOn VARCHAR(75) null,
	receivedOn VARCHAR(75) null,
	pullBackRemark VARCHAR(500) null,
	active_ BOOLEAN,
	fileInMovementId LONG,
	movementType LONG
);