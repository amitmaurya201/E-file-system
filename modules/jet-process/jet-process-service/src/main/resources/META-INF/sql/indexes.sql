create index IX_BC7B7789 on JET_PROCESS_ContactDetail (groupId);
create index IX_1A2049F5 on JET_PROCESS_ContactDetail (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_8BACC9B7 on JET_PROCESS_ContactDetail (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_361685E6 on JET_PROCESS_DocFile (groupId);
create index IX_55E4699F on JET_PROCESS_DocFile (nature[$COLUMN_LENGTH:75$]);
create index IX_1C31438 on JET_PROCESS_DocFile (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_2AF348BA on JET_PROCESS_DocFile (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_46204F21 on JET_PROCESS_Receipt (groupId, receiptId);
create index IX_6CF2599C on JET_PROCESS_Receipt (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_833C971E on JET_PROCESS_Receipt (uuid_[$COLUMN_LENGTH:75$], groupId);