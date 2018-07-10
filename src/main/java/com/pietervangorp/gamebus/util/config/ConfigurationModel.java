package com.pietervangorp.gamebus.util.config;

import lombok.Data;

/**
 * Created by pvgorp on 29/12/2017.
 */
@Data
public class ConfigurationModel {
    private ColumnMapping[] columnMappings;
    private DatabaseConfig databaseConfig;
    private FlushTableConfig[] flushTableConfigs;
}
