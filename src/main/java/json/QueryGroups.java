// Copyright (c) 2018 Cloudera, Inc. All rights reserved.
package json;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class QueryGroups {
  private List<QueryWithValidations> queryGroups;

  @JsonCreator
  public QueryGroups(
      @JsonProperty(value = "queryGroups", required = true)
          List<QueryWithValidations> queryGroups) {
    checkArgument((queryGroups != null) && (queryGroups.size() > 0));
    this.queryGroups = queryGroups;
  }

  /**
   * Gets the set of queries with validations in a file.
   * @return An instance of @see java.util.List of @see QueryWithValidations.
   */
  public List<QueryWithValidations> getQueryGroups() {
    return queryGroups;
  }
}
