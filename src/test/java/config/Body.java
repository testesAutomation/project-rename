package config;

public enum Body {


   DOCUMENTANDREQUESTERVALID("{\n" +
           "    \"document\": \"11200901487\",\n" +
           "    \"requester\": \"62173620000180\"\n" +
           "}"),

    USERBLOCKED("{\n" +
            "    \"document\": \"04489753519\",\n" +
            "    \"requester\": \"62173620000180\"\n" +
            "}"),

    DOCUMENTINVALID("{\n" +
            "    \"document\": \"00000000000\",\n" +
            "    \"requester\": \"62173620000180\"\n" +
            "}"),

    REQUESTERINVALID("{\n" +
            "    \"document\": \"11200901487\",\n" +
            "    \"requester\": \"000000000000\"\n" +
            "}"),

    OBITO("{\n" +
            "    \"document\": \"11200901487\",\n" +
            "    \"requester\": \"62173620000180\"\n" +
            "}");




    private String body;


    Body(String body) {
        this.body = body;

    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return body;
    }
}
