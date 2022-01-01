
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE sc_contacts.contacts
(
    contact_id uuid    NOT NULL DEFAULT uuid_generate_v4(),
    first_name VARCHAR NOT NULL,
    last_name  VARCHAR NOT NULL,
    email      VARCHAR NOT NULL,
    phone      VARCHAR,
    PRIMARY KEY (contact_id)
);

INSERT INTO sc_contacts.contacts (first_name,
                                  last_name,
                                  email,
                                  phone)
VALUES ('Kwaku',
        'Ofosu',
        'kwaku.ofosu@gmail.com',
        '233-244-455098'),
       ('Ohemaa',
        'Agyeiwaa',
        'ohemaa.agyeiwaa@live.com',
        '233-201-401333'),
       ('Kwame',
        'Mensah',
        'kwame.mensah@yahoo.com',
        '233-277-875499'),
       ('Adwoa',
        'Gyimah',
        'adwoa.gyimah@twitter.com',
        '233-266-398211');