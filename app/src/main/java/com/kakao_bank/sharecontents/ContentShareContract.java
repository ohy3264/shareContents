package com.kakao_bank.sharecontents;


public interface ContentShareContract {
    interface View {

    }

    interface Presenter {
        void attach(View view);

        void detach();

        void onKakaoShare();

        void onFaceBookShare();

        void onTwitterShare();
    }
}
