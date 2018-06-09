package com.kakao_bank.sharecontents;

import android.app.DialogFragment;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kakao_bank.sharecontents.databinding.ShareContentDialogBinding;

import java.io.File;
import java.util.List;


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
            presenter.onFaceBookShare();
        }

        public void instargramShareButtonClicked() {
            String mediaPath = "";
            Intent instagramIntent = new Intent(Intent.ACTION_SEND);
            instagramIntent.setType("image/*");
            File media = new File(mediaPath);
            Uri uri = Uri.fromFile(media);
            instagramIntent.putExtra(Intent.EXTRA_STREAM, uri);
            instagramIntent.setPackage("com.instagram.android");

            PackageManager packManager = getActivity().getPackageManager();
            List<ResolveInfo> resolvedInfoList = packManager.queryIntentActivities(instagramIntent, PackageManager.MATCH_DEFAULT_ONLY);

            boolean resolved = false;
            for (ResolveInfo resolveInfo : resolvedInfoList) {
                if (resolveInfo.activityInfo.packageName.startsWith("com.instagram.android")) {
                    instagramIntent.setClassName(
                            resolveInfo.activityInfo.packageName,
                            resolveInfo.activityInfo.name);
                    resolved = true;
                    break;
                }
            }
            if (resolved) {
                startActivity(instagramIntent);
            } else {
                Toast.makeText(getActivity(), "Instagram App is not installed", Toast.LENGTH_LONG).show();
            }
        }

        public void tweeterShareButtonClicked() {

        }

        public void urlCopyShareButtonClicked() {

        }

        public void etcShareButtonClicked() {

        }
    }
}
