CREATE TABLE country
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(100) NOT NULL,
    population INT          NOT NULL DEFAULT 0,
    currency   VARCHAR(50)
        check ( population >= 0 )
);