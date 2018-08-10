/**
* replaces the table name with a really long table name
* ToDo: the long table name will be generated through a replacement value
*/
alter table {{dbName}}.tbl_renameTableTest rename to {{dbName}}.tbl_withLongName;
describe extended {{dbName}}.tbl_withLongName;

-- renames a table with the same name
alter table {{dbName}}.tbl_withSameName rename to {{dbName}}.tbl_withSameName;
describe extended {{dbName}}.tbl_withSameName;