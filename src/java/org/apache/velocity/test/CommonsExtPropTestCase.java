package org.apache.velocity.test;

/*
 * Copyright 2001-2004 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.FileWriter;

import java.util.Iterator;
import java.util.Vector;

import org.apache.commons.collections.ExtendedProperties;


/**
 * Tests for the Commons ExtendedProperties class. This is an identical
 *  copy of the ConfigurationTestCase, which will disappear when
 *  the Configuration class does
 *
 * @version $Id: CommonsExtPropTestCase.java,v 1.3 2004/02/27 18:43:19 dlr Exp $
 */
public class CommonsExtPropTestCase extends BaseTestCase
{
    /**
     * Comparison directory.
     */
    private static final String COMPARE_DIR = 
        "../test/configuration/compare";
    
    /**
     * Results directory.
     */
    private static final String RESULTS_DIR = 
        "../test/configuration/results";

    /**
     * Test configuration
     */
    private static final String TEST_CONFIG = 
        "../test/configuration/test.config";

    /**
     * Creates a new instance.
     *
     */
    public CommonsExtPropTestCase()
    {
        super("CommonsExtPropTestCase");
    }

    public static junit.framework.Test suite()
    {
        return new CommonsExtPropTestCase();
    }

    /**
     * Runs the test.
     */
    public void runTest ()
    {
        try
        {
            assureResultsDirectoryExists(RESULTS_DIR);
            
            ExtendedProperties c = new ExtendedProperties(TEST_CONFIG);
            
            FileWriter result = new FileWriter(
                getFileName(RESULTS_DIR, "output", "res"));
            
            message(result, "Testing order of keys ...");
            showIterator(result, c.getKeys());
            
            message(result, "Testing retrieval of CSV values ...");
            showVector(result, c.getVector("resource.loader"));            

            message(result, "Testing subset(prefix).getKeys() ...");
            ExtendedProperties subset = c.subset("file.resource.loader");
            showIterator(result, subset.getKeys());

            message(result, "Testing getVector(prefix) ...");
            showVector(result, subset.getVector("path"));            

            message(result, "Testing getString(key) ...");
            result.write(c.getString("config.string.value"));
            result.write("\n\n");

            message(result, "Testing getBoolean(key) ...");
            result.write(new Boolean(c.getBoolean("config.boolean.value")).toString());
            result.write("\n\n");

            message(result, "Testing getByte(key) ...");
            result.write(new Byte(c.getByte("config.byte.value")).toString());
            result.write("\n\n");

            message(result, "Testing getShort(key) ...");
            result.write(new Short(c.getShort("config.short.value")).toString());
            result.write("\n\n");

            message(result, "Testing getInt(key) ...");
            result.write(new Integer(c.getInt("config.int.value")).toString());
            result.write("\n\n");

            message(result, "Testing getLong(key) ...");
            result.write(new Long(c.getLong("config.long.value")).toString());
            result.write("\n\n");

            message(result, "Testing getFloat(key) ...");
            result.write(new Float(c.getFloat("config.float.value")).toString());
            result.write("\n\n");

            message(result, "Testing getDouble(key) ...");
            result.write(new Double(c.getDouble("config.double.value")).toString());
            result.write("\n\n");

            message(result, "Testing escaped-comma scalar...");
            result.write( c.getString("escape.comma1"));
            result.write("\n\n");

            message(result, "Testing escaped-comma vector...");
            showVector(result,  c.getVector("escape.comma2"));
            result.write("\n\n");

            result.flush();
            result.close();
            
            if (!isMatch(RESULTS_DIR, COMPARE_DIR, "output","res","cmp"))
            {
                fail("Output incorrect.");
            }
        }
        catch (Exception e)
        {
            System.err.println("Cannot setup CommonsExtPropTestCase!");
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void showIterator(FileWriter result, Iterator i)
        throws Exception
    {
        while(i.hasNext())
        {
            result.write((String) i.next());
            result.write("\n");
        }
        result.write("\n");
    }

    private void showVector(FileWriter result, Vector v)
        throws Exception
    {
        for (int j = 0; j < v.size(); j++)
        {
            result.write((String) v.get(j));
            result.write("\n");
        }
        result.write("\n");
    }

    private void message(FileWriter result, String message)
        throws Exception
    {
        result.write("--------------------------------------------------\n");
        result.write(message + "\n");
        result.write("--------------------------------------------------\n");
        result.write("\n");
    }
}








