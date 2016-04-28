package cn.jely.cd.domain;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "ActionResult")
public class ActionJsonResult {
    private boolean operate;
    private ActionJsonResult.MessageType messageType;
    private String message;
    private DetailMessage detail;
    private Object resultObj;

    public ActionJsonResult() {
    }

    public ActionJsonResult(boolean operate, ActionJsonResult.MessageType messageType, String message) {
        this.operate = operate;
        this.messageType = messageType;
        this.message = message;
    }

    public ActionJsonResult(boolean operate, String message, Object resultObj) {
        if(operate) {
            this.messageType = ActionJsonResult.MessageType.INFO;
        } else {
            this.messageType = ActionJsonResult.MessageType.ERROR;
        }

        this.operate = operate;
        this.message = message;
        this.resultObj = resultObj;
    }

    public static ActionJsonResult successResult() {
        return new ActionJsonResult(true,"",null);
    }

    public static ActionJsonResult successResult(Object result) {
        return new ActionJsonResult(true,"",result);
    }

    public static ActionJsonResult fail(Throwable throwable) {
        ActionJsonResult result = new ActionJsonResult(false, MessageType.ERROR, throwable.getMessage());
        StackTraceElement[] stackTrace = throwable.getStackTrace();
        int length = 5;
        if (stackTrace.length < length) {
            length = stackTrace.length;
        }
        List<String> expDetails = new ArrayList<String>();
        for (int i = 0; i < length; i++) {
            expDetails.add(stackTrace[i].toString());
        }
        result.detail = new DetailMessage(throwable.getClass().getSimpleName(), expDetails);
        return result;
    }

    public boolean getOperate() {
        return this.operate;
    }

    public void setOperate(boolean operate) {
        this.operate = operate;
    }

    public ActionJsonResult.MessageType getMessageType() {
        return this.messageType;
    }

    public void setMessageType(ActionJsonResult.MessageType messageType) {
        this.messageType = messageType;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResultObj() {
        return this.resultObj;
    }

    public void setResultObj(Object resultObj) {
        this.resultObj = resultObj;
    }

    public DetailMessage getDetail() {
        return detail;
    }

    public static enum MessageType {
        INFO,
        WARN,
        ERROR,
        INTERRUPT;

        private MessageType() {
        }
    }
    protected static class DetailMessage {
        private String title;
        private List<String> desc = new ArrayList<String>();

        public DetailMessage() {
        }

        public DetailMessage(String name, List<String> desc) {
            this.title = name;
            this.desc.addAll(desc);
        }

        public String getTitle() {
            return title;
        }

        public List<String> getDesc() {
            return desc;
        }
    }
}
