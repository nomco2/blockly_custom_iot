package iot_coding_edu.blockly_custom;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.blockly.android.AbstractBlocklyActivity;
import com.google.blockly.android.codegen.CodeGenerationRequest;
import com.google.blockly.model.DefaultBlocks;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AbstractBlocklyActivity {
    private static final String TAG = "test";
    private static final String My_coding_toolbox_1 = "default/My_coding_toolbox_1.xml";

    private static final List<String> JAVASCRIPT_GENERATORS = Arrays.asList(
            // Custom block generators go here. Default blocks are already included.
            // TODO(#99): Include Javascript defaults when other languages are supported.
            "my_coding_algorithm/my_coding_algorithm.js"
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private static final List<String> BLOCK_DEFINITIONS = DefaultBlocks.getAllBlockDefinitions();


    @NonNull
    @Override
    protected List<String> getBlockDefinitionsJsonPaths() {

//        BLOCK_DEFINITIONS.add(set_locale_language());
        return BLOCK_DEFINITIONS;
    }


    private final Handler mHandler = new Handler();
    private final CodeGenerationRequest.CodeGeneratorCallback mCodeGeneratorCallback =
            new CodeGenerationRequest.CodeGeneratorCallback() {
                @Override
                public void onFinishCodeGeneration(final String generatedCode) {
                    // Sample callback.
                    Log.i(TAG, "generatedCode:\n" + generatedCode);
                    Toast.makeText(getApplicationContext(), generatedCode, Toast.LENGTH_SHORT).show();

//                    One_circle_code_bolcks mOne_circle_code_bolcks = new One_circle_code_bolcks(generatedCode);




                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
//                            String encoded = "Turtle.execute("
//                                    + JavascriptUtil.makeJsString(generatedCode) + ")";
//                            mTurtleWebview.loadUrl("javascript:" + encoded);
//                            Toast.makeText(getApplicationContext(),generatedCode.toString(), Toast.LENGTH_LONG).show();

                            //텔넷 데이터 보내기
//                            Toast.makeText(getApplicationContext(), generatedCode.toString(), Toast.LENGTH_LONG).show();

//                            NetworkThread thread = new NetworkThread(generatedCode.toString());
//                            thread.start();
//                            thread.interrupt();
                        }
                    });
                }
            };

    @NonNull
    @Override
    protected CodeGenerationRequest.CodeGeneratorCallback getCodeGenerationCallback() {


        return mCodeGeneratorCallback;

    }

    @NonNull
    @Override
    protected String getToolboxContentsXmlPath() {
        // Replace with a toolbox that includes application specific blocks.
        return My_coding_toolbox_1;
    }

    protected List<String> getGeneratorsJsPaths() {
        return JAVASCRIPT_GENERATORS;
    }

}
