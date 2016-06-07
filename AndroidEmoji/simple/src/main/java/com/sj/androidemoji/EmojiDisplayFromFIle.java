package com.sj.androidemoji;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;

import com.sj.emoji.EmojiDisplay;
import com.sj.emoji.EmojiDisplayListener;
import com.sj.emoji.EmojiSpan;

import java.util.regex.Matcher;

/**
 * Created by sj on 16/3/22.
 */
public class EmojiDisplayFromFIle extends EmojiDisplay{

    public static Spannable spannableFilter(Context context, String filePath, Spannable spannable, CharSequence text, int fontSize, EmojiDisplayListener emojiDisplayListener) {
        Matcher m = getMatcher(text);
        if (m != null) {
            while (m.find()) {
                String emojiHex = Integer.toHexString(Character.codePointAt(m.group(), 0));
                emojiDisplay(context, filePath, spannable, emojiHex, fontSize, m.start(), m.end());
            }
        }
        return spannable;
    }

    public static void emojiDisplay(Context context, String filePath, Spannable spannable, String emojiHex, int fontSize, int start, int end) {
        Drawable drawable = Drawable.createFromPath(filePath + emojiHex + ".png");
        if (drawable != null) {
            int itemHeight;
            int itemWidth;
            if (fontSize == WRAP_DRAWABLE) {
                itemHeight = drawable.getIntrinsicHeight();
                itemWidth = drawable.getIntrinsicWidth();
            } else {
                itemHeight = fontSize;
                itemWidth = fontSize;
            }

            drawable.setBounds(0, 0, itemHeight, itemWidth);
            EmojiSpan imageSpan = new EmojiSpan(drawable);
            spannable.setSpan(imageSpan, start, end, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        }
    }
}
