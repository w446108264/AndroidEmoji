package com.sj.emoji;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Spannable;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sj on 16/3/22.
 */
public class EmojiDisplay {

    @SuppressWarnings("MalformedRegex")
    //                                                            0x203c,0x2049 0x20a0-0x32ff          0x1f00-0x1fff              0xfe4e5-0xfe4ee
    //                                                           |== !!, ?! ==||==== misc ====||======== emoticons ========||========= flags ==========|
    private static final Pattern EMOJI_RANGE = Pattern.compile("[\\u203c\\u2049\\u20a0-\\u32ff\\ud83c\\udc00-\\ud83d\\udeff\\udbb9\\udce5-\\udbb9\\udcee]");

    public static final String HEAD_NAME = "emoji_0x";

    public static final int WRAP_DRAWABLE = -1;

    public static Matcher getMatcher(CharSequence matchStr) {
        return EMOJI_RANGE.matcher(matchStr);
    }

    /**
     * load emoji from File
     *
     * @param spannable the spannable will be returned after filter emoji
     * @param fontSize either WRAP_DRAWABLE or any number
     * @param filePath the emoji source path,the file will be created if exists.
     * @param emojiDisplayListener display the emoji with youself when match.
     * @return a Spannable after filter emoji.
     */
    public static Spannable filterFromFile(Spannable spannable, int fontSize,
                                           String filePath, EmojiDisplayListener emojiDisplayListener) {
        if (spannable == null) {
            return null;
        }
        Matcher m = getMatcher(spannable.toString());
        if (m != null) {
            while (m.find()) {
                String emojiHex = Integer.toHexString(Character.codePointAt(m.group(), 0));
                if (emojiDisplayListener == null) {
                    Drawable drawable = Drawable.createFromPath(filePath + emojiHex + ".png");
                    if (drawable != null) {
                        drawable.setBounds(0, 0, fontSize, fontSize);
                        EmojiSpan imageSpan = new EmojiSpan(drawable);
                        spannable.setSpan(imageSpan, m.start(), m.end(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    }
                } else {
                    emojiDisplayListener.onEmojiDisplay(null, spannable, emojiHex, fontSize, m.start(), m.end());
                }
            }
        }
        return spannable;
    }

    /**
     * load emoji from File asynchronously
     *
     * @param spannable the spannable will be returned after filter emoji
     * @param fontSize either WRAP_DRAWABLE or any number
     * @param filePath the emoji source path,the file will be created if exists.
     * @param emojiAsyncLoadTextView the EmojiAsyncLoadTextView is must.it supports to load emoji asynchronously.
     * @return a Spannable after filter emoji.
     */
    public static Spannable filterAsyncFromFile(Spannable spannable, int fontSize,
                                                String filePath, EmojiAsyncLoadTextView emojiAsyncLoadTextView) {
        if (spannable == null) {
            return null;
        }
        Matcher m = getMatcher(spannable.toString());
        if (m != null) {
            while (m.find()) {
                String emojiHex = Integer.toHexString(Character.codePointAt(m.group(), 0));
                EmojiDrawable emojiDrawable = new EmojiDrawable();
                emojiDrawable.setBounds(0, 0, fontSize, fontSize);
                spannable.setSpan(new EmojiSpan(emojiDrawable, emojiAsyncLoadTextView), m.start(), m.end(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                emojiAsyncLoadTextView.addAsyncLoadTask(emojiDrawable, filePath + emojiHex + ".png");
            }
        }
        return spannable;
    }

    /**
     * load emoji from resource
     *
     * @param context the context to use
     * @param spannable the spannable will be returned after filter emoji
     * @param fontSize either WRAP_DRAWABLE or any number
     * @return a Spannable after filter emoji.
     */
    public static Spannable filterFromResource(Context context, Spannable spannable, int fontSize) {
        return spannable == null ? null : filterFromResource(context, spannable, fontSize, HEAD_NAME, null);
    }

    /**
     * load emoji from Resource
     *
     * @param context the context to use.
     * @param spannable the spannable will be returned after filter emoji.
     * @param fontSize either WRAP_DRAWABLE or any number.
     * @param headName null-ok;The resource name must start with a letter,so when load emoji from resource
     *                 the filename should be added a headName like emoji_0x*.
     * @param emojiDisplayListener display the emoji with youself when match.
     * @return The filter spannable, or null.
     */
    public static Spannable filterFromResource(Context context, Spannable spannable, int fontSize, String headName,
                                               EmojiDisplayListener emojiDisplayListener) {
        if (spannable == null) {
            return null;
        }
        Matcher m = getMatcher(spannable.toString());
        if (m != null) {
            while (m.find()) {
                String emojiHex = Integer.toHexString(Character.codePointAt(m.group(), 0));
                if (emojiDisplayListener == null) {
                    /**
                     * create a drawable for spannable.
                     * <p>
                     * The resource name must start with a letter.
                     * so, add a head name for every emoji image.
                     * see that on res/mipmap-xhdpi
                     * </p>
                     */
                    Drawable drawable = getDrawable(context, headName + emojiHex);
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
                        spannable.setSpan(imageSpan, m.start(), m.end(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    }
                } else {
                    emojiDisplayListener.onEmojiDisplay(context, spannable, headName + emojiHex, fontSize, m.start(), m.end());
                }
            }
        }
        return spannable;
    }

    /**
     * load emoji Resource file asynchronously
     *
     * @param context the context to use.
     * @param spannable the spannable will be returned after filter emoji
     * @param fontSize either WRAP_DRAWABLE or any number
     * @param headName null-ok;The resource name must start with a letter,so when load emoji from resource
     *                 the filename should be added a headName like emoji_0x*.
     * @param emojiAsyncLoadTextView the EmojiAsyncLoadTextView is must.it supports to load emoji asynchronously.
     * @return a Spannable after filter emoji.
     */
    public static Spannable filterAsyncFromResource(Context context, final Spannable spannable, int fontSize, String headName,
                                                    final EmojiAsyncLoadTextView emojiAsyncLoadTextView) {
        if (spannable == null) {
            return null;
        }
        Matcher m = getMatcher(spannable.toString());
        if (m != null) {
            while (m.find()) {
                String emojiHex = Integer.toHexString(Character.codePointAt(m.group(), 0));
                int resID = context.getResources().getIdentifier(headName + emojiHex, "mipmap", context.getPackageName());
                if (resID <= 0) {
                    resID = context.getResources().getIdentifier(headName + emojiHex, "drawable", context.getPackageName());
                }
                if (resID > 0) {
                    EmojiDrawable emojiDrawable = new EmojiDrawable();
                    emojiDrawable.setBounds(0, 0, fontSize, fontSize);
                    final EmojiSpan emojiSpan = new EmojiSpan(emojiDrawable, emojiAsyncLoadTextView);
                    spannable.setSpan(emojiSpan, m.start(), m.end(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    emojiAsyncLoadTextView.addAsyncLoadTask(emojiDrawable, context.getResources(), resID, null);
                }
            }
        }
        return spannable;
    }

    protected static Drawable getDrawable(Context context, String emojiName) {
        int resID = context.getResources().getIdentifier(emojiName, "mipmap", context.getPackageName());
        if (resID <= 0) {
            resID = context.getResources().getIdentifier(emojiName, "drawable", context.getPackageName());
        }
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                return context.getResources().getDrawable(resID, null);
            } else {
                return context.getResources().getDrawable(resID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getFontHeight(TextView textView) {
        Paint paint = new Paint();
        paint.setTextSize(textView.getTextSize());
        Paint.FontMetrics fm = paint.getFontMetrics();
        return (int) Math.ceil(fm.bottom - fm.top);
    }
}
