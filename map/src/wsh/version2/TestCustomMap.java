package wsh.version2;

/**
 * 测试自定义Map
 *
 * @author weishihuai
 * @date 2018/10/01 16:30
 */
public class TestCustomMap {

    public static void main(String[] args) {
        CustomMap customMap = new CustomMap();
        customMap.put("name", "zhangsan");
        customMap.put("name", "lisi");
        //lisi
        System.out.println(customMap.get("name"));
        //1
        System.out.println(customMap.size());

    }


}
