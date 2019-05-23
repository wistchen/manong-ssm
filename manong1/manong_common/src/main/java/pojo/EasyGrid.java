package pojo;

import java.util.List;

/**
 * @author APPLE
 * @author 2019-05-10 下午4:36
 * @description 商品展示
 */
public class EasyGrid {

    private int total;
    private List<?> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
