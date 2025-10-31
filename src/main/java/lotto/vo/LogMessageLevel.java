package lotto.vo;

public enum LogMessageLevel {
    ERROR("[ERROR] "),
    WARN("[WARN] "),
    INFO("[INFO] "),
    DEBUG("[DEBUG] "),
    TRACE("[TRACE] ");

    private String level;

    LogMessageLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }
}