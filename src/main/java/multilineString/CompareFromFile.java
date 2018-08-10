// Copyright (c) 2018 Cloudera, Inc. All rights reserved.
package multilineString;

import static java.lang.String.format;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.regex.Pattern;

//import jdk.internal.org.objectweb.asm.TypeReference;
import org.apache.commons.lang3.tuple.ImmutablePair;
import javafx.util.Pair;

import json.EntitiesWithSqlTypes;
import json.ExcludeFilterKeyValue;
import json.ExpectedResponse;
import json.QueryWithDescription;
import json.QueryWithValidations;
import json.QueryWithResponses;

public class CompareFromFile {

  static final String NEW_LINE = System.getProperty("line.separator");

  private static final String EXPECTED_FILE_NAME = "expected.txt";
  private static final String ACTUAL_FILE_NAME = "actual.txt";
  private static final int LAST_FEW_CHARS_COUNT = 10;
  private static final Pattern REGEX_PATTERN = Pattern.compile(
      "^#SQL_BEGIN[\\w|\\W]+#SQL_END$",
      Pattern.MULTILINE);

  public static void main(String[] args) throws IOException {
    /*
    String expectedContent = getFileContent(EXPECTED_FILE_NAME);
    String actualContent = getFileContent(ACTUAL_FILE_NAME);
    if (expectedContent.length() != actualContent.length()) {
      System.out.println(String.format("Content length mismatch: Expected content length: %d;" +
                                    " Actual content length: %d",
                                expectedContent.length(),
                                actualContent.length()));
      return;
    }
    System.out.println("Expected content length: " + expectedContent.length());
    System.out.println("Actual content length: " + actualContent.length());
    char[] expectedChars = expectedContent.toCharArray();
    char[] actualChars = actualContent.toCharArray();
    for (int i = 0; i < expectedContent.length(); i++) {
      if (expectedChars[i] != actualChars[i]) {
        System.out.println(String.format(
            "Mismatch at position: %d; Expected char: %c; Actual char: %c",
            i,
            expectedChars[i],
            actualChars[i]));
        if (i > LAST_FEW_CHARS_COUNT) {
          String expectedLastFewChars = getLastFewChars(expectedContent, i);
          String actualLastFewChars = getLastFewChars(actualContent, i);
          System.out.println(String.format(
              "Strings around difference: expected: %s; actual: %s",
              expectedLastFewChars,
              actualLastFewChars));
        }
        return;
      }
    }
    System.out.println("Strings match!");
    */
    /*
    String expectedContent = getFileContent(EXPECTED_FILE_NAME);
    Matcher matcher = REGEX_PATTERN.matcher(expectedContent);
    String updated = null;
    if (matcher.find()) {
      updated = matcher.replaceAll("");
      updated = updated.replaceFirst("\n", "");
      //System.out.println("Updated string: ");
      //System.out.println(updated);
    } else {
      System.out.println("Pattern not found");
    }
    String actualContent = getFileContent(ACTUAL_FILE_NAME);
    if (actualContent.matches(updated)) {
      System.out.println("Actual content matches expected.");
    } else {
      System.out.println("Actual content doesn't match expected.");
      System.out.println("Expected:");
      System.out.println(updated);
      System.out.println("Actual:");
      System.out.println(actualContent);
    }
    */
    //System.out.println("dbName: " + createNameWithUuid("db_alterTableTest"));
    //System.out.println("UUID: " + UUID.randomUUID().toString());
    //System.out.println(format("abc%1$s/%1$s/", 1));
    //System.out.println("Random string of length 255: " + createStringOfLength(255));
    //ObjectMapper mapper = new ObjectMapper();
    //ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
    /*
    YAMLFactory factory = new YAMLFactory();
    factory.configure(YAMLGenerator.Feature.WRITE_DOC_START_MARKER, false);
    factory.configure(YAMLGenerator.Feature.MINIMIZE_QUOTES, true);
    YAMLMapper mapper = new YAMLMapper(factory);
    mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    */
    //mapper.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
//    QueryGroups queryGroups = new QueryGroups(getQueryWithValidations());
    //List<QueryWithValidations> allQueryWithValidations = getQueryWithValidations();
//    String jsonValue = mapper.writeValueAsString(queryGroups);
//    System.out.println(jsonValue);
    //File testFile = new File("test.all.sql.yaml");
    //File testFile = new File("test.expected.sql.yaml");
    //File excludeFieldsFile = new File("excludeFilters.yaml");
    //mapper.writerWithDefaultPrettyPrinter().writeValue(testFile, queryGroups);
    //mapper.writeValue(testFile, allQueryWithValidations);
//    mapper.writeValue(testFile, queryGroups);
    //System.out.println("Written to file.");
//    QueryGroups readQueries = mapper.readValue(testFile, QueryGroups.class);
    /*
    List<QueryWithValidations> readQueries = mapper.readValue(testFile,
                                                              new TypeReference<List<QueryWithValidations>>(){});
    if ((readQueries != null) && (!readQueries.isEmpty())) {
      QueryWithValidations queryWithValidations = readQueries.get(
          readQueries.size() - 1);
      System.out.println(format("Sql statement from last entry: %s",
                                queryWithValidations.getAction().getQueryWithDescription().getSqlQuery()));
    } else {
      System.out.println("No sql statements read from file.");
    }
//    ExpectedResponses expectedResponses = new ExpectedResponses();
//    expectedResponses.setExpectedResponses(getExpectedResponses());
//    File expectedResponseFile = new File("test.expected.impala.jdbc.json");
//    mapper.writerWithDefaultPrettyPrinter().writeValue(expectedResponseFile, expectedResponses);
//    System.out.println("Written to file");
*/
    /*
    Map<String, List<ExcludeFilterKeyValue>> mapOfVersionToExcludeList = new HashMap<>();
    List<ExcludeFilterKeyValue> excludeKeyValueList = new ArrayList<>();
    ExcludeFilterKeyValue nameCreateTime = new ExcludeFilterKeyValue("name", "CreateTime");
    excludeKeyValueList.add(nameCreateTime);
    ExcludeFilterKeyValue nameLastAccessTime = new ExcludeFilterKeyValue("name", "LastAccessTime");
    excludeKeyValueList.add(nameLastAccessTime);
    ExcludeFilterKeyValue typeTransientTime = new ExcludeFilterKeyValue("type", "transient_lastDdlTime");
    excludeKeyValueList.add(typeTransientTime);

    mapOfVersionToExcludeList.put("CDH514+_ImpalaSimbaDriver_2.5.38+", excludeKeyValueList);
    mapper.writeValue(excludeFieldsFile, mapOfVersionToExcludeList);
    System.out.println("Wrote to file");
    */
    /*
    Map<String, List<ExcludeFilterKeyValue>> mapOfVersionToExcludeList =
        mapper.readValue(excludeFieldsFile,
                         new TypeReference<Map<String, List<ExcludeFilterKeyValue>>>(){});
    if (mapOfVersionToExcludeList != null) {
      StringBuilder sb = new StringBuilder();
      for (Map.Entry<String, List<ExcludeFilterKeyValue>> entry:
          mapOfVersionToExcludeList.entrySet()) {
        sb.append(format("%s: ", entry.getKey()));
        for (ExcludeFilterKeyValue keyValue: entry.getValue()) {
          sb.append(format("%s: %s, ", keyValue.getKey(), keyValue.getValue()));
        }
      }
      System.out.println(format("Read value: %s", sb.toString()));
    } else {
      System.out.println("FAIL: found an empty map when expecting one with values.");
    }
    */

    ExecutorService executorService = Executors.newFixedThreadPool(20);
    ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)executorService;
    threadPoolExecutor.setCorePoolSize(5);
    System.out.printf("Core thread count: %d; Max thread count: %d\n",
                      threadPoolExecutor.getCorePoolSize(),
                      threadPoolExecutor.getMaximumPoolSize());
  }

  static List<QueryWithValidations> getQueryWithValidations() {
    List<QueryWithValidations> queryGroups = new ArrayList<>();

    QueryWithDescription createDBqueryWithDescription =
        new QueryWithDescription("Creates a database.",
                                 "create database foobar;");
    QueryWithResponses createDbQuery = new QueryWithResponses(createDBqueryWithDescription);

    QueryWithDescription validateDbQueryWithDescription =
        new QueryWithDescription("Validates a create db query.",
                                 "describe database extended foobar;");
    QueryWithResponses validateDbCreate = new QueryWithResponses(validateDbQueryWithDescription);

    QueryWithValidations dbCreateQueryGroup = new QueryWithValidations(createDbQuery);
    List<QueryWithResponses> createDbValidationQueries = new ArrayList<>();
    createDbValidationQueries.add(validateDbCreate);
    dbCreateQueryGroup.setValidations(createDbValidationQueries);
    dbCreateQueryGroup.setValidationQueriesAlsoRunOnActionCluster(false);

    List<QueryWithValidations> createDbQueryGroup = new ArrayList<>();
    createDbQueryGroup.add(dbCreateQueryGroup);

    queryGroups.add(dbCreateQueryGroup);

    QueryWithDescription createTblQueryWithDescription =
        new QueryWithDescription("Creates a table.",
                                 "create external table foobar.blah (id int, name string);");
    QueryWithResponses createTblQuery = new QueryWithResponses(createTblQueryWithDescription);
    QueryWithValidations tblCreate = new QueryWithValidations(createTblQuery);
    QueryWithDescription validateCreateTblQueryWithDescription =
        new QueryWithDescription("describes the table in extended format.",
                                 "describe extended foobar.blah");
    QueryWithResponses validateCreateTblQuery = new QueryWithResponses(validateCreateTblQueryWithDescription);
    QueryWithDescription insertQueryWithDescription =
        new QueryWithDescription("Inserts data into a table.",
                                 "insert into table foobar.blah values (1, 'foo'), (2, 'bar');");
    QueryWithResponses insertIntoTblQuery = new QueryWithResponses(insertQueryWithDescription);
    QueryWithDescription selectQueryWithDescription =
        new QueryWithDescription("Selects data from a table.",
                                 "select * from foobar.blah;");
    QueryWithResponses selectFromTblQuery = new QueryWithResponses(selectQueryWithDescription);
    List<QueryWithResponses> createTblValidations = new ArrayList<>();
    createTblValidations.add(validateCreateTblQuery);
    createTblValidations.add(insertIntoTblQuery);
    createTblValidations.add(selectFromTblQuery);
    tblCreate.setValidations(createTblValidations);
    tblCreate.setValidationQueriesAlsoRunOnActionCluster(false);

    queryGroups.add(tblCreate);

    return queryGroups;
  }

  static List<ExpectedResponse> getExpectedResponses() {
    List<ExpectedResponse> responses = new ArrayList<>();
    ExpectedResponse describeDbExpected = new ExpectedResponse();
    describeDbExpected.setSqlStatement("describe database foobar;");
    EntitiesWithSqlTypes describeDbEntitiesWithSqlTypes = new EntitiesWithSqlTypes();
    Map<String, Integer> describeDbColumnAndTypes = new HashMap<>();
    describeDbColumnAndTypes.put("name", 12);
    describeDbColumnAndTypes.put("location", 12);
    describeDbColumnAndTypes.put("comment", 12);
    Map<String, Object> row1 = new HashMap<>();
    row1.put("name", "foobar");
    row1.put("location", "s3location");
    row1.put("comment", "this is a db.");
    List<Map<String, Object>> describeDbRows = new ArrayList<>();
    describeDbRows.add(row1);
    describeDbEntitiesWithSqlTypes.setMapOfColumnNamesToSqlTypes(describeDbColumnAndTypes);
    describeDbEntitiesWithSqlTypes.setEntities(describeDbRows);
    describeDbExpected.setEntitiesWithSqlTypes(describeDbEntitiesWithSqlTypes);

    ExpectedResponse describeTableExpected = new ExpectedResponse();
    responses.add(describeDbExpected);
    return responses;
  }

  static String getFileContent(String fileName) throws IOException {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(
        CompareFromFile.class.getResourceAsStream(fileName)))) {
      StringBuilder contentBuilder = new StringBuilder();
      String line;
      while ((line = reader.readLine()) != null) {
        contentBuilder.append(line);
        contentBuilder.append(NEW_LINE);
      }
      return contentBuilder.delete(
          contentBuilder.lastIndexOf(NEW_LINE), contentBuilder.length()).toString();
    }
  }

  private static String getLastFewChars(String content, int index) {
    if (index > LAST_FEW_CHARS_COUNT) {
      int startIndex = index - LAST_FEW_CHARS_COUNT;
      return content.substring(startIndex, index + 1);
    }
    return null;
  }

  private static String createNameWithUuid(String prefix) {
    return format("%s_%s", prefix,
                  UUID.randomUUID()
                      .toString()
                      .replace("-", "").toLowerCase());
  }

  private static String createStringOfLength(int length) {
    StringBuilder builder = new StringBuilder();
    Random r = new Random();
    for(int i=0; i<length; i++) {
      builder.append((char)(r.nextInt('z' - 'a') + 'a'));
    }
    return builder.toString();
  }
}
