package com.werdpressed.partisan.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class BlankFragment extends Fragment implements View.OnClickListener{

    private View rootView;
    private EditText editText;
    private Button button;

    private OnFragmentInteractionListener mListener;

    public static BlankFragment newInstance() {
        return new BlankFragment();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_blank, container, false);
        editText = (EditText) rootView.findViewById(R.id.fragment_editText);
        button = (Button) rootView.findViewById(R.id.fragment_button);
        button.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void onButtonPressed(String message) {
        if (mListener != null) {
            mListener.onFragmentInteraction(message);
        }
    }

    @Override
    public void onClick(View v) {
        String message = editText.getText().toString();

        if (message.trim().equals("")) {
            Toast.makeText(getActivity(), "ERROR: Please enter some text", Toast.LENGTH_SHORT).show();
        } else {
            onButtonPressed(message);
        }
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String message);
    }

}
