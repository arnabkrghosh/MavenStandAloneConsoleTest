// Copyright (c) 2018 Cloudera, Inc. All rights reserved.
package json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ExcludeFilterKeyValue {
  @JsonProperty(value = "key")
  private final String key;

  @JsonProperty(value = "value")
  private final String value;

  @JsonCreator
  public ExcludeFilterKeyValue(
      @JsonProperty(value = "key", required = true) String key,
      @JsonProperty(value = "value", required = true) String value) {
    this.key = key;
    this.value = value;
  }

  public String getKey() {
    return key;
  }

  public String getValue() {
    return value;
  }
}
