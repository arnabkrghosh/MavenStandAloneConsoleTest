{
  "queryWithValidations" : [ {
    "action" : "
    -- this is a create database statement
    create database foobar
      location 'blah';
      ",
    "validations" : [ "describe database extended foobar;" ]
  }, {
    "action" : "
    /**
    * This is a multine comment
    * for creating a table 
    */
    create external table foobar.blah (
      id int, 
      name string)
    partitioned by (
      paritionId int,
      partitionName string);
      ",
    "validations" : [ "describe extended foobar.blah", "insert into table foobar.blah values (1, 'foo'), (2, 'bar');", "select * from foobar.blah;" ]
  } ]
}