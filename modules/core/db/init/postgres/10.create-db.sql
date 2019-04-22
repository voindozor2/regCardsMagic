-- begin REGOFCARDSMAGIC_PEOPLE
create table REGOFCARDSMAGIC_PEOPLE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    SURNAME text not null,
    NAME text not null,
    PATRONYMIC text not null,
    DCI integer not null,
    POSITION_IN_TEAM_ID uuid,
    EMAIL text,
    NICKNAME text,
    NUMBER_OF_CARD text,
    BIRTH_DATE date not null,
    ENTRY_DATE date not null,
    TELEPHONE_NUMBER text not null,
    --
    primary key (ID)
)^
-- end REGOFCARDSMAGIC_PEOPLE
-- begin REGOFCARDSMAGIC_DECK
create table REGOFCARDSMAGIC_DECK (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TITLE text not null,
    OWNER_ID uuid,
    --
    primary key (ID)
)^
-- end REGOFCARDSMAGIC_DECK
-- begin REGOFCARDSMAGIC_CARD
create table REGOFCARDSMAGIC_CARD (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    INFORMATION text,
    OWNER_ID uuid,
    DECK_ID uuid,
    --
    primary key (ID)
)^
-- end REGOFCARDSMAGIC_CARD
-- begin REGOFCARDSMAGIC_CONTRIBUTION
create table REGOFCARDSMAGIC_CONTRIBUTION (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    SUM_ double precision not null,
    --
    PEOPLE_ID uuid,
    TYPE_ID uuid not null,
    DATE_ date not null,
    --
    primary key (ID)
)^
-- end REGOFCARDSMAGIC_CONTRIBUTION
-- begin REGOFCARDSMAGIC_TYPES
create table REGOFCARDSMAGIC_TYPES (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME text not null,
    TYPE_ID uuid,
    DESCRIPTION text,
    --
    primary key (ID)
)^
-- end REGOFCARDSMAGIC_TYPES
-- begin REGOFCARDSMAGIC_TOURNAMENT
create table REGOFCARDSMAGIC_TOURNAMENT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    TYPE_ID uuid not null,
    PEOPLE_ID uuid not null,
    DATE_ date not null,
    --
    primary key (ID)
)^
-- end REGOFCARDSMAGIC_TOURNAMENT
-- begin REGOFCARDSMAGIC_TEAM
create table REGOFCARDSMAGIC_TEAM (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME text not null,
    TEAM_MATES_ID uuid,
    --
    primary key (ID)
)^
-- end REGOFCARDSMAGIC_TEAM
-- begin REGOFCARDSMAGIC_POSITION_IN_TEAM
create table REGOFCARDSMAGIC_POSITION_IN_TEAM (
    ID uuid,
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
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CARD_ID uuid not null,
    --
    primary key (ID)
)^
-- end REGOFCARDSMAGIC_STORAGE
-- begin REGOFCARDSMAGIC_COLLECTION_OF_CARDS
create table REGOFCARDSMAGIC_COLLECTION_OF_CARDS (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    CARD_ID uuid not null,
    --
    BOX text not null,
    SEPARATOR_ text not null,
    --
    primary key (ID)
)^
-- end REGOFCARDSMAGIC_COLLECTION_OF_CARDS
-- begin REGOFCARDSMAGIC_RENT_CARDS
create table REGOFCARDSMAGIC_RENT_CARDS (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    CARD_ID uuid not null,
    --
    TO_WHO_ID uuid not null,
    --
    primary key (ID)
)^
-- end REGOFCARDSMAGIC_RENT_CARDS
-- begin REGOFCARDSMAGIC_CARD_FOR_TRADE
create table REGOFCARDSMAGIC_CARD_FOR_TRADE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    CARD_ID uuid not null,
    --
    primary key (ID)
)^
-- end REGOFCARDSMAGIC_CARD_FOR_TRADE
-- begin REGOFCARDSMAGIC_OPERATION
create table REGOFCARDSMAGIC_OPERATION (
    ID uuid,
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
    ID uuid,
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
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    BUYER_ID uuid not null,
    SELLER_ID uuid not null,
    CARDS_FOR_BUY_ID uuid not null,
    CARDS_FOR_SALE_ID uuid not null,
    --
    primary key (ID)
)^
-- end REGOFCARDSMAGIC_CARD_EXCHANGE
-- begin REGOFCARDSMAGIC_MONEY_OPERATION
create table REGOFCARDSMAGIC_MONEY_OPERATION (
    ID uuid,
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
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    PEOPLE_ID uuid not null,
    POSITION_IN_TEAM_ID uuid not null,
    --
    primary key (ID)
)^
-- end REGOFCARDSMAGIC_COMPENSATION
-- begin REGOFCARDSMAGIC_TRADE
create table REGOFCARDSMAGIC_TRADE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    SUM_ double precision not null,
    --
    SELLER_ID uuid not null,
    BUYER_ID uuid not null,
    CARD_ID uuid,
    --
    primary key (ID)
)^
-- end REGOFCARDSMAGIC_TRADE
-- begin REGOFCARDSMAGIC_RENT
create table REGOFCARDSMAGIC_RENT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    SUM_ double precision not null,
    SELLER_ID uuid not null,
    BUYER_ID uuid not null,
    CARD_ID uuid,
    --
    RENTAL_DATE date not null,
    ADMISSION_DATE date,
    --
    primary key (ID)
)^
-- end REGOFCARDSMAGIC_RENT
-- begin REGOFCARDSMAGIC_PEOPLE_TEAM_LINK
create table REGOFCARDSMAGIC_PEOPLE_TEAM_LINK (
    TEAM_ID uuid,
    PEOPLE_ID uuid,
    primary key (TEAM_ID, PEOPLE_ID)
)^
-- end REGOFCARDSMAGIC_PEOPLE_TEAM_LINK
-- begin REGOFCARDSMAGIC_CARD_SCRY_FALL
create table REGOFCARDSMAGIC_CARD_SCRY_FALL (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    MTGO_ID integer,
    NAME text,
    SCRYFALL_UUID text,
    ARTIST text,
    BORDER text,
    CANNONICAL_IMAGE text,
    CANNONICAL_IMAGE_URI text,
    CMC double precision,
    COLLECTOR_NUMBER text,
    COLOR_IDENTITY text,
    COLORS text,
    FACES text,
    FLAVOR_TEXT text,
    FRAME text,
    IMAGE_URI text,
    LAYOUT text,
    LOYALTY text,
    MANA_COST text,
    MULTIVERSE_ID integer,
    ORACLE_TEXT text,
    POWER_ text,
    PRICE_TIX double precision,
    PRICE_USD double precision,
    RARITY text,
    SCRYFALL_URI text,
    SET_CODE text,
    SET_NAME text,
    TOUGHNESS text,
    TYPE_LINE text,
    IS_COLOR_SHIFTED boolean,
    IS_DIGITAL_ONLY boolean,
    IS_FUTURE_SHIFTED boolean,
    IS_MULTIFACED boolean,
    IS_MULTI_PART boolean,
    IS_RESERVED boolean,
    IS_TIME_SHIFTED boolean,
    LEGALITY_LEGACY text,
    LEGALITY_STANDART text,
    LEGALITY_MODERN text,
    LEGALITY_VINTAGE text,
    --
    primary key (ID)
)^
-- end REGOFCARDSMAGIC_CARD_SCRY_FALL
