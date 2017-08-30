package com.liujiaohan.sell.utils;

import com.liujiaohan.sell.VO.ResultVO;

import java.util.List;

public class ResultVOUtil {
    public static ResultVO success(Object o){
        ResultVO resultVO=new ResultVO();
        resultVO.setMessage("成功");
        resultVO.setCode(0);
        resultVO.setData(o);
        return resultVO;
    }

    public static ResultVO success(){
        return success(null);
    }

    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(code);
        resultVO.setMessage("失败");
        return resultVO;
    }
}
