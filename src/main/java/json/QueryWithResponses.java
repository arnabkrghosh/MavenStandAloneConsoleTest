// Copyright (c) 2018 Cloudera, Inc. All rights reserved.
package json;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.cloudera.thunderhead.systemtest.testing.gridlink.response.SqlResponse;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Type used to deserialize a single SQL query
 * using @see com.fasterxml.jackson.databind.ObjectMapper.
 * Test driver will compare the expectedResponse to the actualResponse
 * using @see com.cloudera.thunderhead.systemtest.testing.gridlink.response.SqlResponse#equals
 * In case of a mismatch between the expectedResponse and actualResponse
 * the @see com.cloudera.thunderhead.systemtest.testing.gridlink.response.SqlResponse#toRawValue
 * and @see com.cloudera.thunderhead.systemtest.testing.gridlink.response.SqlResponse#toComparedValue
 * is used to dump the expected and actual response in the result file
 * along with exact fields that didn't match.
 */
public class QueryWithResponses {
  private QueryWithDescription queryWithDescription;

  @JsonIgnore
  private SqlResponse expectedResponse;

  @JsonIgnore
  private SqlResponse actualResponse;

  /**
   * Creates an instance of @see SqlQuery enforcing required properties.
   * @param queryWithDescription Description of the query as @see java.lang.String.
   */
  @JsonCreator
  public QueryWithResponses(
      @JsonProperty(value = "queryWithDescription", required = true) QueryWithDescription queryWithDescription) {
    this.queryWithDescription = checkNotNull(queryWithDescription);
  }

  @JsonProperty(value = "queryWithDescription")
  public QueryWithDescription getQueryWithDescription() {
    return queryWithDescription;
  }

  /**
   * Gets the expected response from executing the @see sqlQuery with a specific client.
   * @return Instance of @see com.cloudera.thunderhead.systemtest.testing.gridlink.response.SqlResponse
   * for the specific client.
   */
  @JsonIgnore
  public SqlResponse getExpectedResponse() {
    return expectedResponse;
  }

  /**
   * Sets the expected response for executing @sqlQuery with a specific client.
   * This value is deserialized from the expected file.
   * @param expectedResponse Client specific instance
   *                         of @see com.cloudera.thunderhead.systemtest.testing.gridlink.response.SqlResponse.
   */
  @JsonIgnore
  public void setExpectedResponse(SqlResponse expectedResponse) {
    this.expectedResponse = expectedResponse;
  }

  /**
   * Gets the actual response from executing the @see sqlQuery with a specific client.
   * @return Client specific instance
   * of @see com.cloudera.thunderhead.systemtest.testing.gridlink.response.SqlResponse.
   */
  @JsonIgnore
  public SqlResponse getActualResponse() {
    return actualResponse;
  }

  /**
   * Sets the actual response from executing the @see sqlQuery with a specific client.
   * @param actualResponse Client specific instance
   *                       of @see com.cloudera.thunderhead.systemtest.testing.gridlink.response.SqlResponse.
   */
  @JsonIgnore
  public void setActualResponse(SqlResponse actualResponse) {
    this.actualResponse = actualResponse;
  }
}