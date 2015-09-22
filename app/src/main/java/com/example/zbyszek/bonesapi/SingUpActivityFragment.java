package com.example.zbyszek.bonesapi;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Pattern;

/**
 * A placeholder fragment containing a simple view.
 */
public class SingUpActivityFragment extends Fragment implements View.OnClickListener {

    private Button mSignUpButton;
    private EditText mNicknameEditText;
    private EditText mEmailEditText;
    private EditText mPasswordEditText;

    public SingUpActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sing_up, container, false);

        mSignUpButton = (Button) rootView.findViewById(R.id.sing_up_btn);
        mNicknameEditText = (EditText) rootView.findViewById(R.id.nickname_et);
        mEmailEditText = (EditText) rootView.findViewById(R.id.email_et);
        mPasswordEditText = (EditText) rootView.findViewById(R.id.password_et);

        return rootView;

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mSignUpButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sing_up_btn:
                trySingUp();
                break;

        }
    }

    private void trySingUp() {
        String nickname = mNicknameEditText.getText().toString();
        String email = mEmailEditText.getText().toString();
        String password = mPasswordEditText.getText().toString();

        if (TextUtils.isEmpty(nickname)){
            mNicknameEditText.setError("Nieprawidłowa nazwa");
        }

        if (TextUtils.isEmpty(password)){
            mPasswordEditText.setError("Nieprawidłowa nazwa");
        }

        if (TextUtils.isEmpty(email)){
            mEmailEditText.setError("Nieprawidłowa nazwa");
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            mEmailEditText.setError("Nieprawidłowy adres @");
        }
    }
}
