package com.sj.androidemoji;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.sj.emoji.EmojiDisplay;

import java.io.File;
import java.io.IOException;

/**
 * Created by sj on 16/3/22.
 */
public class MainActivity extends AppCompatActivity {

    private final String emojiString = "\uD83D\uDE01\uD83D\uDE14\uD83D\uDE0A\uD83D\uDE1C\uD83D\uDE33\uD83D\uDC44\uD83D\uDE31\uD83D\uDE0C\uD83D\uDE0D\uD83D\uDE23\uD83D\uDE13\uD83D\uDE0F\uD83D\uDE2D\uD83D\uDE12\uD83D\uDE04\uD83D\uDE16\uD83D\uDE32\uD83D\uDE09\uD83D\uDE18\uD83D\uDE1D\uD83D\uDE02\uD83D\uDE21\uD83D\uDE20\uD83D\uDE25\uD83D\uDE37\uD83D\uDE2A\uD83D\uDE28\uD83D\uDE30\uD83D\uDE1E\uD83D\uDE03\uD83D\uDE1A☺\uD83D\uDC7F\uD83D\uDCAA\uD83D\uDC4A\uD83D\uDC4D✌\uD83D\uDC4E\uD83D\uDC46\uD83D\uDC47\uD83D\uDC9D\uD83D\uDC8D\uD83D\uDC94\uD83D\uDC51\uD83D\uDCA4\uD83D\uDCA9\uD83D\uDC69\uD83D\uDC68\uD83D\uDC67\uD83D\uDC66\uD83D\uDC80\uD83D\uDC7B\uD83D\uDC7C\uD83D\uDC84\uD83C\uDF02\uD83D\uDC5C\uD83D\uDC59\uD83D\uDC8B\uD83D\uDC55\uD83D\uDC5F☝\u270A\u270B\uD83D\uDC8E\uD83D\uDC7D\uD83D\uDC8F\uD83C\uDFC3\uD83D\uDCBC\uD83D\uDC7E\uD83D\uDC60\uD83D\uDC6E\uD83D\uDEB6\uD83D\uDC48\uD83D\uDC49\uD83D\uDC55\uD83D\uDC52\uD83D\uDC57\uD83D\uDC61\uD83D\uDC62\uD83D\uDC85\uD83D\uDC86\uD83D\uDC87\uD83D\uDC58\uD83D\uDC93\uD83D\uDC97\uD83D\uDC98\uD83D\uDC99\uD83D\uDC9A\uD83D\uDC9B\uD83D\uDC9C\u2728\uD83D\uDCA8\uD83D\uDCA2\uD83D\uDE22\uD83D\uDC40\uD83D\uDC43\uD83D\uDC42\uD83D\uDE4F\uD83D\uDC4B\uD83D\uDC4F\uD83D\uDC4C\uD83D\uDC50\uD83D\uDE45\uD83D\uDE46\uD83D\uDC91\uD83D\uDE47\uD83D\uDE4C\uD83D\uDC6B\uD83D\uDC6F\uD83C\uDF85\uD83D\uDC71\uD83D\uDC72\uD83D\uDC73\uD83D\uDC74\uD83D\uDC75\uD83D\uDC76\uD83D\uDC77\uD83D\uDC78\uD83D\uDC82\uD83D\uDC83\uD83C\uDF39\uD83D\uDC35\uD83D\uDC19\uD83D\uDC37\uD83D\uDC0D\uD83D\uDC28\uD83D\uDC2E\uD83D\uDC38\uD83D\uDC1B\uD83D\uDC20\uD83D\uDC36\uD83D\uDC2F\uD83D\uDC27\uD83D\uDC33\uD83D\uDC2D⚡☁☀☔\uD83C\uDF19❄\uD83D\uDC1F\uD83D\uDC0E\uD83C\uDF38\uD83D\uDDFB\uD83C\uDF04\uD83D\uDC31\uD83D\uDC3B\uD83C\uDF40\uD83C\uDF41\uD83C\uDF42\uD83C\uDF3A\uD83C\uDF37\uD83C\uDF3B\uD83D\uDC90\uD83C\uDF34\uD83C\uDF35\uD83C\uDF1F\uD83C\uDF0A\uD83C\uDF00\uD83C\uDF3E\uD83C\uDF91\uD83C\uDF43\uD83C\uDF05\uD83C\uDF07\uD83C\uDF20\uD83C\uDF08\uD83D\uDC2C\uD83D\uDC26\uD83D\uDC24\uD83D\uDC39\uD83D\uDC18\uD83D\uDC12\uD83D\uDC11\uD83D\uDC3A\uD83D\uDC30\uD83D\uDC14\uD83D\uDC17\uD83D\uDC2B\uD83C\uDF82\uD83C\uDF7A☕\uD83C\uDF84\uD83D\uDCA3\uD83C\uDFC6\uD83D\uDCB0\uD83D\uDD2B\uD83C\uDFA4\uD83C\uDFB8\uD83C\uDFB5\u26BD\uD83C\uDFC0\uD83D\uDCF7☎\uD83D\uDCF1\uD83D\uDCE0\uD83D\uDCBB\uD83C\uDFBF\u26F3\uD83C\uDFBE\u26BE\uD83C\uDFC4\uD83D\uDD31\uD83C\uDFE2\uD83D\uDD11\uD83C\uDFB7\uD83C\uDFBA\uD83C\uDF74\uD83C\uDF78\uD83C\uDF70\uD83D\uDCEB\uD83D\uDCEE\uD83D\uDCE8\uD83D\uDCF2\uD83D\uDCA1\uD83C\uDF81\uD83D\uDD0D\uD83D\uDD28\u2728\uD83D\uDCBA\uD83C\uDF54\u26F2\u26FA♨\uD83C\uDFA1\uD83C\uDFAB\uD83D\uDCBF\uD83D\uDCC0\uD83D\uDCFB\uD83D\uDCFC\uD83D\uDCFA〽\uD83C\uDC04\uD83C\uDFAF\uD83C\uDFC1\uD83C\uDFB0\uD83D\uDC0E\uD83D\uDEA4\uD83D\uDC89\uD83D\uDEC0\uD83D\uDEBD\uD83D\uDCE2\uD83D\uDCE3\uD83C\uDF8C\uD83D\uDD12\uD83D\uDD13\uD83C\uDF06\uD83C\uDF73\uD83D\uDCD6\uD83D\uDC81\uD83D\uDCDD\uD83C\uDFA7\uD83C\uDF76\uD83C\uDF7B㊗\uD83D\uDEAC\uD83D\uDC8A\uD83C\uDF88\uD83C\uDF89✂\uD83C\uDF80㊙\uD83D\uDCBD\uD83D\uDCE3\uD83C\uDFAC\uD83D\uDD14\uD83C\uDFB6\uD83C\uDF75\uD83C\uDF5E\uD83C\uDF66\uD83C\uDF5F\uD83C\uDF61\uD83C\uDF58\uD83C\uDF5A\uD83C\uDF5D\uD83C\uDF5C\uD83C\uDF5B\uD83C\uDF59\uD83C\uDF62\uD83C\uDF63\uD83C\uDF4E\uD83C\uDF4A\uD83C\uDF53\uD83C\uDF49\uD83C\uDF45\uD83C\uDF46\uD83C\uDF71\uD83C\uDF72\uD83C\uDFC8\uD83C\uDFB1\uD83C\uDFCA\uD83C\uDF8D\uD83C\uDF8E\uD83C\uDF93\uD83C\uDF92\uD83C\uDF8F\uD83C\uDF67\uD83C\uDF87\uD83C\uDF90\uD83C\uDF83\uD83C\uDFA8\uD83C\uDFA9\uD83D\uDE84\uD83D\uDEB2\uD83D\uDE80\uD83D\uDE97\u26F5\uD83D\uDE83\uD83D\uDE84\uD83C\uDFE0\u26EA️\uD83C\uDFE2\uD83D\uDE89\u26FD\uD83C\uDFE6\uD83D\uDEA5\uD83D\uDE8F\uD83D\uDEBB\uD83C\uDFE3\uD83C\uDFE7\uD83C\uDFE5\uD83C\uDFEA\uD83C\uDFEB\uD83C\uDFE8\uD83D\uDE83\uD83D\uDE95\uD83D\uDEA2\uD83D\uDC88\uD83D\uDE99\uD83D\uDE9A\uD83D\uDE92\uD83D\uDE91\uD83D\uDE93\uD83C\uDFA2⚠\uD83D\uDC92\uD83D\uDC92\uD83C\uDFEC\uD83C\uDFEF\uD83C\uDFF0\uD83C\uDFED\uD83D\uDDFC\uE50A\uD83C\uDDEF\uD83C\uDDF5\uD83C\uDDFA\uD83C\uDDF8\uD83C\uDDEB\uD83C\uDDF7\uD83C\uDDE9\uD83C\uDDEA\uD83C\uDDEE\uD83C\uDDF9\uD83C\uDDEC\uD83C\uDDE7\uD83C\uDDEA\uD83C\uDDF8\uD83C\uDDF7\uD83C\uDDFA\uD83C\uDDE8\uD83C\uDDF3\uD83C\uDDF0\uD83C\uDDF7\uD83D\uDDFD\u2B55\u274C\u2753\u2757❤\uD83D\uDD50\uD83D\uDD51\uD83D\uDD52\uD83D\uDD53\uD83D\uDD54\uD83D\uDD55\uD83D\uDD56\uD83D\uDD57\uD83D\uDD58\uD83D\uDD59\uD83D\uDD5A\uD83D\uDD5B\uD83C\uDD9A\uD83D\uDEA7\uD83D\uDEB9\uD83D\uDEBA\uD83D\uDEBC\uD83D\uDCB1\uD83D\uDCB9 \uD83C\uDD7F\uD83C\uDFE7\uD83C\uDE01\uD83D\uDC9F✴✳\uD83D\uDD1E\uD83D\uDEAD\uD83D\uDD30\u267F\uD83D\uDCF6♥♦♠♣#⃣\u27BF\uD83C\uDD95\uD83C\uDD99\uD83C\uDD92\uD83C\uDE36\uD83C\uDE1A\uD83C\uDE37\uD83C\uDE38\uD83D\uDD34◼◻1⃣2⃣3⃣4⃣5⃣6⃣7⃣8⃣9⃣0⃣\uD83C\uDE50\uD83C\uDE39\uD83C\uDE02\uD83C\uDD94\uD83C\uDE35\uD83C\uDE33\uD83C\uDE2F\uD83C\uDE3A⬆⬇➡⬅↗↖↘↙▶◀\u23E9\u23EA\uD83D\uDD2F♈♉♊♋♌♍♎♏♐♑♒♓\u26CE\uD83D\uDD1D\uD83C\uDD97©®\uD83D\uDCF3\uD83D\uDCF4⚠\uD83D\uDEBE\u2754\u2755\uD83C\uDFA6\uD83C\uDD70\uD83C\uDD71\uD83C\uDD8E\uD83C\uDD7E\uD83D\uDC63™";
    private TextView tv_data;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tv_data = (TextView) findViewById(R.id.tv_data);
        tv_data.setText(emojiString);

        setTitle(getString(R.string.app_name) + "-" + "System");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        // system emoji
        if (id == R.id.action_settings) {
            tv_data.setText(emojiString);
            setTitle(getString(R.string.app_name) + "-" + "System");
            return true;
        }
        // parse common emoji
        else if (id == R.id.action_1) {
            spannableEmoticonFilter(tv_data, emojiString);
            setTitle(getString(R.string.app_name) + "-" + "Common");
            return true;
        }
        // parse all emoji
        else if (id == R.id.action_2) {
            unzipEmoji();
            spannableEmoticonFilterFromFile(tv_data, emojiString);
            setTitle(getString(R.string.app_name) + "-" + "All");
            return true;
        }
        // github
        else if (id == R.id.action_3) {
            Uri uri = Uri.parse("http://github.com/w446108264/AndroidEmoji");
            Intent it = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(it);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static void spannableEmoticonFilterFromFile(TextView tv_content, String content) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(content);

        Spannable spannable = EmojiDisplayFromFIle.spannableFilter(tv_content.getContext(),
                spannableStringBuilder,
                content,
                getFontHeight(tv_content)
                , null);
        tv_content.setText(spannable);
    }

    public static void spannableEmoticonFilter(TextView tv_content, String content) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(content);

        Spannable spannable = EmojiDisplay.spannableFilter(tv_content.getContext(),
                spannableStringBuilder,
                content,
                getFontHeight(tv_content));
        tv_content.setText(spannable);
    }

    public static int getFontHeight(TextView textView) {
        Paint paint = new Paint();
        paint.setTextSize(textView.getTextSize());
        Paint.FontMetrics fm = paint.getFontMetrics();
        return (int) Math.ceil(fm.bottom - fm.top);
    }

    public void unzipEmoji() {
        String filePath = FileUtils.getFolderPath();
        File dest = new File(filePath);
        if (dest.exists()) {
            return;
        }
        try {
            FileUtils.unzip(getAssets().open("emoji.zip"), filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
