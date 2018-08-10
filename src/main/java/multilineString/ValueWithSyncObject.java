// Copyright (c) 2018 Cloudera, Inc. All rights reserved.
package multilineString;

public class ValueWithSyncObject {
  private final Integer value;
  private final Object syncObject;
  ValueWithSyncObject(Integer value, Object syncObject) {
    this.value = value;
    this.syncObject = syncObject;
  }

  public Integer getValue() {
    return value;
  }

  public Object getSyncObject() {
    return syncObject;
  }
}
