package com.cursee.time_on_display.impl.client;

import com.cursee.time_on_display.Constants;
import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import io.github.jason13official.monolib.api.common.config.ConfigGetterSetter.Commented;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Deprecated(forRemoval = true)
public class LegacyConfigAdapter {

  public static final String LEGACY_FILENAME = Constants.MOD_ID + ".toml";

  @SuppressWarnings({ "rawtypes", "unchecked" })
  public static void migrate(Path configDir, List<Commented<?>> entries) {

    Path legacyFilepath = configDir.resolve(LEGACY_FILENAME);
    if (!Files.exists(legacyFilepath)) {
      return;
    }

    try (CommentedFileConfig legacy = CommentedFileConfig.builder(legacyFilepath).build()) {

      legacy.load();

      for (Commented entry : entries) {
        if (legacy.contains(entry.key())) {
          entry.set(legacy.get(entry.key()));
        }
      }
    } catch (Exception e) {

      Constants.LOG.info("Failed to migrate legacy config file {}", legacyFilepath.toAbsolutePath());
      return;
    }

    try {

      Files.move(legacyFilepath, configDir.resolve(LEGACY_FILENAME + ".OLD"), StandardCopyOption.REPLACE_EXISTING);
      Constants.LOG.info("Migrated legacy config file {} and renamed it to {}.OLD", LEGACY_FILENAME, LEGACY_FILENAME);
    } catch (Exception e) {

      Constants.LOG.info("Failed to rename legacy config file {}", legacyFilepath.toAbsolutePath());
    }
  }
}
