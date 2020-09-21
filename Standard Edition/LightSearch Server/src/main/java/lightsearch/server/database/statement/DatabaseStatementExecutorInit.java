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
package lightsearch.server.database.statement;

import lightsearch.server.database.DatabaseConnection;
import lightsearch.server.database.cmd.message.DatabaseCommandMessage;

/**
 *
 * @author ViiSE
 */
public class DatabaseStatementExecutorInit {
    
    public static DatabaseStatementExecutor databaseStatementExecutor(DatabaseConnection databaseConnection,
            long lsCode, String dateTime, DatabaseCommandMessage databaseCommandMessage) {
        return new DatabaseStatementExecutorDefaultImpl(databaseConnection, lsCode, dateTime, databaseCommandMessage);
    }
}
