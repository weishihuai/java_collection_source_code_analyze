package wsh.version2;

/**
 * 自定义Entry
 *
 * @author weishihuai
 * @date 2018/10/01 16:18
 */
public class CustomEntry {
    /**
     * 键
     */
    private Object key;
    /**
     * 值
     */
    private Object value;

    public CustomEntry() {

    }

    public CustomEntry(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
