package com.yutai.exuetang.view.activity.audio.twostyle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.upyun.library.common.Params;
import com.upyun.library.common.UploadManager;
import com.upyun.library.listener.SignatureListener;
import com.upyun.library.listener.UpCompleteListener;
import com.upyun.library.listener.UpProgressListener;
import com.upyun.library.utils.UpYunUtils;
import com.yutai.exuetang.R;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public static String KEY = "3AtEDO2ByBUZ7qGVTLPUnuKLOWM="; // 表单api验证密钥
    public static String SPACE = "easygo";
    private ProgressBar uploadProgress;
    private TextView textView;
    String savePath = "/yutai/user/{year}{mon}{day}/{random32}{.suffix}";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        File temp = null;
        try {
            temp = getTempFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setContentView(R.layout.activity_test);
        uploadProgress = (ProgressBar) findViewById(R.id.progressBar);
        textView = (TextView) findViewById(R.id.tv_process);
        final Map<String, Object> paramsMap = new HashMap<>();
        //上传空间
        paramsMap.put(Params.BUCKET, SPACE);
        //保存路径，任选其中一个
        paramsMap.put(Params.SAVE_KEY, savePath);
//        paramsMap.put(Params.PATH, savePath);
        //可选参数（详情见api文档介绍）
        paramsMap.put(Params.RETURN_URL, "httpbin.org/post");
        //进度回调，可为空
        UpProgressListener progressListener = new UpProgressListener() {
            @Override
            public void onRequestProgress(final long bytesWrite, final long contentLength) {
                uploadProgress.setProgress((int) ((100 * bytesWrite) / contentLength));
                textView.setText((100 * bytesWrite) / contentLength + "%");
                Log.e(TAG, (100 * bytesWrite) / contentLength + "%");
            }
        };

        //结束回调，不可为空
        UpCompleteListener completeListener = new UpCompleteListener() {
            @Override
            public void onComplete(boolean isSuccess, String result) {
                textView.setText(isSuccess + ":" + result);
                Log.e(TAG, isSuccess + ":" + result);
            }
        };

        SignatureListener signatureListener = new SignatureListener() {
            @Override
            public String getSignature(String raw) {
                return UpYunUtils.md5(raw + KEY);
            }
        };

        UploadManager.getInstance().formUpload(temp, paramsMap, KEY, completeListener, progressListener);
        UploadManager.getInstance().formUpload(temp, paramsMap, signatureListener, completeListener, progressListener);
       /* UploadManager.getInstance().blockUpload(temp, paramsMap, KEY, completeListener, progressListener);
        UploadManager.getInstance().blockUpload(temp, paramsMap, signatureListener, completeListener, progressListener);
*/
    }
    private File getTempFile() throws IOException {
        File temp = File.createTempFile("upyun", "test");
        /*temp.deleteOnExit();
        OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(temp));
        outputStream.write("just for test !".getBytes());
        outputStream.close();*/
        return temp;
    }
}
