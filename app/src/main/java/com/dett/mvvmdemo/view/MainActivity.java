package com.dett.mvvmdemo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dett.dettmvvm.mvvm.BaseDownloadFileModel;
import com.dett.dettmvvm.mvvm.ResponseData;
import com.dett.dettmvvm.mvvm.SimpleObserver;
import com.dett.dettmvvm.mvvm.SimpleValueCallback;
import com.dett.dettmvvm.mvvm.ValueCallback;
import com.dett.dettmvvm.utils.GsonHelper;
import com.dett.dettmvvm.utils.LogUtils;
import com.dett.mvvmdemo.R;
import com.dett.mvvmdemo.bean.GetResponse;
import com.dett.mvvmdemo.viewmodel.DownloadModel;
import com.dett.mvvmdemo.viewmodel.SwipeModel;

import java.io.File;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        int viewId = view.getId();

        if (viewId == R.id.btn_send_bean_request) {
            loadData();
        } else if (viewId == R.id.btn_post_bean_request) {
            // 由于没有找到合适的demo接口，没有添加测试用例，只需更换下接口即可
        } else if (viewId == R.id.btn_post_upload_request) {
            // 由于没有找到合适的demo接口，没有添加测试用例，只需更换下接口即可
        } else if (viewId == R.id.btn_post_download_request) {
            testDownload();
        }
    }


    private void loadData() {
        // mvvm 加载方式
        final SwipeModel swipeViewModel = ViewModelProviders.of(this).get(SwipeModel.class);

        // 1。监听数据变化
        swipeViewModel.getBanners("android").observe(this, new SimpleObserver<List<GetResponse>>() {

            @Override
            public void onSuccess(Object request, List<GetResponse> data) {
                LogUtils.d(data);
                showToast(GsonHelper.toJson(data));
            }

            @Override
            public void onFailure(String tipMsg) {
                showToast(tipMsg);
            }
        });
    }

    public void testDownload(){
        String url = "http://www.wanandroid.com/blogimgs/e8faab6b-ecb1-4bc2-af96-f7e5039032b3.apk";
        File file = new File(getCacheDir(), "ddddd.apk");
        Button button = findViewById(R.id.btn_post_download_request);

        new DownloadModel(new SimpleValueCallback<File>() {
            @Override
            public void onSuccess(File response) {
                LogUtils.d(response.getAbsolutePath());
                button.setText(response.getAbsolutePath());
            }

            @Override
            public void onFail(String msg) {
                showToast(msg);
            }

            @Override
            public void onProgressChange(int percent) {
                button.setText("进度："+percent);
            }
        }).download(url, file);
    }

    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}