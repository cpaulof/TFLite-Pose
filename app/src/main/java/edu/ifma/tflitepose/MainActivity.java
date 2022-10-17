package edu.ifma.tflitepose;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.
import androidx.camera.core.AspectRatio;
import androidx.camera.core.ImageAnalysis;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tflite.client.TfLiteInitializationOptions;
import org.tensorflow.lite.task.gms.vision.TfLiteVision;
import org.tensorflow.lite.task.gms.vision.detector.ObjectDetector;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private final float threshold = 0.5f;
    private final int maxResults = 5;
    private final String modelName = "movenet.tflite";
    private ObjectDetector detector = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ObjectDetector.ObjectDetectorOptions options = ObjectDetector.ObjectDetectorOptions.builder()
                .setScoreThreshold(threshold)
                .setMaxResults(maxResults).build();

        try {
            ObjectDetector detector = ObjectDetector.createFromFileAndOptions(this, modelName, options);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ImageAnalysis.Analyzer imageAnalyzer = new ImageAnalysis.Builder()
                .setTargetAspectRatio(AspectRatio.RATIO_4_3)
                .setTargetRotation(fragment)




//        TfLiteInitializationOptions options = TfLiteInitializationOptions.builder()
//                .setEnableGpuDelegateSupport(true)
//                .build();
//        TfLiteVision.initialize(this, options).addOnSuccessListener(new OnSuccessListener(){
//
//            @Override
//            public void onSuccess(Object o) {
//                o.onInitialized();
//            }
//        })
    }
}