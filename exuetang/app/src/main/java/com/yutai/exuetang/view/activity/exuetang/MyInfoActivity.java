package com.yutai.exuetang.view.activity.exuetang;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.upyun.library.common.Params;
import com.upyun.library.common.UploadManager;
import com.upyun.library.listener.SignatureListener;
import com.upyun.library.listener.UpCompleteListener;
import com.upyun.library.listener.UpProgressListener;
import com.upyun.library.utils.UpYunUtils;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;
import com.yutai.exuetang.R;
import com.yutai.exuetang.model.beans.exuetang.Child;
import com.yutai.exuetang.model.beans.exuetang.GsonUserInfo;
import com.yutai.exuetang.model.beans.exuetang.User;
import com.yutai.exuetang.utils.CityDialog;
import com.yutai.exuetang.utils.ImageFileUtils;
import com.yutai.exuetang.utils.MyPopupWindow;
import com.yutai.exuetang.utils.RequestManager;
import com.yutai.exuetang.utils.ToastUtils;
import com.yutai.exuetang.view.application.MyApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import rx.Observable;
import rx.functions.Action1;

public class MyInfoActivity extends AppCompatActivity {

    public static final int UPDATE_USER_NICKNAME_WHAT = 1;
    public static final int UPDATE_CHILD_SEX_WHAT = 2;
    public static final int UPDATE_CHILD_BIRTHDAY_WHAT = 3;
    public static final int UPDATE_CHILD_AREA_WHAT = 4;
    public static final int UPDATE_USER_SCHOOl_LCLASS_WHAT = 5;
    public static final int UPDATE_USER_TRAINPLAN_WHAT = 6;
    public static final int UPDATE_USER_HOBBY_WHAT = 7;
    public static final int UPDATE_USER_DREAM_WHAT = 8;
    public static final int GET_USERINFO_WHAT = 9;
    public static final int UPDATE_USER_ADDRESS_WHAT = 10;
    public static final int UPDATE_USER_PHOTO_WHAT = 11;

    @Bind(R.id.my_info_back_image)
    ImageView mMyInfoBackImage;
    @Bind(R.id.my_info_user_photo)
    TextView mMyInfoUserPhoto;
    @Bind(R.id.my_info_user_photo_image)
    ImageView mMyInfoUserPhotoImage;
    @Bind(R.id.my_info_user_photo_layout)
    RelativeLayout mMyInfoUserPhotoLayout;
    @Bind(R.id.my_info_nickname)
    TextView mMyInfoNickname;
    @Bind(R.id.my_info_nickname_tv)
    TextView mMyInfoNicknameTv;
    @Bind(R.id.my_info_nickname_layout)
    RelativeLayout mMyInfoNicknameLayout;
    @Bind(R.id.my_info_phone)
    TextView mMyInfoPhone;
    @Bind(R.id.my_info_phone_tv)
    TextView mMyInfoPhoneTv;
    @Bind(R.id.my_info_phone_layout)
    RelativeLayout mMyInfoPhoneLayout;
    @Bind(R.id.my_info_sex)
    TextView mMyInfoSex;
    @Bind(R.id.my_info_sex_image)
    ImageView mMyInfoSexImage;
    @Bind(R.id.my_info_sex_layout)
    RelativeLayout mMyInfoSexLayout;
    @Bind(R.id.my_info_birthday)
    TextView mMyInfoBirthday;
    @Bind(R.id.my_info_birthday_tv)
    TextView mMyInfoBirthdayTv;
    @Bind(R.id.my_info_birthday_layout)
    RelativeLayout mMyInfoBirthdayLayout;
    @Bind(R.id.my_info_school_class)
    TextView mMyInfoSchoolClass;
    @Bind(R.id.my_info_school_class_tv)
    TextView mMyInfoSchoolClassTv;
    @Bind(R.id.my_info_school_class_layout)
    RelativeLayout mMyInfoSchoolClassLayout;
    @Bind(R.id.my_info_dream)
    TextView mMyInfoDream;
    @Bind(R.id.my_info_dream_tv)
    TextView mMyInfoDreamTv;
    @Bind(R.id.my_info_dream_layout)
    RelativeLayout mMyInfoDreamLayout;
    @Bind(R.id.my_info_hobby)
    TextView mMyInfoHobby;
    @Bind(R.id.my_info_hobby_tv)
    TextView mMyInfoHobbyTv;
    @Bind(R.id.my_info_hobby_layout)
    RelativeLayout mMyInfoHobbyLayout;
    @Bind(R.id.my_info_trainplan)
    TextView mMyInfoTrainplan;
    @Bind(R.id.my_info_trainplan_tv)
    TextView mMyInfoTrainplanTv;
    @Bind(R.id.my_info_trainplan_layout)
    RelativeLayout mMyInfoTrainplanLayout;
    @Bind(R.id.my_info_area)
    TextView mMyInfoArea;
    @Bind(R.id.my_info_area_tv)
    TextView mMyInfoAreaTv;
    @Bind(R.id.my_info_area_layout)
    RelativeLayout mMyInfoAreaLayout;
    @Bind(R.id.my_info_address)
    TextView mMyInfoAddress;
    @Bind(R.id.my_info_address_tv)
    TextView mMyInfoAddressTv;
    @Bind(R.id.my_info_address_layout)
    RelativeLayout mMyInfoAddressLayout;
    //自定义的省市区选择dialog
    private CityDialog dialog;
    //服务端的URL
    public String mPath = MyApplication.url + "/exuetangservlet";
    //Request<String> request;
    //自定义一个dialog
    // private WaitDialog mDialog;
    Observable<String> myObservable;
    Action1<String> onNextAction1;
    private MyPopupWindow popMenus;
    private File mCurrentPhotoFile;//获取当前相册选中的图片文件
    public static String KEY = "3AtEDO2ByBUZ7qGVTLPUnuKLOWM="; // 表单api验证密钥
    public static String SPACE = "easygo";
    String savePath = "/yutai/user/";
    String photopath = "http://easygo.b0.upaiyun.com";
    private String mphotopath;//相册图片的地址
    Uri imageURI1;//拍照选取
    //    Uri selectedImage;//相册选取
    /*private String mloadpath;//图片上传到服务器的地址*/
    User user;
    Child child;
    private int user_id = 1;//偏好设置中获取
   // private int child_id = 1;//要从偏好设置中取到
    private final static int CROP_PIC = 0x125;
    public static final int TAKE_PHOTO = 1;//相册
    public static final int TAKE_CAMERA = 0;//相机

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info_scroll);
        ButterKnife.bind(this);
        initWordsStyle();
//        初始化数据
        initData();
    }

    private void initWordsStyle() {
        mMyInfoUserPhoto.setTypeface(MyApplication.sTypeface);
        mMyInfoNickname.setTypeface(MyApplication.sTypeface);
        mMyInfoNicknameTv.setTypeface(MyApplication.sTypeface);
        mMyInfoPhone.setTypeface(MyApplication.sTypeface);
        mMyInfoPhoneTv.setTypeface(MyApplication.sTypeface);
        mMyInfoSex.setTypeface(MyApplication.sTypeface);
        mMyInfoBirthday.setTypeface(MyApplication.sTypeface);
        mMyInfoBirthdayTv.setTypeface(MyApplication.sTypeface);
        mMyInfoSchoolClass.setTypeface(MyApplication.sTypeface);
        mMyInfoSchoolClassTv.setTypeface(MyApplication.sTypeface);
        mMyInfoDream.setTypeface(MyApplication.sTypeface);
        mMyInfoDreamTv.setTypeface(MyApplication.sTypeface);
        mMyInfoHobby.setTypeface(MyApplication.sTypeface);
        mMyInfoHobbyTv.setTypeface(MyApplication.sTypeface);
        mMyInfoTrainplan.setTypeface(MyApplication.sTypeface);
        mMyInfoTrainplanTv.setTypeface(MyApplication.sTypeface);
        mMyInfoArea.setTypeface(MyApplication.sTypeface);
        mMyInfoAreaTv.setTypeface(MyApplication.sTypeface);
        mMyInfoAddress.setTypeface(MyApplication.sTypeface);
        mMyInfoAddressTv.setTypeface(MyApplication.sTypeface);
    }

    private void initData() {
        Request<String> request = NoHttp.createStringRequest(mPath, RequestMethod.POST);
        // 添加请求参数
        request.add("methods", "getMyInfo");
        request.add("user_id", user_id);
        RequestManager.getInstance().add(GET_USERINFO_WHAT, request, onResponseListener);
    }

    @OnClick({R.id.my_info_back_image, R.id.my_info_user_photo_layout, R.id.my_info_nickname_layout, R.id.my_info_phone_layout, R.id.my_info_sex_layout, R.id.my_info_birthday_layout, R.id.my_info_school_class_layout, R.id.my_info_dream_layout, R.id.my_info_hobby_layout, R.id.my_info_trainplan_layout, R.id.my_info_area_layout, R.id.my_info_address_layout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.my_info_back_image:
                finish();
                break;
            case R.id.my_info_user_photo_layout:
                ToastUtils.showToast(this, "修改头像");
                showUpdateUserPhoto();
                break;
            case R.id.my_info_nickname_layout:
                ToastUtils.showToast(this, "修改昵称");
                showUpdateUserNickname();
                break;
            case R.id.my_info_phone_layout:
                ToastUtils.showToast(this, "修改手机号");
                Intent intent = new Intent();
                intent.setClass(this, MyIntoPhoneActivity.class);
                startActivity(intent);
//                showUpdateUserPhone();
                break;
            case R.id.my_info_sex_layout:
                ToastUtils.showToast(this, "修改性别");
                showUpdateUserSex();
                break;
            case R.id.my_info_birthday_layout:
                ToastUtils.showToast(this, "修改生日");
                showUpdateBirthday();
                break;
            case R.id.my_info_school_class_layout:
                ToastUtils.showToast(this, "修改学校及班级");
                showUpdateUserSchoolClass();
                break;
            case R.id.my_info_dream_layout:
                ToastUtils.showToast(this, "修改我的梦想");
                showUpdateUserDream();
                break;
            case R.id.my_info_hobby_layout:
                ToastUtils.showToast(this, "修改我的特长");
                showUpdateUserHobby();
                break;
            case R.id.my_info_trainplan_layout:
                ToastUtils.showToast(this, "修改我的培训计划");
                showUpdateUserTrainplan();
                break;
            case R.id.my_info_area_layout:
                ToastUtils.showToast(this, "修改地区");
                showUpdateArea();
                break;
            case R.id.my_info_address_layout:
                ToastUtils.showToast(this, "修改邮寄地址");
                showUpdateUserAddress();
                break;
        }
    }

    private void showUpdateUserPhoto() {
        popMenus = new MyPopupWindow(MyInfoActivity.this, itemsOnClick);
        popMenus.showAtLocation(MyInfoActivity.this.findViewById(R.id.my_info_user_photo_layout),
                Gravity.BOTTOM, 0, 0);
    }

    //为弹出窗口实现监听类
    private View.OnClickListener itemsOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            popMenus.dismiss();
            switch (v.getId()) {
                case R.id.btn_take_photo:
                    //拍照上传
                    ToastUtils.showToast(MyInfoActivity.this, "点击了拍照");
                    takeCamera();
                    break;
                case R.id.btn_pick_photo:
                    //从相册获取
                    ToastUtils.showToast(MyInfoActivity.this, "点击相册");
                    takePhoto();
                    break;
                default:
                    break;
            }
        }
    };

    //相册上传
    private void takePhoto() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        /*// TODO Auto-generated method stub
        intent.setAction(Intent.ACTION_PICK);//Pick an item from the data
        intent.setType("image*//*");//从所有图片中进行选择
        intent.putExtra("crop", "true");//设置为裁切
        intent.putExtra("aspectX", 1);//裁切的宽比例
        intent.putExtra("aspectY", 1);//裁切的高比例
        intent.putExtra("outputX", 600);//裁切的宽度
        intent.putExtra("outputY", 600);//裁切的高度
        intent.putExtra("scale", true);//支持缩放
        intent.putExtra("return-data", false);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageURI1);//将裁切的结果输出到指定的Uri
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());//裁切成的图片的格式
        intent.putExtra("noFaceDetection", true); // no face detection
       */
        startActivityForResult(intent, TAKE_PHOTO);
    }

    //拍照
    private void takeCamera() {
        String photoDir = Environment.getExternalStorageDirectory().getPath() + "/devstore_image";
        try {
            File photo_dir = new File(photoDir);
            if (!photo_dir.exists()) {
                photo_dir.mkdirs();
            }
            String fileName = System.currentTimeMillis() + ".jpg";
            mCurrentPhotoFile = new File(photo_dir, fileName);
            // 开启相机
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE, null);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(mCurrentPhotoFile));
            startActivityForResult(intent, TAKE_CAMERA);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private File uri2File(Uri uri) {
        File file = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor actualimagecursor = this.managedQuery(uri, proj, null,
                null, null);
        int actual_image_column_index = actualimagecursor
                .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        actualimagecursor.moveToFirst();
        String img_path = actualimagecursor
                .getString(actual_image_column_index);
        file = new File(img_path);
        return file;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case TAKE_PHOTO:
                //相册选取
                if (data != null) {
                    imageURI1 = data.getData();
                    if (imageURI1 != null) {
//                        goUpLoad(ImageFileUtils.scal(imageURI1));
                        goUpLoad(uri2File(imageURI1));
                       /* if (resultCode==RESULT_OK) {
                            try {
                                Bitmap bitmap= BitmapFactory.decodeStream(getContentResolver().
                                        openInputStream(imageURI1));//将imageUri对象的图片加载到内存
                                //mMyInfoUserPhotoImage.setImageBitmap(bitmap);
                               Log.e("ss","wqwq"+resultCode);
                               // goUpLoad(uri2File(imageURI1));
                            } catch (FileNotFoundException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }*/
                    }
                }

                break;
            case TAKE_CAMERA:
//                拍照
                imageURI1 = Uri.fromFile(mCurrentPhotoFile);
                goUpLoad(ImageFileUtils.scal(imageURI1));
//                goUpLoad(mCurrentPhotoFile);
               /* if (resultCode==RESULT_OK) {
                    cropImageUri(imageURI1, 600, 600, CROP_PIC);
                }*/
                break;
            case CROP_PIC:
                if (resultCode == RESULT_OK) {
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().
                                openInputStream(imageURI1));//将imageUri对象的图片加载到内存
                        mMyInfoUserPhotoImage.setImageBitmap(bitmap);
                        //goUpLoad(bitmap);
                    } catch (FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                break;
        }
    }

    /**
     * 裁剪指定uri对应的照片
     *
     * @param imageUri：uri对应的照片
     * @param outputX：裁剪宽
     * @param outputY：裁剪高
     * @param requestCode：请求码
     */
    private void cropImageUri(Uri imageUri, int outputX, int outputY, int requestCode) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(imageUri, "image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", outputX);
        intent.putExtra("outputY", outputY);
        intent.putExtra("scale", true);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        intent.putExtra("return-data", false);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        intent.putExtra("noFaceDetection", true); // no face detection
        startActivityForResult(intent, TAKE_PHOTO);
    }

    private void goUpLoad(File file) {
        final Map<String, Object> paramsMap = new HashMap<>();
        //上传空间
        paramsMap.put(Params.BUCKET, SPACE);
        //保存路径，任选其中一个
        long currentTimeMillis = System.currentTimeMillis();
        final String saveName = currentTimeMillis+"";
//                + file.getName().substring(file.getName().lastIndexOf("."));
        paramsMap.put(Params.SAVE_KEY, savePath + saveName);
//        paramsMap.put(Params.PATH, savePath);
        //可选参数（详情见api文档介绍）
        paramsMap.put(Params.RETURN_URL, "httpbin.org/post");
        //进度回调，可为空
        UpProgressListener progressListener = new UpProgressListener() {
            @Override
            public void onRequestProgress(final long bytesWrite, final long contentLength) {
                Log.e("Upload", (100 * bytesWrite) / contentLength + "%");
                ToastUtils.showToast(MyInfoActivity.this,"正在上传"+(100 * bytesWrite) / contentLength+"%");
            }
        };

        //结束回调，不可为空
        UpCompleteListener completeListener = new UpCompleteListener() {
            @Override
            public void onComplete(boolean isSuccess, String result) {
                Log.e("Upload", isSuccess + ":" + result);
                if (isSuccess) {
                    Glide.with(MyInfoActivity.this).load(photopath + savePath + saveName)
                            .bitmapTransform(new CropCircleTransformation(MyInfoActivity.this))
                            .error(R.mipmap.portrait_2)
                            .into(mMyInfoUserPhotoImage);
                    ToastUtils.showToast(MyInfoActivity.this, "修改成功");
//                    .setImageResource();
                    Request<String> request = NoHttp.createStringRequest(mPath, RequestMethod.POST);
                    // 添加请求参数
                    request.add("methods", "updateChildAddress");
                    request.add("user_id", user_id);
                    request.add("child_address", photopath + savePath + saveName);
                    RequestManager.getInstance().add(UPDATE_USER_PHOTO_WHAT, request, onResponseListener);

                }
            }
        };

        SignatureListener signatureListener = new SignatureListener() {
            @Override
            public String getSignature(String raw) {
                return UpYunUtils.md5(raw + KEY);
            }
        };

        UploadManager.getInstance().formUpload(file, paramsMap, KEY, completeListener, progressListener);
        UploadManager.getInstance().formUpload(file, paramsMap, signatureListener, completeListener, progressListener);
       /* UploadManager.getInstance().blockUpload(temp, paramsMap, KEY, completeListener, progressListener);
        UploadManager.getInstance().blockUpload(temp, paramsMap, signatureListener, completeListener, progressListener);
*/
    }

    //相册图片上传地址
    private String getPhotoPath(Context context, Uri uri) {
        String[] filePathColumn = {MediaStore.Images.Media.DATA};
        //光标
        Cursor cursor = context.getContentResolver().query(uri, filePathColumn, null, null, null);
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
        String picturePath = cursor.getString(columnIndex);
        mphotopath = picturePath;
        cursor.close();
        return picturePath;
    }

    //修改小孩的通讯地址
    private void showUpdateUserAddress() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.myinfo_dialog_nickname, null);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("请输入你的昵称：");
        builder.setView(view);
        final Dialog dialog = builder.show();
        final EditText contenttext = (EditText) view.findViewById(R.id.my_info_dialog_editview);
        TextView titletextView = (TextView) view.findViewById(R.id.my_info_dialog_title);
        titletextView.setText("通讯地址");
        TextView cancletextView = (TextView) view.findViewById(R.id.my_info_dialog_sex_cancle);
        TextView oktextView = (TextView) view.findViewById(R.id.my_info_dialog_sex_ok);
        contenttext.setHint(mMyInfoAddressTv.getText().toString());
        cancletextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        oktextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (contenttext.getText().toString().length() > 0) {
                    if (contenttext.getText().toString().length() <= 50) {
                        if (!contenttext.getText().toString().equals(mMyInfoAddressTv.getText().toString())) {
                            String child_address = contenttext.getText().toString();
                            Request<String> request = NoHttp.createStringRequest(mPath, RequestMethod.POST);
                            // 添加请求参数
                            request.add("methods", "updateChildAddress");
                            request.add("user_id", user_id);
                            request.add("child_address", child_address);
                            RequestManager.getInstance().add(UPDATE_USER_ADDRESS_WHAT, request, onResponseListener);
                            onNextAction1 = new Action1<String>() {
                                @Override
                                public void call(String s) {
                                    if (s.equals("true")) {
                                        Log.e("call", "true");
                                        mMyInfoAddressTv.setText(contenttext.getText().toString());
                                    } else if (s.equals("false")) {

                                    }
                                }
                            };
                        }
                        dialog.dismiss();
                    } else {
                        ToastUtils.showToast(MyInfoActivity.this, "在50个字以内");
                    }
                } else {
                    ToastUtils.showToast(MyInfoActivity.this, "不能为空");
                }
            }
        });
    }

    //修改培训计划
    private void showUpdateUserTrainplan() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.myinfo_dialog_nickname, null);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("请输入你的昵称：");
        builder.setView(view);
        final Dialog dialog = builder.show();
        final EditText contenttext = (EditText) view.findViewById(R.id.my_info_dialog_editview);
        TextView titletextView = (TextView) view.findViewById(R.id.my_info_dialog_title);
        titletextView.setText("修改培训计划");
        TextView cancletextView = (TextView) view.findViewById(R.id.my_info_dialog_sex_cancle);
        TextView oktextView = (TextView) view.findViewById(R.id.my_info_dialog_sex_ok);
        contenttext.setHint(mMyInfoTrainplanTv.getText().toString());
        cancletextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        oktextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (contenttext.getText().toString().length() > 0) {
                    if (contenttext.getText().toString().length() <= 50) {
                        if (!contenttext.getText().toString().equals(mMyInfoTrainplanTv.getText().toString())) {
                            String child_trainplan = contenttext.getText().toString();
                            Request<String> request = NoHttp.createStringRequest(mPath, RequestMethod.POST);
                            // 添加请求参数
                            request.add("methods", "updateTrainplan");
                            request.add("user_id", user_id);
                            request.add("child_trainplan", child_trainplan);
                            RequestManager.getInstance().add(UPDATE_USER_TRAINPLAN_WHAT, request, onResponseListener);
                            onNextAction1 = new Action1<String>() {
                                @Override
                                public void call(String s) {
                                    if (s.equals("true")) {
                                        Log.e("call", "true");
                                        mMyInfoTrainplanTv.setText(contenttext.getText().toString());
                                    } else if (s.equals("false")) {

                                    }
                                }
                            };
                        }
                        dialog.dismiss();
                    } else {
                        ToastUtils.showToast(MyInfoActivity.this, "在50个字以内");
                    }
                } else {
                    ToastUtils.showToast(MyInfoActivity.this, "不能为空");
                }
            }
        });
    }

    //修改小孩的特长
    private void showUpdateUserHobby() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.myinfo_dialog_nickname, null);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("请输入你的昵称：");
        builder.setView(view);
        final Dialog dialog = builder.show();
        final EditText contenttext = (EditText) view.findViewById(R.id.my_info_dialog_editview);
        TextView titletextView = (TextView) view.findViewById(R.id.my_info_dialog_title);
        titletextView.setText("修改特长");
        TextView cancletextView = (TextView) view.findViewById(R.id.my_info_dialog_sex_cancle);
        TextView oktextView = (TextView) view.findViewById(R.id.my_info_dialog_sex_ok);
        contenttext.setHint(mMyInfoHobbyTv.getText().toString());
        cancletextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        oktextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (contenttext.getText().toString().length() > 0) {
                    if (contenttext.getText().toString().length() <= 10) {
                        if (!contenttext.getText().toString().equals(mMyInfoHobbyTv.getText().toString())) {
                            String child_hobby = contenttext.getText().toString();
                            Request<String> request = NoHttp.createStringRequest(mPath, RequestMethod.POST);
                            // 添加请求参数
                            request.add("methods", "updateChildHobby");
                            request.add("user_id", user_id);
                            request.add("child_hobby", child_hobby);
                            RequestManager.getInstance().add(UPDATE_USER_HOBBY_WHAT, request, onResponseListener);
                            onNextAction1 = new Action1<String>() {
                                @Override
                                public void call(String s) {
                                    if (s.equals("true")) {
                                        Log.e("call", "true");
                                        mMyInfoHobbyTv.setText(contenttext.getText().toString());
                                    } else if (s.equals("false")) {

                                    }
                                }
                            };
                        }
                        dialog.dismiss();
                    } else {
                        ToastUtils.showToast(MyInfoActivity.this, "在10个字以内");
                    }
                } else {
                    ToastUtils.showToast(MyInfoActivity.this, "不能为空");
                }
            }
        });
    }

    //修改小孩的地区
    private void showUpdateArea() {
        CityDialog.InputListener listener = new CityDialog.InputListener() {
            @Override
            public void getText(final String str) {
                String temp[] = str.split("-");
                String child_home_province = temp[0];
                String child_home_city = temp[1];
                String child_home_county = temp[2];
                Request<String> request = NoHttp.createStringRequest(mPath, RequestMethod.POST);
                // 添加请求参数
                request.add("methods", "updateChildArea");
                request.add("user_id", user_id);
                request.add("child_home_province", child_home_province);
                request.add("child_home_city", child_home_city);
                request.add("child_home_county", child_home_county);
                RequestManager.getInstance().add(UPDATE_CHILD_AREA_WHAT, request, onResponseListener);
                onNextAction1 = new Action1<String>() {
                    @Override
                    public void call(String s) {
                        if (s.equals("true")) {
                            Log.e("call", "true");
                            mMyInfoAreaTv.setText(str);
                        } else if (s.equals("false")) {

                        }
                    }
                };

            }
        };
        dialog = new CityDialog(this, listener);
        dialog.setTitle("省-市-区");
        dialog.show();
    }

    //修改小孩的梦想
    private void showUpdateUserDream() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.myinfo_dialog_nickname, null);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("请输入你的昵称：");
        builder.setView(view);
        final Dialog dialog = builder.show();
        final EditText contenttext = (EditText) view.findViewById(R.id.my_info_dialog_editview);
        TextView titletextView = (TextView) view.findViewById(R.id.my_info_dialog_title);
        titletextView.setText("修改梦想");
        TextView cancletextView = (TextView) view.findViewById(R.id.my_info_dialog_sex_cancle);
        TextView oktextView = (TextView) view.findViewById(R.id.my_info_dialog_sex_ok);
        contenttext.setHint(mMyInfoDreamTv.getText().toString());
        cancletextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        oktextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (contenttext.getText().toString().length() > 0) {
                    if (contenttext.getText().toString().length() <= 25) {
                        if (!contenttext.getText().toString().equals(mMyInfoDreamTv.getText().toString())) {
                            String child_dream = contenttext.getText().toString();
                            Request<String> request = NoHttp.createStringRequest(mPath, RequestMethod.POST);
                            // 添加请求参数
                            request.add("methods", "updateChildDream");
                            request.add("user_id", user_id);
                            request.add("child_dream", child_dream);
                            RequestManager.getInstance().add(UPDATE_USER_DREAM_WHAT, request, onResponseListener);
                            onNextAction1 = new Action1<String>() {
                                @Override
                                public void call(String s) {
                                    if (s.equals("true")) {
                                        Log.e("call", "true");
                                        mMyInfoDreamTv.setText(contenttext.getText().toString());
                                    } else if (s.equals("false")) {

                                    }
                                }
                            };
                        }
                        dialog.dismiss();
                    } else {
                        ToastUtils.showToast(MyInfoActivity.this, "在25个字以内");
                    }
                } else {
                    ToastUtils.showToast(MyInfoActivity.this, "不能为空");
                }
            }
        });
    }

    //修改小孩的学校和班级
    private void showUpdateUserSchoolClass() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.myinfo_dialog_nickname, null);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("请输入你的昵称：");
        builder.setView(view);
        final Dialog dialog = builder.show();
        final EditText contenttext = (EditText) view.findViewById(R.id.my_info_dialog_editview);
        TextView titletextView = (TextView) view.findViewById(R.id.my_info_dialog_title);
        titletextView.setText("修改学校及班级");
        TextView cancletextView = (TextView) view.findViewById(R.id.my_info_dialog_sex_cancle);
        TextView oktextView = (TextView) view.findViewById(R.id.my_info_dialog_sex_ok);
        contenttext.setHint(mMyInfoSchoolClassTv.getText().toString());
        cancletextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        oktextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (contenttext.getText().toString().length() > 0) {
                    if (contenttext.getText().toString().length() < 50) {
                        if (!contenttext.getText().toString().equals(mMyInfoSchoolClassTv.getText().toString())) {
                            String child_school_class_name = contenttext.getText().toString();
                            Request<String> request = NoHttp.createStringRequest(mPath, RequestMethod.POST);
                            // 添加请求参数
                            request.add("methods", "updateChildSchoolClass");
                            request.add("user_id", user_id);
                            request.add("child_school_class_name", child_school_class_name);
                            RequestManager.getInstance().add(UPDATE_USER_SCHOOl_LCLASS_WHAT, request, onResponseListener);
                            onNextAction1 = new Action1<String>() {
                                @Override
                                public void call(String s) {
                                    if (s.equals("true")) {
                                        Log.e("call", "true");
                                        mMyInfoSchoolClassTv.setText(contenttext.getText().toString());
                                    } else if (s.equals("false")) {

                                    }
                                }
                            };
                        }
                        dialog.dismiss();
                    } else {
                        ToastUtils.showToast(MyInfoActivity.this, "在50个字以内");
                    }
                } else {
                    ToastUtils.showToast(MyInfoActivity.this, "不能为空");
                }
            }
        });
    }

    //修改小孩的生日
    private void showUpdateBirthday() {
        int year, monthOfYear, dayOfMonth;
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        monthOfYear = calendar.get(Calendar.MONTH);
        dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        final String child_birthday = year + "年" + (monthOfYear + 1) + "月" + dayOfMonth + "日";
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                Request<String> request = NoHttp.createStringRequest(mPath, RequestMethod.POST);
                // 添加请求参数
                request.add("methods", "updateChildBirthday");
                request.add("user_id", user_id);
                request.add("child_birthday", child_birthday);
                RequestManager.getInstance().add(UPDATE_CHILD_BIRTHDAY_WHAT, request, onResponseListener);
                onNextAction1 = new Action1<String>() {
                    @Override
                    public void call(String s) {
                        if (s.equals("true")) {
                            Log.e("call", "true");
                            mMyInfoBirthdayTv.setText(child_birthday);
                        } else if (s.equals("false")) {

                        }
                    }
                };
//                dialog.dismiss();

            }
        }, year, monthOfYear, dayOfMonth);
//        下面的设置是不能选择超过今天以后的日期
        DatePicker datePicker = datePickerDialog.getDatePicker();
        Date date = new Date();//当前时间
        long time = date.getTime();
        datePicker.setMaxDate(time);
        datePicker.setMaxDate(time);
        datePickerDialog.show();
    }

    //修改小孩的性别
    private void showUpdateUserSex() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.myinfo_dialog_sex, null);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);
        final Dialog dialog = builder.show();
        final RadioGroup msexRadiogroup = (RadioGroup) view.findViewById(R.id.sex_radiogroup);
        TextView cancletextView = (TextView) view.findViewById(R.id.my_info_dialog_sex_cancle);
        TextView oktextView = (TextView) view.findViewById(R.id.my_info_dialog_sex_ok);
        cancletextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        oktextView.setOnClickListener(new View.OnClickListener() {
            String child_sex = null;

            @Override
            public void onClick(View v) {
                if (msexRadiogroup.getCheckedRadioButtonId() == R.id.radio_male) {
                    child_sex = "男";
                }
                if (msexRadiogroup.getCheckedRadioButtonId() == R.id.radio_female) {
                    mMyInfoSexImage.setImageResource(R.mipmap.female);
                    child_sex = "女";
                }
                Request<String> request = NoHttp.createStringRequest(mPath, RequestMethod.POST);
                // 添加请求参数
                request.add("methods", "updateChildSex");
                request.add("user_id", user_id);
                request.add("child_sex", child_sex);
                RequestManager.getInstance().add(UPDATE_CHILD_SEX_WHAT, request, onResponseListener);
                onNextAction1 = new Action1<String>() {
                    @Override
                    public void call(String s) {
                        if (s.equals("true")) {
                            Log.e("call", "true");
                            if (child_sex.equals("男")) {
                                mMyInfoSexImage.setImageResource(R.mipmap.male);
                            } else {
                                mMyInfoSexImage.setImageResource(R.mipmap.female);
                            }
                        } else if (s.equals("false")) {

                        }
                    }
                };
                dialog.dismiss();
            }
        });
    }

    private void showUpdateUserPhone() {
        final EditText text = new EditText(this);
        final String textString = text.getText().toString();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("请输入你的手机号：")
                .setView(text)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (!textString.equals("")) {
                            Pattern p = Pattern.compile("[0-9]*");
                            Matcher m = p.matcher(textString);
                            if (m.matches()) {
                                mMyInfoPhoneTv.setText(textString);
                            } else {
                                ToastUtils.showToast(MyInfoActivity.this, "请输入数字");
                            }
                        } else {
                            ToastUtils.showToast(MyInfoActivity.this, "不能为空");
                        }
                    }
                })
                .setNegativeButton("取消", null);
        builder.create().show();
    }

    //修改用户的昵称
    private void showUpdateUserNickname() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.myinfo_dialog_nickname, null);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("请输入你的昵称：");
        builder.setView(view);
        final Dialog dialog = builder.show();
        final EditText contenttext = (EditText) view.findViewById(R.id.my_info_dialog_editview);
        TextView titletextView = (TextView) view.findViewById(R.id.my_info_dialog_title);
        TextView cancletextView = (TextView) view.findViewById(R.id.my_info_dialog_sex_cancle);
        TextView oktextView = (TextView) view.findViewById(R.id.my_info_dialog_sex_ok);
        contenttext.setHint(mMyInfoNicknameTv.getText().toString());
//        contenttext.setText(mMyInfoNicknameTv.getText().toString());
        cancletextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        oktextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (contenttext.getText().toString().length() > 0) {
                    if (contenttext.getText().toString().length() < 10) {
                        if (!contenttext.getText().toString().equals(mMyInfoNicknameTv.getText().toString())) {
                            String new_nickname = contenttext.getText().toString();
                            Request<String> request = NoHttp.createStringRequest(mPath, RequestMethod.POST);
                            // 添加请求参数
                            request.add("methods", "updateUserNickname");
                            request.add("user_id", user_id);
                            request.add("new_nickname", new_nickname);
                            RequestManager.getInstance().add(UPDATE_USER_NICKNAME_WHAT, request, onResponseListener);
                            onNextAction1 = new Action1<String>() {
                                @Override
                                public void call(String s) {
                                    if (s.equals("true")) {
                                        Log.e("call", "true");
                                        mMyInfoNicknameTv.setText(contenttext.getText().toString());
                                    } else if (s.equals("false")) {

                                    }
                                }
                            };
                        }
                        dialog.dismiss();
                    } else {
                        ToastUtils.showToast(MyInfoActivity.this, "昵称在十个字以内");
                    }
                } else {
                    ToastUtils.showToast(MyInfoActivity.this, "昵称不能为空");
                }
            }
        });
    }

    //    网络请求的结果的处理
    public OnResponseListener<String> onResponseListener = new OnResponseListener<String>() {
        @Override
        public void onStart(int what) {

        }

        @Override
        public void onSucceed(int what, Response<String> response) {
            String result = response.get();// 响应结果
            switch (what) {
                case GET_USERINFO_WHAT:
//                    得到用户信息
                    Gson gson = new Gson();
                    Type type = new TypeToken<GsonUserInfo>() {
                    }.getType();
                    GsonUserInfo gsonUserInfo = gson.fromJson(result, type);
                    if (gsonUserInfo.getCode() == 200) {
                        Log.e("myinfo", gsonUserInfo.toString());
                        user = gsonUserInfo.getUser();
                        child = gsonUserInfo.getChild();
                        initUserdata(user);
                        initChilddata(child);
//                        mMyInfoUserPhotoImage
                    }
                    if (gsonUserInfo.getCode() == 222) {
                        Log.e("myinfo", "nodata");
                        if (gsonUserInfo.getUser() != null) {
                            user = gsonUserInfo.getUser();
                            initUserdata(user);
                        }
                    }
                    break;
                case UPDATE_USER_PHOTO_WHAT:
//                    修改头像
                    if (result.equals("200")) {
                        ToastUtils.showToast(MyInfoActivity.this, "修改成功");
                        myObservable = Observable.just("true");
                        myObservable.subscribe(onNextAction1);
//                        mMyInfoNicknameTv.setText(contenttext.getText().toString());
                    } else if (result.equals("222")) {
                        ToastUtils.showToast(MyInfoActivity.this, "修改头像失败");
                        myObservable = Observable.just("false");
                        myObservable.subscribe(onNextAction1);
                    }
                    break;
                case UPDATE_USER_NICKNAME_WHAT:
//                    修改昵称
                    if (result.equals("200")) {
                        ToastUtils.showToast(MyInfoActivity.this, "修改成功");
                        myObservable = Observable.just("true");
                        myObservable.subscribe(onNextAction1);
//                        mMyInfoNicknameTv.setText(contenttext.getText().toString());
                    } else if (result.equals("222")) {
                        ToastUtils.showToast(MyInfoActivity.this, "修改昵称失败");
                        myObservable = Observable.just("false");
                        myObservable.subscribe(onNextAction1);
                    }
                    break;
                case UPDATE_CHILD_SEX_WHAT:
//                    修改性别
                    if (result.equals("200")) {
                        ToastUtils.showToast(MyInfoActivity.this, "修改成功");
//                        mMyInfoNicknameTv.setText(contenttext.getText().toString());
                        myObservable = Observable.just("true");
                        myObservable.subscribe(onNextAction1);
                    } else if (result.equals("222")) {
                        ToastUtils.showToast(MyInfoActivity.this, "修改性别失败");
                        myObservable = Observable.just("false");
                        myObservable.subscribe(onNextAction1);
                    }
                    break;
                case UPDATE_CHILD_BIRTHDAY_WHAT:
//                    修改生日
                    if (result.equals("200")) {
                        ToastUtils.showToast(MyInfoActivity.this, "修改成功");
//                        mMyInfoNicknameTv.setText(contenttext.getText().toString());
                        myObservable = Observable.just("true");
                        myObservable.subscribe(onNextAction1);
                    } else if (result.equals("222")) {
                        ToastUtils.showToast(MyInfoActivity.this, "修改生日失败");
                        myObservable = Observable.just("false");
                        myObservable.subscribe(onNextAction1);
                    }
                    break;
                case UPDATE_CHILD_AREA_WHAT:
//                    修改地区
                    if (result.equals("200")) {
                        ToastUtils.showToast(MyInfoActivity.this, "修改成功");
//                        mMyInfoNicknameTv.setText(contenttext.getText().toString());
                        myObservable = Observable.just("true");
                        myObservable.subscribe(onNextAction1);
                    } else if (result.equals("222")) {
                        ToastUtils.showToast(MyInfoActivity.this, "修改地区失败");
                        myObservable = Observable.just("false");
                        myObservable.subscribe(onNextAction1);
                    }
                    break;
                case UPDATE_USER_SCHOOl_LCLASS_WHAT:
//                    修改地区
                    if (result.equals("200")) {
                        ToastUtils.showToast(MyInfoActivity.this, "修改成功");
//                        mMyInfoNicknameTv.setText(contenttext.getText().toString());
                        myObservable = Observable.just("true");
                        myObservable.subscribe(onNextAction1);
                    } else if (result.equals("222")) {
                        ToastUtils.showToast(MyInfoActivity.this, "修改学校及班级失败");
                        myObservable = Observable.just("false");
                        myObservable.subscribe(onNextAction1);
                    }
                    break;
                case UPDATE_USER_TRAINPLAN_WHAT:
//                    修改地区
                    if (result.equals("200")) {
                        ToastUtils.showToast(MyInfoActivity.this, "修改成功");
//                        mMyInfoNicknameTv.setText(contenttext.getText().toString());
                        myObservable = Observable.just("true");
                        myObservable.subscribe(onNextAction1);
                    } else if (result.equals("222")) {
                        ToastUtils.showToast(MyInfoActivity.this, "修改培训计划失败");
                        myObservable = Observable.just("false");
                        myObservable.subscribe(onNextAction1);
                    }
                    break;
                case UPDATE_USER_HOBBY_WHAT:
//                    修改地区
                    if (result.equals("200")) {
                        ToastUtils.showToast(MyInfoActivity.this, "修改成功");
//                        mMyInfoNicknameTv.setText(contenttext.getText().toString());
                        myObservable = Observable.just("true");
                        myObservable.subscribe(onNextAction1);
                    } else if (result.equals("222")) {
                        ToastUtils.showToast(MyInfoActivity.this, "修改特长失败");
                        myObservable = Observable.just("false");
                        myObservable.subscribe(onNextAction1);
                    }
                    break;
                case UPDATE_USER_DREAM_WHAT:
//                    修改地区
                    if (result.equals("200")) {
                        ToastUtils.showToast(MyInfoActivity.this, "修改成功");
//                        mMyInfoNicknameTv.setText(contenttext.getText().toString());
                        myObservable = Observable.just("true");
                        myObservable.subscribe(onNextAction1);
                    } else if (result.equals("222")) {
                        ToastUtils.showToast(MyInfoActivity.this, "修改梦想失败");
                        myObservable = Observable.just("false");
                        myObservable.subscribe(onNextAction1);
                    }
                    break;
                case UPDATE_USER_ADDRESS_WHAT:
//                    修改地区
                    if (result.equals("200")) {
                        ToastUtils.showToast(MyInfoActivity.this, "修改成功");
//                        mMyInfoNicknameTv.setText(contenttext.getText().toString());
                        myObservable = Observable.just("true");
                        myObservable.subscribe(onNextAction1);
                    } else if (result.equals("222")) {
                        ToastUtils.showToast(MyInfoActivity.this, "修改地区失败");
                        myObservable = Observable.just("false");
                        myObservable.subscribe(onNextAction1);
                    }
                    break;
            }
        }

        private void initChilddata(Child child) {
            if (child.getChild_birthday() != null) {
                mMyInfoBirthdayTv.setText(child.getChild_birthday());
            }
            if (child.getChild_photo() != null) {
                Glide.with(MyInfoActivity.this).load(child.getChild_photo())
                        .bitmapTransform(new CropCircleTransformation(MyInfoActivity.this))
                        .error(R.mipmap.portrait_2)
                        .into(mMyInfoUserPhotoImage);
            }
            if (child.getChild_sex() != null) {//宝宝性别
                if (child.getChild_sex().equals("男")) {
                    mMyInfoSexImage.setImageResource(R.mipmap.male);
                } else if (child.getChild_sex().equals("女")) {
                    mMyInfoSexImage.setImageResource(R.mipmap.female);
                }
            }
            if (child.getChild_home_province() != null && child.getChild_home_city() != null && child.getChild_home_county() != null) {
                mMyInfoAreaTv.setText(child.getChild_home_province() + "-" + child.getChild_home_city() + "-" + child.getChild_home_county());
            }
            if (child.getChild_home_address() != null) {
                mMyInfoAddressTv.setText(child.getChild_home_address());
            }
            if (child.getChild_dream() != null) {
                mMyInfoDreamTv.setText(child.getChild_dream());
            }
            if (child.getChild_hobby() != null) {
                mMyInfoHobbyTv.setText(child.getChild_hobby());
            }
            if (child.getChild_trainplan() != null) {
                mMyInfoTrainplanTv.setText(child.getChild_trainplan());
            }
            if (child.getChild_school_class_name() != null) {
                mMyInfoSchoolClassTv.setText(child.getChild_school_class_name());
            }
        }

        private void initUserdata(User user) {
            if (user.getUser_newphone() != null) {
                mMyInfoPhoneTv.setText(user.getUser_newphone());
            }
            if (user.getUser_nickname() != null) {
                mMyInfoNicknameTv.setText(user.getUser_nickname());
            }
        }

        @Override
        public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {

        }

        @Override
        public void onFinish(int what) {

        }
    };
}
