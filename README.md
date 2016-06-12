# AndroidEmoji

> j.s 🇨🇳

AndroidEmoji


# Features

* API > 9 
* Support load emoji from file.
* Support load emoji asynchronously.
* Suppoet apple,google,twitter,emojione, [Get source.](https://github.com/w446108264/AndroidEmoji/blob/master/AndroidEmoji/simple/assets/
) 
* More thin.  

## Screen Record

<img src="output/main.png" width="60%"/>

<img src="output/emoji_system.png" width="19%"/>
<img src="output/emoji_apple.png" width="19%" />
<img src="output/emoji_google.png" width="19%"/>
<img src="output/emoji_twitter.png" width="19%"/>
<img src="output/emoji_emojione.png" width="19%"/>
 
# XhsEmoticonsKeyboard

If you need a keyboard --> [XhsEmoticonsKeyboard](https://github.com/w446108264/XhsEmoticonsKeyboard) 

<img src="https://github.com/w446108264/XhsEmoticonsKeyboard/raw/master/output/chat-qqemoticon.png" width="12%" /> 
<img src="https://github.com/w446108264/XhsEmoticonsKeyboard/raw/master/output/chat-qqplug.png" width="12%" /> 
<img src="https://github.com/w446108264/XhsEmoticonsKeyboard/raw/master/output/chat-qqfav.png" width="12%" />  
<img src="https://github.com/w446108264/XhsEmoticonsKeyboard/raw/master/output/chat-bigimage.png" width="12%" /> 
<img src="https://github.com/w446108264/XhsEmoticonsKeyboard/raw/master/output/chat-userdefui.png" width="12%" /> 
<img src="https://github.com/w446108264/XhsEmoticonsKeyboard/raw/master/output/chat-text.png" width="12%" />  
<img src="https://github.com/w446108264/XhsEmoticonsKeyboard/raw/master/output/simple-comment.png" width="12%" /> 
<img src="https://github.com/w446108264/XhsEmoticonsKeyboard/raw/master/output/main.png" width="12%" /> 

# Samples

You can [download a sample APK](https://github.com/w446108264/AndroidEmoji/raw/master/output/simple.apk) 
 
 
# Gradle Dependency

Users of your library will need add the jitpack.io repository:

```xml  
allprojects {
    repositories {
        jcenter()
        maven { url "https://jitpack.io" }
    }
}
```

and:

```xml
dependencies { 
    compile 'com.github.w446108264:AndroidEmoji:1.1.1'
}
```
--

### Simple

```java

// The frist, you should put some emoji images to your project.
// see demo!
Spannable spannable = EmojiDisplay.filterFromResource(tv_content.getContext(),
                    new SpannableStringBuilder(content),
                    EmojiDisplay.getFontHeight(tv_content),EmojiDisplay.HEAD_NAME, null);
tv_content.setText(spannable);

```
# Thanks
 
 * [https://github.com/iamcal/emoji-data](https://github.com/iamcal/emoji-data)
 
# Contact & Help

Please fell free to contact me if there is any problem when using the library.

* email: shengjun8486@gmail.com 


