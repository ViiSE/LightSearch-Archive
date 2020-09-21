/*
 * ViiSE (C). 2019. All rights reserved.
 * 
 *
 * This program is owned by ViiSE.
 * Modification and use of this source code for its own purposes is allowed only
 * with the consent of the author of this source code.
 * If you want to contact the author, please, send an email to: viise@outlook.com
 */
package lightsearch.server.security;

/**
 * Генерирует хэш строки.
 * <p>
 * Используется для генирации хэша пароля администратора.
 * @author ViiSE
 * @see lightsearch.server.initialization.AdministratorsMap
 * @since 1.0.0
 */
public interface HashAlgorithms {
    String sha256(String message);
}
