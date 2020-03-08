package cn.wyedward.exception;

/**
 * 自定义一个异常类
 */
public class UserNotExistException extends RuntimeException{

    private static final long serialVersionUID = -245029667937744171L;
    private String id;

    public UserNotExistException(String id) {
        super("user not exist");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
