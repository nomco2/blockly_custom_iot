package iot_coding_edu.blockly_custom;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.blockly.android.AbstractBlocklyActivity;
import com.google.blockly.android.codegen.CodeGenerationRequest;
import com.google.blockly.model.DefaultBlocks;

import java.util.List;

public class MainActivity extends AbstractBlocklyActivity {

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

    @NonNull
    @Override
    protected CodeGenerationRequest.CodeGeneratorCallback getCodeGenerationCallback() {
        // Uses the same callback for every generation call.
        return mCodeGeneratorCallback;
    }



}
