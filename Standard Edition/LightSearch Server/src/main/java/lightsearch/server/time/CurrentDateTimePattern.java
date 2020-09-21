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
package lightsearch.server.time;

/**
 * Шаблоны для вывода текущей даты и времени.
 * @author ViiSE
 * @since 1.0.0
 */
public enum CurrentDateTimePattern {

    DATE_TIME_IN_STANDARD_FORM_WITH_MS("yyyy-MM-dd HH:mm:ss.S"),
    DATE_TIME_IN_STANDARD_FORM("yyyy-MM-dd HH:mm:ss"),
    DATE_TIME_WITH_DOT("dd.MM.yyyy HH:mm:ss"),
    DATE_LOG("dd-MM-yyyy");

    private final String pattern;

    private CurrentDateTimePattern(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() { return pattern; }
}
