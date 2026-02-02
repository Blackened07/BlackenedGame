package org.blackened.utils;

import org.blackened.db.account.GameAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Optional;

public final class JsonWriter {
    private static final Logger logger = LoggerFactory.getLogger(JsonWriter.class);
    //private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd_HH-mm");
    private static final String ACCOUNT_FILE_NAME = "_account_saved.json";

    private JsonWriter() {
    }

    public static void write(GameAccount account, String login) {
        logger.info("Начало преобразования в Json");
        String fileName = "accounts" + "/" + login +  ACCOUNT_FILE_NAME;
        Path full = Paths.get(PropertiesUtil.getProperty(PropertiesUtil.JSON_PATH)).resolve(fileName);
        try {
            Optional.ofNullable(full.getParent()).ifPresent(p -> {
                try {
                    createJsonDir(p);
                } catch (IOException e) {
                    logger.error("Ошибка записи; {}", e.getMessage());
                }
            });
            JsonUtil.parseToJson(full.toString(), account);

        } catch (Exception e) {
            //rework
            throw new RuntimeException(e);
        }
        logger.info("Преобразование в Json завершено");
    }

    private static void createJsonDir(Path dirPath) throws IOException {
        try {
            Files.createDirectories(dirPath);
            logger.info("Директория успешно создана");
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
    }

}
