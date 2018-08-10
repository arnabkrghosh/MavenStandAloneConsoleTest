// Copyright (c) 2018 Cloudera, Inc. All rights reserved.
package com.cloudera.thunderhead.systemtest.testing.gridlink.response;

/**
 * Interface to compare the response from a SQL statement execution to an expected value.
 * The interface also provides API to serialize the raw response as well as the value
 * used for determining equivalence with expected value.
 * The raw response differs from the value used for comparing this instance
 * with a expected response instance in specific values like timing parameters or
 * create and access times not included included in the comparison for equivalence.
 */
public interface SqlResponse {
  /**
   * Compares an instance of this interface with another instance to determine equivalence.
   * The expected instance doesn't have timing parameters, create and
   * access times that are specific to an execution.
   * @param sqlResponse An instance of an implementation of this interface.
   * @return True if the target instance is equivalent to this one, false otherwise.
   */
  boolean equals(SqlResponse sqlResponse);

  /**
   * Serialize the raw form of this instance, which included timing parameters as well as
   * create and access times.
   * Such output will primarily be used for debugging when the test for equivalence
   * between this instance and an expected instance fails.
   * @return This instance serialized as @see java.lang#String String.
   */
  String toRawValue();

  /**
   * Serialize the data for this instance that was used in the comparison with an expected
   * instance to determine equivalence.
   * Values like timing parameters, create and access times that are specific to an execution
   * are filtered out.
   * @return This instance with execution specific values filtered out
   * serialized as @see java.lang#String String.
   */
  String toComparedValue();
}