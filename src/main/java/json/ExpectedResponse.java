// Copyright (c) 2018 Cloudera, Inc. All rights reserved.
package json;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExpectedResponse {
  private String sqlStatement;
  private EntitiesWithSqlTypes entitiesWithSqlTypes;

  public String getSqlStatement() {
    return sqlStatement;
  }

  public void setSqlStatement(String sqlStatement) {
    this.sqlStatement = sqlStatement;
  }

  public EntitiesWithSqlTypes getEntitiesWithSqlTypes() {
    return entitiesWithSqlTypes;
  }

  public void setEntitiesWithSqlTypes(EntitiesWithSqlTypes entitiesWithSqlTypes) {
    this.entitiesWithSqlTypes = entitiesWithSqlTypes;
  }
}
