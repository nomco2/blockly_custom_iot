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
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;

public class MainActivity extends AbstractBlocklyActivity {
    private static final String TAG = "test";
    private static final String My_coding_toolbox_1 = "default/My_coding_toolbox_1.xml";

    private static final List<String> JAVASCRIPT_GENERATORS = Arrays.asList(
            // Custom block generators go here. Default blocks are already included.
            // TODO(#99): Include Javascript defaults when other languages are supported.
            "default/my_coding_algorithm.js"
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
    }

//    private static final List<String> BLOCK_DEFINITIONS = DefaultBlocks.getAllBlockDefinitions();
    private static List<String> BLOCK_DEFINITIONS;



    @NonNull
    @Override
    protected List<String> getBlockDefinitionsJsonPaths() {

        BLOCK_DEFINITIONS = Collections.unmodifiableList(Arrays.asList(
                DefaultBlocks.COLOR_BLOCKS_PATH,
                DefaultBlocks.LIST_BLOCKS_PATH,
                DefaultBlocks.LOGIC_BLOCKS_PATH,
                DefaultBlocks.LOOP_BLOCKS_PATH,
                DefaultBlocks.MATH_BLOCKS_PATH,
                DefaultBlocks.PROCEDURE_BLOCKS_PATH,
                DefaultBlocks.TEXT_BLOCKS_PATH,
                DefaultBlocks.VARIABLE_BLOCKS_PATH,
                "default/my_custom_blocks.json"
        ));
        return BLOCK_DEFINITIONS;
    }

    //언어별 설정을 위하여 DefaultBlocks.java에 있던 VARIABLE_BLOCKS_PATH String을 빼고 여기서 따로 추가해줌
    private String set_locale_language(){

        Locale systemLocale = getApplicationContext().getResources().getConfiguration().locale;
        String strDisplayCountry = systemLocale.getDisplayCountry(); // 대한민국
        String strCountry = systemLocale.getCountry(); // KR
        String strLanguage = systemLocale.getLanguage(); // ko

        String VARIABLE_BLOCKS_PATH;
        if(strLanguage == "ko"){
            VARIABLE_BLOCKS_PATH = "default/my_custom_blocks.json";

        }else{
            VARIABLE_BLOCKS_PATH = "default/my_custom_blocks.json";
        }
        return VARIABLE_BLOCKS_PATH;


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
//        return My_coding_toolbox_1;
        return DefaultBlocks.TOOLBOX_PATH;
    }

    protected List<String> getGeneratorsJsPaths() {
        return JAVASCRIPT_GENERATORS;
    }

}
