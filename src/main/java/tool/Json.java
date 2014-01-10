package tool;

import com.google.common.collect.ImmutableMap;


/**
 * Ajax 返回状态
 * Author: chen
 * DateTime: 1/8/14 12:03 PM
 */
public class Json {

    public static ImmutableMap success( String info ) {
        return ImmutableMap.of("status","1","info",info);
    }

    public static ImmutableMap success() {
        return Json.success("success");
    }

    public static ImmutableMap fail( String info ) {
        return ImmutableMap.of("status","0","info",info);
    }

    public static ImmutableMap fail() {
        return Json.fail("fail");
    }

}
