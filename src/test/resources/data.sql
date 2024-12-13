CREATE TABLE IF NOT EXISTS users (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255)
);

INSERT INTO users (id, name, email) VALUES (3, 'Aayu', 'aa@example.com');
INSERT INTO users (id, name, email) VALUES (4, 'Aryan', 'bb@example.com');
