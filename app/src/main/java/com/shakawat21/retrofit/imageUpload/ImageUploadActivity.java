package com.shakawat21.retrofit.imageUpload;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.shakawat21.retrofit.AllInterface;
import com.shakawat21.retrofit.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImageUploadActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;

    private Button captureImage, selectImage;
    private ImageView imageView;

    private static final int CAPTURE_REQUEST_CODE = 0;
    private static final int SELECT_REQUEST_CODE = 1;

    private AllInterface allInterface;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_upload);

        captureImage = findViewById(R.id.capture_image);
        selectImage = findViewById(R.id.select_image);
        imageView = findViewById(R.id.Image_view);

        progressDialog= new ProgressDialog(ImageUploadActivity.this);
        progressDialog.setMessage("Image Upload.....");

        captureImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CheckPermission()) {
                    Intent capture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(capture, CAPTURE_REQUEST_CODE);
                }
            }
        });

        selectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CheckPermission()) {
                    Intent select = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(select, SELECT_REQUEST_CODE);
                }
            }
        });


        allInterface= ImageRetrofit.getServices();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case CAPTURE_REQUEST_CODE: {
                if (resultCode == RESULT_OK) {
                    Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                    imageView.setImageBitmap(bitmap);
                    progressDialog.show();
                    ImageUpload(bitmap);
                }
            }
            break;

            case SELECT_REQUEST_CODE: {
                if (resultCode == RESULT_OK) {

                    try {
                        Uri imageURI = data.getData();
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageURI);
                        imageView.setImageBitmap(bitmap);
                        progressDialog.show();
                        ImageUpload(bitmap);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            break;
        }
    }

    //upload in server
    private void ImageUpload(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream= new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        String image = android.util.Base64.encodeToString(byteArrayOutputStream.toByteArray(), Base64.DEFAULT);
        String name = String.valueOf(Calendar.getInstance().getTimeInMillis());

        Call<ImageModel> call= allInterface.imageUpload(name, image);
        call.enqueue(new Callback<ImageModel>() {
            @Override
            public void onResponse(Call<ImageModel> call, Response<ImageModel> response) {
                if (response.isSuccessful()){
                    Toast.makeText(ImageUploadActivity.this, ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
                else {
                    Toast.makeText(ImageUploadActivity.this, "Response Failed", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ImageModel> call, Throwable t) {
                Toast.makeText(ImageUploadActivity.this, "Upload Failed", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }

    public boolean CheckPermission() {
        if (ContextCompat.checkSelfPermission(ImageUploadActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(ImageUploadActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(ImageUploadActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(ImageUploadActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) ||
                    ActivityCompat.shouldShowRequestPermissionRationale(ImageUploadActivity.this, Manifest.permission.CAMERA) ||
                    ActivityCompat.shouldShowRequestPermissionRationale(ImageUploadActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                new AlertDialog.Builder(ImageUploadActivity.this)
                        .setTitle("Permission")
                        .setMessage("Please accept the permissions")
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Prompt the user once explanation has been shown
                                ActivityCompat.requestPermissions(ImageUploadActivity.this,
                                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                        MY_PERMISSIONS_REQUEST_LOCATION);

                                startActivity(new Intent(ImageUploadActivity.this, ImageUploadActivity.class));
                                ImageUploadActivity.this.overridePendingTransition(0, 0);
                            }
                        })
                        .create()
                        .show();
            } else {
                ActivityCompat.requestPermissions(ImageUploadActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }
}