CREATE TABLE country
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(100) NOT NULL,
    population INT          NOT NULL DEFAULT 0,
    currency   VARCHAR(50)
        check ( population >= 0 )
);

INSERT INTO country (name, population, currency) VALUES ('Viet Nam', 98000000, 'VND');
INSERT INTO country (name, population, currency) VALUES ('United State of America', 30000000, 'USD');
INSERT INTO country (name, population, currency) VALUES ('England', 20000000, 'GBP');
INSERT INTO country (name, population, currency) VALUES ('Germany', 58000000, 'EUR');