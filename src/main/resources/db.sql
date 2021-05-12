DROP TABLE IF EXISTS operation;
DROP TABLE IF EXISTS sort;

CREATE TABLE sort(
                     id BIGSERIAL PRIMARY KEY NOT NULL,
                     type_id BIGINT NOT NULL,
                     type VARCHAR(20) NOT NULL
);


CREATE TABLE operation(
                          id BIGSERIAL PRIMARY KEY NOT NULL,
                          suma BIGINT NOT NULL,
                          sort_id BIGINT REFERENCES sort (id),
                          date DATE NOT NULL,
                          method VARCHAR(100) NOT NULL,
                          INFO VARCHAR(255)
);

ALTER TABLE operation OWNER TO baigiamasis;

ALTER TABLE sort OWNER TO baigiamasis;

INSERT INTO sort (type_id, type)
VALUES(1, 'income');
INSERT INTO sort (type_id, type)
VALUES(2, 'costs');

INSERT INTO operation (suma, sort_id, date, method, INFO)
VALUES(100, 1, '2021-01-30','cash', 'gavo pinigu');