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
    POSITION_IN_TEAM_ID varchar(36),
    EMAIL longvarchar,
    NICKNAME longvarchar,
    NUMBER_OF_CARD longvarchar,
    BIRTH_DATE date not null,
    ENTRY_DATE date not null,
    TELEPHONE_NUMBER longvarchar not null,
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
-- begin REGOFCARDSMAGIC_TEAM
create table REGOFCARDSMAGIC_TEAM (
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
    TEAM_MATES_ID varchar(36),
    --
    primary key (ID)
)^
-- end REGOFCARDSMAGIC_TEAM
-- begin REGOFCARDSMAGIC_POSITION_IN_TEAM
create table REGOFCARDSMAGIC_POSITION_IN_TEAM (
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
    --
    primary key (ID)
)^
-- end REGOFCARDSMAGIC_POSITION_IN_TEAM
-- begin REGOFCARDSMAGIC_STORAGE
create table REGOFCARDSMAGIC_STORAGE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CARD_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end REGOFCARDSMAGIC_STORAGE
-- begin REGOFCARDSMAGIC_COLLECTION_OF_CARDS
create table REGOFCARDSMAGIC_COLLECTION_OF_CARDS (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    CARD_ID varchar(36) not null,
    --
    BOX longvarchar not null,
    SEPARATOR_ longvarchar not null,
    --
    primary key (ID)
)^
-- end REGOFCARDSMAGIC_COLLECTION_OF_CARDS
-- begin REGOFCARDSMAGIC_RENT_CARDS
create table REGOFCARDSMAGIC_RENT_CARDS (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    CARD_ID varchar(36) not null,
    --
    TO_WHO_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end REGOFCARDSMAGIC_RENT_CARDS
-- begin REGOFCARDSMAGIC_CARD_FOR_TRADE
create table REGOFCARDSMAGIC_CARD_FOR_TRADE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    CARD_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end REGOFCARDSMAGIC_CARD_FOR_TRADE
-- begin REGOFCARDSMAGIC_OPERATION
create table REGOFCARDSMAGIC_OPERATION (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    primary key (ID)
)^
-- end REGOFCARDSMAGIC_OPERATION
-- begin REGOFCARDSMAGIC_BARTER
create table REGOFCARDSMAGIC_BARTER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    primary key (ID)
)^
-- end REGOFCARDSMAGIC_BARTER
-- begin REGOFCARDSMAGIC_CARD_EXCHANGE
create table REGOFCARDSMAGIC_CARD_EXCHANGE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    BUYER_ID varchar(36) not null,
    SELLER_ID varchar(36) not null,
    CARDS_FOR_BUY_ID varchar(36) not null,
    CARDS_FOR_SALE_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end REGOFCARDSMAGIC_CARD_EXCHANGE
-- begin REGOFCARDSMAGIC_MONEY_OPERATION
create table REGOFCARDSMAGIC_MONEY_OPERATION (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    SUM_ double precision not null,
    --
    primary key (ID)
)^
-- end REGOFCARDSMAGIC_MONEY_OPERATION
-- begin REGOFCARDSMAGIC_COMPENSATION
create table REGOFCARDSMAGIC_COMPENSATION (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    PEOPLE_ID varchar(36) not null,
    POSITION_IN_TEAM_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end REGOFCARDSMAGIC_COMPENSATION
-- begin REGOFCARDSMAGIC_TRADE
create table REGOFCARDSMAGIC_TRADE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    SUM_ double precision not null,
    --
    SELLER_ID varchar(36) not null,
    BUYER_ID varchar(36) not null,
    CARD_ID varchar(36),
    --
    primary key (ID)
)^
-- end REGOFCARDSMAGIC_TRADE
-- begin REGOFCARDSMAGIC_RENT
create table REGOFCARDSMAGIC_RENT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    SUM_ double precision not null,
    SELLER_ID varchar(36) not null,
    BUYER_ID varchar(36) not null,
    CARD_ID varchar(36),
    --
    RENTAL_DATE date not null,
    ADMISSION_DATE date,
    --
    primary key (ID)
)^
-- end REGOFCARDSMAGIC_RENT
-- begin REGOFCARDSMAGIC_PEOPLE_TEAM_LINK
create table REGOFCARDSMAGIC_PEOPLE_TEAM_LINK (
    TEAM_ID varchar(36) not null,
    PEOPLE_ID varchar(36) not null,
    primary key (TEAM_ID, PEOPLE_ID)
)^
-- end REGOFCARDSMAGIC_PEOPLE_TEAM_LINK
