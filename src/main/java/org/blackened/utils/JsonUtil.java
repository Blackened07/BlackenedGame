package org.blackened.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.blackened.db.account.GameAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class JsonUtil {

    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    private JsonUtil() {}

    public static <T> T  parseFromJson(String pathName, Class<T> source) {
        logger.info("Начало загрузки из: {}", pathName);
        System.out.println("piska "+ pathName);
        Path path = Paths.get(pathName);
        try {
            String inputJson = Files.readString(path);
            T result = GSON.fromJson(inputJson, source);
            logger.info("Загрузка завершена");
            return result;
        } catch (IOException e) {
            logger.error("Ошибка чтения файла: {}; {}", pathName, e.getMessage());
        }
        return null;
    }

    public static <T> void parseToJson(String pathName, T object) {
        logger.info("Начало преобразования в: {}", pathName);
        Path path = Paths.get(pathName);
        try {
            String outputJson = GSON.toJson(object);
            Files.writeString(path, outputJson);
            logger.info("Преобразование завершено");
        } catch (IOException e) {
            logger.error("Ошибка записи в файл: {}; {}", pathName, e.getMessage());
        }
    }
}
