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

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * Реализация интерфейса {@link lightsearch.server.time.CurrentDateTime} по умолчанию.
 * <p>
 * Шаблоны для даты и времени предоставляет {@link lightsearch.server.time.CurrentDateTimePattern}.
 * @author ViiSE
 * @since 1.0.0
 */
public class CurrentDateTimeDefaultImpl implements CurrentDateTime {

    @Override
    public String dateTimeInStandardFormat() {
        // FIXME: 20.08.2019 I think it can be better
        SimpleDateFormat nice = new SimpleDateFormat(CurrentDateTimePattern.DATE_TIME_IN_STANDARD_FORM.getPattern());
        GregorianCalendar cal = new GregorianCalendar();
        java.util.Date date = cal.getTime();

        return nice.format(date);
    }

    @Override
    public String dateTimeWithDot() {
        // FIXME: 20.08.2019 I think it can be better
        SimpleDateFormat nice = new SimpleDateFormat(CurrentDateTimePattern.DATE_TIME_WITH_DOT.getPattern());
        GregorianCalendar cal = new GregorianCalendar();
        java.util.Date date = cal.getTime();

        return nice.format(date);
    }

    @Override
    public String dateLog() {
        // FIXME: 20.08.2019 I think it can be better
        SimpleDateFormat nice = new SimpleDateFormat(CurrentDateTimePattern.DATE_LOG.getPattern());
        GregorianCalendar cal = new GregorianCalendar();
        java.util.Date date = cal.getTime();

        return nice.format(date);
    }
    
}
