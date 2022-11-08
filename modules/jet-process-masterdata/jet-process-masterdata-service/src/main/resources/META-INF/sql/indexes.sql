create index IX_754D055E on Masterdata_UserPost (userId);
create unique index IX_CC153E9A on Masterdata_UserPost (uuid_[$COLUMN_LENGTH:75$], groupId);