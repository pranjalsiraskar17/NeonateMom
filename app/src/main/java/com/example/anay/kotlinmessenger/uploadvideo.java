package com.example.anay.kotlinmessenger;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
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

public class uploadvideo extends AppCompatActivity{
    private static final int PICK_VIDEO_REQUEST = 3;
    private VideoView vv;
    private Uri viduri;
    private MediaController mc;
    private StorageReference mStorageRef;
    private String videoname;
    private EditText editText;
    String str;
    private DatabaseReference dref;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploadvideo);
        editText=(EditText)findViewById(R.id.txt);
        vv=findViewById(R.id.video);
        mStorageRef = FirebaseStorage.getInstance().getReference("uploads").child("videos");
        dref= FirebaseDatabase.getInstance().getReference("Uploaded_Video");
        vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                        mc=new MediaController(uploadvideo.this);
                        vv.setMediaController(mc);
                        mc.setAnchorView(vv);
                    }
                });
            }
        });

        vv.start();
         str=editText.getText().toString();

    }
    public void Uploadvideo(View view) {
        Intent i=new Intent();
        i.setType("video/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(i,"Select a Video"),PICK_VIDEO_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==PICK_VIDEO_REQUEST && resultCode==RESULT_OK && data!=null){
            viduri=data.getData();
            vv.setVideoURI(viduri);
            videoname=getfile(viduri);


        }
    }

    public void VideoToServer(View view) {
      /*  mStorageRef.child(videoname).putFile(viduri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // Get a URL to the uploaded content
                        Task<Uri> downloadUrl = taskSnapshot.getMetadata().getReference().getDownloadUrl();

                        Toast.makeText(getApplicationContext(),downloadUrl.toString(),Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                        // ...
                        Toast.makeText(uploadvideo.this,exception.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
*/         progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Uploading...");
        progressDialog.show();

        final StorageReference riversRef = mStorageRef.child(videoname)  ;
        UploadTask uploadTask = riversRef.putFile(viduri);

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
                    Toast.makeText(getApplicationContext() ,editText.getText().toString().trim(),Toast.LENGTH_SHORT).show();
                    upload upload=new upload(editText.getText().toString().trim(),string);
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
                Toast.makeText(getApplicationContext() ,"File Uploaded",Toast.LENGTH_SHORT).show();

                 progressDialog.setMessage(((int) progress) + "% Uploaded");
            }
        });
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

    public void Retrieve(View view) {
        Intent intent=new Intent(uploadvideo.this,VideoRetrieve.class);
        startActivity(intent);
    }
}