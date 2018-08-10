// Copyright (c) 2018 Cloudera, Inc. All rights reserved.
package json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Set;

public class ExcludeFieldSet {
  private Map<String, Set<String>> mapOfVersionToExcludeFieldSets;

  @JsonCreator
  public ExcludeFieldSet(
      @JsonProperty(value = "excludeFilters", required = true)
          Map<String, Set<String>> mapOfVersionToExcludeFieldSets) {
    this.mapOfVersionToExcludeFieldSets = mapOfVersionToExcludeFieldSets;
  }

  @JsonProperty(value = "excludeFilters")
  public Map<String, Set<String>> getMapOfVersionToExcludeFieldSets() {
    return mapOfVersionToExcludeFieldSets;
  }
}
