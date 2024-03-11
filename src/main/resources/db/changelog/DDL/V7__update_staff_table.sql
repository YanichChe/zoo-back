ALTER TABLE staff
    ADD COLUMN photo_id integer default 4
        REFERENCES files(id)
            ON DELETE SET NULL;

UPDATE staff SET photo_id = 28 WHERE id = 1;
UPDATE staff SET photo_id = 29 WHERE id = 2;
UPDATE staff SET photo_id = 30 WHERE id = 3;
UPDATE staff SET photo_id = 31 WHERE id = 4;
UPDATE staff SET photo_id = 32 WHERE id = 5;
UPDATE staff SET photo_id = 33 WHERE id = 6;
UPDATE staff SET photo_id = 34 WHERE id = 7;