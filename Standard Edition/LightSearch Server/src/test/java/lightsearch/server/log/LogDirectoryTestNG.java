/* 
 * Copyright 2019 ViiSE.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package lightsearch.server.log;

import lightsearch.server.initialization.OsDetector;
import lightsearch.server.initialization.OsDetectorInit;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static test.message.TestMessage.testBegin;
import static test.message.TestMessage.testEnd;

/**
 *
 * @author ViiSE
 */
public class LogDirectoryTestNG {
    
    @Test
    @Parameters({"logDirectory"})
    public void logDirectory(String logName) {
        testBegin("LogDirectory", "logDirectory()");

        assertFalse(logName.contains("\\"), "Log Name contains \\ !");
        assertFalse(logName.contains("~"),  "Log Name contains ~ !");
        assertFalse(logName.contains("%"),  "Log Name contains % !");
        assertFalse(logName.contains("&"),  "Log Name contains & !");
        assertFalse(logName.contains("*"),  "Log Name contains * !");
        assertFalse(logName.contains("{"),  "Log Name contains { !");
        assertFalse(logName.contains("}"),  "Log Name contains { !");
        assertFalse(logName.contains(":"),  "Log Name contains : !");
        assertFalse(logName.contains("<"),  "Log Name contains < !");
        assertFalse(logName.contains(">"),  "Log Name contains > !");
        assertFalse(logName.contains("?"),  "Log Name contains ? !");
        assertFalse(logName.contains("/"),  "Log Name contains / !");
        assertFalse(logName.contains("+"),  "Log Name contains + !");
        assertFalse(logName.contains("|"),  "Log Name contains | !");
        assertFalse(logName.contains("\""), "Log Name contains \" !");
        
        
        LogDirectory logDirectory = LogDirectoryInit.logDirectory(logName);
        String logDir = logDirectory.logDirectory();
        assertNotNull(logDir, "Log directory is null!");
        assertNotEquals(logDir, "", "Log directory is null!");
        
        OsDetector osDetector = OsDetectorInit.osDetector();
        if(osDetector.isWindows())
            assertTrue(logDir.endsWith("\\"), "Log directory not ends with \\!");
        else if(osDetector.isLinux() || osDetector.isMacOS())
            assertTrue(logDir.endsWith("/"), "Log directory not ends with /!");
        
        System.out.println(logDir);
        
        testEnd("LogDirectory", "logDirectory()");
    }
}
