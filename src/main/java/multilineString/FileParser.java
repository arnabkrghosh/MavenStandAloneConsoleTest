// Copyright (c) 2018 Cloudera, Inc. All rights reserved.
package multilineString;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.base.Strings;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang3.tuple.ImmutablePair;

public class FileParser {

  //private static final Pattern MULTI_LINE_SQL_COMMENT = Pattern.compile("^/\*[\\w|\\W]+\*/$");
  static List<ImmutablePair<String, String>> getStatements(String path) throws IOException {
    checkArgument(!Strings.isNullOrEmpty(path));
    String content = CompareFromFile.getFileContent(path);
    return null;
  }

  private static String removeCommentAndNewline(String content) {
    return null;
  }
}
