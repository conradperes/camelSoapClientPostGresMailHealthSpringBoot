    CREATE TABLE COUNTRIES(
        COUNTRY_I SERIAL,
        NAME TEXT,
        COUNTRY_CODE TEXT,
        CRTE_TS TIMESTAMPTZ NULL default current_timestamp
    );