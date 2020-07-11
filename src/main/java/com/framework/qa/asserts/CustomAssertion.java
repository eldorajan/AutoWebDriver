package test.java.com.framework.qa.asserts;

import com.framework.qa.logger.Logger;
import com.google.common.collect.MapDifference;
import com.google.common.collect.MapDifference.ValueDifference;
import com.google.common.collect.Maps;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.skyscreamer.jsonassert.JSONAssert;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;


/**
 * @author eldorajan
 */
public class CustomAssertion {

    // CustomAssertion Methods

    public static void assertEquals(final boolean actual, final boolean expected, final String message) {
        try {
            Logger.info("Expected: " + expected);
            Logger.info("Actual  : " + actual);
            Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.info("Assertion Error  : " + actual + " is not equal to " + expected);
            Logger.info("VALUE MISMATCH EXCEPTION");
            throw e;
        }
    }

    public static void assertEquals(final byte actual, final byte expected, final String message) {
        try {
            Logger.info("Expected: " + expected);
            Logger.info("Actual  : " + actual);
            Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.info("Assertion Error  : " + actual + " is not equal to " + expected);
            Logger.info("VALUE MISMATCH EXCEPTION");
            throw e;
        }
    }

    public static void assertEquals(final byte[] actual, final byte[] expected, final String message) {
        try {
            Logger.info("Expected: " + expected);
            Logger.info("Actual  : " + actual);
            Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.info("Assertion Error  : " + actual + " is not equal to " + expected);
            Logger.info("VALUE MISMATCH EXCEPTION");
            throw e;
        }
    }

    public static void assertEquals(final char actual, final char expected, final String message) {

        try {
            Logger.info("Expected: " + expected);
            Logger.info("Actual  : " + actual);
            Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.info("Assertion Error  : " + actual + " is not equal to " + expected);
            Logger.info("VALUE MISMATCH EXCEPTION");
            throw e;
        }
    }

    @SuppressWarnings("rawtypes")
    public static void assertEquals(final Collection actual, final Collection expected, final String message) {

        try {
            Logger.info("Expected: " + expected);
            Logger.info("Actual  : " + actual);
            Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.info("Assertion Error  : " + actual + " is not equal to " + expected);
            Logger.info("VALUE MISMATCH EXCEPTION");
            throw e;
        }

    }

    public static void assertEquals(final double actual, final double expected, final String message) {

        try {
            Logger.info("Expected: " + expected);
            Logger.info("Actual  : " + actual);
            Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.info("Assertion Error  : " + actual + " is not equal to " + expected);
            Logger.info("VALUE MISMATCH EXCEPTION");
            throw e;
        }

    }

    public static void assertEquals(final float actual, final float expected, final String message) {

        try {
            Logger.info("Expected: " + expected);
            Logger.info("Actual  : " + actual);
            Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.info("Assertion Error  : " + actual + " is not equal to " + expected);
            Logger.info("VALUE MISMATCH EXCEPTION");
            throw e;
        }

    }

    public static void assertEquals(final int actual, final int expected, final String message) {

        try {
            Logger.info("Expected: " + expected);
            Logger.info("Actual  : " + actual);
            Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.info("Assertion Error  : " + actual + " is not equal to " + expected);
            Logger.info("VALUE MISMATCH EXCEPTION");
            throw e;
        }
    }

    public static void assertEquals(final int actual, final int expected, String field, final String message) {

        try {
            Logger.info("Expected: " + expected);
            Assert.assertEquals(actual, expected, message);
            Logger.info("Actual  : " + actual);

        } catch (AssertionError e) {
            Logger.info("Actual  : " + field + " is not equal to " + expected + ". It is " + actual);
            Logger.info("VALUE MISMATCH EXCEPTION");
            throw e;
        }
    }

    public static void assertEquals(final Double actual, final Double expected, String field, final String message) {

        try {
            Logger.info("Expected: " + expected);
            Assert.assertEquals(actual, expected, message);
            Logger.info("Actual  : " + actual);

        } catch (AssertionError e) {
            Logger.info("Actual  : " + field + " is not equal to " + expected + ". It is " + actual);
            Logger.info("VALUE MISMATCH EXCEPTION");
            throw e;
        }
    }

    public static void assertEquals(BigInteger actual, BigInteger expected, String field, final String message) {

        try {
            Logger.info("Expected: " + expected);
            Assert.assertEquals(actual, expected, message);
            Logger.info("Actual  : " + actual);

        } catch (AssertionError e) {
            Logger.info("Actual  : " + field + " is not equal to " + expected + ". It is " + actual);
            Logger.info("VALUE MISMATCH EXCEPTION");
            throw e;
        }
    }

    public static void assertEquals(final long actual, final long expected, String field, final String message) {

        try {
            Logger.info("Expected: " + expected);
            Assert.assertEquals(actual, expected, message);
            Logger.info("Actual  : " + actual);

        } catch (AssertionError e) {
            Logger.info("Actual  : " + field + " is not equal to " + expected + ". It is " + actual);
            Logger.info("VALUE MISMATCH EXCEPTION");
            throw e;
        }
    }

    public static void assertEquals(final Object actual, final Object expected, final String message) {

        try {
            Logger.info("Expected: " + expected);
            Assert.assertEquals(actual, expected, message);
            Logger.info("Actual  : " + actual);

        } catch (AssertionError e) {
            Logger.info("Actual  : " + actual + " is not equal to " + expected);
            Logger.info("VALUE MISMATCH EXCEPTION");
            throw e;
        }
    }

    public static void assertEquals(final Object[] actual, final Object[] expected, final String message) {

        try {
            Logger.info("Expected: " + expected);
            Assert.assertEquals(actual, expected, message);
            Logger.info("Actual  : " + actual);

        } catch (AssertionError e) {
            Logger.info("Actual  : " + actual + " is not equal to " + expected);
            Logger.info("VALUE MISMATCH EXCEPTION");
            throw e;
        }
    }

    public static void assertEquals(final short actual, final short expected, final String message) {

        try {

            Logger.info("Expected: " + expected);
            Assert.assertEquals(actual, expected, message);
            Logger.info("Actual  : " + actual);

        } catch (AssertionError e) {
            Logger.info("Actual  : " + actual + " is not equal to " + expected);
            Logger.info("VALUE MISMATCH EXCEPTION");
            throw e;
        }
    }

    public static void assertEquals(final String actual, final String expected, final String message) {

        try {

            Logger.pass("Expected: " + expected);
            Assert.assertEquals(actual, expected, message);
            Logger.pass("Actual  : " + actual);

        } catch (AssertionError e) {
            Logger.fail("Actual  : " + actual + " is not equal to " + expected);
            Logger.fail("VALUE MISMATCH EXCEPTION");
            throw e;
        }
    }

    public static void assertEquals(final List<String> actual, final List<String> expected, final String message) {

        try {
            Logger.info("Expected: " + expected);
            Logger.info("Actual  : " + actual);

            Assert.assertTrue(ListUtils.isEqual(expected, actual), message);

            try {
                Logger.pass("Difference => " + CollectionUtils.subtract(expected, actual) + " | " + "Extra => "
                        + CollectionUtils.subtract(actual, expected));
            } catch (Exception e) {
            }
        } catch (AssertionError e) {
            try {
                Logger.pass("Difference => " + CollectionUtils.subtract(expected, actual) + " | " + "Extra => "
                        + CollectionUtils.subtract(actual, expected));
            } catch (Exception e1) {
            }
            Logger.info("Assertion Error  : " + actual + " is not equal to " + expected);
            Logger.info("VALUE MISMATCH EXCEPTION");
            throw e;
        }
    }

    public static void assertEquals(final Set<String> actual, final Set<String> expected, final String message) {

        try {
            Logger.info("Expected: " + expected);
            Logger.info("Actual  : " + actual);

            Assert.assertTrue(ListUtils.isEqual(expected, actual), message);

            try {
                Logger.pass("Difference => " + CollectionUtils.subtract(expected, actual) + " | " + "Extra => "
                        + CollectionUtils.subtract(actual, expected));
            } catch (Exception e) {
            }
        } catch (AssertionError e) {
            try {
                Logger.pass("Difference => " + CollectionUtils.subtract(expected, actual) + " | " + "Extra => "
                        + CollectionUtils.subtract(actual, expected));
            } catch (Exception e1) {
            }
            Logger.info("Assertion Error  : " + actual + " is not equal to " + expected);
            Logger.info("VALUE MISMATCH EXCEPTION");
            throw e;
        }
    }

    public static void assertEquals(final Set<String> actual, final Set<String> expected, final String message,
                                    String pdType, String fileCategory, String fileName, String fileId) {

        try {
            Logger.info("Expected: " + expected);
            Logger.info("Actual  : " + actual);

            Assert.assertTrue(ListUtils.isEqual(expected, actual), message);

            try {
                Logger.pass("File Category: " + fileCategory + " | File Name: " + fileName + " | File Id: " + fileId
                        + " | " + "Present => " + actual + " | " + "Difference => "
                        + CollectionUtils.subtract(expected, actual) + " | " + "Extra => "
                        + CollectionUtils.subtract(actual, expected) + " | " + pdType + "Pass Percentage => ["
                        + getPassPercentage(actual, expected) + "]");
            } catch (Exception e) {
            }
        } catch (AssertionError e) {
            try {
                Logger.fail("File Category: " + fileCategory + " | File Name: " + fileName + " | File Id: " + fileId
                        + " | " + "Present => " + CollectionUtils.intersection(expected, actual) + " | "
                        + "Difference => " + CollectionUtils.subtract(expected, actual) + " | " + "Extra => "
                        + CollectionUtils.subtract(actual, expected) + " | " + pdType + "Pass Percentage => ["
                        + getPassPercentage(actual, expected) + "]");
            } catch (Exception e1) {
            }
            Logger.info("Assertion Error  : " + actual + " is not equal to " + expected);
            Logger.info("VALUE MISMATCH EXCEPTION");
            throw e;
        }
    }

    public static void assertEquals(final List<String> actual, final List<String> expected, final String message,
                                    String pdType, String fileCategory, String fileName, String fileId) {

        try {
            Logger.info("Expected: " + expected);
            Logger.info("Actual  : " + actual);

            Assert.assertTrue(ListUtils.isEqual(expected, actual), message);

            try {
                Logger.pass("File Category: " + fileCategory + " | File Name: " + fileName + " | File Id: " + fileId
                        + " | " + "Present => " + actual + " | " + "Difference => "
                        + CollectionUtils.subtract(expected, actual) + " | " + "Extra => "
                        + CollectionUtils.subtract(actual, expected) + " | " + pdType + "Pass Percentage => ["
                        + getPassPercentage(actual, expected) + "]");
            } catch (Exception e) {
            }
        } catch (AssertionError e) {
            try {
                Logger.fail("File Category: " + fileCategory + " | File Name: " + fileName + " | File Id: " + fileId
                        + " | " + "Present => " + CollectionUtils.intersection(expected, actual) + " | "
                        + "Difference => " + CollectionUtils.subtract(expected, actual) + " | " + "Extra => "
                        + CollectionUtils.subtract(actual, expected) + " | " + pdType + "Pass Percentage => ["
                        + getPassPercentage(actual, expected) + "]");
            } catch (Exception e1) {
            }
            Logger.info("Assertion Error  : " + actual + " is not equal to " + expected);
            Logger.info("VALUE MISMATCH EXCEPTION");
            throw e;
        }
    }

    public static void assertEquals(final String actual, final String expected, String fieldname,
                                    final String message) {

        try {

            Logger.info("Expected: " + fieldname + " should be equals to " + expected);
            Assert.assertEquals(actual, expected, message);
            Logger.info("Actual  : " + fieldname + " is equal to " + actual, LoggerEnricher.EnricherFactory.BOLD_GREEN);

        } catch (AssertionError e) {
            Logger.error("Actual  : " + fieldname + " is not equal to " + expected,
                    LoggerEnricher.EnricherFactory.BOLD_RED);
            Logger.info("VALUE MISMATCH EXCEPTION");
            throw e;
        }
    }

    public static void assertEquals(final String actual, final String expected, String fieldname, final String message,
                                    boolean printHtml) {

        try {
            if (printHtml) {
                Logger.info("Expected: " + fieldname + " should be equals to " + expected);
            }
            Assert.assertEquals(actual, expected, message);
            if (printHtml) {
                Logger.info("Actual  : " + fieldname + " is equal to " + actual,
                        LoggerEnricher.EnricherFactory.BOLD_GREEN);
            }
        } catch (AssertionError e) {
            if (printHtml) {
                if (!(actual.contains("html") || expected.contains("html")))
                    Logger.error("Actual  : " + fieldname + " is not equal to " + expected,
                            LoggerEnricher.EnricherFactory.BOLD_RED);
            }
            Logger.info("VALUE MISMATCH EXCEPTION");
            throw e;
        }
    }

    public static void assertEquals(final Map<String, String> actual, final Map<String, String> expected,
                                    final String message) {

        Map<String, String> actualTemp = StrUtils.sortMap(actual);
        Map<String, String> expectedTemp = StrUtils.sortMap(expected);

        try {

            MapDifference<String, String> diff = Maps.difference(actualTemp, expectedTemp);
            Map<String, ValueDifference<String>> entriesDiffering = diff.entriesDiffering();

            Assert.assertTrue(entriesDiffering.size() == 0, message);
            Logger.pass("Difference: " + diff.entriesDiffering());

        } catch (AssertionError e) {
            MapDifference<String, String> diff = Maps.difference(actualTemp, expectedTemp);
            Logger.fail("Difference: " + diff.entriesDiffering());

            Logger.info("Assertion Error  : " + actual + " is not equal to " + expected);
            Logger.info("VALUE MISMATCH EXCEPTION");
            throw e;
        }
    }

    public static void assertEquals(final List<String> actual, final List<String> expected, String fieldname,
                                    final String message) {

        try {

            Logger.info("Expected: " + fieldname + " should be equals to " + expected);
            Assert.assertTrue(ListUtils.isEqual(expected, actual), message);
            Logger.info("Actual  : " + fieldname + " is equal to " + actual);

        } catch (AssertionError e) {
            Logger.error("Actual  : " + fieldname + " is not equal to " + expected);
            Logger.info("VALUE MISMATCH EXCEPTION");
            throw e;
        }
    }

    public static void assertEquals(final Set<String> actual, final Set<String> expected, String fieldname,
                                    final String message) {

        try {

            Logger.info("Expected: " + fieldname + " should be equals to " + expected);
            Assert.assertTrue(ListUtils.isEqual(expected, actual), message);
            Logger.info("Actual  : " + fieldname + " is equal to " + actual);

        } catch (AssertionError e) {
            Logger.error("Actual  : " + fieldname + " is not equal to " + expected);
            Logger.info("VALUE MISMATCH EXCEPTION");
            throw e;
        }
    }

    public static void assertiEquals(final String actual, final String expected, String fieldname,
                                     final String message) {

        try {

            Logger.info("Expected: " + fieldname + " should be equals to " + expected.toLowerCase());
            Assert.assertEquals(actual.toLowerCase(), expected.toLowerCase(), message);
            Logger.info("Actual  : " + fieldname + " is equal to " + actual.toLowerCase());

        } catch (AssertionError e) {
            Logger.error("Actual  : " + fieldname + " is not equal to " + expected.toLowerCase());
            Logger.info("VALUE MISMATCH EXCEPTION");
            throw e;
        }
    }

    public static void assertFalse(final boolean condition, final String message) {

        try {
            Logger.info("Expected: " + condition);
            Assert.assertFalse(condition, message);
            Logger.info("Actual  : " + condition);
        } catch (AssertionError e) {
            Logger.info("Actual  : " + condition);
            Logger.info("VALUE_NOT_FALSE EXCEPTION");
            throw e;
        }

    }

    public static void assertFalse(final boolean condition, String expectedLog, String actualLog,
                                   final String message) {
        try {
            Logger.info("Expected: " + expectedLog);
            Assert.assertFalse(condition, message);
            Logger.info("Actual  : " + actualLog);
        } catch (AssertionError e) {
            Logger.info("Actual  : " + actualLog);
            Logger.info("Actual and Expected should not match");
            Logger.info("VALUE_NOT_TRUE EXCEPTION");
            throw e;
        }
    }

    public static void assertNotNull(final Object object, final String message) {
        try {
            Logger.info("Expected: Object not to be null.");
            Assert.assertNotNull(object, message);
            Logger.info("Actual: Object is not null.");
        } catch (AssertionError e) {
            Logger.info("Actual: Object is null.");
            Logger.info("OBJECT NULL EXCEPTION");
            throw e;
        }
    }

    public static void assertNotNull(final Object object, String objectName, final String message) {
        try {
            Logger.info("Expected: " + objectName + " Should not be null.");
            Assert.assertNotNull(object, message);
            Logger.info("Actual: " + objectName + " is not null.");
        } catch (AssertionError e) {
            Logger.info("Actual: " + objectName + " is null.");
            Logger.info("OBJECT NULL EXCEPTION");
            throw e;
        }
    }

    public static void assertEmpty(final String value1, String fieldname, final String message) {
        try {
            Logger.info("Expected: " + fieldname + " should be empty ");
            Assert.assertEquals(value1.length(), 0, message);
            Logger.info("Actual  : " + fieldname + " is empty. It has the value of " + value1);
        } catch (AssertionError e) {
            Logger.info("Actual  : " + fieldname + " is not empty.It has the value of " + value1);
            Logger.info("OBJECT NULL EXCEPTION");
            throw e;
        }
    }

    public static void assertNotEmpty(final Integer intVal, final String message) {
        try {
            Logger.info("Expected: " + intVal + " should be not null and empty ");
            Assert.assertTrue(intVal > 0 && intVal != null, message);
            Logger.info("Actual  : " + intVal + " is not null and empty.");
        } catch (AssertionError e) {
            Logger.info("Actual  : " + intVal + " is null or not empty.");
            Logger.info("OBJECT NULL EXCEPTION");
            throw e;
        }
    }

    public static void assertNotEmpty(final Long intVal, final String message) {
        try {
            Logger.info("Expected: " + intVal + " should be not null and empty ");
            Assert.assertTrue(intVal > 0 && intVal != null, message);
            Logger.info("Actual  : " + intVal + " is not null and empty.");
        } catch (AssertionError e) {
            Logger.info("Actual  : " + intVal + " is null or not empty.");
            Logger.info("OBJECT NULL EXCEPTION");
            throw e;
        }
    }

    public static void assertNotEmpty(final String stringVal, final String message) {
        try {
            Logger.info("Expected: " + stringVal + " should be not null and empty ");
            Assert.assertTrue(StringUtils.isNotBlank(stringVal), message);
            Logger.info("Actual  : " + stringVal + " is not null and empty.");
        } catch (AssertionError e) {
            Logger.info("Actual  : " + stringVal + " is null or not empty.");
            Logger.info("OBJECT NULL EXCEPTION");
            throw e;
        }
    }

    public static void assertEmpty(final String stringVal, final String message) {
        try {
            Logger.info("Expected: " + stringVal + " should be null and empty ");
            Assert.assertTrue(StringUtils.isBlank(stringVal), message);
            Logger.info("Actual  : " + stringVal + " is null and empty.");
        } catch (AssertionError e) {
            Logger.info("Actual  : " + stringVal + " is not null or empty.");
            Logger.info("OBJECT NULL EXCEPTION");
            throw e;
        }
    }

    public static void assertNotEmpty(final Integer value, final String fieldname, final String message) {
        try {
            Logger.info("Expected: " + fieldname + " value " + value + " should be not null and empty ");
            Assert.assertTrue(value > 0 && value != null, message);
            Logger.info("Actual: " + fieldname + " value " + value + " is not null and empty ");
        } catch (AssertionError e) {
            Logger.info("Expected: " + fieldname + " value " + value + " is null and empty ");
            Logger.info("OBJECT NULL EXCEPTION");
            throw e;
        }
    }

    public static void assertNotEmpty(final boolean value, final String fieldname, final String message) {
        try {
            Logger.info("Expected: " + fieldname + " value " + value + " should be not null and empty ");
            String booleanValue = String.valueOf(value);
            Assert.assertTrue(booleanValue != null && booleanValue.length() > 0, message);
            Logger.info("Actual: " + fieldname + " value " + value + " is not null and empty ");
        } catch (AssertionError e) {
            Logger.info("Expected: " + fieldname + " value " + value + " is null and empty ");
            Logger.info("OBJECT NULL EXCEPTION");
            throw e;
        }
    }

    public static void assertNotEmpty(final Double value, final String fieldname, final String message) {
        try {
            Logger.info("Expected: " + fieldname + " value " + value + " should be not null and empty ");
            Assert.assertTrue(value > 0 && value != null, message);
            Logger.info("Actual: " + fieldname + " value " + value + " is not null and empty ");
        } catch (AssertionError e) {
            Logger.info("Expected: " + fieldname + " value " + value + " is null and empty ");
            Logger.info("OBJECT NULL EXCEPTION");
            throw e;
        }
    }

    public static void assertNotEmpty(final Long value, final String fieldname, final String message) {
        try {
            Logger.info("Expected: " + fieldname + " value " + value + " should be not null and empty ");
            Assert.assertTrue(value > 0 && value != null, message);
            Logger.info("Actual: " + fieldname + " value " + value + " is not null and empty ");
        } catch (AssertionError e) {
            Logger.info("Expected: " + fieldname + " value " + value + " is null and empty ");
            Logger.info("OBJECT NULL EXCEPTION");
            throw e;
        }
    }

    public static void assertNotEmpty(final String val, String fieldname, final String message) {
        try {
            Logger.info("Expected: " + fieldname + " value " + val + " should be not null and empty ");
            Assert.assertTrue(val != null && val.length() > 0, message);
            Logger.info("Actual: " + fieldname + " value " + val + " is not null and empty ");
        } catch (AssertionError e) {
            Logger.info("Expected: " + fieldname + " value " + val + " is null and empty ");
            Logger.info("OBJECT NULL EXCEPTION");
            throw e;
        }
    }

    public static void assertNotSame(final Object actual, final Object expected, final String message) {
        try {
            Assert.assertNotSame(actual, expected, message);
        } catch (AssertionError e) {
            Logger.info("OBJECT_NOT_SAME EXCEPTION");
            throw e;
        }

    }

    public static void assertNull(final Object object, final String message) {
        try {
            Assert.assertNull(object, message);
        } catch (AssertionError e) {
            Logger.info("OBJECT_NOT_NULL EXCEPTION");
            throw e;
        }
    }

    public static void assertSame(final Object actual, final Object expected, final String message) {
        try {
            Assert.assertSame(actual, expected, message);
        } catch (AssertionError e) {
            Logger.info("OBJECT_NOT_SAME EXCEPTION");
            throw e;
        }
    }

    public static void assertContains(final String actual, final String expected, final String message) {
        try {
            Logger.info("Expected: " + expected);
            Logger.info("Actual: " + actual);
            Assert.assertTrue(actual.contains(expected), message);
        } catch (AssertionError e) {
            Logger.info("OBJECT_DOES_NOT_CONTAIN EXCEPTION");
            throw e;
        }
    }

    public static void assertTrue(final boolean condition, final String message) {
        try {
            Logger.info("Expected: " + true);
            Assert.assertTrue(condition, message);
            Logger.info("Actual  : " + condition);
        } catch (AssertionError e) {
            Logger.info("Actual  : " + condition);
            Logger.info("VALUE_NOT_TRUE EXCEPTION");
            throw e;
        }
    }

    public static void assertJsonEquals(String expected, String actual, boolean strictMode) {
        try {
            Logger.info("Expected: " + expected);
            JSONAssert.assertEquals(expected, actual, strictMode);
            Logger.info("Actual  : " + actual);
            Logger.info("Json Strings match");
        } catch (AssertionError e) {
            Logger.info("Json Strings not matching");
            Logger.info("VALUE MISMATCH EXCEPTION");
            throw e;
        }
    }

    public static void assertTrue(final boolean condition, String logMessage, final String message) {
        try {
            Logger.info("Expected: " + true);
            Assert.assertTrue(condition, message);
            Logger.info("Actual  : " + logMessage);
        } catch (AssertionError e) {
            Logger.info("Actual  : " + condition);
            Logger.info("VALUE_NOT_TRUE EXCEPTION");
            throw e;
        }
    }

    public static void assertTrue(final boolean condition, String expectedLog, String actualLog, final String message) {
        try {
            Logger.info("Expected: " + expectedLog);
            Assert.assertTrue(condition, message);
            Logger.info("Actual  : " + actualLog);
        } catch (AssertionError e) {
            Logger.info("Actual  : " + message);
            Logger.info("VALUE_NOT_TRUE EXCEPTION");
            throw e;
        }
    }

    public static void fail(final String message) {
        try {
            Assert.fail(message);
        } catch (AssertionError e) {
            Logger.info("FAIL EXCEPTION");
            throw e;
        }
    }

    public static void assertContains(boolean condition, String actual, String expected, final String message) {
        try {
            Logger.info("Expected: " + actual + " should contain " + expected);
            Assert.assertTrue(condition, message);
            Logger.info("Actual  : " + actual + " contains " + expected);

        } catch (AssertionError e) {
            Logger.info("Actual  : " + actual + " not contains " + expected);
            Logger.info("VALUE_NOT_TRUE EXCEPTION");
            throw e;
        }
    }

    public static void assertStartsWith(boolean condition, String actual, String expected, final String message) {
        try {
            Logger.info("Expected: " + actual + " should starts with " + expected);
            Assert.assertTrue(condition, message);
            Logger.info("Actual  : " + actual + " starts with " + expected);

        } catch (AssertionError e) {
            Logger.info("Actual  : " + actual + " not starts with " + expected);
            Logger.info("VALUE_NOT_TRUE EXCEPTION");
            throw e;
        }
    }

    public static void assertStartsWith(String actual, String expected, final String message) {
        try {
            Logger.info("Expected: " + actual + " should starts with " + expected);
            Assert.assertTrue(actual.startsWith(expected), message);
            Logger.info("Actual  : " + actual + " starts with " + expected);

        } catch (AssertionError e) {
            Logger.info("Actual  : " + actual + " not starts with " + expected);
            Logger.info("VALUE_NOT_TRUE EXCEPTION");
            throw e;
        }
    }

    public static void assertEndsWith(boolean condition, String actual, String expected, final String message) {
        try {
            Logger.info("Expected: " + actual + " should ends with " + expected);
            Assert.assertTrue(condition, message);
            Logger.info("Actual  : " + actual + " ends with " + expected);

        } catch (AssertionError e) {
            Logger.info("Actual  : " + actual + " not ends with " + expected);
            Logger.info("VALUE_NOT_TRUE EXCEPTION");
            throw e;
        }
    }

    public static void assertEndsWith(String actual, String expected, final String message) {
        try {
            Logger.info("Expected: " + actual + " should ends with " + expected);
            Assert.assertTrue(actual.endsWith(expected), message);
            Logger.info("Actual  : " + actual + " ends with " + expected);

        } catch (AssertionError e) {
            Logger.info("Actual  : " + actual + " not ends with " + expected);
            Logger.info("VALUE_NOT_TRUE EXCEPTION");
            throw e;
        }
    }

    public static void assertThat(final String reason, final boolean assertion) {
        MatcherAssert.assertThat(reason, assertion);

    }

    // assertThat("myValue", allOf(startsWith("my"), containsString("Val")));
    public static <T> void assertThat(final String reason, final T actual, final Matcher<? super T> matcher) {
        MatcherAssert.assertThat(reason, actual, matcher);

    }

    public static <T> void assertThat(final T actual, final Matcher<? super T> matcher) {
        MatcherAssert.assertThat(actual, matcher);

    }

    public static void assertSoftly(Consumer<SoftAssert> softly) {
        SoftAssert assertions = new SoftAssert();
        softly.accept(assertions);
        assertions.assertAll();
    }

}
