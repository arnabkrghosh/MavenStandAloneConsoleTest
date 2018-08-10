// Copyright (c) 2018 Cloudera, Inc. All rights reserved.
package json;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Type used to deserialize a group with queries and
 * corresponding validation queries with @see com.fasterxml.jackson.databind.ObjectMapper.
 */
public class QueryWithValidations {
  private QueryWithResponses action;
  private List<QueryWithResponses> validations;
  private boolean isValidationQueriesAlsoRunOnActionCluster;

  /**
   * Creates an instance of @see QueryWithValidations enforcing required properties.
   * @param action Instance of @see QueryWithResponses.
   */
  @JsonCreator
  public QueryWithValidations(
      @JsonProperty(value = "actionQuery", required = true) QueryWithResponses action) {
    checkNotNull(action);
    this.action = action;
  }

  /**
   * Gets the action query for this statement group.
   * @return An instance of @see QueryWithResponses.
   */
  @JsonProperty(value = "actionQuery")
  public QueryWithResponses getAction() {
    return action;
  }

  /**
   * Gets the validation queries for this statement group.
   * @return List @see java.util.List of QueryWithResponses.
   */
  @JsonProperty(value = "validationQueries")
  public List<QueryWithResponses> getValidations() {
    return validations;
  }

  /**
   * Sets the validation queries for this statement group.
   * There can be 0 or more validation queries for each action query.
   * Negative action queries, in general, don't need validation queries
   * @param validations List @see java.util.List of QueryWithResponses.
   */
  @JsonProperty(value = "validationQueries")
  public void setValidations(List<QueryWithResponses> validations) {
    checkArgument((validations != null) && (validations.size() > 0));
    this.validations = validations;
  }

  /**
   * Indicates if the validation queries need to be run on the action cluster also.
   * Validation queries are run on the validation cluster by default.
   * This flag can be used to debug validation query failure on the validation cluster.
   * @return True if validation queries are also to be run on action cluster, false otherwise.
   */
  @JsonProperty(value = "validationQueriesAlsoRunOnActionCluster")
  public boolean isValidationQueriesAlsoRunOnActionCluster() {
    return isValidationQueriesAlsoRunOnActionCluster;
  }

  /**
   * Sets the flag if validation queries are also to be run on the action cluster.
   * Validation queries are run on the validation cluster by default.
   * This flag can be used to debug validation query failure on the validation cluster.
   * @param validationQueriesAlsoRunOnActionCluster True if validation queries
   *                                                are also to be run on action cluster,
   *                                                false otherwise.
   */
  @JsonProperty(value = "validationQueriesAlsoRunOnActionCluster")
  public void setValidationQueriesAlsoRunOnActionCluster(boolean validationQueriesAlsoRunOnActionCluster) {
    isValidationQueriesAlsoRunOnActionCluster = validationQueriesAlsoRunOnActionCluster;
  }


  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Action query:");
    builder.append(action.getQueryWithDescription().getSqlQuery());
    if ((validations != null) && (validations.size() > 0)) {
      builder.append("Validation queries:");
      validations.stream().forEach(validation ->
                                       builder.append(validation.getQueryWithDescription().getSqlQuery()));
    }
    return builder.toString();
  }
}