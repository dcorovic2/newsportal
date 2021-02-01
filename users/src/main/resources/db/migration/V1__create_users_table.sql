CREATE TABLE users (
    id UUID PRIMARY KEY,
    username VARCHAR NOT NULL UNIQUE,
    password VARCHAR NOT NULL,
    first_name VARCHAR NOT NULL,
    last_name VARCHAR NOT NULL,
    email VARCHAR NOT NULL,
    role VARCHAR NOT NULL
);

INSERT INTO users (id, username, password, first_name, last_name, email, role) VALUES
    ('d052ede9-d6fe-4bd5-ae4f-31894f7e55b0', 'dino', 'test', 'Dino', 'Satrovic', 'dsatrovic1@gmail.com', 'ADMIN'),
    ('3a8e19f5-77a1-43e6-9d48-31519eec2353', 'user', 'test', 'Dino', 'Satrovic', 'dsatrovic1@gmail.com', 'USER');
