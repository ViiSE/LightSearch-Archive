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

package lightsearch.updater.release.info;

import lightsearch.updater.LightSearchUpdater;
import lightsearch.updater.exception.ReleaseInfoException;
import lightsearch.updater.producer.release.info.ReleaseInfoSaverProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static lightsearch.updater.message.TestMessage.*;
import static org.testng.Assert.assertNotNull;

@SpringBootTest(classes = LightSearchUpdater.class)
public class ReleaseInfoSaverTestNG extends AbstractTestNGSpringContextTests {

    @Autowired
    private ReleaseInfoSaverProducer releaseInfoSaverProducer;

    @Test
    @Parameters({"infoContent"})
    public void saveInfo(String infoContent) {
        testBegin("ReleaseInfoSaver", "saveInfo()");

        ReleaseInfoSaver releaseInfoSaver = releaseInfoSaverProducer.getReleaseInfoSaverToFileInstance();
        assertNotNull(releaseInfoSaver, "ReleaseInfoSaver is null!");

        try {
            releaseInfoSaver.saveInfo(infoContent);
            System.out.println("Info is saved");
        } catch (ReleaseInfoException ex) {
            catchMessage(ex);
        }

        testEnd("ReleaseInfoSaver", "saveInfo()");
    }
}
