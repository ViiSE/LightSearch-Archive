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
package lightsearch.server.thread;

/**
 * Управляет потоками LightSearch Server. Может корректно завершать поток по его идентификатору.
 * <p>
 * Также можно завершить работу всех потоков, кроме таймера перезагрузки сервера. В текущей реализации LightSearch Server
 * только таймер перезагрузки после истечения времени перезагрузки вызывает данный метод.
 * @author ViiSE
 * @since 1.0.0
 */
public interface ThreadManager {
    ThreadHolder holder();
    boolean interrupt(String id);
    boolean interruptAll(String timerId);
}
