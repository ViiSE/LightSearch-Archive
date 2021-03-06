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
package lightsearch.daemon.creator;

import lightsearch.daemon.os.detector.OsDetector;
import lightsearch.daemon.type.Daemon;
import lightsearch.daemon.type.DaemonInit;

/**
 *
 * @author ViiSE
 */
public class DaemonCreatorDefaultImpl implements DaemonCreator {

    private final OsDetector osDetector;
    
    public DaemonCreatorDefaultImpl(OsDetector osDetector) {
        this.osDetector = osDetector;
    }

    @Override
    public Daemon createDaemon(String lightSearchServerName) {
        if(osDetector.isWindows())
            return DaemonInit.daemonWindows(lightSearchServerName);
        else if(osDetector.isLinux())
            throw new UnsupportedOperationException("Not supported yet.");
        else if(osDetector.isMacOS())
            throw new UnsupportedOperationException("Not supported yet.");
        else
            throw new UnsupportedOperationException("Not supported yet.");
    }
}
