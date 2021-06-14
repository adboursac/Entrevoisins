package com.openclassrooms.entrevoisins.model;

import java.util.Objects;

/**
 * Model object representing a Neighbour
 */
    public class Neighbour {

    /** Identifier */
    private long mId;

    /** Full name */
    private String mName;

    /** Avatar */
    private String mAvatarUrl;

    /** Address */
    private String mAddress;

    /** Phone number */
    private String mPhoneNumber;

    /** About me */
    private String mAboutMe;

    /** Social media url */
    private String mSocialMediaUrl;

    /** is this neighbour favourite */
    private Boolean mIsFavorite;

    /**
     * Constructor
     * @param id neighbour unique id
     * @param name neighbour name
     * @param avatarUrl neighbour avatar url
     * @param address neighbour address
     * @param phoneNumber neighbour phone number
     * @param aboutMe about me description
     * @param socialMediaUrl neighbour's social media url
     * @param isFavorite favorite list
     */
    public Neighbour(long id, String name, String avatarUrl, String address,
                     String phoneNumber, String aboutMe, String socialMediaUrl, Boolean isFavorite) {
        mId = id;
        mName = name;
        mAvatarUrl = avatarUrl;
        mAddress = address;
        mPhoneNumber = phoneNumber;
        mAboutMe = aboutMe;
        mSocialMediaUrl = socialMediaUrl;
        mIsFavorite = isFavorite;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        this.mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getAvatarUrl() {
        return mAvatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.mAvatarUrl = avatarUrl;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        this.mAddress = address;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.mPhoneNumber = phoneNumber;
    }

    public String getAboutMe() {
        return mAboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.mAboutMe = aboutMe;
    }

    public String getSocialMediaUrl() {
        return mSocialMediaUrl;
    }

    public void setSocialMediaUrl(String socialMediaUrl) {
        this.mSocialMediaUrl = socialMediaUrl;
    }

    public Boolean getFavorite() {
        return mIsFavorite;
    }

    /**
     * Toggle favorite status and return it
     * @return update favorite status
     */
    public boolean toggleFavoriteStatus() {
        return mIsFavorite  = !mIsFavorite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Neighbour neighbour = (Neighbour) o;
        return Objects.equals(mId, neighbour.mId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId);
    }
}
