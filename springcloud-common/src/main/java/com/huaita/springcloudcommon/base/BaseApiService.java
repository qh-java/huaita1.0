package com.huaita.springcloudcommon.base;

import com.huaita.springcloudcommon.constant.ResponseBase;

public class BaseApiService {

    public ResponseBase setResultError(Integer code, String msg) {
        return setResult(code, msg, null);
    }

    public ResponseBase setResultError(String msg) {
        return setResult(500, msg, null);
    }

    public ResponseBase setResultSuccess(Object object) {
        return setResult(200, "处理成功", object);
    }

    public ResponseBase setResultSuccess() {
        return setResult(200, "处理成功", null);
    }


    public ResponseBase setResultSuccess(String msg) {
        return setResult(200, msg, null);
    }

    public ResponseBase setResult(Integer code, String msg, Object object) {
        return new ResponseBase(code, msg, object);
    }
}
