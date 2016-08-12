package com.yutai.exuetang.view.activity.exuetang;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;
import com.yutai.exuetang.R;
import com.yutai.exuetang.utils.CityDialog;
import com.yutai.exuetang.utils.MyPopupWindow;
import com.yutai.exuetang.utils.RequestManager;
import com.yutai.exuetang.utils.ToastUtils;
import com.yutai.exuetang.view.application.MyApplication;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);
        ButterKnife.bind(this);
        initWordsStyle();
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
//                popMenus.showAtLocation(MyInfoActivity.this.findViewById(R.id.change_head),
//                        Gravity.BOTTOM, 0, 0);
    }
    //为弹出窗口实现监听类
    private View.OnClickListener itemsOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            popMenus.dismiss();
            switch (v.getId()) {
                case R.id.btn_take_photo:
                    //拍照上传
                    ToastUtils.showToast(MyInfoActivity.this, "点击了拍照");
                    //takeCamera();
                    break;
                case R.id.btn_pick_photo:
                    //从相册获取
                    ToastUtils.showToast(MyInfoActivity.this, "点击相册");
                    //takePhoto();
                    break;
                default:
                    break;
            }
        }
    };
    private void showUpdateUserAddress() {

    }

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
                            request.add("child_id", 1);
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
                            request.add("child_id", 1);
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
                request.add("child_id", 1);
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
                            request.add("child_id", 1);
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
                            request.add("child_id", 1);
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
                request.add("child_id", 1);
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
                request.add("child_id", 1);
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
                            request.add("user_id", 1);
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
