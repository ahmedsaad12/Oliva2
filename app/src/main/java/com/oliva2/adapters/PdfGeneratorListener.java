package com.oliva2.adapters;


import com.oliva2.models.FailureResponse;
import com.oliva2.models.SuccessResponse;

interface PdfGeneratorContract {
    void onSuccess(SuccessResponse response);

    void showLog(String log);

    void onStartPDFGeneration();

    void onFinishPDFGeneration();

    void onFailure(FailureResponse failureResponse);
}

public abstract class PdfGeneratorListener implements PdfGeneratorContract {
    @Override
    public void showLog(String log) {

    }

    @Override
    public void onSuccess(SuccessResponse response) {

    }

    @Override
    public void onFailure(FailureResponse failureResponse) {

    }
}
