// Copyright (c) 2018 Cloudera, Inc. All rights reserved.
package response;

import com.cloudera.thunderhead.systemtest.testing.gridlink.response.SqlResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class HiveJobSqlResponse implements SqlResponse {
  @Override
  @JsonIgnore
  public boolean equals(SqlResponse sqlResponse) {
    return false;
  }

  @Override
  @JsonIgnore
  public String toRawValue() {
    return null;
  }

  @Override
  @JsonIgnore
  public String toComparedValue() {
    return null;
  }
}
