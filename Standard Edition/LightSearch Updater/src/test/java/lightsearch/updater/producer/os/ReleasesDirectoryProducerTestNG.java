/*
 *  Copyright 2019 ViiSE
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package lightsearch.updater.producer.os;

import lightsearch.updater.LightSearchUpdater;
import lightsearch.updater.os.ReleasesDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static lightsearch.updater.message.TestMessage.testBegin;
import static lightsearch.updater.message.TestMessage.testEnd;
import static org.testng.Assert.assertNotNull;

@SpringBootTest(classes = LightSearchUpdater.class)
public class ReleasesDirectoryProducerTestNG extends AbstractTestNGSpringContextTests {

    @Autowired
    private ReleasesDirectoryProducer releasesDirectoryProducer;

    @Test
    public void getReleasesDirectoryDefaultInstance() {
        testBegin("ReleasesDirectoryProducer", "getReleasesDirectoryDefaultInstance()");

        assertNotNull(releasesDirectoryProducer, "ReleasesDirectoryProducer is null!");

        ReleasesDirectory releasesDirectory = releasesDirectoryProducer.getReleasesDirectoryDefaultInstance();
        assertNotNull(releasesDirectory, "ReleasesDirectory is null!");

        System.out.println("ReleasesDirectory: " + releasesDirectory);

        testEnd("ReleasesDirectoryProducer", "getReleasesDirectoryDefaultInstance()");
    }

    @Test
    public void getReleasesDirectoryWindowsInstance() {
        testBegin("ReleasesDirectoryProducer", "getReleasesDirectoryWindowsInstance()");

        assertNotNull(releasesDirectoryProducer, "ReleasesDirectoryProducer is null!");

        ReleasesDirectory releasesDirectory = releasesDirectoryProducer.getReleasesDirectoryWindowsInstance();
        assertNotNull(releasesDirectory, "ReleasesDirectory is null!");

        System.out.println("ReleasesDirectory: " + releasesDirectory);

        testEnd("ReleasesDirectoryProducer", "getReleasesDirectoryWindowsInstance()");
    }
}
