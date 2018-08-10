// Copyright (c) 2018 Cloudera, Inc. All rights reserved.
package json;

import static com.google.common.base.Preconditions.checkArgument;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Strings;

public class QueryWithDescription {
  private String description;
  private String sqlQuery;

  @JsonCreator
  public QueryWithDescription(
      @JsonProperty(value = "description", required = true) String description,
      @JsonProperty(value = "sqlQuery", required = true) String sqlQuery) {
    checkArgument(!Strings.isNullOrEmpty(description));
    checkArgument(!Strings.isNullOrEmpty(sqlQuery));
    this.description = description;
    this.sqlQuery = sqlQuery;
  }

  @JsonProperty(value = "description")
  public String getDescription() {
    return description;
  }

  @JsonProperty(value = "sqlQuery")
  public String getSqlQuery() {
    return sqlQuery;
  }
}
