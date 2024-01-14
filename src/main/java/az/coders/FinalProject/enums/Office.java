package az.coders.FinalProject.enums;

public enum Office {
    HEAD_OFFICE("Head Office"),
    BRANCH_OFFICE("Branch Office"),
    REGIONAL_OFFICE("Regional Office"),
    HOME_OFFICE("Home Office");

    private final String displayName;

    Office(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

