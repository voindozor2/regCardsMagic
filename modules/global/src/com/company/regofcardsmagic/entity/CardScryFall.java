package com.company.regofcardsmagic.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Lob;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|name")
@Table(name = "REGOFCARDSMAGIC_CARD_SCRY_FALL")
@Entity(name = "regofcardsmagic$CardScryFall")
public class CardScryFall extends StandardEntity {
    private static final long serialVersionUID = 2440595651958432290L;

    @Column(name = "MTGO_ID")
    protected Integer mtgoId;

    @Lob
    @Column(name = "NAME")
    protected String name;

    @Lob
    @Column(name = "SCRYFALL_UUID")
    protected String scryfallUUID;

    @Lob
    @Column(name = "ARTIST")
    protected String artist;

    @Lob
    @Column(name = "BORDER")
    protected String border;

    @Lob
    @Column(name = "CANNONICAL_IMAGE")
    protected String cannonicalImage;

    @Lob
    @Column(name = "CANNONICAL_IMAGE_URI")
    protected String cannonicalImageURI;

    @Column(name = "CMC")
    protected Double cmc;

    @Lob
    @Column(name = "COLLECTOR_NUMBER")
    protected String collectorNumber;

    @Lob
    @Column(name = "COLOR_IDENTITY")
    protected String colorIdentity;

    @Lob
    @Column(name = "COLORS")
    protected String colors;

    @Lob
    @Column(name = "FACES")
    protected String faces;

    @Lob
    @Column(name = "FLAVOR_TEXT")
    protected String flavorText;

    @Lob
    @Column(name = "FRAME")
    protected String frame;

    @Lob
    @Column(name = "IMAGE_URI")
    protected String imageURI;

    @Lob
    @Column(name = "LAYOUT")
    protected String layout;

    @Lob
    @Column(name = "LOYALTY")
    protected String loyalty;

    @Lob
    @Column(name = "MANA_COST")
    protected String manaCost;

    @Column(name = "MULTIVERSE_ID")
    protected Integer multiverseID;

    @Lob
    @Column(name = "ORACLE_TEXT")
    protected String oracleText;

    @Lob
    @Column(name = "POWER_")
    protected String power;

    @Column(name = "PRICE_TIX")
    protected Double priceTix;

    @Column(name = "PRICE_USD")
    protected Double priceUsd;

    @Lob
    @Column(name = "RARITY")
    protected String rarity;

    @Lob
    @Column(name = "SCRYFALL_URI")
    protected String scryfallUri;

    @Lob
    @Column(name = "SET_CODE")
    protected String setCode;

    @Lob
    @Column(name = "SET_NAME")
    protected String setName;

    @Lob
    @Column(name = "TOUGHNESS")
    protected String toughness;

    @Lob
    @Column(name = "TYPE_LINE")
    protected String typeLine;

    @Column(name = "IS_COLOR_SHIFTED")
    protected Boolean isColorShifted;

    @Column(name = "IS_DIGITAL_ONLY")
    protected Boolean isDigitalOnly;

    @Column(name = "IS_FUTURE_SHIFTED")
    protected Boolean isFutureShifted;

    @Column(name = "IS_MULTIFACED")
    protected Boolean isMultifaced;

    @Column(name = "IS_MULTI_PART")
    protected Boolean isMultiPart;

    @Column(name = "IS_RESERVED")
    protected Boolean isReserved;

    @Column(name = "IS_TIME_SHIFTED")
    protected Boolean isTimeShifted;

    @Lob
    @Column(name = "LEGALITY_LEGACY")
    protected String legality_Legacy;

    @Lob
    @Column(name = "LEGALITY_STANDART")
    protected String legality_Standart;

    @Lob
    @Column(name = "LEGALITY_MODERN")
    protected String legality_Modern;

    @Lob
    @Column(name = "LEGALITY_VINTAGE")
    protected String legality_Vintage;

    public void setMtgoId(Integer mtgoId) {
        this.mtgoId = mtgoId;
    }

    public Integer getMtgoId() {
        return mtgoId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setScryfallUUID(String scryfallUUID) {
        this.scryfallUUID = scryfallUUID;
    }

    public String getScryfallUUID() {
        return scryfallUUID;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setBorder(String border) {
        this.border = border;
    }

    public String getBorder() {
        return border;
    }

    public void setCannonicalImage(String cannonicalImage) {
        this.cannonicalImage = cannonicalImage;
    }

    public String getCannonicalImage() {
        return cannonicalImage;
    }

    public void setCannonicalImageURI(String cannonicalImageURI) {
        this.cannonicalImageURI = cannonicalImageURI;
    }

    public String getCannonicalImageURI() {
        return cannonicalImageURI;
    }

    public void setCmc(Double cmc) {
        this.cmc = cmc;
    }

    public Double getCmc() {
        return cmc;
    }

    public void setCollectorNumber(String collectorNumber) {
        this.collectorNumber = collectorNumber;
    }

    public String getCollectorNumber() {
        return collectorNumber;
    }

    public void setColorIdentity(String colorIdentity) {
        this.colorIdentity = colorIdentity;
    }

    public String getColorIdentity() {
        return colorIdentity;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public String getColors() {
        return colors;
    }

    public void setFaces(String faces) {
        this.faces = faces;
    }

    public String getFaces() {
        return faces;
    }

    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }

    public String getFlavorText() {
        return flavorText;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getFrame() {
        return frame;
    }

    public void setImageURI(String imageURI) {
        this.imageURI = imageURI;
    }

    public String getImageURI() {
        return imageURI;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getLayout() {
        return layout;
    }

    public void setLoyalty(String loyalty) {
        this.loyalty = loyalty;
    }

    public String getLoyalty() {
        return loyalty;
    }

    public void setManaCost(String manaCost) {
        this.manaCost = manaCost;
    }

    public String getManaCost() {
        return manaCost;
    }

    public void setMultiverseID(Integer multiverseID) {
        this.multiverseID = multiverseID;
    }

    public Integer getMultiverseID() {
        return multiverseID;
    }

    public void setOracleText(String oracleText) {
        this.oracleText = oracleText;
    }

    public String getOracleText() {
        return oracleText;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getPower() {
        return power;
    }

    public void setPriceTix(Double priceTix) {
        this.priceTix = priceTix;
    }

    public Double getPriceTix() {
        return priceTix;
    }

    public void setPriceUsd(Double priceUsd) {
        this.priceUsd = priceUsd;
    }

    public Double getPriceUsd() {
        return priceUsd;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getRarity() {
        return rarity;
    }

    public void setScryfallUri(String scryfallUri) {
        this.scryfallUri = scryfallUri;
    }

    public String getScryfallUri() {
        return scryfallUri;
    }

    public void setSetCode(String setCode) {
        this.setCode = setCode;
    }

    public String getSetCode() {
        return setCode;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public String getSetName() {
        return setName;
    }

    public void setToughness(String toughness) {
        this.toughness = toughness;
    }

    public String getToughness() {
        return toughness;
    }

    public void setTypeLine(String typeLine) {
        this.typeLine = typeLine;
    }

    public String getTypeLine() {
        return typeLine;
    }

    public void setIsColorShifted(Boolean isColorShifted) {
        this.isColorShifted = isColorShifted;
    }

    public Boolean getIsColorShifted() {
        return isColorShifted;
    }

    public void setIsDigitalOnly(Boolean isDigitalOnly) {
        this.isDigitalOnly = isDigitalOnly;
    }

    public Boolean getIsDigitalOnly() {
        return isDigitalOnly;
    }

    public void setIsFutureShifted(Boolean isFutureShifted) {
        this.isFutureShifted = isFutureShifted;
    }

    public Boolean getIsFutureShifted() {
        return isFutureShifted;
    }

    public void setIsMultifaced(Boolean isMultifaced) {
        this.isMultifaced = isMultifaced;
    }

    public Boolean getIsMultifaced() {
        return isMultifaced;
    }

    public void setIsMultiPart(Boolean isMultiPart) {
        this.isMultiPart = isMultiPart;
    }

    public Boolean getIsMultiPart() {
        return isMultiPart;
    }

    public void setIsReserved(Boolean isReserved) {
        this.isReserved = isReserved;
    }

    public Boolean getIsReserved() {
        return isReserved;
    }

    public void setIsTimeShifted(Boolean isTimeShifted) {
        this.isTimeShifted = isTimeShifted;
    }

    public Boolean getIsTimeShifted() {
        return isTimeShifted;
    }

    public void setLegality_Legacy(String legality_Legacy) {
        this.legality_Legacy = legality_Legacy;
    }

    public String getLegality_Legacy() {
        return legality_Legacy;
    }

    public void setLegality_Standart(String legality_Standart) {
        this.legality_Standart = legality_Standart;
    }

    public String getLegality_Standart() {
        return legality_Standart;
    }

    public void setLegality_Modern(String legality_Modern) {
        this.legality_Modern = legality_Modern;
    }

    public String getLegality_Modern() {
        return legality_Modern;
    }

    public void setLegality_Vintage(String legality_Vintage) {
        this.legality_Vintage = legality_Vintage;
    }

    public String getLegality_Vintage() {
        return legality_Vintage;
    }


}