// Copyright (c) 2018 Cloudera, Inc. All rights reserved.
package json;

import java.util.List;
import java.util.Map;

public class EntitiesWithSqlTypes {
  private Map<String, Integer> mapOfColumnNamesToSqlTypes;
  private List<Map<String, Object>> entities;

  public Map<String, Integer> getMapOfColumnNamesToSqlTypes() {
    return mapOfColumnNamesToSqlTypes;
  }

  public void setMapOfColumnNamesToSqlTypes(Map<String, Integer> mapOfColumnNamesToSqlTypes) {
    this.mapOfColumnNamesToSqlTypes = mapOfColumnNamesToSqlTypes;
  }

  public List<Map<String, Object>> getEntities() {
    return entities;
  }

  public void setEntities(List<Map<String, Object>> entities) {
    this.entities = entities;
  }
}
