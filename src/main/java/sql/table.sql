CREATE TABLE IF NOT EXISTS shareHolder
(
    id                serial primary key,
    nameOfShareHolder varchar(50) not null,
    phoneNumber       varchar(50) not null,
    nationalCode      varchar(50) not null
);
CREATE TABLE IF NOT EXISTS brand
(
    id          serial primary key,
    nameOfBrand varchar(50) not null,
    website     varchar(50) not null,
    description varchar(50) not null
);
CREATE TABLE IF NOT EXISTS shareHolder_brand
(
    shareHolderId int references shareHolder,
    brandId       int references brand
);
CREATE TABLE IF NOT EXISTS categories
(
    id               serial primary key,
    nameOfCategories varchar(50) not null,
    description      varchar(50) not null
);
CREATE TABLE IF NOT EXISTS product
(
    id            serial primary key,
    nameOfProduct varchar(50) not null,
    createDate    varchar(50) not null,
    categoriesId  int references categories,
    brandId       int references brand
);
CREATE TABLE IF NOT EXISTS users
(
    id              serial primary key,
    nameOfUsers     varchar(50) not null,
    username        varchar(50) not null,
    email           varchar(50) not null,
    passwordOfUsers varchar(50) not null
);