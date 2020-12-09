package com.example.intent_ex_application;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.provider.ContactsContract;
import android.provider.MediaStore;

import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dialPhone(View view) {
        //EditText editText = (EditText) findViewById(R.id.phone_number_edit);
        //dialPhoneNumber(editText.getText().toString());
        //capturePhoto();
        //captureVideo();
        //selectContact();
        //insertContact("아무개","uuuuuu79@naver.com");
        //Uri locat = Uri.parse("geo:37.560529, 126.986554");
        //showMap(locat);
        //searchWeb("android");
        openWebPage("https://naver.com");

    }

    // 전화걸기
    public void dialPhoneNumber (String phoneNumber){
        // 암시적 인텐트인 ACTION_DIAL을 설정
        Intent intent = new Intent(Intent.ACTION_DIAL);
        // URI 형태의 전화번호를 데이터로 설정
        intent.setData(Uri.parse("tel:" + phoneNumber));
        // 이러한 Intent를 처리할 수 있는 Activity를 찾는다면 액티비티를 시작
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    // 사진 찍기 모드로 사진 앱 시작
    static final int REQUEST_CAPTURE_PHOTO = 2;

    public void capturePhoto () {
        Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_CAPTURE_PHOTO);
        }
    }

    // 동영상 촬영 모드로 사진 앱 시작
    static final int REQUEST_CAPTURE_VIDEO = 3;

    public void captureVideo () {
        Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_CAPTURE_VIDEO);
        }
    }


    // 연락처 선택
    static final int REQUEST_SELECT_CONTACT = 4;
    public void selectContact () {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_SELECT_CONTACT);
        }
    }


    // 연락처 보기
    public void viewContact (Uri contactUri){
        Intent intent = new Intent(Intent.ACTION_VIEW, contactUri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    // 연락처 편집
    public void editContact (Uri contactUri, String email){
        Intent intent = new Intent(Intent.ACTION_EDIT);
        intent.setData(contactUri);
        intent.putExtra(ContactsContract.Intents.Insert.EMAIL, email);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    // 연락처 추가
    public void insertContact (String name, String email){
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        intent.putExtra(ContactsContract.Intents.Insert.NAME, name);
        intent.putExtra(ContactsContract.Intents.Insert.EMAIL, email);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    // 지도 보기
    public void showMap(Uri geoLocation){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }



    // 웹 검색
    public void searchWeb (String query){
        Intent intent = new Intent(Intent.ACTION_SEARCH);
        intent.putExtra(SearchManager.QUERY, query);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    // URL 열기
    public void openWebPage (String url){
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


}