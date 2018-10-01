package wsh.version1;

/**
 * 测试自定义Map
 *
 * @author weishihuai
 * @date 2018/9/27 21:30
 */
public class TestCustomMap {

    public static void main(String[] args) {

        CustomMap customMap = new CustomMap();
        /***********************************put(key,value)*************************************/
        customMap.put("aaa", "zhangsan");
        customMap.put("bbb", "lisi1");
        customMap.put("bbb", "lisi2");
        customMap.put("ccc", "wangwu");

        /*******************************get(key)***********************************************/
        //zhangsan
        System.out.println(customMap.get("aaa"));

        /************************************size()********************************************/
        //3
        System.out.println(customMap.size());

        /**********************************get(key)********************************************/
        //lisi2
        System.out.println(customMap.get("bbb"));

        /*************************************containsKey(key)*********************************/
        //true
        System.out.println(customMap.containsKey("aaa"));
        //false
        System.out.println(customMap.containsKey("123"));

        /************************************containsValue(value)******************************/
        //true
        System.out.println(customMap.containsValue("zhangsan"));
        //false
        System.out.println(customMap.containsValue("123"));

        /************************************isEmpty()*****************************************/
        //false
        System.out.println(customMap.isEmpty());


    }


}
