-- begin REGOFCARDSMAGIC_PEOPLE
create table REGOFCARDSMAGIC_PEOPLE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    SURNAME longvarchar not null,
    NAME longvarchar not null,
    PATRONYMIC longvarchar not null,
    DCI integer not null,
    --
    primary key (ID)
)^
-- end REGOFCARDSMAGIC_PEOPLE
-- begin REGOFCARDSMAGIC_DECK
create table REGOFCARDSMAGIC_DECK (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TITLE longvarchar not null,
    OWNER_ID varchar(36),
    --
    primary key (ID)
)^
-- end REGOFCARDSMAGIC_DECK
-- begin REGOFCARDSMAGIC_CARD
create table REGOFCARDSMAGIC_CARD (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    INFORMATION longvarchar,
    OWNER_ID varchar(36),
    DECK_ID varchar(36),
    --
    primary key (ID)
)^
-- end REGOFCARDSMAGIC_CARD
-- begin REGOFCARDSMAGIC_CONTRIBUTION
create table REGOFCARDSMAGIC_CONTRIBUTION (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    PEOPLE_ID varchar(36),
    TYPE_ID varchar(36) not null,
    SUM_ double precision not null,
    DATE_ date not null,
    --
    primary key (ID)
)^
-- end REGOFCARDSMAGIC_CONTRIBUTION
-- begin REGOFCARDSMAGIC_TYPES
create table REGOFCARDSMAGIC_TYPES (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME longvarchar not null,
    TYPE_ID varchar(36),
    DESCRIPTION longvarchar,
    --
    primary key (ID)
)^
-- end REGOFCARDSMAGIC_TYPES
-- begin REGOFCARDSMAGIC_TOURNAMENT
create table REGOFCARDSMAGIC_TOURNAMENT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    TYPE_ID varchar(36) not null,
    PEOPLE_ID varchar(36) not null,
    DATE_ date not null,
    --
    primary key (ID)
)^
-- end REGOFCARDSMAGIC_TOURNAMENT
