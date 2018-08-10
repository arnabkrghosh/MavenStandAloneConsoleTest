// Copyright (c) 2018 Cloudera, Inc. All rights reserved.
package multilineString;

import java.util.concurrent.Callable;

public class ObjectStoreWork implements Callable<Integer> {
  private final Object syncObject;

  ObjectStoreWork(Object syncObject) {
    this.syncObject = syncObject;
  }

  /**
   * Computes a result, or throws an exception if unable to do so.
   *
   * @return computed result
   * @throws Exception if unable to compute a result
   */
  @Override
  public Integer call() throws Exception {
    return null;
  }
}
