package pojo;

/**
 * 商品分类列表返回给前端的实体类
 *
 * @author APPLE
 * @author 2019-4-25 上午10:17
 */
public class EasyUITree {
    private int id;
    private String text;
    private String state;
//    删除增加的
    private String attributes;

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
