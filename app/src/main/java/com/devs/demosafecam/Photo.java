package com.devs.demosafecam;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;

/**
 * Created by joseangelmr on 19/12/15.
 */

@ParseClassName("Photo")
public class Photo extends ParseObject {

    public Photo() {
    }

    public String getImei() {
        return getString("imei");
    }

    public void setImei(String imei) {
        put("imei", imei);
    }

    public String getName() {
        return getString("name");
    }

    public void setName(String name) {
        put("name", name);
    }

    public void setName(Integer camera) {
        put("camera", camera);
    }

    public Integer getCamera() {
        return getInt("camera");
    }

    public String getQuality() {
        return getString("quality");
    }

    public void setQuality(String quality) {
        put("quality", quality);
    }

    public ParseFile getImageFile() {
        return getParseFile("image");
    }

    public void setImageFile(ParseFile imageFile) {
        put("image", imageFile);
    }

}
