CREATE TABLE IF NOT EXISTS shareHolder
(
    id                serial primary key,
    nameOfShareHolder varchar(50) not null,
    phoneNumber       varchar(50) not null unique,
    nationalCode      varchar(50) not null unique
);
CREATE TABLE IF NOT EXISTS brand
(
    id          serial primary key,
    nameOfBrand varchar(50) not null unique,
    website     varchar(50) not null unique,
    description varchar(50) not null
);
CREATE TABLE IF NOT EXISTS shareHolder_brand
(
    id            serial primary key,
    shareHolderId int references shareHolder,
    brandId       int references brand
);
CREATE TABLE IF NOT EXISTS categories
(
    id               serial primary key,
    nameOfCategories varchar(50) not null unique,
    description      varchar(50) not null
);
CREATE TABLE IF NOT EXISTS product
(
    id            serial primary key,
    nameOfProduct varchar(50) not null unique,
    createDate    varchar(50) not null,
    categoriesId  int references categories,
    brandId       int references brand
);
CREATE TABLE IF NOT EXISTS users
(
    id              serial primary key,
    nameOfUsers     varchar(50) not null,
    username        varchar(50) not null unique,
    email           varchar(50) not null unique,
    passwordOfUsers varchar(50) not null
);
INSERT INTO shareHolder (nameOfShareHolder, phoneNumber, nationalCode)
VALUES ('ShareHolder1', '123456789', 'ABC123'),
       ('ShareHolder2', '987654321', 'XYZ789'),
       ('ShareHolder3', '555555555', 'DEF456'),
       ('ShareHolder4', '111111111', 'GHI789'),
       ('ShareHolder5', '999999999', 'JKL123');

INSERT INTO brand (nameOfBrand, website, description)
VALUES ('Brand1', 'www.brand1.com', 'Description1'),
       ('Brand2', 'www.brand2.com', 'Description2'),
       ('Brand3', 'www.brand3.com', 'Description3'),
       ('Brand4', 'www.brand4.com', 'Description4'),
       ('Brand5', 'www.brand5.com', 'Description5');

INSERT INTO shareHolder_brand (shareHolderId, brandId)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4),
       (5, 5);

INSERT INTO categories (nameOfCategories, description)
VALUES ('Category1', 'Category Description1'),
       ('Category2', 'Category Description2'),
       ('Category3', 'Category Description3'),
       ('Category4', 'Category Description4'),
       ('Category5', 'Category Description5');

INSERT INTO product (nameOfProduct, createDate, categoriesId, brandId)
VALUES ('Product1', '2023-09-22', 1, 1),
       ('Product2', '2023-09-23', 2, 2),
       ('Product3', '2023-09-24', 3, 3),
       ('Product4', '2023-09-25', 4, 4),
       ('Product5', '2023-09-26', 5, 5);

INSERT INTO users (nameOfUsers, username, email, passwordOfUsers)
VALUES ('User1', 'user1', 'user1@example.com', 'password1'),
       ('User2', 'user2', 'user2@example.com', 'password2'),
       ('User3', 'user3', 'user3@example.com', 'password3'),
       ('User4', 'user4', 'user4@example.com', 'password4'),
       ('User5', 'user5', 'user5@example.com', 'password5');
SELECT sb.id, b.nameOfBrand, sH.nameOfShareHolder
from shareHolder_brand as sb
         inner join shareHolder sH on sH.id = sb.shareHolderId
         inner join brand b on b.id = sb.brandId;