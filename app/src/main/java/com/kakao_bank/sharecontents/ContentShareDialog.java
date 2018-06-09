package com.kakao_bank.sharecontents;

import android.app.DialogFragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kakao_bank.sharecontents.databinding.ShareContentDialogBinding;


public class ContentShareDialog extends DialogFragment implements ContentShareContract.View {
    private ContentShareContract.Presenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ContentSharePresenter(getActivity());
        presenter.attach(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ShareContentDialogBinding binding = DataBindingUtil.inflate(inflater, R.layout.share_content_dialog, container, false);
        binding.setHandler(new Handler());
        return binding.getRoot();
    }

    public class Handler {
        public void kakaoTalkShareButtonClicked() {
            presenter.onKakaoShare();
        }

        public void faceBookShareButtonClicked() {

        }

        public void instargramShareButtonClicked() {

        }

        public void tweeterShareButtonClicked() {

        }

        public void urlCopyShareButtonClicked() {

        }

        public void etcShareButtonClicked() {

        }
    }
}
