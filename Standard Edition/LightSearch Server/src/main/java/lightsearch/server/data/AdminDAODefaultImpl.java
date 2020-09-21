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
package lightsearch.server.data;

/**
 * Реализация интерфейса {@link lightsearch.server.data.AdminDAO} по умолчанию.
 * <p>
 * Количество попыток авторизации администратора определяет поле {@link #MAX_TRY}.
 * @author ViiSE
 * @since 2.0.0
 */
public class AdminDAODefaultImpl implements AdminDAO {

    private String name;
    private boolean isFirst = true;
    private final short MAX_TRY = 3;
    private short tryNumber = 0;
    
    @Override
    public String name() {
        return name;
    }

    /**
     * Проверяет, в первый ли раз администратор делает попытку авотризации или нет.
     * @return {@code false}, если администратор прошел авторизацию на LightSearch Server, иначе - {@code true}.
     */
    @Override
    public boolean isFirst() {
        return isFirst;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Устанавливает, в первый ли раз администратор делает попытку авторизации или нет.
     * @param isFirst {@code false}, если администратор прошел авторизацию на LightSearch Server, иначе - {@code true}.
     */
    @Override
    public void setIsFirst(boolean isFirst) {
        this.isFirst = isFirst;
    }

    @Override
    public short tryNumber() {
        return tryNumber;
    }

    @Override
    public void incrementTryNumber() {
        ++tryNumber;
    }

    @Override
    public short maxTryNumber() {
        return MAX_TRY;
    }
}
