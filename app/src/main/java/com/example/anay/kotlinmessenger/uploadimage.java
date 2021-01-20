package com.example.anay.kotlinmessenger;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;;
import android.widget.*;
import com.google.android.gms.tasks.*;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

public class uploadimage extends AppCompatActivity implements View.OnClickListener {
    private static final int PICK_IMAGE_REQUEST =234 ;
    private ImageView imageView;
    private Button b1,b2,b3;
    private Uri filepath;
    private StorageReference sref;
    private EditText textView;
    private DatabaseReference dref;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploadimage);

        sref = FirebaseStorage.getInstance().getReference();
        dref= FirebaseDatabase.getInstance().getReference("Uploaded_Image");
        imageView = (ImageView)findViewById(R.id.imageview);
        b1 = (Button)findViewById(R.id.choose);
        b1.setOnClickListener(this);
        b2 = (Button)findViewById(R.id.upload);
        b2.setOnClickListener(this);
        b3 = (Button)findViewById(R.id.view);
        b3.setOnClickListener(this);

        textView=findViewById(R.id.txt);
    }
    private void chooser(){
        Intent intent = new Intent();
        intent.setType("image/*");

        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select an image"),PICK_IMAGE_REQUEST);
    }
    private void  upload(){
        if(filepath != null) {
            final ProgressDialog progressDialog=new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();
            String file  = getfile(filepath);
            final StorageReference riversRef = sref.child("Imagesuplaod").child(file)  ;
            UploadTask uploadTask = riversRef.putFile(filepath);

            Task<Uri> urlTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                @Override
                public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                    if (!task.isSuccessful()) {
                        throw task.getException();
                    }

                    // Continue with the task to get the download URL

                    return riversRef.getDownloadUrl();
                }
             }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {
                    if (task.isSuccessful()) {
                        Uri downloadUri = task.getResult();
                        String string=downloadUri.toString();
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext() ,"File uploaded..",Toast.LENGTH_SHORT).show();
                        upload upload=new upload(textView.getText().toString().trim(),string);
                        String uploadId =dref.push().getKey();
                        dref.child(uploadId).setValue(upload);
                    } else {
                        // Handle failures
                        // ...
                    }
                }
            });
            uploadTask.addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                    double progress =(100.0*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                    progressDialog.setMessage(((int) progress) + "% Uploaded");
                }
            });
        }
        else{

            Toast.makeText(context,"fucked up", Toast.LENGTH_SHORT).show();

        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==PICK_IMAGE_REQUEST&&resultCode == RESULT_OK&&data!=null&&data.getData()!=null)
        {
            filepath=data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),filepath);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void onClick(View v) {
        if(v==b1){
            chooser();
        }
        else if(v==b2)
        {
           upload();
        }
        else if (v == b3)
        {
            Intent intent = new Intent(uploadimage.this ,ImageRetrieve.class );
            startActivity(intent);


        }
    }

  public String getfile(Uri uri){
        String result = null;
        if(uri.getScheme().equals("content")){
            Cursor cursor = getContentResolver().query(uri,null,null,null,null);
            try {
                if(cursor!=null&&cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                }
            }
            finally {
                cursor.close();

            }

        }
      if (result==null)
      {
          result = uri.getPath();
          int cut = result.lastIndexOf('/');
          if (cut != -1)
          {

              result = result.substring(cut+1);

          }

      }
      return  result;
  }

}