package org.blackened.utils;

import org.blackened.db.account.GameAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

import static org.blackened.utils.PropertiesUtil.JSON_PATH;

public final class JsonReader {

    public static final String PATH = PropertiesUtil.getProperty(JSON_PATH) + "accounts";
    private static final Logger logger = LoggerFactory.getLogger(JsonReader.class);

    public static GameAccount load() {

        Path accountsPath = Paths.get(PATH);

        try (Stream<Path> jsonDirs = Files.list(accountsPath)) {

            logger.info("start finding directories");

            return jsonDirs
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".json"))
                    .map(JsonReader::read)
                    .filter(Objects::nonNull)
                    .findFirst()
                    .orElse(null);

        } catch (IOException e) {
            logger.error("Error finding directory");
        }
        return new GameAccount("Empty", "");
    }

    private static GameAccount read(Path directory) {
        logger.info("Start parsing json file to game model");
        GameAccount result = JsonUtil.parseFromJson(directory.toString(), GameAccount.class);
        logger.info("Parsing to game model ends");
        return result;
    }

}
