package com.sj.emoji;

import java.io.Serializable;

/**
 * Created by sj on 6/13/16.
 */
public class EmojiBean implements Serializable {

    public int icon;
    public String emoji;

    public EmojiBean(int icon, String emoji) {
        this.icon = icon;
        this.emoji = emoji;
    }
}
