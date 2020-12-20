package com.mizhi.yxd.result;

import lombok.Getter;

/**
 * @Author : yangxudong
 * @Description :   错误码
 * @Date : 下午3:04 2018/5/29
 */
@Getter
public class CodeMsg {
    /**通用模块.*/
    public static final CodeMsg SUCCESS = new CodeMsg(200, "成功");
    public static final CodeMsg SERVER_ERROR = new CodeMsg(500, "服务异常");

    /**用户模块.5001xx*/
    public static final CodeMsg USER_OR_PWD_NOT_RIGHT = new CodeMsg(500100, "用户或密码不正确");
    public static final CodeMsg USER_ALREADY_REGIST = new CodeMsg(500101, "用户已经被注册");

    /**校验模块.6001xx*/
    public static final CodeMsg NAME_IDCARD_NULL = new CodeMsg(600101, "存在姓名或身份证为空");
    public static final CodeMsg SIX_FIFTEEN_NOT_RIGHT = new CodeMsg(600102, "是否6-15周岁字段只能写是或者否");
    public static final CodeMsg IDCARD_NOT_RIGHT = new CodeMsg(600103, "身份证格式有误");
    public static final CodeMsg DISABILITY_NOT_RIGHT = new CodeMsg(600104, "是否残疾生字段只能写是或者否");
    public static final CodeMsg ENJOY_NOT_RIGHT = new CodeMsg(600105, "本学期是否享受米脂资助只能写是或者否");
    public static final CodeMsg IMPORT_VALIDATE_ERROR = new CodeMsg(600106, "导入校验失败");
    public static final CodeMsg IDCARD_EXIST_ERROR = new CodeMsg(600107, "该身份证用户已存在!");
    public static final CodeMsg SUBSIDIZE_EXIST_ERROR = new CodeMsg(600108, "该生已经是被资助学生!");
    public static final CodeMsg DECIMAL_NOT_RIGHT_ERROR = new CodeMsg(600109, "请填写数字!");
    public static final CodeMsg THERE_IS_NO_COUNT_ERROR = new CodeMsg(600110, "没有符合条件的数据");

    private Integer code;
    private String msg;

    private CodeMsg(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private CodeMsg() {
    }

    public CodeMsg setMsg(String msg) {
        this.msg = msg;
        return this;
    }


}
