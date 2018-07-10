package com.pietervangorp.gamebus.util.config;

import lombok.Data;

/**
 * Created by pvgorp on 29/12/2017.
 */
@Data
public class DatabaseConfig {
    private String driver;
    private String url;
    private String username;
    private String password; // FIXME: avoid to store this in a shared location
    private boolean updatesEnabled= false;
}
